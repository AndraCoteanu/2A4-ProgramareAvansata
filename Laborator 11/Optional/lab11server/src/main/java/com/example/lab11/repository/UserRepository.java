package com.example.lab11.repository;

import com.example.lab11.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <h3> Interfata UserRepository </h3>
 * <p> Interfata contine functii predefinite in SpringBoot pentru operatii pe baze de date. </p>
 */
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findAll();

    <A extends User> A save(A entity);

    User getUserByIdUser(short idUser);

    void deleteUserByIdUser(short idUser);
}