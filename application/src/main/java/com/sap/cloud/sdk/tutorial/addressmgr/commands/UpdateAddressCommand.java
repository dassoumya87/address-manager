package com.sap.cloud.sdk.tutorial.addressmgr.commands;

import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerAddress;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.DefaultBusinessPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UpdateAddressCommand {
    private static final Logger logger = LoggerFactory.getLogger(UpdateAddressCommand.class);

    private final BusinessPartnerService businessPartnerService;
    private final BusinessPartnerAddress addressToUpdate;
    private final ErpHttpDestination destination;


    public UpdateAddressCommand(ErpHttpDestination destination, BusinessPartnerAddress addressToUpdate) {
        this(destination, new DefaultBusinessPartnerService(), addressToUpdate);
    }


    public UpdateAddressCommand(ErpHttpDestination destination, BusinessPartnerService businessPartnerService, BusinessPartnerAddress addressToUpdate) {
        this.destination = destination;
        this.businessPartnerService = businessPartnerService;
        this.addressToUpdate = addressToUpdate;
    }

    public Integer execute() throws Exception {
        // replace with code lines from Exercise 05
        return null;
    }
}
