package app.login.api.controller;

import app.login.api.model.RegisterRequest;
import app.login.service.business.UserService;
import app.login.service.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    UserService userService;

    //Register user
    @PostMapping(path = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> register(@RequestBody(required = true)RegisterRequest registerRequest) {

        User newUser = new User(registerRequest.getFirstName(),registerRequest.getLastName(),
                registerRequest.getMobileNumber(),registerRequest.getRole(), registerRequest.getAddress());

        User registeredUser = userService.registerUser(newUser);;
        return new ResponseEntity<User>(registeredUser, HttpStatus.CREATED);
    }

    //loginReq
    @GetMapping(path = "login/{phnNum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> login(@PathVariable(name = "phnNum") final String phoneNum) {


        User user = userService.isValidUSer(phoneNum);
        if(null == user) {
            return new ResponseEntity<User>(new User(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }


}
