package com.codenation.challenge.caesarcrypto.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.codenation.challenge.caesarcrypto.services.RequestService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController("RequestController")
@RequestMapping(RestPath.BASE_PATH + "/requests")
@Api(tags = "Requests")
public class RequestController {

    @Autowired
    private RequestService requestService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/generate-challenge-data")
    @ApiOperation("${v1.challenge.generate.data}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso")
    })
    public void getChallengeData(
            @ApiParam(value = "${v1.challenge.generate.data.token}", required = true) @RequestParam String token) {
        requestService.storeRequestChallengeData(token);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(value = "/build-challenge-data")
    @ApiOperation("${v1.challenge.build.data}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Sucesso")
    })
    public void buildChallengeData(
            @ApiParam(value = "${v1.challenge.generate.data.token}", required = true) @RequestParam String token) {
        requestService.storeRequestChallengeData(token);
    }
}
