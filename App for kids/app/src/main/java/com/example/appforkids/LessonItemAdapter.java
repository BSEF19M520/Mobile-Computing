package com.example.appforkids;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class LessonItemAdapter extends ArrayAdapter<LessonItem> {
    public LessonItemAdapter(@NonNull Context context, @NonNull List<LessonItem> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LessonItem lessonItem = getItem(position);
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.lesson_item, parent,
                false);

        ((ImageView) convertView.findViewById(R.id.lessonItem_imageView)).setImageResource(lessonItem.getImageId());
        ((TextView) convertView.findViewById(R.id.lessonItem_textView)).setText(lessonItem.getImageName());

        return convertView;
    }
}
