package finfo.bmp.com.finfo.Fragment;

import java.sql.ResultSet;

public interface ActionDB {
    public ResultSet SelectData() throws Exception;
    public int InsertData() throws Exception;
    public int UPdateData() throws Exception;
    public int DeleteData() throws Exception;

}
