package com.json.jackson.annotations.writeannotations;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

public class PersonGetter {

    private long personId = 1;

    @JsonGetter("id")
    public long personId() {
        return this.personId;
    }

    @JsonSetter("id")
    public void personId(long personId) {
        this.personId = personId;
    }
}
