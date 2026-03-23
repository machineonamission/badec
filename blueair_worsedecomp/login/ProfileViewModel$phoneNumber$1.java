package com.blueair.login;

import androidx.lifecycle.MutableLiveData;
import com.blueair.auth.GigyaAccountExtended;
import com.gigya.android.sdk.account.models.Phone;
import com.gigya.android.sdk.account.models.Profile;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/login/ProfileViewModel$phoneNumber$1", "Landroidx/lifecycle/MutableLiveData;", "", "setValue", "", "value", "login_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ProfileViewModel.kt */
public final class ProfileViewModel$phoneNumber$1 extends MutableLiveData<String> {
    final /* synthetic */ ProfileViewModel this$0;

    ProfileViewModel$phoneNumber$1(ProfileViewModel profileViewModel) {
        this.this$0 = profileViewModel;
    }

    public void setValue(String str) {
        Profile profile;
        super.setValue(str);
        Phone phone = new Phone();
        phone.setNumber(str);
        GigyaAccountExtended access$getAccount$p = this.this$0.account;
        if (access$getAccount$p != null && (profile = access$getAccount$p.getProfile()) != null) {
            profile.setPhones(CollectionsKt.listOf(phone));
        }
    }
}
