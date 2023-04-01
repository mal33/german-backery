package de.backery.backerydbproxyservice.logic;

import de.backery.backerydbproxyservice.to.UserTo;

import java.util.List;

public interface Usermanagement {

    List<UserTo> getAllUsers();
    UserTo createNewUser(UserTo userTo);
    UserTo getUserById(String userId);
    UserTo updateUser(UserTo reqUserTo);
    UserTo deleteUser(String userId);
}
