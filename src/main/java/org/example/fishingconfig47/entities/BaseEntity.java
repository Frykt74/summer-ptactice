package org.example.fishingconfig47.entities;

import jakarta.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Integer id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
