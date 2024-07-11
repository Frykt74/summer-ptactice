package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Reel extends BaseElementEntity {
    private String type;
    private String model;
    //    Передаточное Число
    private String gearRatio;
    //    Скорость Подмотки
    private int recovery;
    //    Емкость Шпули
    private String lineCapacity;
    //    Мощность Фрикциона
    private float maxDrag;
    //    Подшипники
    private int ballBearings;
    private int weight;

    public Reel(String type, String model, String gearRatio, int recovery, String lineCapacity, float maxDrag, int ballBearings, int weight) {
        this.type = type;
        this.model = model;
        this.gearRatio = gearRatio;
        this.recovery = recovery;
        this.lineCapacity = lineCapacity;
        this.maxDrag = maxDrag;
        this.ballBearings = ballBearings;
        this.weight = weight;
    }

    protected Reel() {
    }

    @Column
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column
    public String getGearRatio() {
        return gearRatio;
    }

    public void setGearRatio(String gearRatio) {
        this.gearRatio = gearRatio;
    }

    @Column
    public int getRecovery() {
        return recovery;
    }

    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }

    @Column
    public String getLineCapacity() {
        return lineCapacity;
    }

    public void setLineCapacity(String lineCapacity) {
        this.lineCapacity = lineCapacity;
    }

    @Column
    public float getMaxDrag() {
        return maxDrag;
    }

    public void setMaxDrag(float maxDrag) {
        this.maxDrag = maxDrag;
    }

    @Column
    public int getBallBearings() {
        return ballBearings;
    }

    public void setBallBearings(int ballBearings) {
        this.ballBearings = ballBearings;
    }

    @Column
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
}
