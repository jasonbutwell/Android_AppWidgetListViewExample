package com.jasonbutwell.appwidgetlistviewexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * Created by J on 18/03/2017.
 */

public class DetailActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String word=getIntent().getStringExtra(WidgetProvider.EXTRA_WORD);

        if (word == null)
            word = "We did not get a word!";

        Toast.makeText(this, word, Toast.LENGTH_LONG).show();

        //finish();
    }
}
