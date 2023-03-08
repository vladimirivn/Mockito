package org.skypro.dao;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.skypro.dao.impl.UserDaoImpl;
import org.skypro.model.User;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private final UserDaoImpl userDao = new UserDaoImpl();
    public static final String VALID_NAME = "Vladimir";
    public static final String INVALID_NAME = "Voldomir";

    @Test
    @DisplayName("Проверка имени в списке")
    void shouldGetUserByName() {
        assertEquals(new User(VALID_NAME), userDao.getUserByName(VALID_NAME));
    }
    @Test
    @DisplayName("Возврат не null если имени есть в списке")
    void shouldGetNotNullGetUserByName() {
        assertNotNull(userDao.getUserByName(VALID_NAME));
    }
    @Test
    @DisplayName("Возврат null если имени нет в списке")
    void shouldGetNullGetUserByName() {
        assertNull(userDao.getUserByName(INVALID_NAME));
    }

}