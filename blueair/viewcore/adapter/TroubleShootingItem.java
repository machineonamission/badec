package com.blueair.viewcore.adapter;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.text.HtmlCompat;
import com.blueair.core.model.SimpleResourceBundle;
import com.blueair.viewcore.databinding.HolderTroubleshootingStepBinding;
import com.blueair.viewcore.utils.NoUnderlineClickableSpan;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(
   d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00128\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R@\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"},
   d2 = {"Lcom/blueair/viewcore/adapter/TroubleShootingItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/viewcore/databinding/HolderTroubleshootingStepBinding;", "simpleResource", "Lcom/blueair/core/model/SimpleResourceBundle;", "onClickLink", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "linkStr", "linkToken", "", "<init>", "(Lcom/blueair/core/model/SimpleResourceBundle;Lkotlin/jvm/functions/Function2;)V", "type", "", "getType", "()I", "bindView", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public final class TroubleShootingItem extends AbstractBindingItem {
   private Function2 onClickLink;
   private final SimpleResourceBundle simpleResource;
   private final int type;

   public TroubleShootingItem(SimpleResourceBundle var1, Function2 var2) {
      Intrinsics.checkNotNullParameter(var1, "simpleResource");
      Intrinsics.checkNotNullParameter(var2, "onClickLink");
      super();
      this.simpleResource = var1;
      this.onClickLink = var2;
   }

   public void bindView(HolderTroubleshootingStepBinding var1, List var2) {
      Intrinsics.checkNotNullParameter(var1, "binding");
      Intrinsics.checkNotNullParameter(var2, "payloads");
      var1.ivIcon.setImageResource(this.simpleResource.getIconRes());
      var1.tvTitle.setText(this.simpleResource.getTitleRes());
      SpannableString var5 = new SpannableString((CharSequence)HtmlCompat.fromHtml(var1.tvContent.getContext().getString(this.simpleResource.getContentRes(), new Object[]{this.simpleResource.getLinkStr()}), 0));
      CharSequence var4 = (CharSequence)this.simpleResource.getLinkStr();
      if (var4 != null && var4.length() != 0) {
         String var6 = this.simpleResource.getLinkStr();
         Intrinsics.checkNotNull(var6);
         int var3 = StringsKt.indexOf$default((CharSequence)var5, var6, 0, false, 6, (Object)null);
         if (var3 != -1) {
            var5.setSpan(new NoUnderlineClickableSpan(this, var6) {
               final String $linkStr;
               final TroubleShootingItem this$0;

               {
                  this.this$0 = var1;
                  this.$linkStr = var2;
               }

               public void onClick(View var1) {
                  Intrinsics.checkNotNullParameter(var1, "widget");
                  this.this$0.onClickLink.invoke(this.$linkStr, this.this$0.simpleResource.getLinkToken());
               }
            }, var3, var6.length() + var3, 33);
            var1.tvContent.setMovementMethod(LinkMovementMethod.getInstance());
         }
      }

      var1.tvContent.setText((CharSequence)var5);
   }

   public HolderTroubleshootingStepBinding createBinding(LayoutInflater var1, ViewGroup var2) {
      Intrinsics.checkNotNullParameter(var1, "inflater");
      HolderTroubleshootingStepBinding var3 = HolderTroubleshootingStepBinding.inflate(var1, var2, false);
      Intrinsics.checkNotNullExpressionValue(var3, "inflate(...)");
      return var3;
   }

   public int getType() {
      return this.type;
   }
}
