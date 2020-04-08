package com.lff.myhometown_a;

import android.app.Activity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;
import com.example.caresyx.myhometown2.R;

import java.util.ArrayList;
import java.util.List;

public class Mvzjk extends Activity {

    private List<String> groupdate;//定义组
    private List<List<String>> childrendate;//定义组中的子条目
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mvzjk);

        ExpandableListView expandable = (ExpandableListView)findViewById(R.id.list);

        groupdate = new ArrayList<String>();
        groupdate.add("张家口辖区");
        groupdate.add("张家口美食");
        groupdate.add("旅游景点");

        childrendate = new ArrayList<List<String>>();

        List<String> child1 = new ArrayList<String>();
        child1.add("桥东区");
        child1.add("桥西区");
        child1.add("宣化区");
        child1.add("下花园区");
        child1.add("万全区");
        child1.add("崇礼区");
        child1.add("张北县");
        child1.add("康保县");
        child1.add("沽源县");
        child1.add("尚义县");
        child1.add("蔚县");
        child1.add("阳原县");
        child1.add("怀安县");
        child1.add("怀来县");
        child1.add("涿鹿县");
        child1.add("赤城县");
        childrendate.add(child1);

        List<String> child2 = new ArrayList<String>();
        child2.add("黄糕");
        child2.add("莜面");
        child2.add("熏肉");
        child2.add("圪渣饼");
        child2.add("牛奶葡萄");
        childrendate.add(child2);

        List<String> child3 = new ArrayList<String>();
        child3.add("大境门");
        child3.add("小五台山");
        child3.add("暖泉古镇");
        child3.add("坝上草原");
        child3.add("黄帝城");
        child3.add("鸡鸣山");
        child3.add("草原天路");
        child3.add("安家沟风景区");
        childrendate.add(child3);

        expandable.setAdapter(new ExpandableAdapter());

    }

    class ExpandableAdapter extends BaseExpandableListAdapter {
        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childrendate.get(groupPosition).get(childPosition);
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return 0;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            TextView myText = null;
            if (convertView != null) {
                myText = (TextView) convertView;
                myText.setText(childrendate.get(groupPosition).get(childPosition));
            } else {
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT, 200);
                myText = new TextView(Mvzjk.this);
                myText.setLayoutParams(layoutParams);
                myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                myText.setPadding(100, 10, 10, 10);
                myText.setTextSize(20);
                myText.setText(childrendate.get(groupPosition).get(childPosition));
            }
            return myText;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childrendate.get(groupPosition).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return childrendate.get(groupPosition);
        }

        @Override
        public int getGroupCount() {
            return childrendate.size();
        }

        @Override
        public long getGroupId(int groupPosition) {
            return 0;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
            TextView myText = null;
            int[] logos = new int[]{R.drawable.xq2, R.drawable.ms, R.drawable.jd};
            if (convertView != null) {
                myText = (TextView) convertView;
                myText.setText(groupdate.get(groupPosition));
            } else {
                myText = new TextView(Mvzjk.this);
                AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 300);
                myText.setLayoutParams(layoutParams);
                myText.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
                myText.setPadding(150, 10, 10, 10);
                myText.setTextSize(30);
                myText.setText(groupdate.get(groupPosition));
            }
            return myText;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
