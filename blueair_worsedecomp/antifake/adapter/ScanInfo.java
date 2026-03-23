package com.blueair.antifake.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.antifake.databinding.ScanInfoBinding;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/antifake/adapter/ScanInfo;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scanResultList", "Landroidx/recyclerview/widget/RecyclerView;", "verificationList", "antifake_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ScanTypeAdapter.kt */
public final class ScanInfo extends LinearLayout {
    private final RecyclerView scanResultList;
    private final RecyclerView verificationList;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ScanInfo(Context context) {
        this(context, (AttributeSet) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScanInfo(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        ScanInfoBinding inflate = ScanInfoBinding.inflate(LayoutInflater.from(context), this, true);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        RecyclerView recyclerView = inflate.verificationList;
        Intrinsics.checkNotNullExpressionValue(recyclerView, "verificationList");
        this.verificationList = recyclerView;
        recyclerView.setAdapter(new ScanTypeAdapter(CollectionsKt.listOf(ScanInfoType.FILTER), ScanType.Verification));
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 1, false));
        RecyclerView recyclerView2 = inflate.scanResultList;
        Intrinsics.checkNotNullExpressionValue(recyclerView2, "scanResultList");
        this.scanResultList = recyclerView2;
        recyclerView2.setAdapter(new ScanTypeAdapter(CollectionsKt.listOf(ScanInfoType.CORRECT, ScanInfoType.REPEAT, ScanInfoType.INVALID, ScanInfoType.UNRECOG), ScanType.Result));
        recyclerView2.setLayoutManager(new LinearLayoutManager(context, 1, false));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ScanInfo(Context context, AttributeSet attributeSet, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : attributeSet);
    }
}
