package models;

/*
Javabean
- field la private
- co default comstructor
- co getter setter
 */
public class Calculator {

    private double num1;
    private double num2;
    private String op;

    public Calculator() {
        this.num1 = 0;
        this.num2 = 0;
        this.op = null;
    }

    public Calculator(double num1, double num2, String op) {
        this.num1 = num1;
        this.num2 = num2;
        this.op = op;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }
    
    // read-only properties
    public Object getResult() {
        Object result = null;
        switch (op) {
            case "add":
                result = num1 + num2;
                break;
            case "sub":
                result = num1 - num2;
                break;
            case "mul":
                result = num1 * num2;
                break;
            case "div":
                if (num2 == 0) {
                    result = "Can't divide by zero";
                } else {
                    result = num1 / num2;
                }
                break;
        }
        return result;
    }

}
