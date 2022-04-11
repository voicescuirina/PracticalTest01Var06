package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {
    private EditText leftEditText;
    private EditText rightEditText;
    private EditText middleEditText;

    private Button playButton, calculateButton;
    private Random random = new Random();

    private ButtonClickListener buttonPlayListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            CheckBox holdLeft = (CheckBox)findViewById(R.id.hold_left);
            CheckBox holdRight = (CheckBox)findViewById(R.id.hold_right);
            CheckBox holdMiddle = (CheckBox)findViewById(R.id.hold_middle);

            switch(view.getId()) {
                case R.id.play_button:
                    if (!holdLeft.isChecked()) {
                        //leftEditText = (EditText)findViewById(R.id.left_edit_text);
                        leftEditText.setText(Constants.numere[random.nextInt(Constants.numere.length)]);
                    }
                    if (!holdRight.isChecked()) {
                        //leftEditText = (EditText)findViewById(R.id.left_edit_text);
                        rightEditText.setText(Constants.numere[random.nextInt(Constants.numere.length)]);
                    }
                    if (!holdMiddle.isChecked()) {
                        //leftEditText = (EditText)findViewById(R.id.left_edit_text);
                        middleEditText.setText(Constants.numere[random.nextInt(Constants.numere.length)]);
                    }
                    Log.d(Constants.TAG, leftEditText.getText().toString() + middleEditText.getText().toString()
                            + rightEditText.getText().toString());

                    break;
                case R.id.calculate_button:
                    Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
                    int numere = 0;
                    if (holdLeft.isChecked()) {
                        //leftEditText = (EditText)findViewById(R.id.left_edit_text);
                        numere++;
                    }
                    if (holdRight.isChecked()) {
                        //leftEditText = (EditText)findViewById(R.id.left_edit_text);
                        numere++;
                    }
                    if (holdMiddle.isChecked()) {
                        //leftEditText = (EditText)findViewById(R.id.left_edit_text);
                        numere++;
                    }
                    intent.putExtra(Constants.VALUES, leftEditText.getText().toString() + middleEditText.getText().toString()
                            + rightEditText.getText().toString());
                    intent.putExtra(Constants.NUMERE, numere);
                    //startActivity(intent);
                    startActivityForResult(intent, Constants.SECONDARY_ACTIVITY_REQUEST_CODE);

                    break;

            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);
        leftEditText = (EditText)findViewById(R.id.left_edit_text);
        rightEditText = (EditText)findViewById(R.id.right_edit_text);
        middleEditText = (EditText)findViewById(R.id.middle_edit_text);

        playButton = (Button)findViewById(R.id.play_button);
        playButton.setOnClickListener(buttonPlayListener);

        calculateButton = (Button)findViewById(R.id.calculate_button);
        calculateButton.setOnClickListener(buttonPlayListener);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == Constants.SECONDARY_ACTIVITY_REQUEST_CODE) {
            Toast.makeText(this, "The activity returned with result " + intent.getStringExtra(Constants.SCORE), Toast.LENGTH_LONG).show();
        }
    }


}