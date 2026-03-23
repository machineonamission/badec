package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceIcp;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.core.util.BasicTwoWayBindingThrottle;
import com.blueair.devicedetails.databinding.HolderDeviceManualModeBinding;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.facebook.appevents.AppEventsConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 +2\u00020\u0001:\u0001+B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J\u0018\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u001aH\u0002J\u0010\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J<\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u00152\u0006\u0010 \u001a\u00020\u00152\u0006\u0010!\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020\u00152\b\b\u0002\u0010#\u001a\u00020\u00152\b\b\u0002\u0010$\u001a\u00020\u0015H\u0002J\u0018\u0010%\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0015H\u0002J\u0010\u0010'\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0006H\u0002J\u0018\u0010(\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020\u0015H\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010&\u001a\u00020\u0015H\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceManualModeHolder;", "Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "getOnFanSpeedSetListener", "()Lkotlin/jvm/functions/Function1;", "twbThrottle", "Lcom/blueair/core/util/BasicTwoWayBindingThrottle;", "getTwbThrottle", "()Lcom/blueair/core/util/BasicTwoWayBindingThrottle;", "twbThrottle$delegate", "Lkotlin/Lazy;", "lastProgress", "", "update", "device", "Lcom/blueair/core/model/Device;", "onProgressSet", "Lcom/blueair/core/model/HasFanSpeed;", "publishValue", "fanSpeedEnum", "updateGermShield", "updateProgressTextTint", "fan0TintRes", "fan1TintRes", "fan2TintRes", "fan3TintRes", "fan2IcpRes", "fan3BlueRes", "getProgressAfterSnap", "progress", "tintFanSpeed", "tintSnapSteps", "isSlidingRight", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceManualModeHolder.kt */
public final class DeviceManualModeHolder extends DeviceAttributeHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STEP_LESS_INTERVAL = 33;
    public static final int STEP_LESS_INTERVAL_ICP = 50;
    private final HolderDeviceManualModeBinding binding;
    /* access modifiers changed from: private */
    public int lastProgress;
    private final Function1<FanSpeedEnum, Unit> onFanSpeedSetListener;
    private final Lazy twbThrottle$delegate = LazyKt.lazy(new DeviceManualModeHolder$$ExternalSyntheticLambda0());

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceManualModeHolder.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|(2:53|54)|55|57) */
        /* JADX WARNING: Can't wrap try/catch for region: R(57:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|57) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0046 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0050 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x0096 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00a0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00aa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00be */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00c8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00d2 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x00dc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x00e6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x00fa */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0104 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.FanSpeedEnum[] r0 = com.blueair.core.model.FanSpeedEnum.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.OFF     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.ONE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.ELEVEN     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTEEN     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.NINETEEN     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWENTY_THREE     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWENTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_ONE     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_FIVE     // Catch:{ NoSuchFieldError -> 0x005a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THIRTY_NINE     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FORTY_THREE     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FORTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.TWO     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_ONE     // Catch:{ NoSuchFieldError -> 0x0096 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0096 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0096 }
            L_0x0096:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_FIVE     // Catch:{ NoSuchFieldError -> 0x00a0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a0 }
            L_0x00a0:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.FIFTY_NINE     // Catch:{ NoSuchFieldError -> 0x00aa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00aa }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00aa }
            L_0x00aa:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_THREE     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_FOUR     // Catch:{ NoSuchFieldError -> 0x00be }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00be }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00be }
            L_0x00be:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SIXTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x00c8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c8 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c8 }
            L_0x00c8:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_ONE     // Catch:{ NoSuchFieldError -> 0x00d2 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d2 }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d2 }
            L_0x00d2:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_FIVE     // Catch:{ NoSuchFieldError -> 0x00dc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dc }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00dc }
            L_0x00dc:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.SEVENTY_NINE     // Catch:{ NoSuchFieldError -> 0x00e6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e6 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e6 }
            L_0x00e6:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.EIGHTY_THREE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.EIGHTY_SEVEN     // Catch:{ NoSuchFieldError -> 0x00fa }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fa }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fa }
            L_0x00fa:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.THREE     // Catch:{ NoSuchFieldError -> 0x0104 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0104 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0104 }
            L_0x0104:
                com.blueair.core.model.FanSpeedEnum r1 = com.blueair.core.model.FanSpeedEnum.NINETY_ONE     // Catch:{ NoSuchFieldError -> 0x010e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x010e }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x010e }
            L_0x010e:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceManualModeHolder.WhenMappings.<clinit>():void");
        }
    }

    public final HolderDeviceManualModeBinding getBinding() {
        return this.binding;
    }

    public final Function1<FanSpeedEnum, Unit> getOnFanSpeedSetListener() {
        return this.onFanSpeedSetListener;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DeviceManualModeHolder(com.blueair.devicedetails.databinding.HolderDeviceManualModeBinding r3, kotlin.jvm.functions.Function1<? super com.blueair.core.model.FanSpeedEnum, kotlin.Unit> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "binding"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.lang.String r0 = "onFanSpeedSetListener"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            androidx.constraintlayout.widget.ConstraintLayout r0 = r3.getRoot()
            java.lang.String r1 = "getRoot(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            android.view.View r0 = (android.view.View) r0
            r2.<init>(r0)
            r2.binding = r3
            r2.onFanSpeedSetListener = r4
            com.blueair.devicedetails.viewholder.DeviceManualModeHolder$$ExternalSyntheticLambda0 r4 = new com.blueair.devicedetails.viewholder.DeviceManualModeHolder$$ExternalSyntheticLambda0
            r4.<init>()
            kotlin.Lazy r4 = kotlin.LazyKt.lazy(r4)
            r2.twbThrottle$delegate = r4
            com.blueair.viewcore.view.AccessibleSeekBar r3 = r3.fanSpeedSeekbar
            android.graphics.drawable.Drawable r3 = r3.getProgressDrawable()
            boolean r4 = r3 instanceof android.graphics.drawable.LayerDrawable
            if (r4 == 0) goto L_0x0034
            android.graphics.drawable.LayerDrawable r3 = (android.graphics.drawable.LayerDrawable) r3
            goto L_0x0035
        L_0x0034:
            r3 = 0
        L_0x0035:
            if (r3 == 0) goto L_0x0055
            r4 = 16908301(0x102000d, float:2.3877265E-38)
            android.graphics.drawable.Drawable r3 = r3.findDrawableByLayerId(r4)
            if (r3 == 0) goto L_0x0055
            android.graphics.drawable.Drawable r3 = r3.mutate()
            if (r3 == 0) goto L_0x0055
            android.view.View r4 = r2.itemView
            android.content.Context r4 = r4.getContext()
            int r0 = com.blueair.viewcore.R.color.colorPrimary
            int r4 = androidx.core.content.ContextCompat.getColor(r4, r0)
            r3.setTint(r4)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceManualModeHolder.<init>(com.blueair.devicedetails.databinding.HolderDeviceManualModeBinding, kotlin.jvm.functions.Function1):void");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceManualModeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceManualModeHolder;", "parentView", "Landroid/view/ViewGroup;", "onFanSpeedSetListener", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "STEP_LESS_INTERVAL", "", "STEP_LESS_INTERVAL_ICP", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceManualModeHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceManualModeHolder newInstance(ViewGroup viewGroup, Function1<? super FanSpeedEnum, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onFanSpeedSetListener");
            HolderDeviceManualModeBinding inflate = HolderDeviceManualModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceManualModeHolder(inflate, function1);
        }
    }

    private final BasicTwoWayBindingThrottle getTwbThrottle() {
        return (BasicTwoWayBindingThrottle) this.twbThrottle$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public static final BasicTwoWayBindingThrottle twbThrottle_delegate$lambda$0() {
        return new BasicTwoWayBindingThrottle(1000);
    }

    public void update(Device device) {
        int i;
        Intrinsics.checkNotNullParameter(device, "device");
        if ((device instanceof HasFanSpeed) && getTwbThrottle().allowReceiveUpdate()) {
            boolean z = device instanceof DeviceIcp;
            if (z) {
                this.binding.fanSpeedSeekbar.setMax(100);
                this.binding.fanspeed2Icp.setVisibility(0);
                this.binding.fanspeed1.setVisibility(4);
                this.binding.fanspeed2.setVisibility(4);
                this.binding.fanspeed0.setText(AppEventsConstants.EVENT_PARAM_VALUE_YES);
            } else if (((HasFanSpeed) device).getHasGear4()) {
                this.binding.fanSpeedSeekbar.setMax(100);
                this.binding.fanspeed1.setVisibility(4);
                this.binding.fanspeed1Blue.setVisibility(0);
                this.binding.fanspeed2.setVisibility(4);
                this.binding.fanspeed2Icp.setVisibility(0);
                this.binding.fanspeed3Blue.setVisibility(0);
                this.binding.fanspeed3.setText("4");
            } else {
                this.binding.fanSpeedSeekbar.setMax(99);
                this.binding.fanspeed2Icp.setVisibility(4);
                this.binding.fanspeed1.setVisibility(0);
                this.binding.fanspeed2.setVisibility(0);
                this.binding.fanspeed0.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            }
            this.binding.fanSpeedSeekbar.setOnSeekBarChangeListener((SeekBar.OnSeekBarChangeListener) null);
            AccessibleSeekBar accessibleSeekBar = this.binding.fanSpeedSeekbar;
            HasFanSpeed hasFanSpeed = (HasFanSpeed) device;
            if (hasFanSpeed.getHasGear4()) {
                i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(hasFanSpeed.getFanSpeedEnum());
            } else if (DeviceKt.isG4orB4orNB(device)) {
                i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedG4(hasFanSpeed.getFanSpeedEnum());
            } else if (z) {
                i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedIcp(((DeviceIcp) device).getFanSpeedEnum());
            } else {
                i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedLegacy(hasFanSpeed.getFanSpeedEnum());
            }
            accessibleSeekBar.setProgress(i);
            this.lastProgress = this.binding.fanSpeedSeekbar.getProgress();
            Timber.Forest forest = Timber.Forest;
            forest.d("update: progress = " + this.binding.fanSpeedSeekbar.getProgress() + ", fanSpeedEnum = " + hasFanSpeed.getFanSpeedEnum(), new Object[0]);
            tintFanSpeed(hasFanSpeed.getFanSpeedEnum());
            updateGermShield(device);
            this.binding.increaseFanSpeedBg.setOnClickListener(new DeviceManualModeHolder$$ExternalSyntheticLambda1(this, device));
            this.binding.decreaseFanSpeedBg.setOnClickListener(new DeviceManualModeHolder$$ExternalSyntheticLambda2(this, device));
            this.binding.fanSpeedSeekbar.setOnSeekBarChangeListener(new DeviceManualModeHolder$update$3(device, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$4(DeviceManualModeHolder deviceManualModeHolder, Device device, View view) {
        Timber.Forest.d("increaseFanSpeedBtn: was = " + deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress(), new Object[0]);
        int i = -1;
        if (((HasFanSpeed) device).getHasGear4()) {
            Iterator<Integer> it = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().iterator();
            int i2 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (it.next().intValue() > deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress()) {
                    i = i2;
                    break;
                } else {
                    i2++;
                }
            }
            if (i >= 0) {
                deviceManualModeHolder.binding.fanSpeedSeekbar.setProgress(FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(i).intValue());
            }
        } else if (DeviceKt.isG4orB4orNB(device)) {
            Iterator<Integer> it2 = FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP().iterator();
            int i3 = 0;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                } else if (it2.next().intValue() > deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress()) {
                    i = i3;
                    break;
                } else {
                    i3++;
                }
            }
            if (i >= 0) {
                deviceManualModeHolder.binding.fanSpeedSeekbar.setProgress(FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP().get(i).intValue());
            }
        } else if (device instanceof DeviceIcp) {
            AccessibleSeekBar accessibleSeekBar = deviceManualModeHolder.binding.fanSpeedSeekbar;
            accessibleSeekBar.setProgress(accessibleSeekBar.getProgress() + 50);
        } else {
            AccessibleSeekBar accessibleSeekBar2 = deviceManualModeHolder.binding.fanSpeedSeekbar;
            accessibleSeekBar2.setProgress(accessibleSeekBar2.getProgress() + 33);
        }
        Timber.Forest.d("increaseFanSpeedBtn: now = " + deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress(), new Object[0]);
    }

    /* access modifiers changed from: private */
    public static final void update$lambda$7(DeviceManualModeHolder deviceManualModeHolder, Device device, View view) {
        Timber.Forest forest = Timber.Forest;
        forest.d("decreaseFanSpeedBtn: was = " + deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress(), new Object[0]);
        int i = -1;
        if (((HasFanSpeed) device).getHasGear4()) {
            List<Integer> blue_premium_fan_progress_snap = FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP();
            ListIterator<Integer> listIterator = blue_premium_fan_progress_snap.listIterator(blue_premium_fan_progress_snap.size());
            while (true) {
                if (listIterator.hasPrevious()) {
                    if (listIterator.previous().intValue() < deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress()) {
                        i = listIterator.nextIndex();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (i >= 0) {
                deviceManualModeHolder.binding.fanSpeedSeekbar.setProgress(FanSpeedUtils.INSTANCE.getBLUE_PREMIUM_FAN_PROGRESS_SNAP().get(i).intValue());
            }
        } else if (DeviceKt.isG4orB4orNB(device)) {
            List<Integer> g4_fan_progress_snap = FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP();
            ListIterator<Integer> listIterator2 = g4_fan_progress_snap.listIterator(g4_fan_progress_snap.size());
            while (true) {
                if (listIterator2.hasPrevious()) {
                    if (listIterator2.previous().intValue() < deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress()) {
                        i = listIterator2.nextIndex();
                        break;
                    }
                } else {
                    break;
                }
            }
            if (i >= 0) {
                deviceManualModeHolder.binding.fanSpeedSeekbar.setProgress(FanSpeedUtils.INSTANCE.getG4_FAN_PROGRESS_SNAP().get(i).intValue());
            }
        } else if (device instanceof DeviceIcp) {
            AccessibleSeekBar accessibleSeekBar = deviceManualModeHolder.binding.fanSpeedSeekbar;
            accessibleSeekBar.setProgress(accessibleSeekBar.getProgress() - 50);
        } else {
            AccessibleSeekBar accessibleSeekBar2 = deviceManualModeHolder.binding.fanSpeedSeekbar;
            accessibleSeekBar2.setProgress(accessibleSeekBar2.getProgress() - 33);
        }
        Timber.Forest forest2 = Timber.Forest;
        forest2.d("decreaseFanSpeedBtn: now = " + deviceManualModeHolder.binding.fanSpeedSeekbar.getProgress(), new Object[0]);
    }

    /* access modifiers changed from: private */
    public final void onProgressSet(HasFanSpeed hasFanSpeed) {
        FanSpeedEnum fanSpeedEnum;
        int progress = this.binding.fanSpeedSeekbar.getProgress();
        Timber.Forest forest = Timber.Forest;
        forest.d("onStopTrackingTouch = " + progress, new Object[0]);
        if (hasFanSpeed.getHasGear4()) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(progress));
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(progress));
        } else if (hasFanSpeed instanceof DeviceIcp) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressIcp(FanSpeedUtils.INSTANCE.getIcpSpeedFromSeekBarProgress(progress));
        } else {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(progress));
        }
        if (fanSpeedEnum == FanSpeedEnum.SNAP_STEP) {
            this.binding.fanSpeedSeekbar.setProgress(getProgressAfterSnap(hasFanSpeed, progress));
            return;
        }
        tintFanSpeed(fanSpeedEnum);
        this.lastProgress = this.binding.fanSpeedSeekbar.getProgress();
        Timber.Forest.d("onStopTrackingTouch: publish", new Object[0]);
        publishValue(fanSpeedEnum, hasFanSpeed);
    }

    /* access modifiers changed from: private */
    public final void publishValue(FanSpeedEnum fanSpeedEnum, HasFanSpeed hasFanSpeed) {
        getTwbThrottle().notifyUpdateSent();
        updateGermShield(hasFanSpeed);
        this.onFanSpeedSetListener.invoke(fanSpeedEnum);
    }

    private final void updateGermShield(Device device) {
        ConstraintLayout constraintLayout = this.binding.germshieldRoot;
        Intrinsics.checkNotNullExpressionValue(constraintLayout, "germshieldRoot");
        ViewExtensionsKt.show(constraintLayout, DeviceKt.isGermShieldOn(device) && !DeviceKt.isGermShieldPlus(device));
    }

    static /* synthetic */ void updateProgressTextTint$default(DeviceManualModeHolder deviceManualModeHolder, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            i5 = R.color.dimgray;
        }
        int i8 = i5;
        if ((i7 & 32) != 0) {
            i6 = R.color.dimgray;
        }
        deviceManualModeHolder.updateProgressTextTint(i, i2, i3, i4, i8, i6);
    }

    private final void updateProgressTextTint(int i, int i2, int i3, int i4, int i5, int i6) {
        this.binding.fanspeed0.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i));
        this.binding.fanspeed1Blue.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i2));
        this.binding.fanspeed1.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i2));
        this.binding.fanspeed2.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i3));
        this.binding.fanspeed3.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i4));
        this.binding.fanspeed3Blue.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i6));
        this.binding.fanspeed2Icp.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i5));
    }

    private final int getProgressAfterSnap(HasFanSpeed hasFanSpeed, int i) {
        if (hasFanSpeed.getHasGear4()) {
            return isSlidingRight(i) ? 25 : 0;
        }
        if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            if (isSlidingRight(i)) {
                return 33;
            }
            return 0;
        } else if (hasFanSpeed instanceof DeviceIcp) {
            if (76 <= i && i < 101) {
                return 100;
            }
            if (26 > i || i >= 76) {
                return 0;
            }
            return 50;
        } else if (1 > i || i >= 33) {
            if (34 > i || i >= 66) {
                if (67 > i || i >= 99) {
                    return 0;
                }
                if (isSlidingRight(i)) {
                    return 99;
                }
                return 66;
            } else if (isSlidingRight(i)) {
                return 66;
            } else {
                return 33;
            }
        } else if (isSlidingRight(i)) {
            return 33;
        } else {
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final void tintFanSpeed(FanSpeedEnum fanSpeedEnum) {
        switch (WhenMappings.$EnumSwitchMapping$0[fanSpeedEnum.ordinal()]) {
            case 1:
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object) null);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object) null);
                return;
            case 10:
            case 11:
            case 12:
            case 13:
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.navy_blue, 0, 32, (Object) null);
                return;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                updateProgressTextTint(R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.navy_blue, R.color.dimgray);
                return;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                updateProgressTextTint(R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.navy_blue, R.color.navy_blue);
                return;
            case 26:
            case 27:
                updateProgressTextTint(R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void tintSnapSteps(HasFanSpeed hasFanSpeed, int i) {
        HasFanSpeed hasFanSpeed2 = hasFanSpeed;
        int i2 = i;
        if (hasFanSpeed2.getHasGear4()) {
            if (i2 >= 25) {
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
                return;
            }
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed2)) {
            if (i2 >= 33) {
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
                return;
            }
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (hasFanSpeed2 instanceof DeviceIcp) {
            if (i2 > 75) {
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.navy_blue, R.color.navy_blue, 0, 32, (Object) null);
            } else if (i2 > 25) {
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.navy_blue, 0, 32, (Object) null);
            } else {
                updateProgressTextTint$default(this, R.color.navy_blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object) null);
            }
        } else if (1 <= i2 && i2 < 33) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (34 <= i2 && i2 < 66) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (67 <= i2 && i2 < 99) {
            updateProgressTextTint$default(this, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, R.color.navy_blue, 0, 0, 48, (Object) null);
        }
    }

    private final boolean isSlidingRight(int i) {
        return this.lastProgress < i;
    }
}
