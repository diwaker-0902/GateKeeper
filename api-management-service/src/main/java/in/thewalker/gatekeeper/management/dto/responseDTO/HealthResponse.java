package in.thewalker.gatekeeper.management.dto.responseDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter 
public class HealthResponse {

    private String serviceName;
    private String serviceDescription;
    private String status;

}
