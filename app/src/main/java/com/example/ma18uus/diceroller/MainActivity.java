package com.example.ma18uus.diceroller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import static com.example.ma18uus.diceroller.R.id.numberEntered;

public class MainActivity extends AppCompatActivity {


    private TextView mgTv;
    private EditText numberEntered;
    private Button validate;
    private Object numberToFind;
    private int counter = 0;
    private TextView base;
    private TextView view;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mgTv = (TextView) findViewById(R.id.msg);
        numberEntered = (EditText) findViewById(R.id.numberEntered);
        base = (TextView) findViewById(R.id.count);
        view = (TextView) findViewById(R.id.counterv);




        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    public void on_button_click(View view){

        TextView tv = (TextView) this.findViewById(R.id.numberTextView);



        Random r = new Random();

        int number = r.nextInt(7);


        tv.setText(Integer.toString(number));


        int n = Integer.parseInt(numberEntered.getText().toString());

        if (n<1 || n>6){
            Toast.makeText(this, "Invalid input, number must be between 1-6", Toast.LENGTH_SHORT).show();

        } else if (n == number){
            Toast.makeText(this, "CONGRATULATION!, Numbers match!!", Toast.LENGTH_SHORT).show();
            counter = counter +1;
            base.setText(Integer.toString(counter));
        }


    }




}
