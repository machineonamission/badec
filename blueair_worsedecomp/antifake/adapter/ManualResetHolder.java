package com.blueair.antifake.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.blueair.antifake.databinding.HolderManualResetBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/antifake/adapter/ManualResetHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/antifake/databinding/HolderManualResetBinding;", "<init>", "(Lcom/blueair/antifake/databinding/HolderManualResetBinding;)V", "getBinding", "()Lcom/blueair/antifake/databinding/HolderManualResetBinding;", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ManualResetAdapter.kt */
public final class ManualResetHolder extends RecyclerView.ViewHolder {
    private final HolderManualResetBinding binding;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ManualResetHolder(HolderManualResetBinding holderManualResetBinding) {
        super(holderManualResetBinding.getRoot());
        Intrinsics.checkNotNullParameter(holderManualResetBinding, "binding");
        this.binding = holderManualResetBinding;
    }

    public final HolderManualResetBinding getBinding() {
        return this.binding;
    }
}
