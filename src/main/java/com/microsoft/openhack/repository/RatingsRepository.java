package com.microsoft.openhack.repository;

import com.microsoft.azure.spring.data.cosmosdb.repository.CosmosRepository;
import com.microsoft.openhack.domain.Ratings;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RatingsRepository extends CosmosRepository<Ratings, String> {
    List findByUserId(String userId);
}
