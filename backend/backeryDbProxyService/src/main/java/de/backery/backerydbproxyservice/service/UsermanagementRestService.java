package de.backery.backerydbproxyservice.service;

import de.backery.backerydbproxyservice.to.UserTo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public interface UsermanagementRestService {


    @GetMapping("/users")
    List<UserTo> getAllUsers();

    @PostMapping("/users")
    ResponseEntity<UserTo> createUser(@RequestBody UserTo article);

    @GetMapping("/users/{userId}")
    ResponseEntity<UserTo> getUserById(@PathVariable(value = "userId") String userId);

    @PutMapping("/users/{userId}")
    ResponseEntity<UserTo> updateUser(@PathVariable(value = "userId") String userId,
                                            @RequestBody UserTo user);

    @DeleteMapping("/users/{userId}")
    ResponseEntity<UserTo> deleteUser(@PathVariable(value = "userId") String userId);
}
