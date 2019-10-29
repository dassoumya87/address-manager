package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import java.util.List;

public interface BusinessPartnerGetRelationshipsFunctionResult {
    ReturnParameter getMessage();

    List<BusinessPartnerRelationships> getAllBPRelationships();


}
