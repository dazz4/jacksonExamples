package com.json.jackson.annotations.writeannotations;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class PersonAnyGetter {
    private Map<String, String> personDetails = new HashMap<>();

    @JsonAnyGetter
    public Map<String, String> getDetails() {
        return personDetails;
    }
}
