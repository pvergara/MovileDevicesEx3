package org.ecos.logic.moviledevicesex3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacter;

public class MainActivity2 extends AppCompatActivity {

    private TextView characterNameLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Intent intent= this.getIntent();

        this.characterNameLabel = this.findViewById(R.id.characterName);

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            SimpsonCharacter simpsonCharacter = intent.getSerializableExtra("simpsonCharacter",SimpsonCharacter.class);
            this.characterNameLabel.setText(simpsonCharacter.getFullName());
        }
    }
}