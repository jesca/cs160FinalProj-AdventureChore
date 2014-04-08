package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ChoreActivity extends ActionBarActivity {
	private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private String loc = Environment.getExternalStorageDirectory() +"/AdvenChoreQuest/";
	private Task mchor;
	private Resources res;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chore);
		final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(new TabListener<FragmentTab1>(this, "tab1",FragmentTab1.class)));
        actionBar.addTab(actionBar.newTab().setText("Character").setTabListener(new TabListener<FragmentTab2>(this, "tab2",FragmentTab2.class)));
        actionBar.addTab(actionBar.newTab().setText("Store").setTabListener(new TabListener<FragmentTab2>(this, "tab3",FragmentTab2.class)));
        Intent in = getIntent();
        mchor = in.getParcelableExtra("Task");
        actionBar.setTitle(mchor.getName());
        res = getResources();
        ((TextView) findViewById(R.id.choreTitle)).setText(mchor.getName());
        ((TextView) findViewById(R.id.choreDesc)).setText(mchor.getDesc());
        TextView tempstatus = (TextView) findViewById(R.id.choreStatus);
        switch (mchor.getStatus()) {
        	default:
        		tempstatus.setText(String.format(res.getString(R.string.status), "Unfinished"));
        		break;
        	case 1:
        		tempstatus.setText(String.format(res.getString(R.string.status), "Waiting on Parent"));
        		break;
        	case 2:
        		tempstatus.setText(String.format(res.getString(R.string.status), "Needs to be Fixed"));
        		break;
        	case 3:
        		tempstatus.setText(String.format(res.getString(R.string.status), "Completed"));
        		break;
        }
        ((TextView) findViewById(R.id.choreDesc)).setText(mchor.getDesc());
        ((ImageView) findViewById(R.id.chorePageIcon)).setImageDrawable(mchor.getIcon());
        ((TextView) findViewById(R.id.chorePoints)).setText(String.format(res.getString(R.string.chorePoints), mchor.getPoints()));
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
	
	public void onClick(View v) {
		Intent	intent	=	new	Intent(MediaStore.ACTION_IMAGE_CAPTURE);	
		Uri	fileUri	= Uri.parse("file://"+loc+mchor.getName()+".png");
		//create a file	to save	the	image	
		intent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);		
		//set the image	file name						
		//start	the	image capture Intent	
		startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
	}
	protected void onActivityResult(int requestCode, int resultCode, 
			Intent data) {
		Log.v("Camera", "Finished Taking Picture");
			if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) { 
				if (resultCode == RESULT_OK) { 
					Log.v("Camera", "Result Ok");
				     // Image captured and saved to fileUri specified in the Intent
						Intent i = new Intent(this, ChildHomePage.class);
						startActivity(i);
				} else if (resultCode == RESULT_CANCELED) {
					Log.v("Camera", "Cancelled");
				} else { 
					// Image capture failed, advise user
					Toast.makeText(ChoreActivity.this, "Camera Failed Please Try Again", Toast.LENGTH_LONG).show();
				} 
			}
		}

}
