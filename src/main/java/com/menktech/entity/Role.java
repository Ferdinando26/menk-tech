package com.menktech.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.menktech.permissions.PermissionEnum;
import jakarta.persistence.*;
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
public class Role {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column
    @Enumerated(EnumType.STRING)
    private PermissionEnum name;

    @ManyToMany(mappedBy = "roles")
    @JsonBackReference
    private List<User> users;


}
