package az.pkg.buildit.service;


import az.pkg.buildit.entity.PlantHireRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PlantHireRequestService {

    @PersistenceContext(unitName = "default")
    private EntityManager em;

    public void create(PlantHireRequest phr){
        em.persist(phr);
    }

    public PlantHireRequest find(long id){
        return em.find(PlantHireRequest.class, id);
    }

    public void modify(PlantHireRequest phr){
        em.merge(phr);
    }
}
