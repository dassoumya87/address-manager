/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.sap.cloud.sdk.s4hana.serialization.ErpTypeConverter;
import com.sap.cloud.sdk.s4hana.serialization.StringBasedErpType;
import com.sap.cloud.sdk.s4hana.serialization.StringBasedErpTypeConverter;

import javax.annotation.Nonnull;

/**
 * Field in parameter
 * 
 * <pre>
 *  Element: BAPI_FLD
 *  Domain: FDNAME
 *  Length: 30
 *  Type: C
 *  Decimals: 0
 * </pre>
 * 
 */
public class FieldInParameter extends StringBasedErpType<FieldInParameter>
{
    private static final long serialVersionUID = -516734032330L;

    public FieldInParameter( final String value )
    {
        super(value, CharCasing.UPPER_CASE);
    }

    @Nonnull
    public static FieldInParameter of( final String value )
    {
        return new FieldInParameter(value);
    }

    @Nonnull
    @Override
    public ErpTypeConverter<FieldInParameter> getTypeConverter()
    {
        return new StringBasedErpTypeConverter<FieldInParameter>(FieldInParameter.class);
    }

    @Nonnull
    @Override
    public Class<FieldInParameter> getType()
    {
        return FieldInParameter.class;
    }

    @Override
    public int getMaxLength()
    {
        return 30;
    }

    @Nonnull
    @Override
    public FillCharStrategy getFillCharStrategy()
    {
        return FillCharStrategy.DO_NOTHING;
    }
}
