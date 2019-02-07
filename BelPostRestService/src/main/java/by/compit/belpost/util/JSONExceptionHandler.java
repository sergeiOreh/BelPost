package by.compit.belpost.util;

import by.compit.belpost.entity.ErrorMessage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONException;
import org.json.JSONPointerException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;

/**
 * Класс JSONExceptionHandler - обработчик исключений, которые могут возникнуть
 * при вводе запроса пользователем. Например, неверный формат запроса.
 */
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class JSONExceptionHandler {

    private static final Logger logger = LogManager.getLogger(JSONExceptionHandler.class);

    private static final int JSON_EXCEPTION_CODE = 400;

    private static final String JSON_EXCEPTION_MESSAGE = "Invalid Parameter";
    private static final String DATE_FORMAT_EXCEPTION_MESSAGE = "Invalid Date Parameter";

    /**
     * @return объекта типа {@link ErrorMessage}
     */
    @SuppressWarnings("Duplicates")
    @ExceptionHandler(value = {JSONException.class, JSONPointerException.class})
    @ResponseBody
    public ErrorMessage handleJSONException(Exception ex) {
        logger.error(ex.getMessage(), ex);
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(JSON_EXCEPTION_CODE);
        errorMessage.setMessage(JSON_EXCEPTION_MESSAGE);

        return errorMessage;
    }

    /**
     * @return объекта типа {@link ErrorMessage}
     */
    @ExceptionHandler(ParseException.class)
    @ResponseBody
    public ErrorMessage handleNotFoundException() {
        ErrorMessage errorMessage = new ErrorMessage();

        errorMessage.setErrorcode(JSON_EXCEPTION_CODE);
        errorMessage.setMessage(DATE_FORMAT_EXCEPTION_MESSAGE);

        return errorMessage;
    }
}
