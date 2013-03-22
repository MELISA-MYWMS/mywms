/*
 * Copyright (c) 2006 - 2010 LinogistiX GmbH
 * 
 *  www.linogistix.com
 *  
 *  Project myWMS-LOS
 */
package de.linogistix.los.inventory.report;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import net.sf.jasperreports.engine.design.JasperDesign;

import org.apache.log4j.Logger;
import org.mywms.globals.DocumentTypes;
import org.mywms.model.Client;
import org.mywms.model.Lot;
import org.mywms.model.StockUnit;

import de.linogistix.los.inventory.businessservice.LOSGoodsReceiptComponent;
import de.linogistix.los.inventory.model.MovementOrderLog;
import de.linogistix.los.location.model.LOSStorageLocation;
import de.linogistix.los.inventory.model.MovementOrderLogDocument;
import de.linogistix.los.inventory.report.MovementOrderLogReport;
import de.linogistix.los.inventory.query.MovementOrderLogQueryRemote;
import de.linogistix.los.inventory.res.InventoryBundleResolver;
import de.linogistix.los.inventory.service.MovementOrderLogService;
import de.linogistix.los.query.BODTO;
import de.linogistix.los.report.businessservice.ReportException;
import de.linogistix.los.report.businessservice.ReportService;
import de.linogistix.los.report.businessservice.ReportServiceBean;
import de.linogistix.los.util.businessservice.ContextService;

@Stateless
public class MovementOrderLogReportBean implements MovementOrderLogReport {

	private static final Logger log = Logger
			.getLogger(MovementOrderLogReport.class);

	@EJB
	MovementOrderLogService MovementOrderLogService;
	@EJB
	ReportService repService;
	@EJB
	ContextService contextService;
	@EJB
	MovementOrderLogQueryRemote MovementOrderLogQuery;

	@PersistenceContext(unitName = "myWMS")
	protected EntityManager manager;

	public MovementOrderLogDocument printMovementOrderLogReport(
			String organization, Date LogDateFrom,
			Date LogDateTo, String printer) throws ReportException {

		String type = DocumentTypes.APPLICATION_PDF.toString();

		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		String documentName = organization;
		documentName += dateFormat.format(date);

		DateFormat dateFormatID = new SimpleDateFormat("yyyyMMddHHmmss");
		String documentID = organization;
		documentID += "_";
		documentID += dateFormatID.format(date);

		MovementOrderLogDocument l = new MovementOrderLogDocument();
		l.setName(documentName);
		l.setBookDocumentID(documentID);
		l.setType(type);

		l.setDateFrom(LogDateFrom);
		l.setDateTo(LogDateTo);

		if (type.equals(DocumentTypes.APPLICATION_PDF.toString())) {
			JasperDesign d;
			List<MovementOrderLog> export;
			//export = LOSFuelOrderLogQuery.queryByDate(LogDateFrom, LogDateTo);
			export = MovementOrderLogQuery.queryByDate(LogDateFrom, LogDateTo);

			if (repService == null) {
				repService = new ReportServiceBean();
			}

			Map<String, Object> parameters = new HashMap<String, Object>();

			//parameters.put("LOS_LOCATION", storageLocation.getName());
			parameters.put("LOS_DATE_FROM", LogDateFrom);
			parameters.put("LOS_DATE_TO", LogDateTo);

			try {
				d = repService.getJrxmlResource(InventoryBundleResolver.class,
						"LOSFuelOrderLogReport.jrxml");

				byte[] bytes = repService.typeExportPdf(l.getName(),
						l.getType(), d, export, parameters);
				l.setDocument(bytes);
			} catch (Throwable t) {
				log.error(t.getMessage(), t);
				throw new ReportException();
			}
		} else {
			throw new IllegalArgumentException("only pdf supported");

		}

		return l;
	}

}
