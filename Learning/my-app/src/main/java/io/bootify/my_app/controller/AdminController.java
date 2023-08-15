package io.bootify.my_app.controller;

import io.bootify.my_app.model.AdminDTO;
import io.bootify.my_app.service.AdminService;
import io.bootify.my_app.util.WebUtils;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
@RequestMapping("/admins")
public class AdminController {

    private final AdminService adminService;

    public AdminController(final AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping
    public String list(final Model model) {
        model.addAttribute("admins", adminService.findAll());
        return "admin/list";
    }

    @GetMapping("/add")
    public String add(@ModelAttribute("admin") final AdminDTO adminDTO) {
        return "admin/add";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("admin") @Valid final AdminDTO adminDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        if (!bindingResult.hasFieldErrors("adminName") && adminService.adminNameExists(adminDTO.getAdminName())) {
            bindingResult.rejectValue("adminName", "Exists.admin.adminName");
        }
        if (!bindingResult.hasFieldErrors("adminEmail") && adminService.adminEmailExists(adminDTO.getAdminEmail())) {
            bindingResult.rejectValue("adminEmail", "Exists.admin.adminEmail");
        }
        if (bindingResult.hasErrors()) {
            return "admin/add";
        }
        adminService.create(adminDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("admin.create.success"));
        return "redirect:/admins";
    }

    @GetMapping("/edit/{adminId}")
    public String edit(@PathVariable final Long adminId, final Model model) {
        model.addAttribute("admin", adminService.get(adminId));
        return "admin/edit";
    }

    @PostMapping("/edit/{adminId}")
    public String edit(@PathVariable final Long adminId,
            @ModelAttribute("admin") @Valid final AdminDTO adminDTO,
            final BindingResult bindingResult, final RedirectAttributes redirectAttributes) {
        final AdminDTO currentAdminDTO = adminService.get(adminId);
        if (!bindingResult.hasFieldErrors("adminName") &&
                !adminDTO.getAdminName().equalsIgnoreCase(currentAdminDTO.getAdminName()) &&
                adminService.adminNameExists(adminDTO.getAdminName())) {
            bindingResult.rejectValue("adminName", "Exists.admin.adminName");
        }
        if (!bindingResult.hasFieldErrors("adminEmail") &&
                !adminDTO.getAdminEmail().equalsIgnoreCase(currentAdminDTO.getAdminEmail()) &&
                adminService.adminEmailExists(adminDTO.getAdminEmail())) {
            bindingResult.rejectValue("adminEmail", "Exists.admin.adminEmail");
        }
        if (bindingResult.hasErrors()) {
            return "admin/edit";
        }
        adminService.update(adminId, adminDTO);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_SUCCESS, WebUtils.getMessage("admin.update.success"));
        return "redirect:/admins";
    }

    @PostMapping("/delete/{adminId}")
    public String delete(@PathVariable final Long adminId,
            final RedirectAttributes redirectAttributes) {
        adminService.delete(adminId);
        redirectAttributes.addFlashAttribute(WebUtils.MSG_INFO, WebUtils.getMessage("admin.delete.success"));
        return "redirect:/admins";
    }

}
