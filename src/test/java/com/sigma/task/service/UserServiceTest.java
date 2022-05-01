package com.sigma.task.service;

import com.sigma.task.dto.request.UserDtoRequest;
import com.sigma.task.model.User;
import com.sigma.task.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    private static final String TEST_EMAIL1 = "11111@gmail.com";

    private static final String TEST_EMAIL2 = "22222@gmail.com";

    private static final String TEST_EMAIL3 = "33333@gmail.com";

    private static final User USER_1 = User.builder()
            .id(1)
            .firstName("111")
            .middleName("11111")
            .lastName("1111111")
            .email(TEST_EMAIL1)
            .phoneNumber("79835247953")
            .carNumber("A555AA55")
            .carModel("BMW X6 White")
            .build();

    private static final User USER_2 = User.builder()
            .id(2)
            .firstName("222")
            .middleName("22222")
            .lastName("2222222")
            .email(TEST_EMAIL2)
            .phoneNumber("79835247933")
            .carNumber("X777AM777")
            .carModel("Lamborghini Diablo Black")
            .build();

    private static final User USER_3 = User.builder()
            .id(3)
            .firstName("333")
            .middleName("33333")
            .lastName("3333333")
            .email(TEST_EMAIL3)
            .phoneNumber("79835247943")
            .carNumber("Y121BA55")
            .carModel("Toyota Prius White")
            .build();

    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userService = new UserService(userRepository);
    }

    @Test
    public void getAll() {
        List<User> users = List.of(USER_1, USER_2, USER_3);
        when(userRepository.findAll()).thenReturn(users);

        List<User> actual = userService.getAll();

        assertEquals(actual.size(), 3);
        assertEquals(actual.get(0).getEmail(), TEST_EMAIL1);
        assertEquals(actual.get(1).getEmail(), TEST_EMAIL2);
        assertEquals(actual.get(2).getEmail(), TEST_EMAIL3);
    }

    @Test
    public void getById() {
        when(userRepository.findById(2L)).thenReturn(Optional.of(USER_2));

        User actual = userService.getById(2L);

        assertNotNull(actual);
        assertEquals(2L, actual.getId());
        assertEquals(actual.getEmail(), TEST_EMAIL2);
    }

    @Test
    public void create() {
        when(userRepository.save(any())).thenReturn(USER_1);

        User actual = userService.create(UserDtoRequest.builder()
                .firstName(USER_1.getFirstName())
                .middleName(USER_1.getMiddleName())
                .lastName(USER_1.getLastName())
                .email(USER_1.getEmail())
                .phoneNumber(USER_1.getPhoneNumber())
                .build());

        assertNotNull(actual);
        assertTrue(actual.getId() > 0);
        assertEquals(actual.getEmail(), TEST_EMAIL1);
    }
}