package kr.co.aiai.app;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity08 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main08);
        Log.d("woong","[MainActivity08]onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("woong","[MainActivity08]onDestroy");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("woong","[MainActivity08]onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("woong","[MainActivity08]onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("woong","[MainActivity08]onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("woong","[MainActivity08]onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("woong","[MainActivity08]onRestart");
    }
}