package com.example.assignment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class customAdapter extends BaseAdapter {

    int [] images;
    String []food;
    Context context;
    private LayoutInflater layoutInflater;
    public customAdapter(Context context, String[] food, int[] images) {
        this.context=context;
        this.food=food;
        this.images=images;

    }

    @Override
    public int getCount() {
        return food.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView==null){
            layoutInflater= (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.sample_view,parent,false);
        }
        ImageView imageView= convertView.findViewById(R.id.food_image);
        TextView textView=convertView.findViewById(R.id.food_name);

        imageView.setImageResource(images[position]);
        textView.setText(food[position]);
        return convertView;
    }
}
