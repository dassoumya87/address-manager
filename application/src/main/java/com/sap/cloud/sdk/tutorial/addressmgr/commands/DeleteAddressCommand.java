package com.sap.cloud.sdk.tutorial.addressmgr.commands;

import com.sap.cloud.sdk.odatav2.connectivity.ODataDeleteResult;
import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerAddress;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.DefaultBusinessPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteAddressCommand {
    private static final Logger logger = LoggerFactory.getLogger(DeleteAddressCommand.class);

    private final BusinessPartnerService businessPartnerService;
    private final String businessPartnerId;
    private final String addressId;
    private final ErpHttpDestination destination;

    public DeleteAddressCommand(ErpHttpDestination destination,
                                String businessPartnerId, String addressId) {

        this(destination, new DefaultBusinessPartnerService(), businessPartnerId, addressId);
    }


    public DeleteAddressCommand(ErpHttpDestination destination, BusinessPartnerService businessPartnerService,
                                String businessPartnerId, String addressId) {
        this.destination = destination;
        this.businessPartnerService = businessPartnerService;
        this.businessPartnerId = businessPartnerId;
        this.addressId = addressId;
    }

    public Integer execute() throws Exception {
        final BusinessPartnerAddress addressToDelete = BusinessPartnerAddress.builder()
                .businessPartner(businessPartnerId)
                .addressID(addressId)
                .build();
        final ODataDeleteResult oDataDeleteResult = businessPartnerService
                .deleteBusinessPartnerAddress(addressToDelete)
                .execute(destination);
        return oDataDeleteResult.getHttpStatusCode();
    }
}
