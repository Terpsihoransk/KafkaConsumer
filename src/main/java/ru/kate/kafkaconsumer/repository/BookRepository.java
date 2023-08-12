package ru.kate.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kate.kafkaconsumer.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
