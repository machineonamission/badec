package com.blueair.antifake.adapter;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.antifake.databinding.ScanInfoBinding;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"},
   d2 = {"Lcom/blueair/antifake/adapter/ScanInfo;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "scanResultList", "Landroidx/recyclerview/widget/RecyclerView;", "verificationList", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScanInfo extends LinearLayout {
   private final RecyclerView scanResultList;
   private final RecyclerView verificationList;

   public ScanInfo(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 2, (DefaultConstructorMarker)null);
   }

   public ScanInfo(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2);
      ScanInfoBinding var4 = ScanInfoBinding.inflate(LayoutInflater.from(var1), (ViewGroup)this, true);
      Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
      RecyclerView var3 = var4.verificationList;
      Intrinsics.checkNotNullExpressionValue(var3, "verificationList");
      this.verificationList = var3;
      var3.setAdapter(new ScanTypeAdapter(CollectionsKt.listOf(ScanInfoType.FILTER), ScanType.Verification));
      var3.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var1, 1, false)));
      RecyclerView var5 = var4.scanResultList;
      Intrinsics.checkNotNullExpressionValue(var5, "scanResultList");
      this.scanResultList = var5;
      var5.setAdapter(new ScanTypeAdapter(CollectionsKt.listOf(new ScanInfoType[]{ScanInfoType.CORRECT, ScanInfoType.REPEAT, ScanInfoType.INVALID, ScanInfoType.UNRECOG}), ScanType.Result));
      var5.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var1, 1, false)));
   }

   // $FF: synthetic method
   public ScanInfo(Context var1, AttributeSet var2, int var3, DefaultConstructorMarker var4) {
      if ((var3 & 2) != 0) {
         var2 = null;
      }

      this(var1, var2);
   }
}
