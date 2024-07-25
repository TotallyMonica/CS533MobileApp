package com.github.totallymonica.cs533mobileapp.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.github.totallymonica.cs533mobileapp.R;
import com.github.totallymonica.cs533mobileapp.activity.ProductActivity;
import com.github.totallymonica.cs533mobileapp.model.Category;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * CS533 Mobile App
 * https://github.com/TotallyMonica/CS533MobileApp
 * Created on 18-Feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */
public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    List<Category> categoryList;
    Context context;
    String Tag;

    public CategoryAdapter(List<Category> categoryList, Context context) {
        this.categoryList = categoryList;
        this.context = context;
    }

    public CategoryAdapter(List<Category> categoryList, Context context, String tag) {
        this.categoryList = categoryList;
        this.context = context;
        Tag = tag;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView;
        if (Tag.equalsIgnoreCase("Home")) {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_home_category, parent, false);
        } else {
            itemView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.row_category, parent, false);
        }


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {

        final Category category = categoryList.get(position);
        holder.title.setText(category.getTitle());

        if (Tag.equalsIgnoreCase("Category")) {
            String image = category.getImage();
            if (image.startsWith("drawable/")) {
                // Check if the image string starts with "drawable/" indicating a local resource
                // Extract the drawable resource name and get the resource ID
                String resourceName = image.replace("drawable/", "");
                int resId = holder.itemView.getContext().getResources().getIdentifier(resourceName, "drawable", holder.itemView.getContext().getPackageName());
                if (resId != 0) {
                    holder.imageView.setImageResource(resId);
                    holder.progressBar.setVisibility(View.GONE);
                } else {
                    Log.d("CategoryAdapter", "Drawable resource not found: " + resourceName);
                }
            } else {
                Picasso.get()
                        .load(image)
                        .into(holder.imageView, new Callback() {
                            @Override
                            public void onSuccess() {
                                holder.progressBar.setVisibility(View.GONE);
                            }

                            @Override
                            public void onError(Exception e) {
                                Log.d("CategoryAdapter", "Error loading image: " + e.getMessage());
                            }
                        });
            }
        }

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProductActivity.class);
                intent.putExtra("CATEGORY_ID", category.getId());
                intent.putExtra("CATEGORY_TITLE", category.getTitle());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                context.startActivity(intent);
            }
        };

        holder.cardView.setOnClickListener(listener);
        holder.title.setOnClickListener(listener);
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView title;
        ProgressBar progressBar;
        CardView cardView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.category_image);
            title = itemView.findViewById(R.id.category_title);
            progressBar = itemView.findViewById(R.id.progressbar);
            cardView = itemView.findViewById(R.id.card_view);
        }
    }
}
