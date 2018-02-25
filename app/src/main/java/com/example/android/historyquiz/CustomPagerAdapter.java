package com.example.android.historyquiz;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CustomPagerAdapter extends PagerAdapter {

    private Context context;

    CustomPagerAdapter(Context context) {
        this.context = context;
    }

    private int layouts[] = {R.layout.question_one, R.layout.question_two, R.layout.question_three, R.layout.question_four, R.layout.question_five,
            R.layout.question_six, R.layout.question_seven, R.layout.question_eight, R.layout.question_nine, R.layout.question_ten};

    @Override
    public int getCount() {
        return layouts.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View one = layoutInflater.inflate(R.layout.question_one, container, false);
        View two = layoutInflater.inflate(R.layout.question_two, container, false);
        View three = layoutInflater.inflate(R.layout.question_three, container, false);
        View four = layoutInflater.inflate(R.layout.question_four, container, false);
        View five = layoutInflater.inflate(R.layout.question_five, container, false);
        View six = layoutInflater.inflate(R.layout.question_six, container, false);
        View seven = layoutInflater.inflate(R.layout.question_seven, container, false);
        View eight = layoutInflater.inflate(R.layout.question_eight, container, false);
        View nine = layoutInflater.inflate(R.layout.question_nine, container, false);
        View ten = layoutInflater.inflate(R.layout.question_ten, container, false);
        View viewarr[] = {one, two, three, four, five, six, seven, eight, nine, ten};
        container.addView(viewarr[position]);
        return viewarr[position];
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }

}
