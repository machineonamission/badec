package com.blueair.android.activity;

import android.view.View;
import android.widget.AdapterView;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.core.model.Device;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0016\u0010\f\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0016¨\u0006\r"}, d2 = {"com/blueair/android/activity/DevSettingsActivity$bindViewModel$3$1$1", "Landroid/widget/AdapterView$OnItemSelectedListener;", "onItemSelected", "", "parent", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "id", "", "onNothingSelected", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DevSettingsActivity.kt */
public final class DevSettingsActivity$bindViewModel$3$1$1 implements AdapterView.OnItemSelectedListener {
    final /* synthetic */ List<Device> $devices;
    final /* synthetic */ DevSettingsActivity this$0;

    DevSettingsActivity$bindViewModel$3$1$1(DevSettingsActivity devSettingsActivity, List<? extends Device> list) {
        this.this$0 = devSettingsActivity;
        this.$devices = list;
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        DevSettingsViewModel access$getViewModel = this.this$0.getViewModel();
        List<Device> list = this.$devices;
        Intrinsics.checkNotNull(list);
        access$getViewModel.setWelcomeHomeTestDevice((Device) CollectionsKt.getOrNull(list, i));
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
        this.this$0.getViewModel().setWelcomeHomeTestDevice((Device) null);
    }
}
