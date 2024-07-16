package entities;

import jakarta.persistence.*;
import services.RodReelService;

@Entity
@Table(name = "fishing_set")
public class FishingSet extends BaseEntity {
    private String name;
    private Rod rod;
    private Reel reel;
    private Line line;
    private Lure lure;
    private float fishWeight;
    private int fishCount;
    private int totalCost;

    @Transient
    private RodReelService rodReelService;

    public FishingSet(String name, Rod rod, Reel reel, Line line, Lure lure, float fishWeight, int fishCount) {
        this.name = name;
        this.rod = rod;
        this.reel = reel;
        this.line = line;
        this.lure = lure;
        this.fishWeight = fishWeight;
        this.fishCount = fishCount;
        validateSet();
        this.totalCost = rod.getPrice() + reel.getPrice() + line.getPrice() + lure.getPrice();;
    }

    protected FishingSet() {
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
        calculateTotalCost();
    }

    @ManyToOne
    @JoinColumn(name = "reel_id")
    public Reel getReel() {
        return reel;
    }

    public void setReel(Reel reel) {
        this.reel = reel;
        calculateTotalCost();
    }

    @ManyToOne
    @JoinColumn(name = "line_id")
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
        calculateTotalCost();
    }

    @ManyToOne
    @JoinColumn(name = "lure_id")
    public Lure getLure() {
        return lure;
    }

    public void setLure(Lure lure) {
        this.lure = lure;
        calculateTotalCost();
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

    @Column(name = "total_cost")
    public int getTotalCost() {
        return totalCost;
    }

    private void calculateTotalCost() {
        this.totalCost = rod.getPrice() + reel.getPrice() + line.getPrice() + lure.getPrice();
    }

    private void validateSet() {
        if (rod != null && reel != null) {
            if (!rodReelService.existsRodAndReel(rod, reel)) {
                throw new IllegalArgumentException("Эта комбинация удилища и катушки недопустима");
            }
        }
        if (line != null && reel != null) {
            if (line.getTestWidth() > reel.getMaxDrag()) {
                throw new IllegalArgumentException("Нагрузка лески не должна превышать мощность фрикциона");
            }
        }
        if (rod != null && lure != null) {
            if (lure.getWeight() < rod.getLureWeightMin() || lure.getWeight() > rod.getLureWeightMax()) {
                throw new IllegalArgumentException("Масса приманки должна быть в диапазоне теста удилища");
            }
        } else
            throw new NullPointerException();
    }
}
