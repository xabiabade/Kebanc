package com.xabi.kebanc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public EditText nombre, direccion, telefono, apellido;
    private Button siguiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText)findViewById(R.id.txtNombreMain);
        apellido=(EditText)findViewById(R.id.txtApellidosMain);
        direccion=(EditText)findViewById(R.id.txtDireccionMain);
        telefono=(EditText)findViewById(R.id.txtTelefonoMain);
        siguiente=(Button)findViewById(R.id.cmdSiguienteMain);

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().equals("")) {
                    nombre.setError("Por favor, introduce tu nombre");
                } else if(apellido.getText().toString().equals("")) {
                    telefono.setError("Por favor, introduce tus apellidos");

                } else if (direccion.getText().toString().equals("")) {
                    direccion.setError("Por favor, introduce una dirección de envío");
                } else if(telefono.getText().toString().equals("")) {
                    telefono.setError("Por favor, introduce un teléfono de contacto");
                }else{
                        LanzarActividad(null);
                    }
                }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1235 && resultCode == RESULT_OK) {

        }
    }
    public void LanzarActividad(View V){
        Intent intent = new Intent(this, Comidas.class);
        intent.putExtra("NOMBRE", nombre.getText().toString());
        intent.putExtra("DIRECCION", direccion.getText().toString());
        intent.putExtra("TELEFONO", telefono.getText().toString());
        intent.putExtra("APELLIDO", apellido.getText().toString());
        startActivityForResult(intent, 1235);
    }


    public void Salir(View v){
        finish();
    }

}
