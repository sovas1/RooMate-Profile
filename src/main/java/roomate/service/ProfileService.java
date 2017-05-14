package roomate.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import roomate.mapper.ProfileMapper;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;
import roomate.repository.ProfileRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    private final ProfileRepository repository;
    private final ProfileMapper mapper;

    public ProfileService(ProfileRepository repository, ProfileMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Profile save(ProfileDto profileDto) {
        final Profile profile = mapper.toEntity(profileDto);
        return repository.save(profile);
    }

    public List<ProfileDto> findAll() {
        final List<Profile> profiles = repository.findAll();
        return profiles.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    public ProfileDto findById(String id) {
        final Profile profile = repository.findOne(id);
        return mapper.toDto(profile);
    }

    public HttpStatus deleteById(String id) {
        if(!repository.exists(id)) {
            return HttpStatus.NOT_MODIFIED;
        }
        repository.delete(id);
        return HttpStatus.OK;
    }

}
