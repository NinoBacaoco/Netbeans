/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.csit228g3.nabua.nabua_final_project;
import com.csit228g3.nabua.nabua_final_project.MySQLConnection.Query;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author RONNA
 */
public class DBHelper {
    public Query query;
    
    public DBHelper(){
        try {
            query = new MySQLConnection.Query();
        } catch (SQLException ex) {
            Logger.getLogger(DBHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //add user modify!!!!!!!!!!!!!
    public void addUser(int user_id, String firstname, String lastname, int age, String gender, float height, float weight) throws SQLException {
        //DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //LocalDate parsedDate = LocalDate.parse(date, formatter);
        
        String values = String.format("%d, ,'%s', '%s', %d, '%s', %f, %f", user_id, firstname, lastname, age, gender, height, weight);
        query.update("INSERT INTO tbluserinfo (user_id, firstname, lastname, age, gender, height, weight) values (" + values + ")");
    }
    
    public ResultSet getUser() throws SQLException{
        return query.execute("SELECT * FROM tbluserinfo");
    }
    
    public void close() throws SQLException{
        query.close();
    }
    
    public static void main(String[] args){
        try{
            DBHelper dbHelper = new DBHelper();
            dbHelper.addUser(1,"Jolly","Hotdog",12,"Male",12,23);
        }catch (SQLException ex){
            
        }
    }
}
