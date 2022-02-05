package com.jksports.eventsrus.enumeration;
//@author jk 03Feb-22
public enum Status {
    EVENT_LIVE("EVENT_LIVE"),
    EVENT_PAST("EVENT_OVER");

    private final String status;

    Status(String status){
        this.status = status;
    }

    public String getStatus(){
        return this.status;
    }
}
