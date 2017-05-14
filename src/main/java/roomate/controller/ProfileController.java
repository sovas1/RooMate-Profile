package roomate.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import roomate.mapper.ProfileMapper;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;
import roomate.service.ProfileService;

import java.util.List;

/**
 * Created by sowki on 06.05.2017.
 */
@RestController
@RequestMapping("profiles")
public class ProfileController {

    private final ProfileService service;
    private final ProfileMapper mapper;

    public ProfileController(ProfileService service, ProfileMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping("")
    public ResponseEntity<ProfileDto> save(@RequestBody ProfileDto profileDto) {
        final Profile profile = service.save(profileDto);
        final ProfileDto resultData = mapper.toDto(profile);
        return new ResponseEntity<>(resultData, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<ProfileDto>> findAll() {
        final List<ProfileDto> resultData = service.findAll();
        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProfileDto> findById(@PathVariable String id) {
        final ProfileDto resultData = service.findById(id);
        return new ResponseEntity<>(resultData, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        final HttpStatus resultStatus = service.deleteById(id);
        return new ResponseEntity(resultStatus);
    }

}
