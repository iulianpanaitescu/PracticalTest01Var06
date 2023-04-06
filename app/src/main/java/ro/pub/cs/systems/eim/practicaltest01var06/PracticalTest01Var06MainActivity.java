package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PracticalTest01Var06MainActivity extends AppCompatActivity {

    Button playBtn;

    EditText firstET;
    EditText secondET;
    EditText thirdET;

    CheckBox firstCB;
    CheckBox secondCB;
    CheckBox thirdCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_main);

        playBtn = findViewById(R.id.playBtn);

        firstET = findViewById(R.id.firstET);
        secondET = findViewById(R.id.secondET);
        thirdET = findViewById(R.id.thirdET);

        firstCB = findViewById(R.id.firstCB);
        secondCB = findViewById(R.id.secondCB);
        thirdCB = findViewById(R.id.thirdCB);

        playBtn.setOnClickListener(it -> {
            int r1 = ThreadLocalRandom.current().nextInt(1, 4);
            int r2 = ThreadLocalRandom.current().nextInt(1, 4);
            int r3 = ThreadLocalRandom.current().nextInt(1, 4);

            Toast.makeText(this, "ET1: " + Constants.numere[r1] + "\n" +
                    "ET2: " + Constants.numere[r2] + "\n" +
                    "ET3: " + Constants.numere[r3] + "\n", Toast.LENGTH_SHORT).show();

            int cbChecked = 0;

            Intent intent = new Intent(getApplicationContext(), PracticalTest01Var06SecondaryActivity.class);
            intent.putExtra(Constants.firstET, "0");
            intent.putExtra(Constants.secondET, "0");
            intent.putExtra(Constants.thirdET, "0");

            if (!(firstCB.isChecked())) {
                firstET.setText(Constants.numere[r1]);
                intent.putExtra(Constants.firstET, firstET.getText().toString());
                cbChecked++;
            }
            if (!(secondCB.isChecked())) {
                secondET.setText(Constants.numere[r2]);
                intent.putExtra(Constants.secondET, secondET.getText().toString());
                cbChecked++;
            }
            if (!(thirdCB.isChecked())) {
                thirdET.setText(Constants.numere[r3]);
                intent.putExtra(Constants.thirdET, thirdET.getText().toString());
                cbChecked++;
            }
            intent.putExtra(Constants.cbChecked, cbChecked);
            startActivityForResult(intent, Constants.REQUEST_CODE);
        });
    }
}