package edu.berkeley.cs160.groupj.finalproject_adventchorequest;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
 
public class MainActivity extends Activity {
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<Task>> listDataChild;
    List<String> listDataDisplay;
    Button button;
    ArrayList<Task> complete  = new ArrayList<Task>();
    ArrayList<Task> reward = new ArrayList<Task>();
    Drawable hi;
    Resources res;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       button = (Button) findViewById(R.id.groups_button_bg);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(MainActivity.this, SelectTask.class);
                startActivity(i);
                
            }
        });
        res = getResources();
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        expListView.setClickable(true);
        hi = res.getDrawable(R.drawable.ic_launcher);
        prepareListData();

        
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(new TabListener<FragmentTab1>(this, "tab1",FragmentTab1.class)));
        actionBar.addTab(actionBar.newTab().setText("Children").setTabListener(new TabListener<FragmentTab2>(this, "tab2",FragmentTab2.class)));
        //expListView.expandGroup(0);       
        //expListView.expandGroup(1);
        

        if (savedInstanceState != null) {
        	actionBar.setSelectedNavigationItem(savedInstanceState.getInt(
        	"selectedTab", 0));
        	}
        
        // Listview Group click listener
        expListView.setOnGroupClickListener(new OnGroupClickListener() {
 
        
        
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v,
                    int groupPosition, long id) {
                // Toast.makeText(getApplicationContext(),
                // "Group Clicked " + listDataHeader.get(groupPosition),
                // Toast.LENGTH_SHORT).show();
                return false;
            }
        });
 
        // Listview Group expanded listener
        expListView.setOnGroupExpandListener(new OnGroupExpandListener() {
 
            @Override
            public void onGroupExpand(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        listDataDisplay.get(groupPosition) +" Expanded",
                        Toast.LENGTH_SHORT).show();*/
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                /*Toast.makeText(getApplicationContext(),
                        listDataDisplay.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();*/
 
            }
        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
            	Intent confirmIntent = new Intent(MainActivity.this, Confirm2.class);
            	if (groupPosition==0) {
        		confirmIntent.putExtra("confirm", listDataChild.get(listDataHeader.get(groupPosition)).get(childPosition));
        		startActivity(confirmIntent);
            	}
                return true;
            }
        });
       
    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
    	super.onSaveInstanceState(outState);
    	outState.putInt("selectedTab", getActionBar().getSelectedNavigationIndex());
    }
    /*
     * Preparing the list data
     */
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<Task>>();
        listDataDisplay = new ArrayList<String>();
        
        
        
    
        
        // Adding child data
        complete.add(new Task(hi,"Kyle", "Mowed Lawn", 5));
        complete.add(new Task(hi, "Sarah", "Cleaned bathroom", 5));
        complete.add(new Task(hi, "James", "Washed dishes", 5));
        


        
        
 //reward data
        reward.add(new Task("John", "League of Legends",0,true));
        reward.add(new Task("Sarah", "Hello Kitty",0,true));
        reward.add(new Task("Kyle", "Pokemon",0,true));
       
        // Adding child data
        listDataDisplay.add("Task List");
        listDataDisplay.add("Reward List");
        listDataHeader.add("You have " +complete.size() + " tasks to be reviewed");
        listDataHeader.add("You have " +reward.size() + " rewards to be assigned");
        // adding header, child data
        listDataChild.put(listDataHeader.get(0), complete); 
        listDataChild.put(listDataHeader.get(1), reward);
       

    }
}