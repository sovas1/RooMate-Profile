package roomate.infrastructure;

import lombok.extern.log4j.Log4j2;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import roomate.infrastructure.exception.*;
import roomate.infrastructure.model.ErrorInfo;
import roomate.infrastructure.model.FieldValidationErrorListDTO;

import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;
import java.util.List;
import java.util.Locale;

/**
 * Created by sowki on 01.06.2017.
 */
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    private final MessageSource messageSource;

    public GlobalExceptionHandler(MessageSource ms) {
        this.messageSource = ms;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public FieldValidationErrorListDTO processValidationError(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        return processFieldErrors(fieldErrors);
    }

    private FieldValidationErrorListDTO processFieldErrors(List<FieldError> fieldErrors) {
        FieldValidationErrorListDTO dto = new FieldValidationErrorListDTO();

        for (FieldError fieldError : fieldErrors) {
            String localizedErrorMessage = resolveErrorMessage(fieldError);
            dto.addValidationError(fieldError.getField(), localizedErrorMessage);
        }

        return dto;
    }

    private String resolveErrorMessage(FieldError fieldError) {
        Locale currentLocale = LocaleContextHolder.getLocale();
        String errorMessage = messageSource.getMessage(fieldError, currentLocale);

        // If the message was not found, return the most accurate field error
        // code instead.
        // You can remove this check if you prefer to get the default error
        // message.
        if (errorMessage.equals(fieldError.getDefaultMessage())) {
            String[] fieldErrorCodes = fieldError.getCodes();
            errorMessage = fieldErrorCodes[0];
        }

        return errorMessage;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    ErrorInfo handleAccessDeniedRequest(HttpServletRequest req, Exception ex) {
        log.error("Handling AccessDeniedException. Response status: UNAUTHORIZED", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BadCredentialsException.class)
    @ResponseBody
    ErrorInfo handleBadCredentialsRequest(HttpServletRequest req, Exception ex) {
        log.error("Handling BadCredentialsException. Response status: UNAUTHORIZED", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(Exception.class)
    @ResponseBody
    ErrorInfo handleBadRequest(HttpServletRequest req, Exception ex) {
        log.error("Handling Exception. Response status: BAD_REQUEST", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(ObjectNotFoundException.class)
    @ResponseBody
    ErrorInfo handleObjectNotFoundRequest(HttpServletRequest req, Exception ex) {
        log.error("Handling ObjectNotFoundException. Response status: NOT_FOUND", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalErrorException.class)
    @ResponseBody
    ErrorInfo handleInternalServerError(HttpServletRequest req, Exception ex) {
        log.error("Handling InternalErrorException. Response status: INTERNAL_SERVER_ERROR", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(UnimplementedMethodException.class)
    @ResponseBody
    ErrorInfo handleUnimplementedMethodException(HttpServletRequest req, Exception ex) {
        log.error("Handling UnimplementedMethodException. Response status: INTERNAL_SERVER_ERROR", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ObjectAlreadyExistsException.class)
    @ResponseBody
    ErrorInfo handleObjectAlreadyExistsException(HttpServletRequest req, Exception ex) {
        log.error("Handling ObjectAlreadyExistsException. Response status: CONFLICT", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.MOVED_PERMANENTLY)
    @ExceptionHandler(InvalidTokenException.class)
    @ResponseBody
    ErrorInfo handleInvalidTokenException(HttpServletRequest req, Exception ex) {
        log.error("Handling InvalidTokenException. Response status: MOVED_PERMANENTLY", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    @ResponseBody
    ErrorInfo handleBadRequestException(HttpServletRequest req, Exception ex) {
        log.error("Handling BadRequestException. Response status: BAD_REQUEST", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ImmutableObjectException.class)
    @ResponseBody
    ErrorInfo handleImmutableObjectException(HttpServletRequest req, Exception ex) {
        log.error("Handling ImmutableObjectException. Response status: BAD_REQUEST", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(ConflictException.class)
    @ResponseBody
    ErrorInfo handleConflictException(HttpServletRequest req, Exception ex) {
        log.error("Handling ConflictException. Response status: CONFLICT", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(DataConsistencyException.class)
    @ResponseBody
    ErrorInfo handleDataConsistencyException(HttpServletRequest req, Exception ex) {
        log.error("Handling DataConsistencyException. Response status: CONFLICT", ex);
        return new ErrorInfo(req.getRequestURL().toString(), ex);
    }

}
