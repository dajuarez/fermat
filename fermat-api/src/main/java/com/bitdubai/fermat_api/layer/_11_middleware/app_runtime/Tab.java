package com.bitdubai.fermat_api.layer._11_middleware.app_runtime;

/**
 * Created by toshiba on 23/02/2015.
 */
public interface Tab {
    public void setLabel(String texto);
    public String getLabel();
    public void setFragment(Fragments fragment);
    public Fragments getFragment();
}
