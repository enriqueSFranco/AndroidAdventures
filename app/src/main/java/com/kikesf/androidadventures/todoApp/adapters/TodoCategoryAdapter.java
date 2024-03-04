package com.kikesf.androidadventures.todoApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kikesf.androidadventures.R;
import com.kikesf.androidadventures.todoApp.TodoCategory;

import java.util.ArrayList;
import java.util.List;

// ADAPTER TODO_CATEGORY
public class TodoCategoryAdapter extends RecyclerView.Adapter<TodoCategoryAdapter.CategoryViewHolder> {
    private List<TodoCategory> todoCategories;

    // VIEW HOLDER TODO_CATEGORY
    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView tvCategoryName;
        private final View vDivider;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);

            tvCategoryName = (TextView) itemView.findViewById(R.id.tv_category_name);
            vDivider = (View) itemView.findViewById(R.id.v_divider);
        }

        public void render(TodoCategory todoCategory) {
            int dividerColor;
            String typeCategory;
            if (todoCategory.equals(TodoCategory.PERSONAL)) {
                typeCategory = TodoCategory.PERSONAL.toString();
                dividerColor = ContextCompat.getColor(vDivider.getContext(), R.color.blue_700);
            } else if (todoCategory.equals(TodoCategory.BUSINESS)) {
                typeCategory = TodoCategory.BUSINESS.toString();
                dividerColor = ContextCompat.getColor(vDivider.getContext(), R.color.orange_200);
            } else {
                typeCategory = TodoCategory.OTHER.toString();
                dividerColor = ContextCompat.getColor(vDivider.getContext(), R.color.gray_700);
            }
            tvCategoryName.setText(typeCategory);
            vDivider.setBackgroundColor(dividerColor);
        }
    }

    public TodoCategoryAdapter(List<TodoCategory> todoCategories) {
        this.todoCategories = new ArrayList<>(todoCategories);
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo_category, parent, false);

        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoCategoryAdapter.CategoryViewHolder holder, int position) {
        holder.render(todoCategories.get(position));
    }

    @Override
    public int getItemCount() {
        return todoCategories.size();
    }
}
