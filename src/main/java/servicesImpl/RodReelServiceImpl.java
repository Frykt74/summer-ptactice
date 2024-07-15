package servicesImpl;

import entities.Reel;
import entities.Rod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RodReelRepository;
import services.RodReelService;

@Service
public class RodReelServiceImpl implements RodReelService {

    @Autowired
    private RodReelRepository rodReelRepository;

    @Override
    public boolean existsRodAndReel(Rod rod, Reel reel) {
        return rodReelRepository.existsRodAndReel(rod, reel);
    }
}
