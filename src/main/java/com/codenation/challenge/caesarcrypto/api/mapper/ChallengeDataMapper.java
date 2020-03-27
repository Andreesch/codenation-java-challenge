package com.codenation.challenge.caesarcrypto.api.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.codenation.challenge.caesarcrypto.entities.ChallengeData;
import com.codenation.challenge.caesarcrypto.services.vo.ChallengeDataVO;

public class ChallengeDataMapper {
    private static final ModelMapper modelMapper = new ModelMapper();

    private ChallengeDataMapper(){};

    public static ChallengeData toEntity(ChallengeDataVO codenationRequestChallengeData) {
        return modelMapper.map(codenationRequestChallengeData, ChallengeData.class);
    }

    public static ChallengeDataVO toVO(ChallengeData challengeData) {
        return modelMapper.map(challengeData, ChallengeDataVO.class);
    }

    public static List<ChallengeDataVO> toVOList(List<ChallengeData> challengeDataList) {
        return challengeDataList.stream()
                .map(ChallengeDataMapper::toVO)
                .collect(Collectors.toList());
    }
}
