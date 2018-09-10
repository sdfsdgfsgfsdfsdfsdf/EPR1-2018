package com.example.anthony.epe1calculoip;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/*
 * ipchile
 *
 * Copyright (C) 2018 Diego
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/gpl-3.0.html>.
 *
 */


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //VARIABLES SOLEMNES
    EditText txtEpr1;
    EditText txtEpe1;
    EditText txtEpr2;
    EditText txtEpe2;

    EditText txtEva1;
    EditText txtEva2;
    EditText txtEva3;
    EditText txtEva4;

    TextView btnAceptar;
    CalculoValidacion cal = new CalculoValidacion();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEpr1=(EditText) findViewById(R.id.txtEpr1);
        txtEpe1=(EditText) findViewById(R.id.txtEpe1);
        txtEpr2=(EditText) findViewById(R.id.txtEpr2);
        txtEpe2=(EditText) findViewById(R.id.txtEpe2);
        txtEva1=(EditText) findViewById(R.id.txtEva1);
        txtEva2=(EditText) findViewById(R.id.txtEva2);
        txtEva3=(EditText) findViewById(R.id.txtEva3);
        txtEva4=(EditText) findViewById(R.id.txtEva4);

        btnAceptar=(TextView) findViewById(R.id.btnAceptar);
        btnAceptar.setOnClickListener(this);
        preparando();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==findViewById(R.id.btnAceptar).getId()){
            String epr1=txtEpr1.getText().toString();
            String epe1=txtEpe1.getText().toString();
            String epr2=txtEpr2.getText().toString();
            String epe2=txtEpe2.getText().toString();
            String eva1=txtEva1.getText().toString();
            String eva2=txtEva2.getText().toString();
            String eva3=txtEva3.getText().toString();
            String eva4=txtEva4.getText().toString();

            if( cal.validarVacio(epr1,epe1,epr2,epe2,eva1,eva2,eva3,eva4) ){
                double nota[]={Double.parseDouble(epr1),Double.parseDouble(epe1),Double.parseDouble(epr2),Double.parseDouble(epe2),Double.parseDouble(eva1),Double.parseDouble(eva2),Double.parseDouble(eva3),Double.parseDouble(eva4)};
                Bundle b = new Bundle();
                b.putDoubleArray("notas", nota);
                Intent in =new Intent();
                in.setClass(getApplicationContext(),ResultadoActivity.class);
                in.putExtras(b);
                startActivity(in);
            }else{
                Toast.makeText(this, "COMPLETA TODOS LOS CAMPOS", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void preparando(){
        txtEpr1.setText("");
        txtEpr2.setText("");
        txtEpe1.setText("");
        txtEpe2.setText("");
        txtEva1.setText("");
        txtEva2.setText("");
        txtEva3.setText("");
        txtEva4.setText("");
    }
}
