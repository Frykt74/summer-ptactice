package DTO;

import lombok.Data;

@Data
public class FishingSetDto {
    private String name;
    private Integer rodId;
    private Integer reelId;
    private Integer lineId;
    private Integer lureId;
    private float fishWeight;
    private int fishCount;
}
