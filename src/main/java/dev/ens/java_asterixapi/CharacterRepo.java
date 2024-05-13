package dev.ens.java_asterixapi;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.MongoRepository;

@Document(collection = "asterixCharacter")
public interface CharacterRepo extends MongoRepository<AsterixCharacter, String> {
}
