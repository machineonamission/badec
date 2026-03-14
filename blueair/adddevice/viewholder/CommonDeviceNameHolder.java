package com.blueair.adddevice.viewholder;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.adddevice.databinding.HolderCommonDeviceNameBinding;
import com.blueair.viewcore.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"},
   d2 = {"Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/adddevice/databinding/HolderCommonDeviceNameBinding;", "<init>", "(Lcom/blueair/adddevice/databinding/HolderCommonDeviceNameBinding;)V", "getBinding", "()Lcom/blueair/adddevice/databinding/HolderCommonDeviceNameBinding;", "radioButton", "Landroid/widget/RadioButton;", "getRadioButton", "()Landroid/widget/RadioButton;", "update", "", "name", "", "isSelected", "", "selectionUpdate", "Companion", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class CommonDeviceNameHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderCommonDeviceNameBinding binding;
   private final RadioButton radioButton;

   public CommonDeviceNameHolder(HolderCommonDeviceNameBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.root);
      this.binding = var1;
      RadioButton var2 = var1.root;
      Intrinsics.checkNotNullExpressionValue(var2, "root");
      this.radioButton = var2;
   }

   public final HolderCommonDeviceNameBinding getBinding() {
      return this.binding;
   }

   public final RadioButton getRadioButton() {
      return this.radioButton;
   }

   public final void selectionUpdate(boolean var1) {
      this.radioButton.setChecked(var1);
      RadioButton var4 = this.radioButton;
      Context var3 = this.itemView.getContext();
      int var2;
      if (var1) {
         var2 = R.font.apercu_bold;
      } else {
         var2 = R.font.apercu_light;
      }

      var4.setTypeface(ResourcesCompat.getFont(var3, var2));
   }

   public final void update(String var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "name");
      this.radioButton.setText((CharSequence)var1);
      this.selectionUpdate(var2);
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/adddevice/viewholder/CommonDeviceNameHolder;", "parentView", "Landroid/view/ViewGroup;", "adddevice_otherRelease"},
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

      public final CommonDeviceNameHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parentView");
         HolderCommonDeviceNameBinding var2 = HolderCommonDeviceNameBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new CommonDeviceNameHolder(var2);
      }
   }
}
