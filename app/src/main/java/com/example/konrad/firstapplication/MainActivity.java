package com.example.konrad.firstapplication;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends ActionBarActivity {

    public MainActivity this1= this;
    private Spinner spinner1, spinner2, spinner3;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnSpinnerDimensionSelection();
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void addListenerOnSpinnerDimensionSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner); //Main spinner with dimension choice
        spinner2 = (Spinner) findViewById(R.id.spinner2); //reference spinner
        spinner3 = (Spinner) findViewById(R.id.spinner3); //target spinner

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            String[] pom1 = getResources().getStringArray(R.array.mass_units); // takes Strings from XML and puts into table
            ArrayList<String> l1 = new ArrayList<String>(Arrays.asList(pom1)); // makes array list out of table
            ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l1);
            String[] pom2 = getResources().getStringArray(R.array.distance_units); // takes Strings from XML and puts into table
            ArrayList<String> l2 = new ArrayList<String>(Arrays.asList(pom2)); // makes array list out of table
            ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l2);
            String[] pom3 = getResources().getStringArray(R.array.temperature_units); // takes Strings from XML and puts into table
            ArrayList<String> l3 = new ArrayList<String>(Arrays.asList(pom3)); // makes array list out of table
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this1, android.R.layout.simple_spinner_item, l3);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String chosenDimension = new String();
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                chosenDimension = spinner1.getSelectedItem().toString();
                if (chosenDimension.equals("Mass")) {
                    spinner2.setAdapter(adapter1);
                    spinner3.setAdapter(adapter1);
                } else if (chosenDimension.equals("Distance")) {
                    spinner2.setAdapter(adapter2);
                    spinner3.setAdapter(adapter2);
                } else if (chosenDimension.equals("Temperature")) {
                    spinner2.setAdapter(adapter3);
                    spinner3.setAdapter(adapter3);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_exit) {
            finish();
            System.exit(0);
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClick(View v) {
        EditText e1 = (EditText) findViewById(R.id.editText);
        TextView r1 = (TextView) findViewById(R.id.textView2);
        String txt0=spinner1.getSelectedItem().toString();
        String txt1=spinner2.getSelectedItem().toString();
        String txt2=spinner3.getSelectedItem().toString();
        try {
            String a = e1.getText().toString();

            ConverterFactory cf1 = new ConverterFactory();
            AbstractConverter c1 = cf1.createConverter(txt0);
            String nt = c1.convert(a,txt1,txt2);
            r1.setText(nt);

        } catch(Exception io){
            r1.setText("Incorrect input");
        }
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.konrad.firstapplication/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app deep link URI is correct.
                Uri.parse("android-app://com.example.konrad.firstapplication/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }
}
