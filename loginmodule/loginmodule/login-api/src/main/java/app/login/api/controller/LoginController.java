package app.login.api.controller;

import app.login.api.model.RegisterRequest;
import app.login.service.business.ConsumerService;
import app.login.service.entity.Consumer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class LoginController {

    @Autowired
    ConsumerService consumerService;

    //Register user
    /*
    this api will add a new user to the DB if it doesn't exist
     */
    @PostMapping(path = "register", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Consumer> register(@RequestBody(required = true)RegisterRequest registerRequest) {

        if(null == consumerService.isValidUSer(registerRequest.getMobileNumber())) {
            Consumer newConsumer = new Consumer(registerRequest.getFirstName(),registerRequest.getLastName(),
                    registerRequest.getMobileNumber(),registerRequest.getRole(), registerRequest.getAddress());

            //call to service layer
            Consumer registeredConsumer = consumerService.registerUser(newConsumer);;
            return new ResponseEntity<Consumer>(registeredConsumer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<Consumer>(new Consumer(), HttpStatus.CONFLICT);
        }
        //Create a new user object from the request

    }

    //loginReq
    /*
    checks whether the user is already present in system before using google sso
     */
    @GetMapping(path = "login/{phnNum}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Consumer> login(@PathVariable(name = "phnNum") final String phoneNum) {

        Consumer consumer = consumerService.isValidUSer(phoneNum);
        if(null == consumer) {
            return new ResponseEntity<Consumer>(new Consumer(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Consumer>(consumer, HttpStatus.OK);
    }


}
