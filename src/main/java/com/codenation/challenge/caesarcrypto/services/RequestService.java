package com.codenation.challenge.caesarcrypto.services;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codenation.challenge.caesarcrypto.api.mapper.RequestChallengeDataMapper;
import com.codenation.challenge.caesarcrypto.constants.CodenationConstants;
import com.codenation.challenge.caesarcrypto.helpers.OkHttpHelperService;
import com.codenation.challenge.caesarcrypto.repository.RequestChallengeDataRepository;
import com.codenation.challenge.caesarcrypto.services.vo.CodenationRequestChallengeDataVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RequestService {

    @Autowired
    private OkHttpHelperService okHttpHelperService;

    @Autowired
    private RequestChallengeDataRepository requestChallengeDataRepository;

    public void storeRequestChallengeData(String token) {
        try {
            String data = okHttpHelperService.doGetRequestSync(CodenationConstants.CODENATION_GENERATE_DATA_URL, generateTokenMap(token));

            requestChallengeDataRepository.save(RequestChallengeDataMapper
                    .toEntity(buildRequestChallengeData(data)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Map<String, String> generateTokenMap(String token) {
        return Map.of("token", token);
    }

    private CodenationRequestChallengeDataVO buildRequestChallengeData(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(data, CodenationRequestChallengeDataVO.class);
    }
}
