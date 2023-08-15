package io.bootify.my_app.service;

import io.bootify.my_app.domain.Admin;
import io.bootify.my_app.model.AdminDTO;
import io.bootify.my_app.repos.AdminRepository;
import io.bootify.my_app.util.NotFoundException;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class AdminService {

    private final AdminRepository adminRepository;

    public AdminService(final AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public List<AdminDTO> findAll() {
        final List<Admin> admins = adminRepository.findAll(Sort.by("adminId"));
        return admins.stream()
                .map(admin -> mapToDTO(admin, new AdminDTO()))
                .toList();
    }

    public AdminDTO get(final Long adminId) {
        return adminRepository.findById(adminId)
                .map(admin -> mapToDTO(admin, new AdminDTO()))
                .orElseThrow(NotFoundException::new);
    }

    public Long create(final AdminDTO adminDTO) {
        final Admin admin = new Admin();
        mapToEntity(adminDTO, admin);
        return adminRepository.save(admin).getAdminId();
    }

    public void update(final Long adminId, final AdminDTO adminDTO) {
        final Admin admin = adminRepository.findById(adminId)
                .orElseThrow(NotFoundException::new);
        mapToEntity(adminDTO, admin);
        adminRepository.save(admin);
    }

    public void delete(final Long adminId) {
        adminRepository.deleteById(adminId);
    }

    private AdminDTO mapToDTO(final Admin admin, final AdminDTO adminDTO) {
        adminDTO.setAdminId(admin.getAdminId());
        adminDTO.setAdminName(admin.getAdminName());
        adminDTO.setAdminEmail(admin.getAdminEmail());
        adminDTO.setAdminPassword(admin.getAdminPassword());
        return adminDTO;
    }

    private Admin mapToEntity(final AdminDTO adminDTO, final Admin admin) {
        admin.setAdminName(adminDTO.getAdminName());
        admin.setAdminEmail(adminDTO.getAdminEmail());
        admin.setAdminPassword(adminDTO.getAdminPassword());
        return admin;
    }

    public boolean adminNameExists(final String adminName) {
        return adminRepository.existsByAdminNameIgnoreCase(adminName);
    }

    public boolean adminEmailExists(final String adminEmail) {
        return adminRepository.existsByAdminEmailIgnoreCase(adminEmail);
    }

}
