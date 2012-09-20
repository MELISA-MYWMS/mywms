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
		"id", "version", "transactionId","labelId","vehicle.labelId","storLoc.name", "stationPump",
		"receipient.identityCard", "rcptPos.id", "orderType", "tankRemaining" 			
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

     
        TemplateQueryWhereToken labelId = new TemplateQueryWhereToken(
            TemplateQueryWhereToken.OPERATOR_LIKE, "labelId",
            value);
        labelId.setLogicalOperator(TemplateQueryWhereToken.OPERATOR_OR);
        ret.add(labelId);

        return ret;

		/*List<TemplateQueryWhereToken> ret =  new ArrayList<TemplateQueryWhereToken>();
		
		TemplateQueryWhereToken name = new TemplateQueryWhereToken(
				TemplateQueryWhereToken.OPERATOR_LIKE, "name",
				value);
		name.setLogicalOperator(TemplateQueryWhereToken.OPERATOR_OR);
		
		TemplateQueryWhereToken orderRef = new TemplateQueryWhereToken(
				TemplateQueryWhereToken.OPERATOR_LIKE, "orderReference",
				value);
		orderRef.setLogicalOperator(TemplateQueryWhereToken.OPERATOR_OR);
		
		TemplateQueryWhereToken orderNumber = new TemplateQueryWhereToken(
				TemplateQueryWhereToken.OPERATOR_LIKE, "orderNumber",
				value);
		orderNumber.setLogicalOperator(TemplateQueryWhereToken.OPERATOR_OR);
		
		
		ret.add(name);
		ret.add(orderNumber);
		ret.add(orderRef);
		
		return ret;*/
	}

}
