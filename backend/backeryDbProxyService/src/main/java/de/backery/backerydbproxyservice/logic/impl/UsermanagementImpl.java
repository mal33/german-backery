package de.backery.backerydbproxyservice.logic.impl;

import de.backery.backerydbproxyservice.dataaccess.entity.UserEntity;
import de.backery.backerydbproxyservice.mapper.CustomMapper;
import de.backery.backerydbproxyservice.to.UserTo;
import de.backery.backerydbproxyservice.dataaccess.repo.UserRepository;
import de.backery.backerydbproxyservice.logic.Usermanagement;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@Component
public class UsermanagementImpl implements Usermanagement {

    private final CustomMapper customMapper;
    private final UserRepository userRepository;

    @Override
    public List<UserTo> getAllUsers() {
        List<UserEntity> allUserEntity = userRepository.findAll();
        log.info("Found {} users", allUserEntity.size());
        return customMapper.userEntityListToUserToList(allUserEntity);
    }

    @Override
    public UserTo createNewUser(UserTo userTo) {
        UserEntity convertedUser = customMapper.userToToUserEntity(userTo);
        convertedUser.setUserId(UUID.randomUUID().toString());
        UserEntity savedUser = userRepository.saveAndFlush(convertedUser);
        log.info("The User with id {} has been created", savedUser.getUserId());
        return customMapper.userEntityToUserTo(savedUser);
    }

    @Override
    public UserTo getUserById(String userId) {
        UserEntity foundUserEntity = userRepository.findByUserId(userId);
        log.info("Found User with id {}", foundUserEntity.getUserId());
        return customMapper.userEntityToUserTo(foundUserEntity);
    }

    @Override
    public UserTo updateUser(UserTo reqUserTo) {
        Optional<UserTo> reqUser = Optional.ofNullable(reqUserTo);
        if (reqUser.isPresent()) {
            UserEntity foundUserEntity =
                    userRepository.findByUserId(reqUser.get().getUserId());
            UserEntity changedEntity = userRepository.save(UserEntity
                    .builder()
                    .id(foundUserEntity.getId())
                    .userId(foundUserEntity.getUserId())
                    .username(foundUserEntity.getUsername())
                    .password(foundUserEntity.getPassword())
                    .build()
            );
            log.info("User with id {} has been updated", changedEntity.getUserId());
            return customMapper.userEntityToUserTo(changedEntity);
        }
        return null;
    }

    @Override
    public UserTo deleteUser(String userId) {
        UserEntity toBeDeletedUser =
                userRepository.findByUserId(userId);
        if (toBeDeletedUser != null) {
            userRepository.delete(toBeDeletedUser);
            log.info("User with id {} has been deleted", toBeDeletedUser.getUserId());
            return customMapper.userEntityToUserTo(toBeDeletedUser);
        }
        return null;
    }
}
