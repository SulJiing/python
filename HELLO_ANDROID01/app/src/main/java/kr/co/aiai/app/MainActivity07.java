package kr.co.aiai.app;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity07 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main07);
        Log.d("woong","[MainActivity07]onCreate");
        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity07.this, MainActivity08.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("woong","[MainActivity07]onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("woong","[MainActivity07]onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("woong","[MainActivity07]onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("woong","[MainActivity07]onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("woong","[MainActivity07]onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("woong","[MainActivity07]onRestart");
    }
}