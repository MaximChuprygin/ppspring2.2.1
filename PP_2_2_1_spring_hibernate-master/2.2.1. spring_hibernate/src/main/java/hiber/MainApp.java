package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

     /* User user1 = new User ("User1", "User1", "user1@mail.ru");
      Car car1 = new Car("1", 1);
      User user2 = new User ("User2", "User2", "user2@mail.ru");
      Car car2 = new Car("2", 2);
      User user3 = new User ("User3", "User3", "user3@mail.ru");
      Car car3 = new Car("3", 3);
      User user4 = new User ("User4", "User4", "user4@mail.ru");
      Car car4 = new Car("4", 4);
      user1.setCar(car1);
      car1.setUser(user1);
      user2.setCar(car2);
      car2.setUser(user2);
      user3.setCar(car3);
      car3.setUser(user3);
      user4.setCar(car4);
      car4.setUser(user4);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);*/


      //userService.add(new User("User1", "Lastname1", "user1@mail.ru",car1));
      //userService.add(new User("User2", "Lastname2", "user2@mail.ru",car2));
      //userService.add(new User("User3", "Lastname3", "user3@mail.ru",car3));
      //userService.add(new User("User4", "Lastname4", "user4@mail.ru",car4));


      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("model = "+user.getCar().getModel());
         System.out.println("series = "+user.getCar().getSeries());
         System.out.println();
      }
      System.out.println(userService.getUserByModelAndSeria("1"));

      context.close();
   }
}
