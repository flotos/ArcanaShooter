package com.flotos.arcanashooter;

import android.hardware.SensorManager;
import android.os.Bundle;
import android.app.Activity;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.widget.TextView;
import android.app.Activity;
import android.view.Menu;

public class ArcanaShooter extends Activity {

	//Declare the View
	private GameView gameView;
	//Declare the Listeners
	
	GestureDetector gestureDetector; // Listen for touches
	//public TextView texttouch;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arcana_shooter);
        gameView = (GameView) findViewById(R.id.gameView);
       //textTouch = (TextView)  findViewById(R.id.textTouch); 
       
        gestureDetector = new GestureDetector(this, gestureListener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.arcana_shooter, menu);
        return true;
    }
    
    //Called when the user touches the screen in this activity
    public boolean onTouchEvent(MotionEvent event)
    { 	
    	//get int representing the type of Action
    	int action = event.getAction();
    	
    	//if the user touched the screen or dragged along screen
    	if (action == MotionEvent.ACTION_DOWN || action == MotionEvent.ACTION_MOVE)
    	{
    		//Finds the Center of the archer
    		int x = (int)event.getX() - (gameView.archer.getBitMap().getWidth() / 2);
    				gameView.archer.goTo(x , gameView.archer.getY()); //
    	}
    	return gestureDetector.onTouchEvent(event);
    }
    
    SimpleOnGestureListener gestureListener = new
    		SimpleOnGestureListener() {
    	//Called when the Listenner touches the screen
    	@Override
    	public boolean onDoubleTap(MotionEvent e) {
    		gameView.arrow.goTo(gameView.archer.getX(), gameView.archer.getY() - 40);
    		return true; // the event was handled.
    	} // end method DoubleTap
    }; // End gestureListener
    
}
