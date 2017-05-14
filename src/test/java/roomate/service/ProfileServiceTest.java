package roomate.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import roomate.mapper.ProfileMapper;
import roomate.repository.ProfileRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProfileServiceTest {

    @Mock private ProfileRepository repository;
    @Mock private ProfileMapper mapper;

    private ProfileService service;

    @Before
    public void setUp() {
        service = new ProfileService(repository, mapper);
    }

    @Test
    public void shouldReturnOkWhileRemovingExistingProfile() throws Exception {
        // given
        final String id = "abcd1234";

        // when
        when(repository.exists(id))
                .thenReturn(true);

        final HttpStatus resultStatus = service.deleteById(id);

        // then
        assertThat(resultStatus, is(HttpStatus.OK));
    }

    @Test
    public void shouldReturnNotModifiedWhileRemovingExistingProfile() throws Exception {
        // given
        final String id = "efgh5678";

        // when
        when(repository.exists(id))
                .thenReturn(false);

        final HttpStatus resultStatus = service.deleteById(id);

        // then
        assertThat(resultStatus, is(HttpStatus.NOT_MODIFIED));
    }

}
