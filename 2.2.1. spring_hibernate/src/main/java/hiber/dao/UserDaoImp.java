package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
      TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   // HQL - ЧУВСТВИТЕЛЕН К РЕГИСТРУ!!!!!!
   @Override
   @SuppressWarnings("unchecked")
   public User get_user_by_car_model_series(String car_model, int series) {
      TypedQuery<User> query = sessionFactory.getCurrentSession()
              .createQuery("from User u join fetch u.car " +
                      "where u.car.model= :car_model and u.car.series= :series");
      query.setParameter("car_model", car_model);
      query.setParameter("series", series);
      return query.getSingleResult();
   }

}
