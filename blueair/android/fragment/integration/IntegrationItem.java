package com.blueair.android.fragment.integration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import com.blueair.android.R;
import com.blueair.android.databinding.IntegrationItemBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(
   d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B+\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\u0004\b\n\u0010\u000bJ\u001e\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00022\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fH\u0016J\u001a\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0019X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006&"},
   d2 = {"Lcom/blueair/android/fragment/integration/IntegrationItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/android/databinding/IntegrationItemBinding;", "integration", "Lcom/blueair/android/fragment/integration/Integration;", "linked", "", "onLinkClick", "Lkotlin/Function1;", "", "<init>", "(Lcom/blueair/android/fragment/integration/Integration;ZLkotlin/jvm/functions/Function1;)V", "getIntegration", "()Lcom/blueair/android/fragment/integration/Integration;", "getLinked", "()Z", "getOnLinkClick", "()Lkotlin/jvm/functions/Function1;", "identifier", "", "getIdentifier", "()J", "setIdentifier", "(J)V", "type", "", "getType", "()I", "bindView", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "app_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class IntegrationItem extends AbstractBindingItem {
   public static final int $stable = 8;
   private long identifier;
   private final Integration integration;
   private final boolean linked;
   private final Function1 onLinkClick;
   private final int type;

   // $FF: synthetic method
   public static void $r8$lambda$I6TTu182XoVQ16QesB2wOASk5_o/* $FF was: $r8$lambda$I6TTu182XoVQ16QesB2wOASk5-o*/(IntegrationItem var0, View var1) {
      bindView$lambda$0(var0, var1);
   }

   public IntegrationItem(Integration var1, boolean var2, Function1 var3) {
      Intrinsics.checkNotNullParameter(var1, "integration");
      Intrinsics.checkNotNullParameter(var3, "onLinkClick");
      super();
      this.integration = var1;
      this.linked = var2;
      this.onLinkClick = var3;
      this.identifier = (long)var1.ordinal();
      this.type = R.id.integration_item_type;
   }

   private static final void bindView$lambda$0(IntegrationItem var0, View var1) {
      var0.onLinkClick.invoke(var0);
   }

   public void bindView(IntegrationItemBinding var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "payloads");
      var1.title.setText(this.integration.getTitle());
      var1.summary.setText(this.integration.getSummary());
      int var3;
      if (this.linked) {
         var3 = com.blueair.viewcore.R.string.unlink;
      } else {
         var3 = com.blueair.viewcore.R.string.link;
      }

      var1.btnLink.setText(var3);
      var1.btnLink.setOnClickListener(new IntegrationItem$$ExternalSyntheticLambda0(this));
   }

   public IntegrationItemBinding createBinding(LayoutInflater var1, ViewGroup var2) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      IntegrationItemBinding var3 = IntegrationItemBinding.inflate(var1, var2, false);
      var3.integrationItemRoot.setAccessibilityDelegate(new View.AccessibilityDelegate() {
         public void onInitializeAccessibilityNodeInfo(View var1, AccessibilityNodeInfo var2) {
            Intrinsics.checkNotNullParameter(var1, "host");
            Intrinsics.checkNotNullParameter(var2, "info");
            super.onInitializeAccessibilityNodeInfo(var1, var2);
            var2.setLongClickable(false);
            var2.removeAction(AccessibilityAction.ACTION_LONG_CLICK);
         }
      });
      Intrinsics.checkNotNullExpressionValue(var3, "apply(...)");
      return var3;
   }

   public long getIdentifier() {
      return this.identifier;
   }

   public final Integration getIntegration() {
      return this.integration;
   }

   public final boolean getLinked() {
      return this.linked;
   }

   public final Function1 getOnLinkClick() {
      return this.onLinkClick;
   }

   public int getType() {
      return this.type;
   }

   public void setIdentifier(long var1) {
      this.identifier = var1;
   }
}
