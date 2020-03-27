package com.codenation.challenge.caesarcrypto.services;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codenation.challenge.caesarcrypto.api.mapper.ChallengeDataMapper;
import com.codenation.challenge.caesarcrypto.constants.CodenationConstants;
import com.codenation.challenge.caesarcrypto.entities.ChallengeData;
import com.codenation.challenge.caesarcrypto.enums.ChallengeDataTypeEnum;
import com.codenation.challenge.caesarcrypto.helpers.OkHttpHelperService;
import com.codenation.challenge.caesarcrypto.repository.ChallengeDataRepository;
import com.codenation.challenge.caesarcrypto.services.vo.ChallengeDataVO;
import com.codenation.challenge.caesarcrypto.services.vo.SendChallengeDataVO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class RequestService {
    private static final String filePath = "/answer.json";

    @Autowired
    private OkHttpHelperService okHttpHelperService;

    @Autowired
    private ChallengeDataRepository challengeDataRepository;

    @Autowired
    private ChallengeDataService challengeDataService;

    public void storeChallengeData(String token) {
        try {
            String data = okHttpHelperService.doGetRequestSync(CodenationConstants.CODENATION_GENERATE_DATA_URL, generateTokenMap(token));

            challengeDataService.store(ChallengeDataMapper
                    .toEntity(buildRequestChallengeData(data)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void buildChallengeData() {
        challengeDataService.buildChallengeData();
    }

    public void sendDataToCodenation(String dataId) {
        ObjectMapper objectMapper = new ObjectMapper();

        String fileURL = System.getProperty("user.dir") + filePath;

        ChallengeData challengeData = challengeDataService.findById(dataId);

        try {
            objectMapper.writeValue(new File(fileURL), SendChallengeDataVO.byEntity(challengeData));
        } catch (IOException e) {
            e.printStackTrace();
        }

        okHttpHelperService.doChallengePostRequestSync(CodenationConstants.CODENATION_SEND_DATA_URL, fileURL, generateTokenMap(challengeData.getToken()));
    }

    private Map<String, String> generateTokenMap(String token) {
        return Map.of("token", token);
    }

    private ChallengeDataVO buildRequestChallengeData(String data) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        return objectMapper.readValue(data, ChallengeDataVO.class)
                .setChallengeDataType(ChallengeDataTypeEnum.RECEIVED)
                .setLastUpdate(LocalDateTime.now());
    }
}
