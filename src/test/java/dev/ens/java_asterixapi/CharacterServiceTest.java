package dev.ens.java_asterixapi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CharacterServiceTest {

    private final CharacterRepo characterRepo = mock(CharacterRepo.class);
    private final CharacterService characterService = new CharacterService(characterRepo);

    // mit AI refactored

    private AsterixCharacter character1;
    private List<AsterixCharacter> characterList;

    @BeforeEach
    void setUp() {
        character1 = new AsterixCharacter("1", "Test1", 30, "Test");
        characterList = List.of(character1);
    }


    @Test
    void getAllCharacters() {
        //GIVEN
//        AsterixCharacter character1 = new AsterixCharacter("1", "Test1", 30, "Test");
//        List<AsterixCharacter> characterList = List.of(character1);

        when(characterRepo.findAll()).thenReturn(characterList);
        //WHEN
        List<AsterixCharacter> actual = characterService.getAllCharacters();

        //THEN
        verify(characterRepo).findAll();
        assertEquals(List.of(character1), actual);
    }

    @Test
    void getCharacterById() {
        //GIVEN
//        AsterixCharacter character1 = new AsterixCharacter("1", "Test1", 30, "Test");

        when(characterRepo.findById("1")).thenReturn(Optional.of(character1));
        //WHEN
        AsterixCharacter actual = characterService.getCharacterById("1");
        //THEN
        verify(characterRepo).findById("1");
        assertEquals(character1, actual);
    }

    @Test
    void removeCharacterById() {
        //GIVEN

        //WHEN

        //THEN
    }

    @Test
    void updateCharacterById() {
        //GIVEN

        //WHEN

        //THEN
    }
}