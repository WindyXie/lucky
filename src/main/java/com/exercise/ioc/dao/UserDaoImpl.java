package com.exercise.ioc.dao;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.Data;

@Repository
@Data
@AllArgsConstructor
public class UserDaoImpl {
    public User getById(int userId) {
        if (9527 == userId) {
            return new User(9527, "华安", "唐伯虎", 18);
        }
        return null;
    }
}
