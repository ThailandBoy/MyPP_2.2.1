package hiber.dao;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);

   User get_user_by_car_model_series(String car_model, int series);

   List<User> listUsers();

}
