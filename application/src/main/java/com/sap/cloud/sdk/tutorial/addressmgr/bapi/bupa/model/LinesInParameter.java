/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.google.gson.annotations.Expose;
import com.sap.cloud.sdk.s4hana.serialization.ErpType;
import com.sap.cloud.sdk.s4hana.serialization.ErpTypeConverter;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.annotation.Nonnull;

/**
 * Lines in parameter
 * 
 * <pre>
 *  Element: BAPI_LINE
 *  Domain: INT4
 *  Length: 4
 *  Type: X
 *  Decimals: 0
 * </pre>
 * 
 */
@EqualsAndHashCode( of = "value" )
@RequiredArgsConstructor
@ToString
public class LinesInParameter implements ErpType<LinesInParameter>
{

    private static final long serialVersionUID = -519195271239L;
    @Getter
    @Expose
    @Nonnull
    private final byte[] value;

    @Nonnull
    @Override
    public ErpTypeConverter<LinesInParameter> getTypeConverter()
    {
        throw new UnsupportedOperationException("Conversion of byte arrays is currently not supported.");
    }

}
