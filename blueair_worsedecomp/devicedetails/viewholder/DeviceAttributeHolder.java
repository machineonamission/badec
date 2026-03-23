package com.blueair.devicedetails.viewholder;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.model.Device;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\n"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceAttributeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "<init>", "(Landroid/view/View;)V", "update", "", "device", "Lcom/blueair/core/model/Device;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceAttributeHolder.kt */
public abstract class DeviceAttributeHolder extends RecyclerView.ViewHolder {
    public abstract void update(Device device);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeviceAttributeHolder(View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }
}
