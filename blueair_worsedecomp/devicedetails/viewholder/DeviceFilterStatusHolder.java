package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.AwsLinkConfig;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceFilterType;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterConfig;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasSKU;
import com.blueair.devicedetails.databinding.HolderDeviceFilterStatusBinding;
import com.blueair.viewcore.R;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.google.android.material.button.MaterialButton;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import timber.log.Timber;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB2\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u0016\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0006J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0010\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\nH\u0002J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0003J\u0010\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterStatusHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceFilterStatusBinding;", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceFilterStatusBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceFilterStatusBinding;", "update", "device", "Lcom/blueair/core/model/Device;", "fromFilterPage", "setOnlineView", "Lcom/blueair/core/model/HasFanSpeed;", "setOfflineView", "updateFilterTimeView", "filterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "updateProgressBar", "", "updateFilterStatusView", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceFilterStatusHolder.kt */
public final class DeviceFilterStatusHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceFilterStatusBinding binding;
    private final Function1<Boolean, Unit> onOpenFilterPageListener;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterStatusHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ConnectivityStatus.values().length];
            try {
                iArr[ConnectivityStatus.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final HolderDeviceFilterStatusBinding getBinding() {
        return this.binding;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceFilterStatusHolder(com.blueair.devicedetails.databinding.HolderDeviceFilterStatusBinding r3, kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onOpenFilterPageListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.onOpenFilterPageListener = r4
            com.google.android.material.button.MaterialButton r4 = r3.howToReplace
            com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder$$ExternalSyntheticLambda0 r0 = new com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder$$ExternalSyntheticLambda0
            r0.<init>(r2)
            r4.setOnClickListener(r0)
            com.google.android.material.button.MaterialButton r4 = r3.buyNew
            com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder$$ExternalSyntheticLambda1 r0 = new com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder$$ExternalSyntheticLambda1
            r0.<init>(r2)
            r4.setOnClickListener(r0)
            com.google.android.material.button.MaterialButton r3 = r3.filterReplacement
            com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder$$ExternalSyntheticLambda2 r4 = new com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder$$ExternalSyntheticLambda2
            r4.<init>(r2)
            r3.setOnClickListener(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceFilterStatusHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceFilterStatusBinding, kotlin.jvm.functions.Function1):void");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072!\u0010\b\u001a\u001d\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\t¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceFilterStatusHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceFilterStatusHolder;", "parentView", "Landroid/view/ViewGroup;", "onOpenFilterPageListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "onlyBuy", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceFilterStatusHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceFilterStatusHolder newInstance(ViewGroup viewGroup, Function1<? super Boolean, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onOpenFilterPageListener");
            HolderDeviceFilterStatusBinding inflate = HolderDeviceFilterStatusBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceFilterStatusHolder(inflate, function1);
        }
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$0(DeviceFilterStatusHolder deviceFilterStatusHolder, View view) {
        deviceFilterStatusHolder.onOpenFilterPageListener.invoke(false);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$1(DeviceFilterStatusHolder deviceFilterStatusHolder, View view) {
        deviceFilterStatusHolder.onOpenFilterPageListener.invoke(true);
    }

    /* access modifiers changed from: private */
    public static final void _init_$lambda$2(DeviceFilterStatusHolder deviceFilterStatusHolder, View view) {
        deviceFilterStatusHolder.onOpenFilterPageListener.invoke(false);
    }

    public final void update(Device device, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        update(device);
        MaterialButton materialButton = this.binding.filterReplacement;
        Intrinsics.checkNotNullExpressionValue(materialButton, "filterReplacement");
        ViewExtensionsKt.show(materialButton, !z);
    }

    public void update(Device device) {
        Intrinsics.checkNotNullParameter(device, "device");
        AwsLinkConfig awsLinkConfig = null;
        HasFanSpeed hasFanSpeed = device instanceof HasFanSpeed ? (HasFanSpeed) device : null;
        if (hasFanSpeed != null) {
            Timber.Forest forest = Timber.Forest;
            StringBuilder sb = new StringBuilder("device:  filter life =  ");
            HasFanSpeed hasFanSpeed2 = (HasFanSpeed) device;
            sb.append(hasFanSpeed2.getFilterLife());
            sb.append(", filter lifetime =  ");
            sb.append(DeviceKt.getFilterLifeTime(device));
            sb.append("  & filter trigger = ");
            sb.append(hasFanSpeed2.getFilterTrigger());
            boolean z = false;
            forest.d(sb.toString(), new Object[0]);
            if (WhenMappings.$EnumSwitchMapping$0[device.getConnectivityStatus().ordinal()] == 1) {
                setOnlineView(hasFanSpeed2);
            } else {
                setOfflineView();
            }
            if (StringsKt.contains$default((CharSequence) hasFanSpeed.getModelName(), (CharSequence) "511i", false, 2, (Object) null) && (hasFanSpeed instanceof HasSKU)) {
                MaterialButton materialButton = this.binding.filterReplacement;
                Intrinsics.checkNotNullExpressionValue(materialButton, "filterReplacement");
                ViewExtensionsKt.hide(materialButton);
                FilterConfig filterConfig$default = DeviceConfigProvider.getFilterConfig$default(DeviceConfigProvider.INSTANCE, (Device) hasFanSpeed, (DeviceFilterType) null, 2, (Object) null);
                MaterialButton materialButton2 = this.binding.howToReplace;
                Intrinsics.checkNotNullExpressionValue(materialButton2, "howToReplace");
                View view = materialButton2;
                DeviceConfigProvider deviceConfigProvider = DeviceConfigProvider.INSTANCE;
                if (filterConfig$default != null) {
                    awsLinkConfig = filterConfig$default.getVideo();
                }
                CharSequence awsLinkValue = deviceConfigProvider.getAwsLinkValue(awsLinkConfig);
                if (awsLinkValue == null || awsLinkValue.length() == 0) {
                    z = true;
                }
                ViewExtensionsKt.show(view, !z);
                MaterialButton materialButton3 = this.binding.buyNew;
                Intrinsics.checkNotNullExpressionValue(materialButton3, "buyNew");
                ViewExtensionsKt.show(materialButton3, DeviceConfigProvider.INSTANCE.hasBuyFilterLink(filterConfig$default));
            }
        }
    }

    private final void setOnlineView(HasFanSpeed hasFanSpeed) {
        FilterLifeTime filterLifeTime = DeviceKt.getFilterLifeTime(hasFanSpeed);
        updateFilterTimeView(filterLifeTime);
        updateFilterStatusView(filterLifeTime);
    }

    private final void setOfflineView() {
        this.binding.filterTimeLeftView.setText(this.itemView.getContext().getText(R.string.offline_label));
        TextView textView = this.binding.filterTimePercentView;
        Intrinsics.checkNotNullExpressionValue(textView, "filterTimePercentView");
        ViewExtensionsKt.show(textView, false);
    }

    private final void updateFilterTimeView(FilterLifeTime filterLifeTime) {
        if (filterLifeTime instanceof FilterLifeTime.FilterDaysLeft) {
            TextView textView = this.binding.filterTimeLeftView;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = this.itemView.getContext().getString(R.string.filter_usage);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            FilterLifeTime.FilterDaysLeft filterDaysLeft = (FilterLifeTime.FilterDaysLeft) filterLifeTime;
            String format = String.format(string, Arrays.copyOf(new Object[]{Integer.valueOf(filterDaysLeft.getFilterLife())}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            textView.setText(format);
            TextView textView2 = this.binding.filterTimePercentView;
            Intrinsics.checkNotNullExpressionValue(textView2, "filterTimePercentView");
            ViewExtensionsKt.show(textView2, false);
            Integer filterLifePercentage = filterDaysLeft.getFilterLifePercentage();
            if (filterLifePercentage != null) {
                int intValue = filterLifePercentage.intValue();
                this.binding.progress.setProgress(intValue);
                updateProgressBar(intValue);
            }
        } else if (filterLifeTime instanceof FilterLifeTime.FilterPercentageLeft) {
            this.binding.filterTimeLeftView.setText(this.itemView.getContext().getString(R.string.filter_time_left));
            TextView textView3 = this.binding.filterTimePercentView;
            Intrinsics.checkNotNullExpressionValue(textView3, "filterTimePercentView");
            ViewExtensionsKt.show(textView3, true);
            TextView textView4 = this.binding.filterTimePercentView;
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            FilterLifeTime.FilterPercentageLeft filterPercentageLeft = (FilterLifeTime.FilterPercentageLeft) filterLifeTime;
            String format2 = String.format("%d%s", Arrays.copyOf(new Object[]{Integer.valueOf(filterPercentageLeft.getFilterLife()), "%"}, 2));
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            textView4.setText(format2);
            this.binding.progress.setProgress(filterPercentageLeft.getFilterLife());
            updateProgressBar(filterPercentageLeft.getFilterLife());
        } else if (!(filterLifeTime instanceof FilterLifeTime.NoFilterInfo)) {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void updateProgressBar(int i) {
        if (i > 10) {
            this.binding.progress.setIndicatorColor(ContextCompat.getColor(this.binding.progress.getContext(), R.color.colorPrimary));
        } else {
            this.binding.progress.setIndicatorColor(ContextCompat.getColor(this.binding.progress.getContext(), R.color.fill_warning));
        }
    }

    private final void updateFilterStatusView(FilterLifeTime filterLifeTime) {
        boolean z = filterLifeTime.getFilterLife() <= 0;
        if (z) {
            this.binding.filterTimeLeftView.setText(this.itemView.getContext().getText(R.string.filter_has_expired));
        }
        TextView textView = this.binding.filterTimePercentView;
        Intrinsics.checkNotNullExpressionValue(textView, "filterTimePercentView");
        ViewExtensionsKt.show(textView, !z);
        TextView textView2 = this.binding.filterChangeView;
        Intrinsics.checkNotNullExpressionValue(textView2, "filterChangeView");
        ViewExtensionsKt.show(textView2, z);
        this.binding.filterTimePercentView.setTextColor(DeviceConfigProvider.INSTANCE.getFilterStatusColor(filterLifeTime));
    }
}
