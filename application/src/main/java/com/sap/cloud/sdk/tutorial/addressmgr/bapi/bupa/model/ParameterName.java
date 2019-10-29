/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.sap.cloud.sdk.s4hana.serialization.ErpTypeConverter;
import com.sap.cloud.sdk.s4hana.serialization.StringBasedErpType;
import com.sap.cloud.sdk.s4hana.serialization.StringBasedErpTypeConverter;

import javax.annotation.Nonnull;

/**
 * Parameter Name
 * 
 * <pre>
 *  Element: BAPI_PARAM
 *  Domain: SWC_ELEM
 *  Length: 32
 *  Type: C
 *  Decimals: 0
 * </pre>
 * 
 */
public class ParameterName extends StringBasedErpType<ParameterName>
{

    private static final long serialVersionUID = -516826400218L;

    public ParameterName(final String value )
    {
        super(value, CharCasing.UPPER_CASE);
    }

    @Nonnull
    public static ParameterName of( final String value )
    {
        return new ParameterName(value);
    }

    @Nonnull
    @Override
    public ErpTypeConverter<ParameterName> getTypeConverter()
    {
        return new StringBasedErpTypeConverter<ParameterName>(ParameterName.class);
    }

    @Nonnull
    @Override
    public Class<ParameterName> getType()
    {
        return ParameterName.class;
    }

    @Override
    public int getMaxLength()
    {
        return 32;
    }

    @Nonnull
    @Override
    public FillCharStrategy getFillCharStrategy()
    {
        return FillCharStrategy.DO_NOTHING;
    }

}
