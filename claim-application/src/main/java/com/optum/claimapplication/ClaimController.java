package com.optum.claimapplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClaimController {

    @Autowired
    private ClaimService claimService;

    //get all the claim details
    @GetMapping("/claims")
    public List<Claim> getAllClaims(){
        return claimService.findAll();
    }

    //retrieve individual claim details
    @GetMapping("/claims/{id}")
    public Claim getClaim(@PathVariable int id){
        return claimService.findOne(id);
    }

    //method to post a new claim detail
    @PostMapping("/claims")
    public void createClaim(@RequestBody Claim claim){
//        Claim savedClaim
        claimService.save(claim);
    }

}
