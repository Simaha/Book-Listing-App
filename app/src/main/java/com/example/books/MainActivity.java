package com.example.books;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private BookAdapter adapter;

    /** URL for the books data from Google Books Api **/
    private static final String BOOKS_API =
            "https://www.googleapis.com/books/v1/volumes?q=android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BookAsyncTask task = new BookAsyncTask();
        task.execute(BOOKS_API);

        ListView listView = findViewById(R.id.listView);
        adapter = new BookAdapter(this, new ArrayList<Books>());
        listView.setAdapter(adapter);
    }

    private class BookAsyncTask extends AsyncTask<String, Void, ArrayList<Books>>{

        @Override
        protected ArrayList<Books> doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            ArrayList<Books> result = QueryUtils.fetchBookData(urls[0]);
            return result;
        }

        @Override
        protected void onPostExecute(ArrayList<Books> data) {
            adapter.clear();

            if(data != null && !data.isEmpty()){
                adapter.addAll(data);
            }
        }
    }
}