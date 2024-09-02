package org.example.fishingconfig47.entities;

import jakarta.persistence.*;
import org.example.fishingconfig47.exceptions.*;

@Entity
@Table(name = "fishing_set")
public class FishingKit extends BaseEntity {
    private String name;
    private Rod rod;
    private Reel reel;
    private Line line;
    private Lure lure;
    private float fishWeight;
    private int fishCount;


    public FishingKit(String name, Rod rod, Reel reel, Line line, Lure lure, float fishWeight,
                      int fishCount) {
        setName(name);
        setRod(rod);
        setReel(reel, line);
        setLine(line);
        setLure(lure, rod);
        setFishWeight(fishWeight);
        setFishCount(fishCount);
    }

    protected FishingKit() {
    }

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null) {
            throw new IllegalNameException("Name cannot be null");
        }
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

    protected void setReel(Reel reel) {
        this.reel = reel;
    }

    public void setReel(Reel reel, Line line) {
        if (reel == null) {
            throw new ReelNotFoundException("Reel cannot be null");

        } else if (line.getTestWidth() > reel.getMaxDrag()) {
            throw new IllegalLineException("Нагрузка лески не должна превышать мощность фрикциона");
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
            throw new LineNotFoundException("Line cannot be null");
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
            throw new LureNotFoundException("Lure cannot be null");
        } else if (lure.getWeight() < rod.getLureWeightMin() || lure.getWeight() > rod.getLureWeightMax()) {
            throw new IllegalLureException("Масса приманки должна быть в диапазоне теста удилища");
        }
        this.lure = lure;
    }

    @Column(name = "fish_weight")
    public float getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(float fishWeight) {
        if (fishWeight < 0) {
            throw new IllegalFishWeightException("Вес рыбы не может быть отрицательным");
        }
        this.fishWeight = fishWeight;
    }

    @Column(name = "fish_count")
    public int getFishCount() {
        return fishCount;
    }

    public void setFishCount(int fishCount) {
        if (fishCount < 0) {
            throw new IllegalFishCountException("Количество рыб не может быть отрицательным");
        }
        this.fishCount = fishCount;
    }
}
