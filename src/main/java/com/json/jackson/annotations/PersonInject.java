package com.json.jackson.annotations;

import com.fasterxml.jackson.annotation.JacksonInject;

public class PersonInject {

    public long id = 1;
    public String name = "Dariusz";

    @JacksonInject
    public String source = null;

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

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
