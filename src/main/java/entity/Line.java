package entity;

import jakarta.persistence.*;

@Entity
@Table
public class Line {
    private int id;
    private String name;
    private String type;
//  Диаметр
    private float thickness;
    private float testWidth;
    private String color;
    private int price;
    private String description;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int getId() {
        return id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public float getThickness() {
        return thickness;
    }

    public void setThickness(float thickness) {
        this.thickness = thickness;
    }

    @Column
    public float getTestWidth() {
        return testWidth;
    }

    public void setTestWidth(float testWidth) {
        this.testWidth = testWidth;
    }

    @Column
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Column
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Column
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
