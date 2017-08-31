package com.github.mpeter28.airtraffic.core;

public class AirCraftEntryTime implements Comparable<AirCraftEntryTime> {

    private AirCraft airCraft;
    private long entryTime;

    public AirCraftEntryTime(AirCraft airCraft, long entryTime) {
        this.airCraft = airCraft;
        this.entryTime = entryTime;
    }

    @Override
    public int compareTo(AirCraftEntryTime toCompareTo) {
        AirCraft comparisonAirCraft = toCompareTo.getAirCraft();

        if (airCraft.getType() == comparisonAirCraft.getType()) {
            if (airCraft.getSize() == comparisonAirCraft.getSize()) {
                if (entryTime == toCompareTo.entryTime)
                    return 0;
                else
                    return entryTime < toCompareTo.getEntryTime() ? -1 : 1;
            } else if (airCraft.getSize() == AirCraft.AirCraftSize.Large && comparisonAirCraft.getSize() == AirCraft.AirCraftSize.Small) {
                return -1;
            } else {
                return 1;
            }
        } else if (airCraft.getType() == AirCraft.AirCraftType.Passenger && comparisonAirCraft.getType() == AirCraft.AirCraftType.Cargo) {
            return -1;
        } else {
            return 1;
        }
    }

    public AirCraft getAirCraft() {
        return airCraft;
    }

    public long getEntryTime() {
        return entryTime;
    }
}
