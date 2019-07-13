package com.json.jackson.annotations.readannotations;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class PersonRawValue {

    public long id = 0;

    public String address = "{ \"street\" : \"Wall Street\", \"no\":1}";

    @JsonRawValue
    public String rawAddress = "{ \"street\" : \"Wall Street\", \"no\":1}";

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRawAddress() {
        return rawAddress;
    }

    public void setRawAddress(String rawAddress) {
        this.rawAddress = rawAddress;
    }
}
