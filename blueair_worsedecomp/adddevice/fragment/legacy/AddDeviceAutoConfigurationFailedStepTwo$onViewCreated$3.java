package com.blueair.adddevice.fragment.legacy;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/blueair/adddevice/fragment/legacy/AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$3", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: AddDeviceAutoConfigurationFailedStepTwo.kt */
public final class AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$3 extends Animatable2Compat.AnimationCallback {
    final /* synthetic */ AnimatedVectorDrawableCompat $avdFading;

    AddDeviceAutoConfigurationFailedStepTwo$onViewCreated$3(AnimatedVectorDrawableCompat animatedVectorDrawableCompat) {
        this.$avdFading = animatedVectorDrawableCompat;
    }

    public void onAnimationEnd(Drawable drawable) {
        Intrinsics.checkNotNullParameter(drawable, "drawable");
        this.$avdFading.start();
    }
}
