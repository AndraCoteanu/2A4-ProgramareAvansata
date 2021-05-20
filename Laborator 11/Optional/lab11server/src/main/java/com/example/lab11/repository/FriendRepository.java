package com.example.lab11.repository;

import com.example.lab11.entities.Friend;
import com.example.lab11.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

/**
 * <h3> Interfata FriendRepository </h3>
 * <p> Interfata contine functii predefinite in SpringBoot pentru operatii pe baze de date. </p>
 */
@Repository
@Transactional
public interface FriendRepository extends JpaRepository<Friend, Integer> {
    List<Friend> findAllbyId(short idUser);

    <A extends Friend> A save(A entity);

    Friend getFriendById(short idUser);

    void deleteFriendByIdFriend(short idFriend);
}