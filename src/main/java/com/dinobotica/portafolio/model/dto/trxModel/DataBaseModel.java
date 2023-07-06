package com.dinobotica.portafolio.model.dto.trxModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataBaseModel {
    
    private List<Map<String,Object>> resultData;

    private int updatedRows;

    private String message;

    public DataBaseModel() {

        this.resultData = new ArrayList<>();
        this.updatedRows = 0;
        this.message = "";
    }

    public DataBaseModel(List<Map<String, Object>> resultData) {

        this.resultData = resultData;
        this.updatedRows = 0;
        this.message = "";
    }

    public DataBaseModel(int updatedRows) {

        this.resultData = new ArrayList<>();
        this.updatedRows = updatedRows;
        this.message = "";
    }

    public DataBaseModel(String message) {

        this.resultData = new ArrayList<>();
        this.updatedRows = 0;
        this.message = message;
    }


    public DataBaseModel(List<Map<String, Object>> resultData, int updatedRows, String message) {
        this.resultData = resultData;
        this.updatedRows = updatedRows;
        this.message = message;
    }

    public List<Map<String, Object>> getResultData() {
        return resultData;
    }

    public void setResultData(List<Map<String, Object>> resultData) {
        this.resultData = resultData;
    }

    public int getUpdatedRows() {
        return updatedRows;
    }

    public void setUpdatedRows(int updatedRows) {
        this.updatedRows = updatedRows;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
}
