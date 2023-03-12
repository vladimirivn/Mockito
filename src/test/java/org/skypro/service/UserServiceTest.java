package org.skypro.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.dao.UserDao;
import org.skypro.model.User;
import org.skypro.service.impl.UserServiceImpl;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class UserServiceTest {
    private static final User CORRECT_USER = new User("User1");
    private static final User NOT_CORRECT_USER = new User("User2");
    private static final List<User> users = List.of(
            CORRECT_USER,
            new User("User3"),
            new User("User4")
    );

    @Mock
    private UserDao userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Возврат true если есть в списке")
    void shouldReturnTrueWhenUserExist() {
        when(userDaoMock.findAllUsers()).thenReturn(users);
        assertEquals(users, userDaoMock.findAllUsers());
        assertTrue(out.checkUserExist(CORRECT_USER));
        verify(userDaoMock, times(2)).findAllUsers();
    }

    @Test
    @DisplayName("Возврат false если нет в списке")
    void shouldReturnFalseWhenUserNotExist() {
        when(userDaoMock.findAllUsers()).thenReturn(users);
        assertEquals(users, userDaoMock.findAllUsers());
        assertFalse(out.checkUserExist(NOT_CORRECT_USER));
        verify(userDaoMock, times(2)).findAllUsers();
    }
}