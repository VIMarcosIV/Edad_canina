package org.iesch.mi_edad_canina;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.iesch.mi_edad_canina.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // setContentView(R.layout.activity_main);

        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        // findViewById es para enlazar los elementos del XML con los del .java
       // EditText ageEdit = findViewById(R.id.Edad_EditText); // R porque es un registro de android donde se guardan todas las variables
       // Button btnCalculate = findViewById(R.id.Calcular_Btn);
       // TextView txtViewResult = findViewById(R.id.Respuesta_TextView);

        // Para avusos en la pestaña de logcat
        /*
        Log.d("DAM", "MainActivity cargada con éxito");
        Log.e("DAM", "MainActivity cargada con éxito");
        Log.w("DAM", "MainActivity cargada con éxito");
        Log.i("DAM", "MainActivity cargada con éxito");
        Log.v("DAM", "MainActivity cargada con éxito");
         */

        binding.CalcularBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Al hacer click queremos capturar el texto introducido

                String age = binding.EdadEditText.getText().toString();
                if (!age.isEmpty()) {
                    int ageInteger = Integer.parseInt(age);
                    int result = ageInteger * 7;
                    //String textResult = "If you were a dog your age would be " + result + " years old";
                    String textResult = getString(R.string.result_format, result);

                    //  txtViewResult.setText(textResult);
    binding.RespuestaTextView.setText(textResult);
                } else {
                    Log.d("MainActivity", "El campo edad esta vacío");
                    //Toast.makeText(MainActivity.this, "Age field is empty", Toast.LENGTH_SHORT).show();
                    Toast.makeText(MainActivity.this, getString(R.string.you_have_to_insert_an_age), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}