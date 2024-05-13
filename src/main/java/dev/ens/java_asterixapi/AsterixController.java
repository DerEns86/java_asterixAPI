package dev.ens.java_asterixapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asterix/characters")
public class AsterixController {

    private final CharacterRepo characterRepo;

    public AsterixController(CharacterRepo characterRepo){
        this.characterRepo = characterRepo;
    }

    @GetMapping
    public List<AsterixCharacter> getAllCharacters(){
        return characterRepo.findAll();
    }

    @GetMapping("{id}")
    public Optional<AsterixCharacter> getSingleCharacterId(@PathVariable String id){
        return characterRepo.findById(id);
    }

    @PostMapping("new")
    public AsterixCharacter saveCharacter(@RequestBody AsterixCharacter character) {
        characterRepo.save(new AsterixCharacter(character.id(), character.name(), character.age(), character.profession()));
        return character;
    }
}
