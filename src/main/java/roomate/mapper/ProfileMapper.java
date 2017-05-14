package roomate.mapper;

import org.mapstruct.Mapper;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;

@Mapper(componentModel = "spring")
public interface ProfileMapper {

//    @Mappings({
//            @Mapping(source = "work", target = "workTime"),
//            @Mapping(source = "studies", target = "studiesTime"),
//            @Mapping(source = "animals", target = "acceptAnimals"),
//            @Mapping(source = "smoking", target = "acceptSmoking"),
//            @Mapping(source = "drinking", target = "acceptDrinking")
//    })
    ProfileDto toDto(Profile profile);

//    @Mappings({
//            @Mapping(source = "workTime", target = "work"),
//            @Mapping(source = "studiesTime", target = "studies"),
//            @Mapping(source = "acceptAnimals", target = "animals"),
//            @Mapping(source = "acceptSmoking", target = "smoking"),
//            @Mapping(source = "acceptDrinking", target = "drinking")
//    })
    Profile toEntity(ProfileDto profile);

}
