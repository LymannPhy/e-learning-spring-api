package co.istad.elearningspringapi.exception;


import co.istad.elearningspringapi.base.BasedError;
import co.istad.elearningspringapi.base.BasedErrorResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@RestControllerAdvice
public class FileExceptionHandler {
    @Value("${spring.servlet.multipart.max-request-size}")
    private String maxSize;
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    @ResponseBody
    BasedErrorResponse handleMaxSizeException(MaxUploadSizeExceededException ex) {
        BasedError<String> baseError = BasedError.<String>builder()
                .code(HttpStatus.PAYLOAD_TOO_LARGE
                        .getReasonPhrase())
                .description("Media Upload size maximum : "+maxSize).build();
        return new BasedErrorResponse(baseError);
    }
}
