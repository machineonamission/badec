package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.devicedetails.databinding.HolderNameForDeleteBinding;
import com.blueair.viewcore.R;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011XD¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/blueair/devicedetails/viewholder/DeletableItem;", "T", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/devicedetails/databinding/HolderNameForDeleteBinding;", "name", "", "data", "needPrefix", "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "getName", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "type", "", "getType", "()I", "bindView", "", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DeletableItem.kt */
public final class DeletableItem<T> extends AbstractBindingItem<HolderNameForDeleteBinding> {
    private final T data;
    private final String name;
    private final boolean needPrefix;
    private final int type;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeletableItem(String str, Object obj, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, obj, (i & 4) != 0 ? false : z);
    }

    public final String getName() {
        return this.name;
    }

    public final T getData() {
        return this.data;
    }

    public DeletableItem(String str, T t, boolean z) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.data = t;
        this.needPrefix = z;
    }

    public int getType() {
        return this.type;
    }

    public void bindView(HolderNameForDeleteBinding holderNameForDeleteBinding, List<? extends Object> list) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(holderNameForDeleteBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        AppCompatTextView root = holderNameForDeleteBinding.getRoot();
        if (this.needPrefix) {
            charSequence = holderNameForDeleteBinding.getRoot().getContext().getString(R.string.delete_product_title, new Object[]{this.name});
        } else {
            charSequence = this.name;
        }
        root.setText(charSequence);
    }

    public HolderNameForDeleteBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderNameForDeleteBinding inflate = HolderNameForDeleteBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
