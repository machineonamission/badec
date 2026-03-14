package com.blueair.adddevice.fragment;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.adddevice.R;
import com.blueair.adddevice.databinding.HolderSsidRegularBinding;
import com.blueair.core.model.Ssid;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u001e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\nH\u0003R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\t\u001a\u00020\nX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u001a"},
   d2 = {"Lcom/blueair/adddevice/fragment/RegularSsidItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/adddevice/databinding/HolderSsidRegularBinding;", "ssid", "Lcom/blueair/core/model/Ssid;", "<init>", "(Lcom/blueair/core/model/Ssid;)V", "getSsid", "()Lcom/blueair/core/model/Ssid;", "type", "", "getType", "()I", "bindView", "", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "getWiFiImage", "rssi", "adddevice_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class RegularSsidItem extends AbstractBindingItem {
   private final Ssid ssid;
   private final int type;

   public RegularSsidItem(Ssid var1) {
      Intrinsics.checkNotNullParameter(var1, "ssid");
      super();
      this.ssid = var1;
      this.type = R.id.ssid_regular_item_type;
   }

   private final int getWiFiImage(int var1) {
      if (var1 >= -100 && var1 <= 0) {
         if ((-100 > var1 || var1 >= -88) && (-88 > var1 || var1 >= -77)) {
            return (-77 > var1 || var1 >= -66) && (-66 > var1 || var1 >= -54) ? com.blueair.viewcore.R.drawable.ic_wifi_4 : com.blueair.viewcore.R.drawable.ic_wifi_3;
         } else {
            return com.blueair.viewcore.R.drawable.ic_wifi_2;
         }
      } else {
         throw new IllegalArgumentException("Failed requirement.".toString());
      }
   }

   public void bindView(HolderSsidRegularBinding var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "payloads");
      var1.ssidName.setText((CharSequence)this.ssid.getSsid());
      var1.ssidName.setCompoundDrawablesRelativeWithIntrinsicBounds(this.getWiFiImage(this.ssid.getRssi()), 0, 0, 0);
   }

   public HolderSsidRegularBinding createBinding(LayoutInflater var1, ViewGroup var2) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      HolderSsidRegularBinding var3 = HolderSsidRegularBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return var3;
   }

   public final Ssid getSsid() {
      return this.ssid;
   }

   public int getType() {
      return this.type;
   }
}
