package dev.ens.java_asterixapi;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

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

    public AsterixCharacter saveCharacter(AsterixCharacter character) {
        characterRepo.save(new AsterixCharacter(character.id(), character.name(), character.age(), character.profession()));
        return character;
    }
}
