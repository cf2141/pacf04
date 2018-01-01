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


public class App {
  public static void main( String[] args ) {
    System.out.println( "find the file" );
    String localDir = System.getProperty("user.dir"); 
    System.out.println("Working Directory = " + localDir );
    File folder = new File( localDir );
    File[] listOfFiles = folder.listFiles();

    for (int i = 0; i < listOfFiles.length; i++) {
      if (listOfFiles[i].isFile()) {
        System.out.println("File " + listOfFiles[i].getName());
      } else if (listOfFiles[i].isDirectory()) {
      }
    }
  }
}

