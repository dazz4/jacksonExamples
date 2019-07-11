package com.json.jackson.annotations;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class PersonIgnoreType {

    @JsonIgnoreType
    public static class Address {
        public String streetName = "Neverland";
    }

    public String firstName = "Dariusz";
    public String lastName = "Kaminski";
    public Address address = null;
}
