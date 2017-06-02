package roomate.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import roomate.model.Passion;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDto {

    private String id;

    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private Integer age;
    @NotNull
    private String sex;

    private String workTime;
    private String studiesTime;

    @NotNull
    private Map<String, Boolean> accepts;

    @Valid
    private Set<Passion> passions;

    private String aboutMe;

}
