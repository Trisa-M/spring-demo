package com.optum.claimapplication.UnitTest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.optum.claimapplication.Claim;
import com.optum.claimapplication.ClaimController;
import com.optum.claimapplication.ClaimService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ClaimController.class)
@AutoConfigureMockMvc
public class ClaimControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ClaimService mockClaimService;

    ObjectMapper objectMapper = new ObjectMapper();

    Claim claim = new Claim(1, "Name1", 34, 1578.99);
    String jsonClaim = objectMapper.writeValueAsString(claim);

    public ClaimControllerTest() throws JsonProcessingException {
    }

    @Test
    void getAllClaims() throws Exception {

        //given
        when(mockClaimService.findAll()).thenReturn(Collections.singletonList(claim));

        //expect
        MvcResult result =
                mockMvc.perform(get("/claims")
                .accept(APPLICATION_JSON))
                .andReturn();

        List<String> expected = Arrays.asList(jsonClaim);
        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(String.valueOf(expected), result.getResponse()
                .getContentAsString(), true);
    }

    @Test
    public void getClaim() throws Exception {

        //given
        when(mockClaimService.findOne(Mockito.anyInt())).thenReturn(claim);
//
        //expect
        MvcResult result =
                mockMvc.perform(get("/claims/"+claim.getClaimNumber())
                        .accept(APPLICATION_JSON))
                        .andReturn();

        System.out.println(result.getResponse().getContentAsString());

        JSONAssert.assertEquals(jsonClaim, result.getResponse()
                .getContentAsString(), true);
    }

    @Test
    public void createClaim() throws Exception {
        //given
        when(mockClaimService.save(isA(Claim.class))).thenReturn(null);

        //expect
        mockMvc.perform(post("/claims")
                .content(jsonClaim)
                .contentType(APPLICATION_JSON))
        .andExpect(status().isOk());
    }
}
