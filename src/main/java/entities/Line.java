package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Line extends BaseElementEntity {
    private String type;
//  Диаметр
    private float thickness;
    private float testWidth;
    private String color;

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
}
