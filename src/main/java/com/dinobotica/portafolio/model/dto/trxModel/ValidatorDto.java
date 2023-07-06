package com.dinobotica.portafolio.model.dto.trxModel;


public class ValidatorDto {
    
    private int responseCode;

    private String responseMessage;

    private String token;

    private int idRol;

    private String username;
    
    public ValidatorDto(int responseCode, String responseMessage, String token, int idRol, String username) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.token = token;
        this.idRol = idRol;
        this.username = username;
    }


    public int getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public String getToken() {
        return token;
    }

    public int getIdRol() {
        return idRol;
    }

    public String getUsername() {
        return username;
    }

    

    
}
