package org.example.fishingconfig47.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lure")
public class Lure extends BaseElementEntity {
    private int weight;
    private String hookSize;
    private String color;

    public Lure(int weight, String hookSize, String color) {
        this.weight = weight;
        this.hookSize = hookSize;
        this.color = color;
    }

    protected Lure() {
    }

    @Column(name = "weight")
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column(name = "hook_size")
    public String getHookSize() {
        return hookSize;
    }

    public void setHookSize(String hookSize) {
        this.hookSize = hookSize;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
