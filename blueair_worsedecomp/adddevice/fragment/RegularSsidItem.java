package com.blueair.adddevice.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.HolderSsidRegularBinding;
import com.blueair.core.model.Ssid;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0003R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/blueair/adddevice/fragment/RegularSsidItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/adddevice/databinding/HolderSsidRegularBinding;", "ssid", "Lcom/blueair/core/model/Ssid;", "<init>", "(Lcom/blueair/core/model/Ssid;)V", "getSsid", "()Lcom/blueair/core/model/Ssid;", "type", "", "getType", "()I", "bindView", "", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getWiFiImage", "rssi", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: RegularSsidItem.kt */
public final class RegularSsidItem extends AbstractBindingItem<HolderSsidRegularBinding> {
    private final Ssid ssid;
    private final int type = R.id.ssid_regular_item_type;

    public final Ssid getSsid() {
        return this.ssid;
    }

    public RegularSsidItem(Ssid ssid2) {
        Intrinsics.checkNotNullParameter(ssid2, "ssid");
        this.ssid = ssid2;
    }

    public int getType() {
        return this.type;
    }

    public void bindView(HolderSsidRegularBinding holderSsidRegularBinding, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(holderSsidRegularBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        holderSsidRegularBinding.ssidName.setText(this.ssid.getSsid());
        holderSsidRegularBinding.ssidName.setCompoundDrawablesRelativeWithIntrinsicBounds(getWiFiImage(this.ssid.getRssi()), 0, 0, 0);
    }

    public HolderSsidRegularBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderSsidRegularBinding inflate = HolderSsidRegularBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    private final int getWiFiImage(int i) {
        if (i < -100 || i > 0) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if ((-100 <= i && i < -88) || (-88 <= i && i < -77)) {
            return com.blueair.viewcore.R.drawable.ic_wifi_2;
        } else {
            if ((-77 > i || i >= -66) && (-66 > i || i >= -54)) {
                return com.blueair.viewcore.R.drawable.ic_wifi_4;
            }
            return com.blueair.viewcore.R.drawable.ic_wifi_3;
        }
    }
}
