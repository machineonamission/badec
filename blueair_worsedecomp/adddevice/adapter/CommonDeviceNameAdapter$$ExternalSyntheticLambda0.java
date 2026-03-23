package com.blueair.adddevice.adapter;

import android.view.View;
import com.blueair.adddevice.viewholder.CommonDeviceNameHolder;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommonDeviceNameAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ CommonDeviceNameAdapter f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ CommonDeviceNameHolder f$2;

    public /* synthetic */ CommonDeviceNameAdapter$$ExternalSyntheticLambda0(CommonDeviceNameAdapter commonDeviceNameAdapter, String str, CommonDeviceNameHolder commonDeviceNameHolder) {
        this.f$0 = commonDeviceNameAdapter;
        this.f$1 = str;
        this.f$2 = commonDeviceNameHolder;
    }

    public final void onClick(View view) {
        CommonDeviceNameAdapter.onBindViewHolder$lambda$0(this.f$0, this.f$1, this.f$2, view);
    }
}
