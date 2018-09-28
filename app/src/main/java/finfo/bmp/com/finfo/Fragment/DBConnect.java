package finfo.bmp.com.finfo.Fragment;
import java.sql.*;
public class DBConnect {
    public static Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://192.168.1.2:3306/db2";
            String user="bounmy";
            String pwd="bounmy1234";
            return DriverManager.getConnection(url,user,pwd);
        }catch (Exception e){
            return null;
        }
    }
}
