package org.example.fishingconfig47.DTO;

public class FishingKitDto {
    private String name;
    private Integer rodId;
    private Integer reelId;
    private Integer lineId;
    private Integer lureId;
    private Float fishWeight;
    private Integer fishCount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRodId() {
        return rodId;
    }

    public void setRodId(Integer rodId) {
        this.rodId = rodId;
    }

    public Integer getReelId() {
        return reelId;
    }

    public void setReelId(Integer reelId) {
        this.reelId = reelId;
    }

    public Integer getLineId() {
        return lineId;
    }

    public void setLineId(Integer lineId) {
        this.lineId = lineId;
    }

    public Integer getLureId() {
        return lureId;
    }

    public void setLureId(Integer lureId) {
        this.lureId = lureId;
    }

    public Float getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(Float fishWeight) {
        this.fishWeight = fishWeight;
    }

    public Integer getFishCount() {
        return fishCount;
    }

    public void setFishCount(Integer fishCount) {
        this.fishCount = fishCount;
    }
}
