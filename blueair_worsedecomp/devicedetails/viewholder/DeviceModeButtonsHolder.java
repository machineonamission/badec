package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasChildLock;
import com.blueair.core.model.HasDisinfection;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.UiAutoMode;
import com.blueair.core.model.UiG4NightMode;
import com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding;
import com.blueair.viewcore.utils.ModeIcon;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 <2\u00020\u0001:\u0001<B2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020;H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u0014\u0010\u001f\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0014\u0010!\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0012R\u0014\u0010#\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0014\u0010%\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016R\u0014\u0010'\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0012R\u0014\u0010)\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0014\u0010+\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001aR\u0014\u0010-\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0012R\u0014\u0010/\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0016R\u0014\u00101\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\u001aR\u0014\u00103\u001a\u00020\u0010X\u0004¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0012R\u0014\u00105\u001a\u00020\u0014X\u0004¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0016R\u0014\u00107\u001a\u00020\u0018X\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u001a¨\u0006="}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsHolder;", "Lcom/blueair/devicedetails/viewholder/ModeButtonsHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceButtonsModeBinding;", "autoModeRoot", "Landroid/view/View;", "getAutoModeRoot", "()Landroid/view/View;", "autoModeTitleView", "Landroid/widget/TextView;", "getAutoModeTitleView", "()Landroid/widget/TextView;", "autoModeImageView", "Landroid/widget/ImageView;", "getAutoModeImageView", "()Landroid/widget/ImageView;", "nightModeRoot", "getNightModeRoot", "nightModeTitleView", "getNightModeTitleView", "nightModeImageView", "getNightModeImageView", "standByModeRoot", "getStandByModeRoot", "standByModeBackground", "getStandByModeBackground", "standByModeTitleView", "getStandByModeTitleView", "manualModeRoot", "getManualModeRoot", "manualModeTitleView", "getManualModeTitleView", "manualModeImageView", "getManualModeImageView", "childLockRoot", "getChildLockRoot", "childLockTitleView", "getChildLockTitleView", "childLockImageView", "getChildLockImageView", "disinfectionRoot", "getDisinfectionRoot", "disinfectionTitleView", "getDisinfectionTitleView", "disinfectionImageView", "getDisinfectionImageView", "update", "device", "Lcom/blueair/core/model/Device;", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceModeButtonsHolder.kt */
public final class DeviceModeButtonsHolder extends ModeButtonsHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ImageView autoModeImageView;
    private final View autoModeRoot;
    private final TextView autoModeTitleView;
    private final HolderDeviceButtonsModeBinding binding;
    private final ImageView childLockImageView;
    private final View childLockRoot;
    private final TextView childLockTitleView;
    private final ImageView disinfectionImageView;
    private final View disinfectionRoot;
    private final TextView disinfectionTitleView;
    private final ImageView manualModeImageView;
    private final View manualModeRoot;
    private final TextView manualModeTitleView;
    private final ImageView nightModeImageView;
    private final View nightModeRoot;
    private final TextView nightModeTitleView;
    private final Function1<ModeIcon, Unit> onModeSelectedListener;
    private final ImageView standByModeBackground;
    private final View standByModeRoot;
    private final TextView standByModeTitleView;

    public final HolderDeviceButtonsModeBinding getBinding() {
        return this.binding;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceModeButtonsHolder;", "parentView", "Landroid/view/ViewGroup;", "onModeSelectedListener", "Lkotlin/Function1;", "Lcom/blueair/viewcore/utils/ModeIcon;", "Lkotlin/ParameterName;", "name", "mode", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceModeButtonsHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceModeButtonsHolder newInstance(ViewGroup viewGroup, Function1<? super ModeIcon, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onModeSelectedListener");
            HolderDeviceButtonsModeBinding inflate = HolderDeviceButtonsModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceModeButtonsHolder(inflate, function1);
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceModeButtonsHolder(com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding r18, kotlin.jvm.functions.Function1<? super com.blueair.viewcore.utils.ModeIcon, kotlin.Unit> r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.String r3 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            java.lang.String r3 = "onModeSelectedListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r3)
            androidx.constraintlayout.widget.ConstraintLayout r3 = r1.getRoot()
            java.lang.String r4 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)
            android.view.View r3 = (android.view.View) r3
            r0.<init>(r3)
            r0.binding = r1
            r0.onModeSelectedListener = r2
            android.widget.LinearLayout r2 = r1.automodeRoot
            java.lang.String r3 = "automodeRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.autoModeRoot = r2
            android.widget.TextView r2 = r1.automodeTitleview
            java.lang.String r3 = "automodeTitleview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.autoModeTitleView = r2
            androidx.appcompat.widget.AppCompatImageView r2 = r1.automodeImageview
            java.lang.String r3 = "automodeImageview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.autoModeImageView = r2
            android.widget.LinearLayout r2 = r1.nightmodeRoot
            java.lang.String r3 = "nightmodeRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.nightModeRoot = r2
            android.widget.TextView r2 = r1.nightmodeTitleview
            java.lang.String r3 = "nightmodeTitleview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.nightModeTitleView = r2
            androidx.appcompat.widget.AppCompatImageView r2 = r1.nightmodeImageview
            java.lang.String r3 = "nightmodeImageview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.nightModeImageView = r2
            android.widget.LinearLayout r2 = r1.standbyModeRoot
            java.lang.String r3 = "standbyModeRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.standByModeRoot = r2
            androidx.appcompat.widget.AppCompatImageView r2 = r1.standbyModeImageview
            java.lang.String r3 = "standbyModeImageview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.standByModeBackground = r2
            android.widget.TextView r2 = r1.standbyModeTitleview
            java.lang.String r3 = "standbyModeTitleview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            r0.standByModeTitleView = r2
            android.widget.LinearLayout r2 = r1.manualModeRoot
            java.lang.String r3 = "manualModeRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.manualModeRoot = r2
            androidx.appcompat.widget.AppCompatTextView r2 = r1.manualModeTitleview
            java.lang.String r3 = "manualModeTitleview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.manualModeTitleView = r2
            androidx.appcompat.widget.AppCompatImageView r2 = r1.manualModeImageview
            java.lang.String r3 = "manualModeImageview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.manualModeImageView = r2
            android.widget.LinearLayout r2 = r1.childLockRoot
            java.lang.String r3 = "childLockRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.childLockRoot = r2
            androidx.appcompat.widget.AppCompatTextView r2 = r1.childLockTitleview
            java.lang.String r3 = "childLockTitleview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.childLockTitleView = r2
            androidx.appcompat.widget.AppCompatImageView r2 = r1.childLockImageview
            java.lang.String r3 = "childLockImageview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
            r0.childLockImageView = r2
            android.widget.LinearLayout r2 = r1.disinfectionRoot
            java.lang.String r3 = "disinfectionRoot"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.view.View r2 = (android.view.View) r2
            r0.disinfectionRoot = r2
            androidx.appcompat.widget.AppCompatTextView r2 = r1.disinfectionTitleview
            java.lang.String r3 = "disinfectionTitleview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            r0.disinfectionTitleView = r2
            androidx.appcompat.widget.AppCompatImageView r1 = r1.disinfectionImageview
            java.lang.String r2 = "disinfectionImageview"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            r0.disinfectionImageView = r1
            android.view.View r1 = r0.getAutoModeRoot()
            com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda0 r2 = new com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda0
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.view.View r1 = r0.getStandByModeRoot()
            com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda1 r2 = new com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda1
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.view.View r1 = r0.getNightModeRoot()
            com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda2 r2 = new com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda2
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.view.View r1 = r0.getManualModeRoot()
            com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda3 r2 = new com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda3
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.view.View r1 = r0.getChildLockRoot()
            com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda4 r2 = new com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda4
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            android.view.View r1 = r0.getDisinfectionRoot()
            com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda5 r2 = new com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder$$ExternalSyntheticLambda5
            r2.<init>(r0)
            r1.setOnClickListener(r2)
            com.blueair.viewcore.ViewUtils r3 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r4 = r0.getAutoModeRoot()
            java.lang.Class<android.widget.RadioButton> r1 = android.widget.RadioButton.class
            kotlin.reflect.KClass r5 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r8 = 12
            r9 = 0
            r6 = 0
            r7 = 0
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r3, r4, r5, r6, r7, r8, r9)
            com.blueair.viewcore.ViewUtils r10 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r11 = r0.getStandByModeRoot()
            java.lang.Class<android.widget.RadioButton> r1 = android.widget.RadioButton.class
            kotlin.reflect.KClass r12 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r15 = 12
            r16 = 0
            r13 = 0
            r14 = 0
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r10, r11, r12, r13, r14, r15, r16)
            com.blueair.viewcore.ViewUtils r1 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r2 = r0.getNightModeRoot()
            java.lang.Class<android.widget.RadioButton> r3 = android.widget.RadioButton.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            r6 = 12
            r4 = 0
            r5 = 0
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r1, r2, r3, r4, r5, r6, r7)
            com.blueair.viewcore.ViewUtils r8 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r9 = r0.getManualModeRoot()
            java.lang.Class<android.widget.RadioButton> r1 = android.widget.RadioButton.class
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            r13 = 12
            r11 = 0
            r12 = 0
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r8, r9, r10, r11, r12, r13, r14)
            com.blueair.viewcore.ViewUtils r1 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r2 = r0.getChildLockRoot()
            java.lang.Class<android.widget.RadioButton> r3 = android.widget.RadioButton.class
            kotlin.reflect.KClass r3 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r3)
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r1, r2, r3, r4, r5, r6, r7)
            com.blueair.viewcore.ViewUtils r8 = com.blueair.viewcore.ViewUtils.INSTANCE
            android.view.View r9 = r0.getDisinfectionRoot()
            java.lang.Class<android.widget.RadioButton> r1 = android.widget.RadioButton.class
            kotlin.reflect.KClass r10 = kotlin.jvm.internal.Reflection.getOrCreateKotlinClass(r1)
            com.blueair.viewcore.ViewUtils.setAccessibilityDelegate$default(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceModeButtonsHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceButtonsModeBinding, kotlin.jvm.functions.Function1):void");
    }

    public View getAutoModeRoot() {
        return this.autoModeRoot;
    }

    public TextView getAutoModeTitleView() {
        return this.autoModeTitleView;
    }

    public ImageView getAutoModeImageView() {
        return this.autoModeImageView;
    }

    public View getNightModeRoot() {
        return this.nightModeRoot;
    }

    public TextView getNightModeTitleView() {
        return this.nightModeTitleView;
    }

    public ImageView getNightModeImageView() {
        return this.nightModeImageView;
    }

    public View getStandByModeRoot() {
        return this.standByModeRoot;
    }

    public ImageView getStandByModeBackground() {
        return this.standByModeBackground;
    }

    public TextView getStandByModeTitleView() {
        return this.standByModeTitleView;
    }

    public View getManualModeRoot() {
        return this.manualModeRoot;
    }

    public TextView getManualModeTitleView() {
        return this.manualModeTitleView;
    }

    public ImageView getManualModeImageView() {
        return this.manualModeImageView;
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
        return this.disinfectionRoot;
    }

    public TextView getDisinfectionTitleView() {
        return this.disinfectionTitleView;
    }

    public ImageView getDisinfectionImageView() {
        return this.disinfectionImageView;
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceModeButtonsHolder deviceModeButtonsHolder, View view) {
        deviceModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.AUTO);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceModeButtonsHolder deviceModeButtonsHolder, View view) {
        deviceModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.STANDBY);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(DeviceModeButtonsHolder deviceModeButtonsHolder, View view) {
        deviceModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.NIGHT);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$3(DeviceModeButtonsHolder deviceModeButtonsHolder, View view) {
        deviceModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.FAN_SPEED);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$4(DeviceModeButtonsHolder deviceModeButtonsHolder, View view) {
        deviceModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.CHILD_LOCK);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$5(DeviceModeButtonsHolder deviceModeButtonsHolder, View view) {
        deviceModeButtonsHolder.onModeSelectedListener.invoke(ModeIcon.DISINFECTION);
    }

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        HasFanSpeed hasFanSpeed = (HasFanSpeed) device;
        HasChildLock hasChildLock = device instanceof HasChildLock ? (HasChildLock) device : null;
        boolean isG4orB4orNB = DeviceKt.isG4orB4orNB(device);
        boolean supportDisinfection = DeviceKt.supportDisinfection(device);
        ViewExtensionsKt.show(getManualModeRoot(), true);
        ViewExtensionsKt.show(getNightModeRoot(), isG4orB4orNB);
        ViewExtensionsKt.show(getStandByModeRoot(), isG4orB4orNB);
        ViewExtensionsKt.show(getChildLockRoot(), isG4orB4orNB);
        ViewExtensionsKt.show(getDisinfectionRoot(), supportDisinfection);
        boolean areEqual = Intrinsics.areEqual((Object) hasFanSpeed.getUiAutoMode(), (Object) UiAutoMode.Off.INSTANCE);
        boolean z = isG4orB4orNB ? areEqual && Intrinsics.areEqual((Object) ((HasG4NightMode) hasFanSpeed).getUiG4NightMode(), (Object) UiG4NightMode.Off.INSTANCE) : areEqual;
        if (isG4orB4orNB) {
            HasFanSpeed hasFanSpeed2 = hasFanSpeed;
            ModeButtonsHolder modeButtonsHolder = this;
            HasStandBy hasStandBy = (HasStandBy) hasFanSpeed2;
            ModeButtonsHolder.updateStandbyModeBtnViews$default(modeButtonsHolder, hasStandBy.isStandByOn(), false, 2, (Object) null);
            if (hasStandBy.isStandByOn()) {
                updateAutoModeBtnViews(UiAutoMode.Off.INSTANCE, true, device);
                updateNightModeBtnViews(UiG4NightMode.Off.INSTANCE, true);
                updateManualModeBtnViews(false, true);
                updateChildLockBtnViews(false, true);
                if (supportDisinfection) {
                    updateDisinfectionBtnViews(false, true);
                    return;
                }
                return;
            }
            Timber.Forest forest = Timber.Forest;
            StringBuilder sb = new StringBuilder("g4 mode: night mode ui = ");
            HasG4NightMode hasG4NightMode = (HasG4NightMode) device;
            sb.append(hasG4NightMode.getUiG4NightMode());
            sb.append(" & automode ui = ");
            sb.append(hasG4NightMode.getUiAutoMode());
            forest.d(sb.toString(), new Object[0]);
            if (supportDisinfection) {
                Boolean disinfection = ((HasDisinfection) device).getDisinfection();
                boolean booleanValue = disinfection != null ? disinfection.booleanValue() : false;
                ModeButtonsHolder.updateDisinfectionBtnViews$default(modeButtonsHolder, booleanValue, false, 2, (Object) null);
                getDisinfectionRoot().setSelected(booleanValue);
                if (booleanValue) {
                    ModeButtonsHolder.updateAutoModeBtnViews$default(modeButtonsHolder, UiAutoMode.Off.INSTANCE, false, device, 2, (Object) null);
                    ModeButtonsHolder.updateNightModeBtnViews$default(modeButtonsHolder, UiG4NightMode.Off.INSTANCE, false, 2, (Object) null);
                    ModeButtonsHolder.updateManualModeBtnViews$default(modeButtonsHolder, false, false, 2, (Object) null);
                    ModeButtonsHolder.updateChildLockBtnViews$default(modeButtonsHolder, hasChildLock != null ? hasChildLock.isChildLockOn() : false, false, 2, (Object) null);
                    return;
                }
                update$updateModes(this, device, z, hasChildLock);
                return;
            }
            update$updateModes(this, device, z, hasChildLock);
            return;
        }
        UiAutoMode uiAutoMode = hasFanSpeed.getUiAutoMode();
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("legacy mode:  automode ui = " + uiAutoMode, new Object[0]);
        ModeButtonsHolder modeButtonsHolder2 = this;
        ModeButtonsHolder.updateAutoModeBtnViews$default(modeButtonsHolder2, uiAutoMode, false, device, 2, (Object) null);
        ModeButtonsHolder.updateManualModeBtnViews$default(modeButtonsHolder2, z, false, 2, (Object) null);
    }

    private static final void update$updateModes(DeviceModeButtonsHolder deviceModeButtonsHolder, Device device, boolean z, HasChildLock hasChildLock) {
        ModeButtonsHolder modeButtonsHolder = deviceModeButtonsHolder;
        HasG4NightMode hasG4NightMode = (HasG4NightMode) device;
        ModeButtonsHolder.updateAutoModeBtnViews$default(modeButtonsHolder, hasG4NightMode.getUiAutoMode(), false, device, 2, (Object) null);
        ModeButtonsHolder.updateNightModeBtnViews$default(modeButtonsHolder, hasG4NightMode.getUiG4NightMode(), false, 2, (Object) null);
        ModeButtonsHolder.updateManualModeBtnViews$default(modeButtonsHolder, z, false, 2, (Object) null);
        ModeButtonsHolder.updateChildLockBtnViews$default(modeButtonsHolder, hasChildLock != null ? hasChildLock.isChildLockOn() : false, false, 2, (Object) null);
    }
}
