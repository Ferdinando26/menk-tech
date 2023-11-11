package com.menktech.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "roles")
@Data
@Getter
@Setter
@EqualsAndHashCode
public class Role {


    @Id
    private Long id;

    private String name;

    @ManyToMany(mappedBy = "roles")
    private List<User> users;


}
