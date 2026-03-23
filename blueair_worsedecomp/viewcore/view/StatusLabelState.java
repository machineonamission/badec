package com.blueair.viewcore.view;

import android.os.Parcel;
import android.os.Parcelable;
import com.blueair.adddevice.model.AddDeviceState$$ExternalSyntheticBackport0;
import com.blueair.core.model.Device;
import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.FilterLifeTime;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.IndoorDatapoint;
import com.blueair.core.model.SensorType;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.IndoorAirStatusLabel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0006HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0003\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0003\u0010\b\u001a\u00020\u0006HÆ\u0001J\u0006\u0010\u0018\u001a\u00020\u0006J\u0013\u0010\u0019\u001a\u00020\u00032\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bHÖ\u0003J\t\u0010\u001c\u001a\u00020\u0006HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000f¨\u0006%"}, d2 = {"Lcom/blueair/viewcore/view/StatusLabelState;", "Landroid/os/Parcelable;", "shouldShowStatusLabel", "", "shouldSubstituteValueIntoText", "textResId", "", "valueForText", "backgroundResId", "<init>", "(ZZIII)V", "getShouldShowStatusLabel", "()Z", "getShouldSubstituteValueIntoText", "getTextResId", "()I", "getValueForText", "getBackgroundResId", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: StatusLabelTextView.kt */
public final class StatusLabelState implements Parcelable {
    public static final Parcelable.Creator<StatusLabelState> CREATOR = new Creator();
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final int backgroundResId;
    private final boolean shouldShowStatusLabel;
    private final boolean shouldSubstituteValueIntoText;
    private final int textResId;
    private final int valueForText;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StatusLabelTextView.kt */
    public static final class Creator implements Parcelable.Creator<StatusLabelState> {
        public final StatusLabelState createFromParcel(Parcel parcel) {
            boolean z;
            Intrinsics.checkNotNullParameter(parcel, "parcel");
            boolean z2 = true;
            boolean z3 = false;
            if (parcel.readInt() != 0) {
                z = true;
            } else {
                z = true;
                z2 = false;
            }
            if (parcel.readInt() != 0) {
                z3 = z;
            }
            return new StatusLabelState(z2, z3, parcel.readInt(), parcel.readInt(), parcel.readInt());
        }

        public final StatusLabelState[] newArray(int i) {
            return new StatusLabelState[i];
        }
    }

    public static /* synthetic */ StatusLabelState copy$default(StatusLabelState statusLabelState, boolean z, boolean z2, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            z = statusLabelState.shouldShowStatusLabel;
        }
        if ((i4 & 2) != 0) {
            z2 = statusLabelState.shouldSubstituteValueIntoText;
        }
        if ((i4 & 4) != 0) {
            i = statusLabelState.textResId;
        }
        if ((i4 & 8) != 0) {
            i2 = statusLabelState.valueForText;
        }
        if ((i4 & 16) != 0) {
            i3 = statusLabelState.backgroundResId;
        }
        int i5 = i2;
        int i6 = i3;
        return statusLabelState.copy(z, z2, i, i5, i6);
    }

    public final boolean component1() {
        return this.shouldShowStatusLabel;
    }

    public final boolean component2() {
        return this.shouldSubstituteValueIntoText;
    }

    public final int component3() {
        return this.textResId;
    }

    public final int component4() {
        return this.valueForText;
    }

    public final int component5() {
        return this.backgroundResId;
    }

    public final StatusLabelState copy(boolean z, boolean z2, int i, int i2, int i3) {
        return new StatusLabelState(z, z2, i, i2, i3);
    }

    public final int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StatusLabelState)) {
            return false;
        }
        StatusLabelState statusLabelState = (StatusLabelState) obj;
        return this.shouldShowStatusLabel == statusLabelState.shouldShowStatusLabel && this.shouldSubstituteValueIntoText == statusLabelState.shouldSubstituteValueIntoText && this.textResId == statusLabelState.textResId && this.valueForText == statusLabelState.valueForText && this.backgroundResId == statusLabelState.backgroundResId;
    }

    public int hashCode() {
        return (((((((AddDeviceState$$ExternalSyntheticBackport0.m(this.shouldShowStatusLabel) * 31) + AddDeviceState$$ExternalSyntheticBackport0.m(this.shouldSubstituteValueIntoText)) * 31) + this.textResId) * 31) + this.valueForText) * 31) + this.backgroundResId;
    }

    public String toString() {
        return "StatusLabelState(shouldShowStatusLabel=" + this.shouldShowStatusLabel + ", shouldSubstituteValueIntoText=" + this.shouldSubstituteValueIntoText + ", textResId=" + this.textResId + ", valueForText=" + this.valueForText + ", backgroundResId=" + this.backgroundResId + ')';
    }

    public final void writeToParcel(Parcel parcel, int i) {
        Intrinsics.checkNotNullParameter(parcel, "dest");
        parcel.writeInt(this.shouldShowStatusLabel ? 1 : 0);
        parcel.writeInt(this.shouldSubstituteValueIntoText ? 1 : 0);
        parcel.writeInt(this.textResId);
        parcel.writeInt(this.valueForText);
        parcel.writeInt(this.backgroundResId);
    }

    public StatusLabelState(boolean z, boolean z2, int i, int i2, int i3) {
        this.shouldShowStatusLabel = z;
        this.shouldSubstituteValueIntoText = z2;
        this.textResId = i;
        this.valueForText = i2;
        this.backgroundResId = i3;
    }

    public final boolean getShouldShowStatusLabel() {
        return this.shouldShowStatusLabel;
    }

    public final boolean getShouldSubstituteValueIntoText() {
        return this.shouldSubstituteValueIntoText;
    }

    public final int getTextResId() {
        return this.textResId;
    }

    public final int getValueForText() {
        return this.valueForText;
    }

    public final int getBackgroundResId() {
        return this.backgroundResId;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000bJ\u0018\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000bJ \u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\r\u001a\u00020\u000bJ\u001c\u0010\u0004\u001a\u00020\u00052\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/blueair/viewcore/view/StatusLabelState$Companion;", "", "<init>", "()V", "from", "Lcom/blueair/viewcore/view/StatusLabelState;", "device", "Lcom/blueair/core/model/HasSensorData;", "realValue", "", "sensorType", "Lcom/blueair/core/model/SensorType;", "Lcom/blueair/core/model/Device;", "forcedSensorType", "fromSensors", "fromDatapoint", "dataPoint", "Lcom/blueair/core/model/IndoorDatapoint;", "indoorAirStatusLabel", "Lcom/blueair/viewcore/view/IndoorAirStatusLabel;", "filterLifetime", "Lcom/blueair/core/model/FilterLifeTime;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: StatusLabelTextView.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* compiled from: StatusLabelTextView.kt */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            static {
                /*
                    com.blueair.core.model.ConnectivityStatus[] r0 = com.blueair.core.model.ConnectivityStatus.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.OFFLINE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.CONNECTING     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.UPDATING     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.blueair.core.model.ConnectivityStatus r1 = com.blueair.core.model.ConnectivityStatus.ONLINE     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.view.StatusLabelState.Companion.WhenMappings.<clinit>():void");
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StatusLabelState from(HasSensorData hasSensorData, double d, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(sensorType, "sensorType");
            return from$default(this, IndoorAirStatusLabel.Companion.fromValueAndSensor(hasSensorData, d, sensorType), (FilterLifeTime) null, 2, (Object) null);
        }

        public static /* synthetic */ StatusLabelState from$default(Companion companion, Device device, SensorType sensorType, int i, Object obj) {
            if ((i & 2) != 0) {
                sensorType = null;
            }
            return companion.from(device, sensorType);
        }

        public final StatusLabelState from(Device device, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(device, "device");
            int i = R.drawable.status_label_dark_blue;
            int i2 = WhenMappings.$EnumSwitchMapping$0[device.getConnectivityStatus().ordinal()];
            if (i2 == 1) {
                return from((IndoorAirStatusLabel) IndoorAirStatusLabel.Offline.INSTANCE, DeviceKt.getFilterLifeTime(device));
            }
            if (i2 == 2) {
                return from((IndoorAirStatusLabel) IndoorAirStatusLabel.Connecting.INSTANCE, DeviceKt.getFilterLifeTime(device));
            }
            if (i2 == 3) {
                return from((IndoorAirStatusLabel) IndoorAirStatusLabel.Updating.INSTANCE, DeviceKt.getFilterLifeTime(device));
            }
            if (i2 == 4) {
                FilterLifeTime filterLifeTime = DeviceKt.getFilterLifeTime(device);
                if (device instanceof HasSensorData) {
                    if (sensorType == null) {
                        sensorType = ((HasSensorData) device).getLastSelectedSensorType();
                    }
                    return from(IndoorAirStatusLabel.Companion.fromDeviceAndSensor$default(IndoorAirStatusLabel.Companion, (HasSensorData) device, sensorType, false, 4, (Object) null), filterLifeTime);
                } else if (filterLifeTime instanceof FilterLifeTime.FilterDaysLeft) {
                    int filterLife = ((FilterLifeTime.FilterDaysLeft) filterLifeTime).getFilterLife();
                    if (filterLife <= 7) {
                        i = R.drawable.status_label_orange;
                    }
                    return new StatusLabelState(true, true, R.string.filter_usage, filterLife, i);
                } else if (filterLifeTime instanceof FilterLifeTime.FilterPercentageLeft) {
                    int filterLife2 = ((FilterLifeTime.FilterPercentageLeft) filterLifeTime).getFilterLife();
                    if (Integer.MIN_VALUE <= filterLife2 && filterLife2 < 11) {
                        i = R.drawable.status_label_red;
                    } else if (11 <= filterLife2 && filterLife2 < 91) {
                        i = R.drawable.status_label_orange;
                    } else if (90 <= filterLife2 && filterLife2 <= Integer.MAX_VALUE) {
                        i = R.drawable.status_label_blue;
                    }
                    return new StatusLabelState(true, true, R.string.filter_usage_percentage, filterLife2, i);
                } else if (filterLifeTime instanceof FilterLifeTime.NoFilterInfo) {
                    return new StatusLabelState(false, false, R.string.filter_na, 100, R.drawable.status_label_grey);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }

        public static /* synthetic */ StatusLabelState fromSensors$default(Companion companion, HasSensorData hasSensorData, SensorType sensorType, int i, Object obj) {
            if ((i & 2) != 0) {
                sensorType = SensorType.PM25;
            }
            return companion.fromSensors(hasSensorData, sensorType);
        }

        public final StatusLabelState fromSensors(HasSensorData hasSensorData, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(sensorType, "forcedSensorType");
            return from$default(this, IndoorAirStatusLabel.Companion.fromDeviceAndSensor(hasSensorData, sensorType, true), (FilterLifeTime) null, 2, (Object) null);
        }

        public static /* synthetic */ StatusLabelState fromDatapoint$default(Companion companion, IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData, SensorType sensorType, int i, Object obj) {
            if ((i & 4) != 0) {
                sensorType = SensorType.PM25;
            }
            return companion.fromDatapoint(indoorDatapoint, hasSensorData, sensorType);
        }

        public final StatusLabelState fromDatapoint(IndoorDatapoint indoorDatapoint, HasSensorData hasSensorData, SensorType sensorType) {
            Intrinsics.checkNotNullParameter(indoorDatapoint, "dataPoint");
            Intrinsics.checkNotNullParameter(hasSensorData, "device");
            Intrinsics.checkNotNullParameter(sensorType, "forcedSensorType");
            return from$default(this, IndoorAirStatusLabel.Companion.fromDeviceAndSensorAndDatapoint(indoorDatapoint, hasSensorData, sensorType, true), (FilterLifeTime) null, 2, (Object) null);
        }

        static /* synthetic */ StatusLabelState from$default(Companion companion, IndoorAirStatusLabel indoorAirStatusLabel, FilterLifeTime filterLifeTime, int i, Object obj) {
            if ((i & 2) != 0) {
                filterLifeTime = new FilterLifeTime.FilterDaysLeft(100, (Integer) null, 2, (DefaultConstructorMarker) null);
            }
            return companion.from(indoorAirStatusLabel, filterLifeTime);
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x0030  */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0032  */
        /* JADX WARNING: Removed duplicated region for block: B:19:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x005b  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final com.blueair.viewcore.view.StatusLabelState from(com.blueair.viewcore.view.IndoorAirStatusLabel r10, com.blueair.core.model.FilterLifeTime r11) {
            /*
                r9 = this;
                int r0 = com.blueair.viewcore.R.drawable.status_label_dark_blue
                r1 = 1
                r2 = 0
                if (r10 == 0) goto L_0x0008
                r4 = r1
                goto L_0x0009
            L_0x0008:
                r4 = r2
            L_0x0009:
                com.blueair.viewcore.view.IndoorAirStatusLabel$ReplaceFilter r3 = com.blueair.viewcore.view.IndoorAirStatusLabel.ReplaceFilter.INSTANCE
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r3)
                if (r3 == 0) goto L_0x0017
                int r3 = r10.getTextResId()
            L_0x0015:
                r6 = r3
                goto L_0x001f
            L_0x0017:
                if (r10 == 0) goto L_0x001e
                int r3 = r10.getTextResId()
                goto L_0x0015
            L_0x001e:
                r6 = r2
            L_0x001f:
                com.blueair.viewcore.view.IndoorAirStatusLabel$ReplaceFilter r3 = com.blueair.viewcore.view.IndoorAirStatusLabel.ReplaceFilter.INSTANCE
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r3)
                if (r3 != 0) goto L_0x0032
                com.blueair.viewcore.view.IndoorAirStatusLabel$ReplaceFilterPercentage r3 = com.blueair.viewcore.view.IndoorAirStatusLabel.ReplaceFilterPercentage.INSTANCE
                boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r3)
                if (r3 == 0) goto L_0x0030
                goto L_0x0032
            L_0x0030:
                r5 = r2
                goto L_0x0033
            L_0x0032:
                r5 = r1
            L_0x0033:
                boolean r1 = r10 instanceof com.blueair.viewcore.view.IndoorAirStatusLabel.ReplaceFilterPercentage
                if (r1 == 0) goto L_0x005b
                int r10 = r11.getFilterLife()
                r1 = -2147483648(0xffffffff80000000, float:-0.0)
                r2 = 11
                if (r1 > r10) goto L_0x0046
                if (r10 >= r2) goto L_0x0046
                int r0 = com.blueair.viewcore.R.drawable.status_label_red
                goto L_0x0061
            L_0x0046:
                if (r2 > r10) goto L_0x004f
                r1 = 91
                if (r10 >= r1) goto L_0x004f
                int r0 = com.blueair.viewcore.R.drawable.status_label_orange
                goto L_0x0061
            L_0x004f:
                r1 = 90
                if (r1 > r10) goto L_0x0061
                r1 = 2147483647(0x7fffffff, float:NaN)
                if (r10 > r1) goto L_0x0061
                int r0 = com.blueair.viewcore.R.drawable.status_label_blue
                goto L_0x0061
            L_0x005b:
                if (r10 == 0) goto L_0x0061
                int r0 = r10.getBackgroundResId()
            L_0x0061:
                r8 = r0
                com.blueair.viewcore.view.StatusLabelState r3 = new com.blueair.viewcore.view.StatusLabelState
                int r7 = r11.getFilterLife()
                r3.<init>(r4, r5, r6, r7, r8)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.viewcore.view.StatusLabelState.Companion.from(com.blueair.viewcore.view.IndoorAirStatusLabel, com.blueair.core.model.FilterLifeTime):com.blueair.viewcore.view.StatusLabelState");
        }
    }
}
