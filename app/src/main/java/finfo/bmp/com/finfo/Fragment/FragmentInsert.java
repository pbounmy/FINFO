package finfo.bmp.com.finfo.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Connection;

import finfo.bmp.com.finfo.R;

public class FragmentInsert extends Fragment {
    private EditText txtid,txtname,txtsurname,txtaddress;
    private Button btnsave,btnback;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.insertfragment,container,false);
        txtid = v.findViewById(R.id.txtInsertid);
        txtname = v.findViewById(R.id.txtIsertname);
        txtsurname = v.findViewById(R.id.txtInsertsurname);
        txtaddress = v.findViewById(R.id.txtInsertaddress);
        btnsave = v.findViewById(R.id.btnInsert);
        btnback = v.findViewById(R.id.btnback);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new send().execute("");
            }
        });



        return v;
    }
    private class send extends AsyncTask<String,String,String>{
            String msg="";
            String strid = txtid.getText().toString().trim();
            String strname = txtname.getText().toString().trim();
            String strsurname= txtsurname.getText().toString().trim();
            String straddress = txtaddress.getText().toString().trim();

        @Override
        protected void onPreExecute() {
            Toast.makeText(getActivity(), "Please wait inserting data",
                    Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c = DBConnect.getConnect();
                ModelEmployee emp =new ModelEmployee(c);
                emp.setId(strid);
                emp.setName(strname);
                emp.setSurname(strsurname);
                emp.setAddress(straddress);
                int r = emp.InsertData();
                if(r>0){
                    msg="Inserting data complete";

                }else{
                    msg="Can not save data";
                }
                c.close();

            }catch (Exception e){
                msg="Can not save data";
                e.printStackTrace();
            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            Toast.makeText(getActivity(),s,Toast.LENGTH_SHORT).show();
        }
    }
}
