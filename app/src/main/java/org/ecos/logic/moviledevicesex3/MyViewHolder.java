package org.ecos.logic.moviledevicesex3;


import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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
        Toast.makeText(view.getContext(), "Hola " + simpsonCharacter.getName(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(containerActivity, MainActivity2.class);
        intent.putExtra("simpsonCharacter",this.simpsonCharacter);
        containerActivity.startActivity(intent);
    };

    public void setContainerActivity(AppCompatActivity containerActivity) {

        this.containerActivity = containerActivity;
    }
}