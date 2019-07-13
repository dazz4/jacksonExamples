package com.json.jackson.annotations.writeannotations;

import com.fasterxml.jackson.annotation.JsonValue;

public class PersonValue {

    private long id = 0;
    private String name = "Dariusz";

    @JsonValue
    public String toJson() {
        return this.id + ", " + this.name;
    }
}
