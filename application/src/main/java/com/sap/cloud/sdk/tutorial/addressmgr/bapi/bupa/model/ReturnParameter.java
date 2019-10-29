/*
 * Copyright (c) 2019 SAP SE or an SAP affiliate company. All rights reserved.
 */

package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.sap.cloud.sdk.result.ElementName;
import com.sap.cloud.sdk.s4hana.serialization.MessageClass;
import com.sap.cloud.sdk.s4hana.serialization.MessageNumber;
import lombok.Builder;
import lombok.Data;

import javax.annotation.Nullable;

/**
 * Return Parameter
 * 
 * <pre>
 *  Structure: BAPIRET2
 * </pre>
 * 
 */
@Builder
@Data
public class ReturnParameter
{

    /**
     * Field name: FIELD
     * 
     * <pre>
     *  Type element: BAPI_FLD
     *  Domain name: FDNAME
     *  Internal type: CHAR
     *  Description: Field in parameter
     *  Max length: 30
     * </pre>
     * 
     */
    @ElementName( "FIELD" )
    @Nullable
    private FieldInParameter field;
    /**
     * Field name: ID
     * 
     * <pre>
     *  Type element: SYMSGID
     *  Domain name: ARBGB
     *  Internal type: CHAR
     *  Description: Message Class
     *  Max length: 20
     * </pre>
     * 
     */
    @ElementName( "ID" )
    @Nullable
    private MessageClass id;
    /**
     * Field name: MESSAGE
     * 
     * <pre>
     *  Type element: BAPI_MSG
     *  Domain name: TEXT220
     *  Internal type: CHAR
     *  Description: Message Text
     *  Max length: 220
     * </pre>
     * 
     */
    @ElementName( "MESSAGE" )
    @Nullable
    private String message;
    /**
     * Field name: MESSAGE_V1
     * 
     * <pre>
     *  Type element: SYMSGV
     *  Domain name: SYCHAR50
     *  Internal type: CHAR
     *  Description: Message Variable
     *  Max length: 50
     * </pre>
     * 
     */
    @ElementName( "MESSAGE_V1" )
    @Nullable
    private String messageV1;
    /**
     * Field name: MESSAGE_V2
     * 
     * <pre>
     *  Type element: SYMSGV
     *  Domain name: SYCHAR50
     *  Internal type: CHAR
     *  Description: Message Variable
     *  Max length: 50
     * </pre>
     * 
     */
    @ElementName( "MESSAGE_V2" )
    @Nullable
    private String messageV2;
    /**
     * Field name: MESSAGE_V3
     * 
     * <pre>
     *  Type element: SYMSGV
     *  Domain name: SYCHAR50
     *  Internal type: CHAR
     *  Description: Message Variable
     *  Max length: 50
     * </pre>
     * 
     */
    @ElementName( "MESSAGE_V3" )
    @Nullable
    private String messageV3;
    /**
     * Field name: MESSAGE_V4
     * 
     * <pre>
     *  Type element: SYMSGV
     *  Domain name: SYCHAR50
     *  Internal type: CHAR
     *  Description: Message Variable
     *  Max length: 50
     * </pre>
     * 
     */
    @ElementName( "MESSAGE_V4" )
    @Nullable
    private String messageV4;
    /**
     * Field name: NUMBER
     * 
     * <pre>
     *  Type element: SYMSGNO
     *  Domain name: SYMSGNO
     *  Internal type: NUMC
     *  Description: Message Number
     *  Max length: 3
     * </pre>
     * 
     */
    @ElementName( "NUMBER" )
    @Nullable
    private MessageNumber number;
    /**
     * Field name: PARAMETER
     * 
     * <pre>
     *  Type element: BAPI_PARAM
     *  Domain name: SWC_ELEM
     *  Internal type: CHAR
     *  Description: Parameter Name
     *  Max length: 32
     * </pre>
     * 
     */
    @ElementName( "PARAMETER" )
    @Nullable
    private ParameterName parameter;
    /**
     * Field name: ROW
     * 
     * <pre>
     *  Type element: BAPI_LINE
     *  Domain name: INT4
     *  Internal type: INT4
     *  Description: Lines in parameter
     *  Max length: 4
     * </pre>
     * 
     */
    @ElementName( "ROW" )
    @Nullable
    private LinesInParameter row;
    /**
     * Field name: TYPE
     * 
     * <pre>
     *  Type element: BAPI_MTYPE
     *  Domain name: SYCHAR01
     *  Internal type: CHAR
     *  Description: Message type: S Success, E Error, W Warning, I Info, A Abort
     *  Max length: 1
     * </pre>
     * 
     */
    @ElementName( "TYPE" )
    @Nullable
    private String type;

    public void validate()
        throws IllegalArgumentException
    {
        if( (message != null) && (message.length() > 220) ) {
            throw new IllegalArgumentException(
                "Bapi method parameter \"message\" contains an invalid structure. Structure attribute \"MESSAGE\" / Function parameter \"message\" must have at most 220 characters. The given value is too long.");
        }
        if( (messageV1 != null) && (messageV1.length() > 50) ) {
            throw new IllegalArgumentException(
                "Bapi method parameter \"messageV1\" contains an invalid structure. Structure attribute \"MESSAGE_V1\" / Function parameter \"messageV1\" must have at most 50 characters. The given value is too long.");
        }
        if( (messageV2 != null) && (messageV2.length() > 50) ) {
            throw new IllegalArgumentException(
                "Bapi method parameter \"messageV2\" contains an invalid structure. Structure attribute \"MESSAGE_V2\" / Function parameter \"messageV2\" must have at most 50 characters. The given value is too long.");
        }
        if( (messageV3 != null) && (messageV3.length() > 50) ) {
            throw new IllegalArgumentException(
                "Bapi method parameter \"messageV3\" contains an invalid structure. Structure attribute \"MESSAGE_V3\" / Function parameter \"messageV3\" must have at most 50 characters. The given value is too long.");
        }
        if( (messageV4 != null) && (messageV4.length() > 50) ) {
            throw new IllegalArgumentException(
                "Bapi method parameter \"messageV4\" contains an invalid structure. Structure attribute \"MESSAGE_V4\" / Function parameter \"messageV4\" must have at most 50 characters. The given value is too long.");
        }
        if( (type != null) && (type.length() > 1) ) {
            throw new IllegalArgumentException(
                "Bapi method parameter \"type\" contains an invalid structure. Structure attribute \"TYPE\" / Function parameter \"type\" must have at most 1 characters. The given value is too long.");
        }
    }

}
