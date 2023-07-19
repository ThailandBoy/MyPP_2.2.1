package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class); // запилил контейнер для бинов

      UserService userService = context.getBean(UserService.class); // достал бин
      CarService carService = context.getBean(CarService.class);

      Car car1 = new Car("Mark_1", 0001);
      Car car2 =  new Car("Mark_2", 0002);
      Car car3 =  new Car("Mark_3", 0003);
      Car car4 =  new Car("Mark_4", 0004);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru", car1));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru", car2));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru", car3));
      userService.add(new User("User4", "Lastname4", "user4@mail.ru", car4));

     

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car id ="+user.getCar().getId() + "\n");
      }

      carService.listCar().forEach(System.out::println);

      System.out.println(userService.get_user_by_car_model_series("Mark_2", 0002).toString());
      

      context.close();
   }
}
