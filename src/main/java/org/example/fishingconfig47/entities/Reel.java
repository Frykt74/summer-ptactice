package org.example.fishingconfig47.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reel")
public class Reel extends BaseEntity {
    private String type;
    private String gearRatio;
    private int recovery;
    private float maxDrag;
    private int weight;
    private String description;
    private int price;
    private String name;


    public Reel(String name, String type, String gearRatio, int recovery, float maxDrag, int weight) {
        this.name = name;
        this.type = type;
        this.gearRatio = gearRatio;
        this.recovery = recovery;
        this.maxDrag = maxDrag;
        this.weight = weight;
    }

    protected Reel() {
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "gear_ratio")
    public String getGearRatio() {
        return gearRatio;
    }

    public void setGearRatio(String gearRatio) {
        this.gearRatio = gearRatio;
    }

    @Column(name = "recovery")
    public int getRecovery() {
        return recovery;
    }

    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }

    @Column(name = "max_drag")
    public float getMaxDrag() {
        return maxDrag;
    }

    public void setMaxDrag(float maxDrag) {
        this.maxDrag = maxDrag;
    }

    @Column(name = "weight")
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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
