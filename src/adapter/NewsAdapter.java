package adapter;

import java.util.List;

import com.example.fragmentbestpractice.R;

import pojo.News;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class NewsAdapter extends ArrayAdapter<News> {
	private int resource_id;
	public NewsAdapter(Context context, int resource, List<News> objects) {
		super(context, resource, objects);
		// TODO Auto-generated constructor stub
		resource_id=resource;
	}
	@Override
	public View getView(int position,View convertView,ViewGroup parent)
	{
		//获取当前项的Fruit实例
		News news=getItem(position);
		View view;
		ViewHolder viewHolder;
		if (convertView==null) {
			view=LayoutInflater.from(getContext()).inflate(resource_id, null);
			viewHolder=new ViewHolder();
			viewHolder.title=(TextView)view.findViewById(R.id.news_title);
			view.setTag(viewHolder);
		}
		else {
			view=convertView;
			viewHolder=(ViewHolder)view.getTag();
		}
		viewHolder.title.setText(news.getTitle());
		return view;
	}
	//ViewHolder 模式, 效率提高 50% 
	class ViewHolder { 
		TextView title;
	 }
}
