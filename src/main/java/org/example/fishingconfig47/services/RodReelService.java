package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;

public interface RodReelService {
    boolean existsPairOfRodAndReel(Rod rod, Reel reel);
}
