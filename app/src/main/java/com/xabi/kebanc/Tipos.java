package com.xabi.kebanc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Tipos extends AppCompatActivity {
   private Spinner sp1,sp2,sp3,sp4;
    private EditText et1;
    private double total,Doner=3.5,Durum=4,Lahmacum=7.5,Shawarma=8,Gyros=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipos);

        sp1=(Spinner)findViewById(R.id.spinner1);
        sp2=(Spinner)findViewById(R.id.spinner2);
        sp3=(Spinner)findViewById(R.id.spinner3);
        et1=(EditText)findViewById(R.id.total);
        sp4=(Spinner)findViewById(R.id.spinner);

        sp2.setEnabled(false);
        sp3.setEnabled(false);



       final  String []tamaño={"Selecciona","Normal","Completo + 0,5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tamaño);
        sp3.setAdapter(adapter);

        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (tamaño[position].equals("Normal")) {



                } else if (tamaño[position].equals("Completo")) {

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        final String []carne={"Selecciona","Cordero + 0,25","Ternera","Pollo + 0,5"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, carne);
        sp2.setAdapter(adapter2);

        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                if (carne[position].equals("Cordero + 0,25")) {
                    sp3.setEnabled(true);
                    total=total+0.25;
                    et1.setText(String.valueOf(+total));

                } else if (carne[position].equals("Ternera")) {
                    sp3.setEnabled(true);

                } else if (carne[position].equals("Pollo + 0,5")) {
                    sp3.setEnabled(true);
                    total=total+0.5;
                    et1.setText(String.valueOf(+total));

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                sp3.setEnabled(false);
            }
        });

           final  String []durum={"Selecciona","Döner","Dürüm","Lahmacum","Shawarma","Gyros"};
            ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, durum);
            sp1.setAdapter(adapter3);

            sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    if (durum[position].equals("Döner")) {
                        et1.setText(String.valueOf(+Doner));
                        Cantidad(Doner);
                    } else if (durum[position].equals("Dürüm")) {
                        Cantidad(Durum);
                        et1.setText(String.valueOf(+Durum));
                    } else if (durum[position].equals("Lahmacum")) {
                        Cantidad(Lahmacum);
                        et1.setText(String.valueOf(+Lahmacum));
                    } else if (durum[position].equals("Shawarma")) {
                        Cantidad(Shawarma);
                        et1.setText(String.valueOf(+Shawarma));
                    } else if (durum[position].equals("Gyros")) {
                        Cantidad(Gyros);
                        et1.setText(String.valueOf(+Gyros));
                    }
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {
                }

            });


    }


    //METODO PARA sumar LA CANTIDAD

    public double Cantidad(final Double x){
        final String []cantidad={"0","1","2","3","4","5"};
        ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, cantidad);
        sp4.setAdapter(adapter4);
        sp4.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                if (cantidad[position].equals("0")) {

                    et1.setText(String.valueOf(+total));
                    sp2.setEnabled(false);
                    TextView errorText = (TextView)sp2.getSelectedView();

                            errorText.setText("Introduce una cantidad");

                } else if (cantidad[position].equals("1")) {
                    total = x * 1;
                    et1.setText(String.valueOf(+total));
                    sp2.setEnabled(true);
                }else if (cantidad[position].equals("2")) {
                    total=x*2;
                    et1.setText(String.valueOf(+total));
                    sp2.setEnabled(true);

                } else if (cantidad[position].equals("3")) {
                    total=x*3;
                    et1.setText(String.valueOf(+total));
                    sp2.setEnabled(true);

                }else if (cantidad[position].equals("4")) {
                    total=x*4;
                    et1.setText(String.valueOf(+total));
                    sp2.setEnabled(true);

                }else if (cantidad[position].equals("5")) {
                    total=x*5;
                    et1.setText(String.valueOf(+total));
                    sp2.setEnabled(true);

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });

        return total;
    }



    public void Atras(View v){
        finish();
}
}
