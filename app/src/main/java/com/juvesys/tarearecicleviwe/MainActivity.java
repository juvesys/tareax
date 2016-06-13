package com.juvesys.tarearecicleviwe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<contacto> contactos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactos = new ArrayList<contacto>();
        contactos.add(new contacto("Juvenal Perez","7821386596","juvesys@gmail.com"));
        contactos.add(new contacto("Octavio Perez","7821386595","octavio@gmail.com"));
        contactos.add(new contacto("Luis Perez","7821386593","luis@gmail.com"));
        contactos.add(new contacto("Dante Perez", "7821386592", "dante@gmail.com"));
        contactos.add(new contacto("Alonso Perez", "7821386592", "alonso@gmail.com"));

        ArrayList<String> nombresContacto = new ArrayList<>();
        for (contacto contacto:contactos) {
            nombresContacto.add(contacto.getNombre());
        }

        ListView lstcontactos = (ListView)findViewById(R.id.lstcontactos);
        lstcontactos.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_expandable_list_item_1, nombresContacto));

        lstcontactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, detallecontacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pmail),contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });
    }
}
