package kr.co.aiai.app;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity06 extends AppCompatActivity {

    TextView et_disp;
    TextView et_first;
    TextView et_last;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main06);

        et_first =findViewById(R.id.et_first);
        et_last =findViewById(R.id.et_last);
        et_disp = findViewById(R.id.et_disp);
        Button btn = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                myclick();
            }
        });
    }

    public void myclick() {
       int f = Integer.parseInt(String.valueOf(et_first.getText()));
       int l = Integer.parseInt(String.valueOf(et_last.getText()));

       String txt = "";

        for(int i=f;i<=l;i++) {
            txt += getStar(i);
        }
        et_disp.setText(txt);
    }

        public String getStar(int cnt) {
            String ret = "";
            for(int i=0; i<cnt; i++) {
                ret += "*";
            }
            ret += "\n";
            return ret;
        }
    }