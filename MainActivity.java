package com.example.t00064422.count;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import static java.lang.reflect.Array.get;
import static java.lang.reflect.Array.getInt;

public class MainActivity extends AppCompatActivity {

    public final String SHARED_PREF = "sharedPref";
    public final String POTATO_COUNT = "potatoCount";

    private Button button;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences settings = getSharedPreferences(SHARED_PREF, 0);
        button = (Button)findViewById(R.id.button);
        count = settings.getInt(POTATO_COUNT, 0);
        button.setText( count +  "");

    }

    @Override
    protected void onPause() {
        super.onPause();
        SharedPreferences settings = getSharedPreferences(SHARED_PREF, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putInt(POTATO_COUNT, count);

        editor.commit();
    }

    public void countUp(View view) {

        count += 1;
        button.setText( count + "");

    }
}
