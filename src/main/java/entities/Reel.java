package entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "reel")
public class Reel extends BaseElementEntity {
    private String type;
    //    Передаточное Число
    private String gearRatio;
    //    Скорость Подмотки
    private int recovery;
    //    Мощность Фрикциона
    private float maxDrag;
    private int weight;

    public Reel(String type, String gearRatio, int recovery, float maxDrag, int weight) {
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
}
