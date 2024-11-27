/**
 * 
 */
package com.egdk.invoicesys.service;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.egdk.invoicesys.dto.InvoiceRequest;
import com.egdk.invoicesys.dto.InvoiceResponse;
import com.egdk.invoicesys.enums.InvoiceStatus;
import com.egdk.invoicesys.model.Invoice;
import com.egdk.invoicesys.repository.InvoiceRepository;
import com.egdk.invoicesys.utils.BeanUtils;

/**
 * 
 */
@Service
public class InvoiceServiceImpl implements InvoiceService {
	
	@Autowired
	private BeanUtils beanUtil;
	
	@Autowired
	private InvoiceRepository invoiceRepository;

	private final Logger log = LoggerFactory.getLogger(getClass());

	@Override
	public InvoiceResponse createInvoice(InvoiceRequest request) {
		// TODO Auto-generated method stub
		log.info("Create_Invoice : BEGIN");
		Invoice invoice = beanUtil.mapToEntity(request);
		Invoice newInvoice = invoiceRepository.save(invoice);
		log.info("Create_Invoice : END");
		return beanUtil.mapToResponse(newInvoice);

	}	

	@Override
	public List<Invoice> getInvoiceList() {
		// TODO Auto-generated method stub
		log.info("Fetch_Invoices : BEGIN");
		return invoiceRepository.findAll();
	}

	@Override
	public InvoiceResponse payInvoice(int id, InvoiceRequest request) {
		// TODO Auto-generated method stub
		log.info("Pay_Invoice : BEGIN");
		Invoice invoice = invoiceRepository.findById(id);
		invoice.setPaidAmount(request.getAmount());
		if(invoice.getAmount().equals(request.getAmount())) {
			invoice.setStatus(InvoiceStatus.PAID);
		} 
		Invoice newInvoice = invoiceRepository.save(invoice);
		log.info("Pay_Invoice : END");
		return beanUtil.mapToResponse(newInvoice);
	}

	@Override
	public List<Invoice> getPendingInvoices() {
		// TODO Auto-generated method stub
		log.info("Fetch_Pending_Invoices : BEGIN");
		List<Invoice> pendingInvoices = invoiceRepository.getPendingInvoices();
		return pendingInvoices;
	}

	@Override
	public void processOverdueInvoices() {
		// TODO Auto-generated method stub
		log.info("Process_Overdue_Invoices : BEGIN");
		List<Invoice> pendingInvoices = getPendingInvoices();
		pendingInvoices.stream()
		.forEach(i -> {
			if(i.getPaidAmount() > 0) {
				InvoiceRequest request = new InvoiceRequest();
				request.setAmount(i.getAmount()-i.getPaidAmount());
				request.setLate_fee(10.5);
				request.setDue_date(BeanUtils.convertDateToString(BeanUtils.addDaysToCurrentDate(new Date())));
				createInvoice(request);
				i.setStatus(InvoiceStatus.PAID);
				invoiceRepository.save(i);
			} else {
				InvoiceRequest request = new InvoiceRequest();
				request.setAmount(i.getAmount());
				request.setLate_fee(10.5);
				request.setDue_date(BeanUtils.convertDateToString(BeanUtils.addDaysToCurrentDate(new Date())));
				createInvoice(request);
				i.setStatus(InvoiceStatus.VOID);
				invoiceRepository.save(i);
			}
		});
		log.info("Process_Overdue_Invoices : END");
	}

}
