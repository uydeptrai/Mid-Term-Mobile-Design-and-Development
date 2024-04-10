package com.example.hoanggiauy;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        // Nhận danh sách câu trả lời từ Intent
        ArrayList<String> answersList = getIntent().getStringArrayListExtra("answersList");

        // Tìm ListView trong layout
        ListView listViewAnswers = findViewById(R.id.listViewAnswers);

        // Tạo adapter và thiết lập cho ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, answersList);
        listViewAnswers.setAdapter(adapter);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Quay lại trang trước đó
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
