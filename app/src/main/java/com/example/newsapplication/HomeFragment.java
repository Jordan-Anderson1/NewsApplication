package com.example.newsapplication;



import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //COMPONENTS FOR TOP STORIES RECYCLERVIEW

    RecyclerView topStoriesRecyclerView;
    StoriesRecyclerAdapter topStoriesRecyclerAdapter;

    List<NewsArticle> topStoriesList = new ArrayList<>();

    String[] topTitleList = {"Foo",
            "Bar",
            "Baz",
            "qux",
            "quux",
            "corge",
            "grault"};
    String[] topDescriptionList = {"A TOP news story about Foo",
            "A TOP news story about Bar",
            "A TOP news story about Baz",
            "A TOP news story about qux",
            "A TOP news story about quux",
            "A TOP news story about corge",
            "A TOP news story about grault"};


    ///COMPONENTS FOR MAIN NEWS ARTICLES

    RecyclerView newsRecyclerView;
    StoriesRecyclerAdapter storiesRecyclerAdapter;

    List<NewsArticle> storiesList = new ArrayList<>();
    String[] titleList = {"garply",
            "waldo",
            "fred",
            "plugh",
            "xyzzy",
            "thud",
            "Lambdax",
            "Muon",
            "Neutrino",
            "Omega",
            "Psi",
            "Rho",
            "Sigma"};

    String[] descriptionList = {
            "description for garply story",
            "description for waldo story",
            "description for fred story",
            "description for plugh story",
            "description for xyzzy story",
            "description for thud story",
            "description for Lambdax story",
            "description for Muon story",
            "description for Neutrino story",
            "description for Omega story",
            "description for Psi story",
            "description for Rho story",
            "description for Sigma story"
    };






    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //intialise  top stories recycler view

        topStoriesRecyclerView = view.findViewById(R.id.topStoriesRecycler);
        topStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));

        //initialise news recycler view
        newsRecyclerView = view.findViewById(R.id.newsRecycler);
        newsRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2, GridLayoutManager.HORIZONTAL, false));


        //initialise topStories list
        for(int i = 0; i < topTitleList.length; i++){
            NewsArticle article = new NewsArticle(topTitleList[i], topDescriptionList[i]);
            topStoriesList.add(article);
        }

        //initalise news list
        for(int i = 0; i < titleList.length; i++){
            NewsArticle article = new NewsArticle(titleList[i], descriptionList[i]);
            storiesList.add(article);
        }

        //Initialise adapters
        topStoriesRecyclerAdapter = new StoriesRecyclerAdapter(topStoriesList, getActivity().getSupportFragmentManager());
        storiesRecyclerAdapter = new StoriesRecyclerAdapter(storiesList, getActivity().getSupportFragmentManager());


        //SET ADAPTERS
        topStoriesRecyclerView.setAdapter(topStoriesRecyclerAdapter);
        newsRecyclerView.setAdapter(storiesRecyclerAdapter);
        return view;



    }
}