package com.example.anthony.epe1calculoip;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

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

public class ResultadoActivity extends AppCompatActivity implements View.OnClickListener{
    TextView result;
    EditText txtFinal;
    TextView btnFinal;
    LinearLayout conFinal;
    String mensaje;
    double promedio;
    ArrayList<String[]> minimo;
    double preMin[];
    CalculoValidacion cal = new CalculoValidacion();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        conFinal = (LinearLayout) findViewById(R.id.conFinal);
        conFinal.setVisibility(View.INVISIBLE);
        txtFinal = (EditText) findViewById(R.id.txtFinal);
        btnFinal = (TextView) findViewById(R.id.btnFinal);
        btnFinal.setOnClickListener(this);
        result =(TextView) findViewById(R.id.txtReslt);
        Bundle b=getIntent().getExtras();
        double datos[]=b.getDoubleArray("notas");
        promedio=cal.calPromedio(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        minimo = cal.validaNota(datos[0],datos[1],datos[2],datos[3],datos[4],datos[5],datos[6],datos[7]);
        mensaje="NOTA PROMEDIO: " + promedio;
        if(promedio >= 5.5 && minimo.size()==0){
            mensaje += "\nEstado ramo: EXIMIDO";
        }else{
            mensaje += "\nEstado ramo: A EXAMEN\n-------";
            preMin=cal.preApr(promedio);
            mensaje += "\nNOTA PRESENTACION: " + preMin[0];
            mensaje += "\nNOTA MINIMA DE APROBACION: " + preMin[1];
            conFinal.setVisibility(View.VISIBLE);
        }
        result.setText(mensaje);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == findViewById(R.id.btnFinal).getId()){
            String nota = txtFinal.getText().toString();
            if(nota.equals("")){
                Toast.makeText(this, "INGRESA NOTA DE EXAMEN FINAL", Toast.LENGTH_SHORT).show();
            }else{
                double nF = Double.parseDouble(nota);
                mensaje += "\n-------";
                mensaje += "\nNOTA FINAL: " + cal.notaFinal(preMin[0] , nF);
                result.setText(mensaje);
            }
        }
    }
}
