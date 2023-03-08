package org.skypro.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.skypro.dao.impl.UserDaoImpl;
import org.skypro.model.User;
import org.skypro.service.impl.UserServiceImpl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class UserServiceTest {
    private final User existUser = new User("Vladimir");
    private final User notExistUser = new User("Voldomir");
    private final User user = new User("Vladimir");


    @Mock
    private UserDaoImpl userDaoMock;
    @InjectMocks
    private UserServiceImpl out;

    public UserServiceTest() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    @DisplayName("Возврат true если есть в списке")
    void shouldReturnTrueWhenUserExist() {
        when(userDaoMock.getUserByName(existUser.getName())).thenReturn(user);
        assertTrue(out.checkUserExist(existUser));
    }

    @Test
    @DisplayName("Возврат false если нет в списке")
    void shouldReturnFalseWhenUserNotExist() {
        when(userDaoMock.getUserByName(notExistUser.getName())).thenReturn(null);
        assertFalse(out.checkUserExist(notExistUser));
    }
}