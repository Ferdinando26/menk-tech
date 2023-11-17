package com.menktech.service;

import com.menktech.entity.User;
import com.menktech.repository.IRoleRepository;
import com.menktech.repository.IUserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{

    @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    private IRoleRepository iRoleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<User> getAllUsers() {
        return iUserRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return iUserRepository.getReferenceById(id);
    }

    @Override
    public User addUser(User user) {

        user.setRoles(user.getRoles()
                .stream()
                .map(role -> iRoleRepository.findByName(role.getName()))
                .toList());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.iUserRepository.save(user);
    }

    @Override
    public User updateUser(User user) {

        user.setRoles(user.getRoles()
                .stream()
                .map(role -> iRoleRepository.findByName(role.getName()))
                .toList());

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return this.iUserRepository.save(user);
    }

    @Override
    public void deleteUser(User user) {

        iUserRepository.deleteById(user.getId());

    }
}
