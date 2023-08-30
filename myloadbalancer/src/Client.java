public class Client {
    public static void main(String[] args) {
        LoadBalancer loadBalancer = new LoadBalancer();
        double totalEnergyConsumption = 0;

        // Simulate multiple requests
        for (int i = 0; i < 40; i++) {
            Server server = loadBalancer.getNextServer();
            System.out.println("Request " + (i + 1) + " routed to: " + server.name);

            // Simulate server response time (for example, using a random value)
            int responseTime = (int) (Math.random() * 300);

            if (isSLAAdhered(responseTime)) {
                System.out.println("SLA Adhered for Request " + (i + 1));
            } else {
                System.out.println("SLA Not Adhered for Request " + (i + 1));
            }

            totalEnergyConsumption += server.estimateEnergyConsumption();
        }

        System.out.println("Total Energy Consumption: " + totalEnergyConsumption);
    }

    public static boolean isSLAAdhered(int responseTime) {
        // Simulate SLA adherence based on response time threshold (e.g., 200 ms)
        return responseTime <= 200;
    }
}
