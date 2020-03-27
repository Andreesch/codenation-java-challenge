package com.codenation.challenge.caesarcrypto.services.vo;

import java.time.LocalDateTime;

import com.codenation.challenge.caesarcrypto.enums.ChallengeDataTypeEnum;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ChallengeDataVO {

    private String id;
    private Integer numero_casas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumo_criptografico;
    private LocalDateTime lastUpdate;
    private ChallengeDataTypeEnum challengeDataType;

    public String getId() {
        return id;
    }

    public ChallengeDataVO setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getNumero_casas() {
        return numero_casas;
    }

    public ChallengeDataVO setNumero_casas(Integer numero_casas) {
        this.numero_casas = numero_casas;
        return this;
    }

    public String getToken() {
        return token;
    }

    public ChallengeDataVO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getCifrado() {
        return cifrado;
    }

    public ChallengeDataVO setCifrado(String cifrado) {
        this.cifrado = cifrado;
        return this;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public ChallengeDataVO setDecifrado(String decifrado) {
        this.decifrado = decifrado;
        return this;
    }

    public String getResumo_criptografico() {
        return resumo_criptografico;
    }

    public ChallengeDataVO setResumo_criptografico(String resumo_criptografico) {
        this.resumo_criptografico = resumo_criptografico;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public ChallengeDataVO setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public ChallengeDataTypeEnum getChallengeDataType() {
        return challengeDataType;
    }

    public ChallengeDataVO setChallengeDataType(ChallengeDataTypeEnum challengeDataType) {
        this.challengeDataType = challengeDataType;
        return this;
    }
}
