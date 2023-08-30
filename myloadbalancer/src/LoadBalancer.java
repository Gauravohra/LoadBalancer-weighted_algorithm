import java.util.ArrayList;
import java.util.List;
class LoadBalancer {
    private List<Server> servers;
    private int currentIndex;

    public LoadBalancer() {
        servers = new ArrayList<>();
        currentIndex = 0;

        // Add servers with their weights
        servers.add(new Server("Server1", 3));
        servers.add(new Server("Server2", 4));
        servers.add(new Server("Server3", 7));
    }

    public Server getNextServer() {
        int totalWeight = servers.stream().mapToInt(server -> server.weight).sum();

        Server selectedServer = null;
        int currentWeight = 0;
        synchronized (this) {
            for (Server server : servers) {
                currentWeight += server.weight;
                if (currentWeight >= currentIndex) {
                    selectedServer = server;
                    currentIndex = (currentIndex + 1) % totalWeight;
                    break;
                }
            }
        }

        return selectedServer;
    }
}