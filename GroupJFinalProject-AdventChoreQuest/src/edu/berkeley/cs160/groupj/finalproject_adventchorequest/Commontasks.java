package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Commontasks extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.commontasks);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.commontasks, menu);
		return true;
	}

}
