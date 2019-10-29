package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.s4hana.connectivity.exception.RequestExecutionException;
import com.sap.cloud.sdk.s4hana.connectivity.rfc.BapiRequest;

import javax.annotation.Nonnull;


/**
 * SAP BP, BAPI: Determine All BP Relationships
 *
 * <pre>
 * BAPI_BUPA_RELATIONSHIPS_GET
 * </pre>
 *
 */
public interface BusinessPartnerGetRelationshipsFunction {

    @Nonnull
    BusinessPartnerGetRelationshipsFunctionResult execute(Destination destination)
            throws RequestExecutionException;

    @Nonnull
    BapiRequest toRequest();

    BusinessPartnerGetRelationshipsFunction businessPartner(BusinessPartnerNumber businessPartner);
}
