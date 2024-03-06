package hibernate_test2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "details")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Detail {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  int id;

    @Column(name="city")
    private String city;

    @Column(name="phone_number")
    private String phoneNumber;

    @Column(name= "email")
    private String email;

    public Detail(String city, String phoneNumber, String email) {
        this.city = city;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
}
