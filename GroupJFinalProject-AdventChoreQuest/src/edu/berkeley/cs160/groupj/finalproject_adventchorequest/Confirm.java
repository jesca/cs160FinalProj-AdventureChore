package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class Confirm extends Activity {

	Context context = getApplicationContext();
	private Task confirmChore;
	int points; 
	CharSequence confirmToast;
	int duration = Toast.LENGTH_LONG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
        Intent in = getIntent();
        confirmChore = in.getParcelableExtra("confirm");
        points = confirmChore.getPoints();
    	confirmToast = "Confirmed! Your child will be notified and " +points + " will be added to his account";
        ((ImageView) findViewById(R.id.confirmImage)).setImageDrawable(confirmChore.getPic());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.confirm, menu);
        return true;
 
    }
    //clicked on check
    public void confirm(View v) {
    	Toast toast = Toast.makeText(context, confirmToast, duration);
    	toast.show();
    }
    
    //clicked on x
    public void deny(View v) {
    	AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setMessage(R.string.denyalert);

        // Set an EditText view to get user input 
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int whichButton) {
          String value = input.getText().toString();
          // Send this value to the kid
          }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
          public void onClick(DialogInterface dialog, int whichButton) {
            // Cancelled.
          }
        });

        alert.show();
    }
    
    
    
    
    
}
