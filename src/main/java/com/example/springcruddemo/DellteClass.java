package com.example.springcruddemo;
//
//import java.io.*;
//import java.util.Scanner;
//
public class DellteClass {
//
//    public static void main(String[] args) throws Exception {
//        File inputFile = new File("input.txt");
//        if (!inputFile.exists()) {
//            try {
//                inputFile.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Введите целое число A:");
//        int a = scanner.nextInt();
//        System.out.println("Введите целое число B:");
//        int b = scanner.nextInt();
//        BufferedWriter bw = new BufferedWriter(new FileWriter("input.txt"));
//
//        bw.write(Integer.toString(a));
//        bw.newLine();
//        bw.write(Integer.toString(b));
//        bw.close();
//
//        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
//        String c = br.readLine();
//        String d = br.readLine();
//        br.close();
//
//        BufferedWriter bwr = new BufferedWriter(new FileWriter("output.txt"));
//
//        int line1 = Integer.parseInt(c);
//        int line2 = Integer.parseInt(d);
//
//        int sum = line1 + line2;
//        int product = line1 * line2;
//        bwr.write("" + sum);
//        bwr.newLine();
//        bwr.write("" + product);
//
//        bwr.close();
//
//    }
}
