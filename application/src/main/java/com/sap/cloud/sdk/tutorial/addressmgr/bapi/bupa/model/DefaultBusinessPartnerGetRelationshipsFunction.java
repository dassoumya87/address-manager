package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.google.common.collect.Lists;
import com.sap.cloud.sdk.cloudplatform.connectivity.Destination;
import com.sap.cloud.sdk.s4hana.connectivity.exception.RequestExecutionException;
import com.sap.cloud.sdk.s4hana.connectivity.rfc.BapiRequest;
import com.sap.cloud.sdk.s4hana.connectivity.rfc.BapiRequestResult;
import lombok.*;
import lombok.experimental.Accessors;

import javax.annotation.Nonnull;

@ToString
@EqualsAndHashCode
@Accessors( fluent = true )
@RequiredArgsConstructor( access = AccessLevel.PUBLIC )
public class DefaultBusinessPartnerGetRelationshipsFunction implements BusinessPartnerGetRelationshipsFunction {

    @Setter
//    @Nonnull
    private BusinessPartnerNumber businessPartnerNumber;

    @Nonnull
    @Override
    public BusinessPartnerGetRelationshipsFunctionResult execute(Destination destination) throws RequestExecutionException {
        final BapiRequest request = toRequest();
        final BapiRequestResult requestResult = request.execute(destination);
        return new DefaultBusinessPartnerGetRelationshipsFunctionResult(requestResult);
    }

    @Nonnull
    @Override
    public BapiRequest toRequest() {
            final BapiRequest request = new BapiRequest("BAPI_BUPA_RELATIONSHIPS_GET");

        request.withExporting("BUSINESSPARTNER", "BAPIBUS1006_HEAD-BPARTNER", businessPartnerNumber);

        request.withTableAsReturn("RELATIONSHIPS", "BAPIBUS1006_RELATIONS");
        request.withTableAsReturn("RETURN", "BAPIRET2");
        return request;
    }

    @Override
    public BusinessPartnerGetRelationshipsFunction businessPartner(final BusinessPartnerNumber businessPartner){
        businessPartnerNumber = businessPartner;
        return this;
    }
}
