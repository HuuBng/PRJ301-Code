package models;

public class Calculator {

    private double a;
    private double b;
    private double c;
    private int op;

    public Calculator() {
    }

    public Calculator(double a, double b, int op) {
        this.a = a;
        this.b = b;
        this.op = op;
    }

    public Calculator(double a, double b, double c, int op) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.op = op;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public Object getResult() {
        Object result = null;

        switch (op) {
            case 1: // Phuong trinh bac 1
                if (a == 0) {
                    if (b == 0) {
                        result = "Phuong trinh vo so nghiem";
                    } else {
                        result = "Phuong trinh vo nghiem";
                    }
                } else {
                    result = -b / a;
                }
                break;

            case 2: // Phuong trinh bac 2
                double delta = b * b - 4 * a * c;
                double x1;
                double x2;

                if (delta > 0) {
                    x1 = (-b + Math.sqrt(delta)) / (2 * a);
                    x2 = (-b - Math.sqrt(delta)) / (2 * a);
                    result = String.format("Phuong trinh co 2 nghiem la: x1 = %.2f va x2 = %.2f", x1, x2);
                } else if (delta == 0) {
                    x1 = (-b / (2 * a));
                    result = String.format("Phong trinh co nghiem kep: x1 = x2 = %.2f", x1);
                } else {
                    result = "Phuong trinh vo nghiem!";
                }
                break;

            default:
                result = "Invalid op";
        }
        return result;
    }
}
