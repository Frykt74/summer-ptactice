package org.example.fishingconfig47.dtos;

public class FishingKitDto {
    private int id;
    private String name;
    private int rodId;
    private int reelId;
    private int lineId;
    private int lureId;
    private float fishWeight;
    private int fishCount;

    public FishingKitDto(String name, int rodId, int reelId, int lineId, int lureId, float fishWeight, int fishCount) {
        this.name = name;
        this.rodId = rodId;
        this.reelId = reelId;
        this.lineId = lineId;
        this.lureId = lureId;
        this.fishWeight = fishWeight;
        this.fishCount = fishCount;
    }

    protected FishingKitDto() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRodId() {
        return rodId;
    }

    public void setRodId(int rodId) {
        this.rodId = rodId;
    }

    public int getReelId() {
        return reelId;
    }

    public void setReelId(int reelId) {
        this.reelId = reelId;
    }

    public int getLineId() {
        return lineId;
    }

    public void setLineId(int lineId) {
        this.lineId = lineId;
    }

    public int getLureId() {
        return lureId;
    }

    public void setLureId(int lureId) {
        this.lureId = lureId;
    }

    public float getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(float fishWeight) {
        this.fishWeight = fishWeight;
    }

    public int getFishCount() {
        return fishCount;
    }

    public void setFishCount(int fishCount) {
        this.fishCount = fishCount;
    }
}
