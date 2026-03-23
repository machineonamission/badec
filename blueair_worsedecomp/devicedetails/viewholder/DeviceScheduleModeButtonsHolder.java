package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.viewbinding.ViewBinding;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasLinkingCapability;
import com.blueair.core.model.UiAutoMode;
import com.blueair.core.model.UiG4NightMode;
import com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding;
import com.blueair.devicedetails.databinding.HolderScheduleDeviceButtonsModeBinding;
import com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 Z2\u00020\u0001:\u0001ZB+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010T\u001a\u00020\t2\u0006\u0010U\u001a\u00020VH\u0016J\u0016\u0010W\u001a\u00020\t2\u0006\u0010U\u001a\u00020V2\u0006\u0010X\u001a\u00020\bJ\b\u0010Y\u001a\u00020\tH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0010\u001a\u00020\u00118BX\u0002¢\u0006\f\n\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0016\u001a\u00020\u00178BX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0015\u001a\u0004\b\u0018\u0010\u0019R\u001b\u0010\u001b\u001a\u00020\u001c8VX\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0015\u001a\u0004\b\u001d\u0010\u001eR\u001b\u0010 \u001a\u00020\u001c8VX\u0002¢\u0006\f\n\u0004\b\"\u0010\u0015\u001a\u0004\b!\u0010\u001eR\u001b\u0010#\u001a\u00020\u001c8VX\u0002¢\u0006\f\n\u0004\b%\u0010\u0015\u001a\u0004\b$\u0010\u001eR\u001b\u0010&\u001a\u00020'8VX\u0002¢\u0006\f\n\u0004\b*\u0010\u0015\u001a\u0004\b(\u0010)R\u001b\u0010+\u001a\u00020,8VX\u0002¢\u0006\f\n\u0004\b/\u0010\u0015\u001a\u0004\b-\u0010.R\u001b\u00100\u001a\u00020'8VX\u0002¢\u0006\f\n\u0004\b2\u0010\u0015\u001a\u0004\b1\u0010)R\u001b\u00103\u001a\u00020,8VX\u0002¢\u0006\f\n\u0004\b5\u0010\u0015\u001a\u0004\b4\u0010.R\u001b\u00106\u001a\u00020'8VX\u0002¢\u0006\f\n\u0004\b8\u0010\u0015\u001a\u0004\b7\u0010)R\u001b\u00109\u001a\u00020\u001c8VX\u0002¢\u0006\f\n\u0004\b;\u0010\u0015\u001a\u0004\b:\u0010\u001eR\u001b\u0010<\u001a\u00020,8VX\u0002¢\u0006\f\n\u0004\b>\u0010\u0015\u001a\u0004\b=\u0010.R\u001b\u0010?\u001a\u00020'8VX\u0002¢\u0006\f\n\u0004\bA\u0010\u0015\u001a\u0004\b@\u0010)R\u001b\u0010B\u001a\u00020,8VX\u0002¢\u0006\f\n\u0004\bD\u0010\u0015\u001a\u0004\bC\u0010.R\u0016\u0010E\u001a\u0004\u0018\u00010'X\u0004¢\u0006\b\n\u0000\u001a\u0004\bF\u0010)R\u0016\u0010G\u001a\u0004\u0018\u00010,X\u0004¢\u0006\b\n\u0000\u001a\u0004\bH\u0010.R\u0016\u0010I\u001a\u0004\u0018\u00010\u001cX\u0004¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010\u001eR\u001d\u0010K\u001a\u0004\u0018\u00010'8VX\u0002¢\u0006\f\n\u0004\bM\u0010\u0015\u001a\u0004\bL\u0010)R\u001d\u0010N\u001a\u0004\u0018\u00010,8VX\u0002¢\u0006\f\n\u0004\bP\u0010\u0015\u001a\u0004\bO\u0010.R\u001d\u0010Q\u001a\u0004\u0018\u00010\u001c8VX\u0002¢\u0006\f\n\u0004\bS\u0010\u0015\u001a\u0004\bR\u0010\u001e¨\u0006["}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/ModeButtonsHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "supportDisinfection", "", "onPurifierModeChanged", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "", "<init>", "(Landroidx/viewbinding/ViewBinding;ZLkotlin/jvm/functions/Function1;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "getSupportDisinfection", "()Z", "disinfectionBinding", "Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "getDisinfectionBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "disinfectionBinding$delegate", "Lkotlin/Lazy;", "otherBinding", "Lcom/blueair/devicedetails/databinding/HolderScheduleDeviceButtonsModeBinding;", "getOtherBinding", "()Lcom/blueair/devicedetails/databinding/HolderScheduleDeviceButtonsModeBinding;", "otherBinding$delegate", "autoModeImageView", "Landroid/widget/ImageView;", "getAutoModeImageView", "()Landroid/widget/ImageView;", "autoModeImageView$delegate", "nightModeImageView", "getNightModeImageView", "nightModeImageView$delegate", "manualModeImageView", "getManualModeImageView", "manualModeImageView$delegate", "autoModeRoot", "Landroid/view/View;", "getAutoModeRoot", "()Landroid/view/View;", "autoModeRoot$delegate", "autoModeTitleView", "Landroid/widget/TextView;", "getAutoModeTitleView", "()Landroid/widget/TextView;", "autoModeTitleView$delegate", "nightModeRoot", "getNightModeRoot", "nightModeRoot$delegate", "nightModeTitleView", "getNightModeTitleView", "nightModeTitleView$delegate", "standByModeRoot", "getStandByModeRoot", "standByModeRoot$delegate", "standByModeBackground", "getStandByModeBackground", "standByModeBackground$delegate", "standByModeTitleView", "getStandByModeTitleView", "standByModeTitleView$delegate", "manualModeRoot", "getManualModeRoot", "manualModeRoot$delegate", "manualModeTitleView", "getManualModeTitleView", "manualModeTitleView$delegate", "childLockRoot", "getChildLockRoot", "childLockTitleView", "getChildLockTitleView", "childLockImageView", "getChildLockImageView", "disinfectionRoot", "getDisinfectionRoot", "disinfectionRoot$delegate", "disinfectionTitleView", "getDisinfectionTitleView", "disinfectionTitleView$delegate", "disinfectionImageView", "getDisinfectionImageView", "disinfectionImageView$delegate", "update", "device", "Lcom/blueair/core/model/Device;", "bind", "mode", "bindListeners", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleModeButtonsHolder.kt */
public final class DeviceScheduleModeButtonsHolder extends ModeButtonsHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Lazy autoModeImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda5(this));
    private final Lazy autoModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda8(this));
    private final Lazy autoModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda9(this));
    private final ViewBinding binding;
    private final ImageView childLockImageView;
    private final View childLockRoot;
    private final TextView childLockTitleView;
    private final Lazy disinfectionBinding$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda17(this));
    private final Lazy disinfectionImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda3(this));
    private final Lazy disinfectionRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda1(this));
    private final Lazy disinfectionTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda2(this));
    private final Lazy manualModeImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda7(this));
    private final Lazy manualModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda20(this));
    private final Lazy manualModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda21(this));
    private final Lazy nightModeImageView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda6(this));
    private final Lazy nightModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda10(this));
    private final Lazy nightModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda12(this));
    private final Function1<DeviceCreateEditScheduleViewModel.PurifierMode, Unit> onPurifierModeChanged;
    private final Lazy otherBinding$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda4(this));
    private final Lazy standByModeBackground$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda18(this));
    private final Lazy standByModeRoot$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda13(this));
    private final Lazy standByModeTitleView$delegate = LazyKt.lazy(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda19(this));
    private final boolean supportDisinfection;

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
    }

    public final ViewBinding getBinding() {
        return this.binding;
    }

    public final boolean getSupportDisinfection() {
        return this.supportDisinfection;
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b¨\u0006\u000e"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleModeButtonsHolder;", "parent", "Landroid/view/ViewGroup;", "supportDisinfection", "", "onPurifierModeChanged", "Lkotlin/Function1;", "Lcom/blueair/devicedetails/viewmodel/DeviceCreateEditScheduleViewModel$PurifierMode;", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleModeButtonsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleModeButtonsHolder newInstance(ViewGroup viewGroup, boolean z, Function1<? super DeviceCreateEditScheduleViewModel.PurifierMode, Unit> function1) {
            ViewBinding viewBinding;
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            Intrinsics.checkNotNullParameter(function1, "onPurifierModeChanged");
            LayoutInflater from = LayoutInflater.from(viewGroup.getContext());
            if (z) {
                HolderDeviceButtonsModeBinding inflate = HolderDeviceButtonsModeBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNull(inflate);
                viewBinding = inflate;
            } else {
                HolderScheduleDeviceButtonsModeBinding inflate2 = HolderScheduleDeviceButtonsModeBinding.inflate(from, viewGroup, false);
                Intrinsics.checkNotNull(inflate2);
                viewBinding = inflate2;
            }
            return new DeviceScheduleModeButtonsHolder(viewBinding, z, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceScheduleModeButtonsHolder(androidx.viewbinding.ViewBinding r3, boolean r4, kotlin.jvm.functions.Function1<? super com.blueair.devicedetails.viewmodel.DeviceCreateEditScheduleViewModel.PurifierMode, kotlin.Unit> r5) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onPurifierModeChanged"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            android.view.View r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            r2.<init>(r0)
            r2.binding = r3
            r2.supportDisinfection = r4
            r2.onPurifierModeChanged = r5
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda17 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda17
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.disinfectionBinding$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda4 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda4
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.otherBinding$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda5 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda5
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.autoModeImageView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda6 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda6
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.nightModeImageView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda7 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda7
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.manualModeImageView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda8 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda8
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.autoModeRoot$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda9 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda9
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.autoModeTitleView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda10 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda10
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.nightModeRoot$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda12 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda12
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.nightModeTitleView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda13 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda13
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.standByModeRoot$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda18 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda18
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.standByModeBackground$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda19 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda19
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.standByModeTitleView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda20 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda20
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.manualModeRoot$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda21 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda21
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.manualModeTitleView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda1 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda1
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.disinfectionRoot$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda2 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda2
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.disinfectionTitleView$delegate = r3
            com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda3 r3 = new com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda3
            r3.<init>(r2)
            kotlin.Lazy r3 = kotlin.LazyKt.lazy(r3)
            r2.disinfectionImageView$delegate = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceScheduleModeButtonsHolder.<init>(androidx.viewbinding.ViewBinding, boolean, kotlin.jvm.functions.Function1):void");
    }

    private final HolderDeviceButtonsModeBinding getDisinfectionBinding() {
        return (HolderDeviceButtonsModeBinding) this.disinfectionBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final HolderDeviceButtonsModeBinding disinfectionBinding_delegate$lambda$0(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        ViewBinding viewBinding = deviceScheduleModeButtonsHolder.binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding");
        return (HolderDeviceButtonsModeBinding) viewBinding;
    }

    private final HolderScheduleDeviceButtonsModeBinding getOtherBinding() {
        return (HolderScheduleDeviceButtonsModeBinding) this.otherBinding$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final HolderScheduleDeviceButtonsModeBinding otherBinding_delegate$lambda$1(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        ViewBinding viewBinding = deviceScheduleModeButtonsHolder.binding;
        Intrinsics.checkNotNull(viewBinding, "null cannot be cast to non-null type com.blueair.devicedetails.databinding.HolderScheduleDeviceButtonsModeBinding");
        return (HolderScheduleDeviceButtonsModeBinding) viewBinding;
    }

    public ImageView getAutoModeImageView() {
        Object value = this.autoModeImageView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageView) value;
    }

    /* access modifiers changed from: private */
    public static final AppCompatImageView autoModeImageView_delegate$lambda$2(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        return deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().automodeImageview : deviceScheduleModeButtonsHolder.getOtherBinding().automodeImageview;
    }

    public ImageView getNightModeImageView() {
        Object value = this.nightModeImageView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageView) value;
    }

    /* access modifiers changed from: private */
    public static final AppCompatImageView nightModeImageView_delegate$lambda$3(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        return deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().nightmodeImageview : deviceScheduleModeButtonsHolder.getOtherBinding().nightmodeImageview;
    }

    public ImageView getManualModeImageView() {
        Object value = this.manualModeImageView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageView) value;
    }

    /* access modifiers changed from: private */
    public static final AppCompatImageView manualModeImageView_delegate$lambda$4(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        return deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().manualModeImageview : deviceScheduleModeButtonsHolder.getOtherBinding().manualModeImageview;
    }

    public View getAutoModeRoot() {
        return (View) this.autoModeRoot$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ViewGroup autoModeRoot_delegate$lambda$5(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        ViewGroup viewGroup = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().automodeRoot : deviceScheduleModeButtonsHolder.getOtherBinding().automodeRoot;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "automodeRoot");
        return viewGroup;
    }

    public TextView getAutoModeTitleView() {
        return (TextView) this.autoModeTitleView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextView autoModeTitleView_delegate$lambda$6(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        TextView textView = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().automodeTitleview : deviceScheduleModeButtonsHolder.getOtherBinding().automodeTitleview;
        Intrinsics.checkNotNull(textView);
        return textView;
    }

    public View getNightModeRoot() {
        return (View) this.nightModeRoot$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ViewGroup nightModeRoot_delegate$lambda$7(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        ViewGroup viewGroup = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().nightmodeRoot : deviceScheduleModeButtonsHolder.getOtherBinding().nightmodeRoot;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "nightmodeRoot");
        return viewGroup;
    }

    public TextView getNightModeTitleView() {
        return (TextView) this.nightModeTitleView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextView nightModeTitleView_delegate$lambda$8(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        TextView textView = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().nightmodeTitleview : deviceScheduleModeButtonsHolder.getOtherBinding().nightmodeTitleview;
        Intrinsics.checkNotNull(textView);
        return textView;
    }

    public View getStandByModeRoot() {
        return (View) this.standByModeRoot$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ViewGroup standByModeRoot_delegate$lambda$9(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        ViewGroup viewGroup = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().standbyModeRoot : deviceScheduleModeButtonsHolder.getOtherBinding().standbyModeRoot;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "standbyModeRoot");
        return viewGroup;
    }

    public ImageView getStandByModeBackground() {
        Object value = this.standByModeBackground$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (ImageView) value;
    }

    /* access modifiers changed from: private */
    public static final AppCompatImageView standByModeBackground_delegate$lambda$10(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        return deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().standbyModeImageview : deviceScheduleModeButtonsHolder.getOtherBinding().standbyModeImageview;
    }

    public TextView getStandByModeTitleView() {
        return (TextView) this.standByModeTitleView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final TextView standByModeTitleView_delegate$lambda$11(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        TextView textView = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().standbyModeTitleview : deviceScheduleModeButtonsHolder.getOtherBinding().standbyModeTitleview;
        Intrinsics.checkNotNull(textView);
        return textView;
    }

    public View getManualModeRoot() {
        return (View) this.manualModeRoot$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final ViewGroup manualModeRoot_delegate$lambda$12(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        ViewGroup viewGroup = deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().manualModeRoot : deviceScheduleModeButtonsHolder.getOtherBinding().manualModeRoot;
        Intrinsics.checkNotNullExpressionValue(viewGroup, "manualModeRoot");
        return viewGroup;
    }

    public TextView getManualModeTitleView() {
        Object value = this.manualModeTitleView$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (TextView) value;
    }

    /* access modifiers changed from: private */
    public static final AppCompatTextView manualModeTitleView_delegate$lambda$13(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        return deviceScheduleModeButtonsHolder.supportDisinfection ? deviceScheduleModeButtonsHolder.getDisinfectionBinding().manualModeTitleview : deviceScheduleModeButtonsHolder.getOtherBinding().manualModeTitleview;
    }

    public View getChildLockRoot() {
        return this.childLockRoot;
    }

    public TextView getChildLockTitleView() {
        return this.childLockTitleView;
    }

    public ImageView getChildLockImageView() {
        return this.childLockImageView;
    }

    public View getDisinfectionRoot() {
        return (View) this.disinfectionRoot$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final LinearLayout disinfectionRoot_delegate$lambda$14(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        if (deviceScheduleModeButtonsHolder.supportDisinfection) {
            return deviceScheduleModeButtonsHolder.getDisinfectionBinding().disinfectionRoot;
        }
        return null;
    }

    public TextView getDisinfectionTitleView() {
        return (TextView) this.disinfectionTitleView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final AppCompatTextView disinfectionTitleView_delegate$lambda$15(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        if (deviceScheduleModeButtonsHolder.supportDisinfection) {
            return deviceScheduleModeButtonsHolder.getDisinfectionBinding().disinfectionTitleview;
        }
        return null;
    }

    public ImageView getDisinfectionImageView() {
        return (ImageView) this.disinfectionImageView$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final AppCompatImageView disinfectionImageView_delegate$lambda$16(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder) {
        if (deviceScheduleModeButtonsHolder.supportDisinfection) {
            return deviceScheduleModeButtonsHolder.getDisinfectionBinding().disinfectionImageview;
        }
        return null;
    }

    public final void bind(Device device, DeviceCreateEditScheduleViewModel.PurifierMode purifierMode) {
        Intrinsics.checkNotNullParameter(device, "device");
        Intrinsics.checkNotNullParameter(purifierMode, "mode");
        Timber.Forest forest = Timber.Forest;
        forest.d("bind: device = " + device + ", mode = " + purifierMode, new Object[0]);
        boolean z = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY;
        boolean z2 = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.AUTO;
        boolean z3 = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT;
        boolean z4 = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL;
        boolean z5 = purifierMode == DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION;
        bindListeners();
        if (DeviceKt.isG4orB4orNB(device)) {
            ViewExtensionsKt.show(getStandByModeRoot(), true);
            updateStandbyModeBtnViews(!z, true);
            ViewExtensionsKt.show(getNightModeRoot(), true);
            ModeButtonsHolder.updateNightModeBtnViews$default(this, z3 ? UiG4NightMode.On.INSTANCE : UiG4NightMode.Off.INSTANCE, false, 2, (Object) null);
        } else {
            ViewExtensionsKt.show(getAutoModeRoot(), (device instanceof HasFanSpeed) && ((HasFanSpeed) device).getAutoMode() != AutoMode.NOT_AVAILABLE);
            if (device instanceof HasLinkingCapability) {
                ViewExtensionsKt.show(getAutoModeRoot(), ((HasLinkingCapability) device).isLinked());
            }
            ViewExtensionsKt.show(getNightModeRoot(), false);
            ViewExtensionsKt.show(getStandByModeRoot(), false);
        }
        if (this.supportDisinfection) {
            View disinfectionRoot = getDisinfectionRoot();
            if (disinfectionRoot != null) {
                ViewExtensionsKt.show(disinfectionRoot, true);
            }
            ModeButtonsHolder.updateDisinfectionBtnViews$default(this, z5, false, 2, (Object) null);
        }
        ModeButtonsHolder modeButtonsHolder = this;
        ModeButtonsHolder.updateAutoModeBtnViews$default(modeButtonsHolder, z2 ? UiAutoMode.On.INSTANCE : UiAutoMode.Off.INSTANCE, false, device, 2, (Object) null);
        ViewExtensionsKt.show$default(getManualModeRoot(), false, 1, (Object) null);
        ModeButtonsHolder.updateManualModeBtnViews$default(modeButtonsHolder, z4, false, 2, (Object) null);
    }

    private final void bindListeners() {
        View disinfectionRoot;
        getStandByModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda0(this));
        getAutoModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda11(this));
        getManualModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda14(this));
        getNightModeRoot().setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda15(this));
        if (this.supportDisinfection && (disinfectionRoot = getDisinfectionRoot()) != null) {
            disinfectionRoot.setOnClickListener(new DeviceScheduleModeButtonsHolder$$ExternalSyntheticLambda16(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void bindListeners$lambda$17(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder, View view) {
        deviceScheduleModeButtonsHolder.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.STANDBY);
    }

    /* access modifiers changed from: private */
    public static final void bindListeners$lambda$18(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder, View view) {
        deviceScheduleModeButtonsHolder.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.AUTO);
    }

    /* access modifiers changed from: private */
    public static final void bindListeners$lambda$19(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder, View view) {
        deviceScheduleModeButtonsHolder.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.MANUAL);
    }

    /* access modifiers changed from: private */
    public static final void bindListeners$lambda$20(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder, View view) {
        deviceScheduleModeButtonsHolder.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.NIGHT);
    }

    /* access modifiers changed from: private */
    public static final void bindListeners$lambda$21(DeviceScheduleModeButtonsHolder deviceScheduleModeButtonsHolder, View view) {
        deviceScheduleModeButtonsHolder.onPurifierModeChanged.invoke(DeviceCreateEditScheduleViewModel.PurifierMode.DISINFECTION);
    }
}
