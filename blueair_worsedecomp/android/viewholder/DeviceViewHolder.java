package com.blueair.android.viewholder;

import android.content.Context;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.HolderDeviceBinding;
import com.blueair.core.model.ApSubMode;
import com.blueair.core.model.AutoMode;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.core.model.DeviceImage;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasAlarm;
import com.blueair.core.model.HasEcoMode;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.model.HasG4NightMode;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.HasStandBy;
import com.blueair.core.model.HasWick;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.Mode;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.ViewUtils;
import com.blueair.viewcore.utils.DeviceConfigProvider;
import com.blueair.viewcore.utils.ModeIcon;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.blueair.viewcore.view.SwitchCompat;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Calendar;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty;
import org.joda.time.DateTimeConstants;
import org.kodein.di.DI;
import org.kodein.di.DIAware;
import org.kodein.di.DIContext;
import org.kodein.di.DITrigger;
import org.kodein.di.android.ClosestKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 Z2\u00020\u00012\u00020\u0002:\u0001ZB\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J \u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010'\u001a\u00020(J\u0018\u0010)\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010*\u001a\u00020(H\u0002J\u001a\u0010+\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\u0018\u0010,\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0002J\u001f\u00103\u001a\u00020\"2\u0006\u0010#\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106H\u0002¢\u0006\u0002\u00107J\b\u00108\u001a\u00020\"H\u0002J\u0010\u00109\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010:\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010;\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\u0006\u0010<\u001a\u00020=H\u0002J\u0018\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u000202H\u0002J\u0018\u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u0002022\u0006\u0010A\u001a\u00020BH\u0002J \u0010>\u001a\u00020\"2\u0006\u0010?\u001a\u0002022\u0006\u0010@\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u00020\"2\u0006\u0010@\u001a\u000202H\u0002J\u0010\u0010F\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u001a\u0010G\u001a\u00020\"2\u0006\u0010H\u001a\u0002022\b\b\u0002\u0010I\u001a\u00020(H\u0002J\u001a\u0010J\u001a\u00020\"2\u0006\u0010#\u001a\u0002042\b\u0010%\u001a\u0004\u0018\u00010&H\u0002J\b\u0010K\u001a\u00020\"H\u0002J\b\u0010L\u001a\u00020\"H\u0002J!\u0010M\u001a\u00020\"2\u0012\u0010N\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140O\"\u00020\u0014H\u0002¢\u0006\u0002\u0010PJ\u0010\u0010Q\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0010\u0010R\u001a\u0002022\u0006\u0010S\u001a\u000202H\u0002J)\u0010T\u001a\u0002002\u0006\u0010U\u001a\u0002022\u0012\u0010V\u001a\n\u0012\u0006\b\u0001\u0012\u00020W0O\"\u00020WH\u0002¢\u0006\u0002\u0010XJ\b\u0010Y\u001a\u000200H\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\t\u001a\u00020\n8VX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0017\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u000e\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u001e\u001a\n  *\u0004\u0018\u00010\u001f0\u001fX\u0004¢\u0006\u0002\n\u0000¨\u0006["}, d2 = {"Lcom/blueair/android/viewholder/DeviceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lorg/kodein/di/DIAware;", "binding", "Lcom/blueair/android/databinding/HolderDeviceBinding;", "<init>", "(Lcom/blueair/android/databinding/HolderDeviceBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/HolderDeviceBinding;", "di", "Lorg/kodein/di/DI;", "getDi", "()Lorg/kodein/di/DI;", "di$delegate", "Lkotlin/Lazy;", "clickView", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getClickView", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "standByModeClickView", "Landroid/view/View;", "getStandByModeClickView", "()Landroid/view/View;", "offlineInfoView", "getOfflineInfoView", "timeFormatter", "Ljava/text/SimpleDateFormat;", "getTimeFormatter", "()Ljava/text/SimpleDateFormat;", "timeFormatter$delegate", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "update", "", "device", "Lcom/blueair/core/model/Device;", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "forceOffline", "", "hydrateStandby", "offline", "setOnlineDevice", "hydrateMode", "mode", "Lcom/blueair/core/model/Mode;", "formatCountdownText", "", "leftSeconds", "", "hydrateHumidity", "Lcom/blueair/core/model/HasSensorData;", "hum", "", "(Lcom/blueair/core/model/HasSensorData;Ljava/lang/Float;)V", "setOfflineDevice", "setSafetySwitchOffDevice", "showDeviceMode", "showDeviceApSubMode", "subMode", "Lcom/blueair/core/model/ApSubMode;", "showMode", "offset", "iconRes", "modeIcon", "Lcom/blueair/viewcore/utils/ModeIcon;", "text", "", "showWarning", "showFilterWickStatus", "hydrateFilterStatus", "lifeLeft", "wickFilter", "showAirQuality", "hideMode1", "hideMode2", "hideViews", "views", "", "([Landroid/view/View;)V", "hydrateAlarm", "getColor", "colorRes", "getString", "textRes", "formatArgs", "", "(I[Ljava/lang/Object;)Ljava/lang/String;", "fetchPattern", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceViewHolder.kt */
public final class DeviceViewHolder extends RecyclerView.ViewHolder implements DIAware {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(DeviceViewHolder.class, "di", "getDi()Lorg/kodein/di/DI;", 0))};
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDeviceBinding binding;
    private final Calendar calendar = Calendar.getInstance();
    private final ConstraintLayout clickView;
    private final Lazy di$delegate;
    private final View offlineInfoView;
    private final View standByModeClickView;
    private final Lazy timeFormatter$delegate = LazyKt.lazy(new DeviceViewHolder$$ExternalSyntheticLambda0(this));

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceViewHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;

        /* JADX WARNING: Can't wrap try/catch for region: R(35:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|(2:21|22)|23|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(37:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|(2:33|34)|35|37|38|39|40|41|42|43|44|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(39:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|47) */
        /* JADX WARNING: Can't wrap try/catch for region: R(40:0|1|2|3|5|6|7|9|10|11|13|14|15|16|17|18|19|(2:21|22)|23|25|26|27|28|29|30|31|32|33|34|35|37|38|39|40|41|42|43|44|45|47) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0065 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0075 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x008f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x009f */
        static {
            /*
                com.blueair.core.model.DehSubMode[] r0 = com.blueair.core.model.DehSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.blueair.core.model.DehSubMode r2 = com.blueair.core.model.DehSubMode.DRYING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.blueair.core.model.DehSubMode r3 = com.blueair.core.model.DehSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.blueair.core.model.DehSubMode r4 = com.blueair.core.model.DehSubMode.CONTINUOUS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.blueair.core.model.MainMode[] r0 = com.blueair.core.model.MainMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.MainMode r4 = com.blueair.core.model.MainMode.SMART     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.blueair.core.model.MainMode r4 = com.blueair.core.model.MainMode.AirPurify     // Catch:{ NoSuchFieldError -> 0x003b }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r4] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.blueair.core.model.MainMode r4 = com.blueair.core.model.MainMode.COOL     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                r4 = 4
                com.blueair.core.model.MainMode r5 = com.blueair.core.model.MainMode.HEAT     // Catch:{ NoSuchFieldError -> 0x004c }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                $EnumSwitchMapping$1 = r0
                com.blueair.core.model.Mode[] r0 = com.blueair.core.model.Mode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.FAN     // Catch:{ NoSuchFieldError -> 0x005d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.AUTO     // Catch:{ NoSuchFieldError -> 0x0065 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0065 }
                r0[r5] = r2     // Catch:{ NoSuchFieldError -> 0x0065 }
            L_0x0065:
                com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.NIGHT     // Catch:{ NoSuchFieldError -> 0x006d }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x006d }
                r0[r5] = r3     // Catch:{ NoSuchFieldError -> 0x006d }
            L_0x006d:
                com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.ECO     // Catch:{ NoSuchFieldError -> 0x0075 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0075 }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x0075 }
            L_0x0075:
                com.blueair.core.model.Mode r5 = com.blueair.core.model.Mode.SKIN     // Catch:{ NoSuchFieldError -> 0x007e }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x007e }
                r6 = 5
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x007e }
            L_0x007e:
                $EnumSwitchMapping$2 = r0
                com.blueair.core.model.ApSubMode[] r0 = com.blueair.core.model.ApSubMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.ApSubMode r5 = com.blueair.core.model.ApSubMode.FAN     // Catch:{ NoSuchFieldError -> 0x008f }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x008f }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x008f }
            L_0x008f:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.AUTO     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.NIGHT     // Catch:{ NoSuchFieldError -> 0x009f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009f }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x009f }
            L_0x009f:
                com.blueair.core.model.ApSubMode r1 = com.blueair.core.model.ApSubMode.ECO     // Catch:{ NoSuchFieldError -> 0x00a7 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a7 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x00a7 }
            L_0x00a7:
                $EnumSwitchMapping$3 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewholder.DeviceViewHolder.WhenMappings.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceViewHolder(HolderDeviceBinding holderDeviceBinding) {
        super(holderDeviceBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDeviceBinding, "binding");
        this.binding = holderDeviceBinding;
        Context context = this.itemView.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        this.di$delegate = ClosestKt.closestDI(context).provideDelegate(this, $$delegatedProperties[0]);
        ConstraintLayout constraintLayout = holderDeviceBinding.foregroundLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "foregroundLayout");
        this.clickView = constraintLayout;
        SwitchCompat switchCompat = holderDeviceBinding.standbySwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "standbySwitch");
        this.standByModeClickView = switchCompat;
        ImageView imageView = holderDeviceBinding.ivOfflineInfo;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivOfflineInfo");
        this.offlineInfoView = imageView;
        ViewUtils viewUtils = ViewUtils.INSTANCE;
        ConstraintLayout constraintLayout2 = holderDeviceBinding.foregroundLayout;
        Intrinsics.checkNotNullExpressionValue(constraintLayout2, "foregroundLayout");
        ViewUtils.setAccessibilityDelegate$default(viewUtils, constraintLayout2, (KClass) null, getString(R.string.button_role, new Object[0]), (Function2) null, 10, (Object) null);
        holderDeviceBinding.ivOfflineInfo.setContentDescription(holderDeviceBinding.getRoot().getContext().getString(R.string.more_info_about, new Object[]{getString(R.string.offline_label, new Object[0])}));
    }

    public final HolderDeviceBinding getBinding() {
        return this.binding;
    }

    public DIContext<?> getDiContext() {
        return DIAware.DefaultImpls.getDiContext(this);
    }

    public DITrigger getDiTrigger() {
        return DIAware.DefaultImpls.getDiTrigger(this);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/viewholder/DeviceViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/viewholder/DeviceViewHolder;", "parentView", "Landroid/view/ViewGroup;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDeviceBinding inflate = HolderDeviceBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceViewHolder(inflate);
        }
    }

    public DI getDi() {
        return (DI) this.di$delegate.getValue();
    }

    public final ConstraintLayout getClickView() {
        return this.clickView;
    }

    public final View getStandByModeClickView() {
        return this.standByModeClickView;
    }

    public final View getOfflineInfoView() {
        return this.offlineInfoView;
    }

    private final SimpleDateFormat getTimeFormatter() {
        return (SimpleDateFormat) this.timeFormatter$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final SimpleDateFormat timeFormatter_delegate$lambda$0(DeviceViewHolder deviceViewHolder) {
        return new SimpleDateFormat(deviceViewHolder.fetchPattern());
    }

    public final void update(Device device, IndoorDatapoint indoorDatapoint, boolean z) {
        Intrinsics.checkNotNullParameter(device, "device");
        int i = 0;
        boolean z2 = z || !device.isOnline();
        HolderDeviceBinding holderDeviceBinding = this.binding;
        holderDeviceBinding.deviceName.setText(device.getName());
        ImageView imageView = holderDeviceBinding.deviceImg;
        DeviceImage deviceImage = DeviceConfigProvider.INSTANCE.getDeviceImage(device);
        imageView.setImageResource(deviceImage != null ? deviceImage.getDevice() : 0);
        Flow flow = holderDeviceBinding.flowStatus;
        Intrinsics.checkNotNullExpressionValue(flow, "flowStatus");
        ViewExtensionsKt.show$default(flow, false, 1, (Object) null);
        hideMode2();
        ImageView imageView2 = holderDeviceBinding.ivOfflineInfo;
        Intrinsics.checkNotNullExpressionValue(imageView2, "ivOfflineInfo");
        LinearLayout linearLayout = holderDeviceBinding.llTimer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTimer");
        ImageView imageView3 = holderDeviceBinding.childLockIcon;
        Intrinsics.checkNotNullExpressionValue(imageView3, "childLockIcon");
        AppCompatImageView appCompatImageView = holderDeviceBinding.ivWarning;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivWarning");
        SimpleIconTextView simpleIconTextView = holderDeviceBinding.itvAlarm;
        Intrinsics.checkNotNullExpressionValue(simpleIconTextView, "itvAlarm");
        View view = holderDeviceBinding.airQualityIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "airQualityIndicator");
        TextView textView = holderDeviceBinding.tvAirQuality;
        Intrinsics.checkNotNullExpressionValue(textView, "tvAirQuality");
        View view2 = holderDeviceBinding.ivDegreeIndicator;
        Intrinsics.checkNotNullExpressionValue(view2, "ivDegreeIndicator");
        TextView textView2 = holderDeviceBinding.tvDegree;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvDegree");
        TextView textView3 = holderDeviceBinding.tvAirFilterStatus;
        Intrinsics.checkNotNullExpressionValue(textView3, "tvAirFilterStatus");
        TextView textView4 = holderDeviceBinding.tvWickFilterStatus;
        Intrinsics.checkNotNullExpressionValue(textView4, "tvWickFilterStatus");
        hideViews(imageView2, linearLayout, imageView3, appCompatImageView, simpleIconTextView, view, textView, view2, textView2, textView3, textView4);
        if (z2) {
            setOfflineDevice();
        } else {
            setOnlineDevice(device, indoorDatapoint);
            if (DeviceKt.isSafetySwitchOn(device)) {
                TextView textView5 = this.binding.safetySwitchText;
                Intrinsics.checkNotNullExpressionValue(textView5, "safetySwitchText");
                ViewExtensionsKt.hide(textView5);
            } else {
                setSafetySwitchOffDevice(device);
            }
        }
        hydrateStandby(device, z2);
        hydrateAlarm(device);
        HolderDeviceBinding holderDeviceBinding2 = this.binding;
        int[] referencedIds = holderDeviceBinding2.flowStatus.getReferencedIds();
        Intrinsics.checkNotNullExpressionValue(referencedIds, "getReferencedIds(...)");
        int length = referencedIds.length;
        while (i < length) {
            View viewById = holderDeviceBinding2.foregroundLayout.getViewById(referencedIds[i]);
            Intrinsics.checkNotNullExpressionValue(viewById, "getViewById(...)");
            if (viewById.getVisibility() == 8) {
                i++;
            } else {
                return;
            }
        }
        Flow flow2 = holderDeviceBinding2.flowStatus;
        Intrinsics.checkNotNullExpressionValue(flow2, "flowStatus");
        ViewExtensionsKt.hide(flow2);
    }

    private final void hydrateStandby(Device device, boolean z) {
        HolderDeviceBinding holderDeviceBinding = this.binding;
        boolean z2 = false;
        if (device instanceof HasStandBy) {
            if (z || !DeviceKt.isSafetySwitchOn(device)) {
                z2 = true;
            }
            holderDeviceBinding.standbySwitch.setEnabled(!z2);
            holderDeviceBinding.standbySwitch.setChecked(!((HasStandBy) device).isStandByOn());
            return;
        }
        SwitchCompat switchCompat = holderDeviceBinding.standbySwitch;
        Intrinsics.checkNotNullExpressionValue(switchCompat, "standbySwitch");
        ViewExtensionsKt.show(switchCompat, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01f5, code lost:
        if (r4 == null) goto L_0x01f7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void setOnlineDevice(com.blueair.core.model.Device r10, com.blueair.core.model.IndoorDatapoint r11) {
        /*
            r9 = this;
            com.blueair.android.databinding.HolderDeviceBinding r0 = r9.binding
            android.widget.TextView r1 = r0.deviceName
            int r2 = com.blueair.viewcore.R.color.colorPrimaryText
            int r2 = r9.getColor(r2)
            r1.setTextColor(r2)
            android.widget.ImageView r0 = r0.childLockIcon
            java.lang.String r1 = "childLockIcon"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            boolean r1 = r10 instanceof com.blueair.core.model.HasChildLock
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x0027
            r1 = r10
            com.blueair.core.model.HasChildLock r1 = (com.blueair.core.model.HasChildLock) r1
            boolean r1 = r1.isChildLockOn()
            if (r1 == 0) goto L_0x0027
            r1 = r2
            goto L_0x0028
        L_0x0027:
            r1 = r3
        L_0x0028:
            io.flatcircle.viewhelper.ViewExtensionsKt.show(r0, r1)
            boolean r0 = r10 instanceof com.blueair.core.model.HasWick
            r1 = 0
            if (r0 == 0) goto L_0x0034
            r4 = r10
            com.blueair.core.model.HasWick r4 = (com.blueair.core.model.HasWick) r4
            goto L_0x0035
        L_0x0034:
            r4 = r1
        L_0x0035:
            if (r4 == 0) goto L_0x0076
            boolean r4 = r4.getWickdryOn()
            if (r4 != r2) goto L_0x0076
            r9.hideMode1()
            r3 = r10
            com.blueair.core.model.HasWick r3 = (com.blueair.core.model.HasWick) r3
            int r3 = r3.getWickDryLeftSeconds()
            java.lang.String r3 = r9.formatCountdownText(r3)
            int r4 = com.blueair.viewcore.R.drawable.icon_dry_mode_flat
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            r9.showMode(r2, r4, r3)
            boolean r2 = r10 instanceof com.blueair.core.model.HasSensorData
            if (r2 == 0) goto L_0x0071
            boolean r2 = com.blueair.core.model.DeviceKt.isStandByOn(r10)
            if (r2 != 0) goto L_0x0071
            r2 = r10
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            if (r11 == 0) goto L_0x0065
            java.lang.Float r1 = r11.getHum()
        L_0x0065:
            r9.hydrateHumidity(r2, r1)
            boolean r1 = com.blueair.core.model.DeviceKt.hasAirFilter(r10)
            if (r1 == 0) goto L_0x0071
            r9.showAirQuality(r2, r11)
        L_0x0071:
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x0076:
            boolean r4 = com.blueair.core.model.DeviceKt.isDisinfectionOn(r10)
            if (r4 == 0) goto L_0x009d
            r9.hideMode1()
            com.blueair.devicedetails.util.DisinfectionUtils r11 = com.blueair.devicedetails.util.DisinfectionUtils.INSTANCE
            java.lang.String r1 = "null cannot be cast to non-null type com.blueair.core.model.HasDisinfection"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r1)
            r1 = r10
            com.blueair.core.model.HasDisinfection r1 = (com.blueair.core.model.HasDisinfection) r1
            java.lang.String r11 = r11.getCountdownText(r1)
            com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.DISINFECTION
            int r1 = r1.getFlatIcon()
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            r9.showMode(r2, r1, r11)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x009d:
            boolean r4 = com.blueair.core.model.DeviceKt.isStandByOn(r10)
            if (r4 == 0) goto L_0x00ab
            r9.hideMode1()
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x00ab:
            boolean r4 = r10 instanceof com.blueair.core.model.DeviceDehumidifier
            r5 = 3
            r6 = 2
            if (r4 == 0) goto L_0x0113
            r4 = r10
            com.blueair.core.model.DeviceDehumidifier r4 = (com.blueair.core.model.DeviceDehumidifier) r4
            com.blueair.core.model.MainMode r7 = com.blueair.core.model.MainMode.Dehumidification
            boolean r7 = r4.isInMainMode(r7)
            if (r7 == 0) goto L_0x00ef
            int r7 = com.blueair.viewcore.R.drawable.mode_icon_dehum_flat
            r9.showMode((int) r3, (int) r7)
            com.blueair.core.model.DehSubMode r3 = r4.dehSubMode()
            int[] r4 = com.blueair.android.viewholder.DeviceViewHolder.WhenMappings.$EnumSwitchMapping$0
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 == r2) goto L_0x00e9
            if (r3 == r6) goto L_0x00df
            if (r3 != r5) goto L_0x00d9
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.CONTINUOUS
            r9.showMode((int) r2, (com.blueair.viewcore.utils.ModeIcon) r3)
            goto L_0x00ff
        L_0x00d9:
            kotlin.NoWhenBranchMatchedException r10 = new kotlin.NoWhenBranchMatchedException
            r10.<init>()
            throw r10
        L_0x00df:
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.AUTO
            com.blueair.viewcore.utils.ModeIcon r3 = r3.proofread(r10)
            r9.showMode((int) r2, (com.blueair.viewcore.utils.ModeIcon) r3)
            goto L_0x00ff
        L_0x00e9:
            com.blueair.viewcore.utils.ModeIcon r3 = com.blueair.viewcore.utils.ModeIcon.DRYING
            r9.showMode((int) r2, (com.blueair.viewcore.utils.ModeIcon) r3)
            goto L_0x00ff
        L_0x00ef:
            com.blueair.viewcore.utils.ModeIcon r2 = com.blueair.viewcore.utils.ModeIcon.AIR_PURIFY
            int r2 = r2.getFlatIcon()
            r9.showMode((int) r3, (int) r2)
            com.blueair.core.model.ApSubMode r2 = r4.apSubMode()
            r9.showDeviceApSubMode(r10, r2)
        L_0x00ff:
            r2 = r10
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            r9.showAirQuality(r2, r11)
            if (r11 == 0) goto L_0x010b
            java.lang.Float r1 = r11.getHum()
        L_0x010b:
            r9.hydrateHumidity(r2, r1)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x0113:
            boolean r4 = r10 instanceof com.blueair.core.model.DeviceBlue40
            if (r4 == 0) goto L_0x012f
            r9.hideMode1()
            r1 = r10
            com.blueair.core.model.DeviceBlue40 r1 = (com.blueair.core.model.DeviceBlue40) r1
            com.blueair.core.model.ApSubMode r1 = r1.apSubMode()
            r9.showDeviceApSubMode(r10, r1)
            r1 = r10
            com.blueair.core.model.HasSensorData r1 = (com.blueair.core.model.HasSensorData) r1
            r9.showAirQuality(r1, r11)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x012f:
            boolean r4 = r10 instanceof com.blueair.core.model.DeviceMiniRestful
            if (r4 == 0) goto L_0x0145
            r9.hideMode1()
            r11 = r10
            com.blueair.core.model.DeviceMiniRestful r11 = (com.blueair.core.model.DeviceMiniRestful) r11
            com.blueair.core.model.ApSubMode r11 = r11.apSubMode()
            r9.showDeviceApSubMode(r10, r11)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x0145:
            boolean r4 = r10 instanceof com.blueair.core.model.DevicePet20
            if (r4 == 0) goto L_0x0175
            r9.hideMode1()
            r1 = r10
            com.blueair.core.model.DevicePet20 r1 = (com.blueair.core.model.DevicePet20) r1
            com.blueair.core.model.MainMode r3 = r1.mainMode()
            int[] r4 = com.blueair.android.viewholder.DeviceViewHolder.WhenMappings.$EnumSwitchMapping$1
            int r3 = r3.ordinal()
            r3 = r4[r3]
            if (r3 != r2) goto L_0x0163
            com.blueair.viewcore.utils.ModeIcon r1 = com.blueair.viewcore.utils.ModeIcon.SMART
            r9.showMode((int) r2, (com.blueair.viewcore.utils.ModeIcon) r1)
            goto L_0x016a
        L_0x0163:
            com.blueair.core.model.ApSubMode r1 = r1.apSubMode()
            r9.showDeviceApSubMode(r10, r1)
        L_0x016a:
            r1 = r10
            com.blueair.core.model.HasSensorData r1 = (com.blueair.core.model.HasSensorData) r1
            r9.showAirQuality(r1, r11)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x0175:
            boolean r4 = r10 instanceof com.blueair.core.model.DeviceCombo3in1
            if (r4 == 0) goto L_0x0242
            r4 = r10
            com.blueair.core.model.DeviceCombo3in1 r4 = (com.blueair.core.model.DeviceCombo3in1) r4
            com.blueair.core.model.MainMode r7 = r4.mainMode()
            int[] r8 = com.blueair.android.viewholder.DeviceViewHolder.WhenMappings.$EnumSwitchMapping$1
            int r7 = r7.ordinal()
            r7 = r8[r7]
            if (r7 == r6) goto L_0x019c
            if (r7 == r5) goto L_0x0196
            r5 = 4
            if (r7 == r5) goto L_0x0190
            goto L_0x01a1
        L_0x0190:
            com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.HEAT
            r9.showMode((int) r3, (com.blueair.viewcore.utils.ModeIcon) r5)
            goto L_0x01a1
        L_0x0196:
            com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.COOL
            r9.showMode((int) r3, (com.blueair.viewcore.utils.ModeIcon) r5)
            goto L_0x01a1
        L_0x019c:
            com.blueair.viewcore.utils.ModeIcon r5 = com.blueair.viewcore.utils.ModeIcon.AIR_PURIFY
            r9.showMode((int) r3, (com.blueair.viewcore.utils.ModeIcon) r5)
        L_0x01a1:
            com.blueair.core.model.ApSubMode r5 = r4.currentSubMode()
            r9.showDeviceApSubMode(r10, r5)
            if (r11 != 0) goto L_0x01af
            com.blueair.core.model.IndoorDatapoint r4 = r4.getLatestSensorDatapoint()
            goto L_0x01b0
        L_0x01af:
            r4 = r11
        L_0x01b0:
            if (r4 == 0) goto L_0x01f7
            java.lang.Float r4 = r4.getTmp()
            if (r4 == 0) goto L_0x01f7
            java.lang.Number r4 = (java.lang.Number) r4
            float r4 = r4.floatValue()
            boolean r5 = com.blueair.core.model.DeviceKt.isCelsiusUnit(r10)
            if (r5 == 0) goto L_0x01da
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            r5.append(r4)
            java.lang.String r4 = "°C"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x01f5
        L_0x01da:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            com.blueair.core.model.DeviceData$Companion r6 = com.blueair.core.model.DeviceData.Companion
            float r4 = r6.convertCelsiusToFahrenheit((float) r4)
            int r4 = kotlin.math.MathKt.roundToInt((float) r4)
            r5.append(r4)
            java.lang.String r4 = "°F"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
        L_0x01f5:
            if (r4 != 0) goto L_0x01ff
        L_0x01f7:
            int r4 = com.blueair.viewcore.R.string.label_reading
            java.lang.Object[] r5 = new java.lang.Object[r3]
            java.lang.String r4 = r9.getString(r4, r5)
        L_0x01ff:
            com.blueair.android.databinding.HolderDeviceBinding r5 = r9.binding
            android.view.View r5 = r5.ivDegreeIndicator
            com.blueair.android.databinding.HolderDeviceBinding r6 = r9.binding
            android.view.View r6 = r6.ivDegreeIndicator
            android.content.Context r6 = r6.getContext()
            int r7 = com.blueair.viewcore.R.color.grey_200
            android.content.res.ColorStateList r6 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r6, r7)
            r5.setBackgroundTintList(r6)
            com.blueair.android.databinding.HolderDeviceBinding r5 = r9.binding
            android.view.View r5 = r5.ivDegreeIndicator
            java.lang.String r6 = "ivDegreeIndicator"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r5, r3, r2, r1)
            com.blueair.android.databinding.HolderDeviceBinding r5 = r9.binding
            android.widget.TextView r5 = r5.tvDegree
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r5.setText(r4)
            com.blueair.android.databinding.HolderDeviceBinding r4 = r9.binding
            android.widget.TextView r4 = r4.tvDegree
            java.lang.String r5 = "tvDegree"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            android.view.View r4 = (android.view.View) r4
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r4, r3, r2, r1)
            r1 = r10
            com.blueair.core.model.HasSensorData r1 = (com.blueair.core.model.HasSensorData) r1
            r9.showAirQuality(r1, r11)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x0242:
            boolean r2 = r10 instanceof com.blueair.core.model.DeviceCombo2in1
            if (r2 == 0) goto L_0x0279
            r2 = r10
            com.blueair.core.model.DeviceCombo2in1 r2 = (com.blueair.core.model.DeviceCombo2in1) r2
            boolean r4 = r2.getHumMode()
            if (r4 == 0) goto L_0x0255
            com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.HUM
            r9.showMode((int) r3, (com.blueair.viewcore.utils.ModeIcon) r4)
            goto L_0x025e
        L_0x0255:
            com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.AIR_PURIFY
            int r4 = r4.getFlatIcon()
            r9.showMode((int) r3, (int) r4)
        L_0x025e:
            com.blueair.core.model.Mode r2 = r2.mode()
            r9.hydrateMode(r10, r2)
            r2 = r10
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            r9.showAirQuality(r2, r11)
            if (r11 == 0) goto L_0x0271
            java.lang.Float r1 = r11.getHum()
        L_0x0271:
            r9.hydrateHumidity(r2, r1)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x0279:
            boolean r2 = r10 instanceof com.blueair.core.model.DeviceCombo2in120
            if (r2 == 0) goto L_0x02c5
            r2 = r10
            com.blueair.core.model.DeviceCombo2in120 r2 = (com.blueair.core.model.DeviceCombo2in120) r2
            com.blueair.core.model.MainMode r4 = com.blueair.core.model.MainMode.Humidification
            boolean r4 = r2.isInMainMode(r4)
            if (r4 == 0) goto L_0x029c
            com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.HUM
            r9.showMode((int) r3, (com.blueair.viewcore.utils.ModeIcon) r4)
            com.blueair.core.model.HumSubMode r2 = r2.humSubMode()
            com.blueair.core.model.Mode r2 = r2.toMode()
            com.blueair.core.model.Mode r3 = com.blueair.core.model.Mode.AUTO
            if (r2 == r3) goto L_0x029a
            goto L_0x02ad
        L_0x029a:
            r2 = r1
            goto L_0x02ad
        L_0x029c:
            com.blueair.viewcore.utils.ModeIcon r4 = com.blueair.viewcore.utils.ModeIcon.AIR_PURIFY
            int r4 = r4.getFlatIcon()
            r9.showMode((int) r3, (int) r4)
            com.blueair.core.model.ApSubMode r2 = r2.apSubMode()
            com.blueair.core.model.Mode r2 = r2.toMode()
        L_0x02ad:
            if (r2 == 0) goto L_0x02b2
            r9.hydrateMode(r10, r2)
        L_0x02b2:
            r2 = r10
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            r9.showAirQuality(r2, r11)
            if (r11 == 0) goto L_0x02be
            java.lang.Float r1 = r11.getHum()
        L_0x02be:
            r9.hydrateHumidity(r2, r1)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x02c5:
            boolean r2 = r10 instanceof com.blueair.core.model.DeviceHumidifier
            if (r2 == 0) goto L_0x02df
            r9.hideMode1()
            r9.showDeviceMode(r10)
            r2 = r10
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            if (r11 == 0) goto L_0x02d8
            java.lang.Float r1 = r11.getHum()
        L_0x02d8:
            r9.hydrateHumidity(r2, r1)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x02df:
            boolean r2 = r10 instanceof com.blueair.core.model.DeviceHumidifier20
            if (r2 == 0) goto L_0x02f9
            r9.hideMode1()
            r9.showDeviceMode(r10)
            r2 = r10
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            if (r11 == 0) goto L_0x02f2
            java.lang.Float r1 = r11.getHum()
        L_0x02f2:
            r9.hydrateHumidity(r2, r1)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x02f9:
            r9.hideMode1()
            r9.showDeviceMode(r10)
            boolean r1 = r10 instanceof com.blueair.core.model.HasSensorData
            if (r1 == 0) goto L_0x030d
            r1 = r10
            com.blueair.core.model.HasSensorData r1 = (com.blueair.core.model.HasSensorData) r1
            r9.showAirQuality(r1, r11)
            r9.showFilterWickStatus(r10)
            goto L_0x0310
        L_0x030d:
            r9.showFilterWickStatus(r10)
        L_0x0310:
            boolean r11 = com.blueair.core.model.DeviceKt.isStandByOn(r10)
            if (r11 != 0) goto L_0x034f
            if (r0 == 0) goto L_0x0334
            boolean r11 = r10 instanceof com.blueair.core.model.HasWaterLevel
            if (r11 == 0) goto L_0x0326
            r11 = r10
            com.blueair.core.model.HasWaterLevel r11 = (com.blueair.core.model.HasWaterLevel) r11
            com.blueair.core.model.WaterLevel r0 = com.blueair.core.model.WaterLevel.SHORTAGE
            boolean r11 = r11.isInWaterLevel(r0)
            goto L_0x032d
        L_0x0326:
            r11 = r10
            com.blueair.core.model.HasWick r11 = (com.blueair.core.model.HasWick) r11
            boolean r11 = r11.getWaterShortage()
        L_0x032d:
            if (r11 == 0) goto L_0x0334
            int r11 = com.blueair.viewcore.R.drawable.icon_water_shortage_flat
            r9.showWarning(r11)
        L_0x0334:
            boolean r11 = r10 instanceof com.blueair.core.model.HasWaterTank
            if (r11 == 0) goto L_0x034f
            boolean r11 = r10 instanceof com.blueair.core.model.HasWaterLevel
            if (r11 == 0) goto L_0x034f
            boolean r11 = r10 instanceof com.blueair.core.model.DeviceCombo2in120
            if (r11 != 0) goto L_0x034f
            com.blueair.core.model.HasWaterLevel r10 = (com.blueair.core.model.HasWaterLevel) r10
            com.blueair.core.model.WaterLevel r11 = com.blueair.core.model.WaterLevel.FULL
            boolean r10 = r10.isInWaterLevel(r11)
            if (r10 == 0) goto L_0x034f
            int r10 = com.blueair.viewcore.R.drawable.icon_water_tank_full_flat
            r9.showWarning(r10)
        L_0x034f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewholder.DeviceViewHolder.setOnlineDevice(com.blueair.core.model.Device, com.blueair.core.model.IndoorDatapoint):void");
    }

    private final void hydrateMode(Device device, Mode mode) {
        int i = WhenMappings.$EnumSwitchMapping$2[mode.ordinal()];
        if (i == 1) {
            showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(device)));
        } else if (i == 2) {
            showMode(1, ModeIcon.AUTO.proofread(device));
        } else if (i == 3) {
            showMode(1, ModeIcon.NIGHT);
        } else if (i == 4) {
            showMode(1, ModeIcon.ECO);
        } else if (i == 5) {
            showMode(1, ModeIcon.SKIN);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final String formatCountdownText(int i) {
        int i2 = i / DateTimeConstants.SECONDS_PER_HOUR;
        int ceil = (int) Math.ceil(((double) (i - (i2 * DateTimeConstants.SECONDS_PER_HOUR))) / 60.0d);
        if (ceil > 59) {
            i2++;
            ceil = 0;
        }
        String format = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i2), Integer.valueOf(ceil)}, 2));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0032, code lost:
        if (r8 == null) goto L_0x0034;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void hydrateHumidity(com.blueair.core.model.HasSensorData r8, java.lang.Float r9) {
        /*
            r7 = this;
            int r0 = com.blueair.viewcore.R.color.fill_grey
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L_0x0034
            r3 = r9
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            com.blueair.viewcore.view.IndoorAirStatusLabel$Companion r4 = com.blueair.viewcore.view.IndoorAirStatusLabel.Companion
            float r9 = r9.floatValue()
            double r5 = (double) r9
            com.blueair.core.model.SensorType r9 = com.blueair.core.model.SensorType.HUM
            com.blueair.viewcore.view.IndoorAirStatusLabel r8 = r4.fromValueAndSensor(r8, r5, r9)
            if (r8 == 0) goto L_0x0020
            int r0 = r8.getColorRes()
        L_0x0020:
            int r8 = com.blueair.viewcore.R.string.humidity_value
            int r9 = kotlin.math.MathKt.roundToInt((float) r3)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.Object[] r3 = new java.lang.Object[r1]
            r3[r2] = r9
            java.lang.String r8 = r7.getString(r8, r3)
            if (r8 != 0) goto L_0x003c
        L_0x0034:
            int r8 = com.blueair.viewcore.R.string.label_reading
            java.lang.Object[] r9 = new java.lang.Object[r2]
            java.lang.String r8 = r7.getString(r8, r9)
        L_0x003c:
            com.blueair.android.databinding.HolderDeviceBinding r9 = r7.binding
            android.view.View r9 = r9.ivDegreeIndicator
            com.blueair.android.databinding.HolderDeviceBinding r3 = r7.binding
            android.view.View r3 = r3.ivDegreeIndicator
            android.content.Context r3 = r3.getContext()
            android.content.res.ColorStateList r0 = androidx.appcompat.content.res.AppCompatResources.getColorStateList(r3, r0)
            r9.setBackgroundTintList(r0)
            com.blueair.android.databinding.HolderDeviceBinding r9 = r7.binding
            android.view.View r9 = r9.ivDegreeIndicator
            java.lang.String r0 = "ivDegreeIndicator"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r0)
            r0 = 0
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r9, r2, r1, r0)
            com.blueair.android.databinding.HolderDeviceBinding r9 = r7.binding
            android.widget.TextView r9 = r9.tvDegree
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r9.setText(r8)
            com.blueair.android.databinding.HolderDeviceBinding r8 = r7.binding
            android.widget.TextView r8 = r8.tvDegree
            java.lang.String r9 = "tvDegree"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            android.view.View r8 = (android.view.View) r8
            io.flatcircle.viewhelper.ViewExtensionsKt.show$default(r8, r2, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.viewholder.DeviceViewHolder.hydrateHumidity(com.blueair.core.model.HasSensorData, java.lang.Float):void");
    }

    private final void setOfflineDevice() {
        hideMode1();
        HolderDeviceBinding holderDeviceBinding = this.binding;
        showMode(1, 0, getString(R.string.offline_label, new Object[0]));
        ImageView imageView = holderDeviceBinding.ivOfflineInfo;
        Intrinsics.checkNotNullExpressionValue(imageView, "ivOfflineInfo");
        ViewExtensionsKt.show$default(imageView, false, 1, (Object) null);
        TextView textView = holderDeviceBinding.safetySwitchText;
        Intrinsics.checkNotNullExpressionValue(textView, "safetySwitchText");
        ViewExtensionsKt.hide(textView);
        holderDeviceBinding.deviceName.setTextColor(getColor(R.color.surface_dark_55));
    }

    private final void setSafetySwitchOffDevice(Device device) {
        HolderDeviceBinding holderDeviceBinding = this.binding;
        ImageView imageView = holderDeviceBinding.childLockIcon;
        Intrinsics.checkNotNullExpressionValue(imageView, "childLockIcon");
        LinearLayout linearLayout = holderDeviceBinding.llTimer;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llTimer");
        LinearLayout linearLayout2 = holderDeviceBinding.llMode1;
        Intrinsics.checkNotNullExpressionValue(linearLayout2, "llMode1");
        LinearLayout linearLayout3 = holderDeviceBinding.llMode2;
        Intrinsics.checkNotNullExpressionValue(linearLayout3, "llMode2");
        AppCompatImageView appCompatImageView = holderDeviceBinding.ivWarning;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivWarning");
        hideViews(imageView, linearLayout, linearLayout2, linearLayout3, appCompatImageView);
        holderDeviceBinding.deviceName.setTextColor(getColor(R.color.surface_dark_55));
        if (DeviceKt.hasFrontPanel(device)) {
            holderDeviceBinding.safetySwitchText.setText(R.string.front_panel_open);
        } else {
            holderDeviceBinding.safetySwitchText.setText(R.string.close_filter_cover);
        }
        TextView textView = holderDeviceBinding.safetySwitchText;
        Intrinsics.checkNotNullExpressionValue(textView, "safetySwitchText");
        ViewExtensionsKt.show(textView, true);
        showFilterWickStatus(device);
    }

    private final void showDeviceMode(Device device) {
        boolean z = device instanceof HasFanSpeed;
        if (z && ((HasFanSpeed) device).getAutoMode() == AutoMode.ON) {
            showMode(1, ModeIcon.AUTO.proofread(device));
        } else if ((device instanceof HasG4NightMode) && ((HasG4NightMode) device).isG4NightModeOn()) {
            showMode(1, ModeIcon.NIGHT);
        } else if ((device instanceof HasEcoMode) && ((HasEcoMode) device).isEcoModeOn()) {
            showMode(1, ModeIcon.ECO);
        } else if (z) {
            showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(device)));
        } else {
            hideMode2();
        }
    }

    private final void showDeviceApSubMode(Device device, ApSubMode apSubMode) {
        int i = WhenMappings.$EnumSwitchMapping$3[apSubMode.ordinal()];
        if (i == 1) {
            showMode(1, ModeIcon.FAN_SPEED.getFlatIcon(), String.valueOf(FanSpeedUtils.INSTANCE.getFanSpeedLevel(device)));
        } else if (i == 2) {
            showMode(1, ModeIcon.AUTO.proofread(device).getFlatIcon());
        } else if (i == 3) {
            showMode(1, ModeIcon.NIGHT.getFlatIcon());
        } else if (i == 4) {
            showMode(1, ModeIcon.ECO.getFlatIcon());
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    private final void showMode(int i, int i2) {
        showMode(i, i2, "");
    }

    private final void showMode(int i, ModeIcon modeIcon) {
        showMode(i, modeIcon.getFlatIcon());
    }

    private final void showMode(int i, int i2, CharSequence charSequence) {
        ImageView imageView;
        ViewGroup viewGroup;
        TextView textView;
        boolean z;
        if (i == 0) {
            imageView = this.binding.modeIcon1;
            Intrinsics.checkNotNullExpressionValue(imageView, "modeIcon1");
            AppCompatTextView appCompatTextView = this.binding.modeText1;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView, "modeText1");
            textView = appCompatTextView;
            LinearLayout linearLayout = this.binding.llMode1;
            Intrinsics.checkNotNullExpressionValue(linearLayout, "llMode1");
            viewGroup = linearLayout;
        } else {
            imageView = this.binding.modeIcon2;
            Intrinsics.checkNotNullExpressionValue(imageView, "modeIcon2");
            AppCompatTextView appCompatTextView2 = this.binding.modeText2;
            Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "modeText2");
            textView = appCompatTextView2;
            LinearLayout linearLayout2 = this.binding.llMode2;
            Intrinsics.checkNotNullExpressionValue(linearLayout2, "llMode2");
            viewGroup = linearLayout2;
        }
        boolean z2 = true;
        if (i2 != 0) {
            imageView.setImageResource(i2);
            ViewExtensionsKt.show$default(imageView, false, 1, (Object) null);
            ((AppCompatTextView) textView).setImportantForAccessibility(2);
            z = true;
        } else {
            ViewExtensionsKt.hide(imageView);
            ((AppCompatTextView) textView).setImportantForAccessibility(1);
            z = false;
        }
        if (charSequence.length() > 0) {
            ((AppCompatTextView) textView).setText(charSequence);
            ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
        } else {
            ViewExtensionsKt.hide(textView);
            z2 = z;
        }
        ViewExtensionsKt.show(viewGroup, z2);
    }

    private final void showWarning(int i) {
        AppCompatImageView appCompatImageView = this.binding.ivWarning;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "ivWarning");
        ViewExtensionsKt.show(appCompatImageView, true);
        this.binding.ivWarning.setImageResource(i);
    }

    private final void showFilterWickStatus(Device device) {
        Integer filterLifeLeftPercentage = DeviceConfigProvider.INSTANCE.getFilterLifeLeftPercentage(device);
        if (filterLifeLeftPercentage != null) {
            hydrateFilterStatus$default(this, filterLifeLeftPercentage.intValue(), false, 2, (Object) null);
        }
        if (device instanceof HasWick) {
            hydrateFilterStatus(((HasWick) device).getWickLifeLeft(), true);
        }
    }

    static /* synthetic */ void hydrateFilterStatus$default(DeviceViewHolder deviceViewHolder, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        deviceViewHolder.hydrateFilterStatus(i, z);
    }

    private final void hydrateFilterStatus(int i, boolean z) {
        if (!ArraysKt.contains(new int[]{0, 5, 10}, i)) {
            return;
        }
        if (z) {
            this.binding.tvWickFilterStatus.setText(getString(R.string.wick_filter_left, Integer.valueOf(i)));
            TextView textView = this.binding.tvWickFilterStatus;
            Intrinsics.checkNotNullExpressionValue(textView, "tvWickFilterStatus");
            ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
            return;
        }
        this.binding.tvAirFilterStatus.setText(getString(R.string.air_filter_left, Integer.valueOf(i)));
        TextView textView2 = this.binding.tvAirFilterStatus;
        Intrinsics.checkNotNullExpressionValue(textView2, "tvAirFilterStatus");
        ViewExtensionsKt.show$default(textView2, false, 1, (Object) null);
    }

    private final void showAirQuality(HasSensorData hasSensorData, IndoorDatapoint indoorDatapoint) {
        int i = R.color.fill_grey;
        String string = getString(R.string.label_reading, new Object[0]);
        Context context = this.binding.tvAirQuality.getContext();
        IndoorDatapoint indoorDatapoint2 = indoorDatapoint;
        IndoorAirStatusLabel fromDeviceAndSensorsAndDatapoint$default = IndoorAirStatusLabel.Companion.fromDeviceAndSensorsAndDatapoint$default(IndoorAirStatusLabel.Companion, indoorDatapoint2, hasSensorData, IndoorAirRatingRanges.Companion.getAirRatingSensors(hasSensorData), true, false, 16, (Object) null);
        if (fromDeviceAndSensorsAndDatapoint$default != null) {
            string = getString(fromDeviceAndSensorsAndDatapoint$default.getLabelResId(), new Object[0]);
            i = fromDeviceAndSensorsAndDatapoint$default.getColorRes();
        }
        HolderDeviceBinding holderDeviceBinding = this.binding;
        holderDeviceBinding.tvAirQuality.setText(string);
        holderDeviceBinding.airQualityIndicator.setBackgroundTintList(AppCompatResources.getColorStateList(context, i));
        View view = holderDeviceBinding.airQualityIndicator;
        Intrinsics.checkNotNullExpressionValue(view, "airQualityIndicator");
        ViewExtensionsKt.show$default(view, false, 1, (Object) null);
        TextView textView = holderDeviceBinding.tvAirQuality;
        Intrinsics.checkNotNullExpressionValue(textView, "tvAirQuality");
        ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
    }

    private final void hideMode1() {
        LinearLayout linearLayout = this.binding.llMode1;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llMode1");
        linearLayout.setVisibility(8);
    }

    private final void hideMode2() {
        LinearLayout linearLayout = this.binding.llMode2;
        Intrinsics.checkNotNullExpressionValue(linearLayout, "llMode2");
        linearLayout.setVisibility(8);
    }

    private final void hydrateAlarm(Device device) {
        if (device instanceof HasAlarm) {
            this.calendar.setTimeZone(device.getTimezone(this.itemView.getContext()));
            this.calendar.setTimeInMillis(System.currentTimeMillis());
            int i = this.calendar.get(11);
            int i2 = this.calendar.get(12);
            int i3 = (this.calendar.get(7) + 5) % 7;
            int i4 = (i * DateTimeConstants.SECONDS_PER_HOUR) + (i2 * 60) + this.calendar.get(13);
            Ref.IntRef intRef = new Ref.IntRef();
            intRef.element = DateTimeConstants.SECONDS_PER_DAY;
            Ref.IntRef intRef2 = new Ref.IntRef();
            intRef2.element = 7;
            Ref.BooleanRef booleanRef = new Ref.BooleanRef();
            Iterator it = ((HasAlarm) device).getAlarms().iterator();
            while (true) {
                int i5 = 0;
                if (it.hasNext()) {
                    DeviceAlarm deviceAlarm = (DeviceAlarm) it.next();
                    if (deviceAlarm != null && deviceAlarm.getEnabled() && !booleanRef.element) {
                        int secondsInDay = deviceAlarm.getSecondsInDay();
                        BitSet valueOf = BitSet.valueOf(new byte[]{(byte) deviceAlarm.getRepeats()});
                        if (valueOf.get(7)) {
                            if (secondsInDay < i4) {
                                i5 = 1;
                            }
                            hydrateAlarm$checkEarliest(DateTimeConstants.SECONDS_PER_DAY, intRef2, intRef, booleanRef, i4, i5, secondsInDay);
                        } else {
                            int i6 = intRef2.element;
                            if (i6 >= 0) {
                                while (true) {
                                    if ((i5 != 0 || secondsInDay >= i4) && valueOf.get((i5 + i3) % 7)) {
                                        hydrateAlarm$checkEarliest(DateTimeConstants.SECONDS_PER_DAY, intRef2, intRef, booleanRef, i4, i5, secondsInDay);
                                        if (booleanRef.element) {
                                            return;
                                        }
                                    }
                                    if (i5 == i6) {
                                        break;
                                    }
                                    i5++;
                                }
                            } else {
                                continue;
                            }
                        }
                    }
                } else if (intRef.element < 86400) {
                    int i7 = intRef.element / DateTimeConstants.SECONDS_PER_HOUR;
                    this.calendar.set(11, i7);
                    this.calendar.set(12, (intRef.element - (i7 * DateTimeConstants.SECONDS_PER_HOUR)) / 60);
                    String fetchPattern = fetchPattern();
                    getTimeFormatter().setTimeZone(this.calendar.getTimeZone());
                    if (!Intrinsics.areEqual((Object) fetchPattern, (Object) getTimeFormatter().toPattern())) {
                        getTimeFormatter().applyPattern(fetchPattern);
                    }
                    this.binding.itvAlarm.setText(getTimeFormatter().format(this.calendar.getTime()));
                    SimpleIconTextView simpleIconTextView = this.binding.itvAlarm;
                    Intrinsics.checkNotNullExpressionValue(simpleIconTextView, "itvAlarm");
                    ViewExtensionsKt.show$default(simpleIconTextView, false, 1, (Object) null);
                    return;
                } else {
                    return;
                }
            }
        }
    }

    private static final boolean hydrateAlarm$checkEarliest(int i, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.BooleanRef booleanRef, int i2, int i3, int i4) {
        int i5 = (i3 * i) + i4;
        int i6 = (intRef.element * i) + intRef2.element;
        boolean z = false;
        if (i6 <= i5) {
            return false;
        }
        intRef.element = i3;
        intRef2.element = i4;
        if (i5 == i2) {
            z = true;
        }
        booleanRef.element = z;
        return true;
    }

    private final int getColor(int i) {
        return this.itemView.getContext().getColor(i);
    }

    private final String getString(int i, Object... objArr) {
        String string = this.itemView.getContext().getString(i, Arrays.copyOf(objArr, objArr.length));
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return string;
    }

    private final String fetchPattern() {
        return DateFormat.is24HourFormat(this.itemView.getContext()) ? "HH:mm" : "hh:mm a";
    }

    private final void hideViews(View... viewArr) {
        for (View visibility : viewArr) {
            visibility.setVisibility(8);
        }
    }
}
