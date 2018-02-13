package com.example.u3_ejercicio_de_dialogos;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    EditText etNombre;
    Spinner spYear;
    ListView lvEstudios;
    TextView tvEstudios;
    CheckBox cbTerminos;
    Button btnComprobar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre = (EditText)findViewById(R.id.etNombre);
        spYear = (Spinner) findViewById(R.id.spYear);
        lvEstudios = (ListView) findViewById(R.id.lvEstudios);
        tvEstudios = (TextView) findViewById(R.id.tvEstudios);
        cbTerminos = (CheckBox) findViewById(R.id.cbTerminos);
        btnComprobar = (Button) findViewById(R.id.btnComprobar);

        //Datos a mostrar en el ListView
        String [] estudios = {"ESO", "Grado Medio", "Grado Superior", "Licenciatura"};

        //Crear el Adaptador
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,estudios);

        //Añadir el adaptador al ListView
        lvEstudios.setAdapter(adaptador);

        //Añadir el mensaje en un evento click
        lvEstudios.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String estudios_selecionados = parent.getItemAtPosition(position).toString();
                tvEstudios.setText(estudios_selecionados);

            }
        });

        //Contenido Spinner

        ArrayList<String> years = new ArrayList<String>();
        years.add("");
        int thisYear = Calendar.getInstance().get(Calendar.YEAR);
        for (int i = 1980; i <= thisYear; i++) { years.add(Integer.toString(i)); }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, years);
        spYear.setAdapter(adapter);

    }//FIN onCreate

    public void clickComprobar (View view){

        if (cbTerminos.isChecked()){

            String nombre = etNombre.getText().toString();
            String year = spYear.getSelectedItem().toString();
            String estudios = tvEstudios.getText().toString();

            if (nombre.equals("") || year.equals("") || estudios.equals("")){

                //Dialogo debes rellenar todos los campos
                FragmentManager fragmentManager = getFragmentManager();
                DialogoDatos datos = new DialogoDatos();
                datos.show(fragmentManager, "Aceptación Términos");

            }else{

                int years = Integer.parseInt(year);
                Calendar today = Calendar.getInstance();


               


            }







        }else{

            //Dialogo debes aceptar los terminos
            FragmentManager fragmentManager = getFragmentManager();
            DialogoTerminos terminos = new DialogoTerminos();
            terminos.show(fragmentManager, "Error Aceptación Términos");



        }


    }




}//FIN MainActivity