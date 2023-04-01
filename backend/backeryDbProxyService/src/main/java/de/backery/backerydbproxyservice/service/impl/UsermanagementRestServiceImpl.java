package de.backery.backerydbproxyservice.service.impl;

import de.backery.backerydbproxyservice.logic.Usermanagement;
import de.backery.backerydbproxyservice.service.UsermanagementRestService;
import de.backery.backerydbproxyservice.to.UserTo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@Component
public class UsermanagementRestServiceImpl implements UsermanagementRestService {

    private final Usermanagement usermanagement;

    @Override
    public List<UserTo> getAllUsers() {
        return usermanagement.getAllUsers();
    }

    @Override
    public ResponseEntity<UserTo> createUser(UserTo user) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(usermanagement.createNewUser(user));
    }

    @Override
    public ResponseEntity<UserTo> getUserById(String userId) {
        UserTo foundUser = usermanagement.getUserById(userId);
        return generateUserToResponse(foundUser);
    }

    @Override
    public ResponseEntity<UserTo> updateUser(String userId, UserTo user) {
        UserTo updatedUser = usermanagement.updateUser(user);
        return generateUserToResponse(updatedUser);
    }

    @Override
    public ResponseEntity<UserTo> deleteUser(String userId) {
        UserTo deletedUser = usermanagement.deleteUser(userId);
        return generateUserToResponse(deletedUser);
    }

    private ResponseEntity<UserTo> generateUserToResponse(UserTo userTo) {
        if (userTo != null) {
            return ResponseEntity.ok(userTo);
        }
        return ResponseEntity.notFound().build();
    }
}
