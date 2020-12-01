public
class Car {
    private String type;
    private String model;
    private String colour;
    private int horsepower;

    public
    Car (String type, String model, String colour, int horsepower) {
        this.type = type;
        this.model = model;
        this.colour = colour;
        this.horsepower = horsepower;
    }

    public
    int getHorsepower () {
        return this.horsepower;
    }

    public
    String getModel () {
        return this.model;
    }

    public
    String getType () {
        return this.type;
    }

    @Override
    public
    String toString () {
        return String.format ("Type: Car%n" +
                              "Model: %s%n" +
                              "Color: %s%n" +
                              "Horsepower: %d", this.model,this.colour,this.horsepower);
    }
}
