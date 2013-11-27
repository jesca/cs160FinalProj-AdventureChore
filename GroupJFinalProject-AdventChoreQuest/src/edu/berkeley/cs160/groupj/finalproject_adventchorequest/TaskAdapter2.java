package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;

public class TaskAdapter2 extends ArrayAdapter<Task> {

	  private final Context context;
	  private final ArrayList<Task> values;

	  public TaskAdapter2(Context context, ArrayList<Task> values) {
	    super(context, R.layout.splitlist2, values);
	    this.context = context;
	    this.values = values;
	  }

	  @SuppressLint("ShowToast")
	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.splitlist2, parent, false);
	    TextView taskname = (TextView) rowView.findViewById(R.id.chorename);
	    ImageView icon = (ImageView) rowView.findViewById(R.id.choreicon);
	    Task temptask = values.get(position);
	    taskname.setText(temptask.getName());
	    icon.setImageDrawable(temptask.getIcon());
	    return rowView;
	  }
}
