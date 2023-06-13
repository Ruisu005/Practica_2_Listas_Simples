package com.example.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listViewPlanets;
    private ArrayAdapter<String> planetsAdapter;
    private TextView textViewPlanetInfo;

    private String[] planetNames = {"Mercurio", "Venus", "Tierra", "Marte", "Jupiter", "Saturno", "Urano", "Neptuno"};

    private String[] planetInfo = {
            "Mercurio es el planeta más cercano al Sol y el más pequeño del sistema solar.",
            "Venus es el segundo planeta más cercano al Sol y el más similar a la Tierra en términos de tamaño y composición.",
            "La Tierra es nuestro hogar y el único planeta conocido que alberga vida.",
            "Marte es el cuarto planeta desde el Sol y es conocido como el 'Planeta Rojo' debido a su apariencia rojiza.",
            "Júpiter es el planeta más grande del sistema solar y tiene una gran cantidad de lunas y una característica distintiva: la Gran Mancha Roja.",
            "Saturno es conocido por sus impresionantes anillos y tiene un tamaño casi nueve veces mayor que el de la Tierra.",
            "Urano es un gigante gaseoso con un color azul verdoso y tiene la particularidad de tener su eje de rotación inclinado.",
            "Neptuno es el último planeta en nuestro sistema solar y se caracteriza por su intenso color azul y fuertes vientos."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewPlanets = findViewById(R.id.listViewPlanets);
        textViewPlanetInfo = findViewById(R.id.textViewPlanetInfo);

        planetsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, planetNames);
        listViewPlanets.setAdapter(planetsAdapter);

        listViewPlanets.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedPlanet = planetNames[position];
                String selectedPlanetInfo = planetInfo[position];

                textViewPlanetInfo.setText(selectedPlanetInfo);

                Toast.makeText(MainActivity.this, "Planeta seleccionado: " + selectedPlanet, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
