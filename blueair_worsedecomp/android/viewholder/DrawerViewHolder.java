package com.blueair.android.viewholder;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.android.databinding.HolderDrawerItemBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/blueair/android/viewholder/DrawerViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/android/databinding/HolderDrawerItemBinding;", "<init>", "(Lcom/blueair/android/databinding/HolderDrawerItemBinding;)V", "getBinding", "()Lcom/blueair/android/databinding/HolderDrawerItemBinding;", "update", "", "menuItem", "Landroid/view/MenuItem;", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DrawerViewHolder.kt */
public final class DrawerViewHolder extends RecyclerView.ViewHolder {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderDrawerItemBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/viewholder/DrawerViewHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/android/viewholder/DrawerViewHolder;", "parentView", "Landroid/view/ViewGroup;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: DrawerViewHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DrawerViewHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderDrawerItemBinding inflate = HolderDrawerItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new DrawerViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DrawerViewHolder(HolderDrawerItemBinding holderDrawerItemBinding) {
        super(holderDrawerItemBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderDrawerItemBinding, "binding");
        this.binding = holderDrawerItemBinding;
    }

    public final HolderDrawerItemBinding getBinding() {
        return this.binding;
    }

    public final void update(MenuItem menuItem) {
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        this.binding.ivLeading.setImageDrawable(menuItem.getIcon());
        this.binding.tvName.setText(menuItem.getTitle());
    }
}
