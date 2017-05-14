package roomate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import roomate.mapper.ProfileMapper;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;
import roomate.service.ProfileService;

/**
 * Created by sowki on 06.05.2017.
 */
@RestController
public class ProfileController {

    private final ProfileService service;
    private final ProfileMapper mapper;

    public ProfileController(ProfileService service, ProfileMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("/test")
    public String test() {
        return "Test Token []";
    }

    @PostMapping("")
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto profileDto) {
        final Profile profile = service.save(profileDto);
        final ProfileDto result = mapper.toDto(profile);
        return new ResponseEntity<>(result, HttpStatus.CREATED);
    }

}
