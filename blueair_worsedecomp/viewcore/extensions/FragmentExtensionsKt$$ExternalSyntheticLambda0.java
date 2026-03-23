package com.blueair.viewcore.extensions;

import android.os.Bundle;
import androidx.fragment.app.FragmentResultListener;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FragmentExtensionsKt$$ExternalSyntheticLambda0 implements FragmentResultListener {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ FragmentExtensionsKt$$ExternalSyntheticLambda0(Function2 function2) {
        this.f$0 = function2;
    }

    public final void onFragmentResult(String str, Bundle bundle) {
        FragmentExtensionsKt.setFragmentResultListenerWithClear$lambda$0(this.f$0, str, bundle);
    }
}
