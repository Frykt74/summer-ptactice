package org.example.fishingconfig47.entities;

import jakarta.persistence.*;
import org.example.fishingconfig47.services.RodReelService;

@Entity
@Table(name = "fishing_set")
public class FishingKit extends BaseEntity {
    private String name;
    private Rod rod;
    private Reel reel;
    private Line line;
    private Lure lure;
    private Float fishWeight;
    private Integer fishCount;

    @Transient
    private RodReelService rodReelService;

    public FishingKit(String name, Rod rod, Reel reel, Line line, Lure lure,Float fishWeight,
                      Integer fishCount,RodReelService rodReelService) {
        this.rodReelService = rodReelService;
        setName(name);
        setRod(rod, reel);
        setReel(reel, line);
        setLine(line);
        setLure(lure, rod);
        setFishWeight(fishWeight);
        setFishCount(fishCount);
    }
//TODO
    public FishingKit() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "rod_id")
    public Rod getRod() {
        return rod;
    }

    protected void setRod(Rod rod) {
        this.rod = rod;
    }

    public void setRod(Rod rod, Reel reel) {
        if (rod == null) {
            throw new IllegalArgumentException("Rod cannot be null");
        } else if (!rodReelService.existsPairOfRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("Pair of Rod and Reel cannot be found");
        }
        this.rod = rod;
    }

    @ManyToOne
    @JoinColumn(name = "reel_id")
    public Reel getReel() {
        return reel;
    }

    protected void setReel(Reel reel) {
        this.reel = reel;
    }

    public void setReel(Reel reel, Line line) {
        if (reel == null) {
            throw new IllegalArgumentException("Reel cannot be null");
        } else if (line.getTestWidth() > reel.getMaxDrag()) {
            throw new IllegalArgumentException("Нагрузка лески не должна превышать мощность фрикциона");
        }
        this.reel = reel;
    }

    @ManyToOne
    @JoinColumn(name = "line_id")
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        if (line == null) {
            throw new IllegalArgumentException("Line cannot be null");
        }
        this.line = line;
    }

    @ManyToOne
    @JoinColumn(name = "lure_id")
    public Lure getLure() {
        return lure;
    }

    protected void setLure(Lure lure) {
        this.lure = lure;
    }

    public void setLure(Lure lure, Rod rod) {
        if (lure == null) {
            throw new IllegalArgumentException("Lure cannot be null");
        } else if (lure.getWeight() < rod.getLureWeightMin() || lure.getWeight() > rod.getLureWeightMax()) {
            throw new IllegalArgumentException("Масса приманки должна быть в диапазоне теста удилища");
        }
        this.lure = lure;
    }

    @Column(name = "fish_weight")
    public float getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(float fishWeight) {
        if (fishWeight < 0) {
            throw new IllegalArgumentException("Fish weight cannot be negative");
        }
        this.fishWeight = fishWeight;
    }

    @Column(name = "fish_count")
    public int getFishCount() {
        return fishCount;
    }

    public void setFishCount(int fishCount) {
        if (fishCount < 0) {
            throw new IllegalArgumentException("Fish count cannot be negative");
        }
        this.fishCount = fishCount;
    }
}
