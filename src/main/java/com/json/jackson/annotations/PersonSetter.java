package com.json.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonSetter;

public class PersonSetter {

    private long personId = 0;
    private String name = "Dariusz";

    public long getPersonId() {
        return personId;
    }

    @JsonSetter("id")
    public void setPersonId(long personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
