package roomate.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import roomate.model.enums.Sex;
import roomate.model.enums.Studies;
import roomate.model.enums.Work;

@Data
@Builder
@Document
@NoArgsConstructor
@AllArgsConstructor
public class Profile {

    @Id
    private String id;

    private String firstName;
    private String lastName;
    private Integer age;
    private Sex sex;
    private Work workTime;
    private Studies studiesTime;

    private Boolean acceptAnimals;
    private Boolean acceptSmoking;
    private Boolean acceptDrinking;

    private Boolean cleaningSchedule;

    private String aboutMe;

}
