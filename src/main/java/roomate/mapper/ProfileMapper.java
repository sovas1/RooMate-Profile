package roomate.mapper;

import org.mapstruct.Mapper;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

    ProfileDto toDto(Profile profile);
    Profile toEntity(ProfileDto profile);

}
