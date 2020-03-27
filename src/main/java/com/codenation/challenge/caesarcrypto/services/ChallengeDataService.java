package com.codenation.challenge.caesarcrypto.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codenation.challenge.caesarcrypto.api.mapper.ChallengeDataMapper;
import com.codenation.challenge.caesarcrypto.crypto.EncryptHelper;
import com.codenation.challenge.caesarcrypto.entities.ChallengeData;
import com.codenation.challenge.caesarcrypto.enums.ChallengeDataTypeEnum;
import com.codenation.challenge.caesarcrypto.repository.ChallengeDataRepository;
import com.codenation.challenge.caesarcrypto.services.vo.ChallengeDataVO;

@Service
public class ChallengeDataService {

    @Autowired
    private ChallengeDataRepository challengeDataRepository;

    public void store(ChallengeData challengeData) {
        challengeDataRepository.save(challengeData);
    }

    public void buildChallengeData() {
        store(buildNewChallengeData(findLastOne()));
    }

    public List<ChallengeDataVO> list() {
        return ChallengeDataMapper.toVOList(challengeDataRepository.findAll());
    }

    public ChallengeData findLastOne() {
        return challengeDataRepository.findFirstByOrderByIdDesc();
    }

    public ChallengeData findById(String id) {
        return challengeDataRepository.findById(id).get();
    }

    private ChallengeData buildNewChallengeData(ChallengeData challengeData) {
        String decryptedData = CaesarChallengeHelper.decryptData(challengeData.getNumero_casas(), challengeData.getCifrado());

        return new ChallengeData()
                .setCifrado(challengeData.getCifrado())
                .setDecifrado(decryptedData)
                .setNumero_casas(challengeData.getNumero_casas())
                .setResumo_criptografico(EncryptHelper.toSHA1Encrypt(decryptedData))
                .setToken(challengeData.getToken())
                .setLastUpdate(LocalDateTime.now())
                .setChallengeDataType(ChallengeDataTypeEnum.GENERATED);
    }
}
