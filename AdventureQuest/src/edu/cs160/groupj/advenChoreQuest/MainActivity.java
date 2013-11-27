package edu.cs160.groupj.advenChoreQuest;
 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;



import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnChildClickListener;
import android.widget.ExpandableListView.OnGroupClickListener;
import android.widget.ExpandableListView.OnGroupCollapseListener;
import android.widget.ExpandableListView.OnGroupExpandListener;
import android.widget.Toast;
import edu.cs160.groupj.advenChoreQuest.taskadd;
import edu.cs160.groupj.advenChoreQuest.R;
 
public class MainActivity extends Activity {
 
    ExpandableListAdapter listAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    List<String> listDataDisplay;
    Button button;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
       button = (Button) findViewById(R.id.groups_button_bg);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            	Intent i = new Intent(MainActivity.this, taskadd.class);
                startActivity(i);
                
            }
        });
        // get the listview
        expListView = (ExpandableListView) findViewById(R.id.lvExp);
        
        // preparing list data
        prepareListData();
 
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);
 
        // setting list adapter
        expListView.setAdapter(listAdapter);

        final ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        actionBar.addTab(actionBar.newTab().setText("Home").setTabListener(new TabListener<FragmentTab1>(this, "tab1",FragmentTab1.class)));
        actionBar.addTab(actionBar.newTab().setText("Children").setTabListener(new TabListener<FragmentTab2>(this, "tab2",FragmentTab2.class)));
        expListView.expandGroup(0);       
        expListView.expandGroup(1);
        

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
                Toast.makeText(getApplicationContext(),
                        listDataDisplay.get(groupPosition) +" Expanded",
                        Toast.LENGTH_SHORT).show();
            }
        });
 
        // Listview Group collasped listener
        expListView.setOnGroupCollapseListener(new OnGroupCollapseListener() {
 
            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(getApplicationContext(),
                        listDataDisplay.get(groupPosition) + " Collapsed",
                        Toast.LENGTH_SHORT).show();
 
            }
        });
 
        // Listview on child click listener
        expListView.setOnChildClickListener(new OnChildClickListener() {
 
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                    int groupPosition, int childPosition, long id) {
                
                return false;
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
        listDataChild = new HashMap<String, List<String>>();
 
        listDataDisplay = new ArrayList<String>();
        
        // Adding child data
        List<String> complete  = new ArrayList<String>();
        complete.add("James: " + "Do Laundry");
        complete.add("Jennifer: " + "Clean Bathroom");
        complete.add("Jack: " + "Check Mailbox");
        complete.add("James: " + "Clean Dishes");
        complete.add("Jennifer: " + "Vacuum Floor");


        
        
 
        List<String> reward = new ArrayList<String>();
        reward.add("James: " + "Counter Strike");
        reward.add("Jennifer: " + "Hello Kity");
        reward.add("Jack: " + "Play Time");
        reward.add("James: " + "League of Legends");
        listDataDisplay.add("Task List");
        listDataDisplay.add("Reward List");
        // Adding child data
        listDataHeader.add("You have " +complete.size() + " tasks to be reviewed");
        listDataHeader.add("You have " +reward.size() + " rewards to be assigned");
        listDataChild.put(listDataHeader.get(0), complete); // Header, Child data
        listDataChild.put(listDataHeader.get(1), reward);
       

    }
}