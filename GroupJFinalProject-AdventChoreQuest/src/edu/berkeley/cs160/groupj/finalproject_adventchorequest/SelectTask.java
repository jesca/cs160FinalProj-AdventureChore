package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import java.util.ArrayList;

import android.app.ActionBar;
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
import android.util.Log;

public class SelectTask extends Activity {
	private ArrayList<Task> tasks;
	private TaskAdapter2 tadapt2;
	private Resources res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_task);
		final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(new TabListener<FragmentTab1>(this, "tab1",FragmentTab1.class)));
        actionBar.addTab(actionBar.newTab().setText("Children").setTabListener(new TabListener<FragmentTab2>(this, "tab2",FragmentTab2.class)));
		res = getResources();
		final ListView listview2 = (ListView) findViewById(R.id.listView2);
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
        tadapt2 = new TaskAdapter2(this, tasks);
        listview2.setAdapter(tadapt2);
        listview2.setOnItemClickListener(new OnItemClickListener() {
       	 
            @Override
            public void onItemClick(AdapterView parent, View v,
                    int position, long id) {
            	Intent i = new Intent(SelectTask.this, TaskAdd.class);
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
