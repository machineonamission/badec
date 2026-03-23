package com.blueair.core.util;

import androidx.lifecycle.MutableLiveData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003¨\u0006\u0004"}, d2 = {"forceRefresh", "", "T", "Landroidx/lifecycle/MutableLiveData;", "core_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: MutableLiveDataExtension.kt */
public final class MutableLiveDataExtensionKt {
    public static final <T> void forceRefresh(MutableLiveData<T> mutableLiveData) {
        Intrinsics.checkNotNullParameter(mutableLiveData, "<this>");
        mutableLiveData.setValue(mutableLiveData.getValue());
    }
}
