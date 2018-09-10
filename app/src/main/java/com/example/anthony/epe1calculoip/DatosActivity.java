package com.example.anthony.epe1calculoip;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

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

public class DatosActivity extends AppCompatActivity implements View.OnClickListener {
    TextView btnIng;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);
        btnIng = (TextView) findViewById(R.id.btnIngresar);
        btnIng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==findViewById(R.id.btnIngresar).getId()){
            Intent in =new Intent();
            in.setClass(getApplicationContext(),MainActivity.class);
            startActivity(in);
        }
    }
}
