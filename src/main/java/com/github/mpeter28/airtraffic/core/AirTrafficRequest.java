package com.github.mpeter28.airtraffic.core;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.mpeter28.airtraffic.core.requests.DequeueAirCraft;
import com.github.mpeter28.airtraffic.core.requests.EnqueueAirCraft;
import com.github.mpeter28.airtraffic.core.requests.StartQueue;

import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicBoolean;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({@JsonSubTypes.Type(value = StartQueue.class, name = "startQueue"),
        @JsonSubTypes.Type(value = DequeueAirCraft.class, name = "dequeue"),
        @JsonSubTypes.Type(value = EnqueueAirCraft.class, name = "enqueue"),})
public interface AirTrafficRequest {

    AirTrafficRequestResponse performRequest(AtomicBoolean started, PriorityQueue<AirCraftEntryTime> airCraftQueue);

}
