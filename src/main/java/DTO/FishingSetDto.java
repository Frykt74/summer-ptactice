package DTO;

import entities.Line;
import entities.Lure;
import entities.Reel;
import entities.Rod;
import lombok.Data;

@Data
public class FishingSetDto {
    private String name;
    private Rod rod;
    private Reel reel;
    private Line line;
    private Lure lure;
    private float fishWeight;
    private int fishCount;
    private int totalCost;
}
