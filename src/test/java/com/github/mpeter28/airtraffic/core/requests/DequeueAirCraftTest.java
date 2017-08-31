package com.github.mpeter28.airtraffic.core.requests;

import com.github.mpeter28.airtraffic.core.AirCraft;
import com.github.mpeter28.airtraffic.core.AirCraftEntryTime;
import com.github.mpeter28.airtraffic.core.AirTrafficQueue;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class DequeueAirCraftTest {

    @Test
    public void queueNotStartedTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        AirTrafficRequestResponse response = queue.aqmRequestProcess(new DequeueAirCraft());

        Assert.assertEquals("Error: Aircraft control queue has not been started", response.getMessage());
        Assert.assertNull(response.getReturnedAirCraft());
    }

    @Test
    public void queueEmptyTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        queue.aqmRequestProcess(new StartQueue());
        AirTrafficRequestResponse response = queue.aqmRequestProcess(new DequeueAirCraft());

        Assert.assertEquals("Error: Aircraft control queue is empty", response.getMessage());
        Assert.assertNull(response.getReturnedAirCraft());
    }

    @Test
    public void dequeueTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        queue.aqmRequestProcess(new StartQueue());
        queue.aqmRequestProcess((started, airCraftQueue) -> {
            airCraftQueue.add(new AirCraftEntryTime(
                    new AirCraft(AirCraft.AirCraftType.Passenger, AirCraft.AirCraftSize.Large, new HashMap<>()),
                    100000
            ));
            airCraftQueue.add(new AirCraftEntryTime(
                    new AirCraft(AirCraft.AirCraftType.Cargo, AirCraft.AirCraftSize.Large, new HashMap<>()),
                    100000
            ));

            return null;
        });
        AirTrafficRequestResponse response = queue.aqmRequestProcess(new DequeueAirCraft());

        Assert.assertEquals("Dequeued aircraft", response.getMessage());
        Assert.assertEquals(AirCraft.AirCraftType.Passenger, response.getReturnedAirCraft().getType());
        Assert.assertEquals(1, queue.getAirCraftQueue().size());
    }
}
