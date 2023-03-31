package de.backery.backerydbproxyservice.logic.impl;

import de.backery.backerydbproxyservice.to.UserTo;
import de.backery.backerydbproxyservice.dataaccess.repo.UserRepository;
import de.backery.backerydbproxyservice.logic.Usermanagement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class UsermanagementImpl implements Usermanagement {

    private final UserRepository userRepository;

    @Override
    public List<UserTo> getAllUser() {
        return null;
    }
}
