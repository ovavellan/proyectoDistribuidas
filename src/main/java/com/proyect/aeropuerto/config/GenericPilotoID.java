package com.proyect.aeropuerto.config;

import java.text.DecimalFormat;

public class GenericPilotoID {
	private static int counter = 1;
    private static DecimalFormat df = new DecimalFormat("000000000000");

    public static String getNextId() {
        String uniqueCode = df.format(counter);
        counter++;
        return uniqueCode;
    }
}
