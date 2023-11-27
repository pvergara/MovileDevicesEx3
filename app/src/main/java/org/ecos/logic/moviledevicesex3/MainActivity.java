package org.ecos.logic.moviledevicesex3;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacterAdapter;
import org.ecos.logic.moviledevicesex3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private final SimpsonCharacterAdapter simpsonCharacterAdapter = new SimpsonCharacterAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        RecyclerView recyclerView = binding.recyclerViewId;
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(this.simpsonCharacterAdapter);

    }


}