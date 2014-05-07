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

public class Medium extends Activity{
	private static String[] word_list = {"relative","mechanic","dispatch","attorney","batsman","application","turbine",
		"artificial","networks","inertia","pigments","instructions","version","manifest","publicity","transaction","mammoth",
		"building","activity","jeopardy","difficulty","install","independence","republic","kingdom","pirates","olympics",
		"sanitary","indonesia","flying","indicator","controller","insulator","conductor","diode","transistor","circuit",
		"kinematics","dynamics","friction","pressure","declaration","yesterday","hospital","philanthropy","executive",
		"consultation","graduate","examination","compatible","professional","signals","electrify","indolence","confidence",
		"virtual","adjective","conjunction","swing","diverse","aptitude","dominion","donnish","dormant","execrable","egalitarian",
		"servile","pragmatic","admonish","contour","abjure","abode","abolition","propulsion","countdown","automobile",
		"optimization","celestial","advertisement","campaign","dictionary","revolution","connoisseur","adamant","perfection",
		"communication","integration","debenture","journal","research","caliber","potential","capacity","wireless","programming",
		"aesthetic","lieutenant","artillery","sufficient","suggestive","jaunt","conspiracy","haunted","dexterity","devastated",
		"emporium","encounter","compass","exothermic","endorsement","enormous","flabby","flutter","glacial","gladden",
		"glorified","glossy","glimmer","scuzzy","secondary","chromosome","selection","semester","senator","parliament",
		"sensation","separation","shallow","reference","testimony","wrestling","wrangle","wretch","warranty","vinegar","angola",
		"andorra","austria","malaysia","australia","bhutan","agency","aggregate","against","aggresive","baronet","barrage",
		"barrier","beautiful","decipher","decision","deception","designate","destruction","destitute","beginner","farrier","fasten",
		"deceptive","fatigue","feasible","feather","feminine","fertilizer","fickle","figure","finance","finite","finger",
		"dollar","ounce","retardant","essential","estuary","evaluate","everyone","anyone","someone","exception","excessive",
		"excitement","extrude","extrovert","fabricate","fleecy","flattery","doomed","frantic","freckle","frippery","frontier",
		"runner","stammer","fundamental","gameplay","garbage","garish","chartered","gavel","generation","geneticist",
		 "aaronical", "abacinate", "abaciscus", "abactinal", "abaisance", "abandoned", "abandonee", "abandoner", "abasement", 
		 "abashedly", "abashment", "abatement", "abattoirs", "abbatical", "abbotcies", "abbotship", "abdicable", "abdicated", 
		 "abdicates", "abdominal", "avuncular", "awakening", "awareness", "awfullest", "awfulness", "awkwarder", "awkwardly", 
		 "axiomatic", "axletrees", "axminster", "ayatollah", "azedarach", "azimuthal", "azotizing","zooks", "zoolatry", 
		 "zoologer", "zoologic","zoopathology", "zoophaga", "zoophagan", "zoophagous", "zoophiles", "zoophilist", "zoophily"};
	
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
        
         Toast.makeText(Medium.this, 
                "onCreate()", 
                Toast.LENGTH_SHORT).cancel();
        
       checkButton = (ImageView) findViewById(R.id.check_button);
       
       answerView = (EditText) findViewById(R.id.answer_view);
        
       
       checkButton.setOnClickListener(checkButtonListener);
       index =  (int) Math.ceil(Math.random()*245); 
         getReference();
         	setValue(index);  
    }
    
    @Override
    protected void onDestroy() {
     super.onDestroy();
     Toast.makeText(Medium.this, 
             "onDestroy()", 
             Toast.LENGTH_SHORT).cancel();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
     super.onConfigurationChanged(newConfig);
     Toast.makeText(Medium.this, 
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
			index = (int) Math.ceil(Math.random()*245);
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
