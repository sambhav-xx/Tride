package com.example.Tride.User;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("users")
public record User(
        String name,
        @Id
      String emailId,
        String from,
        String to,
        int price,
        int seats


) {
}
