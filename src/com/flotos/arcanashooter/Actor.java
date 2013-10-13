package com.flotos.arcanashooter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

public class Actor {
private Context mContext;

	//location of Actor
	private int x;
	private int y;
	
	//name
	private String name;
	
	//refers to the drawable resource
	private int costume;
	private int currentCostume;
	
	//Array to store 10 possible Costumes
	//need to convert to a mutable array ?hashmap?
	private BitmapDrawable[] graphic = new BitmapDrawable[10];
		
	//constructor
		public Actor (Context context,int xSet, int ySet, String n, int outfit){
			x = xSet;
			y = ySet;
			name = n;
			costume = outfit;
			currentCostume = 0;
			mContext = context;
			graphic[0] = (BitmapDrawable)mContext.getResources().getDrawable(costume);
		} // End Constructor
		
		//Set Functions
		public void goTo (int xPos, int yPos) {
			x = xPos;
			y = yPos;
		} //End goto()
		
		//Sets Costume to graphics array at index
		public void setCostume (int c, int i) {
			graphic[i] = (BitmapDrawable)mContext.getResources().getDrawable(c);
		} // End setCostume()
		
		public void setCurrentCostume(int i){
			currentCostume = i;
		} // end setCurrentCostume()

		//Get Functions
		
		public int getX(){
			return x;
		}
		public int getY(){
			return y;
		}
		public String getName(){
			return name;
		}
		public int getCostume(){
			return costume;
		}
		public Bitmap getBitMap(){
			return graphic[currentCostume].getBitmap();
		}
		public Bitmap getBitMapAtIndex(int i){
			return graphic[i].getBitmap();
		}
		
		
}
