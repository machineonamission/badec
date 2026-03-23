package com.blueair.viewcore.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.blueair.viewcore.R;
import com.google.android.material.textfield.TextInputLayout;
import com.mapbox.maps.plugin.locationcomponent.LocationComponentConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jboss.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import org.projectodd.stilts.stomp.protocol.StompFrame;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001eB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bJ\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0012\u0010\u001a\u001a\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXD¢\u0006\u0002\n\u0000R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0011\u001a\u00020\u0012@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u001f"}, d2 = {"Lcom/blueair/viewcore/view/SimpleTextInputLayout;", "Lcom/google/android/material/textfield/TextInputLayout;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "required", "", "triggerTimeMillis", "", "blockPeriod", "value", "", "errorText", "getErrorText", "()Ljava/lang/CharSequence;", "setErrorText", "(Ljava/lang/CharSequence;)V", "initAttr", "", "setTextInputAccessibilityDelegate", "delegate", "Lcom/google/android/material/textfield/TextInputLayout$AccessibilityDelegate;", "shouldAnnounceErrorForAccessibility", "TextInputAccessibilityDelegate", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: SimpleTextInputLayout.kt */
public final class SimpleTextInputLayout extends TextInputLayout {
    private final long blockPeriod;
    private CharSequence errorText;
    /* access modifiers changed from: private */
    public boolean required;
    private long triggerTimeMillis;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleTextInputLayout(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleTextInputLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.blockPeriod = LocationComponentConstants.MAX_ANIMATION_DURATION_MS;
        this.errorText = "";
        initAttr(attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SimpleTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.blockPeriod = LocationComponentConstants.MAX_ANIMATION_DURATION_MS;
        this.errorText = "";
        initAttr(attributeSet, i);
    }

    public final CharSequence getErrorText() {
        return this.errorText;
    }

    public final void setErrorText(CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(charSequence, "value");
        this.errorText = charSequence;
        if (charSequence.length() > 0) {
            this.triggerTimeMillis = System.currentTimeMillis();
        }
    }

    private final void initAttr(AttributeSet attributeSet, int i) {
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        int[] iArr = R.styleable.SimpleTextInputLayout;
        Intrinsics.checkNotNullExpressionValue(iArr, "SimpleTextInputLayout");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i, 0);
        this.required = obtainStyledAttributes.getBoolean(R.styleable.SimpleTextInputLayout_required, false);
        obtainStyledAttributes.recycle();
    }

    public void setTextInputAccessibilityDelegate(TextInputLayout.AccessibilityDelegate accessibilityDelegate) {
        EditText editText = getEditText();
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, new TextInputAccessibilityDelegate(this));
        }
    }

    public final boolean shouldAnnounceErrorForAccessibility() {
        return this.errorText.length() > 0 && System.currentTimeMillis() - this.triggerTimeMillis < this.blockPeriod;
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/blueair/viewcore/view/SimpleTextInputLayout$TextInputAccessibilityDelegate;", "Landroidx/core/view/AccessibilityDelegateCompat;", "layout", "Lcom/blueair/viewcore/view/SimpleTextInputLayout;", "<init>", "(Lcom/blueair/viewcore/view/SimpleTextInputLayout;)V", "getLayout", "()Lcom/blueair/viewcore/view/SimpleTextInputLayout;", "onInitializeAccessibilityNodeInfo", "", "host", "Landroid/view/View;", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "viewcore_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: SimpleTextInputLayout.kt */
    public static final class TextInputAccessibilityDelegate extends AccessibilityDelegateCompat {
        private final SimpleTextInputLayout layout;

        public final SimpleTextInputLayout getLayout() {
            return this.layout;
        }

        public TextInputAccessibilityDelegate(SimpleTextInputLayout simpleTextInputLayout) {
            Intrinsics.checkNotNullParameter(simpleTextInputLayout, "layout");
            this.layout = simpleTextInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            String str;
            String str2;
            AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
            View view2 = view;
            Intrinsics.checkNotNullParameter(view2, StompFrame.Header.HOST);
            Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat2, "info");
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            CharSequence text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            boolean isEmpty = TextUtils.isEmpty(text);
            String valueOf = !TextUtils.isEmpty(hint) ? String.valueOf(hint) : "";
            if (this.layout.required) {
                String str3 = ", " + view2.getContext().getString(R.string.required);
                str = ", ";
                if (StringsKt.contains$default((CharSequence) valueOf, (CharSequence) WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, false, 2, (Object) null)) {
                    str2 = StringsKt.replace$default(valueOf, WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD, str3, false, 4, (Object) null);
                } else {
                    str2 = valueOf + str3;
                }
                valueOf = str2;
            } else {
                str = ", ";
            }
            if (!isEmpty) {
                accessibilityNodeInfoCompat2.setText(text);
            } else {
                CharSequence charSequence = valueOf;
                if (!TextUtils.isEmpty(charSequence)) {
                    accessibilityNodeInfoCompat2.setText(charSequence);
                } else if (placeholderText != null) {
                    accessibilityNodeInfoCompat2.setText(placeholderText);
                }
            }
            CharSequence charSequence2 = valueOf;
            if (!TextUtils.isEmpty(charSequence2)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat2.setHintText(charSequence2);
                } else {
                    if (!isEmpty) {
                        valueOf = text + str + valueOf;
                    }
                    accessibilityNodeInfoCompat2.setText(valueOf);
                }
                accessibilityNodeInfoCompat2.setShowingHintText(isEmpty);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat2.setMaxTextLength(counterMaxLength);
            accessibilityNodeInfoCompat2.setSelected(false);
            if (this.layout.shouldAnnounceErrorForAccessibility()) {
                accessibilityNodeInfoCompat2.setText(this.layout.getErrorText());
                accessibilityNodeInfoCompat2.setStateDescription((CharSequence) null);
                accessibilityNodeInfoCompat2.setContentDescription((CharSequence) null);
                accessibilityNodeInfoCompat2.setHintText((CharSequence) null);
                accessibilityNodeInfoCompat2.setClassName("");
            }
        }
    }
}
