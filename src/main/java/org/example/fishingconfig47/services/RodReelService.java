package org.example.fishingconfig47.services;

import org.example.fishingconfig47.entities.Reel;
import org.example.fishingconfig47.entities.Rod;
import org.example.fishingconfig47.entities.RodReel;

public interface RodReelService {
    RodReel savePairOfRodAndReel(Rod rod, Reel reel);
}
