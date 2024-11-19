package fr.app.lorcanaDex.bo;

import java.time.LocalDate;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonAlias;

public class SetApiLorcast {

    // {
    // "id": "set_c254adfcbf6d4e3482a675ecece86dcc",
    // "name": "Promo Set 1",
    // "code": "P1",
    // "released_at": "2023-08-18",
    // "prereleased_at": "2023-08-18"
    // },

    private Long setIdBdd;

    @JsonAlias({ "id" })
    private String setIdApi;

    @JsonAlias({ "name" })
    private String name;

    @JsonAlias({ "code" })
    private String code;

    @JsonAlias({ "released_at" })
    private LocalDate releasedAt;

    @JsonAlias({ "prereleased_at" })
    private LocalDate prereleasedAt;

    public SetApiLorcast() {

    }

    public SetApiLorcast(Long setIdBdd, String setIdApi, String name, String code, LocalDate releasedAt,
            LocalDate prereleasedAt) {
        this.setIdBdd = setIdBdd;
        this.setIdApi = setIdApi;
        this.name = name;
        this.code = code;
        this.releasedAt = releasedAt;
        this.prereleasedAt = prereleasedAt;
    }

    public Long getSetIdBdd() {
        return setIdBdd;
    }

    public void setSetIdBdd(Long setIdBdd) {
        this.setIdBdd = setIdBdd;
    }

    public String getSetIdApi() {
        return setIdApi;
    }

    public void setSetIdApi(String setIdApi) {
        this.setIdApi = setIdApi;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDate getReleasedAt() {
        return releasedAt;
    }

    public void setReleasedAt(LocalDate releasedAt) {
        this.releasedAt = releasedAt;
    }

    public LocalDate getPrereleasedAt() {
        return prereleasedAt;
    }

    public void setPrereleasedAt(LocalDate prereleasedAt) {
        this.prereleasedAt = prereleasedAt;
    }

    @Override
    public String toString() {
        return "SetApiLorcast [setIdBdd=" + setIdBdd + ", setIdApi=" + setIdApi + ", name=" + name + ", code=" + code
                + ", releasedAt=" + releasedAt + ", prereleasedAt=" + prereleasedAt + "]";
    }

}
