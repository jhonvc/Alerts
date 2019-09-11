package com.example.tecsup.alerts;

import android.content.ClipData;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Producto> datos;
    EditText nombre;
    EditText precio;
    EditText imagen;
    Button agregar;
    Button eliminar;


    ProductoAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listview);
        nombre=findViewById(R.id.nombre);
        precio=findViewById(R.id.precio);
        imagen=findViewById(R.id.imagen);
        agregar=findViewById(R.id.button_agregar);
        eliminar=findViewById(R.id.btn_eliminar);
        datos= new ArrayList<>();
        for (int i=0;i<100000; i++){
            datos.add(new Producto("Numero:"+i,(double)i,"https://i.blogs.es/453885/portada/450_1000.jpg"));
        }
        final ProductoAdapter adapter = new ProductoAdapter(this,R.layout.item_producto,datos);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                Toast.makeText(MainActivity.this,""+ posicion,Toast.LENGTH_SHORT).show();
                MostrarMenu(view);
            }
        });
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.add(new Producto(nombre.getText().toString(),Double.parseDouble(precio.getText().toString()),imagen.getText().toString()));
                adapter.notifyDataSetChanged();
            }

        });
                eliminar.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {
                        EliminarPrimero();
                    }
                });
        }
        void EliminarPrimero(){
        datos.remove(0);
        adapter.notifyDataSetChanged();
        }
       void MostrarMenu(View v, final int i){
           final PopupMenu menu=new PopupMenu(this,v);
           menu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
               @Override
               public boolean onMenuItemClick(MenuItem item) {
                   switch (item.getItemId()){
                       case R.id.menu_editar:
                           break;
                       case R.id.menu_eliminar:
                           datos.remove(i);
                           adapter.notifyDataSetChanged();
                           break;
                   }
                   return true;
               }
           });
           menu.inflate(R.menu.menu_producto);
           menu.show();
       }
       void CargarValoresEditar(int i){
        nombre.setText(datos.get(i).getNombre());
        precio.setText(datos.get(i).getPrecio().toString());
        imagen.setText(datos.get(i).getImagen());
        agregar.setText("Actualizar");

       }

}