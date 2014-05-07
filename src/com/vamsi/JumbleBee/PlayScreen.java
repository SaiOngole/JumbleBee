package com.vamsi.JumbleBee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class PlayScreen extends Activity{
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);  
        
        ImageView easy = (ImageView) findViewById(R.id.easy);
        ImageView medium = (ImageView) findViewById(R.id.medium);
        ImageView hard = (ImageView) findViewById(R.id.hard);
         
        easy.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent easyIntent = new Intent(PlayScreen.this,Easy.class);
				startActivity(easyIntent);
			}
		});
        
        medium.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent mediumIntent = new Intent(PlayScreen.this,Medium.class);
				startActivity(mediumIntent);
			}
		});
        
        hard.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent hardIntent = new Intent(PlayScreen.this,Hard.class);
				startActivity(hardIntent);
			}
		});
}

}
