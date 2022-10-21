public class Expedetion implements BusCompany {
    private String startPoint;
    private String destination;
    private double distance;
    private String Time;
    private double ticketPrice;
    private int seat=25;
    private double profit;
    public Customer customer;
    int reserve;
    public int ID;
    public Expedetion(){
        startPoint="Unknown";
        destination="Unknown";
        distance=0.0;
        Time="Unknown";
        ticketPrice=0.0;
    }
    public Expedetion(String start,String dest,String time ){
        startPoint=start;
        destination=dest;
        distance=getDistance();
        Time=time;
        ticketPrice=getTicketPrice();
    }
    public void setReserve(int reserve){
        this.reserve=reserve;

    }
    public int getReserve(){
        return reserve;
    }
    public void setID(int ID){
            this.ID = ID;

    }
    public int getCustomerID(){
        return ID;
    }
    public void setStartPoint(String startPoint){
        this.startPoint=startPoint;
    }
    public void setDestination(String destination){
        this.destination=destination;
    }
    public String getStartPoint(){
        return startPoint;
    }
    public String getDestination(){
        return destination;
    }
    public void setDistance(String startPoint,String destination,String time) {
        if (startPoint.equals("İzmir") && destination.equals("İstanbul") || startPoint.equals("İstanbul") && destination.equals("İzmir")) {
            this.distance = 477;
        }
        else if (startPoint.equals("İzmir") && destination.equals("Ankara") || startPoint.equals("Ankara") && destination.equals("İzmir")) {
            this.distance = 489;
        }
        else if (startPoint.equals("İstanbul") && destination.equals("Ankara") || startPoint.equals("Ankara") && destination.equals("İstanbul"))
        {
            this.distance=456;
        }
    }
    public double getDistance(){
        return distance;
    }
    public void setTime(String Time) {
        this.Time = Time;
    }
    public String getTime() {
        return Time;
    }


    public void calculateTicketPrice(double gas,double salary,double prof ){
        double distance=getDistance();
        this.ticketPrice= (((distance*gas)+salary)+prof)/seat;
    }
    public double getTicketPrice(){
        return ticketPrice;
    }
    public void setProfit(double profit) {
        this.profit = profit;
    }

    public double getProfit() {
        return profit;
    }

    public void printSeats(int[][]seats) {
        for (int row = 0; row < seats.length; row++) {
            for (int column = 0; column < seats[row].length; column++) {
                System.out.printf("%d ", seats[row][column]);
                if(seats[row][column]%4==2){
                    System.out.print("   ");
                }
            }
            System.out.println();
            System.out.println();


        }
    }

    public void displayExpeditions(){
        System.out.println("Starts from: "+getStartPoint());
        System.out.println("Destination: "+getDestination());
        System.out.println("Distance: "+getDistance());
        System.out.println("Date and Time: "+getTime());
        System.out.println("Ticket Price: "+getTicketPrice());

    }

}
