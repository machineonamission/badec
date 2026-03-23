package com.blueair.viewcore.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.viewholder.DropDownItemHolder;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\nH\u0016J\b\u0010\u0019\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\nH\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001d"}, d2 = {"Lcom/blueair/viewcore/adapter/DropDownListAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/viewcore/viewholder/DropDownItemHolder;", "headFirstItem", "", "items", "", "", "onItemSelectedListener", "Lkotlin/Function2;", "", "", "<init>", "(ZLjava/util/List;Lkotlin/jvm/functions/Function2;)V", "getHeadFirstItem", "()Z", "value", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "getItemCount", "onBindViewHolder", "holder", "position", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DropDownListAdapter.kt */
public final class DropDownListAdapter extends RecyclerView.Adapter<DropDownItemHolder> {
    private final boolean headFirstItem;
    private List<String> items;
    private final Function2<Integer, String, Unit> onItemSelectedListener;

    public DropDownListAdapter(boolean z, List<String> list, Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function2, "onItemSelectedListener");
        this.headFirstItem = z;
        this.onItemSelectedListener = function2;
        this.items = list;
    }

    public final boolean getHeadFirstItem() {
        return this.headFirstItem;
    }

    public final List<String> getItems() {
        return this.items;
    }

    public final void setItems(List<String> list) {
        Intrinsics.checkNotNullParameter(list, "value");
        if (!Intrinsics.areEqual((Object) this.items, (Object) list)) {
            this.items = list;
            notifyDataSetChanged();
        }
    }

    public DropDownItemHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return DropDownItemHolder.Companion.newInstance(viewGroup);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(DropDownItemHolder dropDownItemHolder, int i) {
        Intrinsics.checkNotNullParameter(dropDownItemHolder, "holder");
        TextView textView = dropDownItemHolder.getBinding().text;
        textView.setText(this.items.get(i));
        if (this.headFirstItem) {
            textView.setTextSize(2, i == 0 ? 16.0f : 14.0f);
        }
        textView.setOnClickListener(new DropDownListAdapter$$ExternalSyntheticLambda0(this, dropDownItemHolder, i));
    }

    /* access modifiers changed from: private */
    public static final void onBindViewHolder$lambda$1$lambda$0(DropDownListAdapter dropDownListAdapter, DropDownItemHolder dropDownItemHolder, int i, View view) {
        dropDownListAdapter.onItemSelectedListener.invoke(Integer.valueOf(dropDownItemHolder.getBindingAdapterPosition()), dropDownListAdapter.items.get(i));
    }
}
