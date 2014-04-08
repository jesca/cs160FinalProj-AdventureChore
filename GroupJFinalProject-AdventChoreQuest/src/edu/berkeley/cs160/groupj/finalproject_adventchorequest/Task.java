package edu.berkeley.cs160.groupj.finalproject_adventchorequest;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

public class Task implements Parcelable {
	private String myname;
	private String mychild;
	private String mydesc;
	private int myworth;
	private int mystatus;
	private Drawable mycon;
	private String myreward;
	private Drawable mypic;
	private static String formatPoints = "%d Points";
	
	public Task(String name, String desc, int points, Drawable icon) {
		this(name,desc,points,icon,0);
	}
	
	public Task(String name, String desc, int points, Drawable icon, int status) {
		myname = name;
		myworth = points;
		mycon = icon;
		mydesc = desc;
		mystatus = status;
		mypic = mycon;
		mychild = myname;
	}
	
	public Task(Drawable pic, String child, String name, int points) {
		mypic = pic;
		mycon = pic;
        mydesc = "";
		mychild = child;
		myname = name;
		myworth = points;
		mystatus =0;
	}
	
	public Task(String child, String name, int points, boolean chore) {
		mychild = child;
		myreward = name;
		myworth = points;
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
	
	public String getChild() {
		return mychild;
	}
	
	public void setPoints(int newpoints) {
		myworth = newpoints;
	}
	
	public int getPoints() {
		return myworth;
	}
	
	public void setStatus(int newstatus) {
		mystatus = newstatus;
	}
	
	public int getStatus() {
		return mystatus;
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
	 
	public Drawable getPic() {
		return mypic;
	}
	public int describeContents() {
         return 0;
    }

	public String getReward() {
		return myreward;
	}
		

     public void writeToParcel(Parcel out, int flags) {
    	 out.writeString(myname);
    	 out.writeString(mydesc);
    	 out.writeInt(myworth);
    	 out.writeInt(mystatus);
    	 Bitmap bitmap = (Bitmap)((BitmapDrawable) mycon).getBitmap();
    	 out.writeParcelable(bitmap, flags);
    	 bitmap = (Bitmap)((BitmapDrawable) mypic).getBitmap();
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
 		 mystatus = in.readInt();
 		 Bitmap bitmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
 		 mycon = new BitmapDrawable(bitmap);
 		 Bitmap picmap = (Bitmap)in.readParcelable(getClass().getClassLoader());
 		 mypic = new BitmapDrawable(bitmap);
     }

}
