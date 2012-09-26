package de.linogistix.los.inventory.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.linogistix.los.inventory.model.LOSFuelOrderLog;
import de.linogistix.los.inventory.query.dto.LOSFuelOrderLogTO;
import de.linogistix.los.query.BusinessObjectQueryBean;
import de.linogistix.los.query.TemplateQueryWhereToken;

@Stateless
public class LOSFuelOrderLogQueryBean extends
		BusinessObjectQueryBean<LOSFuelOrderLog> implements
		LOSFuelOrderLogQueryRemote {

	private static final String[] props = new String[]{
		"id", "version", "transactionId", "vehicle.labelId","storLoc.name", "stationPump",
		"receipient.identityCard", "rcptPos.id", "orderType", "tankRemaining", "vehicle.plateNumber",
		"receipient.firstName", "receipient.rank", "receipient.lastName", "rcptPos.articleRef", "rcptPos.articleDescr"
	};
	
			
			
	@Override
	public String getUniqueNameProp() {
		return "transactionId";
	}

	@Override
	public Class<LOSFuelOrderLogTO> getBODTOClass() {
		return LOSFuelOrderLogTO.class;
	}
	
	@Override
	protected String[] getBODTOConstructorProps() {
		return props;
	}
	
	@Override
	protected List<TemplateQueryWhereToken> getAutoCompletionTokens(String value) {
 List<TemplateQueryWhereToken> ret = new ArrayList<TemplateQueryWhereToken>();

 	TemplateQueryWhereToken transactionId = new TemplateQueryWhereToken(
         TemplateQueryWhereToken.OPERATOR_LIKE, "transactionId",
         value);
     transactionId.setLogicalOperator(TemplateQueryWhereToken.OPERATOR_OR);
     ret.add(transactionId);

        return ret;

	}

}
