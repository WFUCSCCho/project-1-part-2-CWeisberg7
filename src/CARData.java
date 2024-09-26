import java.util.Objects;

/********************************
 *
 *
 *
 * Got rid of title status, lot number, country, and condition.
 ********************************/
public class CARData implements Comparable<CARData> {

    private Integer price;
    private Integer year;
    private String brand;
    private String model;
    private String color;
    private String statecity;
    private float mileage;
    private String vin;

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

    @Override
    public String toString() {
        return "Car Price: " + price + ", Year: " + year + ", Brand: " + brand + ", Model: " + model + ", Color: " + color + ", State/City: " + statecity + ", Mileage: " + mileage + ", Vin: " + vin;
    }

    @Override
    public int compareTo(CARData o) {
        return this.price.compareTo(o.price);
    }
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
