package com.kikesf.androidadventures.todoApp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.kikesf.androidadventures.R;
import com.kikesf.androidadventures.todoApp.adapters.TodoAdapter;
import com.kikesf.androidadventures.todoApp.adapters.TodoCategoryAdapter;
import com.kikesf.androidadventures.todoApp.models.Todo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TodoActivity extends AppCompatActivity {
    private List<TodoCategory> categories = new ArrayList<>(Arrays.asList(
            TodoCategory.PERSONAL,
            TodoCategory.BUSINESS,
            TodoCategory.OTHER
    ));
    private List<Todo> todos = new ArrayList<>(Arrays.asList(new Todo("leer 10min", false, TodoCategory.BUSINESS)));
    private FloatingActionButton floatingActionButton;
    private RecyclerView rvTodoCategories, rvTodos;
    private TodoCategoryAdapter todoCategoryAdapter;
    private TodoAdapter todoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        initComponents();
        initUI();
        initListeners();
    }

    public void initComponents() {
        rvTodoCategories = findViewById(R.id.rv_todo_categories);
        rvTodos = findViewById(R.id.rv_todos);
        floatingActionButton = findViewById(R.id.fab_create_todo);
    }

    public void initUI() {
        todoCategoryAdapter = new TodoCategoryAdapter(categories);
        todoAdapter = new TodoAdapter(todos);

        rvTodoCategories.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvTodoCategories.setAdapter(todoCategoryAdapter);

        rvTodos.setLayoutManager(new LinearLayoutManager(this)); // layour vertical
        rvTodos.setAdapter(todoAdapter);
    }

    private void initListeners() {
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        Dialog dialog = new Dialog(this); // CREAMOS EL DIALOG
        dialog.setContentView(R.layout.activity_dialog); // ENGANCHAMOS EL LAYOUT DEL DIALOG

        // RECUPERAMOS LAS REFERENCIAS DE LOS COMPONENTES QUE TIENE EL DIALOG
        // SE PONE dialog.findViewById(R.id.et_todo_title) PORQUE ESE ELEMENTO ESTA DENTRO DEL LAYOUT DEL DIALOG
        // SI SE PONE findViewById(R.id.et_todo_title) NO LO ENCONTRARIA PORQUE ESTARIA BUSCADO EN EL LAYOUT DE TODO
        EditText todoTitle = dialog.findViewById(R.id.et_todo_title);
        Button btnAddTodo = dialog.findViewById(R.id.btn_add_todo);
        RadioGroup radioGroupCategories = dialog.findViewById(R.id.rg_categories);


        btnAddTodo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO implement method add todo
                int radioButtonId = radioGroupCategories.getCheckedRadioButtonId();
                RadioButton selectedRadioButton = radioGroupCategories.findViewById(radioButtonId);
                TodoCategory currentCategory;

                if (selectedRadioButton.getText().toString().equalsIgnoreCase(getString(R.string.personal_category))) { // RECUPERAMOS LA CATEOGRIA
                    currentCategory = TodoCategory.PERSONAL;
                } else if (selectedRadioButton.getText().equals(getString(R.string.business_category))) {
                    currentCategory = TodoCategory.BUSINESS;
                } else {
                    currentCategory = TodoCategory.OTHER;
                }

                String title = todoTitle.getText().toString();
                Todo newTodo = new Todo(title, false, currentCategory); // CREAMOS EL TODO
                todos.add(newTodo);
                for(Todo todo:todos) {
                    Log.i("todo", todo.getTitle());
                }
                updatedTodos();
                dialog.hide(); // OCULTAMOS EL DIALOG
            }
        });

        dialog.show(); // MOSTRAMOS EL DIALOG
    }

    private void updatedTodos() {
        // NOTE: NO ES UNA FORMA OPTIMA DE NOTIFICAR AL ADAPTADOR LA ACTUALIZACION DE LOS DATOS
        // YA QUE VERIFICA TODOS LOS ITEMS SI HAN CAMBIADO
        todoAdapter.notifyDataSetChanged(); // NOTIFICA AL ADAPTOR QUE HAY CAMBIO EN LOS DATOS
    }
}