package com.example.fragmentbestpractice;

import fragment.NewsContentFragment;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class NewsContentActivity extends Activity {
	public static void actionStart(Context context,String newsTitle,String newsContent) {
		Intent intent=new Intent(context, NewsContentActivity.class);
		intent.putExtra("news_title", newsTitle);
		intent.putExtra("news_content", newsContent);
		context.startActivity(intent);
	}
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.news_conent);
		String newsTitle=getIntent().getStringExtra("news_title");
		String newsContent=getIntent().getStringExtra("news_content");
		//获取传入的新闻标题和内容
		NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
		newsContentFragment.refresh(newsTitle, newsContent);
		//刷新newsContentFragment的界面
	}
}
