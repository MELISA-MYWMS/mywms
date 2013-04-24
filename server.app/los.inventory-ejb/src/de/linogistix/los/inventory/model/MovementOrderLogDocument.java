/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.los.inventory.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.mywms.model.Document;

/**
 * 
 * @author MELISA
 */
@Entity
@Table(name = "los_MovementOrderLogBook"
// , uniqueConstraints = {
// @UniqueConstraint(columnNames = {
// "BookDocumentID"
// })}
)
public class MovementOrderLogDocument extends Document {

	private static final long serialVersionUID = 1L;

	private String bookDocumentID;

	private String organization;

	private Date dateFrom;

	private Date dateTo;

	@Column(nullable = false)
	public String getBookDocumentID() {
		return bookDocumentID;
	}

	public void setBookDocumentID(String bookDocumentID) {
		this.bookDocumentID = bookDocumentID;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

}
