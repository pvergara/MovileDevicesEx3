package org.ecos.logic.moviledevicesex3;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacter;

public class MyViewHolder extends RecyclerView.ViewHolder {
    private final View element;
    private TextView name;
    private TextView year;
    ImageView logo;
    private SimpsonCharacter simpsonCharacter;
    private AppCompatActivity containerActivity;
    private ActivityResultLauncher<Intent> launcher;

    public MyViewHolder(View element) {
        super(element);
        this.element = element;
        this.name = element.findViewById(R.id.textViewNombre);
        this.year = element.findViewById(R.id.textViewYear);
        this.logo = element.findViewById(R.id.imageView);

        element.setOnClickListener(this.onElementClick);
    }

    public TextView getName() {
        return name;
    }

    public TextView getYear() {
        return year;
    }

    public ImageView getLogo() {
        return logo;
    }

    public void setSimpsonCharacter(SimpsonCharacter simpsonCharacter) {
        this.simpsonCharacter = simpsonCharacter;
    }

    private final View.OnClickListener onElementClick = view -> {
        Intent intent = new Intent(containerActivity, MainActivity2.class);
        intent.putExtra("simpsonCharacter.characterId",this.simpsonCharacter.getCharacterId());
        intent.putExtra("simpsonCharacter.name",this.simpsonCharacter.getName());
        intent.putExtra("simpsonCharacter.fullName",this.simpsonCharacter.getFullName());
        intent.putExtra("simpsonCharacter.age",this.simpsonCharacter.getAge());
        intent.putExtra("simpsonCharacter.isFemale",this.simpsonCharacter.isFemale());
        intent.putExtra("simpsonCharacter.description",this.simpsonCharacter.getDescription());
        intent.putExtra("simpsonCharacter.resourceId",this.simpsonCharacter.getImageResourceId());

        launcher.launch(intent);
//        containerActivity.startActivity(intent);
    };

    public void setContainerActivity(AppCompatActivity containerActivity) {

        this.containerActivity = containerActivity;
    }

    public void setLauncher(ActivityResultLauncher<Intent> launcher) {

        this.launcher = launcher;
    }
}