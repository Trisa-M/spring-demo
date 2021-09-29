package com.optum.claimapplication;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClaimService {

    public static int claimCount = 0;
    //creating an object of ArrayList
    private static List<Claim> claims = new ArrayList<>();

    //returns a list of claims
    public List<Claim> findAll() {
        return claims;
    }

    //find individual claim
    public Claim findOne(int num){
        for(Claim claim:claims){
            if(claim.getClaimNumber()==num)
                return claim;
        }
        return null;
    }

    //add claim to the list
    public Claim save(Claim newClaim){
        if(newClaim.getClaimNumber()==null){
            newClaim.setClaimNumber(++claimCount);
        }
        claims.add(newClaim);
        return newClaim;
    }

    static {
        //adding claims to the List
        claims.add(new Claim(1, "Name1", 34, 1578.99));
//        claims.add(new Claim(2, "Name2", 57, 4484.68));
//        claims.add(new Claim(3, "Name3", 68, 7284.57));
//        claims.add(new Claim(4, "Name4", 27, 3839.87));
    }

}
