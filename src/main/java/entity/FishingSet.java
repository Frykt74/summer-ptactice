package entity;

import jakarta.persistence.*;

@Entity
@Table
public class FishingSet {
    private int id;
    private String name;
    private Rod rod;
    private Reel reel;
    private Line line;
    private Lure lure;
    private float fishWeight;
    private int fishCount;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    public int getId() {
        return id;
    }

    @Column
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn
    public Rod getRod() {
        return rod;
    }

    public void setRod(Rod rod) {
        this.rod = rod;
    }

    @ManyToOne
    @JoinColumn
    public Reel getReel() {
        return reel;
    }

    public void setReel(Reel reel) {
        this.reel = reel;
    }

    @ManyToOne
    @JoinColumn
    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    @ManyToOne
    @JoinColumn
    public Lure getLure() {
        return lure;
    }

    public void setLure(Lure lure) {
        this.lure = lure;
    }

    @Column
    public float getFishWeight() {
        return fishWeight;
    }

    public void setFishWeight(float fishWeight) {
        this.fishWeight = fishWeight;
    }

    @Column
    public int getFishCount() {
        return fishCount;
    }

    public void setFishCount(int fishCount) {
        this.fishCount = fishCount;
    }
}
