package ro.pub.cs.systems.eim.practicaltest01var06;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class PracticalTest01Var06SecondaryActivity extends AppCompatActivity {

    Button okBtn;

    TextView tV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var06_secondary);

        okBtn = findViewById(R.id.okBtn);
        tV1 = findViewById(R.id.tV1);

        okBtn.setOnClickListener(it -> {
            finish();
        });

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                tV1.setText("0");
            } else {
                Integer fET = Integer.parseInt(String.valueOf(extras.getInt("firstET")));
                Integer sET = Integer.parseInt(String.valueOf(extras.getInt("secondET")));
                Integer tET = Integer.parseInt(String.valueOf(extras.getInt("thirdET")));
                Integer cbChecked = Integer.parseInt(String.valueOf(extras.getInt("cbChecked")));

                if (cbChecked.equals(0)) {
                    tV1.setText("Gained 100");
                } else if (cbChecked.equals(1)) {
                    tV1.setText("Gained 50");
                } else if (cbChecked.equals(2)) {
                    tV1.setText("Gained 10");
                }
            }
        } else {
            tV1.setText("0");
        }
    }
}