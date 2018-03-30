package ly.mysummery.commom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;
import java.util.List;

import ly.mysummery.utils.ViewHolder;


public abstract class CommonAdapter<T> extends BaseAdapter
{
	protected ViewHolder holder;
	protected Context mContext;
	protected List<T> mDatas;
	protected LayoutInflater mInflater;
	protected int mlayoutId;


	public CommonAdapter(Context context, List<T> datas, int layoutId)
	{
		init(context, datas, layoutId);
	}

	public void init(Context context, List<T> datas, int layoutId){
		this.mContext = context;
		if (datas!=null)
			this.mDatas = datas;
		mDatas = new ArrayList<>();
		this.mlayoutId = layoutId;
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public int getCount()
	{
		if (mDatas==null) mDatas = new ArrayList<>();
		return mDatas.size();
	}


	@Override
	public T getItem(int position)
	{
		return mDatas.get(position);
	}


	@Override
	public long getItemId(int position)
	{
		return position;
	}


//	@Override
//	public abstract View getView(int position, View convertView, ViewGroup parent);
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		holder = ViewHolder.get(mContext, convertView, parent, mlayoutId, position);
		
		convert(holder, getItem(position),position);
		
		return holder.getConvertView();
	}
	
	public abstract void convert(ViewHolder holder, T t, int position);

	public void setList(List<T>list){
		this.mDatas = list;
		super.notifyDataSetChanged();
	}

	public void addAll(List<T>list){
		this.mDatas.addAll(list);
		super.notifyDataSetChanged();
	}

	public void addAll(int pos,List<T>list){
		this.mDatas.addAll(pos,list);
		super.notifyDataSetChanged();
	}

	public void add(int position,T t){
		if (mDatas==null) mDatas = new ArrayList<>();
		this.mDatas.add(position,t);
		super.notifyDataSetChanged();
	}

	public void clearAll(){
		this.mDatas.clear();
		super.notifyDataSetChanged();
	}

	public void delete(T t){
		mDatas.remove(t);
		super.notifyDataSetChanged();
	}

	public void delete(int position){
		mDatas.remove(position);
		super.notifyDataSetChanged();
	}

	public List<T> getmDatas() {
		return mDatas;
	}
}