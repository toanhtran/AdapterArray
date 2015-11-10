package com.toanhtran.adapterarray;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    public static final String EXTRA_TEXT = "com.toanhtran.adapterarray.EXTRA_TEXT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String[] myArray = {"Americable: 0956-50-2172","Auto Service Center(Garage): 0956-50-3607","Auto Service Center(Rent-a-car): 0956-50-3576","Fire Department: 0956-502142",
                "Base Operator: 0956-50-1110","Dental Clinic (MB): 0956-50-3886","Dental Clinic (Hario):0956-50-8977","Dr. On Call: Weekends/holidays and after hours: 080-1721-7310",
                "Medical Emergency Care: 0956-50-0911", "Medical Urgent Care/Duty Nurse: 0956-50-2550","Medical Routine Appointment: 0956-50-8872","Nurse Advice: 0956-50-2550",
                "Pet Care: 0956-50-3627"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<>(this, R.layout.list_item, myArray);

        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override


            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView clickedTextView = (TextView) view.findViewById(R.id.textview);
                String text = clickedTextView.getText().toString();
                startDetailActivity(text);

            }

        });

    }

        private void startDetailActivity(String text) {
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra(EXTRA_TEXT, text);
            startActivity(intent);
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list, menu);
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
}
