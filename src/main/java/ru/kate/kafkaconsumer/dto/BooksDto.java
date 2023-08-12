package ru.kate.kafkaconsumer.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Base64;

@Data
public class BooksDto {

    @JsonProperty("id")
    @JsonDeserialize(using = Base64NumberDeserializer.class)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("genre_id")
    @JsonDeserialize(using = Base64NumberDeserializer.class)
    private Long genre_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(Long genre_id) {
        this.genre_id = genre_id;
    }


    public static class Base64NumberDeserializer extends JsonDeserializer {
        @Override
        public Object deserialize(final JsonParser jsonParser, final DeserializationContext deserializationContext) throws IOException {
            final BigInteger rawValue = new BigInteger(Base64.getDecoder().decode(jsonParser.getText()));
            return rawValue.longValue();
        }
    }
}
