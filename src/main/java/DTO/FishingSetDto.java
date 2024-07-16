package DTO;

import lombok.Data;

@Data
public class FishingSetDto {
    private String name;
    private int rodId;
    private int reelId;
    private int lineId;
    private int lureId;
    private float fishWeight;
    private int fishCount;
    private int totalCost;
}
