package com.blueair.viewcore.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.databinding.HolderEmptyStateBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/blueair/viewcore/viewholder/EmptyStateHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/viewcore/databinding/HolderEmptyStateBinding;", "<init>", "(Lcom/blueair/viewcore/databinding/HolderEmptyStateBinding;)V", "getBinding", "()Lcom/blueair/viewcore/databinding/HolderEmptyStateBinding;", "update", "", "message", "", "Companion", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: EmptyStateHolder.kt */
public final class EmptyStateHolder extends RecyclerView.ViewHolder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HolderEmptyStateBinding binding;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/viewcore/viewholder/EmptyStateHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/viewcore/viewholder/EmptyStateHolder;", "parentView", "Landroid/view/ViewGroup;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: EmptyStateHolder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final EmptyStateHolder newInstance(ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parentView");
            HolderEmptyStateBinding inflate = HolderEmptyStateBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
            return new EmptyStateHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EmptyStateHolder(HolderEmptyStateBinding holderEmptyStateBinding) {
        super(holderEmptyStateBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderEmptyStateBinding, "binding");
        this.binding = holderEmptyStateBinding;
    }

    public final HolderEmptyStateBinding getBinding() {
        return this.binding;
    }

    public final void update(String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        this.binding.emptyMsg.setText(str);
    }
}
