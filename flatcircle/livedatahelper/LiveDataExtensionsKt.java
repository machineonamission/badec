package io.flatcircle.livedatahelper;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aA\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007\u001aA\u0010\u000b\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u0007¨\u0006\r"}, d2 = {"observe", "", "T", "Landroidx/lifecycle/LiveData;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "lambda", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "observeNonNull", "t", "livedatahelper_release"}, k = 2, mv = {1, 1, 13})
/* compiled from: LiveDataExtensions.kt */
public final class LiveDataExtensionsKt {
    public static final <T> void observe(LiveData<T> liveData, LifecycleOwner lifecycleOwner, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(liveData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "owner");
        Intrinsics.checkParameterIsNotNull(function1, "lambda");
        liveData.observe(lifecycleOwner, new LiveDataExtensionsKt$sam$androidx_lifecycle_Observer$0(function1));
    }

    public static final <T> void observeNonNull(LiveData<T> liveData, LifecycleOwner lifecycleOwner, Function1<? super T, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(liveData, "receiver$0");
        Intrinsics.checkParameterIsNotNull(lifecycleOwner, "owner");
        Intrinsics.checkParameterIsNotNull(function1, "lambda");
        liveData.observe(lifecycleOwner, new LiveDataExtensionsKt$observeNonNull$1(function1));
    }
}
