package com.github.mpeter28.airtraffic.core.requests;

import com.github.mpeter28.airtraffic.core.AirCraft;
import com.github.mpeter28.airtraffic.core.AirCraftEntryTime;
import com.github.mpeter28.airtraffic.core.AirTrafficRequest;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class EnqueueAirCraft implements AirTrafficRequest {

    private AirCraft airCraft;

    public EnqueueAirCraft() {
    }

    public EnqueueAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }

    @Override
    public AirTrafficRequestResponse performRequest(AtomicBoolean started, PriorityQueue<AirCraftEntryTime> airCraftQueue) {
        if (!started.get())
            return new AirTrafficRequestResponse("Error: Aircraft control queue has not been started", null);

        airCraftQueue.add(new AirCraftEntryTime(airCraft, System.currentTimeMillis()));
        return new AirTrafficRequestResponse("Enqueued aircraft", null);
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public void setAirCraft(AirCraft airCraft) {
        this.airCraft = airCraft;
    }
}
