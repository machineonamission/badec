package com.blueair.viewcore.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\u0004\u0010\bB!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB)\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"},
   d2 = {"Lcom/blueair/viewcore/view/QualityStatusView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "qualityTitle", "Landroid/widget/TextView;", "qualityValue", "qualityImage", "Landroid/widget/ImageView;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class QualityStatusView extends ConstraintLayout {
   private final ImageView qualityImage;
   private final TextView qualityTitle;
   private final TextView qualityValue;

   public QualityStatusView(Context var1) {
      Intrinsics.checkNotNullParameter(var1, "context");
      super(var1);
      View var3 = ConstraintLayout.inflate(this.getContext(), R.layout.quality_status_view, (ViewGroup)this);
      View var2 = var3.findViewById(R.id.quality_title);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.qualityTitle = (TextView)var2;
      var2 = var3.findViewById(R.id.quality_value);
      Intrinsics.checkNotNullExpressionValue(var2, "findViewById(...)");
      this.qualityValue = (TextView)var2;
      var3 = var3.findViewById(R.id.quality_status_image);
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.qualityImage = (ImageView)var3;
   }

   public QualityStatusView(Context var1, AttributeSet var2) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2);
      View var3 = ConstraintLayout.inflate(this.getContext(), R.layout.quality_status_view, (ViewGroup)this);
      View var5 = var3.findViewById(R.id.quality_title);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.qualityTitle = (TextView)var5;
      var5 = var3.findViewById(R.id.quality_value);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.qualityValue = (TextView)var5;
      var3 = var3.findViewById(R.id.quality_status_image);
      Intrinsics.checkNotNullExpressionValue(var3, "findViewById(...)");
      this.qualityImage = (ImageView)var3;
   }

   public QualityStatusView(Context var1, AttributeSet var2, int var3) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3);
      View var4 = ConstraintLayout.inflate(this.getContext(), R.layout.quality_status_view, (ViewGroup)this);
      View var6 = var4.findViewById(R.id.quality_title);
      Intrinsics.checkNotNullExpressionValue(var6, "findViewById(...)");
      this.qualityTitle = (TextView)var6;
      var6 = var4.findViewById(R.id.quality_value);
      Intrinsics.checkNotNullExpressionValue(var6, "findViewById(...)");
      this.qualityValue = (TextView)var6;
      var4 = var4.findViewById(R.id.quality_status_image);
      Intrinsics.checkNotNullExpressionValue(var4, "findViewById(...)");
      this.qualityImage = (ImageView)var4;
   }

   public QualityStatusView(Context var1, AttributeSet var2, int var3, int var4) {
      Intrinsics.checkNotNullParameter(var1, "context");
      Intrinsics.checkNotNullParameter(var2, "attrs");
      super(var1, var2, var3, var4);
      View var5 = ConstraintLayout.inflate(this.getContext(), R.layout.quality_status_view, (ViewGroup)this);
      View var7 = var5.findViewById(R.id.quality_title);
      Intrinsics.checkNotNullExpressionValue(var7, "findViewById(...)");
      this.qualityTitle = (TextView)var7;
      var7 = var5.findViewById(R.id.quality_value);
      Intrinsics.checkNotNullExpressionValue(var7, "findViewById(...)");
      this.qualityValue = (TextView)var7;
      var5 = var5.findViewById(R.id.quality_status_image);
      Intrinsics.checkNotNullExpressionValue(var5, "findViewById(...)");
      this.qualityImage = (ImageView)var5;
   }
}
