package com.example.androidlab3_part1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapter extends BaseAdapter {

    private List<MainActivity.Film> data;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<MainActivity.Film> data) {
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // 1. Проверяем, есть ли у нас пункт списка для повторного использования
        if (convertView == null)
            convertView = inflater.inflate(R.layout.list_item, parent, false);

        // 2. Получаем доступ к виджетам дерева объектов
        TextView title = convertView.findViewById(R.id.title);
        ImageView image = convertView.findViewById(R.id.imageView);
        TextView date = convertView.findViewById(R.id.date);

        // 3. Меняем содержимое виджетов
        title.setText(data.get(position).getTitle());
        image.setImageResource(data.get(position).getAvatarId());
        date.setText(data.get(position).getDate());

        // 4. Возвращаем модифицированное дерево объектов
        return convertView;
    }
}
