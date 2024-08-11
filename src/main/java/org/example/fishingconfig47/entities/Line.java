package org.example.fishingconfig47.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "line")
public class Line extends BaseEntity {
    private String type;
//  Диаметр
    private float thickness;
    private float testWidth;
    private String color;
    private int length;
    private String description;
    private int price;

    public Line(String type, float thickness, float testWidth, String color, int length) {
        this.type = type;
        this.thickness = thickness;
        this.testWidth = testWidth;
        this.color = color;
        this.length = length;
    }

    protected Line() {
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "thickness")
    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    @Column(name = "test_width")
    public float getTestWidth() {
        return testWidth;
    }

    public void setTestWidth(float testWidth) {
        this.testWidth = testWidth;
    }

    @Column(name = "color")
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
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
}
