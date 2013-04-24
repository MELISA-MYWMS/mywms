package de.linogistix.los.inventory.query;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import javax.ejb.Stateless;

import javax.persistence.Query;

import de.linogistix.los.inventory.model.MovementOrderLog;
import de.linogistix.los.inventory.query.dto.MovementOrderLogTO;
import de.linogistix.los.query.BusinessObjectQueryBean;
import de.linogistix.los.query.TemplateQueryWhereToken;

@Stateless
public class MovementOrderLogQueryBean extends
		BusinessObjectQueryBean<MovementOrderLog> implements
		MovementOrderLogQueryRemote {

	private static final String[] props = new String[] { "id", "version",
			"transactionId", "organization", "formation", "militaryUnit",
			"currDate", "vehicle", "movementDate", "orderNo",
			"movementPurpose", "movementRoute", "movementLoad", "driver",
			"passenger1Name", "passenger2Name", "passenger3Name",
			"passenger4Name" };

	@Override
	public String getUniqueNameProp() {
		return "transactionId";
	}

	@Override
	public Class<MovementOrderLogTO> getBODTOClass() {
		return MovementOrderLogTO.class;
	}

	@Override
	protected String[] getBODTOConstructorProps() {
		return props;
		// return new String[]{};
	}

	@Override
	protected List<TemplateQueryWhereToken> getAutoCompletionTokens(String value) {
		List<TemplateQueryWhereToken> ret = new ArrayList<TemplateQueryWhereToken>();

		TemplateQueryWhereToken transactionId = new TemplateQueryWhereToken(
				TemplateQueryWhereToken.OPERATOR_LIKE, "transactionId", value);
		transactionId.setLogicalOperator(TemplateQueryWhereToken.OPERATOR_OR);
		ret.add(transactionId);

		return ret;
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MovementOrderLog> queryByDate(Date createDateFrom,
			Date createDateTo) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("SELECT ");
		buffer.append(" r ");
		buffer.append(" FROM ");
		buffer.append(MovementOrderLog.class.getName());
		buffer.append(" r ");
		buffer.append(" WHERE ");
		// buffer.append(" r.created.date>=:dateFrom and r.created.date<=:dateTo");
		buffer.append(" r.created>=:dateFrom and r.created<=:dateTo");
		Query q = manager.createQuery(new String(buffer));
		q = q.setParameter("dateFrom", createDateFrom);
		q = q.setParameter("dateTo", createDateTo);

		return q.getResultList();
	}
}
