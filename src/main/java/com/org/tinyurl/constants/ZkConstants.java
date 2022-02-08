package com.org.tinyurl.constants;

public enum ZkConstants {

    COUNTERNODE("/counter");

    private String name;

    ZkConstants(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
