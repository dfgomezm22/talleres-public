/*
 * This file is part of ISIS1206
 *
 * Copyright (C) 2015 - ISIS1206 Team
 */
package calculator;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Scanner;

public class Calculator
{

   private double lastResult = 0;

   public double add(double a, double b){
      lastResult = a+b;
      return lastResult;
   }

   public double subtract(double a, double b){
      lastResult = a-b;
      return lastResult;
   }

   public double multiply(double a, double b){
      lastResult = a*b;
      return lastResult;
   }

   public double divide(double a, double b){
      lastResult = a/b;
      return lastResult;
   }

   public double getLasResult(){
     return lastResult;
   }
}
