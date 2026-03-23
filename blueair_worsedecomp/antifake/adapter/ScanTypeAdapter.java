package com.blueair.antifake.adapter;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/antifake/adapter/ScanTypeAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/blueair/antifake/adapter/ScanTypeHolder;", "typeList", "", "Lcom/blueair/antifake/adapter/ScanInfoType;", "scanType", "Lcom/blueair/antifake/adapter/ScanType;", "<init>", "(Ljava/util/List;Lcom/blueair/antifake/adapter/ScanType;)V", "getItemCount", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "onBindViewHolder", "", "holder", "position", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScanTypeAdapter.kt */
public final class ScanTypeAdapter extends RecyclerView.Adapter<ScanTypeHolder> {
    private final ScanType scanType;
    private final List<ScanInfoType> typeList;

    public ScanTypeAdapter(List<? extends ScanInfoType> list, ScanType scanType2) {
        Intrinsics.checkNotNullParameter(list, "typeList");
        Intrinsics.checkNotNullParameter(scanType2, "scanType");
        this.typeList = list;
        this.scanType = scanType2;
    }

    public int getItemCount() {
        return this.typeList.size();
    }

    public ScanTypeHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return ScanTypeHolder.Companion.newInstance(viewGroup, this.scanType);
    }

    public void onBindViewHolder(ScanTypeHolder scanTypeHolder, int i) {
        Intrinsics.checkNotNullParameter(scanTypeHolder, "holder");
        scanTypeHolder.update(this.typeList.get(i));
    }
}
