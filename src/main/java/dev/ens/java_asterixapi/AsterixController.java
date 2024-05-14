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

    @PostMapping()
    public AsterixCharacter postCharacter(@RequestBody AsterixCharacterNoId character) {
     AsterixCharacter newCharacter = new AsterixCharacter(null, character.name(), character.age(), character.profession());
        return characterService.saveCharacter(newCharacter);
    }

    @DeleteMapping("{id}")
    public String deleteCharacter(@PathVariable String id){
        characterService.removeCharacterById(id);
       return "Character: " + id + " deleted";
    }

    @PutMapping("{id}")
    public AsterixCharacter updateCharacter(@PathVariable String id, @RequestBody AsterixCharacter updatedCharacter){
      return  characterService.updateCharacterById(id, new AsterixCharacter(id, updatedCharacter.name(), updatedCharacter.age(), updatedCharacter.profession()));
    }
}
