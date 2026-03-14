package com.blueair.devicedetails.viewholder;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.core.util.TimezoneUtils;
import com.blueair.devicedetails.databinding.HolderTimezoneBinding;
import com.blueair.viewcore.R;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/blueair/devicedetails/databinding/HolderTimezoneBinding;", "<init>", "(Lcom/blueair/devicedetails/databinding/HolderTimezoneBinding;)V", "getBinding", "()Lcom/blueair/devicedetails/databinding/HolderTimezoneBinding;", "bind", "", "timezone", "Ljava/util/TimeZone;", "isSelected", "", "Companion", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeviceTimezoneHolder extends RecyclerView.ViewHolder {
   public static final Companion Companion = new Companion((DefaultConstructorMarker)null);
   private final HolderTimezoneBinding binding;

   public DeviceTimezoneHolder(HolderTimezoneBinding var1) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      super((View)var1.getRoot());
      this.binding = var1;
   }

   public final void bind(TimeZone var1, boolean var2) {
      Intrinsics.checkNotNullParameter(var1, "timezone");
      TextView var5 = this.binding.displayName;
      TimezoneUtils var4 = TimezoneUtils.INSTANCE;
      Context var6 = this.itemView.getContext();
      Intrinsics.checkNotNullExpressionValue(var6, "getContext(...)");
      var5.setText((CharSequence)var4.getDisplayName(var6, var1));
      this.binding.timezone.setText((CharSequence)var1.getID());
      View var7 = this.itemView;
      int var3;
      if (var2) {
         var3 = this.itemView.getContext().getColor(R.color.platinum);
      } else {
         var3 = 0;
      }

      var7.setBackgroundTintList(ColorStateList.valueOf(var3));
   }

   public final HolderTimezoneBinding getBinding() {
      return this.binding;
   }

   @Metadata(
      d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"},
      d2 = {"Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder$Companion;", "", "<init>", "()V", "newInstance", "Lcom/blueair/devicedetails/viewholder/DeviceTimezoneHolder;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
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

      public final DeviceTimezoneHolder newInstance(ViewGroup var1) {
         Intrinsics.checkNotNullParameter(var1, "parent");
         HolderTimezoneBinding var2 = HolderTimezoneBinding.inflate(LayoutInflater.from(var1.getContext()), var1, false);
         Intrinsics.checkNotNullExpressionValue(var2, "inflate(...)");
         return new DeviceTimezoneHolder(var2);
      }
   }
}
