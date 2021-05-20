package com.example.lab11.services;

import com.example.lab11.entities.Friend;
import com.example.lab11.entities.User;
import com.example.lab11.repository.FriendRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.lab11.repository.UserRepository;

import java.util.List;

/**
 * <h3> Clasa FriendService </h3>
 * <p> Se creaza functii cu ajutorul metodelor din interfata FriendRepository pentru cerintele din enunt. </p>
 */
@Service
public class FriendService {
    private final FriendRepository friendRepository;

    @Autowired
    public FriendService(FriendRepository friendRepository) {
        this.friendRepository = friendRepository;
    }

    public List<Friend> getAllFriends(short idUser) {
        return friendRepository.findAllbyId(idUser);
    }

    public Friend addFriend(Friend friend) {
        friendRepository.save(friend);
        return friend;
    }

    public void deleteFriend(short idUser, short idFriend) {
        Friend friend = friendRepository.getFriendById(idUser);
        friendRepository.deleteFriendByIdFriend(friend.getIdUser());
    }
}
