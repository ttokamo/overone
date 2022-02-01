package by.overone.it.pojo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Component
@Scope("prototype")
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "first_name")
    @Setter
    private String firstName;

    @Column(name = "second_name")
    @Setter
    private String secondName;

    @Column(name = "email")
    @Setter
    private String email;

    @Column(name = "address")
    @Setter
    private String address;

    @Column(name = "telephone")
    @Setter
    private String telephone;

    @Column(name = "password")
    @Setter
    private String password;

    @Column(name = "create_date")
    @Setter
    private LocalDateTime createDate;
}
