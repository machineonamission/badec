package com.blueair.devicedetails.viewholder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import com.blueair.devicedetails.databinding.HolderNameForDeleteBinding;
import com.blueair.viewcore.R;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B!\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00032\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016J\u001a\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001f"},
   d2 = {"Lcom/blueair/devicedetails/viewholder/DeletableItem;", "T", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/devicedetails/databinding/HolderNameForDeleteBinding;", "name", "", "data", "needPrefix", "", "<init>", "(Ljava/lang/String;Ljava/lang/Object;Z)V", "getName", "()Ljava/lang/String;", "getData", "()Ljava/lang/Object;", "Ljava/lang/Object;", "type", "", "getType", "()I", "bindView", "", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "devicedetails_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class DeletableItem extends AbstractBindingItem {
   private final Object data;
   private final String name;
   private final boolean needPrefix;
   private final int type;

   public DeletableItem(String var1, Object var2, boolean var3) {
      Intrinsics.checkNotNullParameter(var1, "name");
      super();
      this.name = var1;
      this.data = var2;
      this.needPrefix = var3;
   }

   // $FF: synthetic method
   public DeletableItem(String var1, Object var2, boolean var3, int var4, DefaultConstructorMarker var5) {
      if ((var4 & 4) != 0) {
         var3 = false;
      }

      this(var1, var2, var3);
   }

   public void bindView(HolderNameForDeleteBinding var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "payloads");
      AppCompatTextView var4 = var1.getRoot();
      CharSequence var3;
      if (this.needPrefix) {
         var3 = (CharSequence)var1.getRoot().getContext().getString(R.string.delete_product_title, new Object[]{this.name});
      } else {
         var3 = (CharSequence)this.name;
      }

      var4.setText(var3);
   }

   public HolderNameForDeleteBinding createBinding(LayoutInflater var1, ViewGroup var2) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      HolderNameForDeleteBinding var3 = HolderNameForDeleteBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return var3;
   }

   public final Object getData() {
      return this.data;
   }

   public final String getName() {
      return this.name;
   }

   public int getType() {
      return this.type;
   }
}
