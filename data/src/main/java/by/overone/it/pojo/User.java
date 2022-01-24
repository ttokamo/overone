package by.overone.it.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER")
@NoArgsConstructor
@Getter
public class User {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid")
    private String id;

    @Column(name = "FIRST_NAME")
    @Setter
    private String firstName;

    @Column(name = "SECOND_NAME")
    @Setter
    private String secondName;

    @Column(name = "EMAIL")
    @Setter
    private String email;

    @Column(name = "ADDRESS")
    @Setter
    private String address;

    @Column(name = "TELEPHONE")
    @Setter
    private String telephone;

    @Column(name = "PASSWORD")
    @Setter
    private String password;

    @Column(name = "CREATE_DATE")
    @Setter
    private LocalDateTime createDate;
}
