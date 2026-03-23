package com.blueair.viewcore.adapter;

import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.core.text.HtmlCompat;
import com.blueair.core.model.SimpleResourceBundle;
import com.blueair.viewcore.databinding.HolderTroubleshootingStepBinding;
import com.mikepenz.fastadapter.binding.AbstractBindingItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001BI\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00128\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\u0004\b\r\u0010\u000eJ\u001e\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R@\u0010\u0005\u001a4\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0006X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010XD¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, d2 = {"Lcom/blueair/viewcore/adapter/TroubleShootingItem;", "Lcom/mikepenz/fastadapter/binding/AbstractBindingItem;", "Lcom/blueair/viewcore/databinding/HolderTroubleshootingStepBinding;", "simpleResource", "Lcom/blueair/core/model/SimpleResourceBundle;", "onClickLink", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "linkStr", "linkToken", "", "<init>", "(Lcom/blueair/core/model/SimpleResourceBundle;Lkotlin/jvm/functions/Function2;)V", "type", "", "getType", "()I", "bindView", "binding", "payloads", "", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "parent", "Landroid/view/ViewGroup;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TroubleShootingItem.kt */
public final class TroubleShootingItem extends AbstractBindingItem<HolderTroubleshootingStepBinding> {
    /* access modifiers changed from: private */
    public Function2<? super String, ? super String, Unit> onClickLink;
    /* access modifiers changed from: private */
    public final SimpleResourceBundle simpleResource;
    private final int type;

    public TroubleShootingItem(SimpleResourceBundle simpleResourceBundle, Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(simpleResourceBundle, "simpleResource");
        Intrinsics.checkNotNullParameter(function2, "onClickLink");
        this.simpleResource = simpleResourceBundle;
        this.onClickLink = function2;
    }

    public int getType() {
        return this.type;
    }

    public void bindView(HolderTroubleshootingStepBinding holderTroubleshootingStepBinding, List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(holderTroubleshootingStepBinding, "binding");
        Intrinsics.checkNotNullParameter(list, "payloads");
        holderTroubleshootingStepBinding.ivIcon.setImageResource(this.simpleResource.getIconRes());
        holderTroubleshootingStepBinding.tvTitle.setText(this.simpleResource.getTitleRes());
        SpannableString spannableString = new SpannableString(HtmlCompat.fromHtml(holderTroubleshootingStepBinding.tvContent.getContext().getString(this.simpleResource.getContentRes(), new Object[]{this.simpleResource.getLinkStr()}), 0));
        CharSequence linkStr = this.simpleResource.getLinkStr();
        if (!(linkStr == null || linkStr.length() == 0)) {
            String linkStr2 = this.simpleResource.getLinkStr();
            Intrinsics.checkNotNull(linkStr2);
            int indexOf$default = StringsKt.indexOf$default((CharSequence) spannableString, linkStr2, 0, false, 6, (Object) null);
            if (indexOf$default != -1) {
                spannableString.setSpan(new TroubleShootingItem$bindView$1(this, linkStr2), indexOf$default, linkStr2.length() + indexOf$default, 33);
                holderTroubleshootingStepBinding.tvContent.setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
        holderTroubleshootingStepBinding.tvContent.setText(spannableString);
    }

    public HolderTroubleshootingStepBinding createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        HolderTroubleshootingStepBinding inflate = HolderTroubleshootingStepBinding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        return inflate;
    }
}
