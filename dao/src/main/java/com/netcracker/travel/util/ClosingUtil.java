package com.netcracker.travel.util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClosingUtil {

    private ClosingUtil(){}

    public static void close(PreparedStatement statement){
        if(statement != null){
            try{
                statement.close();
            }
            catch(SQLException e){
                SystemLogger.getInstance().logError(ClosingUtil.class, e.getMessage());
            }
        }
    }

    public static void close(ResultSet resultSet){
        if(resultSet != null){
            try{
                resultSet.close();
            }
            catch(SQLException e){
                SystemLogger.getInstance().logError(ClosingUtil.class, e.getMessage());
            }
        }
    }
}
