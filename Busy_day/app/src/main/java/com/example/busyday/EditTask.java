package com.example.busyday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class EditTask extends AppCompatActivity {

    private EditText editName;
    private EditText editTxt;
    //private TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);
        editName = (EditText)findViewById(R.id.editText);
        editTxt = (EditText)findViewById(R.id.editText3);
    }

    public void write (View view){
        String nameWrite = editName.getText().toString();
        String textWrite = editName.getText().toString();
       try {
           FileOutputStream fileOutput = openFileOutput("file.txt", MODE_PRIVATE);
           fileOutput.write(nameWrite.getBytes());
           fileOutput.write(textWrite.getBytes());
           fileOutput.close();
           editName.setText("");
           Toast.makeText(EditTask.this, "Изменения сохраненеы",Toast.LENGTH_LONG).show();
       }
       catch (FileNotFoundException e)
       {
           e.printStackTrace();
       }
       catch (IOException e)
       {
           e.printStackTrace();
       }
    }

    public void read (View view){
        try {
        FileInputStream fileInput = openFileInput("file.txt");
        InputStreamReader reader = new InputStreamReader(fileInput);
        BufferedReader buffer = new BufferedReader (reader);
        StringBuffer stringBuffer = new StringBuffer();
        String lines;
        while ((lines = buffer.readLine()) != null)
        {
            stringBuffer.append(lines+"\n");
            editTxt.setText(stringBuffer.toString());
        }
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
