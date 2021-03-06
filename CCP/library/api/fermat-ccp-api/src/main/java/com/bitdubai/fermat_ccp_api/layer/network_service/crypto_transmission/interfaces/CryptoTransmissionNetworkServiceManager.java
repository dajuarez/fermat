package com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.interfaces;

import com.bitdubai.fermat_api.layer.all_definition.enums.CryptoCurrency;
import com.bitdubai.fermat_api.layer.all_definition.enums.TransactionMetadataState;
import com.bitdubai.fermat_api.layer.all_definition.transaction_transference_protocol.TransactionSender;
import com.bitdubai.fermat_api.layer.all_definition.transaction_transference_protocol.crypto_transactions.FermatCryptoTransaction;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CantAcceptCryptoRequestException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CantConfirmMetaDataNotificationException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CantGetMetadataNotificationsException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CantGetTransactionStateException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CantSetToCreditedInWalletException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CantSetToSeenByCryptoVaultException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.exceptions.CouldNotTransmitCryptoException;
import com.bitdubai.fermat_ccp_api.layer.network_service.crypto_transmission.interfaces.structure.CryptoTransmissionMetadata;

import java.util.List;
import java.util.UUID;

/**
 * The interface <code>CryptoTransmissionNetworkServiceManager</code>
 * provides the methods to send and receive meta information of crypto transactions.
 */
public interface CryptoTransmissionNetworkServiceManager extends TransactionSender<FermatCryptoTransaction>{

    /**
     * The method <code>informTransactionCreditedInWallet</code> informs the peer network service
     * that sent the transaction that the said transaction has been credited in its destination wallet.
     *
     * @param transmissionId an identifier of the transmission
     * @throws CantSetToCreditedInWalletException
     */
    public void informTransactionCreditedInWallet(UUID transmissionId) throws CantSetToCreditedInWalletException;

    /**
     * The method <code>informTransactionSeenByVault</code> informs the peer network service that sent
     * the identified transaction that the transaction has been registered by the crypto vault in
     * this device
     *
     * @param transmissionId an identifier of the transmission
     * @throws CantSetToSeenByCryptoVaultException
     */
    public void informTransactionSeenByVault(UUID transmissionId) throws CantSetToSeenByCryptoVaultException;

    /**
     * The method <code>getState</code> returns the status of the transmission sent.
     *
     * @param identifier an identifier of the transmission, it could be the requestId or a transmissionId
     * @return the status of the transmission
     * @throws CantGetTransactionStateException
     */
    public TransactionMetadataState getState(UUID identifier) throws CantGetTransactionStateException;

    /**
     * The method <code>acceptCryptoRequest</code> sends the meta information associated to a crypto
     * transaction through the fermat network services as an answer to a payment request
     *
     * @param transmissionId                  The identifier of the transmission generated by the transactional layer
     * @param requestId                       The identifier of the payment request that created this transaction
     * @param cryptoCurrency                  The crypto currency of the payment
     * @param cryptoAmount                    The crypto amount being sent
     * @param senderPublicKey                 The public key of the sender of the payment
     * @param destinationPublicKey            The public key of the destination of a payment
     * @param associatedCryptoTransactionHash The hash of the crypto transaction associated with this meta information
     * @param paymentDescription              The description of the payment
     * @throws CantAcceptCryptoRequestException
     */
    public void acceptCryptoRequest(UUID transmissionId,
                                    UUID requestId,
                                    CryptoCurrency cryptoCurrency,
                                    long cryptoAmount,
                                    String senderPublicKey,
                                    String destinationPublicKey,
                                    String associatedCryptoTransactionHash,
                                    String paymentDescription) throws CantAcceptCryptoRequestException;


    /**
     * The method <code>sendCrypto</code> sends the meta information associated to a crypto transaction
     * through the fermat network services
     *
     * @param transmissionId                  The identifier of the transmission generated by the transactional layer
     * @param cryptoCurrency                  The crypto currency of the payment
     * @param cryptoAmount                    The crypto amount being sent
     * @param senderPublicKey                 The public key of the sender of the payment
     * @param destinationPublicKey            The public key of the destination of a payment
     * @param associatedCryptoTransactionHash The hash of the crypto transaction associated with this meta information
     * @param paymentDescription              The description of the payment
     * @throws CouldNotTransmitCryptoException
     */
    public void sendCrypto(UUID transmissionId,
                           CryptoCurrency cryptoCurrency,
                           long cryptoAmount,
                           String senderPublicKey,
                           String destinationPublicKey,
                           String associatedCryptoTransactionHash,
                           String paymentDescription
    ) throws CouldNotTransmitCryptoException;

    /**
     *The method <code>getPendingNotifications</code> returns a list of meta information associated to a crypto transaction pending to process with plugin
     * @return List of CryptoTransmissionMetadata
     * @throws CantGetMetadataNotificationsException
     */

     List<CryptoTransmissionMetadata> getPendingNotifications() throws CantGetMetadataNotificationsException;

    /**
     *The method <code>sendCrypto</code> sends the meta information associated to a crypto transaction
     * @param notificationID
     * @throws CantConfirmMetaDataNotificationException
     */

     void confirmNotification(final UUID notificationID) throws CantConfirmMetaDataNotificationException;
}
