package me.atticusthecoder.chatmgr.common;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Random;

import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class UtilMath
{
	public static double trim(int degree, double d) 
	{
		String format = "#.#";
		
		for (int i=1 ; i<degree ; i++)
			format += "#";

		DecimalFormatSymbols symb = new DecimalFormatSymbols(Locale.US);
		DecimalFormat twoDForm = new DecimalFormat(format, symb);
		return Double.valueOf(twoDForm.format(d));
	}

}

