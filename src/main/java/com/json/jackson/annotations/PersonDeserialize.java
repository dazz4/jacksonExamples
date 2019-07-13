package com.json.jackson.annotations;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = CustomPersonDeserializer.class)
public class PersonDeserialize {

    public long id;
    public String name;

    public PersonDeserialize() {
    }

    public PersonDeserialize(long id, String name) {
        this.id = id;
        this.name = name;
    }

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
