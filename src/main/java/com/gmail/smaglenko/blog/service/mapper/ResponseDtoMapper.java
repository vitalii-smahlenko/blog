package com.gmail.smaglenko.blog.service.mapper;

public interface ResponseDtoMapper<D, M> {
    D mapToDto(M m);
}