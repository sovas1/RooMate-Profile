package roomate.infrastructure.model;

/**
 * Created by sowki on 01.06.2017.
 */
public class ErrorInfo {

    private final String url;
    private final String ex;

    public ErrorInfo(String requestUrl, Exception ex) {
        this.url = requestUrl;
        this.ex = ex.getCause().getLocalizedMessage();
    }

}
