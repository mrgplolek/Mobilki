package pl.prescriptionapp.restapi.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.prescriptionapp.restapi.dto.UserDto;
import pl.prescriptionapp.restapi.service.user.UserService;


@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    @ResponseBody
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto){
        return userService.postUser(userDto);
    }


    @GetMapping("/login")
    public ResponseEntity<?> loginUser(@RequestParam String email, @RequestParam String password){
        return userService.loginUser(email, password);
    }


}
