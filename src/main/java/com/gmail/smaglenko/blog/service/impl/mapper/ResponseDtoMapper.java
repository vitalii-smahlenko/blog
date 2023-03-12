package com.gmail.smaglenko.blog.service.impl.mapper;

public interface ResponseDtoMapper<D, T> {
    D mapToDto(T t);
}