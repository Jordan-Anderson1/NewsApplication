package com.example.newsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class ArticleFragment extends Fragment {

    RecyclerView relatedRecyclerView;

    StoriesRecyclerAdapter relatedRecyclerAdapter;

    List<NewsArticle> relatedArticlesList = new ArrayList<>();

    String[] relatedTitles = {
            "Related title 1",
            "Related title 2",
            "Related title 3",
            "Related title 4",
            "Related title 5",
            "Related title 1",
            "Related title 1"
    };


    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";


    private String title;
    private String description;

    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance(String title, String description) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            description = getArguments().getString(ARG_DESCRIPTION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_article, container, false);

        TextView titleTextView = view.findViewById(R.id.articleTitleText);
        TextView descriptionTextView = view.findViewById(R.id.articleDescriptionText);

        titleTextView.setText(title);
        descriptionTextView.setText(description);

        return view;


    }
}