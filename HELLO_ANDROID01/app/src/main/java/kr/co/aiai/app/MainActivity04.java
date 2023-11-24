package kr.co.aiai.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.EventListener;

public class MainActivity04 extends AppCompatActivity {

    TextView tv1;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv5;
    TextView tv6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main04);

        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv3 = findViewById(R.id.tv3);
        tv4 = findViewById(R.id.tv4);
        tv5 = findViewById(R.id.tv5);
        tv6 = findViewById(R.id.tv6);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myclick();
            }
        });
    }

    public void myclick() {
        int[] arr = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18, 19, 20,
                21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
                31, 32, 33, 34, 35, 36, 37, 38, 39, 40,
                41, 42, 42, 43, 44, 45
        };
        for (int i = 0; i <= 1000; i++) {
            int rnd = (int) (Math.random() * 45) + 1;
            int a = arr[0];
            arr[0] = arr[rnd];
            arr[rnd] = a;
        }
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                int a = arr[i];
                int b = arr[j];
                if (a < b) {
                    arr[i] = b;
                    arr[j] = a;
                }
            }

            tv1.setText(arr[0] + "");
            tv2.setText(arr[1] + "");
            tv3.setText(arr[2] + "");
            tv4.setText(arr[3] + "");
            tv5.setText(arr[4] + "");
            tv6.setText(arr[5] + "");
        }
    }
}