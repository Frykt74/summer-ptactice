package entities;


import jakarta.persistence.*;

// Удилища
@Entity
@Table
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
    //    Колен
    private int pieces;
    //    Колец
    private int guides;

    public Rod(String type, int length, float lureWeightMin, float lureWeightMax, String power, float lineWeightMin,
               float lineWeightMax, String action, int pieces, int guides) {
        this.type = type;
        this.length = length;
        this.lureWeightMin = lureWeightMin;
        this.lureWeightMax = lureWeightMax;
        this.power = power;
        this.lineWeightMin = lineWeightMin;
        this.lineWeightMax = lineWeightMax;
        this.action = action;
        this.pieces = pieces;
        this.guides = guides;
    }

    protected Rod() {
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Column
    public float getLureWeightMin() {
        return lureWeightMin;
    }

    public void setLureWeightMin(float lureWeightMin) {
        this.lureWeightMin = lureWeightMin;
    }

    @Column
    public float getLureWeightMax() {
        return lureWeightMax;
    }

    public void setLureWeightMax(float lureWeightMax) {
        this.lureWeightMax = lureWeightMax;
    }

    @Column
    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    @Column
    public float getLineWeightMin() {
        return lineWeightMin;
    }

    public void setLineWeightMin(float lineWeightMin) {
        this.lineWeightMin = lineWeightMin;
    }

    @Column
    public float getLineWeightMax() {
        return lineWeightMax;
    }

    public void setLineWeightMax(float lineWeightMax) {
        this.lineWeightMax = lineWeightMax;
    }

    @Column
    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Column
    public int getPieces() {
        return pieces;
    }

    public void setPieces(int pieces) {
        this.pieces = pieces;
    }

    @Column
    public int getGuides() {
        return guides;
    }

    public void setGuides(int guides) {
        this.guides = guides;
    }
}
