package com.abt.java.enumeration;

public class DoEnum {

    public static void main(String[] args) {
        runColorMe();
    }

    enum ColorMe {
        RED, GREEN, BLUE;
    }

    private static void runColorMe() {
        ColorMe color = ColorMe.RED;
        int counter = 10;
        while (counter-- > 0) {
            switch (color) {
                case RED:
                    System.out.println("Red");
                    color = ColorMe.BLUE;
                    break;
                case BLUE:
                    System.out.println("Blue");
                    color = ColorMe.GREEN;
                    break;
                case GREEN:
                    System.out.println("Green");
                    color = ColorMe.RED;
                    break;
            }
        }
    }

    enum Color {
        RED(1), GREEN(2), BLUE(3);
        private int code;

        Color(int code) {
            this.code = code;
        }

        public int getCode() {
            return code;
        }
    }

    enum SingletonDemo {
        INSTANCE;
        public void otherMethods() {
            System.out.println("Something");
        }
    }

}
