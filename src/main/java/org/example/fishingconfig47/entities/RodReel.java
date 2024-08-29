package org.example.fishingconfig47.entities;

import jakarta.persistence.*;
import org.example.fishingconfig47.services.impl.RodReelServiceImpl;

@Entity
@Table(name = "rod_reel")
public class RodReel extends BaseEntity {
    private Rod rod;
    private Reel reel;

    @Transient
    private RodReelServiceImpl rodReelService;

    public RodReel(Rod rod, Reel reel) {
        setRod(rod);
        setReel(reel);
    }

    protected RodReel() {
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
}
