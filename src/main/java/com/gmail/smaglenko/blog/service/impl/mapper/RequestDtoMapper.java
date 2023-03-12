package com.gmail.smaglenko.blog.service.impl.mapper;

public interface RequestDtoMapper<D, T> {
    T mapToModel(D dto);
}