package com.android.demo.listview;

import java.text.ChoiceFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;

public class BlogListVIewActivity extends Activity {
	
	
	ListView listView;
	
	ArrayList< String>arrayList; // list of the strings that should appear in ListView
	ArrayAdapter<String> arrayAdapter; // a middle man to bind ListView and array list 
	
   
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        listView = (ListView) findViewById(R.id.lstDemo);
        
        arrayList = new ArrayList<String>();
        arrayList.add("India");
        arrayList.add("USA");
        arrayList.add("England");
        arrayList.add("Singapur");
        arrayList.add("China");
        arrayList.add("Canada");
        arrayList.add("Srilanka");
        arrayList.add("SouthAfrica");
        
       
        
        
        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_single_choice,arrayList);
        listView.setAdapter(arrayAdapter);
        
        
        //  LETS HIGHLIGHT SELECTED ITEMS
        
        listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View view, int position,
					long itemId) {
				
				
				/*  
				 *  when we click on item on list view we can get it catch item here.
				 * so view is the item clicked in list view and position is the position 
				 * of that item in list view which was clicked.
				 * 
				 * Now that we know which item is click we can easily change the color
				 * of text but when we click on next item we we have to deselect the old 
				 * selected item means recolor it back to default , and then hight the 
				 * new selected item by coloring it .
				 * 
				 * So here's the code of doing it.
				 * 
				 * 
				 * */
				
				
				CheckedTextView textView = (CheckedTextView) view;
				for (int i = 0; i < listView.getCount(); i++) {
					textView= (CheckedTextView) listView.getChildAt(i);
					if (textView != null) {
						textView.setTextColor(Color.WHITE);
					}
					
				}
				listView.invalidate();
				textView = (CheckedTextView) view;
				if (textView != null) {
					textView.setTextColor(Color.BLUE);
				}

			}
		});
        
        
    }
}