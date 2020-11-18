package com.example.books;

public class Books {

    private String mTitle;
    private String mAuthors;
    private String mDate;

    public Books(String title, String authors, String date){
        mTitle = title;
        mAuthors = authors;
        mDate = date;
    }

    public String getTitle(){ return mTitle; }

    public String getAuthors(){ return  mAuthors; }

    public String getDate(){ return mDate; }
}
