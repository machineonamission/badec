package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.core.util.TypedValueCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;
import com.dd.ShadowLayout;
import com.google.android.material.divider.MaterialDividerItemDecoration;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

@Metadata(
   d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0002R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0016"},
   d2 = {"Lcom/blueair/viewcore/view/ShadowedRecyclerViewLayout;", "Lcom/dd/ShadowLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "backgroundLayout", "Landroid/widget/FrameLayout;", "getBackgroundLayout", "()Landroid/widget/FrameLayout;", "initViews", "", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ShadowedRecyclerViewLayout extends ShadowLayout {
   private final FrameLayout backgroundLayout;
   private final RecyclerView recyclerView;

   public ShadowedRecyclerViewLayout(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      this(var1, (AttributeSet)null, 0);
   }

   public ShadowedRecyclerViewLayout(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      this(var1, var2, 0);
   }

   public ShadowedRecyclerViewLayout(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1, var2, var3);
      this.recyclerView = new RecyclerView(this.getContext());
      this.backgroundLayout = new FrameLayout(this.getContext());
      this.initViews(var1, var2);
   }

   private final void initViews(Context var1, AttributeSet var2) {
      RecyclerView var6 = this.recyclerView;
      var6.setItemAnimator((RecyclerView.ItemAnimator)null);
      var6.setLayoutManager((RecyclerView.LayoutManager)(new LinearLayoutManager(var1)));
      var6.setOverScrollMode(2);
      var6.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
      var6.setClipToOutline(true);
      MaterialDividerItemDecoration var5 = new MaterialDividerItemDecoration(var1, 1);
      var5.setDividerColorResource(var1, R.color.surface_dark_10);
      var5.setLastItemDecorated(false);
      var6.addItemDecoration((RecyclerView.ItemDecoration)var5);
      if (var2 != null) {
         int[] var8 = R.styleable.ShadowedRecyclerViewLayout;
         Intrinsics.checkNotNullExpressionValue(var8, "ShadowedRecyclerViewLayout");
         TypedArray var7 = var1.obtainStyledAttributes(var2, var8, 0, 0);
         int var4 = var7.getResourceId(R.styleable.ShadowedRecyclerViewLayout_srvl_background, R.drawable.rounded_rectangle_white_r16_black5_stroke1);
         int var3 = var7.getDimensionPixelSize(R.styleable.ShadowedRecyclerViewLayout_srvl_background_padding, MathKt.roundToInt(TypedValueCompat.dpToPx(1.0F, var7.getResources().getDisplayMetrics())));
         this.backgroundLayout.setBackgroundResource(var4);
         this.backgroundLayout.setPadding(var3, var3, var3, var3);
         this.recyclerView.setBackgroundResource(var4);
         this.recyclerView.setBackgroundTintList(ColorStateList.valueOf(0));
         var7.recycle();
      }

      this.backgroundLayout.addView((View)this.recyclerView, (ViewGroup.LayoutParams)(new FrameLayout.LayoutParams(-1, -2)));
      this.addView((View)this.backgroundLayout, (ViewGroup.LayoutParams)(new FrameLayout.LayoutParams(-1, -2)));
   }

   public final FrameLayout getBackgroundLayout() {
      return this.backgroundLayout;
   }

   public final RecyclerView getRecyclerView() {
      return this.recyclerView;
   }
}
