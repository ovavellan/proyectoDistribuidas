package com.proyect.aeropuerto.config;

import java.text.DecimalFormat;

public class GenericDetailID {
	private static int counter = 1;
    private static DecimalFormat df = new DecimalFormat("000000000000");

    public static String getNextID() {
        String uniqueCode = df.format(counter);
        counter++;
        return uniqueCode;
    }
}
