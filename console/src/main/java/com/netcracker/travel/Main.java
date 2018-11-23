package com.netcracker.travel;

public class Main {

    public static void main(String[] args) {
        Double d = 12.0;
        String str = String.valueOf(d);
        d = Double.valueOf(str);

        System.out.println(str);
        System.out.println(d);
            Menu.chooseAction();
    }
}
