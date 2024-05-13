package dev.ens.java_asterixapi;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/asterix/characters")
public class AsterixController {

    private final CharacterService characterService;

    public AsterixController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping
    public List<AsterixCharacter> getAllCharacters(){
        return characterService.getAllCharacters();
    }

    @GetMapping("{id}")
    public AsterixCharacter getSingleCharacterId(@PathVariable String id){
        return characterService.getCharacterById(id);
    }

    @PostMapping("new")
    public AsterixCharacter saveCharacter(@RequestBody AsterixCharacter character) {
       characterService.saveCharacter(character);
        return character;
    }
}
