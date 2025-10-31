package com.example.mall.service;

import com.example.mall.entity.Staff;
import com.example.mall.repository.StaffRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffService {

    private final StaffRepository repo;

    public StaffService(StaffRepository repo) {
        this.repo = repo;
    }

    public List<Staff> getAllStaff() {
        return repo.findAll();
    }

    public Staff getStaffById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public Staff createStaff(Staff staff) {
        return repo.save(staff);
    }

    public Staff updateStaff(Long id, Staff details) {
        Staff staff = repo.findById(id).orElse(null);
        if (staff != null) {
            staff.setName(details.getName());
            staff.setRole(details.getRole());
            staff.setSalary(details.getSalary());
            staff.setShop(details.getShop());
            return repo.save(staff);
        }
        return null;
    }

    public void deleteStaff(Long id) {
        repo.deleteById(id);
    }
}