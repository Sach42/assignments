package io.bootify.my_app.rest;

import io.bootify.my_app.model.AdminDTO;
import io.bootify.my_app.service.AdminService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/api/admins", produces = MediaType.APPLICATION_JSON_VALUE)
public class AdminResource {

    private final AdminService adminService;

    public AdminResource(final AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public ResponseEntity<List<AdminDTO>> getAllAdmins() {
        return ResponseEntity.ok(adminService.findAll());
    }

    @GetMapping("/{adminId}")
    public ResponseEntity<AdminDTO> getAdmin(@PathVariable(name = "adminId") final Long adminId) {
        return ResponseEntity.ok(adminService.get(adminId));
    }

    @PostMapping
    @ApiResponse(responseCode = "201")
    public ResponseEntity<Long> createAdmin(@RequestBody @Valid final AdminDTO adminDTO) {
        final Long createdAdminId = adminService.create(adminDTO);
        return new ResponseEntity<>(createdAdminId, HttpStatus.CREATED);
    }

    @PutMapping("/{adminId}")
    public ResponseEntity<Long> updateAdmin(@PathVariable(name = "adminId") final Long adminId,
            @RequestBody @Valid final AdminDTO adminDTO) {
        adminService.update(adminId, adminDTO);
        return ResponseEntity.ok(adminId);
    }

    @DeleteMapping("/{adminId}")
    @ApiResponse(responseCode = "204")
    public ResponseEntity<Void> deleteAdmin(@PathVariable(name = "adminId") final Long adminId) {
        adminService.delete(adminId);
        return ResponseEntity.noContent().build();
    }

}
