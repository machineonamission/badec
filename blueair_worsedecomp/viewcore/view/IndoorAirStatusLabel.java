package com.blueair.viewcore.view;

import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.core.util.IndoorAirRatingRanges;
import com.blueair.viewcore.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000 \u001e2\u00020\u0001:\u000e\u0011\u0012\u0013\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001eB1\b\u0004\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0003\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u0003J\r\u0010\u000f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n\u0001\r\u001f !\"#$%&'()*+¨\u0006,"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "", "textResId", "", "backgroundResId", "colorRes", "labelResId", "<init>", "(IIII)V", "getTextResId", "()I", "getBackgroundResId", "getColorRes", "getLabelResId", "getIndoorAirQualityIcon6", "getIndoorAirStatusProgressDrawable", "()Ljava/lang/Integer;", "Excellent", "Good", "Moderate", "Polluted", "VeryPolluted", "Ideal", "Moist", "Dry", "ReplaceFilter", "ReplaceFilterPercentage", "Offline", "Connecting", "Updating", "Companion", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Connecting;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Dry;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Excellent;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Good;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Ideal;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moderate;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moist;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Offline;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Polluted;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilter;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilterPercentage;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Updating;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel$VeryPolluted;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: IndoorAirStatusLabel.kt */
public abstract class IndoorAirStatusLabel {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int backgroundResId;
    private final int colorRes;
    private final int labelResId;
    private final int textResId;

    public /* synthetic */ IndoorAirStatusLabel(int i, int i2, int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, i4);
    }

    private IndoorAirStatusLabel(int i, int i2, int i3, int i4) {
        this.textResId = i;
        this.backgroundResId = i2;
        this.colorRes = i3;
        this.labelResId = i4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IndoorAirStatusLabel(int i, int i2, int i3, int i4, int i5, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, i2, i3, (i5 & 8) != 0 ? i : i4, (DefaultConstructorMarker) null);
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public final int getBackgroundResId() {
        return this.backgroundResId;
    }

    public final int getColorRes() {
        return this.colorRes;
    }

    public final int getLabelResId() {
        return this.labelResId;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Excellent;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Excellent extends IndoorAirStatusLabel {
        public static final Excellent INSTANCE = new Excellent();

        private Excellent() {
            super(R.string.excellent, R.drawable.status_label_excellent, R.color.color_excellent, R.string.label_excellent_air, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Good;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Good extends IndoorAirStatusLabel {
        public static final Good INSTANCE = new Good();

        private Good() {
            super(R.string.good, R.drawable.status_label_good, R.color.color_good, R.string.state_good_air, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moderate;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Moderate extends IndoorAirStatusLabel {
        public static final Moderate INSTANCE = new Moderate();

        private Moderate() {
            super(R.string.moderate, R.drawable.status_label_moderate, R.color.color_moderate, R.string.label_moderate_air, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Polluted;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Polluted extends IndoorAirStatusLabel {
        public static final Polluted INSTANCE = new Polluted();

        private Polluted() {
            super(R.string.polluted, R.drawable.status_label_polluted, R.color.color_polluted, R.string.label_polluted_air, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$VeryPolluted;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class VeryPolluted extends IndoorAirStatusLabel {
        public static final VeryPolluted INSTANCE = new VeryPolluted();

        private VeryPolluted() {
            super(R.string.vpolluted, R.drawable.status_label_vpolluted, R.color.color_vpolluted, R.string.label_vpolluted_air, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Ideal;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Ideal extends IndoorAirStatusLabel {
        public static final Ideal INSTANCE = new Ideal();

        private Ideal() {
            super(R.string.humidity_level_ideal, R.drawable.status_label_good, R.color.color_good, R.string.ideal_hum_table_title_hum, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Moist;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Moist extends IndoorAirStatusLabel {
        public static final Moist INSTANCE = new Moist();

        private Moist() {
            super(R.string.humidity_level_moist, R.drawable.status_label_moderate, R.color.color_moderate, R.string.humidity_level_moist, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Dry;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Dry extends IndoorAirStatusLabel {
        public static final Dry INSTANCE = new Dry();

        private Dry() {
            super(R.string.humidity_level_dry, R.drawable.status_label_vpolluted, R.color.color_vpolluted, R.string.humidity_level_dry, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilter;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class ReplaceFilter extends IndoorAirStatusLabel {
        public static final ReplaceFilter INSTANCE = new ReplaceFilter();

        private ReplaceFilter() {
            super(R.string.filter_usage, R.drawable.filter_progress_replace, R.color.bruno_blue, 0, 8, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$ReplaceFilterPercentage;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class ReplaceFilterPercentage extends IndoorAirStatusLabel {
        public static final ReplaceFilterPercentage INSTANCE = new ReplaceFilterPercentage();

        private ReplaceFilterPercentage() {
            super(R.string.filter_usage_percentage, R.drawable.filter_progress_replace, R.color.error_red, 0, 8, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Offline;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Offline extends IndoorAirStatusLabel {
        public static final Offline INSTANCE = new Offline();

        private Offline() {
            super(R.string.offline_label, R.drawable.status_label_grey, R.color.light_gray, 0, 8, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Connecting;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Connecting extends IndoorAirStatusLabel {
        public static final Connecting INSTANCE = new Connecting();

        private Connecting() {
            super(R.string.connecting, R.drawable.status_label_grey, R.color.light_gray, 0, 8, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Updating;", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Updating extends IndoorAirStatusLabel {
        public static final Updating INSTANCE = new Updating();

        private Updating() {
            super(R.string.firmware_updating, R.drawable.status_label_grey, R.color.light_gray, 0, 8, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ*\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bJ<\u0010\u000f\u001a\u0004\u0018\u00010\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\t0\u00112\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0012\u001a\u00020\u000bJ \u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\b\u001a\u00020\tJ(\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00052\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u0007H\u0002¨\u0006\u001d"}, d2 = {"Lcom/blueair/viewcore/view/IndoorAirStatusLabel$Companion;", "", "<init>", "()V", "fromDeviceAndSensor", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "device", "Lcom/blueair/core/model/HasSensorData;", "sensorType", "Lcom/blueair/core/model/SensorType;", "fromSensorOnly", "", "fromDeviceAndSensorAndDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "fromDeviceAndSensorsAndDatapoint", "sensorTypes", "", "nullableRating", "fromValueAndSensor", "realValue", "", "fromIndoorRating", "indoorAirRating", "Lcom/blueair/core/util/IndoorAirRatingRanges$IndoorAirRating;", "filterLifeTime", "Lcom/blueair/core/model/FilterLifeTime;", "connectivityStatus", "Lcom/blueair/core/model/ConnectivityStatus;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: IndoorAirStatusLabel.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ IndoorAirStatusLabel fromDeviceAndSensor$default(Companion companion, HasSensorData hasSensorData, SensorType sensorType, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = false;
            }
            return companion.fromDeviceAndSensor(hasSensorData, sensorType, z);
        }

        public final IndoorAirStatusLabel fromDeviceAndSensor(HasSensorData hasSensorData, SensorType sensorType, boolean z) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            IndoorAirRatingRanges.IndoorAirRating aqiFor = hasSensorData.aqiFor(sensorType);
            if (z) {
                return fromIndoorRating(aqiFor, hasSensorData);
            }
            return fromIndoorRating(aqiFor, DeviceKt.getFilterLifeTime(hasSensorData), hasSensorData.getConnectivityStatus());
        }

        public static /* synthetic */ IndoorAirStatusLabel fromDeviceAndSensorAndDatapoint$default(Companion companion, IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData, SensorType sensorType, boolean z, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            return companion.fromDeviceAndSensorAndDatapoint(indoorDatapoint, hasSensorData, sensorType, z);
        }

        public final IndoorAirStatusLabel fromDeviceAndSensorAndDatapoint(IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData, SensorType sensorType, boolean z) {
            Intrinsics.checkNotNullParameter(indoorDatapoint, "dataPoint");
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            IndoorAirRatingRanges.IndoorAirRating ratingFromDatapoint = IndoorAirRatingRanges.Companion.instance(hasSensorData).ratingFromDatapoint(indoorDatapoint, sensorType);
            if (z) {
                return fromIndoorRating(ratingFromDatapoint, hasSensorData);
            }
            return fromIndoorRating(ratingFromDatapoint, DeviceKt.getFilterLifeTime(hasSensorData), hasSensorData.getConnectivityStatus());
        }

        public static /* synthetic */ IndoorAirStatusLabel fromDeviceAndSensorsAndDatapoint$default(Companion companion, IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData, List list, boolean z, boolean z2, int i, Object obj) {
            if ((i & 8) != 0) {
                z = false;
            }
            if ((i & 16) != 0) {
                z2 = false;
            }
            return companion.fromDeviceAndSensorsAndDatapoint(indoorDatapoint, hasSensorData, list, z, z2);
        }

        public final IndoorAirStatusLabel fromDeviceAndSensorsAndDatapoint(IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData, List<? extends SensorType> list, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(list, "sensorTypes");
            IndoorAirRatingRanges.IndoorAirRating fromIndex = IndoorAirRatingRanges.IndoorAirRating.Companion.fromIndex(IndoorAirRatingRanges.Companion.instance(hasSensorData).voteWorstRating(list, indoorDatapoint).getSecond().intValue());
            if (fromIndex == null && !z2) {
                return null;
            }
            if (z) {
                return fromIndoorRating(fromIndex, hasSensorData);
            }
            return fromIndoorRating(fromIndex, DeviceKt.getFilterLifeTime(hasSensorData), hasSensorData.getConnectivityStatus());
        }

        public final IndoorAirStatusLabel fromValueAndSensor(HasSensorData hasSensorData, double d, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            if (sensorType != SensorType.HUM) {
                return fromIndoorRating(hasSensorData.aqiFor(d, sensorType), (FilterLifeTime) null, (ConnectivityStatus) null);
            }
            if (d < 30.0d) {
                return Dry.INSTANCE;
            }
            if (30.0d > d || d > 50.0d) {
                return Moist.INSTANCE;
            }
            return Ideal.INSTANCE;
        }

        private final IndoorAirStatusLabel fromIndoorRating(IndoorAirRatingRanges.IndoorAirRating indoorAirRating, FilterLifeTime filterLifeTime, ConnectivityStatus connectivityStatus) {
            if (connectivityStatus == ConnectivityStatus.OFFLINE) {
                return Offline.INSTANCE;
            }
            if (connectivityStatus == ConnectivityStatus.CONNECTING) {
                return Connecting.INSTANCE;
            }
            if (filterLifeTime instanceof FilterLifeTime.FilterDaysLeft) {
                if (((FilterLifeTime.FilterDaysLeft) filterLifeTime).getFilterLife() < 7) {
                    return ReplaceFilter.INSTANCE;
                }
            } else if (filterLifeTime instanceof FilterLifeTime.FilterPercentageLeft) {
                return ReplaceFilterPercentage.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE)) {
                return Excellent.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE)) {
                return Good.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE)) {
                return Moderate.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE)) {
                return Polluted.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE)) {
                return VeryPolluted.INSTANCE;
            }
            return null;
        }

        private final IndoorAirStatusLabel fromIndoorRating(IndoorAirRatingRanges.IndoorAirRating indoorAirRating, HasSensorData hasSensorData) {
            ConnectivityStatus connectivityStatus = hasSensorData.getConnectivityStatus();
            Timber.Forest forest = Timber.Forest;
            forest.d("fromIndoorRating: device = " + hasSensorData, new Object[0]);
            if (DeviceKt.isG4orB4orNB(hasSensorData)) {
                if (connectivityStatus == ConnectivityStatus.OFFLINE || connectivityStatus == ConnectivityStatus.CONNECTING) {
                    return null;
                }
            } else if (connectivityStatus == ConnectivityStatus.OFFLINE) {
                return Offline.INSTANCE;
            } else {
                if (connectivityStatus == ConnectivityStatus.CONNECTING) {
                    return Connecting.INSTANCE;
                }
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.EXCELLENT.INSTANCE)) {
                return Excellent.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.GOOD.INSTANCE)) {
                return Good.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.MODERATE.INSTANCE)) {
                return Moderate.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.POLLUTED.INSTANCE)) {
                return Polluted.INSTANCE;
            }
            if (Intrinsics.areEqual((Object) indoorAirRating, (Object) IndoorAirRatingRanges.IndoorAirRating.VERY_POLLUTED.INSTANCE)) {
                return VeryPolluted.INSTANCE;
            }
            return null;
        }
    }

    public final int getIndoorAirQualityIcon6() {
        if (Intrinsics.areEqual((Object) this, (Object) Excellent.INSTANCE)) {
            return R.drawable.ic_aqi_dot_excellent_6;
        }
        if (Intrinsics.areEqual((Object) this, (Object) Ideal.INSTANCE) || Intrinsics.areEqual((Object) this, (Object) Good.INSTANCE)) {
            return R.drawable.ic_aqi_dot_good_6;
        }
        if (Intrinsics.areEqual((Object) this, (Object) Moist.INSTANCE) || Intrinsics.areEqual((Object) this, (Object) Moderate.INSTANCE)) {
            return R.drawable.ic_aqi_dot_moderate_6;
        }
        if (Intrinsics.areEqual((Object) this, (Object) Polluted.INSTANCE)) {
            return R.drawable.ic_aqi_dot_polluted_6;
        }
        if (Intrinsics.areEqual((Object) this, (Object) Dry.INSTANCE) || Intrinsics.areEqual((Object) this, (Object) VeryPolluted.INSTANCE)) {
            return R.drawable.ic_aqi_dot_vpolluted_6;
        }
        return R.drawable.ic_aqi_dot_null_6;
    }

    public final Integer getIndoorAirStatusProgressDrawable() {
        if (Intrinsics.areEqual((Object) this, (Object) Excellent.INSTANCE)) {
            return Integer.valueOf(R.drawable.progressbar_blue);
        }
        if (Intrinsics.areEqual((Object) this, (Object) Good.INSTANCE)) {
            return Integer.valueOf(R.drawable.progressbar_green);
        }
        if (Intrinsics.areEqual((Object) this, (Object) Moderate.INSTANCE)) {
            return Integer.valueOf(R.drawable.progressbar_yellow);
        }
        if (Intrinsics.areEqual((Object) this, (Object) Polluted.INSTANCE)) {
            return Integer.valueOf(R.drawable.progressbar_peach);
        }
        if (Intrinsics.areEqual((Object) this, (Object) VeryPolluted.INSTANCE)) {
            return Integer.valueOf(R.drawable.progressbar_warmpink);
        }
        if (Intrinsics.areEqual((Object) this, (Object) Offline.INSTANCE)) {
            return Integer.valueOf(R.drawable.progressbar_offline);
        }
        return null;
    }
}
