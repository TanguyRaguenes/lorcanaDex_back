package fr.app.lorcanaDex.bo;

public class ImageUrisApiLorcast {

    private DigitalApiLorcast digital;

    public void ImageUris() {
    }

    public void ImageUris(DigitalApiLorcast digital) {
        this.digital = digital;
    }

    public DigitalApiLorcast getDigital() {
        return digital;
    }

    public void setDigital(DigitalApiLorcast digital) {
        this.digital = digital;
    }

    @Override
    public String toString() {
        return "ImageUris{" +
                "digital=" + digital +
                '}';
    }
}
