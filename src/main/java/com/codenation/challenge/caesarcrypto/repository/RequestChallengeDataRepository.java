package com.codenation.challenge.caesarcrypto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codenation.challenge.caesarcrypto.entities.RequestChallengeData;

@Repository
public interface RequestChallengeDataRepository extends JpaRepository<RequestChallengeData, String> {
}
