package edu.miu.cs.cs489.lab11;

import edu.miu.cs.cs489.lab11.model.Patient;
import edu.miu.cs.cs489.lab11.repository.PatientRepository;
import edu.miu.cs.cs489.lab11.service.PatientService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.CoreMatchers.*;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    PatientService patientService;



    
    @Test
    public void patientIsFound(){
        Integer id = 1;
        Patient p = patientService.searchPatientById(id);
        assertNotNull(p);
    }

    @Test
    public void patientNotFound(){
        try{
            Integer patientId = 99;
            Patient patient = patientService.searchPatientById(patientId);
        }catch(IllegalArgumentException ex){
            assertEquals("patient not found", ex.getMessage());
        }
    }
}
