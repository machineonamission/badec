package com.blueair.login;

import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.BrandXxBh8488Eml;
import com.blueair.auth.Email;
import com.blueair.auth.GigyaAccountExtended;
import com.blueair.auth.OptInOptOut;
import com.blueair.auth.SubscriptionsDto;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0017\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/blueair/login/ProfileViewModel$consentData$1", "Landroidx/lifecycle/MutableLiveData;", "", "setValue", "", "value", "(Ljava/lang/Boolean;)V", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileViewModel.kt */
public final class ProfileViewModel$consentData$1 extends MutableLiveData<Boolean> {
    final /* synthetic */ ProfileViewModel this$0;

    ProfileViewModel$consentData$1(ProfileViewModel profileViewModel) {
        this.this$0 = profileViewModel;
    }

    public void setValue(Boolean bool) {
        SubscriptionsDto subscriptions;
        OptInOptOut optInOptOut;
        BrandXxBh8488Eml brand_xx_bh8488_eml;
        Email email;
        super.setValue(bool);
        GigyaAccountExtended access$getAccount$p = this.this$0.account;
        if (access$getAccount$p != null && (subscriptions = access$getAccount$p.getSubscriptions()) != null && (optInOptOut = subscriptions.getOptInOptOut()) != null && (brand_xx_bh8488_eml = optInOptOut.getBRAND_XX_BH8488_EML()) != null && (email = brand_xx_bh8488_eml.getEmail()) != null) {
            email.setSubscribed(bool != null ? bool.booleanValue() : false);
        }
    }
}
