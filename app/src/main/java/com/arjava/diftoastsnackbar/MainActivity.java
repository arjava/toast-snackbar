package com.arjava.diftoastsnackbar;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Handler;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.pranavpandey.android.dynamic.toasts.DynamicToast;

import de.mateware.snacky.Snacky;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText inputText;
    String inputString = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputText = findViewById(R.id.inputText);

        Button btnHelloToast = findViewById(R.id.helloToast);
        Button btnCustomToast = findViewById(R.id.customToast);
        Button btnUpdateToast = findViewById(R.id.updateToast);
        Button btnCancelToast = findViewById(R.id.canceledToast);
        Button btnLibraryToast = findViewById(R.id.libraryToast);
        Button btnHelloSnack = findViewById(R.id.helloSnack);
        Button btnCustomSnack = findViewById(R.id.customSnack);
        Button btnUpdateSnack = findViewById(R.id.updateSnack);
        Button btnActonSnack = findViewById(R.id.actionSnack);
        Button btnLibrarySnack = findViewById(R.id.librarySnack);

        btnHelloToast.setOnClickListener(this);
        btnCustomToast.setOnClickListener(this);
        btnUpdateToast.setOnClickListener(this);
        btnCancelToast.setOnClickListener(this);
        btnLibraryToast.setOnClickListener(this);
        btnHelloSnack.setOnClickListener(this);
        btnCustomSnack.setOnClickListener(this);
        btnUpdateSnack.setOnClickListener(this);
        btnActonSnack.setOnClickListener(this);
        btnLibrarySnack.setOnClickListener(this);

    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onClick(View view) {

        inputString = inputText.getText().toString();
        final Toast toast;
        final Snackbar snack;
        Handler handler = new Handler();
        //setting library DynamicToast
        DynamicToast.Config.getInstance()
                .setIconSize(100)
                .apply();

        switch (view.getId()) {
            case R.id.helloToast:

                Toast.makeText(getApplicationContext(), inputString, Toast.LENGTH_SHORT).show();
                break;
            case R.id.customToast:

                Context context = getApplicationContext();
                CharSequence text = "Ini adalah Custom toast !";
                int duration = Toast.LENGTH_SHORT;

                LayoutInflater inflater = getLayoutInflater();
                View layout = inflater.inflate(R.layout.custom_toast,
                        (ViewGroup) findViewById(R.id.custom_toast_container));

                TextView tv = layout.findViewById(R.id.text);
                tv.setText(text);

                toast = new Toast(context);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 100);
                toast.setDuration(duration);
                toast.setView(layout);
                toast.show();
                break;
            case R.id.updateToast:

                toast = Toast.makeText(getApplicationContext(), inputString, Toast.LENGTH_SHORT);
                toast.setText("Toast updated");
                toast.show();
                break;
            case R.id.canceledToast:

                toast = Toast.makeText(getApplicationContext(), inputString, Toast.LENGTH_LONG);
                toast.show();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        toast.cancel();
                    }
                }, 1000);
                break;
            case R.id.libraryToast:

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DynamicToast.makeError(getApplicationContext(), "Ini Library Toast").show();
                    }
                }, 1000);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DynamicToast.makeSuccess(getApplicationContext(), "Ini Library Toast").show();
                    }
                }, 2000);

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        DynamicToast.makeWarning(getApplicationContext(), "Ini Library Toast").show();
                    }
                }, 2000);
                break;
            case R.id.helloSnack:

                Snackbar.make(findViewById(R.id.activity_main), inputString, Snackbar.LENGTH_LONG).show();
                break;
            case R.id.customSnack:

                inform(this, "Assalamu'alaikum ?", R.color.colorWhite);
                break;
            case R.id.updateSnack:

                snack = Snackbar.make(findViewById(R.id.activity_main), "Whoo, snackbar!",Snackbar.LENGTH_LONG);
                snack.show();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        snack.setText("Updated Snackbar !");
                        snack.show();
                    }
                }, 3000);
                break;
            case R.id.actionSnack:

                snack = Snackbar.make(findViewById(R.id.activity_main), "Whoo, snackbar!",Snackbar.LENGTH_LONG);
                snack.setAction("Undo", new MyUndoListener());
                snack.show();
                break;
            case R.id.librarySnack:

                Snacky.builder()
                        .setBackgroundColor(Color.parseColor("#0077CC"))
                        .setTextSize(18)
                        .setTextColor(Color.parseColor("#FFFFFF"))
                        .setTextTypefaceStyle(Typeface.ITALIC)
                        .setText(
                                "This is a custom Snackbar with all possibilities of customization and an icon. It will be cutted after 4 lines of text, so it depends on your test device if you can read all of this")
                        .setMaxLines(4)
                        .centerText()
                        .setActionText("YEAH!")
                        .setActionTextColor(Color.parseColor("#66FFFFFF"))
                        .setActionTextSize(20)
                        .setActionTextTypefaceStyle(Typeface.BOLD)
                        .setIcon(R.mipmap.ic_launcher_round)
                        .setActivity(MainActivity.this)
                        .setDuration(Snacky.LENGTH_LONG)
                        .build()
                        .show();
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
        views.setBackgroundColor(views.getResources().getColor(R.color.colorPrimary));
        snack.show();
    }
}
