package com.bitdubai.fermat_cbp_plugin.layer.business_transaction.customer_broker_crypto_sale.developer.bitdubai.version_1.exceptions;

import com.bitdubai.fermat_api.FermatException;

/**
 * Created by Yordin Alayn on 29.09.15.
 */
public class CantInsertRecordCustomerBrokerCryptoSaleBusinessTransactionException extends FermatException {
    public CantInsertRecordCustomerBrokerCryptoSaleBusinessTransactionException(String message, Exception cause, String context, String possibleReason) {
        super(message, cause, context, possibleReason);
    }
}
