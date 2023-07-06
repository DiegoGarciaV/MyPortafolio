package com.dinobotica.portafolio.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.dinobotica.portafolio.model.dto.trxModel.DataBaseModel;

@Component("ConexionDatos")
public class DataBaseConnection implements IDataBaseConnection{


    @Value("${database.username}")
    private String dataBaseUsername;

    @Value("${database.password}")
    private String dataBasePassword;

    @Value("${database.host:localhost}")
    private String dataBaseHost;

    @Value("${database.port}")
    private String dataBasePort;

    @Value("${database.name}")
    private String dataBaseName;

    @Value("${database.driver:com.mysql.cj.jdbc.Driver}")
    private String dataBaseDriver;
    
    Connection connection = null;

    private static final String CLOSED_DB_CONN = "Database connection closed";

    @Override
    public boolean openConnection() {
        try 
        {
            if(connection != null && !connection.isClosed())
                return true;
            
        } catch (Exception e) {
            System.out.println(e);
        }

        StringBuilder url = new StringBuilder();
        url.append("jdbc:mysql://")
        .append(dataBaseHost)
        .append(":")
        .append(dataBasePort)
        .append("/")
        .append(dataBaseName);

        try 
        {
            Class.forName(dataBaseDriver);
            connection = DriverManager.getConnection( 
                                    url.toString(),
                                    dataBaseUsername,
                                    dataBasePassword
                                );
            return !connection.isClosed();
            
        } catch (Exception e) {
            System.out.println(e);
        }
        

        return false;
    }

    @Override
    public boolean closeConnection() {
        
        try 
        {
            connection.close();
            connection = null;
            return true;

        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean isConnected() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isConnected'");
    }

    @Override
    public DataBaseModel ejecQuery(String sqlq) {

        PreparedStatement consulta = null;
        if(openConnection())
        {
            try 
            {
                
                consulta = connection.prepareStatement(sqlq);
                ResultSet rs = consulta.executeQuery();
                List<Map<String, Object>> resultado = new LinkedList<>();
                while(rs.next())
                {
                    Map<String,Object> registro = new HashMap<>();
                    int i = 0;
                    int cCount = rs.getMetaData().getColumnCount();
                    while(i < cCount)
                    {
                        registro.put(rs.getMetaData().getColumnName(i+1), rs.getString(i+1));
                        i++;
                    }
                    resultado.add(registro);
                }
                return new DataBaseModel(resultado);

            } catch (SQLException e) {
                System.err.println(e);
                return new DataBaseModel(new LinkedList<>(),0,e.getMessage());
            }
            finally
            {
                try 
                {
                    if(consulta != null)
                        consulta.close();
                } 
                catch (SQLException e) 
                {
                    e.printStackTrace();
                }
            }
        }
        return new DataBaseModel(new LinkedList<>());
    }

    @Override
    public DataBaseModel ejecUpdate(String sqlq)
    {
        if(openConnection())
        {
            try(PreparedStatement insertion = connection.prepareStatement(sqlq)) 
            {
                return new DataBaseModel(insertion.executeUpdate());
            } 
            catch (SQLException e) {
                e.printStackTrace();
                return new DataBaseModel(new LinkedList<>(),0,e.toString());
            }
        }
        return new DataBaseModel(new LinkedList<>(),0,CLOSED_DB_CONN);
    }

    @Override
    public DataBaseModel ejecProcedure(String proc, List<Object> params) {
        StringBuilder ejecProcedureQuery = new StringBuilder("CALL ");

        ejecProcedureQuery.append(proc)
        .append("(");
        for(int i = 0; i < params.size(); i++)
        {
            Object param = params.get(i);

            if (param instanceof String || param instanceof Date) {
                ejecProcedureQuery.append("'")
                .append(param)
                .append("'");
            }
            else
                ejecProcedureQuery.append(param);

            if(i < params.size() - 1)
                ejecProcedureQuery.append(",");
        }
        ejecProcedureQuery.append(");");
        return ejecQuery(ejecProcedureQuery.toString());
    }

    @Override
    public DataBaseModel ejecUpdate(String sqlq, Map<String, Object> values) {
        
        int currentAttribute = 0;
        if(openConnection())
        {
            try(PreparedStatement insertion = connection.prepareStatement(sqlq)) 
            {
                currentAttribute = 1;
                for(Map.Entry<String,Object> attribute : values.entrySet())
                {    
                    Object value = attribute.getValue();
                    if(value!=null)
                        value = value.toString();
                    insertion.setString(currentAttribute,(String)value); 
                    currentAttribute++;
                }
                return new DataBaseModel(insertion.executeUpdate());
            } 
            catch (Exception e) {
                return new DataBaseModel(e.getMessage());
            }
        }
        return new DataBaseModel(new LinkedList<>(),0,CLOSED_DB_CONN);

    }

    @Override
    public DataBaseModel ejecUpdate(String sqlq, Map<String, Object> values, List<Map<String,Object>> filter) {
        
        int currentAttribute = 0;
        if(openConnection())
        {
            try(PreparedStatement insertion = connection.prepareStatement(sqlq)) 
            {
                currentAttribute = 1;
                for(Map.Entry<String,Object> attribute : values.entrySet())
                {    
                    Object value = attribute.getValue();
                    if(value!=null)
                        value = value.toString();
                    insertion.setString(currentAttribute,(String)value); 
                    currentAttribute++;
                }

                for(Map<String,Object> restriction : filter)
                {    
                    for(Map.Entry<String,Object> fieldRestriction : restriction.entrySet())
                    {    
                        Object value = fieldRestriction.getValue();
                        if(value!=null)
                            value = value.toString();
                        insertion.setString(currentAttribute,(String)value); 
                        currentAttribute++;
                    }
                }
                return new DataBaseModel(insertion.executeUpdate());
            } 
            catch (Exception e) {
                return new DataBaseModel(e.getMessage());
            }
        }
        return new DataBaseModel(new LinkedList<>(),0,CLOSED_DB_CONN);

    }

    @Override
    public DataBaseModel ejecUpdate(String sqlq, List<Map<String, Object>> values) {

        int currentAttribute = 0;
        if(openConnection())
        {
            try(PreparedStatement insertion = connection.prepareStatement(sqlq)) 
            {
                currentAttribute = 1;
                for(Map<String,Object> register : values)
                {
                    for(Map.Entry<String,Object> attribute : register.entrySet())
                    {    
                        Object value = attribute.getValue();
                        if(value!=null)
                            value = value.toString();
                        insertion.setString(currentAttribute,(String)value); 
                        currentAttribute++;
                    }
                }
                
                return new DataBaseModel(insertion.executeUpdate());
            } 
            catch (Exception e) {
                return new DataBaseModel(e.getMessage());
            }
        }
        return new DataBaseModel(new LinkedList<>(),0,CLOSED_DB_CONN);
    }

    @Override
    public String generateInsertQuery(String table, List<Map<String, Object>> values) {

        StringBuilder insertFieldsQuery = new StringBuilder("(");
        StringBuilder insertValuesQuery = new StringBuilder("(");
        
        if(values.isEmpty())
            return null;

        int currentAttribute = 0;
        Map<String, Object> singleRow = values.get(0);
        for(Map.Entry<String,Object> attribute : singleRow.entrySet())
        {   
            insertFieldsQuery.append(attribute.getKey());
            insertValuesQuery.append("?");
            if(currentAttribute++ < singleRow.size() - 1)
            {
                insertFieldsQuery.append(",");
                insertValuesQuery.append(",");
            }    
            else
            {
                insertFieldsQuery.append(") ");
                insertValuesQuery.append(")");
            }
        }
        
        StringBuilder insertQuery = new StringBuilder("INSERT INTO ")
        .append(table)
        .append(insertFieldsQuery)
        .append(" VALUES ");
        
        for(int i = 0; i < values.size(); i++)
        {
            insertQuery.append(insertValuesQuery);
            if(i < values.size() - 1)
                insertQuery.append(",");
        }

        return insertQuery.toString();

    }

    @Override
    public String generateInsertQuery(String table, Map<String, Object> values) {
        
        StringBuilder insertFieldsQuery = new StringBuilder("INSERT INTO ").append(table).append("(");
        StringBuilder insertValuesQuery = new StringBuilder("VALUES (");
        
        int currentAttribute = 0;
        for(Map.Entry<String,Object> attribute : values.entrySet())
        {   
            insertFieldsQuery.append(attribute.getKey());
            insertValuesQuery.append("?");
            if(currentAttribute++ < values.size() - 1)
            {
                insertFieldsQuery.append(",");
                insertValuesQuery.append(",");
            }    
            else
            {
                insertFieldsQuery.append(") ");
                insertValuesQuery.append(")");
            }
        }

        return insertFieldsQuery.append(insertValuesQuery).toString();
    }
    
    public String generateUpdateQuery(String table, Map<String,Object> values, List<Map<String,Object>> filter)
    {
        StringBuilder updateQuery = new StringBuilder("UPDATE ").append(table).append(" SET ");
        int currentAttribute = 0;
        for(Map.Entry<String,Object> updateValue : values.entrySet())
        {
            updateQuery.append(updateValue.getKey())
            .append(" = ?");
            if(currentAttribute++ < values.size() - 1)
                updateQuery.append(",");
        }

        if(filter!=null && !filter.isEmpty())
        {
            updateQuery.append(" WHERE (");
            int currentRestriction = 0;
            for(Map<String,Object> restriction : filter)
            {
                currentAttribute = 0;
                for(Map.Entry<String,Object> filterRestriction : restriction.entrySet())
                {
                    updateQuery.append(filterRestriction.getKey())
                    .append(" = ?");
                    if(currentAttribute++ < restriction.size() - 1)
                        updateQuery.append(" OR ");
                }
                if(currentRestriction++ < filter.size() - 1)
                        updateQuery.append(") AND (");
                else
                    updateQuery.append(")");
            }
                
        }
        
        
        return updateQuery.append(";").toString();
    }
}
