package com.blueair.auth;

import com.blueair.auth.GigyaService;
import com.blueair.core.model.UserInfoItem;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.gigya.android.sdk.GigyaCallback;
import com.gigya.android.sdk.network.GigyaError;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"com/blueair/auth/GigyaService$updateProfile$2$1$1", "Lcom/gigya/android/sdk/GigyaCallback;", "Lcom/blueair/auth/GigyaAccountExtended;", "onSuccess", "", "account", "onError", "error", "Lcom/gigya/android/sdk/network/GigyaError;", "auth_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: GigyaService.kt */
public final class GigyaService$updateProfile$2$1$1 extends GigyaCallback<GigyaAccountExtended> {
    final /* synthetic */ Continuation<Unit> $it;
    final /* synthetic */ boolean $recordUserInfoCollection;

    GigyaService$updateProfile$2$1$1(boolean z, Continuation<? super Unit> continuation) {
        this.$recordUserInfoCollection = z;
        this.$it = continuation;
    }

    public void onSuccess(GigyaAccountExtended gigyaAccountExtended) {
        boolean z;
        Intrinsics.checkNotNullParameter(gigyaAccountExtended, "account");
        if (this.$recordUserInfoCollection) {
            GigyaAccountAddress address = gigyaAccountExtended.getData().getAddress();
            String str = null;
            String addressLine1 = address != null ? address.getAddressLine1() : null;
            String city = address != null ? address.getCity() : null;
            String country = address != null ? address.getCountry() : null;
            String postCode = address != null ? address.getPostCode() : null;
            if (address != null) {
                str = address.getStateCode();
            }
            Iterable listOf = CollectionsKt.listOf(addressLine1, city, country, postCode, str);
            if (!(listOf instanceof Collection) || !((Collection) listOf).isEmpty()) {
                Iterator it = listOf.iterator();
                while (true) {
                    if (it.hasNext()) {
                        CharSequence charSequence = (String) it.next();
                        if (charSequence == null || charSequence.length() == 0) {
                            z = true;
                            continue;
                        } else {
                            z = false;
                            continue;
                        }
                        if (!z) {
                            UserInfoCollectionsManager.addRecord$default(UserInfoCollectionsManager.INSTANCE, UserInfoItem.USER_ADDRESS, CollectionsKt.joinToString$default(listOf, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null), false, 4, (Object) null);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        Continuation<Unit> continuation = this.$it;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(Unit.INSTANCE));
    }

    public void onError(GigyaError gigyaError) {
        Intrinsics.checkNotNullParameter(gigyaError, "error");
        Continuation<Unit> continuation = this.$it;
        Result.Companion companion = Result.Companion;
        continuation.resumeWith(Result.m9366constructorimpl(ResultKt.createFailure(new GigyaService.GigyaException(gigyaError))));
    }
}
