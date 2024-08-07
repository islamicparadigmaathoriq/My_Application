package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.activity.ComponentActivity;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import android.util.Log;

import com.example.myapplication.R;

public class MainActivity extends ComponentActivity {
    private static final String TAG = "MainActivity";
    private EditText editTextTask;
    private Button buttonAdd;
    private ListView listViewTasks;

    private ArrayList<String> tasks;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            editTextTask = findViewById(R.id.editTextTask);
            buttonAdd = findViewById(R.id.buttonAdd);
            listViewTasks = findViewById(R.id.listViewTasks);
            Log.d(TAG, "Views initialized successfully");

            tasks = new ArrayList<>();
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, tasks);
            listViewTasks.setAdapter(adapter);
            Log.d(TAG, "Adapter set successfully");

            buttonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String task = editTextTask.getText().toString();
                    if (!task.isEmpty()) {
                        tasks.add(task);
                        adapter.notifyDataSetChanged();
                        editTextTask.setText("");
                    }
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "Error in onCreate: ", e);
        }
    }
}