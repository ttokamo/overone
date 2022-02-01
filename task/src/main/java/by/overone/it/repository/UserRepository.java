package by.overone.it.repository;

import by.overone.it.pojo.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface UserRepository extends CrudRepository<User, String> {

    @Query("from User where email =:email")
    User getUserByEmail(@Param("email") String email);

    @Query("from User where email =:email and password =:password")
    User getUserByEmailAndPassword(@Param("email") String email, @Param("password") String password);

    @Query("from User where id =:id")
    User getUserById(@Param("id") String id);
}
