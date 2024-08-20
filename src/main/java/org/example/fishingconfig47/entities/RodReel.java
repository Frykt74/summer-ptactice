package org.example.fishingconfig47.entities;

import jakarta.persistence.*;
import org.example.fishingconfig47.services.RodReelService;

@Entity
@Table(name = "rod_reel")
public class RodReel extends BaseEntity {
    private Rod rod;
    private Reel reel;

    @Transient
    private RodReelService rodReelService;

    public RodReel(Rod rod, Reel reel) {
        setRod(rod, reel);
        setReel(reel);
    }

    protected RodReel() {
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
        if (rodReelService.existsPairOfRodAndReel(rod, reel)) {
            throw new IllegalArgumentException("Rod and Reel already exists");
        }
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
