package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.devicedetails.databinding.HolderDeviceSettingInfoErrorReportBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001b\u0012\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00022\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceInfoItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/devicedetails/databinding/HolderDeviceSettingInfoErrorReportBinding;", "info", "Lkotlin/Pair;", "", "<init>", "(Lkotlin/Pair;)V", "getInfo", "()Lkotlin/Pair;", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "type", "", "getType", "()I", "bindView", "", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeviceInfoItem.kt */
public final class DeviceInfoItem extends AbstractBindingItem<HolderDeviceSettingInfoErrorReportBinding> {
    private long identifier;
    private final Pair<String, String> info;
    private final int type;

    public final Pair<String, String> getInfo() {
        return this.info;
    }

    public DeviceInfoItem(Pair<String, String> pair) {
        Intrinsics.checkNotNullParameter(pair, "info");
        this.info = pair;
    }

    public long getIdentifier() {
        return this.identifier;
    }

    public void setIdentifier(long j) {
        this.identifier = j;
    }

    public int getType() {
        return this.type;
    }

    public void bindView(HolderDeviceSettingInfoErrorReportBinding holderDeviceSettingInfoErrorReportBinding, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(holderDeviceSettingInfoErrorReportBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        holderDeviceSettingInfoErrorReportBinding.infoTitle.setText(this.info.getFirst());
        holderDeviceSettingInfoErrorReportBinding.infoView.setText(this.info.getSecond());
    }

    public HolderDeviceSettingInfoErrorReportBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderDeviceSettingInfoErrorReportBinding inflate = HolderDeviceSettingInfoErrorReportBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
