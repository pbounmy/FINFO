package finfo.bmp.com.finfo.Fragment;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import finfo.bmp.com.finfo.R;

public class FragmentShowData extends Fragment {
    private Button btnLoad;
    private TextView tvstate;
    private ListView lvitm;
    ArrayList<String> arrname = new ArrayList<String>();
    ArrayList<String> arrnid = new ArrayList<String>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.selectfragment,container,false);
        btnLoad = v.findViewById(R.id.btnload);
        tvstate =v.findViewById(R.id.tvstate);
        lvitm = v.findViewById(R.id.lvitm);

        lvitm.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               String str = String.valueOf(position);
                Toast.makeText(getActivity(), str, Toast.LENGTH_SHORT).show();
            }
        });
        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               new getdata().execute("");
            }
        });


        return v;
    }
    private class getdata extends AsyncTask<String,String,String>{

        ArrayAdapter<String> adt;
        String msg="";

        @Override
        protected void onPreExecute() {
            tvstate.setText("Please wait ....");
        }
        @Override
        protected String doInBackground(String... strings) {
            try {
                Connection c =DBConnect.getConnect();
                ModelEmployee emp = new ModelEmployee(c);
                ResultSet rs = emp.SelectData();
                arrname.clear();
                arrnid.clear();
                while (rs.next()){
                    arrnid.add(rs.getString("id"));
                    arrname.add(rs.getString("name"));
                }
                rs.close();
            }catch (Exception e){
                msg ="can not load data";
                e.printStackTrace();
            }

            return msg;
        }

        @Override
        protected void onPostExecute(String s) {
            adt = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,arrname);
            lvitm.setAdapter(adt);
            tvstate.setText(s);
        }
    }
}
