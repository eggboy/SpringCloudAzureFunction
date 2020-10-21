package com.microsoft.openhack.service;

import com.microsoft.openhack.domain.Ratings;
import com.microsoft.openhack.repository.RatingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingsService {
    @Autowired
    private RatingsRepository ratingsRepository;

    public List<Ratings> getRatingsByUserId(String userId) {
        List<Ratings> ratingsList = new ArrayList<>();

        return ratingsList = ratingsRepository.findByUserId(userId);
    }

    public Boolean validateUserid(String userId) {

        String url = "https://serverlessohuser.trafficmanager.net/api/GetUser?userId=";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url + userId, String.class);

        if (response.getBody().contains("Please pass a valid userId on the query string"))
            return Boolean.FALSE;
        else return Boolean.TRUE;
    }
}
