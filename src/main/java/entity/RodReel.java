package entity;

import jakarta.persistence.*;

@Entity
@Table
public class RodReel {
    private RodReelId id;
    private Rod rod;
    private Reel reel;

    @EmbeddedId
    public RodReelId getId() {
        return id;
    }

    public void setId(RodReelId id) {
        this.id = id;
    }

    @ManyToOne
    @MapsId("rodId")
    @JoinColumn
    public Rod getRod() {
        return rod;
    }

    public void setRod(Rod rod) {
        this.rod = rod;
    }

    @ManyToOne
    @MapsId("reelId")
    @JoinColumn
    public Reel getReel() {
        return reel;
    }

    public void setReel(Reel reel) {
        this.reel = reel;
    }
}
