package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class TaskAdapter extends ArrayAdapter<Task> {

	  private final Context context;
	  private final ArrayList<Task> values;

	  public TaskAdapter(Context context, ArrayList<Task> values) {
	    super(context, R.layout.splitlistlayout, values);
	    this.context = context;
	    this.values = values;
	  }

	  @Override
	  public View getView(int position, View convertView, ViewGroup parent) {
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.splitlistlayout, parent, false);
	    TextView taskname = (TextView) rowView.findViewById(R.id.chorename);
	    TextView taskpoints = (TextView) rowView.findViewById(R.id.chorepoints);
	    ImageView icon = (ImageView) rowView.findViewById(R.id.choreicon);
	    Task temptask = values.get(position);
	    taskname.setText(temptask.getName());
	    taskpoints.setText(temptask.getPointString());
	    icon.setImageDrawable(temptask.getIcon());
	    return rowView;
	  }
}
