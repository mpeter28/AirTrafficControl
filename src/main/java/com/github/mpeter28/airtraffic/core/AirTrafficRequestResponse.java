package com.github.mpeter28.airtraffic.core;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AirTrafficRequestResponse {

    private String message;
    private AirCraft returnedAirCraft;

    public AirTrafficRequestResponse() {
    }

    public AirTrafficRequestResponse(String message, AirCraft returnedAirCraft) {
        this.message = message;
        this.returnedAirCraft = returnedAirCraft;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public AirCraft getReturnedAirCraft() {
        return returnedAirCraft;
    }

    public void setReturnedAirCraft(AirCraft returnedAirCraft) {
        this.returnedAirCraft = returnedAirCraft;
    }
}
