package edu.utsa.travelplanner.data.activitydata;

public class Activity {


    private int actId;
    private String actName;
    private String actLocation;
    private String actStartDate;
    private String actStartTime;
    private String actEndDate;
    private String actEndTime;

    public Activity(int actId, String actName, String actLocation, String actStartDate, String actStartTime, String actEndDate, String actEndTime) {
        this.actId = actId;
        this.actName = actName;
        this.actLocation = actLocation;
        this.actStartDate = actStartDate;
        this.actStartTime = actStartTime;
        this.actEndDate = actEndDate;
        this.actEndTime = actEndTime;
    }

    public Activity (){
    }

    //Get/set activity id
    public int getActId() {
        return actId;
    }
    public void setActId(int actId) {
        this.actId = actId;
    }

    //Get/set activity name
    public String getActName() {
        return actName;
    }
    public void setActName(String actName) {
        this.actName = actName;
    }

    //Get/set activity location
    public String getActLocation() {
        return actLocation;
    }
    public void setActLocation(String actLocation) {
        this.actLocation = actLocation;
    }

    //Get/set activity start date
    public String getActStartDate() {
        return actStartDate;
    }
    public void setActStartDate(String actStartDate) {
        this.actStartDate = actStartDate;
    }

    //Get/set activity start time
    public String getActStartTime() {
        return actStartTime;
    }
    public void setActStartTime(String actStartTime) {
        this.actStartTime = actStartTime;
    }

    //Get/set activity end date
    public String getActEndDate() {
        return actEndDate;
    }
    public void setActEndDate(String actEndDate) {
        this.actEndDate = actEndDate;
    }

    //Get/set activity end time
    public String getActEndTime() {
        return actEndTime;
    }
    public void setActEndTime(String actEndTime) {
        this.actEndTime = actEndTime;
    }

}
