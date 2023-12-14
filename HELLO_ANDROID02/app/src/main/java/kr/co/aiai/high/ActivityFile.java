package kr.co.aiai.high;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ActivityFile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String textWrite = "babo₩nbabo₩nbabo";
                    FileOutputStream fileoutputstream = openFileOutput("babo.txt", MODE_PRIVATE);
                    fileoutputstream.write(textWrite.getBytes());
                    fileoutputstream.close();
                } catch (Exception e) {
                e.printStackTrace();
                }
            }
        });
    }
}