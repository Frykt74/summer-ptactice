package entities;

import jakarta.persistence.*;

@Entity
@Table
public class Reel {
    private int id;
    private String name;
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
