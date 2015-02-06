package fragment;

import java.util.ArrayList;
import java.util.List;

import com.example.fragmentbestpractice.NewsContentActivity;
import com.example.fragmentbestpractice.R;

import pojo.News;

import adapter.NewsAdapter;
import android.R.integer;
import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class NewsTitleFragment extends Fragment implements OnItemClickListener {
	private ListView newsTitleListView;
	private List<News> newsList;
	private NewsAdapter adapter;
	private boolean isTwoPane;
	@Override
	public void onAttach(Activity activity)
	{
		super.onAttach(activity);
		newsList=getNews();//初始化新闻
		adapter=new NewsAdapter(activity,R.layout.news_item,newsList);
	}
	private List<News> getNews()
	{
		List<News> newsList=new ArrayList<News>();
		News news1=new News();
		news1.setTitle("China sets up mission to the African Union");
		news1.setContent("China has established a permanent mission to the African Union headquarters in Addis Ababa, the Ethiopian capital.");
		newsList.add(news1);
		News news2=new News();
		news2.setTitle("Pilot avoided bigger tragedy by ditching plane in river");
		news2.setContent("Pilot of the crashed TransAsia Airways plane narrowly avoided hitting buildings, likely averting a worse disaster, according to a report.");
		newsList.add(news2);
		News news3=new News();
		news3.setTitle("Fourth panda dies from virus in NW China");
		news3.setContent("Six-year-old panda, Feng Feng, died from heart failure after days of treatment, the fourth victim of canine distemper virus in Shaanxi province.");
		newsList.add(news3);
		return newsList;
	}
	@Override
	public void onItemClick(AdapterView<?> parent,View v,int position,long id) {
		// TODO Auto-generated method stub
		News news=newsList.get(position);
		if(isTwoPane)//如果是双页模式
		{
			NewsContentFragment newsContentFragment=(NewsContentFragment)getFragmentManager().findFragmentById(R.id.news_content_fragment);
			newsContentFragment.refresh(news.getTitle(), news.getContent());
		}
		else {
			NewsContentActivity.actionStart(getActivity(), news.getTitle(), news.getContent());
		}
	}
	@Override
	public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState){
		View view=inflater.inflate(R.layout.news_title_frag, container,false);
		newsTitleListView=(ListView)view.findViewById(R.id.news_title_list_view);
		newsTitleListView.setAdapter(adapter);
		newsTitleListView.setOnItemClickListener(this);
		return view;
	}
	@Override
	public void onActivityCreated(Bundle savedInstanceState)
	{
		super.onActivityCreated(savedInstanceState);
		if(getActivity().findViewById(R.id.news_content_fragment)!=null)//可以找到news_content_layout，为双页模式
		{
			isTwoPane=true;
		}
		else {
			isTwoPane=false;
		}
	}
}
