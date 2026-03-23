package com.blueair.adddevice.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.HolderSsidHiddenBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/blueair/adddevice/fragment/HiddenSsidItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/adddevice/databinding/HolderSsidHiddenBinding;", "<init>", "()V", "type", "", "getType", "()I", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "adddevice_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: HiddenSsidItem.kt */
public final class HiddenSsidItem extends AbstractBindingItem<HolderSsidHiddenBinding> {
    public static final HiddenSsidItem INSTANCE = new HiddenSsidItem();
    private static final int type = R.id.ssid_hidden_item_type;

    private HiddenSsidItem() {
    }

    public int getType() {
        return type;
    }

    public HolderSsidHiddenBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderSsidHiddenBinding inflate = HolderSsidHiddenBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
