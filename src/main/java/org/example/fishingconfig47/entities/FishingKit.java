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

//    public FishingKit(String name, Rod rod, Reel reel, Line line, Lure lure, Float fishWeight, Integer fishCount, RodReelService rodReelService) {
//        try {
//            this.rodReelService = rodReelService;
//            if (rod == null || reel == null || line == null || lure == null || fishWeight == null) {
//                throw new NullPointerException();
//            }
//            validateSet(rod, reel, line, lure);
//            this.name = name;
//            this.rod = rod;
//            this.reel = reel;
//            this.line = line;
//            this.lure = lure;
//            this.fishWeight = fishWeight;
//            this.fishCount = fishCount;
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    public FishingKit(String name, Rod rod, Reel reel, Line line, Lure lure, Float fishWeight, Integer fishCount, RodReelService rodReelService) {
        this.rodReelService = rodReelService;
        this.name = name;
        this.rod = rod;
        this.reel = reel;
        this.line = line;
        this.lure = lure;
        this.fishWeight = fishWeight;
        this.fishCount = fishCount;
    }

    protected FishingKit() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "rod_id")
    public Rod getRod() {
        return rod;
    }

    public void setRod(Rod rod) {
        this.rod = rod;
    }

    @ManyToOne
    @JoinColumn(name = "reel_id")
    public Reel getReel() {
        return reel;
    }

    public void setReel(Reel reel) {
        this.reel = reel;
    }

    @ManyToOne
    @JoinColumn(name = "line_id")
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @ManyToOne
    @JoinColumn(name = "lure_id")
    public Lure getLure() {
        return lure;
    }

    public void setLure(Lure lure) {
        this.lure = lure;
    }

    @Column(name = "fish_weight")
    public float getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(float fishWeight) {
        this.fishWeight = fishWeight;
    }

    @Column(name = "fish_count")
    public int getFishCount() {
        return fishCount;
    }

    public void setFishCount(int fishCount) {
        this.fishCount = fishCount;
    }

    private void validateSet(Rod rod, Reel reel, Line line, Lure lure) {
        if (fishWeight == null || fishCount == null || fishCount < 0 || fishWeight < 0) {
            this.fishWeight = 0f;
            this.fishCount = 0;
        }
        if (!rodReelService.existsRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("Эта комбинация удилища и катушки недопустима");
        }
        if (line.getTestWidth() > reel.getMaxDrag()) {
            throw new IllegalArgumentException("Нагрузка лески не должна превышать мощность фрикциона");
        }
        if (lure.getWeight() < rod.getLureWeightMin() || lure.getWeight() > rod.getLureWeightMax()) {
            throw new IllegalArgumentException("Масса приманки должна быть в диапазоне теста удилища");
        }
    }
}
