package com.blueair.android.adapter;

import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import com.blueair.android.databinding.HolderSimpleInfoBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001a\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nXD¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/blueair/android/adapter/SimpleInfoItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/android/databinding/HolderSimpleInfoBinding;", "infoItem", "Lcom/blueair/android/adapter/InfoListItem;", "<init>", "(Lcom/blueair/android/adapter/InfoListItem;)V", "getInfoItem", "()Lcom/blueair/android/adapter/InfoListItem;", "type", "", "getType", "()I", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "bindView", "", "binding", "payloads", "", "", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleInfoItem.kt */
public final class SimpleInfoItem extends AbstractBindingItem<HolderSimpleInfoBinding> {
    public static final int $stable = 8;
    private final InfoListItem infoItem;
    private final int type;

    public SimpleInfoItem(InfoListItem infoListItem) {
        Intrinsics.checkNotNullParameter(infoListItem, "infoItem");
        this.infoItem = infoListItem;
    }

    public final InfoListItem getInfoItem() {
        return this.infoItem;
    }

    public int getType() {
        return this.type;
    }

    public HolderSimpleInfoBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderSimpleInfoBinding inflate = HolderSimpleInfoBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }

    public void bindView(HolderSimpleInfoBinding holderSimpleInfoBinding, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(holderSimpleInfoBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        TextView textView = holderSimpleInfoBinding.tvTitle;
        InfoListItem infoListItem = this.infoItem;
        Resources resources = holderSimpleInfoBinding.getRoot().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        textView.setText(infoListItem.obtainText(resources));
    }
}
