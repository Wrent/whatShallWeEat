package cz.wrent.wswe.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document
public class Food {
    @Id
    private final UUID id;
    private final String name;

    public Food(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }
}
