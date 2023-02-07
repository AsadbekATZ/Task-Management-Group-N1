package org.example.service;

import org.example.DTO.AddDto;

import java.util.UUID;

public interface BaseService<T> {
    AddDto add(T t);

    T getById(UUID id);
}
