package com.menktech.service;

import com.menktech.entity.User;
import com.menktech.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private IUserRepository iUserRepository;

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
        return iUserRepository.save(user);
    }

    @Override
    public User updateUser(User user) {

        User existingUser = iUserRepository.findById(user.getId()).orElse(null);
        if(existingUser !=null){

            existingUser.setPassword(user.getPassword());
            existingUser.setRoles(user.getRoles());
            existingUser.setUsername(user.getUsername());

            return iUserRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public void deleteUser(User user) {

        iUserRepository.deleteById(user.getId());

    }
}
