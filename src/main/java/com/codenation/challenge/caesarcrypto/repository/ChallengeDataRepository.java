package com.codenation.challenge.caesarcrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenation.challenge.caesarcrypto.entities.ChallengeData;

@Repository
public interface ChallengeDataRepository extends JpaRepository<ChallengeData, String> {

    public ChallengeData findFirstByOrderByIdDesc();
}
