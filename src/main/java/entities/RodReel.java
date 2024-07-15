package entities;

import jakarta.persistence.*;

@Entity
@Table(name = "rod_reel")
public class RodReel {
    private RodReelId id;
    private Rod rod;
    private Reel reel;

    public RodReel(RodReelId id, Rod rod, Reel reel) {
        this.id = id;
        this.rod = rod;
        this.reel = reel;
    }

    protected RodReel() {
    }

    @EmbeddedId
    public RodReelId getId() {
        return id;
    }

    @ManyToOne
    @MapsId("rodId")
    @JoinColumn(name = "rod_id")
    public Rod getRod() {
        return rod;
    }

    public void setRod(Rod rod) {
        this.rod = rod;
    }

    @ManyToOne
    @MapsId("reelId")
    @JoinColumn(name = "reel_id")
    public Reel getReel() {
        return reel;
    }

    public void setReel(Reel reel) {
        this.reel = reel;
    }
}
