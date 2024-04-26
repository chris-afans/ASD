package edu.miu.cs.cs489.adsmgtcliapp.dto;

public record UserAuthResponse(
        String jwtToken,
        String firstName,
        String lastName
) {
}
