package roomate.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by sowki on 06.05.2017.
 */
@RestController
public class ProfileController {

    @GetMapping("/test")
    public String test() {
        return "Test Token []";
    }

}
