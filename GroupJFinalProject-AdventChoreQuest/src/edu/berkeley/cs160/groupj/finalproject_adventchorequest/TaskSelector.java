package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class TaskSelector extends Activity {
	private ArrayList<Task> tasks;
	private TaskAdapter2 tadapt2;
	private Resources res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		res = getResources();
		final ListView listview = (ListView) findViewById(R.id.listView1);
        tasks = new ArrayList<Task>();
        Drawable trash = res.getDrawable(R.drawable.trash);
        Drawable laundry = res.getDrawable(R.drawable.laundry);
        Drawable room = res.getDrawable(R.drawable.room);
        Drawable lawn = res.getDrawable(R.drawable.lawn);
        Drawable dishes = res.getDrawable(R.drawable.dishes);
        Drawable custom = res.getDrawable(R.drawable.commontasks);

        tasks.add(new Task("Custom Task",-1, custom));
        tasks.add(new Task("Mow Lawn",2, lawn));
        tasks.add(new Task("Take Out Trash",2, trash));
        tasks.add(new Task("Clean Room",2, room));
        tasks.add(new Task("Wash Laundry",2, laundry));
        tasks.add(new Task("Do dishes",2, dishes));

        //chores = new ArrayList<String>(Arrays.asList("Rake Leaves - 2 point", "Vacuum - 3 points", "Garden - 7 points", "Walk Dog - 2 points", "Do Homework - 3 points", "Laundry - 5 points", "Dishes - 3 points", "Clean Room - 4 points", "Take Out Trash - 2 points"));
        //aadapt = new ArrayAdapter<String>(this, R.layout.listviewlayout, chores);
        tadapt2 = new TaskAdapter2(this, tasks);
        listview.setAdapter(tadapt2);
        listview.setOnItemClickListener(new OnItemClickListener() {
       	 
            @Override
            public void onItemClick(AdapterView parent, View v,
                    int position, long id) {
            	Intent i = new Intent(TaskSelector.this, TaskAdd.class);
            	startActivity(i);
            }
        });
    }

	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
