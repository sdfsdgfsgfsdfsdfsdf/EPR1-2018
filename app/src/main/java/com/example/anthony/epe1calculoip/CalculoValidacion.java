package com.example.anthony.epe1calculoip;

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
public class CalculoValidacion {
    public boolean  validarVacio(String txtEpr1,String txtEpr2,String txtEpe1,String txtEpe2,
                                 String txtEva1,String txtEva2,String txtEva3,String txtEva4) {
        if (txtEpr1.equals("") || txtEpr2.equals("") ||  txtEpe1.equals("")|| txtEpe2.equals("") || txtEva1.equals("") || txtEva2.equals("") || txtEva3.equals("") || txtEva4.equals("") ||
                txtEpr1 == null || txtEpr2 == null ||  txtEpe1 == null || txtEpe2 == null || txtEva1 == null || txtEva2 == null || txtEva3 == null || txtEva4 == null) {
            return false;
        } else {
            return true;
        }
    }
    public ArrayList<String[]>  validaNota(double txtEpr1, double txtEpe1, double txtEpr2, double txtEpe2,
                                           double txtEva1,double txtEva2,double txtEva3,double txtEva4) {
        ArrayList<String[]> datos = new ArrayList<String[]>();
        String info[]=new String[2];
        if (txtEpr1 < 4.0) {
            info[0] = "EPR1";
            info[1] = "" + txtEpr1;
            datos.add(info);
        }
        if (txtEpe1 < 4.0) {
            info[0] = "EPE1";
            info[1] = "" + txtEpe1;
            datos.add(info);
        }
        if (txtEpr2 < 4.0) {
            info[0] = "EPR2";
            info[1] = "" + txtEpr2;
            datos.add(info);
        }
        if (txtEpe2 < 4.0) {
            info[0] = "EPE2";
            info[1] = "" + txtEpe2;
            datos.add(info);
        }
        double evas = txtEva1 + txtEva2 + txtEva3 + txtEva4;
        evas = Math.rint((evas / 4) * 10) / 10;
        if (evas < 4.0) {
            info[0] = "PROMEDIO FINAL EVA";
            info[1] = "" + evas;
            datos.add(info);
        }
        return datos;
    }
    public double calPromedio(double txtEpr1,double txtEpr2,double txtEpe1,double txtEpe2,
                              double txtEva1,double txtEva2,double txtEva3,double txtEva4) {
        //CALCULOS EPs
        double epr1 = txtEpr1 * 0.10;
        double epr2 = txtEpr2 * 0.15;
        double epe1 = txtEpe1 * 0.20;
        double epe2 = txtEpe2 * 0.25;
        double evas = txtEva1 + txtEva2 + txtEva3 + txtEva4;
        evas = (evas / 4) * 0.30;
        double prom = epr1 + epe1 + epr2 +epe2 + evas;
        return Math.rint(prom *10)/10;
    }
    public double[] preApr(double prom) {
        double pres = prom * 0.7;
        pres = Math.rint(pres * 10) / 10;
        double apro = (((pres - 4) * 100) / 30) * -1;
        apro = Math.rint(apro * 10) / 10;

        double datos[]={pres,apro};
        return datos;
    }
    public double notaFinal(double pres,double fin){
        fin = Math.rint((fin * 0.3) * 10) / 10;
        return (pres + fin);
    }
}
