package ru.kate.kafkaconsumer.listner;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.kate.kafkaconsumer.dto.BooksDto;
import ru.kate.kafkaconsumer.mapper.BooksMapper;
import ru.kate.kafkaconsumer.model.Book;
import ru.kate.kafkaconsumer.model.Genre;
import ru.kate.kafkaconsumer.repository.BookRepository;
import ru.kate.kafkaconsumer.repository.GenreRepository;

@Service

public class BookListener {

    private final BooksMapper booksMapper;
    private final BookRepository bookRepository;
    private final GenreRepository genreRepository;

    public BookListener(BooksMapper booksMapper, BookRepository bookRepository, GenreRepository genreRepository) {
        this.booksMapper = booksMapper;
        this.bookRepository = bookRepository;
        this.genreRepository = genreRepository;
    }

    @KafkaListener(
            topics = "book-topic"
    )
    public void listen(@Payload final BooksDto booksDto) {

        Genre genre = genreRepository.findById(booksDto.getGenre_id()).orElseThrow(() -> new RuntimeException("Такого жанра нет"));

        Book book = booksMapper.map(booksDto);
        book.setName(booksDto.getName());
        book.setGenre(genre);
        bookRepository.save(book);

    }
}
