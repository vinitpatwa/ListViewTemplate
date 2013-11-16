package com.vinit.listviewtemplate;

import java.util.ArrayList;

import com.vinit.listviewtemplate.models.Tweet;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.AbsListView;
import android.widget.Toast;
import eu.erikw.PullToRefreshListView;
import eu.erikw.PullToRefreshListView.OnRefreshListener;


import com.haarman.listviewanimations.itemmanipulation.OnDismissCallback;
import com.haarman.listviewanimations.itemmanipulation.SwipeDismissAdapter;
import com.haarman.listviewanimations.swinginadapters.prepared.SwingBottomInAnimationAdapter;

public class ListActivity extends Activity implements OnDismissCallback {
	PullToRefreshListView lv_list;
	ListAdapter adapter;
	SwingBottomInAnimationAdapter swingBottomInAnimationAdapter;



	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		lv_list = (PullToRefreshListView) findViewById(R.id.lv_list);

		ArrayList<Tweet> tweet = Tweet.getSampleTweet();
		adapter = new ListAdapter(this, tweet);


		swingBottomInAnimationAdapter= new SwingBottomInAnimationAdapter(new SwipeDismissAdapter(adapter, this));
		swingBottomInAnimationAdapter.setInitialDelayMillis(300);
		swingBottomInAnimationAdapter.setAbsListView(lv_list);
		

		lv_list.setAdapter(swingBottomInAnimationAdapter);

		lv_list.setOnRefreshListener(new OnRefreshListener() {
			@Override
			public void onRefresh() {
				Toast.makeText(getBaseContext(),"pulled to refresh", Toast.LENGTH_SHORT).show();

				try{
					Thread.sleep(2000);
				}catch(Exception e){
					e.printStackTrace();
				}
				// Your code to refresh the list contents
				// Make sure you call listView.onRefreshComplete()
				// once the loading is done. This can be done from here or any
				// place such as when the network request has completed successfully.
				lv_list.onRefreshComplete();
			}
		});

	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}


	@Override
	public void onDismiss(AbsListView listView, int[] reverseSortedPositions) {
		// TODO Auto-generated method stub
	    for (int position : reverseSortedPositions) {
	    	Tweet t = adapter.getItem(position);
	    	adapter.remove(t);
	    }
	}

}
