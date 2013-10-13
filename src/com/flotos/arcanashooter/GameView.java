package com.flotos.arcanashooter;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.GestureDetector.SimpleOnGestureListener;


public class GameView extends View {

	//Handler to handle animation sequence timing
	private Handler h;
	
	//Actors for the game
	public Actor archer;
	public Actor arrow;
	public Actor balloon;
	
	//For debugging
	private Paint testPaint;
	
	//Frame rate for animation
	private final int FRAME_RATE = 30;
	
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		h = new Handler();
		
		//Set the actor positions and Costumes
		archer = new Actor(context,50,1000, "bob", R.drawable.archer);
		arrow = new Actor(context,100,150, "arrow", R.drawable.arrow);
		balloon = new Actor(context,50,150, "baloon", R.drawable.blueballoon);
		balloon.setCostume(R.drawable.popballoon, 1);
	}
	
	private Runnable r = new Runnable() {
		//@Override
		public void run() {
			invalidate();
		}
	};
	
	protected void onDraw (Canvas c) {
		
		arrow.goTo(arrow.getX(), arrow.getY()-10);
				
		//Arrow Goes back to Archer
		if (arrow.getX() > c.getWidth()) {
			arrow.goTo(archer.getX(), archer.getY() + 40);
		}
		
		//Logic for Balloon to Pop when touching Arrow
		if ((Math.abs(balloon.getY() - arrow.getY()) < 20) && (Math.abs(balloon.getX() - arrow.getX()) < 20)) {
			balloon.setCurrentCostume(1);
		}
		//Balloon goes back to top of screen
		balloon.goTo(balloon.getX(), balloon.getY() + 10);
		if (balloon.getY() > c.getHeight()) {
			balloon.setCurrentCostume(0);
			balloon.goTo(balloon.getX(), 0);
		}
		
		//Draw the Animation
		c.drawBitmap(archer.getBitMap(), archer.getX(), archer.getY(), null);
		c.drawBitmap(arrow.getBitMap(), arrow.getX(), arrow.getY(), null);
		c.drawBitmap(balloon.getBitMap(), balloon.getX(), balloon.getY(), null);
		h.postDelayed(r, FRAME_RATE);
	}
	
}
