package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.google.common.collect.Lists;
import com.sap.cloud.sdk.result.ResultElement;
import com.sap.cloud.sdk.s4hana.connectivity.rfc.BapiRequestResult;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.List;


@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class DefaultBusinessPartnerGetRelationshipsFunctionResult implements BusinessPartnerGetRelationshipsFunctionResult {

    private final BapiRequestResult result;

    @Override
    public ReturnParameter getMessage() {
        return result.get("RETURN").getAsObject().as(ReturnParameter.class);
    }

    @Override
    public List<BusinessPartnerRelationships> getAllBPRelationships() {
        final List<BusinessPartnerRelationships> list = Lists.newArrayList();
        for (final ResultElement row : result.get("RELATIONSHIPS").getAsCollection()) {
            list.add(row.getAsObject().as(BusinessPartnerRelationships.class));
        }
        return list;
    }
}
