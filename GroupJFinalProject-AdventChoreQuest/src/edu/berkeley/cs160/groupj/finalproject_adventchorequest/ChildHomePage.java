package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import java.util.ArrayList;
import java.util.Arrays;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ChildHomePage extends ActionBarActivity {
	
	private int level=5;
	private int exp=20;
	private String guildlevel = "Bronze";
	private String guild = "Knight";
	private ProgressBar levelprogress;
	private Resources res;
	private TextView leveldesc;
	private String name = "Kyle";
	//private ArrayList<String> chores;
	private ArrayList<Task> chores;
	//private ArrayAdapter<String> aadapt;
	private TaskAdapter tadapt;
	private ActionBar abar;
	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_home_page);
    	abar = getActionBar();
    	abar.setDisplayShowHomeEnabled(false);
    	abar.setDisplayShowTitleEnabled(false);
        res = getResources();
        ((TextView) findViewById(R.id.homeName)).setText(String.format(res.getString(R.string.title), name));
        leveldesc = (TextView) findViewById(R.id.childleveltype);
        leveldesc.setText(String.format(res.getString(R.string.leveldesc), level, guildlevel, guild));
        levelprogress = (ProgressBar) findViewById(R.id.levelProgressHome);
        levelprogress.setProgress(exp);
        Drawable ticon = res.getDrawable(R.drawable.ic_launcher);
        final ListView listview = (ListView) findViewById(R.id.listView1);
        chores = new ArrayList<Task>();
        chores.add(new Task("Rake Leaves", 5, ticon));
        chores.add(new Task("Vaccuum", 3, ticon));
        //chores = new ArrayList<String>(Arrays.asList("Rake Leaves - 2 point", "Vacuum - 3 points", "Garden - 7 points", "Walk Dog - 2 points", "Do Homework - 3 points", "Laundry - 5 points", "Dishes - 3 points", "Clean Room - 4 points", "Take Out Trash - 2 points"));
        //aadapt = new ArrayAdapter<String>(this, R.layout.listviewlayout, chores);
        tadapt = new TaskAdapter(this, chores);
        listview.setAdapter(tadapt);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.child_home_page, menu);
        return true;
    }
    
}
