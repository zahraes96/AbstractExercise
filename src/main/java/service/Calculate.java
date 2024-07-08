package service;

public class Calculate  extends  AbstractCalculator{
    @Override
    public double add(double a, double b) {
        return a+b;
    }
    @Override
    public double multipliy(double a, double b) {
        return a*b;
    }
    @Override
    public double subtract(double a, double b) {
        return a-b;
    }
    @Override
    public double divide(double a, double b) throws Exception {
        if (b==0)
            return -1;
        return a/b;
    }
}
