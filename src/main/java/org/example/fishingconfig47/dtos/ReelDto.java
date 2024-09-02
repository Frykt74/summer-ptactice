package org.example.fishingconfig47.dtos;

public class ReelDto {
    private int id;
    private String type;
    private String gearRatio;
    private int recovery;
    private float maxDrag;
    private int weight;
    private String description;
    private int price;
    private String name;

    public ReelDto(String type, String gearRatio, int recovery, float maxDrag,
                   int weight, String description, int price, String name) {
        this.type = type;
        this.gearRatio = gearRatio;
        this.recovery = recovery;
        this.maxDrag = maxDrag;
        this.weight = weight;
        this.description = description;
        this.price = price;
        this.name = name;
    }

    protected ReelDto() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGearRatio() {
        return gearRatio;
    }

    public void setGearRatio(String gearRatio) {
        this.gearRatio = gearRatio;
    }

    public int getRecovery() {
        return recovery;
    }

    public void setRecovery(int recovery) {
        this.recovery = recovery;
    }

    public float getMaxDrag() {
        return maxDrag;
    }

    public void setMaxDrag(float maxDrag) {
        this.maxDrag = maxDrag;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
