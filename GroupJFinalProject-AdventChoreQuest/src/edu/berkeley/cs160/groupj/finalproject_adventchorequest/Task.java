package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
	private String myname;
	private String mydesc;
	private int myworth;
	private Drawable mycon;
	private static String formatPoints = "%d Points";
	
	public Task(String name, String desc, int points, Drawable icon) {
		myname = name;
		myworth = points;
		mycon = icon;
		mydesc = desc;
	}
	
	public void setName(String newname) {
		myname = newname;
	}
	
	public String getName() {
		return myname;
	}
	
	public void setDesc(String newdesc) {
		mydesc = newdesc;
	}
	
	public String getDesc() {
		return mydesc;
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
	
	 public int describeContents() {
         return 0;
     }

     public void writeToParcel(Parcel out, int flags) {
    	 out.writeString(myname);
    	 out.writeString(mydesc);
    	 out.writeInt(myworth);
    	 Bitmap bitmap = (Bitmap)((BitmapDrawable) mycon).getBitmap();
    	 out.writeParcelable(bitmap, flags);
     }

     public static final Parcelable.Creator<Task> CREATOR = new Parcelable.Creator<Task>() {
         public Task createFromParcel(Parcel in) {
             return new Task(in);
         }

         public Task[] newArray(int size) {
             return new Task[size];
         }
     };
     
     private Task(Parcel in) {
    	 myname = in.readString();
    	 mydesc = in.readString();
 		 myworth = in.readInt();
 		 Bitmap bitmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
 		 mycon = new BitmapDrawable(bitmap);
     }

}
