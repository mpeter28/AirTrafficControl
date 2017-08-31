package com.github.mpeter28.airtraffic.core.requests;

import com.github.mpeter28.airtraffic.core.AirTrafficQueue;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;
import org.junit.Assert;
import org.junit.Test;

public class StartQueueTest {

    @Test
    public void startsTheQueueTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        AirTrafficRequestResponse response = queue.aqmRequestProcess(new StartQueue());

        Assert.assertEquals("Aircraft control queue started", response.getMessage());
        Assert.assertTrue(queue.isActive());
    }

    @Test
    public void alreadyStartedTest() {
        AirTrafficQueue queue = new AirTrafficQueue();
        queue.aqmRequestProcess((started, airCraftQueue) -> { started.set(true); return null;});
        AirTrafficRequestResponse response = queue.aqmRequestProcess(new StartQueue());

        Assert.assertEquals("Aircraft control queue was already started", response.getMessage());
        Assert.assertTrue(queue.isActive());
    }
}
