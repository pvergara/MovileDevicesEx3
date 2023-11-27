package org.ecos.logic.moviledevicesex3;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacterAdapter;
import org.ecos.logic.moviledevicesex3.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final ActivityResultContracts.StartActivityForResult contract = new ActivityResultContracts.StartActivityForResult();
    private ActivityMainBinding binding;
    private final SimpsonCharacterAdapter simpsonCharacterAdapter = new SimpsonCharacterAdapter(this);
    private ActivityResultCallback<ActivityResult> activityResult = o -> {
        if (o.getResultCode()==RESULT_OK){
            Intent intent = o.getData();
            Toast.makeText(this,intent.getStringExtra("lerele"),Toast.LENGTH_LONG).show();
        }
    };
    private ActivityResultLauncher<Intent> launcher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.launcher = this.registerForActivityResult(this.contract,this.activityResult);
        simpsonCharacterAdapter.setLauncher(launcher);
        RecyclerView recyclerView = binding.recyclerViewId;
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(this.simpsonCharacterAdapter);

    }


}