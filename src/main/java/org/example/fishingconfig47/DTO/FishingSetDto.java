package org.example.fishingconfig47.DTO;

import lombok.Data;

@Data
public class FishingSetDto {
    private String name;
    private Integer rodId;
    private Integer reelId;
    private Integer lineId;
    private Integer lureId;
    private Float fishWeight;
    private Integer fishCount;
}
