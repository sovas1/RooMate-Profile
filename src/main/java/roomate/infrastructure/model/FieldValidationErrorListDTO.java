package roomate.infrastructure.model;

import java.util.Collections;
import java.util.List;

/**
 * Created by sowki on 01.06.2017.
 */

public class FieldValidationErrorListDTO {

    private List<String> errors = Collections.emptyList();

    public void addValidationError(String field, String localizedErrorMessage) {
        errors.add("Field: " + field + ", Msg: " + localizedErrorMessage);
    }

}
