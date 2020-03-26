package com.codenation.challenge.caesarcrypto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "CHALLENGE_DATA")
public class RequestChallengeData {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private String id;

    @Column(name = "NUMERO_CASAS", nullable = false)
    private Integer numero_casas;

    @Column(name = "TOKEN", nullable = false)
    private String token;

    @Lob
    @Column(name = "CIFRADO", nullable = false)
    private String cifrado;

    @Column(name = "DECIFRADO")
    private String decifrado;

    @Column(name = "RESUMO_CRIPTOGRAFICO")
    private String resumo_criptografico;

    public String getId() {
        return id;
    }

    public RequestChallengeData setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getNumero_casas() {
        return numero_casas;
    }

    public RequestChallengeData setNumero_casas(Integer numero_casas) {
        this.numero_casas = numero_casas;
        return this;
    }

    public String getToken() {
        return token;
    }

    public RequestChallengeData setToken(String token) {
        this.token = token;
        return this;
    }

    public String getCifrado() {
        return cifrado;
    }

    public RequestChallengeData setCifrado(String cifrado) {
        this.cifrado = cifrado;
        return this;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public RequestChallengeData setDecifrado(String decifrado) {
        this.decifrado = decifrado;
        return this;
    }

    public String getResumo_criptografico() {
        return resumo_criptografico;
    }

    public RequestChallengeData setResumo_criptografico(String resumo_criptografico) {
        this.resumo_criptografico = resumo_criptografico;
        return this;
    }
}
