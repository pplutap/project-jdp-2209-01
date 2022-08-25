package com.kodilla.ecommercee.domain;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "groups")
public class Group {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "group_id", unique = true)
    private Long id;

    @Column(name = "group_name")
    private String name;
}
