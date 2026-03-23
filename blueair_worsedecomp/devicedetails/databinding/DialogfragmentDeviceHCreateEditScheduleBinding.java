package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.google.android.material.button.MaterialButton;

public final class DialogfragmentDeviceHCreateEditScheduleBinding implements ViewBinding {
    public final ImageButton backBtn;
    public final View bottomSpace;
    public final CheckBox cbFri;
    public final CheckBox cbMon;
    public final CheckBox cbSat;
    public final CheckBox cbSun;
    public final CheckBox cbThu;
    public final CheckBox cbTue;
    public final CheckBox cbWed;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout contentContainerActive;
    public final ConstraintLayout daysList;
    public final MaterialButton deleteBtn;
    public final Guideline endGuideline;
    public final ImageView endIcon;
    public final ImageView endMainModeIcon;
    public final LinearLayout endTimeGroup;
    public final TextView endTimeValue;
    public final TextView endTitle;
    public final ProgressBlockerView progressView;
    private final FrameLayout rootView;
    public final MaterialButton saveBtn;
    public final EditText scheduleName;
    public final TextView scheduleRepeat;
    public final SwitchCompat scheduleSwitchBtn;
    public final TextView setDays;
    public final TextView setName;
    public final TextView setTime;
    public final TextView settings;
    public final ConstraintLayout settingsEnd;
    public final ConstraintLayout settingsStart;
    public final Guideline startGuideline;
    public final ImageView startIcon;
    public final ImageView startMainModeIcon;
    public final LinearLayout startTimeGroup;
    public final TextView startTimeValue;
    public final TextView startTitle;
    public final TextView timezoneLabel;
    public final TextView timezoneValue;
    public final TextView title;

    private DialogfragmentDeviceHCreateEditScheduleBinding(FrameLayout frameLayout, ImageButton imageButton, View view, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, MaterialButton materialButton, Guideline guideline, ImageView imageView, ImageView imageView2, LinearLayout linearLayout, TextView textView, TextView textView2, ProgressBlockerView progressBlockerView, MaterialButton materialButton2, EditText editText, TextView textView3, SwitchCompat switchCompat, TextView textView4, TextView textView5, TextView textView6, TextView textView7, ConstraintLayout constraintLayout4, ConstraintLayout constraintLayout5, Guideline guideline2, ImageView imageView3, ImageView imageView4, LinearLayout linearLayout2, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12) {
        this.rootView = frameLayout;
        this.backBtn = imageButton;
        this.bottomSpace = view;
        this.cbFri = checkBox;
        this.cbMon = checkBox2;
        this.cbSat = checkBox3;
        this.cbSun = checkBox4;
        this.cbThu = checkBox5;
        this.cbTue = checkBox6;
        this.cbWed = checkBox7;
        this.contentContainer = constraintLayout;
        this.contentContainerActive = constraintLayout2;
        this.daysList = constraintLayout3;
        this.deleteBtn = materialButton;
        this.endGuideline = guideline;
        this.endIcon = imageView;
        this.endMainModeIcon = imageView2;
        this.endTimeGroup = linearLayout;
        this.endTimeValue = textView;
        this.endTitle = textView2;
        this.progressView = progressBlockerView;
        this.saveBtn = materialButton2;
        this.scheduleName = editText;
        this.scheduleRepeat = textView3;
        this.scheduleSwitchBtn = switchCompat;
        this.setDays = textView4;
        this.setName = textView5;
        this.setTime = textView6;
        this.settings = textView7;
        this.settingsEnd = constraintLayout4;
        this.settingsStart = constraintLayout5;
        this.startGuideline = guideline2;
        this.startIcon = imageView3;
        this.startMainModeIcon = imageView4;
        this.startTimeGroup = linearLayout2;
        this.startTimeValue = textView8;
        this.startTitle = textView9;
        this.timezoneLabel = textView10;
        this.timezoneValue = textView11;
        this.title = textView12;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceHCreateEditScheduleBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceHCreateEditScheduleBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_h_create_edit_schedule, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000d, code lost:
        r1 = com.blueair.devicedetails.R.id.bottom_space;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding bind(android.view.View r44) {
        /*
            r0 = r44
            int r1 = com.blueair.devicedetails.R.id.back_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            android.widget.ImageButton r5 = (android.widget.ImageButton) r5
            if (r5 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.bottom_space
            android.view.View r6 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r6 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_fri
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.CheckBox r7 = (android.widget.CheckBox) r7
            if (r7 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_mon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            android.widget.CheckBox r8 = (android.widget.CheckBox) r8
            if (r8 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_sat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.CheckBox r9 = (android.widget.CheckBox) r9
            if (r9 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_sun
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.CheckBox r10 = (android.widget.CheckBox) r10
            if (r10 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_thu
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.CheckBox r11 = (android.widget.CheckBox) r11
            if (r11 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_tue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            if (r12 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.cb_wed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.CheckBox r13 = (android.widget.CheckBox) r13
            if (r13 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            androidx.constraintlayout.widget.ConstraintLayout r14 = (androidx.constraintlayout.widget.ConstraintLayout) r14
            if (r14 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.content_container_active
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            androidx.constraintlayout.widget.ConstraintLayout r15 = (androidx.constraintlayout.widget.ConstraintLayout) r15
            if (r15 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.days_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            androidx.constraintlayout.widget.ConstraintLayout r16 = (androidx.constraintlayout.widget.ConstraintLayout) r16
            if (r16 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.delete_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            com.google.android.material.button.MaterialButton r17 = (com.google.android.material.button.MaterialButton) r17
            if (r17 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.end_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.constraintlayout.widget.Guideline r18 = (androidx.constraintlayout.widget.Guideline) r18
            if (r18 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.end_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.ImageView r19 = (android.widget.ImageView) r19
            if (r19 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.end_main_mode_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.ImageView r20 = (android.widget.ImageView) r20
            if (r20 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.end_time_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r21 = r2
            android.widget.LinearLayout r21 = (android.widget.LinearLayout) r21
            if (r21 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.end_time_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            android.widget.TextView r22 = (android.widget.TextView) r22
            if (r22 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.end_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            android.widget.TextView r23 = (android.widget.TextView) r23
            if (r23 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.progress_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            com.blueair.viewcore.view.ProgressBlockerView r24 = (com.blueair.viewcore.view.ProgressBlockerView) r24
            if (r24 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.save_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            com.google.android.material.button.MaterialButton r25 = (com.google.android.material.button.MaterialButton) r25
            if (r25 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.schedule_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            android.widget.EditText r26 = (android.widget.EditText) r26
            if (r26 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.schedule_repeat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.schedule_switch_btn
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            com.blueair.viewcore.view.SwitchCompat r28 = (com.blueair.viewcore.view.SwitchCompat) r28
            if (r28 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.set_days
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            android.widget.TextView r29 = (android.widget.TextView) r29
            if (r29 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.set_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.TextView r30 = (android.widget.TextView) r30
            if (r30 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.set_time
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            android.widget.TextView r31 = (android.widget.TextView) r31
            if (r31 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.settings
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            android.widget.TextView r32 = (android.widget.TextView) r32
            if (r32 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.settings_end
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            androidx.constraintlayout.widget.ConstraintLayout r33 = (androidx.constraintlayout.widget.ConstraintLayout) r33
            if (r33 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.settings_start
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            androidx.constraintlayout.widget.ConstraintLayout r34 = (androidx.constraintlayout.widget.ConstraintLayout) r34
            if (r34 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.start_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            androidx.constraintlayout.widget.Guideline r35 = (androidx.constraintlayout.widget.Guideline) r35
            if (r35 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.start_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            android.widget.ImageView r36 = (android.widget.ImageView) r36
            if (r36 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.start_main_mode_icon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            android.widget.ImageView r37 = (android.widget.ImageView) r37
            if (r37 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.start_time_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r38 = r2
            android.widget.LinearLayout r38 = (android.widget.LinearLayout) r38
            if (r38 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.start_time_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r39 = r2
            android.widget.TextView r39 = (android.widget.TextView) r39
            if (r39 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.start_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r40 = r2
            android.widget.TextView r40 = (android.widget.TextView) r40
            if (r40 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.timezone_label
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r41 = r2
            android.widget.TextView r41 = (android.widget.TextView) r41
            if (r41 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.timezone_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r42 = r2
            android.widget.TextView r42 = (android.widget.TextView) r42
            if (r42 == 0) goto L_0x01d1
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r43 = r2
            android.widget.TextView r43 = (android.widget.TextView) r43
            if (r43 == 0) goto L_0x01d1
            com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding r3 = new com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding
            r4 = r0
            android.widget.FrameLayout r4 = (android.widget.FrameLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43)
            return r3
        L_0x01d1:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding.bind(android.view.View):com.blueair.devicedetails.databinding.DialogfragmentDeviceHCreateEditScheduleBinding");
    }
}
