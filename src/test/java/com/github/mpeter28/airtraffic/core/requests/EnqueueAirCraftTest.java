package com.github.mpeter28.airtraffic.core.requests;

import com.github.mpeter28.airtraffic.core.AirCraft;
import com.github.mpeter28.airtraffic.core.AirTrafficQueue;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class EnqueueAirCraftTest {

    @Test
    public void queueNotStartedTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        AirTrafficRequestResponse response = queue.aqmRequestProcess(new EnqueueAirCraft(new AirCraft()));

        Assert.assertEquals("Error: Aircraft control queue has not been started", response.getMessage());
        Assert.assertEquals(0, queue.getAirCraftQueue().size());
    }

    @Test
    public void enqueuesAirCraftTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        queue.aqmRequestProcess(new StartQueue());
        queue.aqmRequestProcess(new EnqueueAirCraft(new AirCraft(AirCraft.AirCraftType.Passenger, AirCraft.AirCraftSize.Small, new HashMap<>())));
        queue.aqmRequestProcess(new EnqueueAirCraft(new AirCraft(AirCraft.AirCraftType.Cargo, AirCraft.AirCraftSize.Large, new HashMap<>())));

        Assert.assertEquals(2, queue.getAirCraftQueue().size());
    }

    @Test
    public void enqueuesMessageTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        queue.aqmRequestProcess(new StartQueue());
        AirTrafficRequestResponse response = queue
                .aqmRequestProcess(new EnqueueAirCraft(new AirCraft(AirCraft.AirCraftType.Passenger, AirCraft.AirCraftSize.Small, new HashMap<>())));

        Assert.assertEquals("Enqueued aircraft", response.getMessage());
    }
}
