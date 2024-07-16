package org.example.fishingconfig47.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

// Удилища
@Entity
@Table(name = "rod")
public class Rod extends BaseElementEntity {
    private String type;
    private int length;
    //    Тест (Вес приманки)
    private float lureWeightMin;
    private float lureWeightMax;
    //    Класс
    private String power;
    //    Рабочая Нагрузка
    private float lineWeightMin;
    private float lineWeightMax;
    //    Строй
    private String action;

    public Rod(String type, int length, float lureWeightMin, float lureWeightMax, String power, float lineWeightMin,
               float lineWeightMax, String action) {
        this.type = type;
        this.length = length;
        this.lureWeightMin = lureWeightMin;
        this.lureWeightMax = lureWeightMax;
        this.power = power;
        this.lineWeightMin = lineWeightMin;
        this.lineWeightMax = lineWeightMax;
        this.action = action;
    }

    protected Rod() {
    }

    @Column(name = "type")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Column(name = "lure_weight_min")
    public float getLureWeightMin() {
        return lureWeightMin;
    }

    public void setLureWeightMin(float lureWeightMin) {
        this.lureWeightMin = lureWeightMin;
    }

    @Column(name = "lure_weight_max")
    public float getLureWeightMax() {
        return lureWeightMax;
    }

    public void setLureWeightMax(float lureWeightMax) {
        this.lureWeightMax = lureWeightMax;
    }

    @Column(name = "power")
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Column(name = "line_weight_min")
    public float getLineWeightMin() {
        return lineWeightMin;
    }

    public void setLineWeightMin(float lineWeightMin) {
        this.lineWeightMin = lineWeightMin;
    }

    @Column(name = "line_weight_max")
    public float getLineWeightMax() {
        return lineWeightMax;
    }

    public void setLineWeightMax(float lineWeightMax) {
        this.lineWeightMax = lineWeightMax;
    }

    @Column(name = "action")
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
