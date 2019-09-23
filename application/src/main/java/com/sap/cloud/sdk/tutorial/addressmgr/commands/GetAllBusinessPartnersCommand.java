package com.sap.cloud.sdk.tutorial.addressmgr.commands;

import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.datamodel.odata.helper.Order;
import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.connectivity.DefaultErpHttpDestination;
import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class GetAllBusinessPartnersCommand {
    private static final Logger logger = LoggerFactory.getLogger(GetAllBusinessPartnersCommand.class);
    private static final String CATEGORY_PERSON = "1";
    private final BusinessPartnerService businessPartnerService;

    private static final String DESTINATION_NAME = "S4HC_SYSTEM";
    final ErpHttpDestination destination = DestinationAccessor.getDestination(DESTINATION_NAME)
            .asHttp().decorate(DefaultErpHttpDestination::new);

    public GetAllBusinessPartnersCommand(final BusinessPartnerService service) {
        businessPartnerService = service;
    }

    public List<BusinessPartner> execute() throws ODataException {
        return businessPartnerService
                .getAllBusinessPartner()
                .select(BusinessPartner.BUSINESS_PARTNER,
                        BusinessPartner.LAST_NAME,
                        BusinessPartner.FIRST_NAME)
                .filter(BusinessPartner.BUSINESS_PARTNER_CATEGORY.eq(CATEGORY_PERSON))
                .orderBy(BusinessPartner.LAST_NAME, Order.ASC)
                .execute(destination);

    }
}
