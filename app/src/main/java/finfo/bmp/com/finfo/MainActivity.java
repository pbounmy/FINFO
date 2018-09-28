package finfo.bmp.com.finfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import finfo.bmp.com.finfo.Fragment.FragmentMenu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState ==null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.contentmain,new FragmentMenu())
                    .commit();

        }



    }
}
