package kit.edu.nikkolasedip.a36questions;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set);
        TextView textView =(TextView) findViewById(R.id.textView2);
        Typeface tf = Typeface.createFromAsset(getAssets(),"font2source.ttf");
        textView.setTypeface(tf);
        Button button = (Button) findViewById(R.id.button1);
        button.setTypeface(tf);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAnotherActivity();
            }
        });

    }

        public void openAnotherActivity(){
        Intent intent = new Intent(this, ContentActivity.class);
        startActivity(intent);
}}
