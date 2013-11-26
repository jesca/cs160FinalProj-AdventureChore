package edu.cs160.groupj.advenChoreQuest;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

public class taskadd extends Activity {
	Dialog datepicker;
	ImageButton choosedate;
	Button set;
	DatePicker datep;
	Integer month,day,year;
	TextView date;
	private Spinner childrenspinner;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taskadd);
		
	
	//common task button activity
			final ImageButton addtask = (ImageButton) findViewById(R.id.commontasksicon);
	        addtask.setOnClickListener(new View.OnClickListener() {
	            public void onClick(View v) {
	            	 Intent ctpg = new Intent(taskadd.this, Commontasks.class);
	                 startActivity(ctpg);
	                // Perform action on click
	            }
	        });
		
		

	        
	      //back button activity
	      		final ImageButton back = (ImageButton) findViewById(R.id.back);
	              back.setOnClickListener(new View.OnClickListener() {
	                  public void onClick(View v) {
	                  	 Intent back = new Intent(taskadd.this, MainActivity.class);
	                       startActivity(back);
	                      // Perform action on click
	                  }
	              });
		
	              /*
	              
	              //check button activity
	              		final ImageButton ok = (ImageButton) findViewById(R.id.addtask);
	                      ok.setOnClickListener(new View.OnClickListener() {
	                          public void onClick(View v) {
	                          	 //do something on check
	                              
	                          }
	                      });
	                      

	                      choosedate = (ImageButton)findViewById(R.id.calicon);
	                      date = (TextView)findViewById(R.id.duedate);
	               
	                      choosedate.setOnClickListener(new View.OnClickListener() {
	               
	                          @Override
	                          public void onClick(View view) {
	                              // TODO Auto-generated method stub
	                              datepicker = new Dialog(taskadd.this);
	                              datepicker.setContentView(R.layout.datepicker);
	                              datepicker.setTitle("Select Due Date");
	               
	                              datep = (DatePicker)datepicker.findViewById(R.id.datePicker);
	                              set = (Button)datepicker.findViewById(R.id.btnSet);
	               
	                              set.setOnClickListener(new View.OnClickListener() {
	               
	                                  @Override
	                                  public void onClick(View view) {
	                                      // TODO Auto-generated method stub
	                                      month = datep.getMonth();
	                                      day = datep.getDayOfMonth();
	                                      year = datep.getYear();
	                                     
	                                      date.setText("Due date: "+day+"/"+month+"/"+year);
	                                      datepicker.dismiss();
	                                  }
	                              });
	                              datepicker.show();
	               
	                          }
	                      });     
	               
	                      */
	                      
	                      childrenspinner = (Spinner) findViewById(R.id.choosechild);
	                   // Create an ArrayAdapter using the string array and a default spinner layout
	                      ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
	                              R.array.children_array, android.R.layout.simple_spinner_item);
	                      // Specify the layout to use when the list of choices appears
	                      adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	                      // Apply the adapter to the spinner
	                      childrenspinner.setAdapter(adapter);
	                      
	                      
	                      
	                      
	                      
	                  }


                
                      
                      
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		
	
	}

}
