package com.company;

import java.util.Scanner;
import java.lang.String;

public class Main {

    public static void main(String[] args) {
        String[][] data = {
                {"БИШКЕК", "8:170.0;10:500.0;30:800.0;50:3495.0->1.0:-1.0"},
                {"ОШ", "8.0:350.0;10.0:900.0;30.0:2460.0;50.0:4926.0->1.0:-1.0"},
                {"АЛМАТЫ", "0.3:650.0;0.5:750.0->1.0:430.0"},
                {"ШЫМКЕНТ", "0.3:700.0;0.5:750.0->1.0:430.0"},
                {"МОСКВА", "0.5:1130.14->1.0:160.0"},
                {"САНКТ-ПЕТЕРБУРГ", "0.5:856.98->1.0:231.53"},
                {"ЛОНДОН", "0.5:2900.0->1.0:500.0"},
                {"МАДРИД", "0.5:3000.0->1.0:700.0"},
        };
        System.out.println("Введите вес: ");
        Scanner scanner = new Scanner(System.in);
        double weight = scanner.nextDouble();
        for (int i = 0; i < data.length ; i++) {
            System.out.println(i + ". " + data[i][0]);

        }
        int city_id = scanner.nextInt();
        if (city_id < 0 || city_id > data.length - 1){
            System.out.println("Введите индех города из списка");
        }
        String [] temp = data[city_id][1].split("->1.0:");
        double priceForEachKG = Double.parseDouble(temp[1]);
        temp = temp[0].split(";");
        for (int i = 0; i < temp.length; i++) {
            temp = temp[i].split(":");

            double weightInterval = Double.parseDouble(temp[0]);
            double priceInterval = Double.parseDouble(temp[1]);
            if (weight <= weightInterval){
                System.out.println("Price = " + priceInterval);
                break;
            }
            else {
                double price;
                price = (weight - weightInterval) * priceForEachKG + priceInterval;
                if (price <= 0){
                    System.out.println("Цена не может быть рассчитана");
                }
                else {
                    System.out.println("Price = " + price);
                    break;
                }
            }

        }



    }
}
