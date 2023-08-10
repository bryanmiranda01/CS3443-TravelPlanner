package edu.utsa.travelplanner.data.tripdata;

public class Trip {

    public int tripId;
    public String destination;

    public String address;
    public String cc;
    public String startt;
    public String endt;
    public String transport;

    //Constructor
    public Trip(int tripid, String destination, String address, String cc, String startt, String endt, String transport) {
        this.destination = destination;
        this.address = address;
        this.cc = cc;
        this.startt = startt;
        this.endt = endt;
        this.transport = transport;
    }

    public Trip(){
    }

    // Get/set trip id
    public int getTripId(){ return tripId; }
    public void setTripId(int tripId) {this.tripId = tripId; }

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
        return startt;
    }
    public void setStart(String start) {
        this.startt = start;
    }

    //    Get/set end date
    public String getEnd() {
        return endt;
    }
    public void setEnd(String end) {
        this.endt = end;
    }

    //    Get/set mode of transportation
    public String getTransport() {
        return transport;
    }
    public void setTransport(String transport) {
        this.transport = transport;
    }
}
