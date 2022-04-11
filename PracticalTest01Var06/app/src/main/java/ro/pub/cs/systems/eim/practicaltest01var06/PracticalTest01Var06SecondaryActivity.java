package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    private TextView gainedTextView;
    private Button okButton;
    int scoreMultip = 0;
    private ButtonClickListener buttonClickListener = new ButtonClickListener();
    private class ButtonClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.ok_button:
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(Constants.SCORE, scoreMultip);
                    setResult(Activity.RESULT_OK, resultIntent);
                    break;
            }
            finish();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);
        gainedTextView = (TextView)findViewById(R.id.gained_text_view);
        Intent intent = getIntent();
        if (intent != null && intent.getExtras().containsKey(Constants.NUMERE)) {
            String values = intent.getStringExtra(Constants.VALUES);
            if (values.charAt(0) == values.charAt(1) && values.charAt(1) == values.charAt(2)) {

                scoreMultip = intent.getIntExtra(Constants.NUMERE, -1);
                if (scoreMultip == 0) scoreMultip = 100;
                if (scoreMultip == 1) scoreMultip = 50;
                if (scoreMultip == 2) scoreMultip = 10;

                gainedTextView.setText("Gained: " + String.valueOf(scoreMultip));
            }
        }

        okButton = (Button)findViewById(R.id.ok_button);
        okButton.setOnClickListener(buttonClickListener);
    }
}