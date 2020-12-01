public
class Vehicle {
    private String type;
    private String model;
    private String colour;
    private int horsePower;

    public
    Vehicle (String type, String model, String colour, int horsePower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsePower = horsePower;
    }

    public
    String getType () {
        return this.type;
    }

    public
    String getModel () {
        return this.model;
    }

    public
    String getColour () {
        return this.colour;
    }

    public
    int getHorsePower () {
        return this.horsePower;
    }

    @Override
    public
    String toString () {
        return String.format ("Type: %s%n" +
                              "Model: %s%n" +
                              "Color: %s%n" +
                              "Horsepower: %d", this.getType().toUpperCase().charAt(0) + this.getType().substring(1),this.model,this.colour,this.horsePower);
    }
}
