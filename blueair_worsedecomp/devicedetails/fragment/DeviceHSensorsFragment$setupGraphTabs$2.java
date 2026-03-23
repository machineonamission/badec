package com.blueair.devicedetails.fragment;

import com.blueair.core.model.DeviceKt;
import com.blueair.core.model.HasSensorData;
import com.blueair.core.model.SensorType;
import com.blueair.graph.view.GraphViewH;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/fragment/DeviceHSensorsFragment$setupGraphTabs$2", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabUnselected", "onTabSelected", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceHSensorsFragment.kt */
public final class DeviceHSensorsFragment$setupGraphTabs$2 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ DeviceHSensorsFragment this$0;

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DeviceHSensorsFragment.kt */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.blueair.core.model.SensorType[] r0 = com.blueair.core.model.SensorType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM1     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM25     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.PM10     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.VOC     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.HUM     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.blueair.core.model.SensorType r1 = com.blueair.core.model.SensorType.TMP     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.fragment.DeviceHSensorsFragment$setupGraphTabs$2.WhenMappings.<clinit>():void");
        }
    }

    public void onTabReselected(TabLayout.Tab tab) {
    }

    DeviceHSensorsFragment$setupGraphTabs$2(DeviceHSensorsFragment deviceHSensorsFragment) {
        this.this$0 = deviceHSensorsFragment;
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        if (tab != null) {
            this.this$0.updateTabItem(tab, false);
        }
    }

    public void onTabSelected(TabLayout.Tab tab) {
        GraphViewH.DataType dataType;
        if (tab != null) {
            this.this$0.updateTabItem(tab, true);
            Object tag = tab.getTag();
            GraphViewH graphViewH = null;
            SensorType sensorType = tag instanceof SensorType ? (SensorType) tag : null;
            if (sensorType != null) {
                DeviceHSensorsFragment deviceHSensorsFragment = this.this$0;
                switch (WhenMappings.$EnumSwitchMapping$0[sensorType.ordinal()]) {
                    case 1:
                        HasSensorData access$getDevice$p = deviceHSensorsFragment.device;
                        if (access$getDevice$p == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p = null;
                        }
                        dataType = new GraphViewH.DataType.AQI(access$getDevice$p, SensorType.PM1);
                        break;
                    case 2:
                        HasSensorData access$getDevice$p2 = deviceHSensorsFragment.device;
                        if (access$getDevice$p2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p2 = null;
                        }
                        dataType = new GraphViewH.DataType.AQI(access$getDevice$p2, SensorType.PM25);
                        break;
                    case 3:
                        HasSensorData access$getDevice$p3 = deviceHSensorsFragment.device;
                        if (access$getDevice$p3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p3 = null;
                        }
                        dataType = new GraphViewH.DataType.AQI(access$getDevice$p3, SensorType.PM10);
                        break;
                    case 4:
                        HasSensorData access$getDevice$p4 = deviceHSensorsFragment.device;
                        if (access$getDevice$p4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p4 = null;
                        }
                        dataType = new GraphViewH.DataType.AQI(access$getDevice$p4, SensorType.VOC);
                        break;
                    case 5:
                        HasSensorData access$getDevice$p5 = deviceHSensorsFragment.device;
                        if (access$getDevice$p5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p5 = null;
                        }
                        dataType = new GraphViewH.DataType.HUM(access$getDevice$p5);
                        break;
                    case 6:
                        HasSensorData access$getDevice$p6 = deviceHSensorsFragment.device;
                        if (access$getDevice$p6 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p6 = null;
                        }
                        HasSensorData access$getDevice$p7 = deviceHSensorsFragment.device;
                        if (access$getDevice$p7 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("device");
                            access$getDevice$p7 = null;
                        }
                        dataType = new GraphViewH.DataType.TMP(access$getDevice$p6, DeviceKt.isCelsiusUnit(access$getDevice$p7));
                        break;
                    default:
                        return;
                }
                GraphViewH access$getGraph$p = deviceHSensorsFragment.graph;
                if (access$getGraph$p == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("graph");
                } else {
                    graphViewH = access$getGraph$p;
                }
                if (!Intrinsics.areEqual((Object) dataType, (Object) graphViewH.getDataType())) {
                    deviceHSensorsFragment.setGraphDataType(dataType);
                }
            }
        }
    }
}
