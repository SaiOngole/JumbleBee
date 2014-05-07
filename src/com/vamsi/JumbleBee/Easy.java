package com.vamsi.JumbleBee;

import java.util.Random;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Easy extends Activity{
	private static String[] word_list = {"relative","clock","quick","velocity","windows","official","drive","memory","basic",
		"shift","fuel","mechanic","dispatch","garage","sweep","student","school","special","route","teacher","awesome","danger",
		"batsman","floods","switch","charger","android","machine","surface","networks","tension","inertia","pigments","instructions",
		"manifest","agenda","manager","jumble","install","upload","kingdom","pirates","island","port","sensor","diode","circuit",
		"friction","pressure","volume","console","debug","problems","lucky","whole","series","cricket","hospital","waiting","master",
		"heavy","animal","warning","package","courier","kids","confidence","swing","capital","history","invent","fashion","clock",
		"genius","doodle","slime","abode","abolition","rocket","chipset","cooker","bubble","effort","pancreas","culture","countdown",
		"paragraph","working","kingfisher","ostrich","meteor","galaxy","struggle","freedom","campaign","record","embassy","royal",
		"canine","statistics","mathematics","physical","intelligent","weird","vampire","compact","picture","template","direction",
		"communication","journal","research","readymade","capacity","victory","soldier","follower","personal","wireless",
		"programming","waterfalls","commander","artillery","tropical","sufficient","jaunt","emporium","encounter","compass",
		"enormous","glacial","gladden","glazed","glorified","glossy","musician","shallow","reference","thesis","nepal","asset",
		"barge","cover","coward","crab","crazy","debate","death","dean","decimal","deceit","dessert","despite","detonate","devotee",
		"diddly","dignity","digest","dilate","dinner","lunch","disgrace","domino","pizza","burger","level","shock","center",
		"evolution","failure","faith","fate","faint","false","alarm","friend","fallow","father","fault","fatal","faun","fend",
		"frenzy","fence","ferry","fetch","graph","fire","water","pence","pound","flesh","evade","evict","convict","acquit",
		"flour","forest","fork","former","farmer","forgot","squad","freaky","hammer","fumble","funnel","gather","gaudy","gearing",
		"equal","associate","abstract"};
	
	public static final String MyPrefs = "mySharedPreferences";
	
	private final static int Right_Answer = 1;
	
	private final static int Wrong_Answer = 2;
	 
	private int scoreCount = 0;
		
	private TextView questionView = null;
	
	private EditText answerView = null;
	
	private TextView score = null;

	private ImageView checkButton = null;
	
	private String text;
	
	String word = "";
	
	String jumbled = "";
	
	int temp;
	
	int index = 12;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameplay);  
        
         Toast.makeText(Easy.this, 
                "onCreate()", 
                Toast.LENGTH_SHORT).cancel();
        
       checkButton = (ImageView) findViewById(R.id.check_button);
       
       answerView = (EditText) findViewById(R.id.answer_view);
        
       
       checkButton.setOnClickListener(checkButtonListener);
       index =  (int) Math.ceil(Math.random()*210); 
         getReference();
         	setValue(index);  
    }
    
    @Override
    protected void onDestroy() {
     super.onDestroy();
     Toast.makeText(Easy.this, 
             "onDestroy()", 
             Toast.LENGTH_SHORT).cancel();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
     super.onConfigurationChanged(newConfig);
     Toast.makeText(Easy.this, 
             "onConfigurationChanged(): " + newConfig.toString(), 
             Toast.LENGTH_SHORT).cancel();
    }
       
        private void setValue(int index) {
    	 
    	
    	word = word_list[index];
    	System.out.println(word);
    	Random r = new Random();
    	for(int i=0;i<word.length();i++) {
    		if(r.nextBoolean()) {
    			jumbled = jumbled + word.charAt(i);
    		}
    		else {
    			jumbled = word.charAt(i) + jumbled;
    		}
    	}   	
    	answerView.setText("");  
    	questionView.setText(jumbled);    	
    	 }
    
    private void getReference() {
    	questionView = (TextView)findViewById(R.id.questionText);
    }
    
    
    private OnClickListener checkButtonListener = new OnClickListener() {
		
		public void onClick(View v) {
			answerView = (EditText)findViewById(R.id.answer_view);
			
			text = answerView.getText().toString();
			
			if(text.equals(word)) {
				scoreCount++;
				showDialog(Right_Answer);
				
			}
			else {
				showDialog(Wrong_Answer);
			}
		}
	};
    
	private android.content.DialogInterface.OnClickListener dialogListener = new android.content.DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface arg0, int arg1) {
			TextView correctAnswer = (TextView) findViewById(R.id.correctAnswer);
			correctAnswer.setText("The previous answer was: "+word_list[index]);
			jumbled = "";
			index = (int) Math.ceil(Math.random()*213);
			score = (TextView) findViewById(R.id.score);
			score.setText("Your score is:" +scoreCount);
			if(scoreCount>20){
				TextView suggest = (TextView) findViewById(R.id.suggest);
				suggest.setText("Awesome!!!"+"\n"+"You are good enough to play the next level!");
			}
			
			setValue(index);
			
			
		}
	};
	private android.content.DialogInterface.OnClickListener negativeDialogListener = new android.content.DialogInterface.OnClickListener() {
		
		public void onClick(DialogInterface dialog, int which) {
			
			finish();	
		}
	};
	
	@Override
	
	protected Dialog onCreateDialog(int id) {
		Dialog dialog = null;
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setPositiveButton("Go", dialogListener)
		.setCancelable(false);
		builder.setNegativeButton("Quit", negativeDialogListener);
		
		switch(id) {
		
		case Right_Answer:
			
			builder.setMessage("Your Answer is correct,go to the next question?");
			dialog = builder.create();
			break;
			
	
	case Wrong_Answer:
			scoreCount = 0;
			builder.setMessage("Your answer is wrong!"+"\n"+"Go to the next question?");
			dialog = builder.create();
			break;
		}
		return dialog;
	}
}
