package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.sap.cloud.sdk.s4hana.serialization.ErpTypeConverter;
import com.sap.cloud.sdk.s4hana.serialization.StringBasedErpType;
import com.sap.cloud.sdk.s4hana.serialization.StringBasedErpTypeConverter;

import javax.annotation.Nonnull;


/**
 * Business Partner Number
 *
 * <pre>
 *  Element: BU_PARTNER
 *  Domain: BU_PARTNER
 *  Length: 10
 *  Type: C
 *  Decimals: 0
 * </pre>
 */
public class BusinessPartnerNumber extends StringBasedErpType<BusinessPartnerNumber> {
    private static final long serialVersionUID = -516173428507L;

    public BusinessPartnerNumber(final String value) {
        super(value, CharCasing.UPPER_CASE);
    }

    @Nonnull
    public static BusinessPartnerNumber of(final String value) {
        return new BusinessPartnerNumber(value);
    }

    @Nonnull
    @Override
    public ErpTypeConverter<BusinessPartnerNumber> getTypeConverter() {
        return new StringBasedErpTypeConverter<BusinessPartnerNumber>(BusinessPartnerNumber.class);
    }

    @Nonnull
    @Override
    public Class<BusinessPartnerNumber> getType() {
        return BusinessPartnerNumber.class;
    }

    @Override
    public int getMaxLength() {
        return 10;
    }

    @Nonnull
    @Override
    public FillCharStrategy getFillCharStrategy() {
        return FillCharStrategy.FILL_LEADING;
    }
}
