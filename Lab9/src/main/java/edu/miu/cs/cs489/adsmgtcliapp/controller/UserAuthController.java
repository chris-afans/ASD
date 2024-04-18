package edu.miu.cs.cs489.adsmgtcliapp.controller;

import edu.miu.cs.cs489.adsmgtcliapp.dto.UserAuthRequest;
import edu.miu.cs.cs489.adsmgtcliapp.dto.UserAuthResponse;
import edu.miu.cs.cs489.adsmgtcliapp.service.UsersInterface;
import edu.miu.cs.cs489.adsmgtcliapp.service.util.JWTMgmtUtilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping(value = {"/adsweb/api/v1/public/auth"})
public class UserAuthController {

    private JWTMgmtUtilityService jwtMgmtUtilityService;
    private AuthenticationManager authenticationManager;
    private UsersInterface usersInterface;

    public UserAuthController(JWTMgmtUtilityService jwtMgmtUtilityService,
                              AuthenticationManager authenticationManager,
                              UsersInterface usersInterface) {
        this.jwtMgmtUtilityService = jwtMgmtUtilityService;
        this.authenticationManager = authenticationManager;
        this.usersInterface = usersInterface;
    }

    @PostMapping(value = {"adsweb/api/v1/login"})
    public ResponseEntity<UserAuthResponse> authenticateUser( @RequestBody UserAuthRequest userAuthRequest) throws Exception {
        UserAuthResponse userAuthResponse = null;
        try {
            var username = userAuthRequest.username();
            var password = userAuthRequest.password();
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,
                            password)
            );
            var jwtToken = jwtMgmtUtilityService.generateToken(username);
            var user = usersInterface.getUserByUsername(username);
            if(user != null) {
                userAuthResponse = new UserAuthResponse(jwtToken, user.getFirstName(), user.getLastName());
            }
        } catch (Exception ex) {
            System.out.println("UserAuthException is: " + ex);
            throw ex;
        }
        return ResponseEntity.ok(userAuthResponse);
    }

}
