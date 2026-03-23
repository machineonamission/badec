package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.Group;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.HasRemoveYellowWater;
import com.blueair.core.model.HasWick;
import com.blueair.devicedetails.databinding.HolderDeviceFilterV2Binding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00162\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0016BZ\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\tH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterV2Holder;", "Lcom/blueair/devicedetails/viewholder/DeviceControlHolder;", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterV2Binding;", "binding", "device", "Lcom/blueair/core/model/Device;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "hasBuyLink", "", "onInfoClick", "Lkotlin/Function0;", "", "openPageAct", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlyBuy", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterV2Binding;Lcom/blueair/core/model/Device;Lcom/blueair/core/model/DeviceFilterType;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;)V", "update", "forceOffline", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterV2Holder.kt */
public final class DeviceFilterV2Holder extends DeviceControlHolder<HolderDeviceFilterV2Binding> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Device device;
    private final DeviceFilterType filterType;
    private final boolean hasBuyLink;
    private final Function0<Unit> onInfoClick;
    private final Function1<Boolean, Unit> openPageAct;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterV2Holder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                com.blueair.core.model.DeviceFilterType[] r0 = com.blueair.core.model.DeviceFilterType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.FILTER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.WICK     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.DeviceFilterType r1 = com.blueair.core.model.DeviceFilterType.REFRESHER     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceFilterV2Holder.WhenMappings.<clinit>():void");
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2!\u0010\u0011\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012¨\u0006\u0016"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterV2Holder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterV2Holder;", "parentView", "Landroid/view/ViewGroup;", "device", "Lcom/blueair/core/model/Device;", "filterType", "Lcom/blueair/core/model/DeviceFilterType;", "hasBuyLink", "", "onInfoClickListener", "Lkotlin/Function0;", "", "onOpenPageListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onlyBuy", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterV2Holder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFilterV2Holder newInstance(ViewGroup viewGroup, Device device, DeviceFilterType deviceFilterType, boolean z, Function0<Unit> function0, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(deviceFilterType, "filterType");
            Intrinsics.checkNotNullParameter(function0, "onInfoClickListener");
            Intrinsics.checkNotNullParameter(function1, "onOpenPageListener");
            HolderDeviceFilterV2Binding inflate = HolderDeviceFilterV2Binding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFilterV2Holder(inflate, device, deviceFilterType, z, function0, function1);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0109, code lost:
        if (com.blueair.core.model.DeviceType.Companion.isNb411iMax(r9 != null ? com.blueair.core.model.DeviceKt.getSkuCompat(r9) : r13) == false) goto L_0x010d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceFilterV2Holder(com.blueair.devicedetails.databinding.HolderDeviceFilterV2Binding r8, com.blueair.core.model.Device r9, com.blueair.core.model.DeviceFilterType r10, boolean r11, kotlin.jvm.functions.Function0<kotlin.Unit> r12, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r13) {
        /*
            r7 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "filterType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "onInfoClick"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "openPageAct"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            r0 = r8
            androidx.viewbinding.ViewBinding r0 = (androidx.viewbinding.ViewBinding) r0
            r7.<init>(r0)
            r7.device = r9
            r7.filterType = r10
            r7.hasBuyLink = r11
            r7.onInfoClick = r12
            r7.openPageAct = r13
            int[] r12 = com.blueair.devicedetails.viewholder.DeviceFilterV2Holder.WhenMappings.$EnumSwitchMapping$0
            int r13 = r10.ordinal()
            r12 = r12[r13]
            r13 = 0
            java.lang.String r0 = "ivInfo"
            r1 = 0
            r2 = 1
            if (r12 == r2) goto L_0x00be
            r3 = 2
            if (r12 == r3) goto L_0x007f
            r3 = 3
            if (r12 != r3) goto L_0x0079
            android.widget.ImageView r12 = r8.leadingIcon
            int r3 = com.blueair.viewcore.R.drawable.ic_water_refresher
            r12.setImageResource(r3)
            android.widget.TextView r12 = r8.title
            int r3 = com.blueair.viewcore.R.string.label_water_refresher
            r12.setText(r3)
            com.google.android.material.button.MaterialButton r12 = r8.btnBuy
            int r3 = com.blueair.viewcore.R.string.action_buy_refresher
            r12.setText(r3)
            android.widget.ImageView r12 = r8.ivInfo
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.getRoot()
            android.content.Context r3 = r3.getContext()
            int r4 = com.blueair.viewcore.R.string.more_info_about
            int r5 = com.blueair.viewcore.R.string.label_water_refresher
            java.lang.String r5 = r7.getString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r1] = r5
            java.lang.String r3 = r3.getString(r4, r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r12.setContentDescription(r3)
            android.widget.ImageView r12 = r8.ivInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r12, r1, r2, r13)
            goto L_0x0110
        L_0x0079:
            kotlin.NoWhenBranchMatchedException r8 = new kotlin.NoWhenBranchMatchedException
            r8.<init>()
            throw r8
        L_0x007f:
            android.widget.ImageView r12 = r8.leadingIcon
            int r13 = com.blueair.viewcore.R.drawable.ic_humidity_wick
            r12.setImageResource(r13)
            android.widget.TextView r12 = r8.title
            int r13 = com.blueair.viewcore.R.string.label_wick_filter
            r12.setText(r13)
            com.google.android.material.button.MaterialButton r12 = r8.btnBuy
            int r13 = com.blueair.viewcore.R.string.action_buy_wick_filter
            r12.setText(r13)
            android.widget.ImageView r12 = r8.ivInfo
            androidx.constraintlayout.widget.ConstraintLayout r13 = r8.getRoot()
            android.content.Context r13 = r13.getContext()
            int r3 = com.blueair.viewcore.R.string.more_info_about
            int r4 = com.blueair.viewcore.R.string.label_wick_filter
            java.lang.String r4 = r7.getString(r4)
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r1] = r4
            java.lang.String r13 = r13.getString(r3, r2)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r12.setContentDescription(r13)
            android.widget.ImageView r12 = r8.ivInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r12)
            goto L_0x0110
        L_0x00be:
            android.widget.ImageView r12 = r8.leadingIcon
            int r3 = com.blueair.viewcore.R.drawable.ic_filter_status
            r12.setImageResource(r3)
            android.widget.TextView r12 = r8.title
            int r3 = com.blueair.viewcore.R.string.label_air_filter
            r12.setText(r3)
            com.google.android.material.button.MaterialButton r12 = r8.btnBuy
            int r3 = com.blueair.viewcore.R.string.action_buy_filter
            r12.setText(r3)
            android.widget.ImageView r12 = r8.ivInfo
            androidx.constraintlayout.widget.ConstraintLayout r3 = r8.getRoot()
            android.content.Context r3 = r3.getContext()
            int r4 = com.blueair.viewcore.R.string.more_info_about
            int r5 = com.blueair.viewcore.R.string.label_air_filter
            java.lang.String r5 = r7.getString(r5)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r6[r1] = r5
            java.lang.String r3 = r3.getString(r4, r6)
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r12.setContentDescription(r3)
            android.widget.ImageView r12 = r8.ivInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r0)
            android.view.View r12 = (android.view.View) r12
            boolean r0 = r9 instanceof com.blueair.core.model.DeviceMiniRestful
            if (r0 != 0) goto L_0x010c
            com.blueair.core.model.DeviceType$Companion r0 = com.blueair.core.model.DeviceType.Companion
            if (r9 == 0) goto L_0x0105
            java.lang.String r13 = com.blueair.core.model.DeviceKt.getSkuCompat(r9)
        L_0x0105:
            boolean r13 = r0.isNb411iMax(r13)
            if (r13 != 0) goto L_0x010c
            goto L_0x010d
        L_0x010c:
            r2 = r1
        L_0x010d:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r12, r2)
        L_0x0110:
            androidx.constraintlayout.widget.ConstraintLayout r12 = r8.contentContainer
            java.lang.String r10 = r10.name()
            r12.setTag(r10)
            if (r9 == 0) goto L_0x0128
            boolean r9 = com.blueair.core.model.DeviceKt.shouldMergeFilter(r9)
            if (r9 == 0) goto L_0x0128
            com.google.android.material.button.MaterialButton r9 = r8.btnBuy
            int r10 = com.blueair.viewcore.R.string.btn_buy
            r9.setText(r10)
        L_0x0128:
            com.google.android.material.button.MaterialButton r9 = r8.btnBuy
            com.blueair.devicedetails.viewholder.DeviceFilterV2Holder$$ExternalSyntheticLambda0 r10 = new com.blueair.devicedetails.viewholder.DeviceFilterV2Holder$$ExternalSyntheticLambda0
            r10.<init>(r7)
            r9.setOnClickListener(r10)
            com.google.android.material.button.MaterialButton r9 = r8.btnReplace
            com.blueair.devicedetails.viewholder.DeviceFilterV2Holder$$ExternalSyntheticLambda1 r10 = new com.blueair.devicedetails.viewholder.DeviceFilterV2Holder$$ExternalSyntheticLambda1
            r10.<init>(r7)
            r9.setOnClickListener(r10)
            android.widget.ImageView r9 = r8.ivInfo
            com.blueair.devicedetails.viewholder.DeviceFilterV2Holder$$ExternalSyntheticLambda2 r10 = new com.blueair.devicedetails.viewholder.DeviceFilterV2Holder$$ExternalSyntheticLambda2
            r10.<init>(r7)
            r9.setOnClickListener(r10)
            com.google.android.material.button.MaterialButton r8 = r8.btnBuy
            java.lang.String r9 = "btnBuy"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            android.view.View r8 = (android.view.View) r8
            if (r11 == 0) goto L_0x0152
            goto L_0x0154
        L_0x0152:
            r1 = 8
        L_0x0154:
            r8.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceFilterV2Holder.<init>(com.blueair.devicedetails.databinding.HolderDeviceFilterV2Binding, com.blueair.core.model.Device, com.blueair.core.model.DeviceFilterType, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1):void");
    }

    static final void lambda$4$lambda$1(DeviceFilterV2Holder deviceFilterV2Holder, View view) {
        deviceFilterV2Holder.openPageAct.invoke(true);
    }

    static final void lambda$4$lambda$2(DeviceFilterV2Holder deviceFilterV2Holder, View view) {
        deviceFilterV2Holder.openPageAct.invoke(false);
    }

    static final void lambda$4$lambda$3(DeviceFilterV2Holder deviceFilterV2Holder, View view) {
        deviceFilterV2Holder.onInfoClick.invoke();
    }

    public void update(Device device2, boolean z) {
        Integer num;
        Intrinsics.checkNotNullParameter(device2, "device");
        int i = WhenMappings.$EnumSwitchMapping$0[this.filterType.ordinal()];
        if (i != 1) {
            if (i == 2) {
                HasWick hasWick = device2 instanceof HasWick ? (HasWick) device2 : null;
                if (hasWick != null) {
                    num = Integer.valueOf(hasWick.getWickLifeLeft());
                }
            } else if (i == 3) {
                HasRemoveYellowWater hasRemoveYellowWater = device2 instanceof HasRemoveYellowWater ? (HasRemoveYellowWater) device2 : null;
                if (hasRemoveYellowWater != null) {
                    num = Integer.valueOf(hasRemoveYellowWater.getRefresherLifeLeft());
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
            num = null;
        } else {
            num = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(device2);
        }
        Context context = ((HolderDeviceFilterV2Binding) getBinding()).progressText.getContext();
        if (!(device2 instanceof HasRemoveYellowWater) || !Intrinsics.areEqual((Object) ((HasRemoveYellowWater) device2).getYwrmEnabled(), (Object) false) || this.filterType != DeviceFilterType.REFRESHER) {
            ((HolderDeviceFilterV2Binding) getBinding()).progressText.setOnClickListener(new DeviceFilterV2Holder$$ExternalSyntheticLambda3(this));
            ((HolderDeviceFilterV2Binding) getBinding()).progressText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_right_v2, 0);
            Group group = ((HolderDeviceFilterV2Binding) getBinding()).groupLife;
            Intrinsics.checkNotNullExpressionValue(group, "groupLife");
            ViewExtensionsKt.show$default(group, false, 1, (Object) null);
            MaterialButton materialButton = ((HolderDeviceFilterV2Binding) getBinding()).btnBuy;
            Intrinsics.checkNotNullExpressionValue(materialButton, "btnBuy");
            materialButton.setVisibility(this.hasBuyLink ? 0 : 8);
            if (z || !device2.isOnline()) {
                ((HolderDeviceFilterV2Binding) getBinding()).progressText.setText(getString(R.string.offline_label));
                ((HolderDeviceFilterV2Binding) getBinding()).progressIndicator.setProgress(0);
            } else if (num != null) {
                int intValue = num.intValue();
                AppCompatTextView appCompatTextView = ((HolderDeviceFilterV2Binding) getBinding()).progressText;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String format = String.format(getString(R.string.percentage_left), Arrays.copyOf(new Object[]{Integer.valueOf(intValue)}, 1));
                Intrinsics.checkNotNullExpressionValue(format, "format(...)");
                appCompatTextView.setText(format);
                ((HolderDeviceFilterV2Binding) getBinding()).progressIndicator.setProgress(intValue);
                if (intValue > 10) {
                    ((HolderDeviceFilterV2Binding) getBinding()).progressIndicator.setIndicatorColor(ContextCompat.getColor(context, R.color.colorPrimary));
                } else {
                    ((HolderDeviceFilterV2Binding) getBinding()).progressIndicator.setIndicatorColor(ContextCompat.getColor(context, R.color.fill_warning));
                }
                Group group2 = ((HolderDeviceFilterV2Binding) getBinding()).groupProgress;
                Intrinsics.checkNotNullExpressionValue(group2, "groupProgress");
                ViewExtensionsKt.show$default(group2, false, 1, (Object) null);
            } else {
                new DeviceFilterV2Holder$$ExternalSyntheticLambda4(this);
            }
        } else {
            ((HolderDeviceFilterV2Binding) getBinding()).progressText.setCompoundDrawablesRelativeWithIntrinsicBounds(0, 0, 0, 0);
            ((HolderDeviceFilterV2Binding) getBinding()).progressText.setText(getString(R.string.inactive));
            Group group3 = ((HolderDeviceFilterV2Binding) getBinding()).groupLife;
            Intrinsics.checkNotNullExpressionValue(group3, "groupLife");
            ViewExtensionsKt.hide(group3);
            MaterialButton materialButton2 = ((HolderDeviceFilterV2Binding) getBinding()).btnBuy;
            Intrinsics.checkNotNullExpressionValue(materialButton2, "btnBuy");
            ViewExtensionsKt.hide(materialButton2);
            ((HolderDeviceFilterV2Binding) getBinding()).progressText.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$5(DeviceFilterV2Holder deviceFilterV2Holder, View view) {
        deviceFilterV2Holder.openPageAct.invoke(false);
    }

    /* access modifiers changed from: private */
    public static final Unit update$lambda$7(DeviceFilterV2Holder deviceFilterV2Holder) {
        Group group = ((HolderDeviceFilterV2Binding) deviceFilterV2Holder.getBinding()).groupProgress;
        Intrinsics.checkNotNullExpressionValue(group, "groupProgress");
        ViewExtensionsKt.hide(group);
        return Unit.INSTANCE;
    }
}
