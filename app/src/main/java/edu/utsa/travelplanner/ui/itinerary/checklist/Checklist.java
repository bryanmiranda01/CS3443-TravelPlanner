package edu.utsa.travelplanner.ui.itinerary.checklist;

public class Checklist {

    private int checklistId;
    private boolean hotelReserved;
    private boolean transportBooked;
    private boolean passportValid;
    private boolean visaRequired;
    
    //shopping list needs to store [String, String, Boolean]
    public Checklist(int checklistId, boolean hotelReserved, boolean transportBooked, boolean passportValid, boolean visaRequired){
        this.checklistId = checklistId;
        this.hotelReserved = hotelReserved;
        this.transportBooked = transportBooked;
        this.passportValid = passportValid;
        this.visaRequired = visaRequired;
    }
    //Get/set checklist id
    public int getChecklistId() {
        return checklistId;
    }
    public void setChecklistId(int checklistId) {
        this.checklistId = checklistId;
    }

    //Get/set hotel reserved
    public boolean isHotelReserved() {
        return hotelReserved;
    }
    public void setHotelReserved(boolean hotelReserved) {
        this.hotelReserved = hotelReserved;
    }

    //Get/set transport booked
    public boolean isTransportBooked() {
        return transportBooked;
    }
    public void setTransportBooked(boolean transportBooked) {
        this.transportBooked = transportBooked;
    }

    //Get/set passport valid
    public boolean isPassportValid() {
        return passportValid;
    }
    public void setPassportValid(boolean passportValid) {
        this.passportValid = passportValid;
    }

    //Get/set visa required
    public boolean isVisaRequired() {
        return visaRequired;
    }
    public void setVisaRequired(boolean visaRequired) {
        this.visaRequired = visaRequired;
    }
}
