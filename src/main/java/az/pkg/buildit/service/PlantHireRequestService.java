package az.pkg.buildit.service;


import az.pkg.buildit.entity.PlantHireRequest;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

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
    public List<PlantHireRequest> findAll(){
        return em.createQuery("select p from PlantHireRequest p").getResultList();
    }


    public void modify(PlantHireRequest phr){
        em.merge(phr);
    }
}
