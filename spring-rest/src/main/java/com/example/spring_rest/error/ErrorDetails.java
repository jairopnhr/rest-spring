package com.example.spring_rest.error;

public class ErrorDetails {

    private int code; // Código específico do erro
    private String mensagem; // Mensagem de erro
    private Long timestamp; // Timestamp do momento do erro
    private String path; // Caminho da requisição que gerou o erro
    private int status; // Status HTTP (ex: 404, 500)
    private String error; // Descrição curta do erro (ex: "Not Found", "Internal Server Error")
    private String details; // Detalhes adicionais sobre o erro
    private String exception; // Nome da exceção lançada
    private String userMessage; // Mensagem amigável para o usuário final
    private String method; // Método HTTP utilizado na requisição (GET, POST, etc.)
    private String ipAddress; // Endereço IP de quem fez a requisição
    private String requestId; // ID único da requisição para rastreamento

    // Construtor padrão
    public ErrorDetails() {
    }

    // Construtor completo
    public ErrorDetails(int code, String mensagem, Long timestamp, String path, int status, String error, String details,
                        String exception, String userMessage, String method, String ipAddress, String requestId) {
        this.code = code;
        this.mensagem = mensagem;
        this.timestamp = timestamp;
        this.path = path;
        this.status = status;
        this.error = error;
        this.details = details;
        this.exception = exception;
        this.userMessage = userMessage;
        this.method = method;
        this.ipAddress = ipAddress;
        this.requestId = requestId;
    }

    // Getters e Setters
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getException() {
        return exception;
    }

    public void setException(String exception) {
        this.exception = exception;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }
}
