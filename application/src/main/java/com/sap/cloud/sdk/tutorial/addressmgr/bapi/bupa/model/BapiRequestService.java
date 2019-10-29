/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceConfiguration;
import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceDecorator;
import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceRuntimeException;
import com.sap.cloud.sdk.s4hana.connectivity.exception.RequestExecutionException;

import javax.annotation.Nonnull;


public class BapiRequestService {
    private final Destination destination;

    public BapiRequestService(final Destination destination) {
        this.destination = destination;
    }

    /**
     * Calls the test BAPI to get data.
     *
     * @return Result of test BAPI.
     */
    @Nonnull
    public BusinessPartnerGetRelationshipsFunctionResult getData() {
        return ResilienceDecorator.decorateSupplier(() -> {
            try {
                return execute();
            } catch (final RequestExecutionException e) {
                throw new ResilienceRuntimeException(e);
            }
        }, ResilienceConfiguration.of(BapiRequestService.class)).get();
    }

    private BusinessPartnerGetRelationshipsFunctionResult execute()
            throws RequestExecutionException {
        final BusinessPartnerNumber businessPartnerNumber = BusinessPartnerNumber.of("17397");
        return new DefaultBusinessPartnerGetRelationshipsService().getAllBPRelationships().businessPartner(businessPartnerNumber).execute(
                destination);
    }
}
