package org.skypro.model;

import java.util.Objects;

public class User {
    private final String name;


    public User(String name) {
        if (name == null || name.isBlank() || name.isEmpty()) {
            throw new RuntimeException("Введите корректное имя пользователя");
        } else {
            this.name = name;
        }
    }
    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
