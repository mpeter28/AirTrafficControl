package com.github.mpeter28.airtraffic.core.requests;

import com.github.mpeter28.airtraffic.core.AirCraftEntryTime;
import com.github.mpeter28.airtraffic.core.AirTrafficRequest;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

public class StartQueue implements AirTrafficRequest {

    @Override
    public AirTrafficRequestResponse performRequest(AtomicBoolean started, PriorityQueue<AirCraftEntryTime> airCraftQueue) {
        if (started.get()) {
            return new AirTrafficRequestResponse("Aircraft control queue was already started", null);
        } else {
            started.set(true);
            return new AirTrafficRequestResponse("Aircraft control queue started", null);
        }
    }
}
