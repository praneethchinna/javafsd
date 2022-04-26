package com.company.lockers;

import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Lockers {

  public static String projectPath = "D:\\spring\\FinalProject\\companyLocker";

  public static void main(String[] args) {
    int option;

    do {
      displayMenu();

      Scanner scan = new Scanner(System.in);
      option = scan.nextInt();

      switch (option) {
      case 1:
        displayFiles();
        break;
      case 2:
        createFiles();
        break;
      case 3:
        deleteFiles();
        break;
      case 4:
        searchFiles();
        break;
      case 5:
        System.out.println("thank you");
        break;

      default:
        throw new IllegalArgumentException("Unexpected value: " + option);
      }
    }
    while (option != 5);

  }

  public static void displayMenu() {
    System.out.println("*-------------------------------------------------------------------*");
    System.out.println("\t Welcome to Lockers.com");
    System.out.println("\t developer name: Mudhigonda Praneeth");
    System.out.println("=====================================================================");
    System.out.println("\t1. Display all files");
    System.out.println("\t2. add the files");
    System.out.println("\t3. Delete  files");
    System.out.println("\t4. search files");
    System.out.println("\t5. Exit");
    System.out.println("=====================================================================");
    System.out.println("enter your choice");

  }
  public static void displayFiles() {
    File directoryPath = new File(projectPath);

    File[] contents = directoryPath.listFiles();

    Set < File > treeset = new TreeSet < File > ();

    treeset.addAll(Arrays.asList(contents));

    for (File file: treeset) {

      System.out.println(file.getName());

    }

  }
  public static void createFiles() {
    try {
      Scanner scan = new Scanner(System.in);
      String fileName;
      int linesCount;

      System.out.println("enter file name");
      fileName = scan.nextLine();

      System.out.println("enter content lines");
      linesCount = Integer.parseInt(scan.nextLine());

      FileWriter fw = new FileWriter(projectPath + "\\" + fileName);

      for (int i = 1; i <= linesCount; i++) {
        System.out.println("enter file content");
        fw.write(scan.nextLine() + "\n");
      }
      System.out.println("created successfully");
      fw.close();

    } catch (Exception e) {
      System.out.println(e);
    }
  }
  public static void deleteFiles() {
    Scanner scan = new Scanner(System.in);
    try {

      System.out.println("enter file name to delete");
      String fileName = scan.nextLine();
      File fl = new File(projectPath + "\\" + fileName);
      if (fl.exists()) {
        fl.delete();
        System.out.println("file deleted successfully");
      } else {
        System.out.println("file do not exists");
      }

    } catch (Exception e) {
      // TODO: handle exception

      System.out.println(e);
    }
  }
  public static void searchFiles() {
    Scanner scan = new Scanner(System.in);
    try {

      System.out.println("enter file name to search");
      String fileName = scan.nextLine();
      File fl = new File(projectPath + "\\" + fileName);
      if (fl.exists()) {

        System.out.println("file exists");
      } else {
        System.out.println("file do not exists");
      }

    } catch (Exception e) {
      // TODO: handle exception

      System.out.println(e);
    }

  }

}