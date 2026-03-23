package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SimpleIconTextView;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ActivityDeviceScheduleOverviewBinding implements ViewBinding {
    public final ImageButton backBtn;
    public final LinearLayout bottomBar;
    public final MaterialButton btnCancel;
    public final MaterialButton btnLastUsed;
    public final MaterialButton btnSaveChange;
    public final CheckBox cbEveryday;
    public final CheckBox cbFri;
    public final CheckBox cbMon;
    public final CheckBox cbSat;
    public final CheckBox cbSun;
    public final CheckBox cbThu;
    public final CheckBox cbTue;
    public final CheckBox cbWed;
    public final CheckBox cbWeekdays;
    public final CheckBox cbWeekends;
    public final ConstraintLayout contentContainer;
    public final Guideline endGuideline;
    public final TextView endModeLabel;
    public final ShadowLayout endTimeGroup;
    public final TextView endTimeLabel;
    public final AppCompatTextView endTimeValue;
    public final FrameLayout flEndTime;
    public final FrameLayout flStartTime;
    public final Flow flowDayOfWeek;
    public final Flow flowRepeat;
    public final SimpleIconTextView ictvEndMode;
    public final SimpleIconTextView ictvStartMode;
    public final TextInputLayout inputDeviceName;
    public final ImageView ivEndMainMode;
    public final ImageView ivStartMainMode;
    public final LinearLayout llEndMode;
    public final ConstraintLayout llRoot;
    public final LinearLayout llStartMode;
    public final ProgressBlockerView progressView;
    private final ConstraintLayout rootView;
    public final TextInputEditText scheduleName;
    public final NestedScrollView scrollView;
    public final View separator;
    public final TextView setDays;
    public final ShadowLayout settingsEnd;
    public final ShadowLayout settingsStart;
    public final Guideline startGuideline;
    public final TextView startModeLabel;
    public final ShadowLayout startTimeGroup;
    public final TextView startTimeLabel;
    public final AppCompatTextView startTimeValue;
    public final TextView title;
    public final FrameLayout titleBar;

    private ActivityDeviceScheduleOverviewBinding(ConstraintLayout constraintLayout, ImageButton imageButton, LinearLayout linearLayout, MaterialButton materialButton, MaterialButton materialButton2, MaterialButton materialButton3, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, ConstraintLayout constraintLayout2, Guideline guideline, TextView textView, ShadowLayout shadowLayout, TextView textView2, AppCompatTextView appCompatTextView, FrameLayout frameLayout, FrameLayout frameLayout2, Flow flow, Flow flow2, SimpleIconTextView simpleIconTextView, SimpleIconTextView simpleIconTextView2, TextInputLayout textInputLayout, ImageView imageView, ImageView imageView2, LinearLayout linearLayout2, ConstraintLayout constraintLayout3, LinearLayout linearLayout3, ProgressBlockerView progressBlockerView, TextInputEditText textInputEditText, NestedScrollView nestedScrollView, View view, TextView textView3, ShadowLayout shadowLayout2, ShadowLayout shadowLayout3, Guideline guideline2, TextView textView4, ShadowLayout shadowLayout4, TextView textView5, AppCompatTextView appCompatTextView2, TextView textView6, FrameLayout frameLayout3) {
        this.rootView = constraintLayout;
        this.backBtn = imageButton;
        this.bottomBar = linearLayout;
        this.btnCancel = materialButton;
        this.btnLastUsed = materialButton2;
        this.btnSaveChange = materialButton3;
        this.cbEveryday = checkBox;
        this.cbFri = checkBox2;
        this.cbMon = checkBox3;
        this.cbSat = checkBox4;
        this.cbSun = checkBox5;
        this.cbThu = checkBox6;
        this.cbTue = checkBox7;
        this.cbWed = checkBox8;
        this.cbWeekdays = checkBox9;
        this.cbWeekends = checkBox10;
        this.contentContainer = constraintLayout2;
        this.endGuideline = guideline;
        this.endModeLabel = textView;
        this.endTimeGroup = shadowLayout;
        this.endTimeLabel = textView2;
        this.endTimeValue = appCompatTextView;
        this.flEndTime = frameLayout;
        this.flStartTime = frameLayout2;
        this.flowDayOfWeek = flow;
        this.flowRepeat = flow2;
        this.ictvEndMode = simpleIconTextView;
        this.ictvStartMode = simpleIconTextView2;
        this.inputDeviceName = textInputLayout;
        this.ivEndMainMode = imageView;
        this.ivStartMainMode = imageView2;
        this.llEndMode = linearLayout2;
        this.llRoot = constraintLayout3;
        this.llStartMode = linearLayout3;
        this.progressView = progressBlockerView;
        this.scheduleName = textInputEditText;
        this.scrollView = nestedScrollView;
        this.separator = view;
        this.setDays = textView3;
        this.settingsEnd = shadowLayout2;
        this.settingsStart = shadowLayout3;
        this.startGuideline = guideline2;
        this.startModeLabel = textView4;
        this.startTimeGroup = shadowLayout4;
        this.startTimeLabel = textView5;
        this.startTimeValue = appCompatTextView2;
        this.title = textView6;
        this.titleBar = frameLayout3;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityDeviceScheduleOverviewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityDeviceScheduleOverviewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_device_schedule_overview, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:70:0x019e, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding bind(android.view.View r52) {
        /*
            r0 = r52
            int r1 = com.blueair.devicedetails.R.id.back_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.bottom_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.btn_cancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            com.google.android.material.button.MaterialButton r7 = (com.google.android.material.button.MaterialButton) r7
            if (r7 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.btn_lastUsed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.google.android.material.button.MaterialButton r8 = (com.google.android.material.button.MaterialButton) r8
            if (r8 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.btn_saveChange
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            com.google.android.material.button.MaterialButton r9 = (com.google.android.material.button.MaterialButton) r9
            if (r9 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_everyday
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            if (r10 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_fri
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.CheckBox r11 = (android.widget.CheckBox) r11
            if (r11 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_mon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            if (r12 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_sat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.CheckBox r13 = (android.widget.CheckBox) r13
            if (r13 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_sun
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            if (r14 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_thu
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.CheckBox r15 = (android.widget.CheckBox) r15
            if (r15 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_tue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.CheckBox r16 = (android.widget.CheckBox) r16
            if (r16 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_wed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.CheckBox r17 = (android.widget.CheckBox) r17
            if (r17 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_weekdays
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.CheckBox r18 = (android.widget.CheckBox) r18
            if (r18 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.cb_weekends
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.CheckBox r19 = (android.widget.CheckBox) r19
            if (r19 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.ConstraintLayout r20 = (androidx.constraintlayout.widget.ConstraintLayout) r20
            if (r20 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.end_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            androidx.constraintlayout.widget.Guideline r21 = (androidx.constraintlayout.widget.Guideline) r21
            if (r21 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.end_mode_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.end_time_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            com.dd.ShadowLayout r23 = (com.dd.ShadowLayout) r23
            if (r23 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.end_time_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            android.widget.TextView r24 = (android.widget.TextView) r24
            if (r24 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.end_time_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            androidx.appcompat.widget.AppCompatTextView r25 = (androidx.appcompat.widget.AppCompatTextView) r25
            if (r25 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.fl_end_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.FrameLayout r26 = (android.widget.FrameLayout) r26
            if (r26 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.fl_start_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.FrameLayout r27 = (android.widget.FrameLayout) r27
            if (r27 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.flow_dayOfWeek
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            androidx.constraintlayout.helper.widget.Flow r28 = (androidx.constraintlayout.helper.widget.Flow) r28
            if (r28 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.flow_repeat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            androidx.constraintlayout.helper.widget.Flow r29 = (androidx.constraintlayout.helper.widget.Flow) r29
            if (r29 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.ictv_endMode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            com.blueair.viewcore.view.SimpleIconTextView r30 = (com.blueair.viewcore.view.SimpleIconTextView) r30
            if (r30 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.ictv_startMode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            com.blueair.viewcore.view.SimpleIconTextView r31 = (com.blueair.viewcore.view.SimpleIconTextView) r31
            if (r31 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.input_deviceName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            com.google.android.material.textfield.TextInputLayout r32 = (com.google.android.material.textfield.TextInputLayout) r32
            if (r32 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.iv_endMainMode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            android.widget.ImageView r33 = (android.widget.ImageView) r33
            if (r33 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.iv_startMainMode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            android.widget.ImageView r34 = (android.widget.ImageView) r34
            if (r34 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.ll_endMode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            android.widget.LinearLayout r35 = (android.widget.LinearLayout) r35
            if (r35 == 0) goto L_0x0226
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            int r1 = com.blueair.devicedetails.R.id.ll_startMode
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.LinearLayout r37 = (android.widget.LinearLayout) r37
            if (r37 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.progress_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            com.blueair.viewcore.view.ProgressBlockerView r38 = (com.blueair.viewcore.view.ProgressBlockerView) r38
            if (r38 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.schedule_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            com.google.android.material.textfield.TextInputEditText r39 = (com.google.android.material.textfield.TextInputEditText) r39
            if (r39 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.scroll_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            androidx.core.widget.NestedScrollView r40 = (androidx.core.widget.NestedScrollView) r40
            if (r40 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r41 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r41 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.set_days
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r42 = r2
            android.widget.TextView r42 = (android.widget.TextView) r42
            if (r42 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.settings_end
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r43 = r2
            com.dd.ShadowLayout r43 = (com.dd.ShadowLayout) r43
            if (r43 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.settings_start
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r44 = r2
            com.dd.ShadowLayout r44 = (com.dd.ShadowLayout) r44
            if (r44 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.start_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r45 = r2
            androidx.constraintlayout.widget.Guideline r45 = (androidx.constraintlayout.widget.Guideline) r45
            if (r45 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.start_mode_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r46 = r2
            android.widget.TextView r46 = (android.widget.TextView) r46
            if (r46 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.start_time_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r47 = r2
            com.dd.ShadowLayout r47 = (com.dd.ShadowLayout) r47
            if (r47 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.start_time_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r48 = r2
            android.widget.TextView r48 = (android.widget.TextView) r48
            if (r48 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.start_time_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r49 = r2
            androidx.appcompat.widget.AppCompatTextView r49 = (androidx.appcompat.widget.AppCompatTextView) r49
            if (r49 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r50 = r2
            android.widget.TextView r50 = (android.widget.TextView) r50
            if (r50 == 0) goto L_0x0226
            int r1 = com.blueair.devicedetails.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r51 = r2
            android.widget.FrameLayout r51 = (android.widget.FrameLayout) r51
            if (r51 == 0) goto L_0x0226
            com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding r3 = new com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding
            r36 = r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51)
            return r3
        L_0x0226:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding.bind(android.view.View):com.blueair.devicedetails.databinding.ActivityDeviceScheduleOverviewBinding");
    }
}
