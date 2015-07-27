/*
 * Test.java
 * This file is part of ISIS1206
 *
 * Copyright (C) 2015 - ISIS1206 Team 
 *
 * ISIS1206 is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * ISIS1206 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with ISIS1206. If not, see <http://www.gnu.org/licenses/>.
 */


import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Test
{
     public static void main(String... args) 
     {
        try 
        {
            System.out.println("Ingrese un número por favor: ");
            BufferedReader br = 
            new BufferedReader(new InputStreamReader(System.in));
            String s = br.readLine();
            double number = Double.parseDouble(s);
            System.out.println("El número ingresado es:" + number);
        } 
        catch (Exception e) 
        {
            System.err.println("Error:" + e.getMessage());
        }
    }
}
