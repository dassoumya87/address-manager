package com.sap.cloud.sdk.tutorial.addressmgr.bapi.bupa.model;

import com.google.gson.Gson;
import com.sap.cloud.sdk.cloudplatform.connectivity.DestinationAccessor;
import com.sap.cloud.sdk.s4hana.connectivity.DefaultErpHttpDestination;
import com.sap.cloud.sdk.s4hana.connectivity.ErpHttpDestination;
import com.sap.cloud.sdk.tutorial.addressmgr.BusinessPartnerServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bapi")
public class BapiRequestServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(BusinessPartnerServlet.class);

    private static final String CATEGORY_PERSON = "1";
    private final ErpHttpDestination destination = DestinationAccessor.getDestination("ErpQueryEndpoint").asHttp().decorate(DefaultErpHttpDestination::new);

    @Override
    protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        //            final List<BusinessPartner> businessPartners =
//                    new DefaultBusinessPartnerService()
//                            .getAllBusinessPartner()
//                            .select(BusinessPartner.BUSINESS_PARTNER,
//                                    BusinessPartner.LAST_NAME,
//                                    BusinessPartner.FIRST_NAME,
//                                    BusinessPartner.IS_MALE,
//                                    BusinessPartner.IS_FEMALE,
//                                    BusinessPartner.CREATION_DATE)
//                            .filter(BusinessPartner.BUSINESS_PARTNER_CATEGORY.eq(CATEGORY_PERSON))
//                            .orderBy(BusinessPartner.LAST_NAME, Order.ASC)
//                            .top(200)
//                            .execute(destination);

//        final BusinessPartnerGetRelationshipsFunctionResult result =
//                new BapiRequestService(DestinationAccessor.tryGetDestination("er9001").get()).getData();
        final BusinessPartnerGetRelationshipsFunctionResult result =
                new BapiRequestService(DestinationAccessor.tryGetDestination("ER9_BAPI_TEST").get()).getData();

        final List<BusinessPartnerRelationships> bpRelationships =
                result.getAllBPRelationships();
        if( bpRelationships.isEmpty() ) {
            final ReturnParameter returnParameter = result.getMessage();
            final String message = returnParameter.getMessage();

            if( message == null || message.trim().isEmpty() ) {
                logger.error("Unexpected BAPI return parameter: " + returnParameter + ".");
               // return null;
            }
        }
        response.setContentType("application/json");
        response.getWriter().write(new Gson().toJson(bpRelationships));
    }
}
