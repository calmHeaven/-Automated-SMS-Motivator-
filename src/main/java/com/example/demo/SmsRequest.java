package com.example.demo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class SmsRequest {
    @NotBlank
    private final String phoneNumber;
    @NotBlank
    private final String message;


    public SmsRequest(@JsonProperty("phoneNumber") String phoneNumber,
                      @JsonProperty("message") String message) {
        this.phoneNumber = phoneNumber;
        this.message = message;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }


    public String getMessage() {
        return this.message;
    }


    @Override
    public String toString() {
        return "SmsRequest{" +
            " phoneNumber='" + getPhoneNumber() + "\'" +
            ", message='" + getMessage() + "\'" +
            "}";
    }

}
