package com.json.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PersonCreator {
    private long id = 1;
    private String name = "Dariusz";

    @JsonCreator
    public PersonCreator(@JsonProperty("id") long id, @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
