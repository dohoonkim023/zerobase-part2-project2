package zerobase.weather.config;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 전역예외처리를 함
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR) //클라이언트에서 서버api를 호출하는 시점에 발생하는 예외가 발생 하였을 때 어떤걸 반환 할 것인지
    @ExceptionHandler(Exception.class) //이 어노테이션이 필요하고, 모든 Exception을 다루기 위해 Exception.class을 넣어줌.
    public Exception handleAllException() {
        System.out.println("error from GlobalExceptionHandler");
        return new Exception();
    }
}
