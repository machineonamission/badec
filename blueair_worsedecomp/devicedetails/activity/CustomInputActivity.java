package com.blueair.devicedetails.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.devicedetails.R;
import com.blueair.devicedetails.databinding.ActivityCustomInputBinding;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.material.textfield.TextInputEditText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0014J\b\u0010\u000f\u001a\u00020\fH\u0002R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058TX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/blueair/devicedetails/activity/CustomInputActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "_screenName", "inputBinding", "Lcom/blueair/devicedetails/databinding/ActivityCustomInputBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "bindView", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: CustomInputActivity.kt */
public final class CustomInputActivity extends BaseActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_HINT = "extra_hint";
    public static final String EXTRA_INITIAL_VALUE = "extra_initial_value";
    public static final String EXTRA_INPUT = "extra_input";
    public static final String EXTRA_MAX_LENGTH = "extra_max_length";
    public static final String EXTRA_TITLE = "extra_title";
    private String _screenName;
    /* access modifiers changed from: private */
    public ActivityCustomInputBinding inputBinding;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this._screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseLokaliseActivity.immersiveStatusBar$default(this, false, 1, (Object) null);
        setStatusMode(true);
        bindView();
    }

    private final void bindView() {
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_custom_input);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        ActivityCustomInputBinding activityCustomInputBinding = (ActivityCustomInputBinding) contentView;
        this.inputBinding = activityCustomInputBinding;
        ActivityCustomInputBinding activityCustomInputBinding2 = null;
        if (activityCustomInputBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding = null;
        }
        setContentView(activityCustomInputBinding.getRoot());
        this._screenName = getIntent().getStringExtra("screen_name");
        ActivityCustomInputBinding activityCustomInputBinding3 = this.inputBinding;
        if (activityCustomInputBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding3 = null;
        }
        activityCustomInputBinding3.editTextLayout.setHint((CharSequence) getIntent().getStringExtra(EXTRA_HINT));
        ActivityCustomInputBinding activityCustomInputBinding4 = this.inputBinding;
        if (activityCustomInputBinding4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding4 = null;
        }
        activityCustomInputBinding4.tvTitle.setText(getIntent().getStringExtra(EXTRA_TITLE));
        ActivityCustomInputBinding activityCustomInputBinding5 = this.inputBinding;
        if (activityCustomInputBinding5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding5 = null;
        }
        TextInputEditText textInputEditText = activityCustomInputBinding5.editText;
        Intrinsics.checkNotNullExpressionValue(textInputEditText, "editText");
        textInputEditText.addTextChangedListener(new CustomInputActivity$bindView$$inlined$addTextChangedListener$default$1(this));
        ActivityCustomInputBinding activityCustomInputBinding6 = this.inputBinding;
        if (activityCustomInputBinding6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding6 = null;
        }
        activityCustomInputBinding6.editText.setText(getIntent().getStringExtra(EXTRA_INITIAL_VALUE));
        ActivityCustomInputBinding activityCustomInputBinding7 = this.inputBinding;
        if (activityCustomInputBinding7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding7 = null;
        }
        activityCustomInputBinding7.btnBack.setOnClickListener(new CustomInputActivity$$ExternalSyntheticLambda0(this));
        ActivityCustomInputBinding activityCustomInputBinding8 = this.inputBinding;
        if (activityCustomInputBinding8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding8 = null;
        }
        activityCustomInputBinding8.btnSave.setOnClickListener(new CustomInputActivity$$ExternalSyntheticLambda1(this));
        ActivityCustomInputBinding activityCustomInputBinding9 = this.inputBinding;
        if (activityCustomInputBinding9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding9 = null;
        }
        activityCustomInputBinding9.editText.requestFocus();
        int intExtra = getIntent().getIntExtra(EXTRA_MAX_LENGTH, 0);
        if (intExtra > 0) {
            ActivityCustomInputBinding activityCustomInputBinding10 = this.inputBinding;
            if (activityCustomInputBinding10 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            } else {
                activityCustomInputBinding2 = activityCustomInputBinding10;
            }
            TextInputEditText textInputEditText2 = activityCustomInputBinding2.editText;
            InputFilter[] filters = textInputEditText2.getFilters();
            Intrinsics.checkNotNullExpressionValue(filters, "getFilters(...)");
            textInputEditText2.setFilters((InputFilter[]) ArraysKt.plus((T[]) (Object[]) filters, new InputFilter.LengthFilter(intExtra)));
        }
    }

    /* access modifiers changed from: private */
    public static final void bindView$lambda$1(CustomInputActivity customInputActivity, View view) {
        customInputActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void bindView$lambda$3(CustomInputActivity customInputActivity, View view) {
        ActivityCustomInputBinding activityCustomInputBinding = customInputActivity.inputBinding;
        if (activityCustomInputBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("inputBinding");
            activityCustomInputBinding = null;
        }
        String valueOf = String.valueOf(activityCustomInputBinding.editText.getText());
        Intent intent = new Intent();
        intent.putExtra(EXTRA_INPUT, valueOf);
        Unit unit = Unit.INSTANCE;
        customInputActivity.setResult(-1, intent);
        customInputActivity.finish();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JA\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/blueair/devicedetails/activity/CustomInputActivity$Companion;", "", "<init>", "()V", "EXTRA_HINT", "", "EXTRA_TITLE", "EXTRA_INITIAL_VALUE", "EXTRA_INPUT", "EXTRA_MAX_LENGTH", "getLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "screenName", "title", "hint", "initialValue", "maxLength", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)Landroid/content/Intent;", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: CustomInputActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ Intent getLaunchIntent$default(Companion companion, Context context, String str, String str2, String str3, String str4, Integer num, int i, Object obj) {
            if ((i & 32) != 0) {
                num = null;
            }
            return companion.getLaunchIntent(context, str, str2, str3, str4, num);
        }

        public final Intent getLaunchIntent(Context context, String str, String str2, String str3, String str4, Integer num) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str2, "title");
            Intrinsics.checkNotNullParameter(str3, ViewHierarchyConstants.HINT_KEY);
            Intrinsics.checkNotNullParameter(str4, "initialValue");
            Intent intent = new Intent(context, CustomInputActivity.class);
            intent.putExtra("screen_name", str);
            intent.putExtra(CustomInputActivity.EXTRA_HINT, str3);
            intent.putExtra(CustomInputActivity.EXTRA_TITLE, str2);
            intent.putExtra(CustomInputActivity.EXTRA_INITIAL_VALUE, str4);
            intent.putExtra(CustomInputActivity.EXTRA_MAX_LENGTH, num);
            return intent;
        }
    }
}
