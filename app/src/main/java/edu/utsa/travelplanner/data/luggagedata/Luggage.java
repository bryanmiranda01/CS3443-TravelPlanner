package edu.utsa.travelplanner.data.luggagedata;

public class Luggage {

    private int luggageId;
    private String owner;
    private String brand;
    private String weight; //lbs
    private String dimensions;
    private String color;

    public Luggage(int luggageId, String owner, String brand, String weight, String dimensions, String color){
        this.luggageId = luggageId;
        this.owner = owner;
        this.brand = brand;
        this.weight = weight;
        this.dimensions = dimensions;
        this.color = color;
    }

    public Luggage(){
    }

    //Get/set luggage id
    public int getLuggageId() {
        return luggageId;
    }
    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    //Get/set owner
    public String getOwner() {
        return owner;
    }
    public void setOwner(String owner) {
        this.owner = owner;
    }

    //Get/set brand
    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    //Get/set weight
    public String getWeight() {
        return weight;
    }
    public void setWeight(String weight) {
        this.weight = weight;
    }

    //Get/set dimensions
    public String getDimensions() {
        return dimensions;
    }
    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    //Get/set color
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
