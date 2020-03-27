package com.codenation.challenge.caesarcrypto.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.codenation.challenge.caesarcrypto.enums.ChallengeDataTypeEnum;

@Entity
@Table(name = "CHALLENGE_DATA")
public class ChallengeData {

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

    @Column(name = "INSERT_DATE", nullable = false)
    private LocalDateTime lastUpdate;

    @Column(name = "DATA_TYPE", nullable = false)
    private ChallengeDataTypeEnum challengeDataType;

    public String getId() {
        return id;
    }

    public ChallengeData setId(String id) {
        this.id = id;
        return this;
    }

    public Integer getNumero_casas() {
        return numero_casas;
    }

    public ChallengeData setNumero_casas(Integer numero_casas) {
        this.numero_casas = numero_casas;
        return this;
    }

    public String getToken() {
        return token;
    }

    public ChallengeData setToken(String token) {
        this.token = token;
        return this;
    }

    public String getCifrado() {
        return cifrado;
    }

    public ChallengeData setCifrado(String cifrado) {
        this.cifrado = cifrado;
        return this;
    }

    public String getDecifrado() {
        return decifrado;
    }

    public ChallengeData setDecifrado(String decifrado) {
        this.decifrado = decifrado;
        return this;
    }

    public String getResumo_criptografico() {
        return resumo_criptografico;
    }

    public ChallengeData setResumo_criptografico(String resumo_criptografico) {
        this.resumo_criptografico = resumo_criptografico;
        return this;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public ChallengeData setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    public ChallengeDataTypeEnum getChallengeDataType() {
        return challengeDataType;
    }

    public ChallengeData setChallengeDataType(ChallengeDataTypeEnum challengeDataType) {
        this.challengeDataType = challengeDataType;
        return this;
    }
}
