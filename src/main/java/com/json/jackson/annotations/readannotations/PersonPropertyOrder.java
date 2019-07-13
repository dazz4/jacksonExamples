package com.json.jackson.annotations.readannotations;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name", "id"})
public class PersonPropertyOrder {

    private long id = 0;
    private String name = "Dariusz";

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
}
