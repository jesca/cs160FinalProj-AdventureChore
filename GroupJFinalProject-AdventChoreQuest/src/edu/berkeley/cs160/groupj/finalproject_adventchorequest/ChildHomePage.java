package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ChildHomePage extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_home_page);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.child_home_page, menu);
        return true;
    }
    
}
