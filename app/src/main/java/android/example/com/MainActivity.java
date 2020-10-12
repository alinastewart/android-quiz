package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Global variable that allows us to recalculate score each time answer to question 3 is modified:
    boolean radio_score = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculateScore(View view) {
        //As button pressed initiate score variable at zero.
        //This allows to recalculate score each time answer is modified and Submit Results button is pressed:
        int score = 0;
        String feedbackMessage;

        EditText nameField = (EditText) findViewById(R.id.name_field);
        String name = nameField.getText().toString();
        //Creating boolean variables for question 1 and increasing score if answer is right:
        CheckBox checkBoxOneFive = (CheckBox) findViewById(R.id.oneFive);
        boolean oneFive = checkBoxOneFive.isChecked();
        CheckBox checkBoxOneSeven = (CheckBox) findViewById(R.id.oneSeven);
        boolean oneSeven = checkBoxOneSeven.isChecked();
        CheckBox checkBoxOneSix = (CheckBox) findViewById(R.id.oneSix);
        boolean oneSix = checkBoxOneSix.isChecked();
        CheckBox checkBoxOneFour = (CheckBox) findViewById(R.id.oneFour);
        boolean oneFour = checkBoxOneFour.isChecked();
        if ((oneFive) && (oneSeven) && (oneSix) && !(oneFour)) {
            score += 1;
        }
        //Creating boolean variables for question 2 and increasing score if answer is right:
        CheckBox checkBoxTwoThree = (CheckBox) findViewById(R.id.twoThree);
        boolean twoThree = checkBoxTwoThree.isChecked();
        CheckBox checkBoxTwoOne = (CheckBox) findViewById(R.id.twoOne);
        boolean twoOne = checkBoxTwoOne.isChecked();
        CheckBox checkBoxTwoSeven = (CheckBox) findViewById(R.id.twoSeven);
        boolean twoSeven = checkBoxTwoSeven.isChecked();
        CheckBox checkBoxTwoFive = (CheckBox) findViewById(R.id.twoFive);
        boolean twoFive = checkBoxTwoFive.isChecked();
        if (!(twoSeven) && !(twoFive) && (twoOne) && (twoThree)) {
            score += 1;
        }
        EditText textField = (EditText) findViewById(R.id.text_field);
        String answerText = textField.getText().toString().toLowerCase();
        //Checking if correct answer entered:
        if (answerText.equals("dime")) {
            score += 1;
        }
        // Calculating all scores including radio:
        if (radio_score == true) {
            score += 1;
        }
        if (score < 4) {
            feedbackMessage = "Please study more!";
        } else {
            feedbackMessage = "Great job!";
        }
        Toast.makeText(this, name + ", you earned " + score + " points on quiz!\n" + feedbackMessage, Toast.LENGTH_LONG).show();

    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radio_true:
                if (checked) {
                    radio_score = true;
                    break;
                }
            case R.id.radio_false:
                if (checked) {
                    if (radio_score == true) {
                        radio_score = false;
                    }
                    break;
                }
        }
    }

    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.score_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}