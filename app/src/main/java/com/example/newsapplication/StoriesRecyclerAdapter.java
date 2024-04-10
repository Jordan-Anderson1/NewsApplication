package com.example.newsapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class StoriesRecyclerAdapter extends RecyclerView.Adapter<StoriesRecyclerAdapter.ViewHolder> {

    private FragmentManager fragmentManager;

    private List<NewsArticle> storiesList;

    int position;

    public StoriesRecyclerAdapter(List<NewsArticle> storiesList, FragmentManager fragmentManager){
        this.storiesList = storiesList;
        this.fragmentManager = fragmentManager;


    }




    @NonNull
    @Override
    public StoriesRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_card, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull StoriesRecyclerAdapter.ViewHolder holder, int position) {
        holder.title.setText(storiesList.get(position).getTitle());
        holder.description.setText(storiesList.get(position).getDescription());

        NewsArticle article = storiesList.get(position);

        Picasso.get().load(storiesList.get(position).getImageUrl()).into(holder.image);


        }


    @Override
    public int getItemCount() {
        return storiesList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView description;

        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleText);
            description = itemView.findViewById(R.id.articleText);
            image = itemView.findViewById(R.id.imageView);


            //SET ON CLICK LISTENER
            itemView.setOnClickListener(view -> {
                int position = getAbsoluteAdapterPosition();
                if(position != RecyclerView.NO_POSITION) {
                    NewsArticle clickedArticle = storiesList.get(position);
                    //Log.d("Recycler", "ClickedTitle: " + clickedArticle.getTitle() + "Clicked desc: " + clickedArticle.getDescription());
                    Fragment fragment;
                    fragment = new ArticleFragment();

                    navigateToArticleFragment(clickedArticle);

                }
            });

        }

        private void navigateToArticleFragment(NewsArticle article){

            Bundle bundle = new Bundle();
            bundle.putString("title", article.getTitle());
            bundle.putString("description", article.getDescription());
            bundle.putString("imageUrl", article.getImageUrl());
//           bundle.putString("url", imageUrl);

            ArticleFragment fragment = new ArticleFragment();
            fragment.setArguments(bundle);


            //ArticleFragment fragment = ArticleFragment.newInstance(article.getTitle(), article.getDescription());

            FragmentTransaction transaction = ((FragmentActivity) itemView.getContext()).getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.fragmentContainerView, fragment);
            transaction.addToBackStack(null);
            transaction.commit();



//            fragmentManager.beginTransaction()
//                    .replace(R.id.fragmentContainerView, fragment)
//                    .addToBackStack(null)
//                    .commit();
//
        }


    }

}

