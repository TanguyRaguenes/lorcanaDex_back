package fr.app.lorcanaDex.bo;

public class DigitalApiLorcast {

    private String small;
    private String normal;
    private String large;

    public DigitalApiLorcast() {
    }

    public DigitalApiLorcast(String small, String normal, String large) {
        this.small = small;
        this.normal = normal;
        this.large = large;
    }

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getNormal() {
        return normal;
    }

    public void setNormal(String normal) {
        this.normal = normal;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

    @Override
    public String toString() {
        return "Digital{" +
                "small='" + small + '\'' +
                ", normal='" + normal + '\'' +
                ", large='" + large + '\'' +
                '}';
    }

}
