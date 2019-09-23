package com.sap.cloud.sdk.tutorial.addressmgr.commands;

import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestinationUtils;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class GetSingleBusinessPartnerByIdCommand {

    private static final Logger logger = LoggerFactory.getLogger(GetSingleBusinessPartnerByIdCommand.class);
    private static final String CATEGORY_PERSON = "1";

    private final BusinessPartnerService businessPartnerService;

    private final String id;

    private static final String DESTINATION_NAME = "S4HC_SYSTEM";

    final ErpHttpDestination destination = ErpHttpDestinationUtils
            .getErpHttpDestination(DESTINATION_NAME);


    public GetSingleBusinessPartnerByIdCommand(final BusinessPartnerService service, final String id) {
        businessPartnerService = service;
        this.id = id;
    }


    public BusinessPartner execute() throws Exception {
        // replace with code lines from Exercise 05
        return null;

    }
}
