package edu.berkeley.cs160.groupj.finalproject_adventchorequest;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import edu.berkeley.cs160.groupj.finalproject_adventchorequest.R;

public class FragmentTab2 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
		Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.simple, container, false);
		return v;
		}
}