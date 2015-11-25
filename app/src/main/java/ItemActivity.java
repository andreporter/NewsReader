package com.porter.newsreader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;


/**
 * Created by Andre on 11/24/2015.
 */
public class ItemActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        // get references to widgets
        TextView titleTextView = (TextView) findViewById(R.id.titleTextView);
        TextView pubDateTextView = (TextView) findViewById(R.id.pubDateTextView);
        TextView descriptionTextView = (TextView) findViewById(R.id.descriptionTextView);
        TextView linkTextView = (TextView) findViewById(R.id.linkTextView);

        Intent intent = getIntent();
        String pubDate = intent.getStringExtra("pubdate");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description").replace('\n', ' ');

        pubDateTextView.setText(pubDate);
        titleTextView.setText(title);
        descriptionTextView.setText(description);

        linkTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = getIntent();
        String link = intent.getStringExtra("link");
        Uri viewUri = Uri.parse(link);

        Intent viewIntent = new Intent(Intent.ACTION_VIEW, viewUri);
        startActivity(viewIntent);
    }
}
