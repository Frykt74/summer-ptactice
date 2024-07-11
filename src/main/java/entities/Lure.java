package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Lure extends BaseElementEntity {
    private String type;
    private int weight;
    private String hookSize;
    private String color;

    public Lure(String type, int weight, String hookSize, String color) {
        this.type = type;
        this.weight = weight;
        this.hookSize = hookSize;
        this.color = color;
    }

    protected Lure() {
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Column
    public String getHookSize() {
        return hookSize;
    }

    public void setHookSize(String hookSize) {
        this.hookSize = hookSize;
    }

    @Column
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
