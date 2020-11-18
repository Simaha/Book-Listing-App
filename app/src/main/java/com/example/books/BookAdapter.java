package com.example.books;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends ArrayAdapter<Books> {

    private static final String LOG_TAG = BookAdapter.class.getSimpleName();

    public BookAdapter(Context context, ArrayList<Books> book){
        super(context, 0, book);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        Books currentBook = getItem(position);

        //ImageView imageView = listItemView.findViewById(R.id.thumbnail);
        //imageView.setImageResource(currentBook.getThumbnail());

        TextView titleTextView = listItemView.findViewById(R.id.title);
        titleTextView.setText(currentBook.getTitle());

        TextView  authorTextView = listItemView.findViewById(R.id.author);
        authorTextView.setText(currentBook.getAuthors());

        TextView dateTextView = listItemView.findViewById(R.id.date);
        dateTextView.setText(currentBook.getDate());

        return listItemView;
    }
}
