package com.blueair.devicedetails.dialog;

import io.apptik.widget.MultiSlider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0018\u00010\rR\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J(\u0010\u0010\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\f\u0010\f\u001a\b\u0018\u00010\rR\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"com/blueair/devicedetails/dialog/DeviceFanPresetDialogFragment$onViewCreated$2$4$2", "Lio/apptik/widget/MultiSlider$OnTrackingChangeListener;", "oldTempArray", "", "getOldTempArray", "()[D", "setOldTempArray", "([D)V", "onStartTrackingTouch", "", "multiSlider", "Lio/apptik/widget/MultiSlider;", "thumb", "Lio/apptik/widget/MultiSlider$Thumb;", "value", "", "onStopTrackingTouch", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFanPresetDialogFragment.kt */
public final class DeviceFanPresetDialogFragment$onViewCreated$2$4$2 implements MultiSlider.OnTrackingChangeListener {
    public double[] oldTempArray;
    final /* synthetic */ DeviceFanPresetDialogFragment this$0;

    DeviceFanPresetDialogFragment$onViewCreated$2$4$2(DeviceFanPresetDialogFragment deviceFanPresetDialogFragment) {
        this.this$0 = deviceFanPresetDialogFragment;
    }

    public final double[] getOldTempArray() {
        double[] dArr = this.oldTempArray;
        if (dArr != null) {
            return dArr;
        }
        Intrinsics.throwUninitializedPropertyAccessException("oldTempArray");
        return null;
    }

    public final void setOldTempArray(double[] dArr) {
        Intrinsics.checkNotNullParameter(dArr, "<set-?>");
        this.oldTempArray = dArr;
    }

    public void onStartTrackingTouch(MultiSlider multiSlider, MultiSlider.Thumb thumb, int i) {
        this.this$0.isReset = false;
        double[] access$getCurrentPresetArray$p = this.this$0.currentPresetArray;
        if (access$getCurrentPresetArray$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("currentPresetArray");
            access$getCurrentPresetArray$p = null;
        }
        setOldTempArray((double[]) access$getCurrentPresetArray$p.clone());
    }

    public void onStopTrackingTouch(MultiSlider multiSlider, MultiSlider.Thumb thumb, int i) {
        this.this$0.validateTempArray(getOldTempArray());
    }
}
