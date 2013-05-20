package com.example.test1;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;


public class ElvAdapter extends BaseExpandableListAdapter {
	String[] parent={"p1","p2"};
	String[][] child={
			{"c11","c12"},
			{"c21"}
	};
	Context context;
	ElvAdapter(Context c){
		context = c;
	}
	@Override
	public Object getChild(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return child;
	}

	@Override
	public long getChildId(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getChildView(int arg0, int arg1, boolean arg2, View arg3,
			ViewGroup arg4) {
		TextView tv = new TextView(context);
		tv.setText(child[arg0][arg1]);
		//arg3.setPadding(30, 0, 0, 0);
		return tv;
	}

	@Override
	public int getChildrenCount(int arg0) {
		// TODO Auto-generated method stub
		return child[arg0].length;
	}

	@Override
	public Object getGroup(int arg0) {
		// TODO Auto-generated method stub
		return parent;
	}

	@Override
	public int getGroupCount() {
		// TODO Auto-generated method stub
		return parent.length;
	}

	@Override
	public long getGroupId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getGroupView(int arg0, boolean arg1, View arg2, ViewGroup arg3) {
		TextView tv = new TextView(context);
		tv.setText(parent[arg0]);
		arg3.setPadding(20, 0, 0, 0);
		return tv;
	}

	@Override
	public boolean hasStableIds() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isChildSelectable(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return true;
	}

}
