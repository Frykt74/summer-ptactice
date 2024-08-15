package org.example.fishingconfig47.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "lure")
public class Lure extends BaseEntity {
    private int weight;
    private String hookSize;
    private String color;
    private String description;
    private int price;
    private String name;


    public Lure(String name, int weight, String hookSize, String color) {
        this.name = name;
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

    @Column(name = "description", length = 1024)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
