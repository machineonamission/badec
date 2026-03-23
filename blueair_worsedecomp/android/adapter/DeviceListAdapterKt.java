package com.blueair.android.adapter;

import com.blueair.core.model.Device;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u001e\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00042\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0002¨\u0006\b"}, d2 = {"doListsContainSameDevices", "", "nuList", "", "Lcom/blueair/core/model/Device;", "oldList", "hasDeviceChanged", "o", "app_otherRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceListAdapter.kt */
public final class DeviceListAdapterKt {
    /* access modifiers changed from: private */
    public static final boolean doListsContainSameDevices(List<? extends Device> list, List<? extends Device> list2) {
        Iterable<Device> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (Device uid : iterable) {
            arrayList.add(uid.getUid());
        }
        Set set = CollectionsKt.toSet((List) arrayList);
        Iterable<Device> iterable2 = list2;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable2, 10));
        for (Device uid2 : iterable2) {
            arrayList2.add(uid2.getUid());
        }
        return Intrinsics.areEqual((Object) set, (Object) CollectionsKt.toSet((List) arrayList2));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x01fd, code lost:
        if (kotlin.jvm.internal.Intrinsics.areEqual(r2, r1) == false) goto L_0x01ff;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x0294, code lost:
        if (((com.blueair.core.model.HasPetMainMode) r9).getSmartSubMode() != ((com.blueair.core.model.HasPetMainMode) r0).getSmartSubMode()) goto L_0x0296;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final boolean hasDeviceChanged(com.blueair.core.model.Device r9, java.util.List<? extends com.blueair.core.model.Device> r10) {
        /*
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.Iterator r10 = r10.iterator()
        L_0x0006:
            boolean r0 = r10.hasNext()
            r1 = 0
            if (r0 == 0) goto L_0x0023
            java.lang.Object r0 = r10.next()
            r2 = r0
            com.blueair.core.model.Device r2 = (com.blueair.core.model.Device) r2
            java.lang.String r2 = r2.getUid()
            java.lang.String r3 = r9.getUid()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 == 0) goto L_0x0006
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            com.blueair.core.model.Device r0 = (com.blueair.core.model.Device) r0
            r10 = 1
            if (r0 != 0) goto L_0x002a
            return r10
        L_0x002a:
            com.blueair.core.model.DeviceType r2 = r9.getType()
            com.blueair.core.model.DeviceType r3 = r0.getType()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x0039
            return r10
        L_0x0039:
            java.lang.String r2 = r9.getName()
            java.lang.String r3 = r0.getName()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x0048
            return r10
        L_0x0048:
            com.blueair.core.model.ConnectivityStatus r2 = r9.getConnectivityStatus()
            com.blueair.core.model.ConnectivityStatus r3 = r0.getConnectivityStatus()
            if (r2 == r3) goto L_0x0053
            return r10
        L_0x0053:
            boolean r2 = r9 instanceof com.blueair.core.model.HasFanSpeed
            if (r2 == 0) goto L_0x009c
            boolean r2 = r0 instanceof com.blueair.core.model.HasFanSpeed
            if (r2 == 0) goto L_0x009c
            r2 = r9
            com.blueair.core.model.HasFanSpeed r2 = (com.blueair.core.model.HasFanSpeed) r2
            com.blueair.core.model.AutoMode r3 = r2.getAutoMode()
            r4 = r0
            com.blueair.core.model.HasFanSpeed r4 = (com.blueair.core.model.HasFanSpeed) r4
            com.blueair.core.model.AutoMode r5 = r4.getAutoMode()
            if (r3 != r5) goto L_0x009b
            boolean r3 = r9 instanceof com.blueair.core.model.HasG4NightMode
            if (r3 == 0) goto L_0x0083
            boolean r3 = r0 instanceof com.blueair.core.model.HasG4NightMode
            if (r3 == 0) goto L_0x0083
            r3 = r9
            com.blueair.core.model.HasG4NightMode r3 = (com.blueair.core.model.HasG4NightMode) r3
            boolean r3 = r3.isG4NightModeOn()
            r5 = r0
            com.blueair.core.model.HasG4NightMode r5 = (com.blueair.core.model.HasG4NightMode) r5
            boolean r5 = r5.isG4NightModeOn()
            if (r3 != r5) goto L_0x009b
        L_0x0083:
            int r3 = com.blueair.core.model.DeviceKt.fanSpeedValue(r9)
            int r5 = com.blueair.core.model.DeviceKt.fanSpeedValue(r0)
            if (r3 != r5) goto L_0x009b
            java.lang.Integer r2 = r2.getFilterLife()
            java.lang.Integer r3 = r4.getFilterLife()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x009c
        L_0x009b:
            return r10
        L_0x009c:
            boolean r2 = r9 instanceof com.blueair.core.model.HasWelcomeHome
            if (r2 == 0) goto L_0x00d1
            boolean r2 = r0 instanceof com.blueair.core.model.HasWelcomeHome
            if (r2 == 0) goto L_0x00d1
            r2 = r9
            com.blueair.core.model.HasWelcomeHome r2 = (com.blueair.core.model.HasWelcomeHome) r2
            com.blueair.core.model.WelcomeHomeLocation r2 = r2.getWelcomeHome()
            if (r2 == 0) goto L_0x00b6
            boolean r2 = r2.isEnabled()
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            goto L_0x00b7
        L_0x00b6:
            r2 = r1
        L_0x00b7:
            r3 = r0
            com.blueair.core.model.HasWelcomeHome r3 = (com.blueair.core.model.HasWelcomeHome) r3
            com.blueair.core.model.WelcomeHomeLocation r3 = r3.getWelcomeHome()
            if (r3 == 0) goto L_0x00c9
            boolean r3 = r3.isEnabled()
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            goto L_0x00ca
        L_0x00c9:
            r3 = r1
        L_0x00ca:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x00d1
            return r10
        L_0x00d1:
            boolean r2 = r9 instanceof com.blueair.core.model.HasStandBy
            if (r2 == 0) goto L_0x00ea
            boolean r2 = r0 instanceof com.blueair.core.model.HasStandBy
            if (r2 == 0) goto L_0x00ea
            r2 = r9
            com.blueair.core.model.HasStandBy r2 = (com.blueair.core.model.HasStandBy) r2
            boolean r2 = r2.isStandByOn()
            r3 = r0
            com.blueair.core.model.HasStandBy r3 = (com.blueair.core.model.HasStandBy) r3
            boolean r3 = r3.isStandByOn()
            if (r2 == r3) goto L_0x00ea
            return r10
        L_0x00ea:
            boolean r2 = r9 instanceof com.blueair.core.model.HasEcoMode
            if (r2 == 0) goto L_0x0103
            boolean r2 = r0 instanceof com.blueair.core.model.HasEcoMode
            if (r2 == 0) goto L_0x0103
            r2 = r9
            com.blueair.core.model.HasEcoMode r2 = (com.blueair.core.model.HasEcoMode) r2
            boolean r2 = r2.isEcoModeOn()
            r3 = r0
            com.blueair.core.model.HasEcoMode r3 = (com.blueair.core.model.HasEcoMode) r3
            boolean r3 = r3.isEcoModeOn()
            if (r2 == r3) goto L_0x0103
            return r10
        L_0x0103:
            boolean r2 = r9 instanceof com.blueair.core.model.HasSafetySwitch
            if (r2 == 0) goto L_0x011c
            boolean r2 = r0 instanceof com.blueair.core.model.HasSafetySwitch
            if (r2 == 0) goto L_0x011c
            r2 = r9
            com.blueair.core.model.HasSafetySwitch r2 = (com.blueair.core.model.HasSafetySwitch) r2
            boolean r2 = r2.isSafetySwitchOn()
            r3 = r0
            com.blueair.core.model.HasSafetySwitch r3 = (com.blueair.core.model.HasSafetySwitch) r3
            boolean r3 = r3.isSafetySwitchOn()
            if (r2 == r3) goto L_0x011c
            return r10
        L_0x011c:
            boolean r2 = r9 instanceof com.blueair.core.model.HasLinkingCapability
            if (r2 == 0) goto L_0x0135
            boolean r2 = r0 instanceof com.blueair.core.model.HasLinkingCapability
            if (r2 == 0) goto L_0x0135
            r2 = r9
            com.blueair.core.model.HasLinkingCapability r2 = (com.blueair.core.model.HasLinkingCapability) r2
            boolean r2 = r2.isLinked()
            r3 = r0
            com.blueair.core.model.HasLinkingCapability r3 = (com.blueair.core.model.HasLinkingCapability) r3
            boolean r3 = r3.isLinked()
            if (r2 == r3) goto L_0x0135
            return r10
        L_0x0135:
            boolean r2 = r9 instanceof com.blueair.core.model.HasChildLock
            if (r2 == 0) goto L_0x014e
            boolean r2 = r0 instanceof com.blueair.core.model.HasChildLock
            if (r2 == 0) goto L_0x014e
            r2 = r9
            com.blueair.core.model.HasChildLock r2 = (com.blueair.core.model.HasChildLock) r2
            boolean r2 = r2.isChildLockOn()
            r3 = r0
            com.blueair.core.model.HasChildLock r3 = (com.blueair.core.model.HasChildLock) r3
            boolean r3 = r3.isChildLockOn()
            if (r2 == r3) goto L_0x014e
            return r10
        L_0x014e:
            int r2 = r9.getUpdateProgress()
            int r3 = r0.getUpdateProgress()
            if (r2 == r3) goto L_0x0159
            return r10
        L_0x0159:
            boolean r2 = r9 instanceof com.blueair.core.model.HasDisinfection
            if (r2 == 0) goto L_0x0192
            boolean r2 = r0 instanceof com.blueair.core.model.HasDisinfection
            if (r2 == 0) goto L_0x0192
            r2 = r9
            com.blueair.core.model.HasDisinfection r2 = (com.blueair.core.model.HasDisinfection) r2
            java.lang.Boolean r3 = r2.getDisinfection()
            r4 = r0
            com.blueair.core.model.HasDisinfection r4 = (com.blueair.core.model.HasDisinfection) r4
            java.lang.Boolean r5 = r4.getDisinfection()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0191
            java.lang.Integer r3 = r2.getDisinfectLeftTime()
            java.lang.Integer r5 = r4.getDisinfectLeftTime()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0191
            java.lang.Long r2 = r2.getDisinfectLeftTimeUpdateTime()
            java.lang.Long r3 = r4.getDisinfectLeftTimeUpdateTime()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            if (r2 != 0) goto L_0x0192
        L_0x0191:
            return r10
        L_0x0192:
            boolean r2 = r9 instanceof com.blueair.core.model.HasWick
            if (r2 == 0) goto L_0x0200
            boolean r2 = r0 instanceof com.blueair.core.model.HasWick
            if (r2 == 0) goto L_0x0200
            r2 = r9
            com.blueair.core.model.HasWick r2 = (com.blueair.core.model.HasWick) r2
            boolean r3 = r2.getWickdryOn()
            r4 = r0
            com.blueair.core.model.HasWick r4 = (com.blueair.core.model.HasWick) r4
            boolean r5 = r4.getWickdryOn()
            if (r3 != r5) goto L_0x01ff
            int r3 = r2.getWickdryLeftTime()
            int r5 = r4.getWickdryLeftTime()
            if (r3 != r5) goto L_0x01ff
            long r5 = r2.getWickdryLeftTimeUpdateTime()
            long r7 = r4.getWickdryLeftTimeUpdateTime()
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 != 0) goto L_0x01ff
            boolean r3 = r2.getWaterShortage()
            boolean r5 = r4.getWaterShortage()
            if (r3 != r5) goto L_0x01ff
            int r2 = r2.getWickUsage()
            int r3 = r4.getWickUsage()
            if (r2 == r3) goto L_0x01d5
            goto L_0x01ff
        L_0x01d5:
            boolean r2 = r9 instanceof com.blueair.core.model.HasSensorData
            if (r2 == 0) goto L_0x0200
            boolean r2 = r0 instanceof com.blueair.core.model.HasSensorData
            if (r2 == 0) goto L_0x0200
            r2 = r9
            com.blueair.core.model.HasSensorData r2 = (com.blueair.core.model.HasSensorData) r2
            com.blueair.core.model.IndoorDatapoint r2 = r2.getLatestSensorDatapoint()
            if (r2 == 0) goto L_0x01eb
            java.lang.Float r2 = r2.getHum()
            goto L_0x01ec
        L_0x01eb:
            r2 = r1
        L_0x01ec:
            r3 = r0
            com.blueair.core.model.HasSensorData r3 = (com.blueair.core.model.HasSensorData) r3
            com.blueair.core.model.IndoorDatapoint r3 = r3.getLatestSensorDatapoint()
            if (r3 == 0) goto L_0x01f9
            java.lang.Float r1 = r3.getHum()
        L_0x01f9:
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Float) r2, (java.lang.Float) r1)
            if (r1 != 0) goto L_0x0200
        L_0x01ff:
            return r10
        L_0x0200:
            boolean r1 = r9 instanceof com.blueair.core.model.HasMainMode
            if (r1 == 0) goto L_0x0297
            boolean r1 = r0 instanceof com.blueair.core.model.HasMainMode
            if (r1 == 0) goto L_0x0297
            r1 = r9
            com.blueair.core.model.HasMainMode r1 = (com.blueair.core.model.HasMainMode) r1
            int r2 = r1.getMainMode()
            r3 = r0
            com.blueair.core.model.HasMainMode r3 = (com.blueair.core.model.HasMainMode) r3
            int r4 = r3.getMainMode()
            if (r2 != r4) goto L_0x0296
            int r1 = r1.getApSubMode()
            int r2 = r3.getApSubMode()
            if (r1 == r2) goto L_0x0224
            goto L_0x0296
        L_0x0224:
            boolean r1 = r9 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r1 == 0) goto L_0x0265
            boolean r1 = r0 instanceof com.blueair.core.model.HasCombo3in1MainMode
            if (r1 == 0) goto L_0x0265
            r1 = r9
            com.blueair.core.model.HasCombo3in1MainMode r1 = (com.blueair.core.model.HasCombo3in1MainMode) r1
            int r2 = r1.getApFanSpeed()
            r3 = r0
            com.blueair.core.model.HasCombo3in1MainMode r3 = (com.blueair.core.model.HasCombo3in1MainMode) r3
            int r4 = r3.getApFanSpeed()
            if (r2 != r4) goto L_0x0264
            int r2 = r1.getHeatSubMode()
            int r4 = r3.getHeatSubMode()
            if (r2 != r4) goto L_0x0264
            int r2 = r1.getHeatFanSpeed()
            int r4 = r3.getHeatFanSpeed()
            if (r2 != r4) goto L_0x0264
            int r2 = r1.getCoolSubMode()
            int r4 = r3.getCoolSubMode()
            if (r2 != r4) goto L_0x0264
            int r1 = r1.getCoolFanSpeed()
            int r2 = r3.getCoolFanSpeed()
            if (r1 == r2) goto L_0x0297
        L_0x0264:
            return r10
        L_0x0265:
            boolean r1 = r9 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r1 == 0) goto L_0x027e
            boolean r1 = r0 instanceof com.blueair.core.model.HasDehumidifierMainMode
            if (r1 == 0) goto L_0x027e
            r1 = r9
            com.blueair.core.model.HasDehumidifierMainMode r1 = (com.blueair.core.model.HasDehumidifierMainMode) r1
            int r1 = r1.getDehSubMode()
            r2 = r0
            com.blueair.core.model.HasDehumidifierMainMode r2 = (com.blueair.core.model.HasDehumidifierMainMode) r2
            int r2 = r2.getDehSubMode()
            if (r1 == r2) goto L_0x0297
            return r10
        L_0x027e:
            boolean r1 = r9 instanceof com.blueair.core.model.HasPetMainMode
            if (r1 == 0) goto L_0x0297
            boolean r1 = r0 instanceof com.blueair.core.model.HasPetMainMode
            if (r1 == 0) goto L_0x0297
            r1 = r9
            com.blueair.core.model.HasPetMainMode r1 = (com.blueair.core.model.HasPetMainMode) r1
            int r1 = r1.getSmartSubMode()
            r2 = r0
            com.blueair.core.model.HasPetMainMode r2 = (com.blueair.core.model.HasPetMainMode) r2
            int r2 = r2.getSmartSubMode()
            if (r1 == r2) goto L_0x0297
        L_0x0296:
            return r10
        L_0x0297:
            boolean r1 = com.blueair.core.model.DeviceKt.isCelsiusUnit(r9)
            boolean r2 = com.blueair.core.model.DeviceKt.isCelsiusUnit(r0)
            if (r1 == r2) goto L_0x02a2
            return r10
        L_0x02a2:
            boolean r1 = r9 instanceof com.blueair.core.model.HasMode
            if (r1 == 0) goto L_0x02bb
            boolean r1 = r0 instanceof com.blueair.core.model.HasMode
            if (r1 == 0) goto L_0x02bb
            r1 = r9
            com.blueair.core.model.HasMode r1 = (com.blueair.core.model.HasMode) r1
            int r1 = r1.getMode()
            r2 = r0
            com.blueair.core.model.HasMode r2 = (com.blueair.core.model.HasMode) r2
            int r2 = r2.getMode()
            if (r1 == r2) goto L_0x02bb
            return r10
        L_0x02bb:
            boolean r1 = r9 instanceof com.blueair.core.model.HasHumMode
            if (r1 == 0) goto L_0x02d4
            boolean r1 = r0 instanceof com.blueair.core.model.HasHumMode
            if (r1 == 0) goto L_0x02d4
            r1 = r9
            com.blueair.core.model.HasHumMode r1 = (com.blueair.core.model.HasHumMode) r1
            boolean r1 = r1.getHumMode()
            r2 = r0
            com.blueair.core.model.HasHumMode r2 = (com.blueair.core.model.HasHumMode) r2
            boolean r2 = r2.getHumMode()
            if (r1 == r2) goto L_0x02d4
            return r10
        L_0x02d4:
            boolean r1 = r9 instanceof com.blueair.core.model.HasTimer
            if (r1 == 0) goto L_0x02ed
            boolean r1 = r0 instanceof com.blueair.core.model.HasTimer
            if (r1 == 0) goto L_0x02ed
            r1 = r9
            com.blueair.core.model.HasTimer r1 = (com.blueair.core.model.HasTimer) r1
            int r1 = r1.getLeftSeconds()
            r2 = r0
            com.blueair.core.model.HasTimer r2 = (com.blueair.core.model.HasTimer) r2
            int r2 = r2.getLeftSeconds()
            if (r1 == r2) goto L_0x02ed
            return r10
        L_0x02ed:
            boolean r1 = r9 instanceof com.blueair.core.model.HasAlarm
            if (r1 == 0) goto L_0x030a
            boolean r1 = r0 instanceof com.blueair.core.model.HasAlarm
            if (r1 == 0) goto L_0x030a
            r1 = r9
            com.blueair.core.model.HasAlarm r1 = (com.blueair.core.model.HasAlarm) r1
            java.util.List r1 = r1.getAlarms()
            r2 = r0
            com.blueair.core.model.HasAlarm r2 = (com.blueair.core.model.HasAlarm) r2
            java.util.List r2 = r2.getAlarms()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r1 != 0) goto L_0x030a
            return r10
        L_0x030a:
            boolean r1 = r9 instanceof com.blueair.core.model.HasWaterLevel
            if (r1 == 0) goto L_0x0323
            boolean r1 = r0 instanceof com.blueair.core.model.HasWaterLevel
            if (r1 == 0) goto L_0x0323
            r1 = r9
            com.blueair.core.model.HasWaterLevel r1 = (com.blueair.core.model.HasWaterLevel) r1
            int r1 = r1.getWaterLevel()
            r2 = r0
            com.blueair.core.model.HasWaterLevel r2 = (com.blueair.core.model.HasWaterLevel) r2
            int r2 = r2.getWaterLevel()
            if (r1 == r2) goto L_0x0323
            return r10
        L_0x0323:
            boolean r1 = r9 instanceof com.blueair.core.model.HasSensorMode
            if (r1 == 0) goto L_0x033a
            boolean r1 = r0 instanceof com.blueair.core.model.HasSensorMode
            if (r1 == 0) goto L_0x033a
            com.blueair.core.model.HasSensorMode r9 = (com.blueair.core.model.HasSensorMode) r9
            int r9 = r9.getSensorMode()
            com.blueair.core.model.HasSensorMode r0 = (com.blueair.core.model.HasSensorMode) r0
            int r0 = r0.getSensorMode()
            if (r9 == r0) goto L_0x033a
            return r10
        L_0x033a:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.adapter.DeviceListAdapterKt.hasDeviceChanged(com.blueair.core.model.Device, java.util.List):boolean");
    }
}
