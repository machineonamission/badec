package com.blueair.android.activity;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableFloatState;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class HomeActivity$$ExternalSyntheticLambda13 implements Function2 {
    public final /* synthetic */ MutableFloatState f$0;

    public /* synthetic */ HomeActivity$$ExternalSyntheticLambda13(MutableFloatState mutableFloatState) {
        this.f$0 = mutableFloatState;
    }

    public final Object invoke(Object obj, Object obj2) {
        return HomeActivity.observeViewModel$lambda$10(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
    }
}
