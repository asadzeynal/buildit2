package az.pkg.buildit.service;

import az.pkg.buildit.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserService {

    @PersistenceContext(unitName = "default")
    private EntityManager em;


    public User findUserByUserName(String username){
        User user = (User) em.createQuery("select u from Worker u where username = :username")
                .setParameter("username", username)
                .getSingleResult();
        return user;
    }
}
