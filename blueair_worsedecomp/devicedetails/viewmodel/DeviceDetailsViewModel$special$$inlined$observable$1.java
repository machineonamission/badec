package com.blueair.devicedetails.viewmodel;

import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.properties.ObservableProperty;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: Delegates.kt */
public final class DeviceDetailsViewModel$special$$inlined$observable$1 extends ObservableProperty<Device> {
    final /* synthetic */ DeviceDetailsViewModel this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceDetailsViewModel$special$$inlined$observable$1(Object obj, DeviceDetailsViewModel deviceDetailsViewModel) {
        super(obj);
        this.this$0 = deviceDetailsViewModel;
    }

    /* JADX WARNING: type inference failed for: r21v1 */
    /* JADX WARNING: type inference failed for: r22v1 */
    /* JADX WARNING: type inference failed for: r21v2 */
    /* JADX WARNING: type inference failed for: r21v3 */
    /* JADX WARNING: type inference failed for: r21v4 */
    /* JADX WARNING: type inference failed for: r22v5 */
    /* JADX WARNING: type inference failed for: r22v6 */
    /* JADX WARNING: type inference failed for: r21v5 */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0189, code lost:
        if (r15.getWickUsage() == r16.getWickUsage()) goto L_0x0191;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x018f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x019b  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x01c0  */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x01dd  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01e0  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01ea  */
    /* JADX WARNING: Removed duplicated region for block: B:134:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x020d  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0224  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02ba  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x02d3  */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x02cb A[EDGE_INSN: B:172:0x02cb->B:155:0x02cb ?: BREAK  , SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:174:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00e6  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0100  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0136  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013b  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0146  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x014c  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0155  */
    /* JADX WARNING: Removed duplicated region for block: B:95:0x0158  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0161  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void afterChange(kotlin.reflect.KProperty<?> r21, com.blueair.core.model.Device r22, com.blueair.core.model.Device r23) {
        /*
            r20 = this;
            r0 = r20
            java.lang.String r1 = "property"
            r2 = r21
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r1)
            r1 = r23
            com.blueair.core.model.Device r1 = (com.blueair.core.model.Device) r1
            r2 = r22
            com.blueair.core.model.Device r2 = (com.blueair.core.model.Device) r2
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r3 = r0.this$0
            androidx.lifecycle.MutableLiveData r3 = r3._deviceOffline
            r5 = 1
            if (r1 == 0) goto L_0x0028
            int r6 = r1.getConnectivityStatusIndex()
            com.blueair.core.model.ConnectivityStatus r7 = com.blueair.core.model.ConnectivityStatus.ONLINE
            int r7 = r7.ordinal()
            if (r6 != r7) goto L_0x0028
            r6 = r5
            goto L_0x0029
        L_0x0028:
            r6 = 0
        L_0x0029:
            r6 = r6 ^ r5
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r3.postValue(r6)
            r3 = 0
            if (r2 == 0) goto L_0x0039
            java.lang.String r6 = r2.getUid()
            goto L_0x003a
        L_0x0039:
            r6 = r3
        L_0x003a:
            if (r1 == 0) goto L_0x0041
            java.lang.String r7 = r1.getUid()
            goto L_0x0042
        L_0x0041:
            r7 = r3
        L_0x0042:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0060
            if (r2 == 0) goto L_0x004f
            java.lang.String r6 = r2.getName()
            goto L_0x0050
        L_0x004f:
            r6 = r3
        L_0x0050:
            if (r1 == 0) goto L_0x0057
            java.lang.String r7 = r1.getName()
            goto L_0x0058
        L_0x0057:
            r7 = r3
        L_0x0058:
            boolean r6 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r6, (java.lang.Object) r7)
            if (r6 == 0) goto L_0x0060
            r6 = r5
            goto L_0x0061
        L_0x0060:
            r6 = 0
        L_0x0061:
            if (r2 == 0) goto L_0x0068
            java.lang.String r7 = r2.getModelName()
            goto L_0x0069
        L_0x0068:
            r7 = r3
        L_0x0069:
            if (r1 == 0) goto L_0x0070
            java.lang.String r8 = r1.getModelName()
            goto L_0x0071
        L_0x0070:
            r8 = r3
        L_0x0071:
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r2 == 0) goto L_0x007c
            java.util.TimeZone r8 = com.blueair.core.model.Device.CC.getTimezone$default(r2, r3, r5, r3)
            goto L_0x007d
        L_0x007c:
            r8 = r3
        L_0x007d:
            if (r1 == 0) goto L_0x0084
            java.util.TimeZone r9 = com.blueair.core.model.Device.CC.getTimezone$default(r1, r3, r5, r3)
            goto L_0x0085
        L_0x0084:
            r9 = r3
        L_0x0085:
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r9)
            boolean r9 = r2 instanceof com.blueair.core.model.HasFanSpeed
            if (r9 == 0) goto L_0x00ae
            boolean r10 = r1 instanceof com.blueair.core.model.HasFanSpeed
            if (r10 == 0) goto L_0x00ae
            int r10 = com.blueair.core.model.DeviceKt.fanSpeedValue(r2)
            int r11 = com.blueair.core.model.DeviceKt.fanSpeedValue(r1)
            if (r10 != r11) goto L_0x00ac
            r10 = r2
            com.blueair.core.model.HasFanSpeed r10 = (com.blueair.core.model.HasFanSpeed) r10
            com.blueair.core.model.AutoMode r10 = r10.getAutoMode()
            r11 = r1
            com.blueair.core.model.HasFanSpeed r11 = (com.blueair.core.model.HasFanSpeed) r11
            com.blueair.core.model.AutoMode r11 = r11.getAutoMode()
            if (r10 != r11) goto L_0x00ac
            goto L_0x00ae
        L_0x00ac:
            r10 = 0
            goto L_0x00af
        L_0x00ae:
            r10 = r5
        L_0x00af:
            boolean r11 = r2 instanceof com.blueair.core.model.HasBrightness
            if (r11 == 0) goto L_0x00ca
            boolean r11 = r1 instanceof com.blueair.core.model.HasBrightness
            if (r11 == 0) goto L_0x00ca
            r11 = r2
            com.blueair.core.model.HasBrightness r11 = (com.blueair.core.model.HasBrightness) r11
            int r11 = r11.getBrightness()
            r12 = r1
            com.blueair.core.model.HasBrightness r12 = (com.blueair.core.model.HasBrightness) r12
            int r12 = r12.getBrightness()
            if (r11 != r12) goto L_0x00c8
            goto L_0x00ca
        L_0x00c8:
            r11 = 0
            goto L_0x00cb
        L_0x00ca:
            r11 = r5
        L_0x00cb:
            boolean r12 = r2 instanceof com.blueair.core.model.HasChildLock
            if (r12 == 0) goto L_0x00e6
            boolean r12 = r1 instanceof com.blueair.core.model.HasChildLock
            if (r12 == 0) goto L_0x00e6
            r12 = r2
            com.blueair.core.model.HasChildLock r12 = (com.blueair.core.model.HasChildLock) r12
            boolean r12 = r12.isChildLockOn()
            r13 = r1
            com.blueair.core.model.HasChildLock r13 = (com.blueair.core.model.HasChildLock) r13
            boolean r13 = r13.isChildLockOn()
            if (r12 != r13) goto L_0x00e4
            goto L_0x00e6
        L_0x00e4:
            r12 = 0
            goto L_0x00e7
        L_0x00e6:
            r12 = r5
        L_0x00e7:
            boolean r13 = r2 instanceof com.blueair.core.model.HasSafetySwitch
            if (r13 == 0) goto L_0x0102
            boolean r13 = r1 instanceof com.blueair.core.model.HasSafetySwitch
            if (r13 == 0) goto L_0x0102
            r13 = r2
            com.blueair.core.model.HasSafetySwitch r13 = (com.blueair.core.model.HasSafetySwitch) r13
            boolean r13 = r13.isSafetySwitchOn()
            r14 = r1
            com.blueair.core.model.HasSafetySwitch r14 = (com.blueair.core.model.HasSafetySwitch) r14
            boolean r14 = r14.isSafetySwitchOn()
            if (r13 != r14) goto L_0x0100
            goto L_0x0102
        L_0x0100:
            r13 = 0
            goto L_0x0103
        L_0x0102:
            r13 = r5
        L_0x0103:
            if (r9 == 0) goto L_0x0131
            boolean r9 = r1 instanceof com.blueair.core.model.HasFanSpeed
            if (r9 == 0) goto L_0x0131
            r9 = r2
            com.blueair.core.model.HasFanSpeed r9 = (com.blueair.core.model.HasFanSpeed) r9
            com.blueair.core.model.Filter r14 = r9.getFilter()
            r15 = r1
            com.blueair.core.model.HasFanSpeed r15 = (com.blueair.core.model.HasFanSpeed) r15
            r21 = 0
            com.blueair.core.model.Filter r4 = r15.getFilter()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r4)
            if (r4 == 0) goto L_0x012e
            java.lang.Integer r4 = r9.getFilterLife()
            java.lang.Integer r9 = r15.getFilterLife()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r9)
            if (r4 == 0) goto L_0x012e
            goto L_0x0133
        L_0x012e:
            r4 = r21
            goto L_0x0134
        L_0x0131:
            r21 = 0
        L_0x0133:
            r4 = r5
        L_0x0134:
            if (r2 == 0) goto L_0x013b
            com.blueair.core.model.ConnectivityStatus r9 = r2.getConnectivityStatus()
            goto L_0x013c
        L_0x013b:
            r9 = r3
        L_0x013c:
            if (r1 == 0) goto L_0x0143
            com.blueair.core.model.ConnectivityStatus r14 = r1.getConnectivityStatus()
            goto L_0x0144
        L_0x0143:
            r14 = r3
        L_0x0144:
            if (r9 != r14) goto L_0x0148
            r9 = r5
            goto L_0x014a
        L_0x0148:
            r9 = r21
        L_0x014a:
            if (r2 == 0) goto L_0x0155
            int r14 = r2.getUpdateProgress()
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            goto L_0x0156
        L_0x0155:
            r14 = r3
        L_0x0156:
            if (r1 == 0) goto L_0x0161
            int r15 = r1.getUpdateProgress()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            goto L_0x0162
        L_0x0161:
            r15 = r3
        L_0x0162:
            boolean r14 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r14, (java.lang.Object) r15)
            boolean r15 = r2 instanceof com.blueair.core.model.HasWick
            if (r15 == 0) goto L_0x018f
            boolean r15 = r1 instanceof com.blueair.core.model.HasWick
            if (r15 == 0) goto L_0x018f
            r15 = r2
            com.blueair.core.model.HasWick r15 = (com.blueair.core.model.HasWick) r15
            r22 = r5
            boolean r5 = r15.getWaterShortage()
            r16 = r1
            com.blueair.core.model.HasWick r16 = (com.blueair.core.model.HasWick) r16
            boolean r3 = r16.getWaterShortage()
            if (r5 != r3) goto L_0x018c
            int r3 = r15.getWickUsage()
            int r5 = r16.getWickUsage()
            if (r3 != r5) goto L_0x018c
            goto L_0x0191
        L_0x018c:
            r3 = r21
            goto L_0x0193
        L_0x018f:
            r22 = r5
        L_0x0191:
            r3 = r22
        L_0x0193:
            boolean r5 = r2 instanceof com.blueair.core.model.HasRemoveYellowWater
            if (r5 == 0) goto L_0x01c0
            boolean r5 = r1 instanceof com.blueair.core.model.HasRemoveYellowWater
            if (r5 == 0) goto L_0x01c0
            r5 = r2
            com.blueair.core.model.HasRemoveYellowWater r5 = (com.blueair.core.model.HasRemoveYellowWater) r5
            java.lang.Boolean r15 = r5.getYwrmEnabled()
            r16 = r1
            com.blueair.core.model.HasRemoveYellowWater r16 = (com.blueair.core.model.HasRemoveYellowWater) r16
            r17 = r3
            java.lang.Boolean r3 = r16.getYwrmEnabled()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x01bd
            int r3 = r5.getYwrmUsage()
            int r5 = r16.getYwrmUsage()
            if (r3 != r5) goto L_0x01bd
            goto L_0x01c2
        L_0x01bd:
            r3 = r21
            goto L_0x01c4
        L_0x01c0:
            r17 = r3
        L_0x01c2:
            r3 = r22
        L_0x01c4:
            boolean r5 = r2 instanceof com.blueair.core.model.HasWaterLevel
            if (r5 == 0) goto L_0x01e0
            boolean r5 = r1 instanceof com.blueair.core.model.HasWaterLevel
            if (r5 == 0) goto L_0x01e0
            r5 = r2
            com.blueair.core.model.HasWaterLevel r5 = (com.blueair.core.model.HasWaterLevel) r5
            int r5 = r5.getWaterLevel()
            r15 = r1
            com.blueair.core.model.HasWaterLevel r15 = (com.blueair.core.model.HasWaterLevel) r15
            int r15 = r15.getWaterLevel()
            if (r5 != r15) goto L_0x01dd
            goto L_0x01e0
        L_0x01dd:
            r5 = r21
            goto L_0x01e2
        L_0x01e0:
            r5 = r22
        L_0x01e2:
            boolean r15 = r2 instanceof com.blueair.core.model.HasWaterTank
            if (r15 == 0) goto L_0x0201
            boolean r15 = r1 instanceof com.blueair.core.model.HasWaterTank
            if (r15 == 0) goto L_0x0201
            r15 = r2
            com.blueair.core.model.HasWaterTank r15 = (com.blueair.core.model.HasWaterTank) r15
            boolean r15 = r15.getWaterTankFailure()
            r16 = r1
            com.blueair.core.model.HasWaterTank r16 = (com.blueair.core.model.HasWaterTank) r16
            r18 = r3
            boolean r3 = r16.getWaterTankFailure()
            if (r15 != r3) goto L_0x01fe
            goto L_0x0203
        L_0x01fe:
            r3 = r21
            goto L_0x0205
        L_0x0201:
            r18 = r3
        L_0x0203:
            r3 = r22
        L_0x0205:
            boolean r15 = r2 instanceof com.blueair.core.model.HasSensorMode
            if (r15 == 0) goto L_0x0224
            boolean r15 = r1 instanceof com.blueair.core.model.HasSensorMode
            if (r15 == 0) goto L_0x0224
            r15 = r2
            com.blueair.core.model.HasSensorMode r15 = (com.blueair.core.model.HasSensorMode) r15
            int r15 = r15.getSensorMode()
            r16 = r1
            com.blueair.core.model.HasSensorMode r16 = (com.blueair.core.model.HasSensorMode) r16
            r19 = r3
            int r3 = r16.getSensorMode()
            if (r15 != r3) goto L_0x0221
            goto L_0x0226
        L_0x0221:
            r3 = r21
            goto L_0x0228
        L_0x0224:
            r19 = r3
        L_0x0226:
            r3 = r22
        L_0x0228:
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            java.lang.Boolean r11 = java.lang.Boolean.valueOf(r11)
            java.lang.Boolean r10 = java.lang.Boolean.valueOf(r10)
            java.lang.Boolean r12 = java.lang.Boolean.valueOf(r12)
            java.lang.Boolean r13 = java.lang.Boolean.valueOf(r13)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Boolean r9 = java.lang.Boolean.valueOf(r9)
            java.lang.Boolean r14 = java.lang.Boolean.valueOf(r14)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r17)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)
            java.lang.Boolean r16 = java.lang.Boolean.valueOf(r19)
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r18)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r18 = r3
            r3 = 15
            java.lang.Boolean[] r3 = new java.lang.Boolean[r3]
            r3[r21] = r6
            r3[r22] = r7
            r6 = 2
            r3[r6] = r8
            r6 = 3
            r3[r6] = r11
            r6 = 4
            r3[r6] = r10
            r6 = 5
            r3[r6] = r12
            r6 = 6
            r3[r6] = r13
            r6 = 7
            r3[r6] = r4
            r4 = 8
            r3[r4] = r9
            r4 = 9
            r3[r4] = r14
            r4 = 10
            r3[r4] = r15
            r4 = 11
            r3[r4] = r5
            r4 = 12
            r3[r4] = r16
            r4 = 13
            r3[r4] = r17
            r4 = 14
            r3[r4] = r18
            java.util.List r3 = kotlin.collections.CollectionsKt.listOf(r3)
            java.lang.Iterable r3 = (java.lang.Iterable) r3
            boolean r4 = r3 instanceof java.util.Collection
            if (r4 == 0) goto L_0x02b0
            r4 = r3
            java.util.Collection r4 = (java.util.Collection) r4
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x02b0
            goto L_0x02cb
        L_0x02b0:
            java.util.Iterator r3 = r3.iterator()
        L_0x02b4:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x02cb
            java.lang.Object r4 = r3.next()
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            if (r4 != 0) goto L_0x02b4
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r3 = r0.this$0
            r3.updateState()
        L_0x02cb:
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r3 = r0.this$0
            boolean r3 = r3.isAttachedToDeviceDetailsDialogFragment()
            if (r3 == 0) goto L_0x0316
            if (r2 != 0) goto L_0x02d8
            r5 = r22
            goto L_0x02da
        L_0x02d8:
            boolean r5 = r2 instanceof com.blueair.core.model.HasLocation
        L_0x02da:
            if (r5 == 0) goto L_0x0316
            boolean r3 = r1 instanceof com.blueair.core.model.HasLocation
            if (r3 == 0) goto L_0x0316
            com.blueair.core.model.HasLocation r2 = (com.blueair.core.model.HasLocation) r2
            if (r2 == 0) goto L_0x02ea
            java.lang.String r2 = r2.getLocationId()
            if (r2 != 0) goto L_0x02ec
        L_0x02ea:
            java.lang.String r2 = ""
        L_0x02ec:
            r3 = r1
            com.blueair.core.model.HasLocation r3 = (com.blueair.core.model.HasLocation) r3
            java.lang.String r3 = r3.getLocationId()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x0316
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r2 = r0.this$0
            r3 = r2
            kotlinx.coroutines.CoroutineScope r3 = (kotlinx.coroutines.CoroutineScope) r3
            kotlinx.coroutines.CoroutineDispatcher r2 = kotlinx.coroutines.Dispatchers.getIO()
            r4 = r2
            kotlin.coroutines.CoroutineContext r4 = (kotlin.coroutines.CoroutineContext) r4
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$device$2$1 r2 = new com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$device$2$1
            com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel r5 = r0.this$0
            r6 = 0
            r2.<init>(r5, r1, r6)
            r6 = r2
            kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
            r7 = 2
            r8 = 0
            r5 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r3, r4, r5, r6, r7, r8)
        L_0x0316:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.viewmodel.DeviceDetailsViewModel$special$$inlined$observable$1.afterChange(kotlin.reflect.KProperty, java.lang.Object, java.lang.Object):void");
    }
}
