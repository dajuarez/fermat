package com.bitdubai.wallet_platform_core.layer._11_module.wallet_runtime.developer.bitdubai.version_1.transaction;

import com.bitdubai.wallet_platform_api.layer._1_definition.money.CryptoMoney;

/**
 * Created by ciencias on 22.12.14.
 */
public class OnlyCryptoWithSystemUser implements TransactionWithSystemUser, OnlyCryptoTransaction {

    private CryptoMoney mCryptoMoney;

}
