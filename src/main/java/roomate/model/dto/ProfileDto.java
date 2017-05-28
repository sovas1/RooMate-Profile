package roomate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String sex;

    private String workTime;
    private String studiesTime;

    private Map<String, Boolean> accepts;

    private String aboutMe;

}
