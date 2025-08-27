package com.petshop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

public class CustomerDTO {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Request {

        private String firstName;


        private String lastName;


        private String email;


        private String phoneNumber;

        private Long addressId;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Response {
        private Long customerId;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private Long addressId;
        private String createdAt;
        private String updatedAt;
    }
}
