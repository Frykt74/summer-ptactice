package entities;

import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class RodReelKey implements java.io.Serializable {
    private int rodId;
    private int reelId;

    public RodReelKey(int rodId, int reelId) {
        this.rodId = rodId;
        this.reelId = reelId;
    }

    public RodReelKey() {

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
        RodReelKey rodReelKey = (RodReelKey) o;
        return rodId == rodReelKey.rodId && reelId == rodReelKey.reelId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rodId, reelId);
    }
}
