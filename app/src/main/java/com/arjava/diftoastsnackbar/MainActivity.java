package com.arjava.diftoastsnackbar;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);

        Button btnHelloTaoast = findViewById(R.id.helloToast);
        Button btnCustomTaoast = findViewById(R.id.customToast);
        Button btnUpdateTaoast = findViewById(R.id.updateToast);
        Button btnCancelTaoast = findViewById(R.id.canceledToast);
        Button btnHelloSnack = findViewById(R.id.helloSnack);
        Button btnCustomSnack = findViewById(R.id.customSnack);
        Button btnUpdateSnack = findViewById(R.id.updateSnack);
        Button btnActonSnack = findViewById(R.id.actionSnack);

        btnHelloTaoast.setOnClickListener(this);
        btnCustomTaoast.setOnClickListener(this);
        btnUpdateTaoast.setOnClickListener(this);
        btnCancelTaoast.setOnClickListener(this);
        btnHelloSnack.setOnClickListener(this);
        btnCustomSnack.setOnClickListener(this);
        btnUpdateSnack.setOnClickListener(this);
        btnActonSnack.setOnClickListener(this);

        inform(this, "Assalamu'alaikum ?", R.color.colorAccent);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.helloToast:


                break;
            case R.id.customToast:
                Context context = getApplicationContext();
                CharSequence text = "Assalamu'alaikum Semua ?";
                int duration = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                break;
            case R.id.updateToast:
                Toast.makeText(getApplicationContext(), inputText.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.canceledToast:

                break;
            case R.id.helloSnack:
                final Snackbar snack = Snackbar.make(findViewById(R.id.activity_main), "Whoo, snackbar!",Snackbar.LENGTH_LONG);
                snack.setAction("Undo", new MyUndoListener());
                snack.show();
                break;
            case R.id.customSnack:

                break;
            case R.id.updateSnack:

                break;
            case R.id.actionSnack:

                break;
        }
    }

    class MyUndoListener implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), "UNDO LISTENER", Toast.LENGTH_LONG).show();
        }
    }

    private void inform(Activity view, @SuppressWarnings("SameParameterValue") String query, int text_color)
    {
        Snackbar snack;
        snack = Snackbar.make(view.findViewById(R.id.activity_main), query, Snackbar.LENGTH_LONG);
        View views = snack.getView();
        TextView tv = views.findViewById(android.support.design.R.id.snackbar_text);
        tv.setTextColor(view.getResources().getColor(text_color));
        //change background color too ?
        views.setBackgroundColor(views.getResources().getColor(R.color.colorPrimaryDark));
        snack.show();
    }
}
