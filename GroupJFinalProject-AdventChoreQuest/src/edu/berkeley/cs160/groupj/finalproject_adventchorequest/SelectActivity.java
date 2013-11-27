package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class SelectActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select, menu);
		return true;
	}
	
	public void onParentClick(View v) {
		Intent  intent  = new Intent(this, MainActivity.class);
		startActivity(intent);
	}
	
	public void onChildClick(View v) {
		Intent  intent  = new Intent(this, ChildHomePage.class);
		startActivity(intent);
	}

}
