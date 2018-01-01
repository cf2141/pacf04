package com.acme.rnd;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import java.util.Random;
import java.util.Scanner;


public class App {
  public static void main( String[] args ) {
    System.out.println( "find the file" );
    String localDir = System.getProperty("user.dir"); 
    String csvFile = null;
    
    System.out.println("Working Directory = " + localDir );
    File folder = new File( localDir );
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        if (listOfFiles[i].getName().contains(".csv")){
          System.out.println("File " + listOfFiles[i].getName());
          csvFile = listOfFiles[i].getName();
        }
      } else if (listOfFiles[i].isDirectory()) {
      }
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    try {
      System.out.println("new Scanner(new File( "+csvFile+" ))");
      Scanner scanner = new Scanner(new File(csvFile));
      scanner.useDelimiter(",");
      while(scanner.hasNext()){
          System.out.print(scanner.next()+"|");
      }
      scanner.close();    
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    try {
      System.out.println("BufferedReader(new FileReader( "+csvFile+" ))");
      br = new BufferedReader(new FileReader(csvFile));
      while ((line = br.readLine()) != null) {
        // use comma as separator
        String[] country = line.split(cvsSplitBy);
        //System.out.println("Country [code= " + country[4] + " , name=" + country[5] + "]");
      }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
      if (br != null) {
        try {
          br.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }  
  
  }
}

