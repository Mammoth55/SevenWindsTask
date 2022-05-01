package com.sigma.task.service;

import com.sigma.task.dto.request.UserDtoRequest;
import com.sigma.task.exeptionhandling.EntityNotFoundException;
import com.sigma.task.model.User;
import com.sigma.task.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no User with ID = " + id + " in Database."));
    }

    public User getByCarNumber(String carNumber) {
        return userRepository.getByCarNumber(carNumber)
                .orElseThrow(() -> new EntityNotFoundException("There is no User with Car Number = " + carNumber + " in Database."));
    }

    @Transactional
    public User create(UserDtoRequest request) {
        return userRepository.save(User.builder()
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .carNumber(request.getCarNumber())
                .carModel(request.getCarModel())
                .build());
    }

    @Transactional
    public User update(long id, UserDtoRequest request) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no User with ID = " + id + " in Database."));
        userRepository.save(User.builder()
                .id(id)
                .firstName(request.getFirstName())
                .middleName(request.getMiddleName())
                .lastName(request.getLastName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .carNumber(request.getCarNumber())
                .carModel(request.getCarModel())
                .build());
        return user;
    }

    @Transactional
    public User deleteById(long id) {
        var user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("There is no User with ID = " + id + " in Database."));
        userRepository.deleteById(id);
        return user;
    }
}