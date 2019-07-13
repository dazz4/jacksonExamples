package com.json.jackson.annotations.readannotations;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties("firstName")
public class PersonIgnoreProperties {
    private String firstName = "Dariusz";
    private String lastName = "Kaminski";
}
