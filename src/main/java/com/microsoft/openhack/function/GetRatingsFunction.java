package com.microsoft.openhack.function;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;
import com.microsoft.openhack.domain.Ratings;
import com.microsoft.openhack.service.RatingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.function.adapter.azure.AzureSpringBootRequestHandler;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

public class GetRatingsFunction extends AzureSpringBootRequestHandler<String, List<Ratings>> {
    RatingsService ratingsService = new RatingsService();

    @FunctionName("getRatings")
    public HttpResponseMessage run(
            @HttpTrigger(
                name = "request", 
                methods = {HttpMethod.GET}, 
                authLevel = AuthorizationLevel.ANONYMOUS) HttpRequestMessage<Optional<String>> request,
            final ExecutionContext context) {

        final String userId = request.getQueryParameters().get("userId");

        if(!ratingsService.validateUserid(userId)) {
            return request
                    .createResponseBuilder(HttpStatus.BAD_REQUEST)
                    .body("User Id is Wrong")
                    .build();
        } else {
            return request
                    .createResponseBuilder(HttpStatus.OK)
                    .body(handleRequest(userId, context))
                    .header("Content-Type", "application/json")
                    .build();
        }

    }

}
