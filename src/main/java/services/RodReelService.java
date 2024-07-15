package services;

import entities.Reel;
import entities.Rod;

public interface RodReelService {
    boolean existsRodAndReel(Rod rod, Reel reel);
}
