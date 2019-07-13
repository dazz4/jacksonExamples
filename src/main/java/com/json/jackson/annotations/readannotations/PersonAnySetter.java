package com.json.jackson.annotations.readannotations;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;

public class PersonAnySetter {
    private Map<String, Object> properties = new HashMap<>();

    @JsonAnySetter
    public void set(String fieldName, Object value) {
        this.properties.put(fieldName, value);
    }

    public Object get(String fieldName) {
        return this.properties.get(fieldName);
    }
}
