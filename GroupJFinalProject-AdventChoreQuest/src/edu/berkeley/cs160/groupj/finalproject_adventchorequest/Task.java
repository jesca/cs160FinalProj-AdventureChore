package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.graphics.drawable.Drawable;

public class Task {
	private String myname;
	private int myworth;
	private Drawable mycon;
	private static String formatPoints = "%d Points";
	
	public Task(String name, int points, Drawable icon) {
		myname = name;
		myworth = points;
		mycon = icon;
	}
	
	public void setName(String newname) {
		myname = newname;
	}
	
	public String getName() {
		return myname;
	}
	
	public void setPoints(int newpoints) {
		myworth = newpoints;
	}
	
	public int getPoints() {
		return myworth;
	}
	
	public String getPointString() {
		return String.format(formatPoints, myworth);
	}
	
	public void setIcon(Drawable newIcon) {
		mycon = newIcon;
	}
	
	public Drawable getIcon() {
		return mycon;
	}

}
