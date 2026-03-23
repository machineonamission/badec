package com.blueair.viewcore.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.PopupWindow;
import androidx.recyclerview.widget.RecyclerView;
import com.blueair.viewcore.R;
import com.blueair.viewcore.adapter.DropDownListAdapter;
import com.blueair.viewcore.utils.MaxCountLayoutManager;
import com.blueair.viewcore.view.ShadowedRecyclerViewLayout;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.kongzue.dialogx.DialogX;
import com.kongzue.dialogx.dialogs.PopNotification;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJh\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\b2\b\b\u0002\u0010\u0014\u001a\u00020\b2\b\b\u0002\u0010\u0015\u001a\u00020\b2\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u0017\u001a\u00020\u00182\u0018\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\n0\u001aJ\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001c\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\bJ\u000e\u0010\u001e\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ+\u0010\u001f\u001a\u00020\n2\b\u0010 \u001a\u0004\u0018\u00010!2\b\b\u0002\u0010\"\u001a\u00020\u00182\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0018¢\u0006\u0002\u0010$J\u0006\u0010%\u001a\u00020\nR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/blueair/viewcore/dialog/DialogUtils;", "", "<init>", "()V", "permissionHints", "", "Lcom/kongzue/dialogx/dialogs/PopNotification;", "statusBarHeight", "", "init", "", "context", "Landroid/content/Context;", "showDropDownList", "anchorView", "Landroid/view/View;", "items", "", "", "width", "dx", "dy", "maxVisibleCount", "headFirstItem", "", "onItemSelectedListener", "Lkotlin/Function2;", "showRequestPermissionHint", "titleRes", "messageRes", "getStatusBarHeight", "immersiveStatusBar", "dialog", "Landroid/app/Dialog;", "fullScreen", "lightMode", "(Landroid/app/Dialog;ZLjava/lang/Boolean;)V", "hideRequestPermissionHints", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: DialogUtils.kt */
public final class DialogUtils {
    public static final DialogUtils INSTANCE = new DialogUtils();
    private static final List<PopNotification> permissionHints = new ArrayList();
    private static int statusBarHeight = 35;

    private DialogUtils() {
    }

    public final void init(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        DialogX.init(context);
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            statusBarHeight = resources.getDimensionPixelSize(identifier) / 2;
        }
    }

    public static /* synthetic */ void showDropDownList$default(DialogUtils dialogUtils, View view, List list, int i, int i2, int i3, int i4, boolean z, Function2 function2, int i5, Object obj) {
        Function2 function22;
        boolean z2;
        List list2;
        View view2;
        DialogUtils dialogUtils2;
        if ((i5 & 4) != 0) {
            i = view.getWidth();
        }
        int i6 = i;
        int i7 = (i5 & 8) != 0 ? 0 : i2;
        int i8 = (i5 & 16) != 0 ? 0 : i3;
        int i9 = (i5 & 32) != 0 ? 0 : i4;
        if ((i5 & 64) != 0) {
            z2 = false;
            view2 = view;
            list2 = list;
            function22 = function2;
            dialogUtils2 = dialogUtils;
        } else {
            z2 = z;
            dialogUtils2 = dialogUtils;
            view2 = view;
            list2 = list;
            function22 = function2;
        }
        dialogUtils2.showDropDownList(view2, list2, i6, i7, i8, i9, z2, function22);
    }

    public final void showDropDownList(View view, List<String> list, int i, int i2, int i3, int i4, boolean z, Function2<? super Integer, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(view, "anchorView");
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function2, "onItemSelectedListener");
        View inflate = LayoutInflater.from(view.getContext()).inflate(R.layout.drop_down_list, (ViewGroup) null);
        Intrinsics.checkNotNull(inflate, "null cannot be cast to non-null type com.blueair.viewcore.view.ShadowedRecyclerViewLayout");
        ShadowedRecyclerViewLayout shadowedRecyclerViewLayout = (ShadowedRecyclerViewLayout) inflate;
        if (i4 > 0) {
            RecyclerView recyclerView = shadowedRecyclerViewLayout.getRecyclerView();
            MaxCountLayoutManager maxCountLayoutManager = new MaxCountLayoutManager(view.getContext());
            maxCountLayoutManager.setMaxCount(i4);
            recyclerView.setLayoutManager(maxCountLayoutManager);
        }
        PopupWindow popupWindow = new PopupWindow(shadowedRecyclerViewLayout, i, -2);
        popupWindow.setFocusable(true);
        shadowedRecyclerViewLayout.getRecyclerView().removeItemDecorationAt(0);
        shadowedRecyclerViewLayout.getRecyclerView().setAdapter(new DropDownListAdapter(z, list, new DialogUtils$$ExternalSyntheticLambda1(popupWindow, function2)));
        popupWindow.showAsDropDown(view, i2, i3);
    }

    /* access modifiers changed from: private */
    public static final Unit showDropDownList$lambda$2(PopupWindow popupWindow, Function2 function2, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "item");
        popupWindow.dismiss();
        function2.invoke(Integer.valueOf(i), str);
        return Unit.INSTANCE;
    }

    public final PopNotification showRequestPermissionHint(int i, int i2) {
        if (!Intrinsics.areEqual((Object) Locale.getDefault().getLanguage(), (Object) Locale.CHINESE.getLanguage())) {
            return null;
        }
        PopNotification build = PopNotification.build();
        if (i != 0) {
            build.setTitle(PopNotification.getApplicationContext().getString(i));
        }
        if (i2 != 0) {
            build.setMessage(i2);
        }
        List<PopNotification> list = permissionHints;
        Intrinsics.checkNotNull(build);
        list.add(build);
        return build.setDialogImplMode(DialogX.IMPL_MODE.DIALOG_FRAGMENT).noAutoDismiss().setMarginTop(statusBarHeight).show();
    }

    public final int getStatusBarHeight(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return (int) TypedValue.applyDimension(1, 24.0f, resources.getDisplayMetrics());
    }

    public static /* synthetic */ void immersiveStatusBar$default(DialogUtils dialogUtils, Dialog dialog, boolean z, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            bool = null;
        }
        dialogUtils.immersiveStatusBar(dialog, z, bool);
    }

    public final void immersiveStatusBar(Dialog dialog, boolean z, Boolean bool) {
        Window window;
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            int systemUiVisibility = window.getDecorView().getSystemUiVisibility();
            if (z) {
                systemUiVisibility |= 1280;
                if (Build.VERSION.SDK_INT >= 28) {
                    WindowManager.LayoutParams attributes = window.getAttributes();
                    attributes.layoutInDisplayCutoutMode = 1;
                    window.setAttributes(attributes);
                }
            }
            if (bool != null) {
                systemUiVisibility = bool.booleanValue() ? systemUiVisibility | 8192 : systemUiVisibility & -8193;
            }
            window.getDecorView().setSystemUiVisibility(systemUiVisibility);
        }
    }

    public final void hideRequestPermissionHints() {
        for (PopNotification dismiss : permissionHints) {
            dismiss.dismiss();
        }
        permissionHints.clear();
    }
}
