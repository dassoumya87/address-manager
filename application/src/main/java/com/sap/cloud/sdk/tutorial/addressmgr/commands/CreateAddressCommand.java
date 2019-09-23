package com.sap.cloud.sdk.tutorial.addressmgr.commands;

import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerAddress;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.DefaultBusinessPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreateAddressCommand {
    private static final Logger logger = LoggerFactory.getLogger(CreateAddressCommand.class);

    private final BusinessPartnerService businessPartnerService;
    private final BusinessPartnerAddress addressToCreate;

    private final ErpHttpDestination destination;

    public CreateAddressCommand(ErpHttpDestination destination, BusinessPartnerAddress addressToCreate) {
        this(destination, new DefaultBusinessPartnerService(), addressToCreate);
    }


    public CreateAddressCommand(ErpHttpDestination destination, BusinessPartnerService businessPartnerService, BusinessPartnerAddress addressToCreate) {
        this.destination = destination;
        this.businessPartnerService = businessPartnerService;
        this.addressToCreate = addressToCreate;
    }

    public BusinessPartnerAddress execute() throws Exception {
        return businessPartnerService
                .createBusinessPartnerAddress(addressToCreate)
                .execute(destination);

    }
}
