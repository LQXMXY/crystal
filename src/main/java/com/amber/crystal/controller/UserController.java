package com.amber.crystal.controller;

import com.amber.crystal.repository.UserRepository;
import com.amber.crystal.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/users")
public class UserController {
    @Resource
    private UserRepository userRepository;

    static Map<Integer, User> userMap =
            Collections.synchronizedMap(new HashMap<Integer, User>());

    @RequestMapping(value = "/", method= RequestMethod.GET)
    public List<User> getUserList(){
        return new ArrayList<User>(userMap.values());
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String postUser(@ModelAttribute User user){
        userMap.put(user.getId(), user);
        userRepository.save(user);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getUser(@PathVariable Integer id){
        return userMap.get(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String putUser(@PathVariable Integer id, @ModelAttribute User user){
        User modifyUser = userMap.get(id);
        modifyUser.setUsername(user.getUsername());
        modifyUser.setPassword(user.getPassword());
        userMap.put(id, modifyUser);
        return "success";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Integer id){
        userMap.remove(id);
        return "success";
    }
}
