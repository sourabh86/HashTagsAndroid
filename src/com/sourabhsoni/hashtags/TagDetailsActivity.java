package com.sourabhsoni.hashtags;

import java.util.ArrayList;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TagDetailsActivity extends Activity {
	
	//List to store messages that contain clicked Tag.
	private ArrayList<String> messagesWithTag;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tag_details);
        
        messagesWithTag=new ArrayList<String>();
        ListView messagesListView=(ListView)findViewById(R.id.messagesWithTag);
        
        //Get the content URI
        Uri uri = getIntent().getData();
        //strip off hashtag from the URI
        String tag=uri.toString().split("/")[3];
        
        //Iterate through all the messages and find the ones
        //which contain this hashtag.
        for(String message:MainActivity.messagesList)
        {
        	if(message.contains(tag))
        	{
        		messagesWithTag.add(message);
        	}
        }
        
        //Show the list of messages which has the hashtag
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, messagesWithTag);
        messagesListView.setAdapter(adapter);
        
	}

}
