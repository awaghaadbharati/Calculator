package com.example.bharatiawaghad.calculator;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bsh.EvalError;
import bsh.Interpreter;

public class MainActivity extends AppCompatActivity implements OnClickListener{
    TextView sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        sum=(TextView)findViewById(R.id.textView);
        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
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

    @Override
    public void onClick(View v) {
        Button btn=(Button)findViewById(v.getId());
        //System.out.println("Hello");
        if(v.getId()==R.id.buttonCalculate)
        {
            String expression=sum.getText().toString();
            Interpreter interpreter = new Interpreter();
            try {
                String result=interpreter.eval(expression).toString();
              //  System.out.println(result);
                sum.setText(result);
            } catch (EvalError evalError) {
                evalError.printStackTrace();

            }

        }
        else
        {
            //Toast.makeText(this, "You pressed :" + btn.getText(), Toast.LENGTH_LONG).show();
            //System.out.println("Hi");
            sum.setText(sum.getText().toString()+btn.getText().toString());
        }
    }
}
