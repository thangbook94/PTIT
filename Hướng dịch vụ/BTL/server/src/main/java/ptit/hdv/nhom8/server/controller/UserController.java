package ptit.hdv.nhom8.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ptit.hdv.nhom8.server.entity.User;
import ptit.hdv.nhom8.server.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User user2 = userRepository.getByUsername(user.getUsername());
        if (user2 != null && user2.getPassword().equals(user.getPassword()))
            return new ResponseEntity<User>(user2, HttpStatus.OK);
        else return null;
    }

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        User user2 = userRepository.getByUsername(user.getUsername());
        if (user2 != null) {
            return "not ok";
        }
        try {
            userRepository.save(user);
            return "ok";
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "not ok";
    }

    @PostMapping("/editProfile")
    public String editProfile(@RequestBody User user) {
        try {
            userRepository.save(user);
            return "ok";
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        return "not ok";
    }
}
