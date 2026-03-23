package com.blueair.devicedetails.dialog;

import android.text.Editable;
import android.text.TextWatcher;
import com.blueair.core.model.DeviceAlarm;
import com.blueair.devicedetails.viewholder.DeletableItem;
import com.mikepenz.fastadapter.IItemAdapter;
import com.mikepenz.fastadapter.adapters.ItemAdapter;
import com.mikepenz.fastadapter.adapters.ModelAdapter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TextView.kt */
public final class DeleteAlarmDialogFragment$onViewCreated$$inlined$addTextChangedListener$default$1 implements TextWatcher {
    final /* synthetic */ DeleteAlarmDialogFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public DeleteAlarmDialogFragment$onViewCreated$$inlined$addTextChangedListener$default$1(DeleteAlarmDialogFragment deleteAlarmDialogFragment) {
        this.this$0 = deleteAlarmDialogFragment;
    }

    public void afterTextChanged(Editable editable) {
        CharSequence charSequence;
        if (editable == null || (charSequence = StringsKt.trim((CharSequence) editable)) == null) {
        }
        if (charSequence.length() == 0) {
            ItemAdapter access$getItemAdapter$p = this.this$0.itemAdapter;
            if (access$getItemAdapter$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
                access$getItemAdapter$p = null;
            }
            IItemAdapter iItemAdapter = access$getItemAdapter$p;
            List access$getOriginAlarms$p = this.this$0.originAlarms;
            if (access$getOriginAlarms$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("originAlarms");
                access$getOriginAlarms$p = null;
            }
            Iterable<DeviceAlarm> iterable = access$getOriginAlarms$p;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (DeviceAlarm deviceAlarm : iterable) {
                CharSequence name = deviceAlarm.getName();
                if (StringsKt.isBlank(name) && (name = this.this$0.defName) == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("defName");
                    name = null;
                }
                arrayList.add(new DeletableItem((String) name, deviceAlarm, !this.this$0.searchable));
            }
            ModelAdapter modelAdapter = (ModelAdapter) IItemAdapter.DefaultImpls.setNewList$default(iItemAdapter, (List) arrayList, false, 2, (Object) null);
            return;
        }
        List arrayList2 = new ArrayList();
        List<DeviceAlarm> access$getOriginAlarms$p2 = this.this$0.originAlarms;
        if (access$getOriginAlarms$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("originAlarms");
            access$getOriginAlarms$p2 = null;
        }
        for (DeviceAlarm deviceAlarm2 : access$getOriginAlarms$p2) {
            CharSequence name2 = deviceAlarm2.getName();
            if (StringsKt.isBlank(name2) && (name2 = this.this$0.defName) == null) {
                Intrinsics.throwUninitializedPropertyAccessException("defName");
                name2 = null;
            }
            String str = (String) name2;
            if (StringsKt.contains((CharSequence) str, charSequence, true)) {
                arrayList2.add(new DeletableItem(str, deviceAlarm2, !this.this$0.searchable));
            }
        }
        ItemAdapter access$getItemAdapter$p2 = this.this$0.itemAdapter;
        if (access$getItemAdapter$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemAdapter");
            access$getItemAdapter$p2 = null;
        }
        ModelAdapter modelAdapter2 = (ModelAdapter) IItemAdapter.DefaultImpls.setNewList$default(access$getItemAdapter$p2, arrayList2, false, 2, (Object) null);
    }
}
