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
import android.widget.TextView;

import java.sql.Connection;

import finfo.bmp.com.finfo.R;

public class FragmentMenu extends Fragment {
    private Button btnsave,btnselect,btntest;
    private TextView tvresult;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.menufragement,container,false);
        btnsave = v.findViewById(R.id.btnSave);
        btnselect = v.findViewById(R.id.btnSelete);
        btntest =v.findViewById(R.id.btntest);
        tvresult =v.findViewById(R.id.tvconect);
        btntest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                new MyTask().execute("");
            }
        });
        btnselect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentmain,new FragmentShowData())
                        .addToBackStack(null)
                        .commit();
            }
        });


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity()
                        .getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.contentmain,new FragmentInsert())
                        .addToBackStack(null)
                        .commit();
            }
        });


        return v;
    }
   private class MyTask extends AsyncTask<String,String,String>{
        String msg="";
       @Override
       protected void onPreExecute() {
           tvresult.setText("Please wait connecting data");
       }

       @Override
       protected String doInBackground(String... strings) {
           try {
               Connection c = DBConnect.getConnect();
               if(c==null){
                   msg="Connection fail!!!";
               }else{
                   msg="Successful connecting data";
               }
           }catch (Exception e){
               msg="Connection fail!!!";
               e.printStackTrace();
           }
           return msg;
       }

       @Override
       protected void onPostExecute(String s) {
           tvresult.setText(s);
       }
   }
}
