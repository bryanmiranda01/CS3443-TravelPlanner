package edu.utsa.travelplanner.ui.home;

public class Trip {

    private String destination;
    private String address;
    private String cc;
    private String start;
    private String end;
    private String transport;

//    Constructor
    public Trip(String destination, String address, String cc, String start, String end, String transport) {
        this.destination = destination;
        this.address = address;
        this.cc = cc;
        this.start = start;
        this.end = end;
        this.transport = transport;

    }

    //    Get/set destination
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

//    Get/set city and country
    public String getCc() {
        return cc;
    }
    public void setCc(String cc) {
        this.cc = cc;
    }

//    Get/set hotel address
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }

//    Get/set start date
    public String getStart() {
        return start;
    }
    public void setStart(String start) {
        this.start = start;
    }

//    Get/set end date
    public String getEnd() {
        return end;
    }
    public void setEnd(String end) {
        this.end = end;
    }

//    Get/set mode of transportation
    public String getTransport() {
        return transport;
    }
    public void setTransport(String transport) {
        this.transport = transport;
    }
}
