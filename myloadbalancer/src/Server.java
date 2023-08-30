class Server {
    String name;
    int weight;

    public Server(String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public double estimateEnergyConsumption() {
        // Simulate energy consumption estimation based on server's weight
        return weight * 10.0; // For simplicity, using weight as a proxy for consumption
    }
}