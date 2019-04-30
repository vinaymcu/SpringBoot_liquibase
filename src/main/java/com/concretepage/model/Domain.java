package com.concretepage.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "domain")
public class Domain {

    @Id
    private long id;

    @Indexed(unique = true)
    private String name;
    private String loc;

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    private boolean displayAds;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDisplayAds() {
        return displayAds;
    }

    public void setDisplayAds(boolean displayAds) {
        this.displayAds = displayAds;
    }



    //getters and setters
}