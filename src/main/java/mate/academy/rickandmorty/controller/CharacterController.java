package mate.academy.rickandmorty.controller;

import java.util.List;
import mate.academy.rickandmorty.model.Character;
import mate.academy.rickandmorty.services.CharacterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/characters")
public class CharacterController {
    private final CharacterService characterService;

    public CharacterController(CharacterService characterService) {
        this.characterService = characterService;
    }

    @GetMapping("/random")
    public Character getRandomCharacter() {
        return characterService.getRandomCharacter();
    }

    @GetMapping("/search")
    public List<Character> getCharacterList(@RequestParam(defaultValue = "ick") String str) {
        return characterService.findByString(str);
    }
}
