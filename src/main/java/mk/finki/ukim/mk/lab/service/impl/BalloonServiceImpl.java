import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.repository.BalloonRepository;
import mk.finki.ukim.mk.lab.service.BalloonService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BalloonServiceImpl implements BalloonService {
    private final BalloonRepository balloonRepository;

    public BalloonServiceImpl(BalloonRepository balloonRepository) {
        this.balloonRepository = balloonRepository;
    }

    @Override
    public List<Balloon> listAll() {
        return balloonRepository.findAllBalloons();
    }

    @Override
    public List<Balloon> searchByNameOrDescription(String text) {
        return balloonRepository.findAllByNameOrDescription(text);
    }
    public int getListSize(){
        return balloonRepository.size();
    }
    public Balloon getColor(String name){
        if (name==null || name.isEmpty()){
            throw new IllegalArgumentException();
        }
        Balloon b = new Balloon(name);
        balloonRepository.chooseColor(b);
        return b;
    }
    public Balloon getLastElement(){
        return balloonRepository.chooseLastElement();
    }
}
