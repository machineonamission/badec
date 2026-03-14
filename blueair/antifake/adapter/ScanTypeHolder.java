package com.blueair.antifake.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.antifake.databinding.HolderScanResultBinding;
import com.blueair.antifake.databinding.HolderVerificationBinding;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0012"},
   d2 = {"Lcom/blueair/antifake/adapter/ScanTypeHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Landroidx/viewbinding/ViewBinding;", "<init>", "(Landroidx/viewbinding/ViewBinding;)V", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "title", "Landroid/widget/TextView;", "info", "image", "Landroidx/appcompat/widget/AppCompatImageView;", "update", "", "result", "Lcom/blueair/antifake/adapter/ScanInfoType;", "Companion", "antifake_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class ScanTypeHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final ViewBinding binding;
   private AppCompatImageView image;
   private TextView info;
   private TextView title;

   public ScanTypeHolder(ViewBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super(var1.getRoot());
      this.binding = var1;
      if (var1 instanceof HolderVerificationBinding) {
         TextView var6 = ((HolderVerificationBinding)var1).verificationTitle;
         Intrinsics.checkNotNullExpressionValue(var6, "verificationTitle");
         this.title = var6;
         var6 = ((HolderVerificationBinding)var1).verificationInfo;
         Intrinsics.checkNotNullExpressionValue(var6, "verificationInfo");
         this.info = var6;
         AppCompatImageView var4 = ((HolderVerificationBinding)var1).verificationImage;
         Intrinsics.checkNotNullExpressionValue(var4, "verificationImage");
         this.image = var4;
      } else {
         if (var1 instanceof HolderScanResultBinding) {
            TextView var2 = ((HolderScanResultBinding)var1).resultTitle;
            Intrinsics.checkNotNullExpressionValue(var2, "resultTitle");
            this.title = var2;
            var2 = ((HolderScanResultBinding)var1).resultInfo;
            Intrinsics.checkNotNullExpressionValue(var2, "resultInfo");
            this.info = var2;
            AppCompatImageView var3 = ((HolderScanResultBinding)var1).iconResult;
            Intrinsics.checkNotNullExpressionValue(var3, "iconResult");
            this.image = var3;
         }

      }
   }

   public final ViewBinding getBinding() {
      return this.binding;
   }

   public final void update(ScanInfoType var1) {
      Intrinsics.checkNotNullParameter(var1, "result");
      TextView var4 = this.title;
      Object var3 = null;
      TextView var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("title");
         var2 = null;
      }

      var2.setText(this.itemView.getContext().getText(var1.getTitle()));
      var4 = this.info;
      var2 = var4;
      if (var4 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("info");
         var2 = null;
      }

      var2.setText(this.itemView.getContext().getText(var1.getInfo()));
      AppCompatImageView var6 = this.image;
      if (var6 == null) {
         Intrinsics.throwUninitializedPropertyAccessException("image");
         var6 = (AppCompatImageView)var3;
      }

      var6.setImageResource(var1.getImage());
   }

   @Metadata(
      d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"},
      d2 = {"Lcom/blueair/antifake/adapter/ScanTypeHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/antifake/adapter/ScanTypeHolder;", "parentView", "Landroid/view/ViewGroup;", "scanType", "Lcom/blueair/antifake/adapter/ScanType;", "antifake_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class Companion {
      private Companion() {
      }

      // $FF: synthetic method
      public Companion(DefaultConstructorMarker var1) {
         this();
      }

      public final ScanTypeHolder newInstance(ViewGroup var1, ScanType var2) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         Intrinsics.checkNotNullParameter(var2, "scanType");
         int var3 = ScanTypeHolder.Companion.WhenMappings.$EnumSwitchMapping$0[var2.ordinal()];
         ViewBinding var5;
         if (var3 != 1) {
            if (var3 != 2) {
               throw new NoWhenBranchMatchedException();
            }

            HolderScanResultBinding var4 = HolderScanResultBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var4, "inflate(...)");
            var5 = var4;
         } else {
            HolderVerificationBinding var6 = HolderVerificationBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
            Intrinsics.checkNotNullExpressionValue(var6, "inflate(...)");
            var5 = var6;
         }

         return new ScanTypeHolder(var5);
      }

      // $FF: synthetic class
      @Metadata(
         k = 3,
         mv = {2, 2, 0},
         xi = 48
      )
      public static final class WhenMappings {
         public static final int[] $EnumSwitchMapping$0;

         static {
            int[] var0 = new int[ScanType.values().length];

            try {
               var0[ScanType.Verification.ordinal()] = 1;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[ScanType.Result.ordinal()] = 2;
            } catch (NoSuchFieldError var2) {
            }

            $EnumSwitchMapping$0 = var0;
         }
      }
   }
}
