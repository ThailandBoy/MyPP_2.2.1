package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   void add(Car car);
   User getUserByCarModelSeries(String car_model, int series);
   List<User> listUsers();
   List<Car> listCar();
}
