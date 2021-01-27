package com.codepath.recyclerviewlab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.codepath.recyclerviewlab.models.Article;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ArticleResultsRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final List<Article> articleList = new ArrayList<>();


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_article_result, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Article article = articleList.get(position);
        ArticleViewHolder articleViewHolder = (ArticleViewHolder) holder;
        articleViewHolder.article_headline.setText(article.headline.main);
        articleViewHolder.article_snippet.setText(article.snippet);
    }

    // Create a "set new articles" and an "addArticles"
    void setNewArticles(List<Article> articles)
    {
        articleList.clear();
        articleList.addAll(articles);
    }

    void addArticles(List<Article> articles)
    {
        articleList.addAll(articles);
    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }



    public class ArticleViewHolder extends RecyclerView.ViewHolder {

        public TextView article_pub_date;
        public TextView article_headline;
        public TextView article_snippet;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);

            article_pub_date = (TextView) itemView.findViewById(R.id.article_pub_date);
            article_headline = (TextView) itemView.findViewById(R.id.article_headline);
            article_snippet = (TextView) itemView.findViewById(R.id.article_snippet);
        }


    }
}
