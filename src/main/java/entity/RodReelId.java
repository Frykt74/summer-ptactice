package entity;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class RodReelId implements java.io.Serializable {
    private int rodId;
    private int reelId;

    public RodReelId(int rodId, int reelId) {
        this.rodId = rodId;
        this.reelId = reelId;
    }

    public RodReelId() {

    }

    public int getRodId() {
        return rodId;
    }

    public void setRodId(int rodId) {
        this.rodId = rodId;
    }

    public int getReelId() {
        return reelId;
    }

    public void setReelId(int reelId) {
        this.reelId = reelId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RodReelId rodReelId = (RodReelId) o;
        return rodId == rodReelId.rodId && reelId == rodReelId.reelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rodId, reelId);
    }
}
