package com.vinit.listviewtemplate;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.vinit.listviewtemplate.models.Tweet;


public class ListAdapter extends ArrayAdapter<Tweet> {

	ImageView iv_image;
	TextView tv_title;
	TextView tv_creator;
	protected ImageLoader imageLoader;

	public ListAdapter(Context context, ArrayList<Tweet> tweet) {
		super(context,0, tweet);
		imageLoader = ImageLoader.getInstance();
		imageLoader.init(ImageLoaderConfiguration.createDefault(context));
	}


	public View getView(int position, View convertView, ViewGroup parent){
		View view = convertView;

		if(view  == null){
			LayoutInflater inflator = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflator.inflate(R.layout.tweet_item, null);
		}
		Tweet tweet= getItem(position);

		iv_image = (ImageView) view.findViewById(R.id.iv_image);
		ImageLoader.getInstance().displayImage(tweet.getImageUrl(), iv_image);

		tv_creator = (TextView) view.findViewById(R.id.tv_creator);
		tv_creator.setText(tweet.getCreator());

		tv_title = (TextView) view.findViewById(R.id.tv_title);
		tv_title.setText(tweet.getTitle());

		return view;
	}
}
