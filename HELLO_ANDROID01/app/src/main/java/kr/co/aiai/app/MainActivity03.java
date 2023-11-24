package kr.co.aiai.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity03 extends AppCompatActivity {
    EditText et_dan;
    EditText et_disp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main03);

        et_dan = findViewById(R.id.et_dan);
        Button btn = findViewById(R.id.btn);
        et_disp = findViewById(R.id.et_disp);
        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                myclick();
            }
        });
    }
    void myclick(){
        String result = "";
        String a = String.valueOf(et_dan.getText());
        int aa = Integer.parseInt(a);

        for(int i=1; i<=9; i++) {
            int aaa = aa * i;
            result += aa+"*"+i+"="+aaa+"\n";
        }
        et_disp.setText(result);
    }
}