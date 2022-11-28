package com.mobigen.framework.exception;

import com.mobigen.framework.component.Messages;
import com.mobigen.framework.result.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@Slf4j
@Component
@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private Messages message;

    // Model Validation
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public JsonResult bindExceptionHandler(BindException e) {
        log.error(message.get("com.mobigen.framework.exception.GlobalExceptionHandler.bindExceptionHandler"), e);
        return getExceptionJsonResult(e, e.getFieldError());
    }

    // JSON Validation
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public JsonResult methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
        log.error(message.get("com.mobigen.framework.exception.GlobalExceptionHandler.methodArgumentNotValidExceptionHandler"), e);

        BindingResult bindingResult = e.getBindingResult();
        return getExceptionJsonResult(e, bindingResult.getFieldError());
    }

    // Controller
    @ExceptionHandler(JsonResultException.class)
    @ResponseBody
    public JsonResult jsonResultExceptionHandler(JsonResultException e) {
        log.error(message.get("com.mobigen.framework.exception.GlobalExceptionHandler.jsonResultExceptionHandler"), e);
        return getExceptionJsonResult(e, e);
    }

    // Authentication
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseBody
    public JsonResult accessDeniedExceptionHandler(AccessDeniedException e) {
        log.error(message.get("com.mobigen.framework.exception.GlobalExceptionHandler.accessDeniedExceptionHandler"), e);
        return getExceptionJsonResult(e, e);
    }

    // Unknown
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public JsonResult unknownExceptionHandler(Exception e) {
        log.error(message.get("com.mobigen.framework.exception.GlobalExceptionHandler.unknownExceptionHandler"), e);
        return getExceptionJsonResult(e, e);
    }

    private String getMessageKey(FieldError error) {
        String errorCode = "";
        String[] codes = error.getCodes();
        if (codes != null && codes.length > 0) {
            errorCode = codes[0];
        }

        return errorCode;
    }

    private String getDefaultMessage(Object e) {
        String msg = "";
        if (e instanceof FieldError) {
            msg = ((FieldError) e).getDefaultMessage();
        } else if (e instanceof JsonResultException) {
            msg = ((JsonResultException) e).getExceptionMessage();
        } else if (e instanceof AccessDeniedException) {
            msg = ((AccessDeniedException) e).getLocalizedMessage();
        } else if (e instanceof Exception) {
            msg = ((Exception) e).getMessage();
        }

        if (msg == null || "".equals(msg)) {
            msg = message.get("com.mobigen.framework.exception.GlobalExceptionHandler");
        }

        return msg;
    }

    private Object[] getArguments(Object e) {
        Object[] arguments = null;
        if (e instanceof FieldError) {
            arguments = ((FieldError) e).getArguments();
        } else if (e instanceof JsonResultException) {
            arguments = ((JsonResultException) e).getArgs();
        }

        return arguments;
    }

    private String getMessageKey(Object e) {
        String key = "";

        if (e instanceof FieldError) {
            key = getMessageKey((FieldError) e);
        } else if (e instanceof JsonResultException) {
            key = ((JsonResultException) e).getMessageKey();
        }

        if (key == null || "".equals(key)) {
            StackTraceElement element = ((Exception) e).getStackTrace()[0];
            key = element.getClassName() + "." + element.getMethodName();
        }

        return key;
    }

    private JsonResult getExceptionJsonResult(Exception exception, Object error) {
        String msg;
        try {
            String key = getMessageKey(error);
            Object[] arguments = getArguments(error);
            msg = message.get(key, arguments);

            if (msg == null || key.equals(msg) || "".equals(msg)) {
                msg = getDefaultMessage(error);
            }
        } catch (Exception e) {
            msg = message.get("com.mobigen.framework.exception.GlobalExceptionHandler");
        }

        JsonResult js = new JsonResult();
        js.setErrorMessage("[IWDF] " + msg);

        // sentry
        // Sentry.captureException(exception, msg);
        return js;
    }

}
