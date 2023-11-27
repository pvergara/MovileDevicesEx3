package org.ecos.logic.moviledevicesex3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacter;

public class MainActivity2 extends AppCompatActivity {

    private TextView characterNameLabel;
    private AppCompatImageView image;
    private SimpsonCharacter character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
        Intent intent = this.getIntent();

        this.characterNameLabel = this.findViewById(R.id.characterName);
        this.image = this.findViewById(R.id.main2_image);

        int characterId = intent.getIntExtra("simpsonCharacter.characterId", 0);
        String name = intent.getStringExtra("simpsonCharacter.name");
        String fullName = intent.getStringExtra("simpsonCharacter.fullName");
        int age = intent.getIntExtra("simpsonCharacter.age", 0);
        int imageResourceId = intent.getIntExtra("simpsonCharacter.resourceId", 0);
        boolean isFemale = intent.getBooleanExtra("simpsonCharacter.isFemale", true);
        this.character = new SimpsonCharacter(characterId, name, fullName, age, isFemale, "", "", imageResourceId);

        this.characterNameLabel.setText(character.getFullName());
        this.image.setImageResource(character.getImageResourceId());
    }

    public void imageClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("lerele",this.character.getName());
        this.setResult(RESULT_OK,intent);
        finish();
    }
}