package com.blueair.devicedetails.fragment;

import com.blueair.core.model.SensorType;
import com.blueair.devicedetails.viewmodel.DeviceSensorsViewModel;
import com.google.android.material.tabs.TabLayout;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/blueair/devicedetails/fragment/DeviceSensorsFragment$initUi$2", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabUnselected", "onTabSelected", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceSensorsFragment.kt */
public final class DeviceSensorsFragment$initUi$2 implements TabLayout.OnTabSelectedListener {
    final /* synthetic */ DeviceSensorsFragment this$0;

    public void onTabReselected(TabLayout.Tab tab) {
    }

    DeviceSensorsFragment$initUi$2(DeviceSensorsFragment deviceSensorsFragment) {
        this.this$0 = deviceSensorsFragment;
    }

    public void onTabUnselected(TabLayout.Tab tab) {
        if (tab != null) {
            this.this$0.updateSelectedTab(tab, false);
        }
    }

    public void onTabSelected(TabLayout.Tab tab) {
        if (tab != null) {
            this.this$0.tabSelected = true;
            this.this$0.updateSelectedTab(tab, true);
            SensorType sensorAtPos = this.this$0.getViewModel().getSensorAtPos(tab.getPosition());
            if (sensorAtPos != null) {
                DeviceSensorsViewModel.selectSensor$default(this.this$0.getViewModel(), sensorAtPos, false, 2, (Object) null);
            }
        }
    }
}
