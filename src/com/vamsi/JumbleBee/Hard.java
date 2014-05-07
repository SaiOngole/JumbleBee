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

public class Hard extends Activity{
	private static String[] word_list = {"sabotage","transportation","assistant","mileage","association","emergency","roundabout","seatbelt","wheelchair","attorney","application","development","turbine","artificial",
		"combustion","retardation","photosynthesis","specifications","instructions",
		"technology","knuckle","jeopardy","psychiatrist","difficulty","automatic","independence","olympics","sanitary","indonesia","indicator","controller","insulator","conductor","transistor","kinematics",
		"declaration","philosophy","anthropologist","philanthropy","executive","consultation","examination","compatible","professional","signals","electrify","indolence","confidence","travelling","percentage","dominion","donnish","execrable","egalitarian","servile","slime","pragmatic","admonish","abolition","accelerator","propulsion","aerodynamics","hypersonic","synchronise","comparator","constitution","sphygmomanometer","hydraulic","pneumatic","encryption",
		"embryo","pancreas","kingfisher","automobile","optimization","numerical","celestial","advertisement","dictionary",
		"revolution","statistics","mathematics","physical","education","challenge","intelligent","connoisseur","adamant","perfection","direction","communication",
		"integration","debenture","synchronize","transmitter","readymade","potential","assassination","preventive","contraceptive",
		"programming","waterfalls","aesthetic","university","lieutenant","commander","artillery","tropical","sufficient",
		"suggestive","humanitarian","humungous","ecological","confession","confederation","conspiracy",
		"dexterity","devastated","emporium","endothermic","exothermic","endorsement","enormous","fastidious",
		"favourite","flamenco","flirtatious","glorified","glossary","gnomic","scuzzy","seismograph","chromosome",
		"parliament","sensation","separation","reference","termagant","termination","testimony","aggravation","aggrandizement",
		"agglomerate","barnyard","afghanistan","kyrgyzstan","svalbard","beatitude","beligerent","bereaved","bicarbonate",
		"debilitate","depreciate","deputation","descendant","fascism","fascinating","fedora","febrile","braille","diamond",
		"fullerene","firmament","flamboyant","flammable","flamingo","flabbergasted","flippant","etcetera","eutrophication",
		"ethnographer","etymology","ethnocentric","excommunicate","excruciating","exoglosic","expulsion","rustication",
		"flibbertigibbet","simulator","flirtatious","forcemeat","forbearance","foreseeable","foreshorten","fortification",
		"foundation","distillation","fratricide","fraternal","freelancer","fuselage","geography","gerontology","gerrymander",
		"gesticulate","gerontocracy","germanium","certificate","gingivitis","gingerale","gossamer","grandiloquent","auditorium",
		"granulated","greenhouse","grimace","conventional","antiquations","consolidated","announcement","rationalized",
		"predications","exploitation","distilleries","computerized","pressureless","satisfactory","jocularities",
		"protractions","contradicted","historicized","annexational","endangerment","extenuation","reeducation",
		"reflectional","dislocation","contemporary","infestation","cobblestoned","coordination","testosterone",
		"apppointment","exterminator","encapsulate","finalization","probationary","commentary","gloominess",
		"prevaricator","intoxication","veterinarian","enlargement","tranquilizer","reservation","amelioration",
		"foundation","moisturising","intelligence","fraternity","exteriotised","hypertension","indentation",
		"surrendering","splendidness","connectional","reincarnated","materializer","stimulations","antagonizing",
		"compression","thunderous","questionable","legalization","degeneration","consolation","chlorination",
		"interaction","enthusiastic","reacquainted","intermingled","affectionate","premeditate","nationalize",
		"bereavement","compensation","extramarital","exoneration","decongestant","malfunction","indignation",
		"penetration","interviewer","carburetition","paratrooper","incarnated","information","denomination","intimidation",
		"retaliation","congregation","demoralize","externalized","interruption","mountaineer","standardize","respiration",
		"embitterment","expenditure","amateurishly","advancement","pathological","figurative","incineration","ejaculation",
		"entrepreneur","inebirations","interpreters","executioners","intermission","advancement","contaminated","scaffoldings",
		"refurnishing","strengthened","hydrogenated","politeness","congratulate","zoogloea", "zoogony", "zoographer", "zoographic", 
		"zoographical", "zoographist", "zoography", "zooid", "zooidal"," zoological", "zoologize","zoomorphic",  
		"zooparasitic", "zoopathologies", "zoophite", "zoophobia", "zoophorous"," zoophytological", " zoroastrian"};
	
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
        
         Toast.makeText(Hard.this, 
                "onCreate()", 
                Toast.LENGTH_SHORT).cancel();
        
       checkButton = (ImageView) findViewById(R.id.check_button);
       
       answerView = (EditText) findViewById(R.id.answer_view);
        
       
       checkButton.setOnClickListener(checkButtonListener);
       index =  (int) Math.ceil(Math.random()*336); 
         getReference();
         	setValue(index);  
    }
    
    @Override
    protected void onDestroy() {
     // TODO Auto-generated method stub
     super.onDestroy();
     Toast.makeText(Hard.this, 
             "onDestroy()", 
             Toast.LENGTH_SHORT).cancel();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
     // TODO Auto-generated method stub
     super.onConfigurationChanged(newConfig);
     Toast.makeText(Hard.this, 
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
			index = (int) Math.ceil(Math.random()*336);
			score = (TextView) findViewById(R.id.score);
			score.setText("Your score is:" +scoreCount);		
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
