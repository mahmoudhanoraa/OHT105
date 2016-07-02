package com.hanora.mahmoud.oht105;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.firebase.client.Firebase;
import com.hanora.mahmoud.oht105.java.Figure;

import java.util.HashMap;
import java.util.Map;

public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        // Add items via the Button and EditText at the bottom of the view.
        final EditText id = (EditText) findViewById(R.id.add_etID);
        final EditText name = (EditText) findViewById(R.id.add_etName);
        final EditText brief = (EditText) findViewById(R.id.add_etBrief);
        final EditText fromDate = (EditText) findViewById(R.id.add_etfromDate);
        final EditText toDate = (EditText) findViewById(R.id.add_etToDate);
        final EditText content = (EditText) findViewById(R.id.add_etContent);
        final EditText image = (EditText) findViewById(R.id.add_etImage);
        final EditText frontnote = (EditText) findViewById(R.id.add_etFrontNote);

        final Button button = (Button) findViewById(R.id.add_bAdd);

        assert button != null;
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Figure figure = new Figure();
                figure.setId(Integer.parseInt(id.getText().toString()));
                figure.setName(name.getText().toString());
                figure.setBrief(brief.getText().toString());
                figure.setFromDate(fromDate.getText().toString());
                figure.setToDate(toDate.getText().toString());
                figure.setContent(content.getText().toString());
                figure.setImage(image.getText().toString());
                figure.setFrontNote(frontnote.getText().toString());
                Map<String, Object> figureMap = new HashMap<String, Object>();
                figureMap.put("Hey", figure);
                new Firebase(MainActivity.itemsUrl).child("" + figure.getId()).setValue(figure);
//                        .push()
//                        .setValue(figure);
            }
        });
    }
}
