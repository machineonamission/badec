package com.blueair.android.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.util.TypedValueCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.bin.david.form.core.SmartTable;
import com.bin.david.form.core.TableConfig;
import com.bin.david.form.data.format.bg.BaseBackgroundFormat;
import com.bin.david.form.data.style.FontStyle;
import com.bin.david.form.data.style.LineStyle;
import com.blueair.android.R;
import com.blueair.android.databinding.ActivityInfoDetailBinding;
import com.blueair.core.model.AnalyticEvent;
import com.blueair.core.model.I18nConfig;
import com.blueair.core.model.UserInfoCollectionGroup;
import com.blueair.core.model.UserInfoCollectionItem;
import com.blueair.core.model.UserInfoCollectionRecord;
import com.blueair.core.util.UserInfoCollectionsManager;
import com.blueair.graph.view.GraphView;
import com.blueair.viewcore.activity.BaseActivity;
import com.blueair.viewcore.activity.BaseLokaliseActivity;
import com.blueair.viewcore.dialog.DialogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;
import org.apache.commons.io.IOUtils;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0014J\u0006\u0010\u0015\u001a\u00020\u0012J\b\u0010\u0016\u001a\u00020\u0012H\u0002J\u000e\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\rH\u0002J\n\u0010\u0019\u001a\u00020\u0005*\u00020\u001aR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/blueair/android/activity/InfoDetailActivity;", "Lcom/blueair/viewcore/activity/BaseActivity;", "<init>", "()V", "screenName", "", "getScreenName", "()Ljava/lang/String;", "binding", "Lcom/blueair/android/databinding/ActivityInfoDetailBinding;", "selectedPeriodIndex", "", "periods", "", "groupId", "group", "Lcom/blueair/core/model/UserInfoCollectionGroup;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "configure", "refreshData", "loadCell", "Lcom/blueair/android/activity/InfoItemRecord;", "value", "Lcom/blueair/core/model/I18nConfig;", "Companion", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: InfoDetailActivity.kt */
public final class InfoDetailActivity extends BaseActivity {
    public static final int $stable = 8;
    public static final String ARG_GROUP_ID = "group_id";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private ActivityInfoDetailBinding binding;
    private UserInfoCollectionGroup group;
    private String groupId = "";
    private final List<String> periods = CollectionsKt.listOf("7天", "30天", "一年");
    private final String screenName = AnalyticEvent.ScreenViewEvent.SIDE_MENU_POLICY_USER_INFO_DETAILS;
    private int selectedPeriodIndex;

    /* access modifiers changed from: protected */
    public String getScreenName() {
        return this.screenName;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ViewDataBinding contentView = DataBindingUtil.setContentView(this, R.layout.activity_info_detail);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.binding = (ActivityInfoDetailBinding) contentView;
        BaseLokaliseActivity.setStatusBarColor$default(this, getColor(com.blueair.viewcore.R.color.light_sliver), (Boolean) null, 2, (Object) null);
        configure();
    }

    public final void configure() {
        ActivityInfoDetailBinding activityInfoDetailBinding;
        Object obj;
        String stringExtra;
        Intent intent = getIntent();
        if (!(intent == null || (stringExtra = intent.getStringExtra("group_id")) == null)) {
            this.groupId = stringExtra;
        }
        Iterator it = UserInfoCollectionsManager.INSTANCE.getCollections().iterator();
        while (true) {
            activityInfoDetailBinding = null;
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual((Object) ((UserInfoCollectionGroup) obj).getId(), (Object) this.groupId)) {
                break;
            }
        }
        UserInfoCollectionGroup userInfoCollectionGroup = (UserInfoCollectionGroup) obj;
        if (userInfoCollectionGroup != null) {
            this.group = userInfoCollectionGroup;
            ActivityInfoDetailBinding activityInfoDetailBinding2 = this.binding;
            if (activityInfoDetailBinding2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityInfoDetailBinding2 = null;
            }
            AppCompatTextView appCompatTextView = activityInfoDetailBinding2.tvTitle;
            UserInfoCollectionGroup userInfoCollectionGroup2 = this.group;
            if (userInfoCollectionGroup2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("group");
                userInfoCollectionGroup2 = null;
            }
            appCompatTextView.setText(I18nConfig.getValue$default(userInfoCollectionGroup2.getName(), (Locale) null, 1, (Object) null));
            ActivityInfoDetailBinding activityInfoDetailBinding3 = this.binding;
            if (activityInfoDetailBinding3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityInfoDetailBinding3 = null;
            }
            activityInfoDetailBinding3.btnBack.setOnClickListener(new InfoDetailActivity$$ExternalSyntheticLambda2(this));
            ActivityInfoDetailBinding activityInfoDetailBinding4 = this.binding;
            if (activityInfoDetailBinding4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
                activityInfoDetailBinding4 = null;
            }
            activityInfoDetailBinding4.tvPeriods.setOnClickListener(new InfoDetailActivity$$ExternalSyntheticLambda3(this));
            ActivityInfoDetailBinding activityInfoDetailBinding5 = this.binding;
            if (activityInfoDetailBinding5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("binding");
            } else {
                activityInfoDetailBinding = activityInfoDetailBinding5;
            }
            TableConfig config = activityInfoDetailBinding.tableView.getConfig();
            int roundToInt = MathKt.roundToInt(TypedValueCompat.dpToPx(1.0f, getResources().getDisplayMetrics()) * ((float) 16));
            config.setShowTableTitle(false);
            config.setShowXSequence(false);
            config.setShowYSequence(false);
            config.setColumnTitleHorizontalPadding(roundToInt);
            config.setColumnTitleVerticalPadding(roundToInt);
            config.setHorizontalPadding(roundToInt);
            config.setVerticalPadding(roundToInt);
            config.setContentBackground(new BaseBackgroundFormat(-1));
            Context context = this;
            config.setContentGridStyle(new LineStyle(context, 1.0f, getColor(com.blueair.viewcore.R.color.surface_dark_10)));
            config.setColumnTitleGridStyle(config.getContentGridStyle());
            config.setSequenceGridStyle(config.getContentGridStyle());
            config.setColumnTitleStyle(new FontStyle(context, 14, getColor(com.blueair.viewcore.R.color.colorPrimaryText)));
            config.setContentStyle(new FontStyle(context, 14, getColor(com.blueair.viewcore.R.color.surface_dark_65)));
            refreshData();
        }
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$2(InfoDetailActivity infoDetailActivity, View view) {
        infoDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void configure$lambda$4(InfoDetailActivity infoDetailActivity, View view) {
        DialogUtils dialogUtils = DialogUtils.INSTANCE;
        ActivityInfoDetailBinding activityInfoDetailBinding = infoDetailActivity.binding;
        if (activityInfoDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInfoDetailBinding = null;
        }
        TextView textView = activityInfoDetailBinding.tvPeriods;
        Intrinsics.checkNotNullExpressionValue(textView, "tvPeriods");
        DialogUtils.showDropDownList$default(dialogUtils, textView, infoDetailActivity.periods, 0, 0, 0, 0, false, new InfoDetailActivity$$ExternalSyntheticLambda1(infoDetailActivity), 124, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final Unit configure$lambda$4$lambda$3(InfoDetailActivity infoDetailActivity, int i, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        if (i != infoDetailActivity.selectedPeriodIndex) {
            infoDetailActivity.selectedPeriodIndex = i;
            infoDetailActivity.refreshData();
        }
        return Unit.INSTANCE;
    }

    private final void refreshData() {
        ActivityInfoDetailBinding activityInfoDetailBinding = this.binding;
        ActivityInfoDetailBinding activityInfoDetailBinding2 = null;
        if (activityInfoDetailBinding == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
            activityInfoDetailBinding = null;
        }
        activityInfoDetailBinding.tvPeriods.setText(this.periods.get(this.selectedPeriodIndex));
        ActivityInfoDetailBinding activityInfoDetailBinding3 = this.binding;
        if (activityInfoDetailBinding3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("binding");
        } else {
            activityInfoDetailBinding2 = activityInfoDetailBinding3;
        }
        SmartTable smartTable = activityInfoDetailBinding2.tableView;
        smartTable.setData(loadCell());
        smartTable.invalidate();
    }

    private final List<InfoItemRecord> loadCell() {
        String str;
        String str2;
        List<InfoItemRecord> arrayList = new ArrayList<>();
        int i = this.selectedPeriodIndex;
        long currentTimeMillis = System.currentTimeMillis() - (i != 0 ? i != 1 ? 31536000000L : 2592000000L : GraphView.ONE_WEEK_IN_MILLIS);
        UserInfoCollectionGroup userInfoCollectionGroup = this.group;
        if (userInfoCollectionGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("group");
            userInfoCollectionGroup = null;
        }
        for (UserInfoCollectionItem userInfoCollectionItem : userInfoCollectionGroup.getItems()) {
            Iterable<UserInfoCollectionRecord> records = userInfoCollectionItem.getRecords();
            int i2 = 0;
            if (!(records instanceof Collection) || !((Collection) records).isEmpty()) {
                for (UserInfoCollectionRecord time : records) {
                    if (time.getTime() >= currentTimeMillis && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            if (i2 == userInfoCollectionItem.getRecords().size()) {
                i2 += userInfoCollectionItem.getOmitted();
            }
            Collection arrayList2 = new ArrayList();
            for (Object next : userInfoCollectionItem.getRecords()) {
                if (((UserInfoCollectionRecord) next).getValue().length() > 0) {
                    arrayList2.add(next);
                }
            }
            List list = (List) arrayList2;
            if (list.isEmpty()) {
                str = "/";
            } else {
                String joinToString$default = CollectionsKt.joinToString$default(CollectionsKt.takeLast(list, 2), IOUtils.LINE_SEPARATOR_UNIX, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new InfoDetailActivity$$ExternalSyntheticLambda0(), 30, (Object) null);
                if (list.size() > 2) {
                    str = joinToString$default + "\n......";
                } else {
                    str = joinToString$default;
                }
            }
            String str3 = str;
            String value = value(userInfoCollectionItem.getName());
            String value2 = value(userInfoCollectionItem.getScenario());
            String value3 = value(userInfoCollectionItem.getUsage());
            if (i2 > 0) {
                str2 = "已收集" + i2 + 27425;
            } else {
                str2 = "未收集";
            }
            arrayList.add(new InfoItemRecord(value, value2, value3, str2, str3));
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final CharSequence loadCell$lambda$12$lambda$10(UserInfoCollectionRecord userInfoCollectionRecord) {
        Intrinsics.checkNotNullParameter(userInfoCollectionRecord, "it");
        String value = userInfoCollectionRecord.getValue();
        if (value.length() >= 4) {
            value = StringsKt.take(value, 2) + "***" + StringsKt.takeLast(value, 2);
        }
        return value;
    }

    public final String value(I18nConfig i18nConfig) {
        Intrinsics.checkNotNullParameter(i18nConfig, "<this>");
        String value$default = I18nConfig.getValue$default(i18nConfig, (Locale) null, 1, (Object) null);
        return value$default == null ? "/" : value$default;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/blueair/android/activity/InfoDetailActivity$Companion;", "", "<init>", "()V", "ARG_GROUP_ID", "", "launch", "", "context", "Landroid/content/Context;", "groupId", "app_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: InfoDetailActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void launch(Context context, String str) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, "groupId");
            Intent intent = new Intent(context, InfoDetailActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("group_id", str);
            context.startActivity(intent);
        }
    }
}
