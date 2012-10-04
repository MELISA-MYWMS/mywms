package de.linogistix.los.inventory.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import de.linogistix.los.query.BODTO;
import de.linogistix.los.query.BODTOConstructorProperty;
import de.linogistix.los.inventory.model.LOSFuelOrderLog;
import de.linogistix.los.inventory.query.dto.LOSFuelOrderLogTO;
import de.linogistix.los.query.BusinessObjectQueryBean;
import de.linogistix.los.query.TemplateQueryWhereToken;

@Stateless
public class LOSFuelOrderLogQueryBean extends
    BusinessObjectQueryBean<LOSFuelOrderLog> implements
    LOSFuelOrderLogQueryRemote {

		private static final String[] props = new String[] {
			"id", "version", "transactionId",
				//, "vehicle.labelId"
				"storLoc.name", "stationPump",
				"receipient.identityCard", 
				//"rcptPos.id", 
				"orderType", "tankRemaining", 
				//"vehicle.plateNumber",
				"receipient.firstName", "receipient.rank", "receipient.lastName"
				//"rcptPos.articleRef", "rcptPos.articleDescr"
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
		//return new String[]{};
    }
	/*@Override
	protected List<BODTOConstructorProperty> getBODTOConstructorProperties() {
		List<BODTOConstructorProperty> propList = super.getBODTOConstructorProperties();
		
		propList.add(new BODTOConstructorProperty("id", false));
		propList.add(new BODTOConstructorProperty("version", false));
		propList.add(new BODTOConstructorProperty("transactionId", false));
		propList.add(new BODTOConstructorProperty("vehicle.labelId", true));
		propList.add(new BODTOConstructorProperty("storLoc.name", true));
		propList.add(new BODTOConstructorProperty("stationPump", true));
		propList.add(new BODTOConstructorProperty("receipient.identityCard", true));
		propList.add(new BODTOConstructorProperty("rcptPos.id", true));
		propList.add(new BODTOConstructorProperty("orderType", true));
		
		propList.add(new BODTOConstructorProperty("tankRemaining", true));
		propList.add(new BODTOConstructorProperty("vehicle.plateNumber", true));
		propList.add(new BODTOConstructorProperty("receipient.firstName", true));
		propList.add(new BODTOConstructorProperty("receipient.rank", true));
		propList.add(new BODTOConstructorProperty("receipient.lastName", true));
		propList.add(new BODTOConstructorProperty("rcptPos.articleRef", true));
		propList.add(new BODTOConstructorProperty("rcptPos.articleDescr", true));
		return propList;
	}*/

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
