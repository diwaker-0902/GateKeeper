package in.thewalker.gatekeeper.management.service;

import in.thewalker.gatekeeper.management.entity.Organization;
import in.thewalker.gatekeeper.management.entity.OrganizationStatus;
import in.thewalker.gatekeeper.management.exception.ApiException;
import in.thewalker.gatekeeper.management.repository.OrganizationRepository;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;


// 1. Fetch the current user's authentication from Spring Security and ensure it is JWT-based.
// 2. Extract the organizationId claim from the JWT; reject the request if it is missing.
// 3. Fetch the Organization from the database by ID and reject it if it doesn't exist.
// 4. Verify the organization is ACTIVE, then return the Organization entity.


@Component
public class TenantContext {

    private final OrganizationRepository organizationRepository;

    public TenantContext(OrganizationRepository organizationRepository) {
        this.organizationRepository = organizationRepository;
    }

    public Organization getOrganization() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(!(authentication instanceof JwtAuthenticationToken)) {
            throw new ApiException(HttpStatus.FORBIDDEN, "Tenant identity is missing");
        }

        Long organizationId = ((JwtAuthenticationToken) authentication).getToken()
                .getClaim("organizationId");

        if(organizationId == null) {
            throw new ApiException(HttpStatus.FORBIDDEN, "Tenant identity is missing");
        }

        // Fetching the whole organization entity from DB using the organizationId claim from the JWT. 
        // This ensures that the organization exists and is active.
        Organization organization = organizationRepository.findById(organizationId)
                .orElseThrow(() -> new ApiException(HttpStatus.FORBIDDEN, "Organization does not exist"));

        if(organization.getStatus() != OrganizationStatus.ACTIVE) {
            throw new ApiException(HttpStatus.FORBIDDEN, "The organization is not active");
        }

        return organization;
    }
}