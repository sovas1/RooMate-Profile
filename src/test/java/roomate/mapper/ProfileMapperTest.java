package roomate.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;
import roomate.model.Profile;
import roomate.model.dto.ProfileDto;
import roomate.model.enums.Sex;
import run.Application;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class ProfileMapperTest {

    @Autowired
    private ProfileMapper mapper;

    @Autowired
    private ApplicationContext ctx;

    @Test
    public void shouldLoadSpringContext() throws Exception {
        assertThat(ctx, is(notNullValue()));
    }

    @Test
    public void shouldMapToDto() throws Exception {

        // given
        Profile profile = Profile.builder()
                .firstName("Mariusz")
                .lastName("Sowa")
                .age(20)
                .sex(Sex.MALE)
                .acceptAnimals(true)
                .acceptDrinking(false)
                .acceptSmoking(false)
                .cleaningSchedule(true)
                .aboutMe("Im a person.")
                .build();

        // when
        final ProfileDto profileDto = mapper.toDto(profile);

        // then
        assertThat(profile.getAboutMe(), is(equalTo(profileDto.getAboutMe())));

    }
}
