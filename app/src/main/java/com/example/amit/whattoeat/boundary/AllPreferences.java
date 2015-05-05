package com.example.amit.whattoeat.boundary;

import android.content.Context;
import android.nfc.Tag;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.amit.whattoeat.R;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class AllPreferences extends ActionBarActivity {
private Button mSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preferences);
        mSubmit = (Button)findViewById(R.id.button);

        mSubmit.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View v) {
                        Toast.makeText(AllPreferences.this, R.string.submit_toast, Toast.LENGTH_SHORT).show();
                    }
                }
        );
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_preferences, menu);
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

    public void saveIngredientChoice(ArrayList<String> userChoice){
        String FileName = "userIngredients";
        try {
            FileOutputStream fo = openFileOutput(FileName, Context.MODE_PRIVATE);

        for(int i = 0; i <userChoice.size();i++){
            fo.write(userChoice.get(i).getBytes());
        }
            fo.close();
        }catch(FileNotFoundException f_no){
            Log.v("AllPreferences", "File not found");
        }
        catch(IOException io_prob){
            Log.d("AllPreferences","Could not read write the file");
        }

    }
}
