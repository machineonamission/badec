package com.blueair.devicedetails.viewholder;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FanSpeedEnum;
import com.blueair.core.model.HasFanSpeed;
import com.blueair.devicedetails.databinding.HolderDeviceManualModeBinding;
import com.blueair.devicedetails.util.FanSpeedUtils;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 02\u00020\u0001:\u00010B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\u001e\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H\u0002J<\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\u001d2\u0006\u0010'\u001a\u00020\u001d2\b\b\u0002\u0010(\u001a\u00020\u001d2\b\b\u0002\u0010)\u001a\u00020\u001dH\u0002J\u0018\u0010*\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010,\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u0006H\u0002J\u0018\u0010-\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010+\u001a\u00020\u001dH\u0002J\u0010\u0010.\u001a\u00020/2\u0006\u0010+\u001a\u00020\u001dH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleManualModeViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "onFanSpeedChanged", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;Lkotlin/jvm/functions/Function1;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderDeviceManualModeBinding;", "fanSpeed0View", "Landroid/widget/TextView;", "fanSpeed1BlueView", "fanSpeed1View", "fanSpeed2View", "fanSpeed2ViewIcp", "fanSpeed3View", "fanSpeed3BlueView", "fanSpeedSeekBar", "Lcom/blueair/viewcore/view/AccessibleSeekBar;", "increaseFanSpeedBtn", "Landroid/widget/ImageView;", "decreaseFanSpeedBtn", "title", "separator", "Landroid/view/View;", "lastProgress", "", "bind", "device", "Lcom/blueair/core/model/HasFanSpeed;", "fanSpeedEnum", "onProgressSet", "updateProgressTextTint", "fan0TintRes", "fan1TintRes", "fan2TintRes", "fan3TintRes", "fan2IcpRes", "fan3BlueRes", "getProgressAfterSnap", "progress", "tintFanSpeed", "tintSnapSteps", "isSlidingRight", "", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceScheduleManualModeViewHolder.kt */
public final class DeviceScheduleManualModeViewHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int STEP_INTERVAL = 3;
    public static final int STEP_LESS_INTERVAL = 33;
    public static final int STEP_LESS_INTERVAL_BLUE_PREMIUM = 25;
    private final HolderDeviceManualModeBinding binding;
    private final ImageView decreaseFanSpeedBtn;
    private final TextView fanSpeed0View;
    private final TextView fanSpeed1BlueView;
    private final TextView fanSpeed1View;
    private final TextView fanSpeed2View;
    private final TextView fanSpeed2ViewIcp;
    private final TextView fanSpeed3BlueView;
    private final TextView fanSpeed3View;
    private final AccessibleSeekBar fanSpeedSeekBar;
    private final ImageView increaseFanSpeedBtn;
    /* access modifiers changed from: private */
    public int lastProgress;
    /* access modifiers changed from: private */
    public final Function1<FanSpeedEnum, Unit> onFanSpeedChanged;
    private final View separator;
    private final TextView title;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleManualModeViewHolder.kt */
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
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewholder.DeviceScheduleManualModeViewHolder.WhenMappings.<clinit>():void");
        }
    }

    public final HolderDeviceManualModeBinding getBinding() {
        return this.binding;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceScheduleManualModeViewHolder(HolderDeviceManualModeBinding holderDeviceManualModeBinding, Function1<? super FanSpeedEnum, Unit> function1) {
        super(holderDeviceManualModeBinding.getRoot());
        Drawable findDrawableByLayerId;
        Drawable mutate;
        Intrinsics.checkNotNullParameter(holderDeviceManualModeBinding, "binding");
        Intrinsics.checkNotNullParameter(function1, "onFanSpeedChanged");
        this.binding = holderDeviceManualModeBinding;
        this.onFanSpeedChanged = function1;
        TextView textView = holderDeviceManualModeBinding.fanspeed0;
        Intrinsics.checkNotNullExpressionValue(textView, "fanspeed0");
        this.fanSpeed0View = textView;
        TextView textView2 = holderDeviceManualModeBinding.fanspeed1Blue;
        Intrinsics.checkNotNullExpressionValue(textView2, "fanspeed1Blue");
        this.fanSpeed1BlueView = textView2;
        TextView textView3 = holderDeviceManualModeBinding.fanspeed1;
        Intrinsics.checkNotNullExpressionValue(textView3, "fanspeed1");
        this.fanSpeed1View = textView3;
        TextView textView4 = holderDeviceManualModeBinding.fanspeed2;
        Intrinsics.checkNotNullExpressionValue(textView4, "fanspeed2");
        this.fanSpeed2View = textView4;
        TextView textView5 = holderDeviceManualModeBinding.fanspeed2Icp;
        Intrinsics.checkNotNullExpressionValue(textView5, "fanspeed2Icp");
        this.fanSpeed2ViewIcp = textView5;
        TextView textView6 = holderDeviceManualModeBinding.fanspeed3;
        Intrinsics.checkNotNullExpressionValue(textView6, "fanspeed3");
        this.fanSpeed3View = textView6;
        TextView textView7 = holderDeviceManualModeBinding.fanspeed3Blue;
        Intrinsics.checkNotNullExpressionValue(textView7, "fanspeed3Blue");
        this.fanSpeed3BlueView = textView7;
        AccessibleSeekBar accessibleSeekBar = holderDeviceManualModeBinding.fanSpeedSeekbar;
        Intrinsics.checkNotNullExpressionValue(accessibleSeekBar, "fanSpeedSeekbar");
        this.fanSpeedSeekBar = accessibleSeekBar;
        AppCompatImageView appCompatImageView = holderDeviceManualModeBinding.increaseFanSpeedBg;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView, "increaseFanSpeedBg");
        this.increaseFanSpeedBtn = appCompatImageView;
        AppCompatImageView appCompatImageView2 = holderDeviceManualModeBinding.decreaseFanSpeedBg;
        Intrinsics.checkNotNullExpressionValue(appCompatImageView2, "decreaseFanSpeedBg");
        this.decreaseFanSpeedBtn = appCompatImageView2;
        TextView textView8 = holderDeviceManualModeBinding.modeTitle;
        Intrinsics.checkNotNullExpressionValue(textView8, "modeTitle");
        this.title = textView8;
        View view = holderDeviceManualModeBinding.separator;
        Intrinsics.checkNotNullExpressionValue(view, "separator");
        this.separator = view;
        Drawable progressDrawable = accessibleSeekBar.getProgressDrawable();
        LayerDrawable layerDrawable = progressDrawable instanceof LayerDrawable ? (LayerDrawable) progressDrawable : null;
        if (layerDrawable != null && (findDrawableByLayerId = layerDrawable.findDrawableByLayerId(16908301)) != null && (mutate = findDrawableByLayerId.mutate()) != null) {
            mutate.setTint(ContextCompat.getColor(this.itemView.getContext(), R.color.colorPrimary));
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tR\u000e\u0010\f\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\rXT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceScheduleManualModeViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceScheduleManualModeViewHolder;", "parentView", "Landroid/view/ViewGroup;", "onFanSpeedChanged", "Lkotlin/Function1;", "Lcom/blueair/core/model/FanSpeedEnum;", "", "STEP_LESS_INTERVAL", "", "STEP_LESS_INTERVAL_BLUE_PREMIUM", "STEP_INTERVAL", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceScheduleManualModeViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DeviceScheduleManualModeViewHolder newInstance(ViewGroup viewGroup, Function1<? super FanSpeedEnum, Unit> function1) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            Intrinsics.checkNotNullParameter(function1, "onFanSpeedChanged");
            HolderDeviceManualModeBinding inflate = HolderDeviceManualModeBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DeviceScheduleManualModeViewHolder(inflate, function1);
        }
    }

    public final void bind(HasFanSpeed hasFanSpeed, FanSpeedEnum fanSpeedEnum) {
        int i;
        Intrinsics.checkNotNullParameter(hasFanSpeed, "device");
        Intrinsics.checkNotNullParameter(fanSpeedEnum, "fanSpeedEnum");
        this.title.setText(R.string.set_manual_fan_speed);
        this.title.setTextSize(2, 15.0f);
        ViewExtensionsKt.hide(this.separator);
        if (hasFanSpeed.getHasGear4()) {
            this.fanSpeedSeekBar.setMax(100);
            this.fanSpeed1View.setVisibility(4);
            this.fanSpeed1BlueView.setVisibility(0);
            this.fanSpeed2View.setVisibility(4);
            this.fanSpeed2ViewIcp.setVisibility(0);
            this.fanSpeed3BlueView.setVisibility(0);
            this.fanSpeed3View.setText("4");
        } else {
            this.fanSpeedSeekBar.setMax(99);
            this.fanSpeed2ViewIcp.setVisibility(4);
            this.fanSpeed1View.setVisibility(0);
            this.fanSpeed2View.setVisibility(0);
        }
        AccessibleSeekBar accessibleSeekBar = this.fanSpeedSeekBar;
        if (hasFanSpeed.getHasGear4()) {
            i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedBluePremium(fanSpeedEnum);
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedG4(fanSpeedEnum);
        } else {
            i = FanSpeedUtils.INSTANCE.getProgressFromFanSpeedLegacy(fanSpeedEnum);
        }
        accessibleSeekBar.setProgress(i);
        this.lastProgress = this.fanSpeedSeekBar.getProgress();
        tintFanSpeed(fanSpeedEnum);
        this.increaseFanSpeedBtn.setOnClickListener(new DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda1(hasFanSpeed, this));
        this.decreaseFanSpeedBtn.setOnClickListener(new DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda2(hasFanSpeed, this));
        this.fanSpeedSeekBar.setOnSeekBarChangeListener(new DeviceScheduleManualModeViewHolder$bind$3(hasFanSpeed, this));
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$1(HasFanSpeed hasFanSpeed, DeviceScheduleManualModeViewHolder deviceScheduleManualModeViewHolder, View view) {
        if (hasFanSpeed.getHasGear4()) {
            int progress = deviceScheduleManualModeViewHolder.fanSpeedSeekBar.getProgress();
            if (progress < 0 || progress >= 25) {
                AccessibleSeekBar accessibleSeekBar = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
                accessibleSeekBar.setProgress(accessibleSeekBar.getProgress() + 3);
                return;
            }
            AccessibleSeekBar accessibleSeekBar2 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
            accessibleSeekBar2.setProgress(accessibleSeekBar2.getProgress() + 25);
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            int progress2 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar.getProgress();
            if (progress2 < 0 || progress2 >= 33) {
                AccessibleSeekBar accessibleSeekBar3 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
                accessibleSeekBar3.setProgress(accessibleSeekBar3.getProgress() + 3);
                return;
            }
            AccessibleSeekBar accessibleSeekBar4 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
            accessibleSeekBar4.setProgress(accessibleSeekBar4.getProgress() + 33);
        } else {
            AccessibleSeekBar accessibleSeekBar5 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
            accessibleSeekBar5.setProgress(accessibleSeekBar5.getProgress() + 33);
        }
    }

    /* access modifiers changed from: private */
    public static final void bind$lambda$2(HasFanSpeed hasFanSpeed, DeviceScheduleManualModeViewHolder deviceScheduleManualModeViewHolder, View view) {
        if (hasFanSpeed.getHasGear4()) {
            int progress = deviceScheduleManualModeViewHolder.fanSpeedSeekBar.getProgress();
            if (progress < 0 || progress >= 26) {
                AccessibleSeekBar accessibleSeekBar = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
                accessibleSeekBar.setProgress(accessibleSeekBar.getProgress() - 3);
                return;
            }
            deviceScheduleManualModeViewHolder.fanSpeedSeekBar.setProgress(0);
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            int progress2 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar.getProgress();
            if (1 > progress2 || progress2 >= 34) {
                AccessibleSeekBar accessibleSeekBar2 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
                accessibleSeekBar2.setProgress(accessibleSeekBar2.getProgress() - 3);
                return;
            }
            deviceScheduleManualModeViewHolder.fanSpeedSeekBar.setProgress(0);
        } else {
            AccessibleSeekBar accessibleSeekBar3 = deviceScheduleManualModeViewHolder.fanSpeedSeekBar;
            accessibleSeekBar3.setProgress(accessibleSeekBar3.getProgress() - 33);
        }
    }

    /* access modifiers changed from: private */
    public final void onProgressSet(HasFanSpeed hasFanSpeed) {
        FanSpeedEnum fanSpeedEnum;
        int progress = this.fanSpeedSeekBar.getProgress();
        if (hasFanSpeed.getHasGear4()) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressBluePremium(FanSpeedUtils.INSTANCE.getBluePremiumFromSeekBarProgress(progress));
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressG4(FanSpeedUtils.INSTANCE.getG4FanSpeedFromSeekBarProgress(progress));
        } else {
            fanSpeedEnum = FanSpeedEnum.Companion.fanSpeedEnumFromProgressLegacy(FanSpeedUtils.INSTANCE.getLegacySpeedFromSeekBarProgress(progress));
        }
        if (fanSpeedEnum == FanSpeedEnum.SNAP_STEP) {
            this.fanSpeedSeekBar.postDelayed(new DeviceScheduleManualModeViewHolder$$ExternalSyntheticLambda0(this, hasFanSpeed, progress), (long) ViewConfiguration.getTapTimeout());
            return;
        }
        tintFanSpeed(fanSpeedEnum);
        this.lastProgress = this.fanSpeedSeekBar.getProgress();
        this.onFanSpeedChanged.invoke(fanSpeedEnum);
    }

    /* access modifiers changed from: private */
    public static final void onProgressSet$lambda$3(DeviceScheduleManualModeViewHolder deviceScheduleManualModeViewHolder, HasFanSpeed hasFanSpeed, int i) {
        deviceScheduleManualModeViewHolder.fanSpeedSeekBar.setProgress(deviceScheduleManualModeViewHolder.getProgressAfterSnap(hasFanSpeed, i));
    }

    static /* synthetic */ void updateProgressTextTint$default(DeviceScheduleManualModeViewHolder deviceScheduleManualModeViewHolder, int i, int i2, int i3, int i4, int i5, int i6, int i7, Object obj) {
        if ((i7 & 16) != 0) {
            i5 = R.color.dimgray;
        }
        int i8 = i5;
        if ((i7 & 32) != 0) {
            i6 = R.color.dimgray;
        }
        deviceScheduleManualModeViewHolder.updateProgressTextTint(i, i2, i3, i4, i8, i6);
    }

    private final void updateProgressTextTint(int i, int i2, int i3, int i4, int i5, int i6) {
        this.fanSpeed0View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i));
        this.fanSpeed1BlueView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i2));
        this.fanSpeed1View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i2));
        this.fanSpeed2View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i3));
        this.fanSpeed3View.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i4));
        this.fanSpeed3BlueView.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i6));
        this.fanSpeed2ViewIcp.setTextColor(ContextCompat.getColor(this.itemView.getContext(), i5));
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
        Timber.Forest forest = Timber.Forest;
        StringBuilder sb = new StringBuilder("fanSpeedEnum called: ");
        FanSpeedEnum fanSpeedEnum2 = fanSpeedEnum;
        sb.append(fanSpeedEnum2);
        forest.d(sb.toString(), new Object[0]);
        switch (WhenMappings.$EnumSwitchMapping$0[fanSpeedEnum2.ordinal()]) {
            case 1:
                updateProgressTextTint$default(this, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object) null);
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
                updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 32, (Object) null);
                return;
            case 10:
            case 11:
            case 12:
            case 13:
                updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.blue, 0, 32, (Object) null);
                return;
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
                updateProgressTextTint(R.color.blue, R.color.blue, R.color.blue, R.color.dimgray, R.color.blue, R.color.dimgray);
                return;
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
                updateProgressTextTint(R.color.blue, R.color.blue, R.color.blue, R.color.dimgray, R.color.blue, R.color.blue);
                return;
            case 26:
            case 27:
                updateProgressTextTint(R.color.blue, R.color.blue, R.color.blue, R.color.blue, R.color.blue, R.color.blue);
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public final void tintSnapSteps(HasFanSpeed hasFanSpeed, int i) {
        int i2 = i;
        if (hasFanSpeed.getHasGear4()) {
            if (i2 >= 25) {
                updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
                return;
            }
            updateProgressTextTint$default(this, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (DeviceKt.isG4orB4orNB(hasFanSpeed)) {
            if (i2 >= 33) {
                updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
                return;
            }
            updateProgressTextTint$default(this, R.color.blue, R.color.dimgray, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (1 <= i2 && i2 < 33) {
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.dimgray, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (34 <= i2 && i2 < 66) {
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.blue, R.color.dimgray, 0, 0, 48, (Object) null);
        } else if (67 <= i2 && i2 < 99) {
            updateProgressTextTint$default(this, R.color.blue, R.color.blue, R.color.blue, R.color.blue, 0, 0, 48, (Object) null);
        }
    }

    private final boolean isSlidingRight(int i) {
        return this.lastProgress < i;
    }
}
