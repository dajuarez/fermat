package com.bitdubai.fermat_dap_android_sub_app_redeem_point_community_bitdubai.holders;

import android.view.View;

import com.bitdubai.fermat_android_api.layer.definition.wallet.views.FermatTextView;
import com.bitdubai.fermat_android_api.ui.holders.FermatViewHolder;
import com.bitdubai.fermat_dap_android_sub_app_redeem_point_community_bitdubai.R;
import com.bitdubai.fermat_android_api.ui.Views.SquareImageView;

/**
 * Created by Nerio on 21/10/15.
 */
public class ActorViewHolder extends FermatViewHolder {

    public SquareImageView thumbnail;
    public FermatTextView name;

    /**
     * Constructor
     *
     * @param itemView
     */
    public ActorViewHolder(View itemView) {
        super(itemView);
        thumbnail = (SquareImageView) itemView.findViewById(R.id.thumbnail);
        name = (FermatTextView) itemView.findViewById(R.id.name);

    }
}
