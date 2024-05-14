package dev.ens.java_asterixapi;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

@Service
public class CharacterService {

    private final CharacterRepo characterRepo;

    public CharacterService(CharacterRepo characterRepo) {
        this.characterRepo = characterRepo;
    }

    public List<AsterixCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    public AsterixCharacter getCharacterById(String id){
        return characterRepo.findById(id)
                .orElseThrow();
    }

    public AsterixCharacter saveCharacter(AsterixCharacter newCharacter) {
        AsterixCharacter characterToSave = characterRepo.save(new AsterixCharacter(UUID.randomUUID().toString(), newCharacter.name(), newCharacter.age(), newCharacter.profession()));
        return characterRepo.save(characterToSave);
    }

    public void removeCharacterById(String id){
         characterRepo.deleteById(id);
    }

    public AsterixCharacter updateCharacterById(String id, AsterixCharacter updatedCharacter) {
        return characterRepo.findById(id)
                .map(character -> {
                    character = updatedCharacter;
                    return characterRepo.save(character);
                })
                .orElseThrow(() -> new IllegalArgumentException("Character with id " + id + " not found"));
      }

    }

