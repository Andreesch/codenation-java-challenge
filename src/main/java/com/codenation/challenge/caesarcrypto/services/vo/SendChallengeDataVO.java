package com.codenation.challenge.caesarcrypto.services.vo;

import com.codenation.challenge.caesarcrypto.entities.ChallengeData;

public class SendChallengeDataVO {
    private Integer numero_casas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumo_criptografico;

    public static SendChallengeDataVO byEntity(ChallengeData challengeData) {
        return new SendChallengeDataVO()
                .setCifrado(challengeData.getCifrado())
                .setDecifrado(challengeData.getDecifrado())
                .setNumero_casas(challengeData.getNumero_casas())
                .setToken(challengeData.getToken())
                .setResumo_criptografico(challengeData.getResumo_criptografico());
    }

    public Integer getNumero_casas() {
        return numero_casas;
    }

    public SendChallengeDataVO setNumero_casas(Integer numero_casas) {
        this.numero_casas = numero_casas;
        return this;
    }

    public String getToken() {
        return token;
    }

    public SendChallengeDataVO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getCifrado() {
        return cifrado;
    }

    public SendChallengeDataVO setCifrado(String cifrado) {
        this.cifrado = cifrado;
        return this;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public SendChallengeDataVO setDecifrado(String decifrado) {
        this.decifrado = decifrado;
        return this;
    }

    public String getResumo_criptografico() {
        return resumo_criptografico;
    }

    public SendChallengeDataVO setResumo_criptografico(String resumo_criptografico) {
        this.resumo_criptografico = resumo_criptografico;
        return this;
    }
}
