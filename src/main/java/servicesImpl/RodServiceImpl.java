package servicesImpl;

import entities.Rod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repositories.RodRepository;
import services.RodService;

@Service
public class RodServiceImpl implements RodService {

    @Autowired
    private RodRepository rodRepository;

    @Override
    public Rod getRodById(int id) {
        return rodRepository.findRodById(id);
    }
}
