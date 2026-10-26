package in.thewalker.gatekeeper.management.dto.responseDTO;

import in.thewalker.gatekeeper.management.entity.Organization;
import in.thewalker.gatekeeper.management.entity.OrganizationStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class OrganizationResponse {

    private Long id;
    private String name;
    private String slug;
    private OrganizationStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // Creates an OrganizationResponse object from an Organization entity. 
    // This method is used to convert the Organization entity to a DTO 
    // which is OrganizationResponse (Data Transfer Object) that can be sent as a response to the client. 
    // It extracts the relevant fields from the Organization entity and constructs a new OrganizationResponse object with those values.
    public static OrganizationResponse from(Organization organization) {
        return new OrganizationResponse(organization.getId(),
                organization.getName(),
                organization.getSlug(),
                organization.getStatus(),
                organization.getCreatedAt(),
                organization.getUpdatedAt());
    }
}