package ru.kate.kafkaconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kate.kafkaconsumer.model.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
}
