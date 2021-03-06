package com.example.flaviokreis.quizapp_brazil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private int TOTAL_OF_QUESTION = 5;

    @BindView(R.id.first_capital)
    EditText firstCapital;

    @BindView(R.id.capital_radio_group)
    RadioGroup capitalRadioGroup;

    @BindView(R.id.biggest_state)
    EditText biggestState;

    @BindView(R.id.inhabitants_radio_group)
    RadioGroup inhabitantsRadioGroup;

    @BindView(R.id.city_1)
    CheckBox city1;
    @BindView(R.id.city_2)
    CheckBox city2;
    @BindView(R.id.city_3)
    CheckBox city3;
    @BindView(R.id.city_4)
    CheckBox city4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick(R.id.verify)
    public void verify(){
        int correctlyAnswers = 0;

        if(firstCapital.getText().toString().equalsIgnoreCase(getString(R.string.salvador))){
            correctlyAnswers++;
        }

        if(capitalRadioGroup.getCheckedRadioButtonId() == R.id.question_2_brasilia){
            correctlyAnswers++;
        }

        if(biggestState.getText().toString().equalsIgnoreCase(getString(R.string.amazonas))){
            correctlyAnswers++;
        }

        if(inhabitantsRadioGroup.getCheckedRadioButtonId() == R.id.inhabitants_2){
            correctlyAnswers++;
        }

        if(city1.isChecked() && !city2.isChecked() && !city3.isChecked() && city4.isChecked() ){
            correctlyAnswers++;
        }

        if( correctlyAnswers == TOTAL_OF_QUESTION ){
            Toast.makeText(this, R.string.toast_ok, Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(this, String.format(Locale.getDefault(), getString(R.string.incorrecty_answer_toast), correctlyAnswers, TOTAL_OF_QUESTION), Toast.LENGTH_LONG).show();
        }
    }
}
