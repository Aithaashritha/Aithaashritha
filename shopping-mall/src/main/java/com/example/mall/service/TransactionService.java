package com.example.mall.service;

import com.example.mall.entity.TransactionRecord;
import com.example.mall.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public List<TransactionRecord> getAllTransactions() {
        return repo.findAll();
    }

    public TransactionRecord getTransactionById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public TransactionRecord createTransaction(TransactionRecord transaction) {
        return repo.save(transaction);
    }

    public TransactionRecord updateTransaction(Long id, TransactionRecord details) {
        TransactionRecord transaction = repo.findById(id).orElse(null);
        if (transaction != null) {
            transaction.setCustomer(details.getCustomer());
            transaction.setProduct(details.getProduct());
            transaction.setQuantity(details.getQuantity());
            transaction.setTotalAmount(details.getTotalAmount());
            transaction.setTransactionDate(details.getTransactionDate());
            return repo.save(transaction);
        }
        return null;
    }

    public void deleteTransaction(Long id) {
        repo.deleteById(id);
    }
}
