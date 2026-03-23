package com.blueair.viewcore;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blueair.core.model.ConnectivityStatus;
import com.blueair.core.model.HasSafetySwitch;
import com.blueair.viewcore.databinding.ConfirmationDialogBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mapbox.maps.plugin.locationcomponent.ModelSourceWrapper;
import de.mateware.snacky.Snacky;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001=B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0005J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u0005J \u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\b\u0001\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J \u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u0011Jf\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\u0010\"Jb\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\r2\u0006\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00052!\u0010\u001c\u001a\u001d\u0012\u0013\u0012\u00110\u001e¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\b0\u001d¢\u0006\u0002\u0010%J\"\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\b\u0002\u0010,\u001a\u00020-J\u000e\u0010.\u001a\u00020\u001e2\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u0002022\b\b\u0001\u00103\u001a\u00020\u0005Jj\u00104\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00132\u0012\b\u0002\u00105\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0013\u0018\u0001062\n\b\u0002\u00107\u001a\u0004\u0018\u00010\r2:\b\u0002\u00108\u001a4\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(:\u0012\u0013\u0012\u00110;¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(<\u0012\u0004\u0012\u00020\b\u0018\u000109R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006>"}, d2 = {"Lcom/blueair/viewcore/ViewUtils;", "", "<init>", "()V", "requestCodeCounter", "", "genRequestCode", "showError", "", "activity", "Landroid/app/Activity;", "messageResId", "message", "", "showInfo", "showSnackbar", "type", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "view", "Landroid/view/View;", "showConfirmation", "context", "Landroid/content/Context;", "titleText", "bodyText", "positiveTextResId", "negativeTextResId", "topImageResId", "result", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "confirmed", "(Landroid/content/Context;IIILjava/lang/Integer;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "positiveText", "negativeText", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function1;)V", "colorGradient", "Landroid/graphics/drawable/PaintDrawable;", "colors", "", "positions", "", "orientation", "Landroid/graphics/drawable/GradientDrawable$Orientation;", "shouldShowFilterDoorPopup", "device", "Lcom/blueair/core/model/HasSafetySwitch;", "createTimePickerShowAccessibilityDelegate", "Landroidx/core/view/AccessibilityDelegateCompat;", "contentDescriptionPatternResourceId", "setAccessibilityDelegate", "kClass", "Lkotlin/reflect/KClass;", "tooltip", "initializer", "Lkotlin/Function2;", "host", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "info", "MessageType", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: ViewUtils.kt */
public final class ViewUtils {
    public static final ViewUtils INSTANCE = new ViewUtils();
    private static volatile int requestCodeCounter;

    private ViewUtils() {
    }

    public final synchronized int genRequestCode() {
        int i;
        i = requestCodeCounter;
        requestCodeCounter = i + 1;
        return i;
    }

    public final void showError(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showSnackbar(activity, i, (MessageType) MessageType.ERROR.INSTANCE);
    }

    public final void showError(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "message");
        showSnackbar(activity, str, (MessageType) MessageType.ERROR.INSTANCE);
    }

    public final void showInfo(Activity activity, String str) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "message");
        showSnackbar(activity, str, (MessageType) MessageType.INFO.INSTANCE);
    }

    public final void showInfo(Activity activity, int i) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        showSnackbar(activity, i, (MessageType) MessageType.INFO.INSTANCE);
    }

    public final void showSnackbar(Activity activity, int i, MessageType messageType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(messageType, "type");
        String string = activity.getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showSnackbar(activity, string, messageType);
    }

    public final void showSnackbar(View view, int i, MessageType messageType) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(messageType, "type");
        String string = view.getContext().getString(i);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        showSnackbar(view, string, messageType);
    }

    public final void showSnackbar(Activity activity, String str, MessageType messageType) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(messageType, "type");
        Snacky.Builder duration = Snacky.builder().setActivity(activity).setText((CharSequence) str).setDuration(3000);
        if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.SUCCESS.INSTANCE)) {
            duration.success().show();
        } else if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.WARNING.INSTANCE)) {
            duration.warning().show();
        } else if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.ERROR.INSTANCE)) {
            duration.error().show();
        } else if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.INFO.INSTANCE)) {
            duration.info().show();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final void showSnackbar(View view, String str, MessageType messageType) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(str, "message");
        Intrinsics.checkNotNullParameter(messageType, "type");
        Snacky.Builder duration = Snacky.builder().setView(view).setText((CharSequence) str).setDuration(3000);
        if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.SUCCESS.INSTANCE)) {
            duration.success().show();
        } else if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.WARNING.INSTANCE)) {
            duration.warning().show();
        } else if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.ERROR.INSTANCE)) {
            duration.error().show();
        } else if (Intrinsics.areEqual((Object) messageType, (Object) MessageType.INFO.INSTANCE)) {
            duration.info().show();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0004\u0005\u0006\u0007B\t\b\u0004¢\u0006\u0004\b\u0002\u0010\u0003\u0001\u0004\b\t\n\u000b¨\u0006\f"}, d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType;", "", "<init>", "()V", "SUCCESS", "WARNING", "INFO", "ERROR", "Lcom/blueair/viewcore/ViewUtils$MessageType$ERROR;", "Lcom/blueair/viewcore/ViewUtils$MessageType$INFO;", "Lcom/blueair/viewcore/ViewUtils$MessageType$SUCCESS;", "Lcom/blueair/viewcore/ViewUtils$MessageType$WARNING;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: ViewUtils.kt */
    public static abstract class MessageType {
        public /* synthetic */ MessageType(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$SUCCESS;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: ViewUtils.kt */
        public static final class SUCCESS extends MessageType {
            public static final SUCCESS INSTANCE = new SUCCESS();

            private SUCCESS() {
                super((DefaultConstructorMarker) null);
            }
        }

        private MessageType() {
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$WARNING;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: ViewUtils.kt */
        public static final class WARNING extends MessageType {
            public static final WARNING INSTANCE = new WARNING();

            private WARNING() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$INFO;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: ViewUtils.kt */
        public static final class INFO extends MessageType {
            public static final INFO INSTANCE = new INFO();

            private INFO() {
                super((DefaultConstructorMarker) null);
            }
        }

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lcom/blueair/viewcore/ViewUtils$MessageType$ERROR;", "Lcom/blueair/viewcore/ViewUtils$MessageType;", "<init>", "()V", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* compiled from: ViewUtils.kt */
        public static final class ERROR extends MessageType {
            public static final ERROR INSTANCE = new ERROR();

            private ERROR() {
                super((DefaultConstructorMarker) null);
            }
        }
    }

    public static /* synthetic */ void showConfirmation$default(ViewUtils viewUtils, Context context, int i, int i2, int i3, Integer num, Integer num2, Function1 function1, int i4, Object obj) {
        if ((i4 & 16) != 0) {
            num = null;
        }
        if ((i4 & 32) != 0) {
            num2 = null;
        }
        viewUtils.showConfirmation(context, i, i2, i3, num, num2, (Function1<? super Boolean, Unit>) function1);
    }

    public final void showConfirmation(Context context, int i, int i2, int i3, Integer num, Integer num2, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(function1, "result");
        String string = num == null ? null : context.getString(num.intValue());
        String string2 = context.getString(i);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        String string3 = context.getString(i2);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        String string4 = context.getString(i3);
        Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
        showConfirmation(context, string2, string3, string4, string, num2, function1);
    }

    public final void showConfirmation(Context context, String str, String str2, String str3, String str4, Integer num, Function1<? super Boolean, Unit> function1) {
        AlertDialog alertDialog;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "titleText");
        Intrinsics.checkNotNullParameter(str2, "bodyText");
        Intrinsics.checkNotNullParameter(str3, "positiveText");
        Intrinsics.checkNotNullParameter(function1, "result");
        boolean z = true;
        AlertDialog.Builder positiveButton = new AlertDialog.Builder(context, 16974394).setCancelable(true).setPositiveButton(str3, new ViewUtils$$ExternalSyntheticLambda0(function1));
        ConfirmationDialogBinding inflate = ConfirmationDialogBinding.inflate(LayoutInflater.from(context));
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        if (num != null) {
            inflate.imageTop.setImageResource(num.intValue());
        }
        ImageView imageView = inflate.imageTop;
        Intrinsics.checkNotNullExpressionValue(imageView, "imageTop");
        View view = imageView;
        if (num == null) {
            z = false;
        }
        ViewExtensionsKt.show(view, z);
        inflate.titleTextView.setText(str);
        inflate.messageTextView.setText(str2);
        positiveButton.setView(inflate.getRoot());
        if (str4 != null) {
            alertDialog = positiveButton.setNegativeButton(str4, new ViewUtils$$ExternalSyntheticLambda1(function1)).show();
        } else {
            alertDialog = positiveButton.show();
        }
        alertDialog.getButton(-2).setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryText));
        alertDialog.getButton(-1).setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryText));
    }

    /* access modifiers changed from: private */
    public static final void showConfirmation$lambda$0(Function1 function1, DialogInterface dialogInterface, int i) {
        function1.invoke(true);
    }

    /* access modifiers changed from: private */
    public static final void showConfirmation$lambda$2(Function1 function1, DialogInterface dialogInterface, int i) {
        function1.invoke(false);
    }

    public static /* synthetic */ PaintDrawable colorGradient$default(ViewUtils viewUtils, int[] iArr, float[] fArr, GradientDrawable.Orientation orientation, int i, Object obj) {
        if ((i & 4) != 0) {
            orientation = GradientDrawable.Orientation.TL_BR;
        }
        return viewUtils.colorGradient(iArr, fArr, orientation);
    }

    public final PaintDrawable colorGradient(int[] iArr, float[] fArr, GradientDrawable.Orientation orientation) {
        Intrinsics.checkNotNullParameter(iArr, "colors");
        Intrinsics.checkNotNullParameter(orientation, ModelSourceWrapper.ORIENTATION);
        ViewUtils$colorGradient$shaderFactory$1 viewUtils$colorGradient$shaderFactory$1 = new ViewUtils$colorGradient$shaderFactory$1(iArr, fArr, orientation);
        PaintDrawable paintDrawable = new PaintDrawable();
        paintDrawable.setShape(new RectShape());
        paintDrawable.setShaderFactory(viewUtils$colorGradient$shaderFactory$1);
        return paintDrawable;
    }

    public final boolean shouldShowFilterDoorPopup(HasSafetySwitch hasSafetySwitch) {
        Intrinsics.checkNotNullParameter(hasSafetySwitch, "device");
        return hasSafetySwitch.getConnectivityStatus() == ConnectivityStatus.ONLINE && !hasSafetySwitch.isSafetySwitchOn();
    }

    public final AccessibilityDelegateCompat createTimePickerShowAccessibilityDelegate(int i) {
        return new ViewUtils$createTimePickerShowAccessibilityDelegate$1(i);
    }

    public static /* synthetic */ void setAccessibilityDelegate$default(ViewUtils viewUtils, View view, KClass kClass, String str, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            kClass = null;
        }
        if ((i & 4) != 0) {
            str = null;
        }
        if ((i & 8) != 0) {
            function2 = null;
        }
        viewUtils.setAccessibilityDelegate(view, kClass, str, function2);
    }

    public final void setAccessibilityDelegate(View view, KClass<? extends View> kClass, String str, Function2<? super View, ? super AccessibilityNodeInfoCompat, Unit> function2) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        ViewCompat.setAccessibilityDelegate(view, new ViewUtils$setAccessibilityDelegate$1(kClass, str, function2));
    }
}
