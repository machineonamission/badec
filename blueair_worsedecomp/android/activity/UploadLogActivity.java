package com.blueair.android.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.ComponentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelLazy;
import com.blueair.android.databinding.ActivityUploadLogBinding;
import com.blueair.android.viewmodel.DevSettingsViewModel;
import com.blueair.core.FileNames;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.IssueType;
import com.blueair.core.model.LogLength;
import com.blueair.viewcore.R;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.dialog.DialogUtils;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0014J\b\u0010\u0014\u001a\u00020\u0011H\u0002J\b\u0010\u0015\u001a\u00020\u0011H\u0014R\u0014\u0010\u0004\u001a\u00020\u0005XD¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lcom/blueair/android/activity/UploadLogActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityUploadLogBinding;", "viewModel", "Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "getViewModel", "()Lcom/blueair/android/viewmodel/DevSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "refreshLogFileSize", "onDestroy", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: UploadLogActivity.kt */
public final class UploadLogActivity extends BaseActivity {
    public static final int $stable = 8;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityUploadLogBinding binding;
    private final String screenName = AnalyticEvent.ScreenViewEvent.UPLOAD_LOG;
    private final Lazy viewModel$delegate;

    public UploadLogActivity() {
        ComponentActivity componentActivity = this;
        this.viewModel$delegate = new ViewModelLazy(Reflection.getOrCreateKotlinClass(DevSettingsViewModel.class), new UploadLogActivity$special$$inlined$viewModels$default$2(componentActivity), new UploadLogActivity$special$$inlined$viewModels$default$1(componentActivity), new UploadLogActivity$special$$inlined$viewModels$default$3((Function0) null, componentActivity));
    }

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: private */
    public final DevSettingsViewModel getViewModel() {
        return (DevSettingsViewModel) this.viewModel$delegate.getValue();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ActivityUploadLogBinding inflate = ActivityUploadLogBinding.inflate(getLayoutInflater());
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        this.binding = inflate;
        ActivityUploadLogBinding activityUploadLogBinding = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            inflate = null;
        }
        setContentView((View) inflate.getRoot());
        setStatusMode(true);
        ActivityUploadLogBinding activityUploadLogBinding2 = this.binding;
        if (activityUploadLogBinding2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityUploadLogBinding = activityUploadLogBinding2;
        }
        activityUploadLogBinding.btnBack.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda2(this));
        activityUploadLogBinding.dropdownIssueType.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda3(activityUploadLogBinding));
        activityUploadLogBinding.dropdownLength.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda4(activityUploadLogBinding));
        activityUploadLogBinding.btnUpload.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda5(activityUploadLogBinding, this));
        LifecycleOwner lifecycleOwner = this;
        getViewModel().getLiveLogUploadProgress().observe(lifecycleOwner, new UploadLogActivity$sam$androidx_lifecycle_Observer$0(new UploadLogActivity$$ExternalSyntheticLambda6(activityUploadLogBinding, this)));
        getViewModel().getLiveLogUploadError().observe(lifecycleOwner, new UploadLogActivity$sam$androidx_lifecycle_Observer$0(new UploadLogActivity$$ExternalSyntheticLambda7(activityUploadLogBinding, this)));
        activityUploadLogBinding.etMaxLogSize.setText(String.valueOf(getViewModel().getMaxLogFileSizeInMB()));
        EditText editText = activityUploadLogBinding.etMaxLogSize;
        Intrinsics.checkNotNullExpressionValue(editText, "etMaxLogSize");
        editText.addTextChangedListener(new UploadLogActivity$onCreate$lambda$16$$inlined$doAfterTextChanged$1(this));
        activityUploadLogBinding.btnClear.setOnClickListener(new UploadLogActivity$$ExternalSyntheticLambda8(this));
        refreshLogFileSize();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$16$lambda$0(UploadLogActivity uploadLogActivity, View view) {
        uploadLogActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$16$lambda$3(ActivityUploadLogBinding activityUploadLogBinding, View view) {
        DialogUtils dialogUtils = DialogUtils.INSTANCE;
        TextView textView = activityUploadLogBinding.dropdownIssueType;
        Intrinsics.checkNotNullExpressionValue(textView, "dropdownIssueType");
        View view2 = textView;
        Iterable<IssueType> entries = IssueType.getEntries();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        for (IssueType value : entries) {
            arrayList.add(value.getValue());
        }
        DialogUtils.showDropDownList$default(dialogUtils, view2, (List) arrayList, 0, 0, 0, 0, false, new UploadLogActivity$$ExternalSyntheticLambda1(activityUploadLogBinding), 124, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$16$lambda$3$lambda$2(ActivityUploadLogBinding activityUploadLogBinding, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "v");
        activityUploadLogBinding.dropdownIssueType.setText(str);
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$16$lambda$6(ActivityUploadLogBinding activityUploadLogBinding, View view) {
        DialogUtils dialogUtils = DialogUtils.INSTANCE;
        TextView textView = activityUploadLogBinding.dropdownLength;
        Intrinsics.checkNotNullExpressionValue(textView, "dropdownLength");
        View view2 = textView;
        Iterable<LogLength> entries = LogLength.getEntries();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(entries, 10));
        for (LogLength value : entries) {
            arrayList.add(value.getValue());
        }
        DialogUtils.showDropDownList$default(dialogUtils, view2, (List) arrayList, 0, 0, 0, 0, false, new UploadLogActivity$$ExternalSyntheticLambda0(activityUploadLogBinding), 124, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$16$lambda$6$lambda$5(ActivityUploadLogBinding activityUploadLogBinding, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "v");
        activityUploadLogBinding.dropdownLength.setText(str);
        return Unit.INSTANCE;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: com.blueair.core.model.LogLength} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: com.blueair.core.model.LogLength} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v0, resolved type: com.blueair.core.model.LogLength} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.blueair.core.model.LogLength} */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void onCreate$lambda$16$lambda$11(com.blueair.android.databinding.ActivityUploadLogBinding r5, com.blueair.android.activity.UploadLogActivity r6, android.view.View r7) {
        /*
            com.google.android.material.button.MaterialButton r7 = r5.btnUpload
            r0 = 0
            r7.setEnabled(r0)
            android.widget.TextView r7 = r5.dropdownIssueType
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            kotlin.enums.EnumEntries r0 = com.blueair.core.model.IssueType.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x001a:
            boolean r1 = r0.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0033
            java.lang.Object r1 = r0.next()
            r3 = r1
            com.blueair.core.model.IssueType r3 = (com.blueair.core.model.IssueType) r3
            java.lang.String r3 = r3.getValue()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r7)
            if (r3 == 0) goto L_0x001a
            goto L_0x0034
        L_0x0033:
            r1 = r2
        L_0x0034:
            com.blueair.core.model.IssueType r1 = (com.blueair.core.model.IssueType) r1
            if (r1 != 0) goto L_0x003a
            com.blueair.core.model.IssueType r1 = com.blueair.core.model.IssueType.OTHER
        L_0x003a:
            android.widget.TextView r7 = r5.dropdownLength
            java.lang.CharSequence r7 = r7.getText()
            java.lang.String r7 = r7.toString()
            kotlin.enums.EnumEntries r0 = com.blueair.core.model.LogLength.getEntries()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x004e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0066
            java.lang.Object r3 = r0.next()
            r4 = r3
            com.blueair.core.model.LogLength r4 = (com.blueair.core.model.LogLength) r4
            java.lang.String r4 = r4.getValue()
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r4, (java.lang.Object) r7)
            if (r4 == 0) goto L_0x004e
            r2 = r3
        L_0x0066:
            com.blueair.core.model.LogLength r2 = (com.blueair.core.model.LogLength) r2
            if (r2 != 0) goto L_0x006c
            com.blueair.core.model.LogLength r2 = com.blueair.core.model.LogLength.M5
        L_0x006c:
            com.google.android.material.textfield.TextInputEditText r5 = r5.descriptionValue
            android.text.Editable r5 = r5.getText()
            java.lang.String r5 = java.lang.String.valueOf(r5)
            com.blueair.android.viewmodel.DevSettingsViewModel r6 = r6.getViewModel()
            r6.uploadLog(r1, r2, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.android.activity.UploadLogActivity.onCreate$lambda$16$lambda$11(com.blueair.android.databinding.ActivityUploadLogBinding, com.blueair.android.activity.UploadLogActivity, android.view.View):void");
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$16$lambda$12(ActivityUploadLogBinding activityUploadLogBinding, UploadLogActivity uploadLogActivity, Integer num) {
        if (num.intValue() > 0) {
            TextView textView = activityUploadLogBinding.tvProgress;
            Intrinsics.checkNotNullExpressionValue(textView, "tvProgress");
            ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
            activityUploadLogBinding.tvProgress.setTextColor(uploadLogActivity.getColor(R.color.colorPrimaryText));
            TextView textView2 = activityUploadLogBinding.tvProgress;
            textView2.setText(num + "% uploaded");
        }
        if (num.intValue() >= 100) {
            activityUploadLogBinding.btnUpload.setEnabled(true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final Unit onCreate$lambda$16$lambda$13(ActivityUploadLogBinding activityUploadLogBinding, UploadLogActivity uploadLogActivity, String str) {
        Intrinsics.checkNotNull(str);
        CharSequence charSequence = str;
        if (charSequence.length() > 0) {
            TextView textView = activityUploadLogBinding.tvProgress;
            Intrinsics.checkNotNullExpressionValue(textView, "tvProgress");
            ViewExtensionsKt.show$default(textView, false, 1, (Object) null);
            activityUploadLogBinding.tvProgress.setTextColor(uploadLogActivity.getColor(R.color.error_red));
            activityUploadLogBinding.tvProgress.setText(charSequence);
            activityUploadLogBinding.btnUpload.setEnabled(true);
        }
        return Unit.INSTANCE;
    }

    /* access modifiers changed from: private */
    public static final void onCreate$lambda$16$lambda$15(UploadLogActivity uploadLogActivity, View view) {
        uploadLogActivity.getViewModel().clearLogs();
        uploadLogActivity.refreshLogFileSize();
    }

    private final void refreshLogFileSize() {
        double length = ((double) (getFileStreamPath(FileNames.DEBUG_LOG).length() / ((long) 1024))) / 1024.0d;
        ActivityUploadLogBinding activityUploadLogBinding = this.binding;
        if (activityUploadLogBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityUploadLogBinding = null;
        }
        TextView textView = activityUploadLogBinding.tvCurrentLogSize;
        String format = String.format("%.2f MB", Arrays.copyOf(new Object[]{Double.valueOf(length)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        textView.setText(format);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/blueair/android/activity/UploadLogActivity$Companion;", "", "<init>", "()V", "launch", "", "context", "Landroid/content/Context;", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: UploadLogActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            context.startActivity(new Intent(context, UploadLogActivity.class));
        }
    }
}
