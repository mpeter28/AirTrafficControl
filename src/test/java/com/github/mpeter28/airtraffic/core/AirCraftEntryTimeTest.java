package com.github.mpeter28.airtraffic.core;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class AirCraftEntryTimeTest {

    @Test
    public void passengerBeforeCargoTest() {
        AirCraftEntryTime passenger = new AirCraftEntryTime(new AirCraft(AirCraft.AirCraftType.Passenger,
                AirCraft.AirCraftSize.Large, new HashMap<>()), 0);

        AirCraftEntryTime cargo = new AirCraftEntryTime(new AirCraft(AirCraft.AirCraftType.Cargo,
                AirCraft.AirCraftSize.Large, new HashMap<>()), 0);

        Assert.assertEquals(-1, passenger.compareTo(cargo));
        Assert.assertEquals(1, cargo.compareTo(passenger));
    }

    @Test
    public void largeBeforeSmallTest() {
        AirCraftEntryTime large = new AirCraftEntryTime(new AirCraft(AirCraft.AirCraftType.Passenger,
                AirCraft.AirCraftSize.Large, new HashMap<>()), 0);

        AirCraftEntryTime small = new AirCraftEntryTime(new AirCraft(AirCraft.AirCraftType.Passenger,
                AirCraft.AirCraftSize.Small, new HashMap<>()), 0);

        Assert.assertEquals(-1, large.compareTo(small));
        Assert.assertEquals(1, small.compareTo(large));
    }

    @Test
    public void oldestFirstTest() {
        AirCraftEntryTime old = new AirCraftEntryTime(new AirCraft(AirCraft.AirCraftType.Passenger,
                AirCraft.AirCraftSize.Large, new HashMap<>()), 0);

        AirCraftEntryTime newest = new AirCraftEntryTime(new AirCraft(AirCraft.AirCraftType.Passenger,
                AirCraft.AirCraftSize.Large, new HashMap<>()), 10);

        Assert.assertEquals(-1, old.compareTo(newest));
        Assert.assertEquals(1, newest.compareTo(old));
    }

}
