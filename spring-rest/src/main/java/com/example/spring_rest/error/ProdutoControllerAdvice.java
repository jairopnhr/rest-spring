package com.example.spring_rest.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;


@ControllerAdvice
public class ProdutoControllerAdvice {

    @ExceptionHandler(NotFoundProdutoException.class)
    public ResponseEntity<ErrorDetails> notFoundProdutoException(NotFoundProdutoException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = createErrorDetails(ex, request, "O produto solicitado não foi encontrado", "Produto não encontrado");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ProdutoNullException.class)
    public ResponseEntity<ErrorDetails> produtoNullException(ProdutoNullException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = createErrorDetails(ex, request, "Produto nulo", "Nenhum produto foi fornecido");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProdutoPriceException.class)
    public ResponseEntity<ErrorDetails> produtoPriceException(ProdutoPriceException ex, HttpServletRequest request) {
        ErrorDetails errorDetails = createErrorDetails(ex, request, "O preço do produto é inválido", "Preço inválido para o produto");
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    // Método auxiliar para criar o objeto ErrorDetails
    private ErrorDetails createErrorDetails(Exception ex, HttpServletRequest request, String details, String userMessage) {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setCode(HttpStatus.BAD_REQUEST.value());
        errorDetails.setMensagem(ex.getMessage());
        errorDetails.setTimestamp(System.currentTimeMillis());
        errorDetails.setPath(request.getRequestURI());
        errorDetails.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDetails.setError(HttpStatus.BAD_REQUEST.getReasonPhrase());
        errorDetails.setDetails(details);
        errorDetails.setException(ex.getClass().getName());
        errorDetails.setUserMessage(userMessage);
        errorDetails.setMethod(request.getMethod());
        errorDetails.setIpAddress(request.getRemoteAddr());
        errorDetails.setRequestId(request.getHeader("X-Request-Id"));
        return errorDetails;
    }
}


