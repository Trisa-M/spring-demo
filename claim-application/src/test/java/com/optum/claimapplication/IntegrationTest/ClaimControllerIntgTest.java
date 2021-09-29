package com.optum.claimapplication.IntegrationTest;

import com.optum.claimapplication.Claim;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClaimControllerIntgTest {
    
    @Autowired
    TestRestTemplate testRestTemplate;

    @Test
    void createClaim() {

        Claim claim = new Claim(1, "Name1", 34, 1578.99);

        //when
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity("/claims", claim, String.class);
//      System.out.println(responseEntity.getStatusCode());

        //then
        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());

    }
}
