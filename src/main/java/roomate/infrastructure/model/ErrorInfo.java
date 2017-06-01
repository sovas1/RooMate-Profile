package roomate.infrastructure.model;

import lombok.Getter;

/**
 * Created by sowki on 01.06.2017.
 */
@Getter
public class ErrorInfo {

    private final String url;
    private final String ex;

    public ErrorInfo(String requestUrl, Exception ex) {
        this.url = requestUrl;
        this.ex = ex.getMessage();
    }

}
