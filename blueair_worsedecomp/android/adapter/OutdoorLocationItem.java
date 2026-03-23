package com.blueair.android.adapter;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.blueair.android.R;
import com.blueair.android.databinding.HolderOutdoorLocationBinding;
import com.blueair.core.model.AqiData;
import com.blueair.core.model.OutdoorPollutants;
import com.blueair.core.model.PollutantType;
import com.blueair.core.model.TrackedLocation;
import com.blueair.core.util.LocationUtils;
import com.blueair.core.util.OutdoorAirRatingRanges;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.OutdoorUiUtils;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 *2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001*B)\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u001e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"H\u0016J\u0010\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u0010\u0010&\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u0002H\u0002J\u000e\u0010'\u001a\u00020\b2\u0006\u0010(\u001a\u00020)R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/blueair/android/adapter/OutdoorLocationItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/android/databinding/HolderOutdoorLocationBinding;", "trackedLocation", "Lcom/blueair/core/model/TrackedLocation;", "aqiData", "Lcom/blueair/core/model/AqiData;", "useCurrentLocation", "", "<init>", "(Lcom/blueair/core/model/TrackedLocation;Lcom/blueair/core/model/AqiData;Z)V", "getTrackedLocation", "()Lcom/blueair/core/model/TrackedLocation;", "setTrackedLocation", "(Lcom/blueair/core/model/TrackedLocation;)V", "getAqiData", "()Lcom/blueair/core/model/AqiData;", "setAqiData", "(Lcom/blueair/core/model/AqiData;)V", "getUseCurrentLocation", "()Z", "type", "", "getType", "()I", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "bindView", "", "binding", "payloads", "", "", "hydrateProgress", "hydrateAqiData", "hydrateTrackedLocation", "isLocationEnable", "context", "Landroid/content/Context;", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: OutdoorLocationItem.kt */
public final class OutdoorLocationItem extends AbstractBindingItem<HolderOutdoorLocationBinding> {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PAYLOAD_AQIDATA = "payload_aqidata";
    public static final String PAYLOAD_PROGRESS = "payload_progress";
    public static final String PAYLOAD_TRACKED_LOCATION = "payload_tracked_location";
    private AqiData aqiData;
    private TrackedLocation trackedLocation;
    private final int type;
    private final boolean useCurrentLocation;

    public OutdoorLocationItem() {
        this((TrackedLocation) null, (AqiData) null, false, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ OutdoorLocationItem(TrackedLocation trackedLocation2, AqiData aqiData2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : trackedLocation2, (i & 2) != 0 ? null : aqiData2, (i & 4) != 0 ? false : z);
    }

    public final TrackedLocation getTrackedLocation() {
        return this.trackedLocation;
    }

    public final void setTrackedLocation(TrackedLocation trackedLocation2) {
        this.trackedLocation = trackedLocation2;
    }

    public final AqiData getAqiData() {
        return this.aqiData;
    }

    public final void setAqiData(AqiData aqiData2) {
        this.aqiData = aqiData2;
    }

    public final boolean getUseCurrentLocation() {
        return this.useCurrentLocation;
    }

    public OutdoorLocationItem(TrackedLocation trackedLocation2, AqiData aqiData2, boolean z) {
        this.trackedLocation = trackedLocation2;
        this.aqiData = aqiData2;
        this.useCurrentLocation = z;
        this.type = R.layout.holder_outdoor_location;
    }

    public int getType() {
        return this.type;
    }

    public HolderOutdoorLocationBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderOutdoorLocationBinding inflate = HolderOutdoorLocationBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void bindView(HolderOutdoorLocationBinding holderOutdoorLocationBinding, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(holderOutdoorLocationBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        if (!list.isEmpty()) {
            for (Object next : list) {
                if (Intrinsics.areEqual((Object) next, (Object) PAYLOAD_TRACKED_LOCATION)) {
                    hydrateTrackedLocation(holderOutdoorLocationBinding);
                } else if (Intrinsics.areEqual((Object) next, (Object) PAYLOAD_AQIDATA)) {
                    hydrateAqiData(holderOutdoorLocationBinding);
                } else if (Intrinsics.areEqual((Object) next, (Object) PAYLOAD_PROGRESS)) {
                    hydrateProgress(holderOutdoorLocationBinding);
                }
            }
        } else {
            hydrateTrackedLocation(holderOutdoorLocationBinding);
            hydrateAqiData(holderOutdoorLocationBinding);
        }
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        ConstraintLayout root = holderOutdoorLocationBinding.getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, root, (KClass) null, holderOutdoorLocationBinding.getRoot().getContext().getString(com.blueair.viewcore.R.string.button_role), (Function2) null, 10, (Object) null);
    }

    private final void hydrateProgress(HolderOutdoorLocationBinding holderOutdoorLocationBinding) {
        LottieAnimationView lottieAnimationView = holderOutdoorLocationBinding.progressView;
        Intrinsics.checkNotNullExpressionValue(lottieAnimationView, "progressView");
        ViewExtensionsKt.show$default(lottieAnimationView, false, 1, (Object) null);
        holderOutdoorLocationBinding.progressView.playAnimation();
    }

    private final void hydrateAqiData(HolderOutdoorLocationBinding holderOutdoorLocationBinding) {
        OutdoorPollutants pollutants;
        AqiData aqiData2 = this.aqiData;
        if (aqiData2 != null && (pollutants = aqiData2.getPollutants()) != null) {
            Double calculatedAQI = pollutants.getCalculatedAQI();
            int pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getPollutantRangePosition(calculatedAQI != null ? (float) calculatedAQI.doubleValue() : 0.0f, PollutantType.AQI.INSTANCE);
            if (pollutantRangePosition < 0) {
                pollutantRangePosition = OutdoorAirRatingRanges.INSTANCE.getMaxPollutantRangePosition(PollutantType.AQI.INSTANCE);
            }
            Context context = holderOutdoorLocationBinding.getRoot().getContext();
            holderOutdoorLocationBinding.airQualityIndicator.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(context, OutdoorUiUtils.INSTANCE.getAqiSeverityColorsNew().get(pollutantRangePosition).intValue())));
            holderOutdoorLocationBinding.tvAirQuality.setText(context.getResources().getStringArray(com.blueair.viewcore.R.array.severity_strings)[pollutantRangePosition]);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: IfRegionVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Don't wrap MOVE or CONST insns: 0x0077: MOVE  (r9v5 java.lang.CharSequence) = (r4v2 java.lang.String)
        	at jadx.core.dex.instructions.args.InsnArg.wrapArg(InsnArg.java:164)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.assignInline(CodeShrinkVisitor.java:133)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.checkInline(CodeShrinkVisitor.java:118)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkBlock(CodeShrinkVisitor.java:65)
        	at jadx.core.dex.visitors.shrink.CodeShrinkVisitor.shrinkMethod(CodeShrinkVisitor.java:43)
        	at jadx.core.dex.visitors.regions.TernaryMod.makeTernaryInsn(TernaryMod.java:122)
        	at jadx.core.dex.visitors.regions.TernaryMod.visitRegion(TernaryMod.java:34)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:73)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:78)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.IfRegionVisitor.visit(IfRegionVisitor.java:31)
        */
    private final void hydrateTrackedLocation(com.blueair.android.databinding.HolderOutdoorLocationBinding r12) {
        /*
            r11 = this;
            androidx.constraintlayout.widget.ConstraintLayout r0 = r12.getRoot()
            android.content.Context r0 = r0.getContext()
            boolean r1 = r11.useCurrentLocation
            java.lang.String r2 = "groupInfo"
            r3 = 1
            java.lang.String r4 = "tvEnableLocation"
            r5 = 0
            r6 = 0
            if (r1 == 0) goto L_0x0031
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            boolean r1 = r11.isLocationEnable(r0)
            if (r1 != 0) goto L_0x0031
            androidx.appcompat.widget.AppCompatTextView r0 = r12.tvEnableLocation
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            android.view.View r0 = (android.view.View) r0
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r0, r6, r3, r5)
            androidx.constraintlayout.widget.Group r12 = r12.groupInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r12)
            return
        L_0x0031:
            com.blueair.core.model.TrackedLocation r1 = r11.trackedLocation
            if (r1 == 0) goto L_0x003e
            com.airbnb.lottie.LottieAnimationView r1 = r12.progressView
            r7 = 4
            r1.setVisibility(r7)
            r1.pauseAnimation()
        L_0x003e:
            androidx.appcompat.widget.AppCompatTextView r1 = r12.tvEnableLocation
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            android.view.View r1 = (android.view.View) r1
            io.flatcircle.viewhelper.ViewExtensionsKt.hide(r1)
            com.blueair.core.model.TrackedLocation r1 = r11.trackedLocation
            if (r1 == 0) goto L_0x0051
            java.lang.String r1 = r1.getLocationName()
            goto L_0x0052
        L_0x0051:
            r1 = r5
        L_0x0052:
            com.blueair.core.model.TrackedLocation r4 = r11.trackedLocation
            if (r4 == 0) goto L_0x005b
            java.lang.String r4 = r4.getCityName()
            goto L_0x005c
        L_0x005b:
            r4 = r5
        L_0x005c:
            com.blueair.core.model.TrackedLocation r7 = r11.trackedLocation
            if (r7 == 0) goto L_0x0065
            java.lang.String r7 = r7.getCountryName()
            goto L_0x0066
        L_0x0065:
            r7 = r5
        L_0x0066:
            androidx.appcompat.widget.AppCompatTextView r8 = r12.tvLocation
            r9 = r1
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            java.lang.String r10 = ", "
            if (r9 == 0) goto L_0x0097
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0076
            goto L_0x0097
        L_0x0076:
            r9 = r4
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9
            if (r9 == 0) goto L_0x0097
            int r9 = r9.length()
            if (r9 != 0) goto L_0x0082
            goto L_0x0097
        L_0x0082:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r10)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x00e9
        L_0x0097:
            r1 = r4
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00a2
            int r1 = r1.length()
            if (r1 != 0) goto L_0x00ae
        L_0x00a2:
            r1 = r7
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x00c3
            int r9 = r1.length()
            if (r9 != 0) goto L_0x00ae
            goto L_0x00c3
        L_0x00ae:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r4)
            r0.append(r10)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x00e9
        L_0x00c3:
            if (r1 == 0) goto L_0x00ce
            int r4 = r1.length()
            if (r4 != 0) goto L_0x00cc
            goto L_0x00ce
        L_0x00cc:
            r0 = r1
            goto L_0x00e9
        L_0x00ce:
            boolean r1 = r11.useCurrentLocation
            if (r1 == 0) goto L_0x00de
            int r1 = com.blueair.viewcore.R.string.outdoor_location_current
            java.lang.String r0 = r0.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            goto L_0x00e9
        L_0x00de:
            int r1 = com.blueair.viewcore.R.string.unknown_city_placeholder
            java.lang.String r0 = r0.getString(r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
        L_0x00e9:
            r8.setText(r0)
            boolean r0 = r11.useCurrentLocation
            if (r0 == 0) goto L_0x00f3
            int r0 = com.blueair.viewcore.R.drawable.ic_current_location
            goto L_0x00f5
        L_0x00f3:
            int r0 = com.blueair.viewcore.R.drawable.ic_user_location
        L_0x00f5:
            r8.setCompoundDrawablesRelativeWithIntrinsicBounds((int) r0, (int) r6, (int) r6, (int) r6)
            androidx.constraintlayout.widget.Group r12 = r12.groupInfo
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r12, r2)
            android.view.View r12 = (android.view.View) r12
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r12, r6, r3, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.adapter.OutdoorLocationItem.hydrateTrackedLocation(com.blueair.android.databinding.HolderOutdoorLocationBinding):void");
    }

    public final boolean isLocationEnable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return LocationUtils.INSTANCE.isLocationPermissionGranted(context) && LocationUtils.INSTANCE.isLocationEnabled(context);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/blueair/android/adapter/OutdoorLocationItem$Companion;", "", "<init>", "()V", "PAYLOAD_TRACKED_LOCATION", "", "PAYLOAD_AQIDATA", "PAYLOAD_PROGRESS", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: OutdoorLocationItem.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
