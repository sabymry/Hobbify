package com.example.myapp.Activity;

import android.app.Activity;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.myapp.Adapter.PopularAdapter;
import com.example.myapp.R;
import com.example.myapp.domain.PopularDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        initRecyclerView();

    }

    private void initRecyclerView() {
        ArrayList<PopularDomain> items = new ArrayList<>();
        items.add(new PopularDomain("Wine and Paint", "item_1", 15, 4, 200, "Vino cu prietenii si incearca\n" +
                "cele mai bune vinuri\n" +
                "in timp ce pictezi"));
        items.add(new PopularDomain("HM Disney Party", "item_2", 40, 4, 60, "Cea mai buna petrecere\n" +
                "Disney la care poti\n" +
                "merge! Nu rata!!"));
        items.add(new PopularDomain("Journalism", "item_3", 5, 3, 10, "Ai vrea sa devi\n" +
                "un adevarat redactor?\n" +
                "Vino la cursurile de jurnalism!"));

          binding.PopularView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
          binding.PopularView.setAdapter(new PopularAdapter(items));
    }
}