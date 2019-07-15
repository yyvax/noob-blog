package com.nooblog.controller;

import com.nooblog.model.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/users")
public class UserController {

    static private Map<Long, User> userMap = new ConcurrentHashMap<>();

    @ApiOperation(value = "Get User list")
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        return new ArrayList<>(userMap.values());
    }

    @ApiOperation(value = "Create User")
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createUser(@ModelAttribute User user) {
        userMap.put(user.getId(), user);
        return user.getName();
    }

    @ApiOperation(value = "Update User", notes = "If not existed, create")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String updateUser(@PathVariable Long id, @ModelAttribute User user) {
        if (userMap.containsKey(id)) {
            userMap.put(id, user);
            return "Updated. New model: " + user.getName();
        }
        else {
            userMap.put(id, user);
            return "No model existed. Created model: " + user.getName();
        }
    }

    @ApiOperation(value = "Delete User")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable Long id) {
        if (userMap.containsKey(id)) {
            userMap.remove(id);
            return "Deleted model: " + id;
        }
        else {
            return "User " + id + " doesn't exist.";
        }
    }

    @PostMapping(value = "/user", consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public User create(@RequestBody User user) {
        user.setId(user.getId());
        user.setName(user.getName());
        user.setPassword(user.getPassword());
        return user;
    }
}
