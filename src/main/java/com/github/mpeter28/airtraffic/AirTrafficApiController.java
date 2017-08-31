package com.github.mpeter28.airtraffic;

import com.github.mpeter28.airtraffic.core.AirCraftEntryTime;
import com.github.mpeter28.airtraffic.core.AirTrafficQueue;
import com.github.mpeter28.airtraffic.core.AirTrafficRequest;
import com.github.mpeter28.airtraffic.core.AirTrafficRequestResponse;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/airTraffic")
public class AirTrafficApiController {

    private final static AirTrafficQueue airTrafficQueue = new AirTrafficQueue();

    @RequestMapping(value = "/request", method = RequestMethod.POST)
    public AirTrafficRequestResponse request(@RequestBody AirTrafficRequest request) {
        AirTrafficRequestResponse response;
        synchronized (airTrafficQueue) {
            response = airTrafficQueue.aqmRequestProcess(request);
        }

        return response;
    }

    @RequestMapping(value = "/queue", method = RequestMethod.GET)
    public List<AirCraftEntryTime> queue() {
        List<AirCraftEntryTime> queue;
        synchronized (airTrafficQueue) {
            queue = airTrafficQueue.getAirCraftQueue();
        }

        return queue;
    }

    @RequestMapping(value = "/started", method = RequestMethod.GET)
    public boolean started() {
        boolean isStarted;
        synchronized (airTrafficQueue) {
            isStarted = airTrafficQueue.isActive();
        }

        return isStarted;
    }
}
