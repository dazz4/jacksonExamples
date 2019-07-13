package com.json.jackson.annotations.writeannotations;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = CustomPersonSerializer.class)
public class PersonSerialize {

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
