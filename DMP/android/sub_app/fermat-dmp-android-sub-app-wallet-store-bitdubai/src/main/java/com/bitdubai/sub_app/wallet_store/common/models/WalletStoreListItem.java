package com.bitdubai.sub_app.wallet_store.common.models;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.bitdubai.fermat_api.layer.all_definition.enums.WalletCategory;
import com.bitdubai.fermat_wpd_api.layer.wpd_middleware.wallet_store.enums.InstallationStatus;
import com.bitdubai.fermat_wpd_api.layer.wpd_sub_app_module.wallet_store.interfaces.WalletStoreCatalogueItem;
import com.wallet_store.bitdubai.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.bitdubai.fermat_wpd_api.layer.wpd_middleware.wallet_store.enums.InstallationStatus.INSTALLED;

/**
 * Created on 22/08/15.
 * Representa la informacion de un item de la lista de wallets que esta en el catalogo de la Wallet Store.
 *
 * @author Nelson Ramirez
 */
public class WalletStoreListItem implements Serializable {
    private static final long serialVersionUID = -8730067026050196759L;


    private InstallationStatus installationStatus;
    private String walletName;
    private String description;
    private Bitmap walletIcon;
    private UUID id;
    private WalletCategory category;
    private boolean testData;
    private int bannerWalletRes;
    private List<Integer> screenshots;


    /**
     * Crea un nuevo WalletStoreListItem
     *
     * @param catalogueItem un item del catalogo
     * @param res           resource object to generate the icon
     */
    public WalletStoreListItem(WalletStoreCatalogueItem catalogueItem, Resources res) {
        testData = false;

        id = catalogueItem.getId();

        category = catalogueItem.getCategory();

        walletName = catalogueItem.getName();

        description = catalogueItem.getDescription();

        installationStatus = catalogueItem.getInstallationStatus();

        try {
            byte[] iconBytes = catalogueItem.getIcon();
            walletIcon = BitmapFactory.decodeByteArray(iconBytes, 0, iconBytes.length);
        } catch (Exception e) {
            walletIcon = BitmapFactory.decodeResource(res, R.drawable.wallet_1);
        }

    }

    public int getBannerWalletRes() {
        return bannerWalletRes;
    }


    public String getDescription() {
        return description;
    }

    public WalletCategory getCategory() {
        return category;
    }

    public UUID getId() {
        return id;
    }

    public InstallationStatus getInstallationStatus() {
        return installationStatus;
    }

    public List<Integer> getScreenshots() {
        return screenshots;
    }

    public String getWalletName() {
        return walletName;
    }

    public Bitmap getWalletIcon() {
        return walletIcon;
    }


    private WalletStoreListItem(String walletName, String description, InstallationStatus installationStatus, Bitmap walletIcon, int bannerWalletRes, List<Integer> screenshots) {
        this.testData = true;

        this.walletName = walletName;
        this.description = description;
        this.installationStatus = installationStatus;
        this.walletIcon = walletIcon;
        this.bannerWalletRes = bannerWalletRes;
        this.screenshots = screenshots;
    }

    public static ArrayList<WalletStoreListItem> getTestData(Resources res) {

        String[] walletNames = {"Bitcoin Wallet", "Crypto Customer Wallet", "Crypto Broker Wallet", "Asset Issuer", "Asset User", "Redeem Point"};

        String[] descriptions = {
                "This reference wallet let you send and receive Bitcoins",
                "This reference wallet allows you to buy any currency, Fiat and Crypto, to any Broker within Fermat with a Crypto Broker Wallet",
                "This reference wallet allows you to sell any currency, Fiat and Crypto, to anyone within Fermat with a Crypto Customer Wallet",
                "This wallet has the assets generated by a issuer, which is the entity that can create them",
                "This is the wallet that holds the assets of users who can use / spend those assets",
                "This wallet holds the assets to be redeemed on a redeem point"};

        String[] prices = {"FREE", "FREE", "FREE", "FREE", "FREE", "FREE"};

        InstallationStatus[] installed = {INSTALLED, INSTALLED, INSTALLED, INSTALLED, INSTALLED, INSTALLED};

        int[] walletIcons = {
                R.drawable.bitcoin_wallet_med,
                R.drawable.crypto_customer_med,
                R.drawable.crypto_broker_med,
                R.drawable.asset_issuer,
                R.drawable.asset_user_wallet,
                R.drawable.redeem_point};

        int[] walletBanners = {
                R.drawable.banner_bitcoin_wallet,
                R.drawable.banner_crypto_customer_wallet,
                R.drawable.banner_crypto_broker,
                R.drawable.banner_asset_issuer_wallet,
                R.drawable.banner_asset_user_wallet,
                R.drawable.banner_redeem_point};

        ArrayList<List<Integer>> walletScreenshots = createListOfScreenshots();

        ArrayList<WalletStoreListItem> testItems = new ArrayList<>();
        for (int i = 0; i < walletIcons.length && i < installed.length && i < prices.length && i < walletNames.length; i++) {
            Bitmap icon = BitmapFactory.decodeResource(res, walletIcons[i]);
            List<Integer> screenshots = walletScreenshots.get(i);
            WalletStoreListItem item = new WalletStoreListItem(walletNames[i], descriptions[i], installed[i], icon, walletBanners[i], screenshots);
            testItems.add(item);
        }

        return testItems;
    }

    private static ArrayList<List<Integer>> createListOfScreenshots() {
        ArrayList<List<Integer>> data = new ArrayList<>();
        ArrayList<Integer> screenshots;

        screenshots = new ArrayList<>();
        screenshots.add(R.drawable.bitcoin_screenshot_1);
        screenshots.add(R.drawable.bitcoin_screenshot_2);
        screenshots.add(R.drawable.bitcoin_screenshot_3);
        data.add(screenshots);

        screenshots = new ArrayList<>();
        screenshots.add(R.drawable.customer_screenshot_1);
        screenshots.add(R.drawable.customer_screenshot_2);
        data.add(screenshots);

        screenshots = new ArrayList<>();
        screenshots.add(R.drawable.broker_screenshot_1);
        screenshots.add(R.drawable.broker_screenshot_2);
        screenshots.add(R.drawable.broker_screenshot_3);
        data.add(screenshots);

        data.add(null);

        data.add(null);

        data.add(null);

        return data;
    }


    public boolean isTestData() {
        return testData;
    }
}
