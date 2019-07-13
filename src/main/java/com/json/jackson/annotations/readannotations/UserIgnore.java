package com.json.jackson.annotations.readannotations;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Component
public class UserIgnore {
    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;
    private String name;
    private String email;
}
