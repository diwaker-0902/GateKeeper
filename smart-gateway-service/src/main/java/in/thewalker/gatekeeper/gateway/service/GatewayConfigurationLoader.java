package in.thewalker.gatekeeper.gateway.service;

import in.thewalker.gatekeeper.gateway.client.ManagementApiClient;
import in.thewalker.gatekeeper.gateway.dto.GatewayRoute;
// import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GatewayConfigurationLoader implements ApplicationRunner {

    private final ManagementApiClient managementApiClient;

    public GatewayConfigurationLoader(ManagementApiClient managementApiClient) {
        this.managementApiClient = managementApiClient;
    }

    @Override
    public void run(ApplicationArguments arguments) {
       refresh();
    }

    public void refresh() {
        List<GatewayRoute> routes = managementApiClient.fetchActiveRoutes();

        //demo
        for(GatewayRoute route : routes) {
            System.out.println("Route : " + route.getTargetPathPrefix());
        }
    }
}




// @Component
// public class GatewayConfigurationLoader implements ApplicationRunner {

//     private final ManagementApiClient managementApiClient;

//     public GatewayConfigurationLoader(ManagementApiClient managementApiClient) {
//         this.managementApiClient = managementApiClient;
//     }

//     @Override
//     public void run(ApplicationArguments arguments) {

//         System.out.println("======================================");
//         System.out.println("GATEWAY CONFIGURATION LOADER STARTED");
//         System.out.println("======================================");

//         refresh();
//     }

//     public void refresh() {

//         System.out.println("Fetching active routes...");

//         List<GatewayRoute> routes =
//                 managementApiClient.fetchActiveRoutes();

//         System.out.println("Total routes received: " + routes.size());

//         for (GatewayRoute route : routes) {

//             System.out.println(
//                     "Activated Route: " + route.getTargetPathPrefix()
//             );
//         }
//     }
// }