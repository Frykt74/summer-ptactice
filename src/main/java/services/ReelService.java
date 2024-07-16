package services;

import entities.Reel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.ReelRepository;

@Service
public class ReelService {

    @Autowired
    private ReelRepository reelRepository;

    public Reel getReelById(Integer id) {
        return reelRepository.findReelById(id);
    }
}
