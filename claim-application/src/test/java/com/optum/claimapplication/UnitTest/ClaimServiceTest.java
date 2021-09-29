package com.optum.claimapplication.UnitTest;

import com.optum.claimapplication.Claim;
import com.optum.claimapplication.ClaimService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClaimServiceTest {

//    @Autowired
//    ClaimService claimService;

    @Test
    public void findAll() {
        List<Claim> expectedList = new ArrayList<>();
        expectedList.add(new Claim(1,"abc",34,45.78));

        ClaimService claimService = new ClaimService();
        List<Claim> resultList = claimService.findAll();

        assertEquals(expectedList.get(0).getClaimNumber(),resultList.get(0).getClaimNumber());
    }
}
