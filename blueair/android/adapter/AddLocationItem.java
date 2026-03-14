package com.blueair.android.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.blueair.android.R;
import com.blueair.android.databinding.HolderAddLocationBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000e"},
   d2 = {"Lcom/blueair/android/adapter/AddLocationItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/android/databinding/HolderAddLocationBinding;", "<init>", "()V", "type", "", "getType", "()I", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class AddLocationItem extends AbstractBindingItem {
   public static final int $stable;
   public static final AddLocationItem INSTANCE = new AddLocationItem();
   private static final int type;

   static {
      type = R.layout.holder_add_location;
      $stable = 8;
   }

   private AddLocationItem() {
   }

   public HolderAddLocationBinding createBinding(LayoutInflater var1, ViewGroup var2) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      HolderAddLocationBinding var3 = HolderAddLocationBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return var3;
   }

   public int getType() {
      return type;
   }
}
