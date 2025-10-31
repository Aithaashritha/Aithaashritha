package com.example.convergenceintegration.service;

import org.springframework.stereotype.Service;
import com.example.convergenceintegration.entity.DataTransfer;
import com.example.convergenceintegration.repository.DataTransferRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DataTransferService {

    private final DataTransferRepository repo;

    public DataTransferService(DataTransferRepository repo) {
        this.repo = repo;
    }

    public List<DataTransfer> getAllTransfers() {
        return repo.findAll();
    }

    public Optional<DataTransfer> getTransferById(Long id) {
        return repo.findById(id);
    }

    // Fixed: use constructor + setters instead of builder
    public DataTransfer initiateTransfer(String source, String target, String type) {
        DataTransfer transfer = new DataTransfer();  // no builder
        transfer.setSourceSystem(source);
        transfer.setTargetSystem(target);
        transfer.setTransferType(type);
        transfer.setStartTime(LocalDateTime.now());
        transfer.setStatus("IN_PROGRESS");
        return repo.save(transfer);
    }

    public DataTransfer updateTransfer(Long id, DataTransfer updated) {
        Optional<DataTransfer> existingOpt = repo.findById(id);
        if (existingOpt.isPresent()) {
            DataTransfer t = existingOpt.get();
            t.setSourceSystem(updated.getSourceSystem());
            t.setTargetSystem(updated.getTargetSystem());
            t.setTransferType(updated.getTransferType());
            t.setStartTime(updated.getStartTime());
            t.setEndTime(updated.getEndTime());
            t.setStatus(updated.getStatus());
            return repo.save(t);
        } else {
            throw new RuntimeException("Transfer not found");
        }
    }

    public void deleteTransfer(Long id) {
        repo.deleteById(id);
    }
}
