package az.pkg.buildit.service;

import az.pkg.buildit.entity.Plant;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PlantService {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void create(Plant plant){
        em.persist(plant);
    }

    public void edit(Plant plant){
        em.merge(plant);
    }

    public Plant find(long id){
        return em.find(Plant.class, id);
    }
}
