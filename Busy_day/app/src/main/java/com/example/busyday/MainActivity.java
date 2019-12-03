package com.example.busyday;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

   // private ImageButton butAdd;
private ListView list;
private String [] names = new String[] {"1","2","3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.Footer);
        setSupportActionBar(toolbar);

      /*  FloatingActionButton butAdd = findViewById(R.id.butAdd);
        butAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
      //readNames();
      list ();

    }

   /* public void readNames ()
    {
        File[] files = new File(".").listFiles();

    }*/

    public void list()
    {
        String namefile = "";
      File[] files = new File(".").listFiles();
        for (int i = 0;i < files.length; i++)
           namefile += files[i];
        ArrayList<String> nam = new ArrayList<String>();
        nam.add(namefile);
       // String [] strFilies = files;
        list = (ListView)findViewById(R.id.listView);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(this,R.layout.notes,nam);
        list.setAdapter(adapter);
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

    public void onButtonClickAdd (View v)
    {
       Intent intent = new Intent(".EditTask");
       startActivity(intent);
    }

  /* public void addListenerOnButton () {
       butAdd = (ImageButton)findViewById(R.id.butAdd);
       butAdd.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick (View v){
               Intent inten = new Intent(".EditTask");
               startActivity(inten);
           }
       });
   }*/



}
