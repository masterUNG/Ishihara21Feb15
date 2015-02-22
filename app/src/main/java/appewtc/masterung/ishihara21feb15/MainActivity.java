package appewtc.masterung.ishihara21feb15;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    //Explicit
    private TextView txtQuestion;
    private ImageView imvIshihara;
    private RadioGroup ragChoice;
    private RadioButton radChoice1, radChoice2, radChoice3, radChoice4;
    private Button btnAnswer;
    private int intRadioButton, intIndex, intUserChoose[], intTrueAnswer[], intScore;
    private MyModel objMyModel;
    private String strChoice[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initial Widget
        initialWidget();

        //Button Controller
        buttonController();

        //Radio Controller
        radioController();

        //About Model
        aboutModel();


    }   // onCreate

    private void aboutModel() {

        objMyModel = new MyModel();
        objMyModel.setOnMyModelChangeListener(new MyModel.OnMyModelChangeListener() {
            @Override
            public void onMyModelChangeListener(MyModel myModel) {

                switch (myModel.getIntButton()) {
                    case 2:
                        imvIshihara.setImageResource(R.drawable.ishihara_02);
                        strChoice = getResources().getStringArray(R.array.time2);
                        setUpChoice();
                        break;
                    case 3:
                        imvIshihara.setImageResource(R.drawable.ishihara_03);
                        strChoice = getResources().getStringArray(R.array.time3);
                        setUpChoice();
                        break;
                    case 4:
                        imvIshihara.setImageResource(R.drawable.ishihara_04);
                        strChoice = getResources().getStringArray(R.array.time4);
                        setUpChoice();
                        break;
                    case 5:
                        imvIshihara.setImageResource(R.drawable.ishihara_05);
                        strChoice = getResources().getStringArray(R.array.time5);
                        setUpChoice();
                        break;
                    case 6:
                        imvIshihara.setImageResource(R.drawable.ishihara_06);
                        strChoice = getResources().getStringArray(R.array.time6);
                        setUpChoice();
                        break;
                    case 7:
                        imvIshihara.setImageResource(R.drawable.ishihara_07);
                        strChoice = getResources().getStringArray(R.array.time7);
                        setUpChoice();
                        break;
                    case 8:
                        imvIshihara.setImageResource(R.drawable.ishihara_08);
                        strChoice = getResources().getStringArray(R.array.time8);
                        setUpChoice();
                        break;
                    case 9:
                        imvIshihara.setImageResource(R.drawable.ishihara_09);
                        strChoice = getResources().getStringArray(R.array.time9);
                        setUpChoice();
                        break;
                    case 10:
                        imvIshihara.setImageResource(R.drawable.ishihara_10);
                        strChoice = getResources().getStringArray(R.array.time10);
                        setUpChoice();
                        break;
                }   // switch

            }   // event
        });

    }   // aboutModel

    private void setUpChoice() {

        radChoice1.setText(strChoice[0]);
        radChoice2.setText(strChoice[1]);
        radChoice3.setText(strChoice[2]);
        radChoice4.setText(strChoice[3]);

    }   // setUpChoice

    private void radioController() {

        ragChoice.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                //Sound Effect
                MediaPlayer radioSound = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_shut);
                radioSound.start();

                //setup intRadioButton
                switch (checkedId) {
                    case R.id.radioButton:
                        intRadioButton = 1;
                        break;
                    case R.id.radioButton2:
                        intRadioButton = 2;
                        break;
                    case R.id.radioButton3:
                        intRadioButton = 3;
                        break;
                    case R.id.radioButton4:
                        intRadioButton = 4;
                        break;
                    default:
                        intRadioButton = 0;
                        break;
                }   // switch

            }   // event
        });

    }   // radioController

    private void buttonController() {

        btnAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Sound Effect
                MediaPlayer buttonSound = MediaPlayer.create(getBaseContext(), R.raw.effect_btn_long);
                buttonSound.start();

                //Check Zero
                checkZero();


            }   // event
        });

    }   // buttonController

    private void checkZero() {

        if (intRadioButton == 0) {

            MyAlertDialot objMyAlert = new MyAlertDialot();
            objMyAlert.myDialog(MainActivity.this);

        } else {

            checkScore();

            checkTimes();

        }

    }   // checkZero

    private void checkScore() {

        //Deceleration
        intUserChoose = new int[10];
        intTrueAnswer = new int[10];
        intTrueAnswer[0] = 1;
        intTrueAnswer[1] = 2;
        intTrueAnswer[2] = 3;
        intTrueAnswer[3] = 1;
        intTrueAnswer[4] = 2;
        intTrueAnswer[5] = 3;
        intTrueAnswer[6] = 1;
        intTrueAnswer[7] = 2;
        intTrueAnswer[8] = 4;
        intTrueAnswer[9] = 4;

        //Setup intUserChoose
        intUserChoose[intIndex] = intRadioButton;

        //Increase Score
        if (intUserChoose[intIndex] == intTrueAnswer[intIndex] ) {
            intScore += 1;
        }

    }   //checkScore

    private void checkTimes() {

        if (intIndex == 9) {

            //Intent to ShowScoreActivity
            Intent objIntent = new Intent(MainActivity.this, ShowScoreActivity.class);
            objIntent.putExtra("Score", intScore);
            Log.d("test", "Score = " + Integer.toString(intScore));
            startActivity(objIntent);
            finish();

        } else {

            //Decrease intIndex
            intIndex += 1;

            //Setup TextView
            txtQuestion.setText(Integer.toString(intIndex + 1) + ". What is this ?");

            //sent value to Model
            objMyModel.setIntButton(intIndex + 1);

            //Clear Answer
            ragChoice.clearCheck();


        }

    }   // checkTime

    private void initialWidget() {

        txtQuestion = (TextView) findViewById(R.id.textView);
        imvIshihara = (ImageView) findViewById(R.id.imageView);
        ragChoice = (RadioGroup) findViewById(R.id.ragChoice);
        radChoice1 = (RadioButton) findViewById(R.id.radioButton);
        radChoice2 = (RadioButton) findViewById(R.id.radioButton2);
        radChoice3 = (RadioButton) findViewById(R.id.radioButton3);
        radChoice4 = (RadioButton) findViewById(R.id.radioButton4);
        btnAnswer = (Button) findViewById(R.id.button);

    }   // initialWidget


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.itemHowToUse:

                Intent objIntent = new Intent(MainActivity.this, HowToUseActivity.class);
                startActivity(objIntent);

                break;
            case R.id.itemAboutMe:

                //Intent to WebView
                Intent objIntentWebView = new Intent(Intent.ACTION_VIEW);
                objIntentWebView.setData(Uri.parse("http://androidthai.in.th/about-me.html"));
                startActivity(objIntentWebView);
                

                break;
        }

        return super.onOptionsItemSelected(item);
    }
}   // Main Class นี่คือ คลาสหลักเวัยเห้ย
