package com.koekoetech.movieshop.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.koekoetech.movieshop.R;
import com.koekoetech.movieshop.model.Category;

import java.util.List;

/**
 * Created by Hein Htet on 8/16/2017.
 **/

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.MyViewHolder> {

    private List<Category> categoryList;

    public CategoryAdapter(List<Category> moviesList) {
        this.categoryList = moviesList;
    }

    @Override
    public CategoryAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_category_item, parent, false);

        return new CategoryAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CategoryAdapter.MyViewHolder holder, int position) {
        Category category = categoryList.get(position);
        holder.itemCategoryName.setText(category.getCategoryName());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public Button itemCategoryName;

        public MyViewHolder(View view) {
            super(view);
            itemCategoryName = (Button) view.findViewById(R.id.category_name);
        }
    }

}
