package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;

public class ChoreActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chore);
		final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(new TabListener<FragmentTab1>(this, "tab1",FragmentTab1.class)));
        actionBar.addTab(actionBar.newTab().setText("Character").setTabListener(new TabListener<FragmentTab2>(this, "tab2",FragmentTab2.class)));
        actionBar.addTab(actionBar.newTab().setText("Store").setTabListener(new TabListener<FragmentTab2>(this, "tab3",FragmentTab2.class)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.chore, menu);
		return true;
	}
	
	public void confirmCompletion() {
		Intent confirm = new Intent(this, CameraActivity.class);
		startActivity(confirm);
	}

}
