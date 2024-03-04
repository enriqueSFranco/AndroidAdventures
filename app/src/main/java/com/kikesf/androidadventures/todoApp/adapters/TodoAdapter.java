package com.kikesf.androidadventures.todoApp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kikesf.androidadventures.R;
import com.kikesf.androidadventures.todoApp.TodoCategory;
import com.kikesf.androidadventures.todoApp.models.Todo;

import java.util.ArrayList;
import java.util.List;

// ADAPTER TODO
public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHoler> {
    private List<Todo> todos;

    // VIEW HOLDER TODO
    public static class TodoViewHoler extends RecyclerView.ViewHolder {
        private final CheckBox cbTodo;
        private final TextView tvTodo;
        private final CardView cvTodo;
        public TodoViewHoler(@NonNull View itemView) {
            super(itemView);

            cbTodo = (CheckBox) itemView.findViewById(R.id.cb_todo);
            tvTodo = (TextView) itemView.findViewById(R.id.tv_todo_text);
            cvTodo = (CardView) itemView.findViewById(R.id.cv_todo);
        }

        private int getColor(@ColorRes int colorResource) {
            return ContextCompat.getColor(cvTodo.getContext(), colorResource);
        }

        public void render(Todo todo) {
            String category = todo.getCategory().toString();
            tvTodo.setText(todo.getTitle());

            int cardBackgroundColor;
            if (category.equals(TodoCategory.PERSONAL.toString())) {
                cardBackgroundColor = getColor(R.color.blue_700);
            } else if (category.equals(TodoCategory.BUSINESS.toString())) {
                cardBackgroundColor = getColor(R.color.orange_200);
            } else {
                cardBackgroundColor = getColor(R.color.gray_700);
            }
            cvTodo.setCardBackgroundColor(cardBackgroundColor);
        }
    }

    public TodoAdapter(List<Todo> todos) {
        this.todos = new ArrayList<>(todos);
    }

    @NonNull
    @Override
    public TodoViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_todo, parent, false);
        return new TodoViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TodoAdapter.TodoViewHoler holder, int position) {
        holder.render(todos.get(position));
    }

    @Override
    public int getItemCount() {
        return todos.size();
    }
}
