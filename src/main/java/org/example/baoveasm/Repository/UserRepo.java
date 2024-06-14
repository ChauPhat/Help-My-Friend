package org.example.baoveasm.Repository;

import org.example.baoveasm.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, String> {
    User save(User e);

    List<User> findAll();

    User findByid(String id);

    List<User> findByRole(String role);

    @Modifying
    @Transactional
    @Query(value = "update [User] set fullname = :fullname, password = :password, email = :email, role = :role  where id = :id", nativeQuery = true)
    int updateUserByuserId(@Param("fullname") String fullname, @Param("password") String password, @Param("email") String email, @Param("role") Boolean role, @Param("id") String id);

    @Modifying
    @Transactional
    @Query(value = "delete from [User] where id = :id", nativeQuery = true)
    int deleteUserByuserId( @Param("id") String id);
}
