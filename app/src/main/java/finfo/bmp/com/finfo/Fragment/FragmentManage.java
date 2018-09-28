package finfo.bmp.com.finfo.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import finfo.bmp.com.finfo.R;

public class FragmentManage extends Fragment {
    String empid="";
    public static FragmentManage getdatafragmen(String strid){
        FragmentManage obj = new FragmentManage();
        Bundle bun = new Bundle();
        bun.putString("keyid",strid);
        obj.setArguments(bun);
        return obj;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        empid =getArguments().getString("keyid");

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.managefragment,container,false);


        return v;
    }
}
