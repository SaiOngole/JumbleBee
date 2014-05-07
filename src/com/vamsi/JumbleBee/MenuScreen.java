package com.vamsi.JumbleBee;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MenuScreen extends Activity {
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);  
        
        ImageView play = (ImageView) findViewById(R.id.play);
        ImageView help = (ImageView) findViewById(R.id.help);
        ImageView credits = (ImageView) findViewById(R.id.credits);
        
        play.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent playIntent = new Intent(MenuScreen.this,PlayScreen.class);
				startActivity(playIntent);
			}
		});
        
        help.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent helpIntent = new Intent(MenuScreen.this,HelpScreen.class);
				startActivity(helpIntent);
			}
		});
        
        credits.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Intent creditsIntent = new Intent(MenuScreen.this,CreditsScreen.class);
				startActivity(creditsIntent);
			}
		});
	}
}
