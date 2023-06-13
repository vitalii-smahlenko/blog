package com.gmail.smaglenko.blog.service.mapper;

import com.gmail.smaglenko.blog.dto.ArticleDto;
import com.gmail.smaglenko.blog.model.Article;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ArticleDtoMapper {
    ArticleDto mapToDto(Article article);

    @Mapping(target = "id", ignore = true)
    Article mapToModel(ArticleDto dto);
}
