package com.github.mpeter28.airtraffic.core;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class AirTrafficQueue {

    private AtomicBoolean active;
    private PriorityQueue<AirCraftEntryTime> airCraftQueue;

    public AirTrafficQueue() {
        active = new AtomicBoolean();
        airCraftQueue = new PriorityQueue<>();
    }

    public AirTrafficRequestResponse aqmRequestProcess(AirTrafficRequest request) {
        return request.performRequest(active, airCraftQueue);
    }

    public boolean isActive() {
        return active.get();
    }

    public List<AirCraftEntryTime> getAirCraftQueue() {
        return new ArrayList<>(airCraftQueue);
    }
}
