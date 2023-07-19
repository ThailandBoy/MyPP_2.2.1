package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "name")
   private String firstName;

   @Column(name = "last_name")
   private String lastName;

   @Column(name = "email")
   private String email;

   // CascadeType.ALL will perform all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH)
   // to the related entities/collection e.g. when User will be Persisted, Car will also be Persisted.
   // Так как связть OneToOne то запись ниже приемлема, но если OneToMany или ManyToMany так делать не надо
   // Тоесть!: если OneToMany или ManyToMany - FetchType.LAZY
   //          если OneToOne, ManyToOne - FetchType.EAGER
   @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
   @JoinColumn(name = "car_id", referencedColumnName = "id")
   private Car car;


   public User() {}
   
   public User(String firstName, String lastName, String email, Car car) {
      this.firstName = firstName;
      this.lastName = lastName;
      this.email = email;
      this.car = car;
   }


   public Long getId() {
      return id;
   }

   public Car getCar() {
      return car;
   }

   public String getFirstName() {
      return firstName;
   }

   public void setFirstName(String firstName) {
      this.firstName = firstName;
   }

   public String getLastName() {
      return lastName;
   }

   public void setLastName(String lastName) {
      this.lastName = lastName;
   }

   public String getEmail() {
      return email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   @Override
   public String toString() {
      return "User [id= " + id + ", firstName= " + firstName + ", lastName= " + lastName + ", email= " + email + ", car= "
            + car + "]";
   }

}
