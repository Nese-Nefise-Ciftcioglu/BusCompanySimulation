public class Bus {
    private double gasoline;
    private double driverSalary;
    public Bus(){
        gasoline=0.0;
        driverSalary=0.0;
    }
    public Bus(double gas,double salar){
        gasoline=gas;
        driverSalary=salar;

    }
    public void setGasoline(double gasoline){
        this.gasoline=gasoline;
    }
    public double getGasoline() {
        return gasoline;
    }
    public void setDriverSalary(double driverSalary){
        this.driverSalary=driverSalary;
    }
    public double getDriverSalary() {
        return driverSalary;
    }
}
