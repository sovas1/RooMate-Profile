package roomate.service;

import org.springframework.stereotype.Service;
import roomate.mapper.ProfileMapper;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;
import roomate.repository.ProfileRepository;

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

}
