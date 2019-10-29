package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

public class DefaultBusinessPartnerGetRelationshipsService implements BusinessPartnerGetRelationshipsService {
    @Override
    public BusinessPartnerGetRelationshipsFunction getAllBPRelationships() {
        return new DefaultBusinessPartnerGetRelationshipsFunction();
    }
}
