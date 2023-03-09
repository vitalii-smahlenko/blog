package com.gmail.smaglenko.blog.controller;

import com.gmail.smaglenko.blog.model.User;
import com.gmail.smaglenko.blog.service.UserService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.ArrayList;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @MockBean
    private UserService userService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
    }

    @Test
    public void shouldShowAllByAgeAfter() {
        int age = 18;
        List<User> mockUsers = new ArrayList<>();
        mockUsers.add(new User(1L, "Petro", 20, null));
        mockUsers.add(new User(2L, "Daria", 23, null));

        Mockito.when(userService.getAllByAgeAfter(age)).thenReturn(mockUsers);

        RestAssuredMockMvc.when()
                .get("/users/getAllByAgeAfter?age=18" )
                .then()
                .statusCode(200)
                .body("size()", Matchers.equalTo(2))
                .body("[0].id", Matchers.equalTo(1))
                .body("[0].name", Matchers.equalTo("Petro"))
                .body("[0].age", Matchers.equalTo(20))
                .body("[1].id", Matchers.equalTo(2))
                .body("[1].name", Matchers.equalTo("Daria"))
                .body("[1].age", Matchers.equalTo(23));
    }
}
