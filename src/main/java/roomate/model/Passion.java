package roomate.model;

import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * Created by sowki on 02.06.2017.
 */
@Data
public class Passion {

    @NotNull
    private String name;

    @Min(1) @Max(5)
    private Integer value; //stars count

    private String description;

}
