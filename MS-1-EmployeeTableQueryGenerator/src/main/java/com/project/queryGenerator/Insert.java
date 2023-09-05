package com.project.queryGenerator;

import org.springframework.stereotype.Component;

@Component
public class Insert {
    public String getInsertQuery(String tableName, String[] columns) {
    	//Insert Query
    	StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder placeholders = new StringBuilder(" VALUES (");

        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]);
            placeholders.append("?");
            if (i < columns.length - 1) {
                sql.append(", ");
                placeholders.append(", ");
            }
        }
        sql.append(")").append(placeholders).append(")");
        return sql.toString();
    }
    //Login Logout Implementation
    public String insertLoginCred(String tableName, String[] columns) {
    	//Insert Query Building
    	StringBuilder sql = new StringBuilder("INSERT INTO " + tableName + " (");
        StringBuilder placeholders = new StringBuilder(" VALUES (");

        for (int i = 0; i < columns.length; i++) {
            sql.append(columns[i]);
            placeholders.append("?");
            if (i < columns.length - 1) {
                sql.append(", ");
                placeholders.append(", ");
            }
        }
        sql.append(")").append(placeholders).append(")");
//        sql.append(";"); not needed I guess
        return sql.toString();
    }
    //Login Logout Implementation Done
}

