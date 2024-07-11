package entities;


import jakarta.persistence.*;

// Удилища
@Entity
@Table
public class Rod {
    private int id;
    private String name;
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
