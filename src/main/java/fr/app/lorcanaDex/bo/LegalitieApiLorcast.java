package fr.app.lorcanaDex.bo;

public class LegalitieApiLorcast {

    private String core;

    public void LegalitiesCoreApiLorcast() {
    }

    public void LegalitiesCoreApiLorcast(String core) {
        this.core = core;
    }

    public String getCore() {
        return core;
    }

    public void setCore(String core) {
        this.core = core;
    }

    @Override
    public String toString() {
        return "LegalitiesCoreApiLorcast{" +
                "core='" + core + '\'' +
                '}';
    }

}
