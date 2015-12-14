package com.xabi.kebanc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nombre,direccion,telefono;
    private Button sigiente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombre=(EditText)findViewById(R.id.editnombre);
        direccion=(EditText)findViewById(R.id.editdirecion);
        telefono=(EditText)findViewById(R.id.edittelefono);
        sigiente=(Button)findViewById(R.id.sigiente);

        sigiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (nombre.getText().toString().equals("")) {
                    nombre.setError("Intoduce un Nombre");

                } else if (direccion.getText().toString().equals("")) {
                    direccion.setError("Intoduce una direccion");
                } else if(telefono.getText().toString().equals("")) {
                    telefono.setError("Intoduce un telefono");
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
        Intent intent = new Intent(this, Tipos.class);
        intent.putExtra("NOMBRE", nombre.getText().toString());
        intent.putExtra("DIRECCION", direccion.getText().toString());
        intent.putExtra("TELEFONO", telefono.getText().toString());
        startActivityForResult(intent, 1235);
    }


    public void Salir(View v){
        finish();
    }

}
