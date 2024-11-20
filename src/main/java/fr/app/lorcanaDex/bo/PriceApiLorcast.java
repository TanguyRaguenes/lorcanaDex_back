package fr.app.lorcanaDex.bo;

import com.fasterxml.jackson.annotation.JsonAlias;

public class PriceApiLorcast {

    private String usd;

    @JsonAlias("usd_foil")
    private String usdFoil;

    public PriceApiLorcast() {

    }

    public PriceApiLorcast(String usd, String usdFoil) {
        this.usd = usd;
        this.usdFoil = usdFoil;
    }

    // Getter pour usd
    public String getUsd() {
        return this.usd;
    }

    // Setter pour usd
    public void setUsd(String usd) {
        this.usd = usd;
    }

    // Getter pour usdFoil
    public String getUsdFoil() {
        return this.usdFoil;
    }

    // Setter pour usdFoil
    public void setUsdFoil(String usdFoil) {
        this.usdFoil = usdFoil;
    }

    @Override
    public String toString() {
        return "PricesApiLorcast{" +
                "usd=" + usd +
                ", usdFoil=" + usdFoil +
                '}';
    }

}
