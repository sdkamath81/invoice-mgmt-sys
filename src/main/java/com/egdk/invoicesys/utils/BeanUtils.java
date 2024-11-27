package com.egdk.invoicesys.utils;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.springframework.stereotype.Component;

import com.egdk.invoicesys.dto.InvoiceRequest;
import com.egdk.invoicesys.dto.InvoiceResponse;
import com.egdk.invoicesys.model.Invoice;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class BeanUtils {
	
	public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
	
	 public static Date convertDateStrToDate(String dateStr) {
	        DateFormat formatter = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
	        Date date = null;
	        if (null != dateStr) {
	            try {
	                date = formatter.parse(dateStr);
	            } catch (ParseException e) {
	                e.printStackTrace();
	            }
	        }
	        return date;
	    }
	 
	 public static Date addDaysToCurrentDate(Date date) {
		 final Calendar cal = new GregorianCalendar();
	        cal.setTime(date);
	        cal.add(Calendar.DAY_OF_MONTH, 10);
	        Date next10Days = cal.getTime();
	        return next10Days;
	    }
	 
	 public static String convertDateToString(Date date) {
	        DateFormat df = new SimpleDateFormat(DATE_FORMAT_YYYY_MM_DD);
	        return df.format(date);
	    }

	 public Invoice mapToEntity(InvoiceRequest request) {
			
			Invoice invoice = new Invoice();
			invoice.setAmount(request.getAmount());
			invoice.setDueDate(convertDateStrToDate(request.getDue_date()));
		    invoice.setLateFee(request.getLate_fee());
			return invoice;
			
		}
		
	 public InvoiceResponse mapToResponse(Invoice invoice) {
			
			InvoiceResponse response = new InvoiceResponse();
			response.setId(invoice.getId());
			response.setAmount(invoice.getAmount());
			response.setDue_date(String.valueOf(invoice.getDueDate()));
			if(null != invoice.getPaidAmount()){
				response.setPaid_amount(invoice.getPaidAmount());
			}
			response.setStatus(invoice.getStatus());
			return response;
			
		}
}
