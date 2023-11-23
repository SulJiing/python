package kr.co.aiai.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity02 extends AppCompatActivity {
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main02);

        TextView tv = findViewById(R.id.tv);
        count = Integer.parseInt(String.valueOf(tv.getText()));

        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                count--;
                tv.setText(count+"");
            }
        });
    }
}