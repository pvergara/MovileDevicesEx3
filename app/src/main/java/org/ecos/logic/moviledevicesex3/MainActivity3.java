package org.ecos.logic.moviledevicesex3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

import org.ecos.logic.moviledevicesex3.data.SimpsonCharacter;
import org.ecos.logic.moviledevicesex3.databinding.ActivityMain3Binding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity3 extends ListActivity {

    private List<SimpsonCharacter> lista = new ArrayList<>();
    private ArrayAdapter<SimpsonCharacter> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.lista.add(new SimpsonCharacter(1, "Homer ", "Homer Jay Simpson", 39, false, "estadounidense", "Homer Jay Simpson (Homero J. Simpson en Hispanoamérica y Homer J. Simpson en España) es un personaje ficticio protagonista de la serie de televisión de dibujos animados Los Simpson. Es el padre de la familia protagonista y uno de los personajes centrales y más importantes de la serie. Fue creado por el dibujante Matt Groening e hizo su debut en televisión el 19 de abril de 1987,  en el corto Good Night del programa El show de Tracey Ullman. Su segundo nombre es un juego de palabras; durante muchas temporadas no se supo qué había detrás de la J hasta que en el capítulo «D'oh-in' In the Wind» descubre que su segundo nombre es Jay (nombre en inglés de la letra j); de este modo,  cuando Homer pronuncia en inglés su propio nombre,  no se distingue si da la letra inicial del segundo nombre o este al completo.", R.drawable.homer_simpson));

        this.adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_checked, lista);


        this.getListView().setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        setListAdapter(adapter);
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Toast.makeText(getApplicationContext(), ((CheckedTextView)v).isChecked()+"",Toast.LENGTH_SHORT).show();

    }
}