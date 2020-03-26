package com.codenation.challenge.caesarcrypto.services.vo;

public class CodenationRequestChallengeDataVO {

    private Integer numero_casas;
    private String token;
    private String cifrado;
    private String decifrado;
    private String resumo_criptografico;

    public Integer getNumero_casas() {
        return numero_casas;
    }

    public CodenationRequestChallengeDataVO setNumero_casas(Integer numero_casas) {
        this.numero_casas = numero_casas;
        return this;
    }

    public String getToken() {
        return token;
    }

    public CodenationRequestChallengeDataVO setToken(String token) {
        this.token = token;
        return this;
    }

    public String getCifrado() {
        return cifrado;
    }

    public CodenationRequestChallengeDataVO setCifrado(String cifrado) {
        this.cifrado = cifrado;
        return this;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public CodenationRequestChallengeDataVO setDecifrado(String decifrado) {
        this.decifrado = decifrado;
        return this;
    }

    public String getResumo_criptografico() {
        return resumo_criptografico;
    }

    public CodenationRequestChallengeDataVO setResumo_criptografico(String resumo_criptografico) {
        this.resumo_criptografico = resumo_criptografico;
        return this;
    }
}
