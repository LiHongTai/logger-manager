package com.roger.enumeration;

public enum EventType {
    DEFAULT("1","default"),
    LOGIN("2","login"),
    UPDATE("3","update"),
    DELETE("4","delete"),
    INSERT("5","insert"),
    SELECT("6","select");


    private String event;
    private String name;

    private EventType(String event,String name){
        this.event = event;
        this.name = name;
    }

    public String getEvent() {
        return event;
    }

    public String getName() {
        return name;
    }

}
