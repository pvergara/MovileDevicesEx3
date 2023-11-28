package org.ecos.logic.moviledevicesex3;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacterAdapter;
import org.ecos.logic.moviledevicesex3.databinding.ActivityMainBinding;
import org.json.JSONArray;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;

public class MainActivity extends AppCompatActivity {

    private final ActivityResultContracts.StartActivityForResult contract = new ActivityResultContracts.StartActivityForResult();
    private ActivityMainBinding binding;
    private final SimpsonCharacterAdapter simpsonCharacterAdapter = new SimpsonCharacterAdapter(this);
    private ActivityResultCallback<ActivityResult> activityResult = o -> {
        if (o.getResultCode() == RESULT_OK) {
            Intent intent = o.getData();
            Toast.makeText(this, intent.getStringExtra("lerele"), Toast.LENGTH_LONG).show();
        }
    };
    private ActivityResultLauncher<Intent> launcher;
    private Map<Integer, Supplier<Boolean>> rubenMustLearnToUseHashes = new HashMap<>();
    private Supplier<Boolean> booleanSupplier = () -> {
        Intent intent = new Intent(this, MainActivity3.class);
        launcher.launch(intent);
        this.startActivity(intent);
        return true;
    };
    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        this.launcher = this.registerForActivityResult(this.contract, this.activityResult);
        simpsonCharacterAdapter.setLauncher(launcher);
        RecyclerView recyclerView = binding.recyclerViewId;
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        recyclerView.setAdapter(this.simpsonCharacterAdapter);

        Toast toast = Toast.makeText(this, "Submenú 1", Toast.LENGTH_SHORT);

        this.rubenMustLearnToUseHashes.put(R.id.meditar, this.booleanSupplier);
        this.rubenMustLearnToUseHashes.put(R.id.mborrar, () -> {
            Toast.makeText(this, "Borrar", Toast.LENGTH_SHORT).show();
            return true;
        });
        this.rubenMustLearnToUseHashes.put(R.id.motro, this.otro);

        this.rubenMustLearnToUseHashes.put(R.id.msubmenu, () -> {
            toast.setText("Submenú 1");
            toast.show();
            return true;
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_principal, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return this.rubenMustLearnToUseHashes.get(item.getItemId()).get();
    }

    private final Supplier<Boolean> otro = () -> {
        Toast.makeText(this, "Otro", Toast.LENGTH_SHORT).show();
        return true;
    };

}