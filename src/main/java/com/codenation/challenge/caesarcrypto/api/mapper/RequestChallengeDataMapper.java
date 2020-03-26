package com.codenation.challenge.caesarcrypto.api.mapper;

import org.modelmapper.ModelMapper;

import com.codenation.challenge.caesarcrypto.entities.RequestChallengeData;
import com.codenation.challenge.caesarcrypto.services.vo.CodenationRequestChallengeDataVO;

public class RequestChallengeDataMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private RequestChallengeDataMapper(){};

    public static RequestChallengeData toEntity(CodenationRequestChallengeDataVO codenationRequestChallengeData) {
        return modelMapper.map(codenationRequestChallengeData, RequestChallengeData.class);
    }
}
