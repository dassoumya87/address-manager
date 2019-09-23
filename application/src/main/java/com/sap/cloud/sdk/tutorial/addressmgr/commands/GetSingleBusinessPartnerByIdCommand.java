package com.sap.cloud.sdk.tutorial.addressmgr.commands;

import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceConfiguration;
import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceDecorator;
import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceIsolationMode;
import com.sap.cloud.sdk.cloudplatform.resilience.ResilienceRuntimeException;
import com.sap.cloud.sdk.odatav2.connectivity.ODataException;
import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestinationUtils;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartner;
import com.sap.cloud.sdk.s4hana.datamodel.odata.namespaces.businesspartner.BusinessPartnerAddress;
import com.sap.cloud.sdk.s4hana.datamodel.odata.services.BusinessPartnerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class GetSingleBusinessPartnerByIdCommand {

    private static final Logger logger = LoggerFactory.getLogger(GetSingleBusinessPartnerByIdCommand.class);
    private static final String CATEGORY_PERSON = "1";

    private final BusinessPartnerService businessPartnerService;
    private final ResilienceConfiguration myResilienceConfig;

    private final String id;

    private static final String DESTINATION_NAME = "S4HC_SYSTEM";

    final ErpHttpDestination destination = ErpHttpDestinationUtils
            .getErpHttpDestination(DESTINATION_NAME);


    public GetSingleBusinessPartnerByIdCommand(final BusinessPartnerService service, final String id) {
        businessPartnerService = service;
        this.id = id;

        //Resilience Configuration
        myResilienceConfig = ResilienceConfiguration.of(BusinessPartnerService.class)
                .isolationMode(ResilienceIsolationMode.TENANT_AND_USER_OPTIONAL)
                .timeLimiterConfiguration(
                        ResilienceConfiguration.TimeLimiterConfiguration.of()
                                .timeoutDuration(Duration.ofMinutes(5)))
                .bulkheadConfiguration(
                        ResilienceConfiguration.BulkheadConfiguration.of()
                                .maxConcurrentCalls(20));

    }


    public BusinessPartner execute() {
        return ResilienceDecorator.executeSupplier(this::run, myResilienceConfig, e -> {
            logger.warn("Fallback called because of exception.", e);
            return new BusinessPartner();
        });
    }

    private BusinessPartner run() {
        try {
            return businessPartnerService.getBusinessPartnerByKey(id)
                    .select(BusinessPartner.BUSINESS_PARTNER,
                            BusinessPartner.LAST_NAME,
                            BusinessPartner.FIRST_NAME,
                            BusinessPartner.IS_MALE,
                            BusinessPartner.IS_FEMALE,
                            BusinessPartner.CREATION_DATE,
                            BusinessPartner.TO_BUSINESS_PARTNER_ADDRESS.select(
                                    BusinessPartnerAddress.BUSINESS_PARTNER,
                                    BusinessPartnerAddress.ADDRESS_ID,
                                    BusinessPartnerAddress.COUNTRY,
                                    BusinessPartnerAddress.POSTAL_CODE, BusinessPartnerAddress.CITY_NAME,
                                    BusinessPartnerAddress.STREET_NAME,
                                    BusinessPartnerAddress.HOUSE_NUMBER))
                    .execute(destination);
        } catch (ODataException e) {
            throw new ResilienceRuntimeException(e);
        }
    }

}
