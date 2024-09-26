/*********************************************
 * @file: CARDAte.java
 * @description: Represents a car's data including its price, year, brand,
 * model, color, state/city, mileage, and VIN number
 * This class implements Comparable to allow for sorting based on price
 * @author: Charles Weisberg
 * @date: 26 September 2024
 *********************************************/

import java.util.Objects;

public class CARData implements Comparable<CARData> {

    private Integer price;
    private Integer year;
    private String brand;
    private String model;
    private String color;
    private String statecity;
    private float mileage;
    private String vin;

    /**
     * Default constructor initializing CARData with default values.
     */
    public CARData() {
        this.price = 0;
        this.year = 0;
        this.brand = "";
        this.model = "";
        this.color = "";
        this.statecity = "";
        this.mileage = 0.0f;
        this.vin = "";
    }

    /**
     * Parameterized contructor to create a CARData object with specified values
     *
     * @param price     the price of the car
     * @param year      the year of the car
     * @param brand     the brand of the car
     * @param model     the model of the car
     * @param color     the color of the car
     * @param statecity the state or city that the car is in
     * @param mileage   the mileage of the car
     * @param vin       the Vehicle Identification Number (VIN)
     */
    public CARData(Integer price, Integer year, String brand, String model, String color, String statecity, float mileage, String vin) {

        this.price = price;
        this.year = year;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.statecity = statecity;
        this.mileage = mileage;
        this.vin = vin;
    }

    /**
     * Returns a string output of all the car attributes
     *
     * @return a string containing the car details
     */
    @Override
    public String toString() {
        return "Car Price: " + price + ", Year: " + year + ", Brand: " + brand + ", Model: " + model + ", Color: " + color + ", State/City: " + statecity + ", Mileage: " + mileage + ", Vin: " + vin;
    }

    /**
     * Compares this CARData object with abother CARData object based on price
     *
     * @param o the object to be compared.
     * @return a negative integer, zero, or a positive integer as this object is
     * less than, equal to or greater than the specified object
     */
    @Override
    public int compareTo(CARData o) {
        return this.price.compareTo(o.price);
    }

    /**
     * Checks if this CARData object is equal to another object
     *
     * @param obj the object to compare with
     * @return true if the objects are equal, false otherwise
     * Compares based on all attributes being the same
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {

            return false;
        }
        CARData other = (CARData) obj;

        return Objects.equals(price, other.price) &&
                Objects.equals(year, other.year) &&
                Objects.equals(brand, other.brand) &&
                Objects.equals(model, other.model) &&
                Objects.equals(color, other.color) &&
                Objects.equals(statecity, other.statecity) &&
                Float.compare(mileage, other.mileage) == 0 &&
                Objects.equals(vin, other.vin);
    }

    // Getter and setter methods

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;

    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;

    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;

    }

    public String getStatecity() {
        return statecity;
    }

    public void setStatecity(String statecity) {
        this.statecity = statecity;

    }

    public float getMileage() {
        return mileage;
    }

    public void setMileage(float mileage) {
        this.mileage = mileage;

    }

    public String getVin() {
        return model;
    }

    public void setVin(String vin) {
        this.vin = vin;

    }
}
