package BIGPROJECT;

import java.io.Serializable;

public class Cities_BP implements Serializable {
    Long id;
    String name;
    String country;
    String short_Name;

    public Cities_BP(Long id, String name, String country, String short_Name) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.short_Name = short_Name;
    }

    public Cities_BP(Long id, String name, String short_name) {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getShort_Name() {
        return short_Name;
    }

    public void setShort_Name(String short_Name) {
        this.short_Name = short_Name;
    }
}
