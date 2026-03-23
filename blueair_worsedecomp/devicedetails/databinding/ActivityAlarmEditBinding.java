package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.helper.widget.Flow;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.AccessibleSeekBar;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.blueair.viewcore.view.SwitchCompat;
import com.dd.ShadowLayout;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ActivityAlarmEditBinding implements ViewBinding {
    public final TextInputEditText alarmName;
    public final LinearLayout bottomBar;
    public final ImageButton btnBack;
    public final MaterialButton btnCancel;
    public final Button btnCloseHint;
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
    public final View clickViewSound;
    public final ConstraintLayout contentContainer;
    public final Guideline endGuideline;
    public final Flow flowDayOfWeek;
    public final Flow flowRepeat;
    public final ConstraintLayout hintContainer;
    public final TextView hintText;
    public final ImageView icVolume;
    public final TextInputLayout inputDeviceName;
    public final FrameLayout offlineContainer;
    public final ProgressBlockerView progressView;
    public final Group ringtoneContent;
    public final ShadowLayout ringtoneGroup;
    public final SwitchCompat ringtoneSwitch;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollView;
    public final AccessibleSeekBar seekbarDuration;
    public final AccessibleSeekBar seekbarVolume;
    public final View separator;
    public final View separator1;
    public final View separator2;
    public final View separator3;
    public final View separatorEnd;
    public final View separatorStart;
    public final TextView setDays;
    public final ShadowLayout setTimeGroup;
    public final Guideline startGuideline;
    public final Group sunriseContent;
    public final ShadowLayout sunriseGroup;
    public final SwitchCompat sunriseSwitch;
    public final AppCompatTextView timeValue;
    public final TextView title;
    public final FrameLayout titleBar;
    public final TextView tvDurationValue;
    public final TextView tvProgress0;
    public final TextView tvProgress100;
    public final TextView tvRingtone;
    public final TextView tvSound;
    public final TextView tvSoundValue;
    public final TextView tvSunriseDuration;
    public final TextView tvSunriseLight;
    public final TextView tvVolume;
    public final TextView tvVolumeValue;

    private ActivityAlarmEditBinding(ConstraintLayout constraintLayout, TextInputEditText textInputEditText, LinearLayout linearLayout, ImageButton imageButton, MaterialButton materialButton, Button button, MaterialButton materialButton2, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, CheckBox checkBox4, CheckBox checkBox5, CheckBox checkBox6, CheckBox checkBox7, CheckBox checkBox8, CheckBox checkBox9, CheckBox checkBox10, View view, ConstraintLayout constraintLayout2, Guideline guideline, Flow flow, Flow flow2, ConstraintLayout constraintLayout3, TextView textView, ImageView imageView, TextInputLayout textInputLayout, FrameLayout frameLayout, ProgressBlockerView progressBlockerView, Group group, ShadowLayout shadowLayout, SwitchCompat switchCompat, NestedScrollView nestedScrollView, AccessibleSeekBar accessibleSeekBar, AccessibleSeekBar accessibleSeekBar2, View view2, View view3, View view4, View view5, View view6, View view7, TextView textView2, ShadowLayout shadowLayout2, Guideline guideline2, Group group2, ShadowLayout shadowLayout3, SwitchCompat switchCompat2, AppCompatTextView appCompatTextView, TextView textView3, FrameLayout frameLayout2, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13) {
        this.rootView = constraintLayout;
        this.alarmName = textInputEditText;
        this.bottomBar = linearLayout;
        this.btnBack = imageButton;
        this.btnCancel = materialButton;
        this.btnCloseHint = button;
        this.btnSaveChange = materialButton2;
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
        this.clickViewSound = view;
        this.contentContainer = constraintLayout2;
        this.endGuideline = guideline;
        this.flowDayOfWeek = flow;
        this.flowRepeat = flow2;
        this.hintContainer = constraintLayout3;
        this.hintText = textView;
        this.icVolume = imageView;
        this.inputDeviceName = textInputLayout;
        this.offlineContainer = frameLayout;
        this.progressView = progressBlockerView;
        this.ringtoneContent = group;
        this.ringtoneGroup = shadowLayout;
        this.ringtoneSwitch = switchCompat;
        this.scrollView = nestedScrollView;
        this.seekbarDuration = accessibleSeekBar;
        this.seekbarVolume = accessibleSeekBar2;
        this.separator = view2;
        this.separator1 = view3;
        this.separator2 = view4;
        this.separator3 = view5;
        this.separatorEnd = view6;
        this.separatorStart = view7;
        this.setDays = textView2;
        this.setTimeGroup = shadowLayout2;
        this.startGuideline = guideline2;
        this.sunriseContent = group2;
        this.sunriseGroup = shadowLayout3;
        this.sunriseSwitch = switchCompat2;
        this.timeValue = appCompatTextView;
        this.title = textView3;
        this.titleBar = frameLayout2;
        this.tvDurationValue = textView4;
        this.tvProgress0 = textView5;
        this.tvProgress100 = textView6;
        this.tvRingtone = textView7;
        this.tvSound = textView8;
        this.tvSoundValue = textView9;
        this.tvSunriseDuration = textView10;
        this.tvSunriseLight = textView11;
        this.tvVolume = textView12;
        this.tvVolumeValue = textView13;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static ActivityAlarmEditBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static ActivityAlarmEditBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.activity_alarm_edit, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        r1 = com.blueair.devicedetails.R.id.click_view_sound;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x017f, code lost:
        r1 = com.blueair.devicedetails.R.id.separator;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0187, code lost:
        r1 = com.blueair.devicedetails.R.id.separator1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x018f, code lost:
        r1 = com.blueair.devicedetails.R.id.separator2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0197, code lost:
        r1 = com.blueair.devicedetails.R.id.separator3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x019f, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x01a7, code lost:
        r1 = com.blueair.devicedetails.R.id.separator_start;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.ActivityAlarmEditBinding bind(android.view.View r63) {
        /*
            r0 = r63
            int r1 = com.blueair.devicedetails.R.id.alarm_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            com.google.android.material.textfield.TextInputEditText r5 = (com.google.android.material.textfield.TextInputEditText) r5
            if (r5 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.bottom_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            android.widget.LinearLayout r6 = (android.widget.LinearLayout) r6
            if (r6 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.btn_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            android.widget.ImageButton r7 = (android.widget.ImageButton) r7
            if (r7 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.btn_cancel
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            com.google.android.material.button.MaterialButton r8 = (com.google.android.material.button.MaterialButton) r8
            if (r8 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.btn_close_hint
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.Button r9 = (android.widget.Button) r9
            if (r9 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.btn_saveChange
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            com.google.android.material.button.MaterialButton r10 = (com.google.android.material.button.MaterialButton) r10
            if (r10 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_everyday
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.CheckBox r11 = (android.widget.CheckBox) r11
            if (r11 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_fri
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r12 = r2
            android.widget.CheckBox r12 = (android.widget.CheckBox) r12
            if (r12 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_mon
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.CheckBox r13 = (android.widget.CheckBox) r13
            if (r13 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_sat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.CheckBox r14 = (android.widget.CheckBox) r14
            if (r14 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_sun
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.CheckBox r15 = (android.widget.CheckBox) r15
            if (r15 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_thu
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r16 = r2
            android.widget.CheckBox r16 = (android.widget.CheckBox) r16
            if (r16 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_tue
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            android.widget.CheckBox r17 = (android.widget.CheckBox) r17
            if (r17 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_wed
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            android.widget.CheckBox r18 = (android.widget.CheckBox) r18
            if (r18 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_weekdays
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            android.widget.CheckBox r19 = (android.widget.CheckBox) r19
            if (r19 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.cb_weekends
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            android.widget.CheckBox r20 = (android.widget.CheckBox) r20
            if (r20 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.click_view_sound
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r22 = r2
            androidx.constraintlayout.widget.ConstraintLayout r22 = (androidx.constraintlayout.widget.ConstraintLayout) r22
            if (r22 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.end_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r23 = r2
            androidx.constraintlayout.widget.Guideline r23 = (androidx.constraintlayout.widget.Guideline) r23
            if (r23 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.flow_dayOfWeek
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r24 = r2
            androidx.constraintlayout.helper.widget.Flow r24 = (androidx.constraintlayout.helper.widget.Flow) r24
            if (r24 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.flow_repeat
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r25 = r2
            androidx.constraintlayout.helper.widget.Flow r25 = (androidx.constraintlayout.helper.widget.Flow) r25
            if (r25 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.hint_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r26 = r2
            androidx.constraintlayout.widget.ConstraintLayout r26 = (androidx.constraintlayout.widget.ConstraintLayout) r26
            if (r26 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.hint_text
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r27 = r2
            android.widget.TextView r27 = (android.widget.TextView) r27
            if (r27 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.ic_volume
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r28 = r2
            android.widget.ImageView r28 = (android.widget.ImageView) r28
            if (r28 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.input_deviceName
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r29 = r2
            com.google.android.material.textfield.TextInputLayout r29 = (com.google.android.material.textfield.TextInputLayout) r29
            if (r29 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.offline_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r30 = r2
            android.widget.FrameLayout r30 = (android.widget.FrameLayout) r30
            if (r30 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.progress_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r31 = r2
            com.blueair.viewcore.view.ProgressBlockerView r31 = (com.blueair.viewcore.view.ProgressBlockerView) r31
            if (r31 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.ringtone_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r32 = r2
            androidx.constraintlayout.widget.Group r32 = (androidx.constraintlayout.widget.Group) r32
            if (r32 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.ringtone_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r33 = r2
            com.dd.ShadowLayout r33 = (com.dd.ShadowLayout) r33
            if (r33 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.ringtone_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r34 = r2
            com.blueair.viewcore.view.SwitchCompat r34 = (com.blueair.viewcore.view.SwitchCompat) r34
            if (r34 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.scroll_view
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r35 = r2
            androidx.core.widget.NestedScrollView r35 = (androidx.core.widget.NestedScrollView) r35
            if (r35 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.seekbar_duration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r36 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r36 = (com.blueair.viewcore.view.AccessibleSeekBar) r36
            if (r36 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.seekbar_volume
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r37 = r2
            com.blueair.viewcore.view.AccessibleSeekBar r37 = (com.blueair.viewcore.view.AccessibleSeekBar) r37
            if (r37 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.separator
            android.view.View r38 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r38 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.separator1
            android.view.View r39 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r39 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.separator2
            android.view.View r40 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r40 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.separator3
            android.view.View r41 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r41 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.separator_end
            android.view.View r42 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r42 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.separator_start
            android.view.View r43 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r43 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.set_days
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r44 = r2
            android.widget.TextView r44 = (android.widget.TextView) r44
            if (r44 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.set_time_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r45 = r2
            com.dd.ShadowLayout r45 = (com.dd.ShadowLayout) r45
            if (r45 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.start_guideline
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r46 = r2
            androidx.constraintlayout.widget.Guideline r46 = (androidx.constraintlayout.widget.Guideline) r46
            if (r46 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.sunrise_content
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r47 = r2
            androidx.constraintlayout.widget.Group r47 = (androidx.constraintlayout.widget.Group) r47
            if (r47 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.sunrise_group
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r48 = r2
            com.dd.ShadowLayout r48 = (com.dd.ShadowLayout) r48
            if (r48 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.sunrise_switch
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r49 = r2
            com.blueair.viewcore.view.SwitchCompat r49 = (com.blueair.viewcore.view.SwitchCompat) r49
            if (r49 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.time_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r50 = r2
            androidx.appcompat.widget.AppCompatTextView r50 = (androidx.appcompat.widget.AppCompatTextView) r50
            if (r50 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r51 = r2
            android.widget.TextView r51 = (android.widget.TextView) r51
            if (r51 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r52 = r2
            android.widget.FrameLayout r52 = (android.widget.FrameLayout) r52
            if (r52 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_duration_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r53 = r2
            android.widget.TextView r53 = (android.widget.TextView) r53
            if (r53 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_progress_0
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r54 = r2
            android.widget.TextView r54 = (android.widget.TextView) r54
            if (r54 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_progress_100
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r55 = r2
            android.widget.TextView r55 = (android.widget.TextView) r55
            if (r55 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_ringtone
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r56 = r2
            android.widget.TextView r56 = (android.widget.TextView) r56
            if (r56 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_sound
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r57 = r2
            android.widget.TextView r57 = (android.widget.TextView) r57
            if (r57 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_sound_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r58 = r2
            android.widget.TextView r58 = (android.widget.TextView) r58
            if (r58 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_sunrise_duration
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r59 = r2
            android.widget.TextView r59 = (android.widget.TextView) r59
            if (r59 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_sunrise_light
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r60 = r2
            android.widget.TextView r60 = (android.widget.TextView) r60
            if (r60 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_volume
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r61 = r2
            android.widget.TextView r61 = (android.widget.TextView) r61
            if (r61 == 0) goto L_0x029c
            int r1 = com.blueair.devicedetails.R.id.tv_volume_value
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r62 = r2
            android.widget.TextView r62 = (android.widget.TextView) r62
            if (r62 == 0) goto L_0x029c
            com.blueair.devicedetails.databinding.ActivityAlarmEditBinding r3 = new com.blueair.devicedetails.databinding.ActivityAlarmEditBinding
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44, r45, r46, r47, r48, r49, r50, r51, r52, r53, r54, r55, r56, r57, r58, r59, r60, r61, r62)
            return r3
        L_0x029c:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.ActivityAlarmEditBinding.bind(android.view.View):com.blueair.devicedetails.databinding.ActivityAlarmEditBinding");
    }
}
