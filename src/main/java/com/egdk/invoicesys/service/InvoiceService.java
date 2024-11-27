package com.egdk.invoicesys.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.egdk.invoicesys.dto.InvoiceRequest;
import com.egdk.invoicesys.dto.InvoiceResponse;
import com.egdk.invoicesys.model.Invoice;

@Service
public interface InvoiceService {

	InvoiceResponse createInvoice(InvoiceRequest request);

	List<Invoice> getInvoiceList();

	InvoiceResponse payInvoice(int id, InvoiceRequest request);
	
	List<Invoice> getPendingInvoices();

	void processOverdueInvoices();

}
