package com.github.mpeter28.airtraffic.core.requests;

import com.github.mpeter28.airtraffic.core.AirCraftEntryTime;
import com.github.mpeter28.airtraffic.core.AirTrafficRequest;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class DequeueAirCraft implements AirTrafficRequest {

    @Override
    public AirTrafficRequestResponse performRequest(AtomicBoolean started, PriorityQueue<AirCraftEntryTime> airCraftQueue) {
        if (!started.get())
            return new AirTrafficRequestResponse("Error: Aircraft control queue has not been started", null);
        else if (airCraftQueue.isEmpty())
            return new AirTrafficRequestResponse("Error: Aircraft control queue is empty", null);
        else
            return new AirTrafficRequestResponse("Dequeued aircraft", airCraftQueue.poll().getAirCraft());
    }
}
