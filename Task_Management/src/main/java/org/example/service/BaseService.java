package org.example.service;

import java.util.UUID;

public interface BaseService<T> {
    int add(T t);

    T getById(UUID id);
}
