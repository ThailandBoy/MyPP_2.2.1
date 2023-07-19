package hiber.dao;

import hiber.model.Car;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao{

    @Autowired
    SessionFactory sessionFactory;
    @Override
    @SuppressWarnings("unchecked")
    public List<Car> listCar() {
        // что за TypedQuery?
        TypedQuery<Car> query = sessionFactory.getCurrentSession()
                .createQuery("select c from Car c join fetch c.user");
        return query.getResultList();
    }
}
