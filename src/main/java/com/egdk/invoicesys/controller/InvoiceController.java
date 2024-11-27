package com.egdk.invoicesys.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.egdk.invoicesys.dto.InvoiceRequest;
import com.egdk.invoicesys.dto.InvoiceResponse;
import com.egdk.invoicesys.model.Invoice;
import com.egdk.invoicesys.service.InvoiceService;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
	
	@Autowired
	private InvoiceService invoiceService;

    private final Logger log = LoggerFactory.getLogger(getClass());
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/create")
	public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request){

		log.info("Create_Invoice :{}", request);
		InvoiceResponse createdInvoice = invoiceService.createInvoice(request);
		return new ResponseEntity<>(createdInvoice, HttpStatus.CREATED);
		
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping(value = "/view")
	public ResponseEntity<List<Invoice>> getInvoiceList(){

		log.info("Fetch_Invoices_List");
		List<Invoice> response = invoiceService.getInvoiceList();
		return new ResponseEntity<>(response, HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param id
	 * @param request
	 * @return
	 */
	@PutMapping(value = "/payments/{id}")
	public ResponseEntity<InvoiceResponse> payInvoice(@PathVariable int id, @RequestBody InvoiceRequest request){

		log.info("Pay_Invoice :{}", request);
		InvoiceResponse paidInvoice = invoiceService.payInvoice(id, request);
		return new ResponseEntity<>(paidInvoice, HttpStatus.OK);
		
	}
	
	/**
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/process-overdue")
	public void processOverdueInvoices(@RequestBody InvoiceRequest request){

		log.info("Process_Overdue_Invoices :{}", request);
		invoiceService.processOverdueInvoices();		
	}

}
