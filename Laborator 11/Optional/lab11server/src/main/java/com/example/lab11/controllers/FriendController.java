package com.example.lab11.controllers;

import com.example.lab11.entities.Friend;
import com.example.lab11.entities.User;
import com.example.lab11.services.FriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <h3> Clasa FriendController </h3>
 * <p> Clasa se foloseste de metodele din FriendService pentru a defini metode pentru requesturi HTTP. </p>
 */
@RestController
@RequestMapping("friends")
public class FriendController {
    @Autowired
    private FriendService friendService;

//    public FriendController(FriendService friendService) {
//        this.friendService = friendService;
//    }

    @RequestMapping(method = RequestMethod.GET, value = "/{idUser}")
    public List<Friend> getUserFriendList(@PathVariable short idUser) {
        return friendService.getAllFriends(idUser);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/")
    public Friend addFriend(@RequestBody Friend friend) {
        return friendService.addFriend(friend);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{idUser}/{idFriend}")
    public void deleteFriend(@PathVariable short idUser, @PathVariable short idFriend) {
        friendService.deleteFriend(idUser, idFriend);
    }
}
