package com.microsoft.openhack.domain;

import com.microsoft.azure.spring.data.cosmosdb.core.mapping.Document;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
@Document(collection = "Ratings")
public class Ratings {
    String id;
    String userId;
    String productId;
    String timestamp;
    String locationName;
    Integer rating;
    String userNotes;
}
