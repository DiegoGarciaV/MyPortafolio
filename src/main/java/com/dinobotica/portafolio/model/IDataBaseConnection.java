package com.dinobotica.portafolio.model;

import java.util.List;
import java.util.Map;

import com.dinobotica.portafolio.model.dto.trxModel.DataBaseModel;

public interface IDataBaseConnection {
    
    public boolean openConnection();

    public boolean closeConnection();

    public boolean isConnected();

    public DataBaseModel ejecQuery(String sqlq);

    public DataBaseModel ejecUpdate(String sqlq);

    public DataBaseModel ejecUpdate(String sqlq, Map<String,Object> values);

    public DataBaseModel ejecUpdate(String sqlq, List<Map<String,Object>> values);

    public DataBaseModel ejecUpdate(String sqlq, Map<String,Object> values, List<Map<String,Object>> filter);

    public DataBaseModel ejecProcedure(String proc, List<Object> params);

    public String generateInsertQuery(String table, Map<String,Object> values);

    public String generateInsertQuery(String table, List<Map<String,Object>> values);

    public String generateUpdateQuery(String table, Map<String,Object> values, List<Map<String,Object>> filter);
    
}
