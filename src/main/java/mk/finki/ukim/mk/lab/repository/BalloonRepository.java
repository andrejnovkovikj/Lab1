package mk.finki.ukim.mk.lab.repository;


import mk.finki.ukim.mk.lab.model.Balloon;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class BalloonRepository {



    List<Balloon> balloon = new ArrayList<>(10);

    @PostConstruct
    public void init(){
        this.balloon.add(new Balloon("Red","Balloon"));
        this.balloon.add(new Balloon("Grey","Balloon"));
        this.balloon.add(new Balloon("Blue","Balloon"));
        this.balloon.add(new Balloon("Green","Balloon"));
    }

    public List<Balloon> findAllBalloons() {
        return balloon;
    }

    public List<Balloon> findAllByNameOrDescription(String text) {
        return balloon.stream().filter(r->r.getName().contains(text) || r.getDescription().contains(text)).collect(Collectors.toList());
    }











}
