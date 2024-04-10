package com.example.newsapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;


public class ArticleFragment extends Fragment {


    RecyclerView relatedArticlesRecyclerView;

    StoriesRecyclerAdapter relatedRecyclerAdapter;

    List<NewsArticle> relatedArticlesList = new ArrayList<>();

    ImageView imageView;


    private static final String ARG_TITLE = "title";
    private static final String ARG_DESCRIPTION = "description";

    private static final String ARG_URL = "imageUrl";





    private String title;
    private String description;

    private String imageUrl;

    //private String url;





    public ArticleFragment() {
        // Required empty public constructor
    }

    public static ArticleFragment newInstance(String title, String description, String imageUrl) {
        ArticleFragment fragment = new ArticleFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESCRIPTION, description);
        args.putString(ARG_URL, imageUrl);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_TITLE);
            description = getArguments().getString(ARG_DESCRIPTION);
            imageUrl = getArguments().getString(ARG_URL);
            //url = getArguments().getString(ARG_URL);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_article, container, false);

        //intialise  related articles recycler view

        relatedArticlesRecyclerView = view.findViewById(R.id.relatedArticlesRecyclerView);
        relatedArticlesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        //initialise relatedStories list
        for(int i = 0; i < 10; i++){
            NewsArticle article = new NewsArticle(("Related Article Title " + String.valueOf(i)), ("Description for related title " + String.valueOf(i)));
            relatedArticlesList.add(article);
        }

        relatedRecyclerAdapter = new StoriesRecyclerAdapter(relatedArticlesList, getActivity().getSupportFragmentManager());


        relatedArticlesRecyclerView.setAdapter(relatedRecyclerAdapter);

        TextView titleTextView = view.findViewById(R.id.articleTitleText);
        TextView descriptionTextView = view.findViewById(R.id.articleDescriptionText);
        ImageView image = view.findViewById(R.id.imageView2);



        titleTextView.setText(title);
        descriptionTextView.setText(description);
        Picasso.get().load(imageUrl).into(image);

        return view;




    }

}
