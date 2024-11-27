package com.egdk.invoicesys.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.egdk.invoicesys.model.Invoice;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer>{

	Invoice findById(int id);

	@Query(value = "SELECT * FROM invoice_details WHERE status='PENDING' and overdue_days > 10", nativeQuery = true)
	List<Invoice> getPendingInvoices();

}
