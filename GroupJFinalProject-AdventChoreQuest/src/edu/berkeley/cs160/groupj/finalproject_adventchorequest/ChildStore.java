package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TextView;

public class ChildStore extends Activity {
	private Resources res;
	private String name = "James";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_child_store);
		final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(new TabListener<FragmentTab1>(this, "tab1",FragmentTab1.class)));
        actionBar.addTab(actionBar.newTab().setText("Character").setTabListener(new TabListener<FragmentTab2>(this, "tab2",FragmentTab2.class)));
        actionBar.addTab(actionBar.newTab().setText("Store").setTabListener(new TabListener<FragmentTab2>(this, "tab3",FragmentTab2.class)));
        res = getResources();
        ((TextView) findViewById(R.id.homeName)).setText(String.format(res.getString(R.string.title), name));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.child_store, menu);
		return true;
	}

}
