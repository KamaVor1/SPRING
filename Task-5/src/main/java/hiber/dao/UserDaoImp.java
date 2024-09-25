package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {
      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   @SuppressWarnings("unchecked")
   public User getUserByCar(String model, int series) {
      Query query = sessionFactory.getCurrentSession().createQuery("FROM User WHERE car IS NOT NULL AND car.model = ?1 AND car.series = ?2");
      query.setParameter(1,model);
      query.setParameter(2,series);
      List<User> users = query.getResultList();
      User user = users.get(0);
      if (users.isEmpty()) {
         return null;
      }
      return user;
   }

}
