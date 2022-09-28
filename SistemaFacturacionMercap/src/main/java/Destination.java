public class Destination {

    public Double costPerMinute;
    public String destination;

    public Destination(Double costPerMinute, String destination) {
        this.costPerMinute = costPerMinute;
        this.destination = destination;
    }
    public Destination(){}
    public Double getCostPerMinute() {
        return costPerMinute;
    }

    public String getDestinationName() {
        return destination;
    }
}
