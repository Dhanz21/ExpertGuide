package com.trekExpert.expertguide.controller;

import com.trekExpert.expertguide.model.Expert;
import com.trekExpert.expertguide.service.ExpertService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/experts")
@Tag(name = "Experts", description = "Expert Management API")
public class ExpertController {

    @Autowired
    private ExpertService expertService;

    @GetMapping
    @Operation(summary = "Get all experts", description = "Retrieve a list of all experts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of experts")
    public ResponseEntity<List<Expert>> getAllExperts() {
        return ResponseEntity.ok(expertService.getAllExperts());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get expert by ID", description = "Retrieve a specific expert by their ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expert found"),
            @ApiResponse(responseCode = "404", description = "Expert not found")
    })
    public ResponseEntity<Expert> getExpertById(
            @Parameter(description = "Expert ID") @PathVariable Long id) {
        Optional<Expert> expert = expertService.getExpertById(id);
        return expert.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get expert by email", description = "Retrieve a specific expert by their email")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expert found"),
            @ApiResponse(responseCode = "404", description = "Expert not found")
    })
    public ResponseEntity<Expert> getExpertByEmail(
            @Parameter(description = "Expert email") @PathVariable String email) {
        Optional<Expert> expert = expertService.getExpertByEmail(email);
        return expert.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/expertise/{expertise}")
    @Operation(summary = "Get experts by expertise", description = "Retrieve all experts with a specific expertise")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of experts")
    public ResponseEntity<List<Expert>> getExpertsByExpertise(
            @Parameter(description = "Expertise area") @PathVariable String expertise) {
        return ResponseEntity.ok(expertService.getExpertsByExpertise(expertise));
    }

    @GetMapping("/active")
    @Operation(summary = "Get active experts", description = "Retrieve all active experts")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved list of active experts")
    public ResponseEntity<List<Expert>> getActiveExperts() {
        return ResponseEntity.ok(expertService.getActiveExperts());
    }

    @PostMapping
    @Operation(summary = "Create a new expert", description = "Create a new expert record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Expert created successfully"),
            @ApiResponse(responseCode = "400", description = "Invalid input")
    })
    public ResponseEntity<Expert> createExpert(@Valid @RequestBody Expert expert) {
        Expert createdExpert = expertService.createExpert(expert);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdExpert);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an expert", description = "Update an existing expert record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Expert updated successfully"),
            @ApiResponse(responseCode = "404", description = "Expert not found")
    })
    public ResponseEntity<Expert> updateExpert(
            @Parameter(description = "Expert ID") @PathVariable Long id,
            @Valid @RequestBody Expert expertDetails) {
        Expert updatedExpert = expertService.updateExpert(id, expertDetails);
        if (updatedExpert != null) {
            return ResponseEntity.ok(updatedExpert);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an expert", description = "Delete an expert record")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Expert deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Expert not found")
    })
    public ResponseEntity<Void> deleteExpert(
            @Parameter(description = "Expert ID") @PathVariable Long id) {
        if (expertService.deleteExpert(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
