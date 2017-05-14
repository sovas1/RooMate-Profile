package roomate.model.dto;

import lombok.Data;

@Data
public class ProfileDto {

    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private String sex;

    private String workTime;
    private String studiesTime;

    private Boolean acceptAnimals;
    private Boolean acceptSmoking;
    private Boolean acceptDrinking;

    private Boolean cleaningSchedule;

    private String aboutMe;

}
