package com.blueair.login;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u0002H\u00042\u0014\u0010\b\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u0002\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"observe", "", "T", "", "L", "Landroidx/lifecycle/LiveData;", "Landroidx/lifecycle/LifecycleOwner;", "liveData", "body", "Lkotlin/Function1;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/LiveData;Lkotlin/jvm/functions/Function1;)V", "login_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: BaseLoginViewModel.kt */
public final class BaseLoginViewModelKt {
    public static final <T, L extends LiveData<T>> void observe(LifecycleOwner lifecycleOwner, L l, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "<this>");
        Intrinsics.checkNotNullParameter(l, "liveData");
        Intrinsics.checkNotNullParameter(function1, "body");
        l.observe(lifecycleOwner, new BaseLoginViewModelKt$sam$androidx_lifecycle_Observer$0(function1));
    }
}
