package com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.interfaces;


import com.bitdubai.fermat_api.layer.all_definition.crypto.asymmetric.interfaces.PublicKey;
import com.bitdubai.fermat_api.layer.all_definition.enums.WalletType;
import com.bitdubai.fermat_api.layer.all_definition.navigation_structure.WalletNavigationStructure;
import com.bitdubai.fermat_api.layer.all_definition.navigation_structure.enums.Wallets;
import com.bitdubai.fermat_api.layer.all_definition.resources_structure.Language;
import com.bitdubai.fermat_api.layer.all_definition.resources_structure.Skin;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.enums.WalletFactoryProjectState;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.exceptions.CantDeleteWalletFactoryProjectLanguageException;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.exceptions.CantDeleteWalletFactoryProjectSkinException;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.exceptions.CantGetWalletFactoryProjectLanguageException;
import com.bitdubai.fermat_api.layer.dmp_middleware.wallet_factory.exceptions.CantGetWalletFactoryProjectSkinException;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

/**
 * Created by eze on 2015.07.14..
 */
public interface WalletFactoryProject {
    // project info
    String getProjectPublicKey();
    void setProjectPublickKey(String publickKey);

    String getName();
    void setName(String name);

    String getDescription();
    void setDescription(String description);

    WalletType getWalletType();
    void setWalletType(WalletType walletType);

    WalletFactoryProjectState getProjectState();
    void setProjectState(WalletFactoryProjectState projectState);

    Timestamp getCreationTimestamp();
    void setCreationTimestamp(Timestamp timestamp);

    Timestamp getLastModificationTimestamp();
    void setLastModificationTimeststamp(Timestamp timestamp);

    int getSize();
    void setSize(int size);



    //skin
    Skin getDefaultSkin();
    void setDefaultSkin(Skin skin);
    List<Skin> getSkins();
    void setSkins(List<Skin> skins);
    void deleteSkin(Skin skin);

    //Language getters
    Language getDefaultLanguage();
    void setDefaultLanguage(Language language);
    List<Language> getLanguages();
    void setLanguages (List<Language> languages);
    void deleteLanguage (Language language);

    //Navigation Structure
    WalletNavigationStructure getNavigationStructure();
    void setNavigationStructure (WalletNavigationStructure navigationStructure);
}