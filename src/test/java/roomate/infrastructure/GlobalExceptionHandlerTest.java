package roomate.infrastructure;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import roomate.infrastructure.exception.ObjectNotFoundException;
import roomate.infrastructure.exception.UnimplementedMethodException;
import roomate.service.ProfileService;
import run.Application;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by sowki on 01.06.2017.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT, classes = Application.class)
public class GlobalExceptionHandlerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @MockBean
    private ProfileService serviceMock;

    @Value("${server.port}")
    private Integer definedPort;

    @Test
    public void shouldReturnErrorInfoWhenExceptionIsThrown() throws ObjectNotFoundException {
        // given
        final String idOfNonExistingUser = "3a4n2325jada6";
        given(serviceMock.findById(idOfNonExistingUser))
                .willThrow(new UnimplementedMethodException("getProfiles() is not implemented yet."));

        // when
        String body = this.restTemplate.getForObject("/profiles/" + idOfNonExistingUser, String.class);

        // then
        assertThat(body).isEqualTo("{\"url\":\"http://localhost:" + definedPort + "/profiles/3a4n2325jada6\"," +
                "\"ex\":\"getProfiles() is not implemented yet.\"}");
    }

}
