package com.gmail.smaglenko.blog.service.mapper;

public interface RequestDtoMapper<D, M> {
    M mapToModel(D dto);
}