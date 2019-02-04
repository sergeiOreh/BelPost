package by.compit.belpost.util;

import by.compit.belpost.entity.ErrorMessage;
import by.compit.belpost.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Класс ServerExceptionHandler - обработчик ошибок, возникающих в данном сервисе.
 */
@ControllerAdvice
public class ServerExceptionHandler {

    private static final Logger logger = LogManager.getLogger(ServerExceptionHandler.class);

    private static final int INTERNAL_SERVER_ERROR_CODE = 500;
    private static final int NOT_FOUND_CODE = 404;

    private static final String INTERNAL_SERVER_ERROR_MESSAGE = "Internal Server Error";
    private static final String NOT_FOUND_MESSAGE = "Not Found";


    /**
     * @return объекта типа {@link ErrorMessage}
     */
    @SuppressWarnings("Duplicates")
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ErrorMessage handleException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(INTERNAL_SERVER_ERROR_CODE);
        errorMessage.setMessage(INTERNAL_SERVER_ERROR_MESSAGE);

        return errorMessage;
    }

    @ResponseBody
    @ExceptionHandler(NotFoundException.class)
    public ErrorMessage handleNotFoundException() {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(NOT_FOUND_CODE);
        errorMessage.setMessage(NOT_FOUND_MESSAGE);

        return errorMessage;
    }
}
