package ru.kate.kafkaconsumer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.kate.kafkaconsumer.dto.BooksDto;
import ru.kate.kafkaconsumer.model.Book;

@Mapper(componentModel = "spring")
public interface BooksMapper {

    Book map(BooksDto booksDto);
}
