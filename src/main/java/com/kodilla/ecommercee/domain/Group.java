package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "GROUP_ENTITY")
public class Group {

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "GROUP_ID", unique = true)
    private Long id;

    @Column(name = "GROUP_NAME")
    private String name;

}
