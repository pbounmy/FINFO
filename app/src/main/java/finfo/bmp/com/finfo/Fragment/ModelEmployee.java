package finfo.bmp.com.finfo.Fragment;
import java.sql.*;
public class ModelEmployee implements ActionDB {
    private String id;
    private String name;
    private String surname;
    private String address;
    Connection c;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ModelEmployee(Connection c) {
        this.c = c;
    }

    @Override
    public ResultSet SelectData() throws Exception {
        String sql="select * from employee";
        ResultSet rs = c.createStatement().executeQuery(sql);
        return rs;
    }
    public ResultSet SelectDataByval() throws Exception{
        String sql="select * from employee where id=?";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,id);
        ResultSet rs =ps.executeQuery();
        return rs;
    }

    @Override
    public int InsertData() throws Exception {
        String sql="Insert into employee(id,name,surname,address) values(?,?,?,?)";
        PreparedStatement ps = c.prepareStatement(sql);
        ps.setString(1,id);
        ps.setString(2,name);
        ps.setString(3,surname);
        ps.setString(4,address);
        return ps.executeUpdate();
    }

    @Override
    public int UPdateData() throws Exception {
        return 0;
    }

    @Override
    public int DeleteData() throws Exception {
        return 0;
    }
}
