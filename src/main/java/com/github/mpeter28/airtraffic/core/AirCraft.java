package com.github.mpeter28.airtraffic.core;

import java.util.Map;

public class AirCraft {

    public enum AirCraftType {
        Passenger,
        Cargo
    }

    public enum AirCraftSize {
        Small,
        Large
    }

    private AirCraftType type;
    private AirCraftSize size;
    private Map<String, Object> properties;

    public AirCraft() {
    }

    public AirCraft(AirCraftType type, AirCraftSize size, Map<String, Object> properties) {
        this.type = type;
        this.size = size;
        this.properties = properties;
    }

    public AirCraftType getType() {
        return type;
    }

    public void setType(AirCraftType type) {
        this.type = type;
    }

    public AirCraftSize getSize() {
        return size;
    }

    public void setSize(AirCraftSize size) {
        this.size = size;
    }

    public Map<String, Object> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Object> properties) {
        this.properties = properties;
    }
}
