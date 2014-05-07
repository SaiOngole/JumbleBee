package com.vamsi.JumbleBee;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;


public class JumbleBeeActivity extends Activity {
			
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);  
        
       
        ImageView splashImage = (ImageView) findViewById(R.id.imageView1);
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.custom);
        splashImage.startAnimation(fade);
        
        ImageView splashplay = (ImageView) findViewById(R.id.imageView2);
        splashplay.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent intent = new Intent(JumbleBeeActivity.this,MenuScreen.class);
				startActivity(intent);
			}
		});
                
        fade.setAnimationListener(new AnimationListener() {
			
			
			
			public void onAnimationEnd(Animation animation) {
				Intent animIntent = new Intent(JumbleBeeActivity.this,MenuScreen.class);
				startActivity(animIntent);
			}

			public void onAnimationRepeat(Animation animation) {
				// Nothing to do here
				
			}

			public void onAnimationStart(Animation animation) {
				// Nothing to do here as well
				
			}
		});
       
}

}

	
