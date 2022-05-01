package com.example.sevenwindstask.controller;

import com.example.sevenwindstask.dto.request.UserDtoRequest;
import com.example.sevenwindstask.model.User;
import com.example.sevenwindstask.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {

    final static String TEST_USER1_CAR_NUMBER = "A555AA55";

    final static String TEST_USER2_CAR_NUMBER = "X777AM777";

    final static User TEST_USER1 = User.builder()
            .id(1)
            .firstName("111")
            .middleName("11111")
            .lastName("1111111")
            .email("11111@gmail.com")
            .phoneNumber("79835247953")
            .carNumber(TEST_USER1_CAR_NUMBER)
            .carModel("BMW X6 White")
            .build();

    final static User TEST_USER2 = User.builder()
            .id(2)
            .firstName("222")
            .middleName("22222")
            .lastName("2222222")
            .email("2222222@gmail.com")
            .phoneNumber("79135247900")
            .carNumber(TEST_USER2_CAR_NUMBER)
            .carModel("Lamborghini Diablo Black")
            .build();

    private MockMvc mockMvc;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Mock
    private UserService userService;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new UserController(userService)).build();
    }

    @Test
    public void getAllTest() throws Exception {
        List<User> users = List.of(TEST_USER1, TEST_USER2);

        when(userService.getAll()).thenReturn(users);

        mockMvc.perform(get("/api/users/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(2)))
                .andExpect(jsonPath("$[0].carNumber", Matchers.equalTo(TEST_USER1_CAR_NUMBER)))
                .andExpect(jsonPath("$[1].carNumber", Matchers.equalTo(TEST_USER2_CAR_NUMBER)));
    }

    @Test
    public void getByIdTest() throws Exception {
        when(userService.getById(2)).thenReturn(TEST_USER2);

        mockMvc.perform(get("/api/users/2"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("$.id", Matchers.equalTo(2)))
                .andExpect(jsonPath("$.carNumber", Matchers.equalTo(TEST_USER2_CAR_NUMBER)));
    }

    @Test
    public void createTest() throws Exception {
        when(userService.create(any())).thenReturn(TEST_USER1);

        mockMvc.perform(post("/api/users/")
                        .content(objectMapper.writeValueAsString(UserDtoRequest.builder()
                                .firstName(TEST_USER1.getFirstName())
                                .middleName(TEST_USER1.getMiddleName())
                                .lastName(TEST_USER1.getLastName())
                                .email(TEST_USER1.getEmail())
                                .phoneNumber(TEST_USER1.getPhoneNumber())
                                .carNumber(TEST_USER1_CAR_NUMBER)
                                .carModel(TEST_USER1.getCarModel())
                                .build()))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.notNullValue()))
                .andExpect(jsonPath("$.carNumber", Matchers.equalTo(TEST_USER1_CAR_NUMBER)));
    }
}