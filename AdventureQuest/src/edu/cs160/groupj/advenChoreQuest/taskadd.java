package edu.cs160.groupj.advenChoreQuest;

import java.util.Calendar;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class taskadd extends Activity {
	Dialog datepicker;
	ImageButton choosedate;
	Button set;
	DatePicker datep;
	TextView date;
	private Spinner childrenspinner;

	private int mYear;
	private int mMonth;
	private int mDay;
	static final int DATE_DIALOG_ID = 0;

	private EditText mDateDisplay;
	private ImageButton mPickDate;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.taskadd);
		EditText paragraph = (EditText) findViewById(R.id.editText1);
		paragraph.setLines(3);
		paragraph.setMaxLines(3);
		final EditText header = (EditText) findViewById(R.id.nameoftask);
		header.setMaxLines(1);
		header.setMaxEms(18);
		mDateDisplay = (EditText) findViewById(R.id.ShowMyDate);        
		    mPickDate = (ImageButton) findViewById(R.id.dateicon);
		    
		    mPickDate.setOnClickListener(new View.OnClickListener() {
		        public void onClick(View v) {
		            showDialog(DATE_DIALOG_ID);
		        }
		    });

		    // get the current date
		    final Calendar c = Calendar.getInstance();
		    mYear = c.get(Calendar.YEAR);
		    mMonth = c.get(Calendar.MONTH);
		    mDay = c.get(Calendar.DAY_OF_MONTH);

		    // display the current date
		    updateDisplay();
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
	              final ImageButton ok = (ImageButton) findViewById(R.id.assign);
	              ok.setOnClickListener(new View.OnClickListener() {
	                  public void onClick(View v) {
	                	  Toast.makeText(getApplicationContext(), "Task Assigned: " + header.getText(), Toast.LENGTH_SHORT).show();
	                  	 Intent ok = new Intent(taskadd.this, MainActivity.class);
	                       startActivity(ok);
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
	private void updateDisplay() {
	    this.mDateDisplay.setText(
	        new StringBuilder()
	                // Month is 0 based so add 1
	                .append(mMonth + 1).append("-")
	                .append(mDay).append("-")
	                .append(mYear).append(" "));
	}
	private DatePickerDialog.OnDateSetListener mDateSetListener =
		    new DatePickerDialog.OnDateSetListener() {
		        public void onDateSet(DatePicker view, int year, 
		                              int monthOfYear, int dayOfMonth) {
		            mYear = year;
		            mMonth = monthOfYear;
		            mDay = dayOfMonth;
		            updateDisplay();
		        }
		    };
		    @Override
		    protected Dialog onCreateDialog(int id) {
		       switch (id) {
		       case DATE_DIALOG_ID:
		          return new DatePickerDialog(this,
		                    mDateSetListener,
		                    mYear, mMonth, mDay);
		       }
		       return null;
		    }
}
