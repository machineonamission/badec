package io.flatcircle.viewhelper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.core.net.MailTo;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.king.zxing.util.CodeUtils;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rH\u0002J9\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\r2\n\b\u0003\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0005J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0018\u001a\u00020\bJ\u0014\u0010\u0019\u001a\u0004\u0018\u00010\u00052\b\u0010\u001a\u001a\u0004\u0018\u00010\bH\u0002J\u0016\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0015J\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\u0015J\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\"\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\bJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010#\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010$\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0010\u0010&\u001a\u00020%2\b\u0010\u0018\u001a\u0004\u0018\u00010\bJ\u0018\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0007JZ\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u00152\u0006\u00100\u001a\u00020\u00152\u0006\u00101\u001a\u00020\u00152\n\b\u0002\u00102\u001a\u0004\u0018\u00010\u00152!\u00103\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020%04¢\u0006\u0002\u00109JS\u0010,\u001a\u00020%2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\r2\u0006\u00100\u001a\u00020\r2\u0006\u0010:\u001a\u00020\r2\b\u0010;\u001a\u0004\u0018\u00010\r2!\u00103\u001a\u001d\u0012\u0013\u0012\u001105¢\u0006\f\b6\u0012\b\b7\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020%04J7\u0010<\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u0015¢\u0006\u0002\u0010>J9\u0010?\u001a\u00020%2\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010\u00152\b\b\u0002\u0010\u0013\u001a\u00020\r¢\u0006\u0002\u0010@R\u0015\u0010\u0003\u001a\u00020\u0004*\u00020\u00058F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\u0003\u001a\u0004\u0018\u00010\u0004*\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\t¨\u0006A"}, d2 = {"Lio/flatcircle/viewhelper/ViewHelperUtil;", "", "()V", "screenDensity", "Lio/flatcircle/viewhelper/ScreenDensity;", "Landroid/app/Activity;", "getScreenDensity", "(Landroid/app/Activity;)Lio/flatcircle/viewhelper/ScreenDensity;", "Landroid/view/View;", "(Landroid/view/View;)Lio/flatcircle/viewhelper/ScreenDensity;", "buildEmailIntent", "Landroid/content/Intent;", "destination", "", "subject", "msg", "buildShareDialogIntent", "activity", "message", "email", "headerResId", "", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/Intent;", "calculateScreenDensity", "view", "getActivityFromView", "v", "getDpfromPx", "resources", "Landroid/content/res/Resources;", "px", "getPxFromDp", "", "dp", "getScreenHeight", "getScreenWidth", "hideSoftKeyboard", "", "openSoftKeyboard", "recursivelyAddSharedTransitionsForFragment", "parent", "Landroid/view/ViewGroup;", "fragmentTransaction", "Landroid/app/FragmentTransaction;", "showConfirmation", "context", "Landroid/content/Context;", "titleText", "bodyText", "positiveTextResId", "negativeTextResId", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirmed", "(Landroid/content/Context;IIILjava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "positiveText", "negativeText", "showEmailDialog", "requestCodeRequiredForResult", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "showShareDialog", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "viewhelper_release"}, k = 1, mv = {1, 1, 13})
/* compiled from: ViewHelperUtil.kt */
public final class ViewHelperUtil {
    public static final ViewHelperUtil INSTANCE = new ViewHelperUtil();

    private ViewHelperUtil() {
    }

    public final void hideSoftKeyboard(View view) {
        if (view != null) {
            Object systemService = view.getContext().getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final void openSoftKeyboard(View view) {
        if (view != null) {
            Object systemService = view.getContext().getSystemService("input_method");
            if (systemService != null) {
                ((InputMethodManager) systemService).showSoftInput(view, 0);
                return;
            }
            throw new TypeCastException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        }
    }

    public final float getPxFromDp(Resources resources, int i) {
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return TypedValue.applyDimension(1, (float) i, resources.getDisplayMetrics());
    }

    public final int getDpfromPx(Resources resources, int i) {
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return Math.round(((float) i) / (resources.getDisplayMetrics().xdpi / ((float) 160)));
    }

    public final int getScreenWidth(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        Resources resources = view.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "view.resources");
        return getScreenWidth(resources);
    }

    public final int getScreenWidth(Resources resources) {
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return resources.getDisplayMetrics().widthPixels;
    }

    public final int getScreenHeight(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        Resources resources = view.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "view.resources");
        return getScreenHeight(resources);
    }

    public final int getScreenHeight(Resources resources) {
        Intrinsics.checkParameterIsNotNull(resources, "resources");
        return resources.getDisplayMetrics().heightPixels;
    }

    public final ScreenDensity getScreenDensity(View view) {
        Intrinsics.checkParameterIsNotNull(view, "receiver$0");
        return calculateScreenDensity(view);
    }

    public final ScreenDensity calculateScreenDensity(View view) {
        Intrinsics.checkParameterIsNotNull(view, ViewHierarchyConstants.VIEW_KEY);
        Activity activityFromView = getActivityFromView(view);
        if (activityFromView == null) {
            return null;
        }
        return calculateScreenDensity(activityFromView);
    }

    public final ScreenDensity getScreenDensity(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "receiver$0");
        return calculateScreenDensity(activity);
    }

    public final ScreenDensity calculateScreenDensity(Activity activity) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Resources resources = activity.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "activity.resources");
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        WindowManager windowManager = activity.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(windowManager, "activity.windowManager");
        windowManager.getDefaultDisplay().getRealMetrics(displayMetrics);
        float f = displayMetrics.density;
        if (f <= ((float) 280)) {
            return ScreenDensity.LOW;
        }
        if (f <= ((float) 240)) {
            return ScreenDensity.HIGH;
        }
        if (f <= ((float) 320)) {
            return ScreenDensity.XHIGH;
        }
        if (f <= ((float) CodeUtils.DEFAULT_REQ_WIDTH)) {
            return ScreenDensity.XXHIGH;
        }
        return ScreenDensity.XXXHIGH;
    }

    private final Activity getActivityFromView(View view) {
        if (view == null) {
            return null;
        }
        Context context = view.getContext();
        Activity activity = (Activity) (!(context instanceof Activity) ? null : context);
        if (activity != null) {
            return activity;
        }
        if (!(context instanceof ContextWrapper)) {
            return null;
        }
        Context baseContext = ((ContextWrapper) context).getBaseContext();
        if (baseContext != null) {
            return (Activity) baseContext;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.app.Activity");
    }

    public final void recursivelyAddSharedTransitionsForFragment(ViewGroup viewGroup, FragmentTransaction fragmentTransaction) {
        CharSequence transitionName;
        Intrinsics.checkParameterIsNotNull(viewGroup, "parent");
        Intrinsics.checkParameterIsNotNull(fragmentTransaction, "fragmentTransaction");
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                recursivelyAddSharedTransitionsForFragment((ViewGroup) childAt, fragmentTransaction);
            } else if (!(childAt == null || (transitionName = childAt.getTransitionName()) == null || transitionName.length() == 0)) {
                try {
                    fragmentTransaction.addSharedElement(childAt, childAt.getTransitionName());
                } catch (IllegalArgumentException e) {
                    Log.w("ViewHelperUtil", e + "\nThere is more than one element in this screen with the same transitionName of " + childAt.getTransitionName());
                }
            }
        }
    }

    public static /* synthetic */ void showShareDialog$default(ViewHelperUtil viewHelperUtil, Activity activity, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            num = null;
            Integer num2 = null;
        }
        Integer num3 = num;
        if ((i & 16) != 0) {
            str3 = "";
        }
        viewHelperUtil.showShareDialog(activity, str, str2, num3, str3);
    }

    public final void showShareDialog(Activity activity, String str, String str2, Integer num, String str3) {
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "message");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "email");
        Activity activity2 = activity;
        Intent buildShareDialogIntent$default = buildShareDialogIntent$default(this, activity2, str, str2, str3, (Integer) null, 16, (Object) null);
        if (num != null) {
            activity2.startActivityForResult(buildShareDialogIntent$default, num.intValue());
        } else {
            activity2.startActivity(buildShareDialogIntent$default);
        }
    }

    static /* synthetic */ Intent buildShareDialogIntent$default(ViewHelperUtil viewHelperUtil, Activity activity, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = Integer.valueOf(R.string.send_to);
        }
        return viewHelperUtil.buildShareDialogIntent(activity, str, str2, str3, num);
    }

    private final Intent buildShareDialogIntent(Activity activity, String str, String str2, String str3, Integer num) {
        Intent intent;
        if (str3.length() == 0) {
            intent = new Intent();
            intent.setAction("android.intent.action.SEND");
            intent.setType(HttpPostBodyUtil.DEFAULT_TEXT_CONTENT_TYPE);
        } else {
            Intent intent2 = new Intent("android.intent.action.SENDTO", Uri.fromParts("mailto", str3, (String) null));
            intent2.putExtra("android.intent.extra.EMAIL", str3);
            intent = intent2;
        }
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", str);
        Intent createChooser = Intent.createChooser(intent, activity.getResources().getText(R.string.send_to));
        Intrinsics.checkExpressionValueIsNotNull(createChooser, "Intent.createChooser(sen…etText(R.string.send_to))");
        return createChooser;
    }

    public static /* synthetic */ void showEmailDialog$default(ViewHelperUtil viewHelperUtil, Activity activity, String str, String str2, String str3, Integer num, int i, Object obj) {
        if ((i & 16) != 0) {
            num = null;
            Integer num2 = null;
        }
        viewHelperUtil.showEmailDialog(activity, str, str2, str3, num);
    }

    public final void showEmailDialog(Activity activity, String str, String str2, String str3, Integer num) {
        Activity activity2;
        Intrinsics.checkParameterIsNotNull(activity, "activity");
        Intrinsics.checkParameterIsNotNull(str, "destination");
        Intrinsics.checkParameterIsNotNull(str2, "subject");
        Intrinsics.checkParameterIsNotNull(str3, "msg");
        Intent buildEmailIntent = buildEmailIntent(str, str2, str3);
        if (buildEmailIntent.resolveActivity(activity.getPackageManager()) == null) {
            activity2 = activity;
            String str4 = str3;
            buildEmailIntent = buildShareDialogIntent$default(this, activity2, str4, str2, str, (Integer) null, 16, (Object) null);
        } else {
            activity2 = activity;
        }
        if (num != null) {
            activity2.startActivityForResult(buildEmailIntent, num.intValue());
        } else {
            activity2.startActivity(buildEmailIntent);
        }
    }

    private final Intent buildEmailIntent(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(MailTo.MAILTO_SCHEME + str + "?subject=" + Uri.encode(str2) + "&body=" + Uri.encode(str3)));
        return intent;
    }

    public static /* synthetic */ void showConfirmation$default(ViewHelperUtil viewHelperUtil, Context context, int i, int i2, int i3, Integer num, Function1 function1, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            num = null;
            Integer num2 = null;
        }
        viewHelperUtil.showConfirmation(context, i, i2, i3, num, (Function1<? super Boolean, Unit>) function1);
    }

    public final void showConfirmation(Context context, int i, int i2, int i3, Integer num, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(function1, "result");
        String string = num == null ? null : context.getString(num.intValue());
        String string2 = context.getString(i);
        Intrinsics.checkExpressionValueIsNotNull(string2, "context.getString(titleText)");
        String string3 = context.getString(i2);
        Intrinsics.checkExpressionValueIsNotNull(string3, "context.getString(bodyText)");
        String string4 = context.getString(i3);
        Intrinsics.checkExpressionValueIsNotNull(string4, "context.getString(positiveTextResId)");
        showConfirmation(context, string2, string3, string4, string, function1);
    }

    public final void showConfirmation(Context context, String str, String str2, String str3, String str4, Function1<? super Boolean, Unit> function1) {
        AlertDialog alertDialog;
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(str, "titleText");
        Intrinsics.checkParameterIsNotNull(str2, "bodyText");
        Intrinsics.checkParameterIsNotNull(str3, "positiveText");
        Intrinsics.checkParameterIsNotNull(function1, "result");
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(context, 16974394).setTitle(str).setMessage(str2).setCancelable(true).setPositiveButton(str3, new ViewHelperUtil$showConfirmation$dialogBuilder$1(function1));
        if (str4 != null) {
            alertDialog = positiveButton.setNegativeButton(str4, new ViewHelperUtil$showConfirmation$dialog$1(function1)).show();
        } else {
            alertDialog = positiveButton.show();
        }
        alertDialog.getButton(-2).setTextColor(ContextCompat.getColor(context, R.color.error_red));
        alertDialog.getButton(-1).setTextColor(ContextCompat.getColor(context, R.color.prussian_blue));
    }
}
