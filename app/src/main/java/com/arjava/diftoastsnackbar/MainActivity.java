package com.arjava.diftoastsnackbar;

import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHelloSnack = findViewById(R.id.helloSnack);

        Context context = getApplicationContext();
        CharSequence text = "Assalamu'alaikum Semua ?";
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        final Snackbar snack = Snackbar.make(findViewById(R.id.activity_main), "Whoo, snackbar!",Snackbar.LENGTH_LONG);
        snack.setAction("Undo", new MyUndoListener());

        btnHelloSnack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snack.show();
            }
        });

//        DUtils.inform(this, "Assalamu'alaikum ?", R.color.colorAccent);

    }

    class MyUndoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "UNDO LISTENER", Toast.LENGTH_LONG).show();
            // Code to undo the user's last action
        }
    }
}
