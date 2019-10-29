package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;


import com.sap.cloud.sdk.result.ElementName;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nonnull;

/**
 * SAP BP: BAPI Structure for BP Relationships
 *
 * <pre>
 *  Structure: BAPIBUS1006_RELATIONS
 * </pre>
 *
 */

@Builder
@Data
public class BusinessPartnerRelationships {
    /**
     * Field name: PARTNER1
     *
     * <pre>
     *  Type element: BU_PARTNER
     *  Domain name: BU_PARTNER
     *  Internal type: CHAR
     *  Description: Business Partner Number
     *  Max length: 10
     * </pre>
     *
     */
    @ElementName( "PARTNER1" )
    @Nonnull
    private BusinessPartnerNumber businessPartnerCompany;

    @ElementName( "PARTNER2" )
    @Nonnull
    private BusinessPartnerNumber businessPartnerPerson;

    @ElementName("RELATIONSHIPCATEGORY")
    private String relationshipCategory;

}
