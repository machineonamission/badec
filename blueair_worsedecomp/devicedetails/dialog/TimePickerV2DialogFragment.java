package com.blueair.devicedetails.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.os.BundleKt;
import androidx.core.util.TypedValueCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentKt;
import com.blueair.devicedetails.databinding.DialogfragmentTimePickerV2Binding;
import com.blueair.devicedetails.view.CustomWheelView;
import com.blueair.viewcore.R;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import io.flatcircle.viewhelper.ViewExtensionsKt;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.joda.time.DateTimeConstants;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0017J\b\u0010\u0017\u001a\u00020\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00102\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001b\u001a\u00020\u0018H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/blueair/devicedetails/dialog/TimePickerV2DialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/blueair/devicedetails/databinding/DialogfragmentTimePickerV2Binding;", "getBinding", "()Lcom/blueair/devicedetails/databinding/DialogfragmentTimePickerV2Binding;", "setBinding", "(Lcom/blueair/devicedetails/databinding/DialogfragmentTimePickerV2Binding;)V", "is24HourFormat", "", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onStart", "", "onViewCreated", "view", "adjustWheelTextSize", "Companion", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* compiled from: TimePickerV2DialogFragment.kt */
public final class TimePickerV2DialogFragment extends DialogFragment {
    private static final String ARG_CYCLIC_ENABLED = "ARG_CYCLIC_ENABLED";
    public static final String ARG_HOUR_OF_DAY = "ARG_HOUR_OF_DAY";
    public static final String ARG_MINUTE = "ARG_MINUTE";
    public static final String ARG_TIME_SECONDS = "ARG_TIME_SECONDS";
    private static final String ARG_TITLE = "ARG_TITLE";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REQUEST_KEY = "TimePickerV2DialogFragment";
    public DialogfragmentTimePickerV2Binding binding;
    private Calendar calendar = Calendar.getInstance();
    private boolean is24HourFormat;

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0004\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005XT¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/blueair/devicedetails/dialog/TimePickerV2DialogFragment$Companion;", "", "<init>", "()V", "REQUEST_KEY", "", "ARG_HOUR_OF_DAY", "ARG_MINUTE", "ARG_TITLE", "ARG_TIME_SECONDS", "ARG_CYCLIC_ENABLED", "newInstance", "Lcom/blueair/devicedetails/dialog/TimePickerV2DialogFragment;", "title", "calendarTime", "Ljava/util/Calendar;", "cyclicEnabled", "", "secondsInDay", "", "devicedetails_otherRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* compiled from: TimePickerV2DialogFragment.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ TimePickerV2DialogFragment newInstance$default(Companion companion, String str, Calendar calendar, boolean z, int i, Object obj) {
            if ((i & 4) != 0) {
                z = true;
            }
            return companion.newInstance(str, calendar, z);
        }

        public final TimePickerV2DialogFragment newInstance(String str, Calendar calendar, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            Intrinsics.checkNotNullParameter(calendar, "calendarTime");
            return newInstance(str, (calendar.get(11) * DateTimeConstants.SECONDS_PER_HOUR) + (calendar.get(12) * 60), z);
        }

        public static /* synthetic */ TimePickerV2DialogFragment newInstance$default(Companion companion, String str, int i, boolean z, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                z = true;
            }
            return companion.newInstance(str, i, z);
        }

        public final TimePickerV2DialogFragment newInstance(String str, int i, boolean z) {
            Intrinsics.checkNotNullParameter(str, "title");
            TimePickerV2DialogFragment timePickerV2DialogFragment = new TimePickerV2DialogFragment();
            timePickerV2DialogFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(TimePickerV2DialogFragment.ARG_TITLE, str), TuplesKt.to(TimePickerV2DialogFragment.ARG_TIME_SECONDS, Integer.valueOf(i)), TuplesKt.to(TimePickerV2DialogFragment.ARG_CYCLIC_ENABLED, Boolean.valueOf(z))));
            return timePickerV2DialogFragment;
        }
    }

    public final DialogfragmentTimePickerV2Binding getBinding() {
        DialogfragmentTimePickerV2Binding dialogfragmentTimePickerV2Binding = this.binding;
        if (dialogfragmentTimePickerV2Binding != null) {
            return dialogfragmentTimePickerV2Binding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final void setBinding(DialogfragmentTimePickerV2Binding dialogfragmentTimePickerV2Binding) {
        Intrinsics.checkNotNullParameter(dialogfragmentTimePickerV2Binding, "<set-?>");
        this.binding = dialogfragmentTimePickerV2Binding;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Window window;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        setStyle(0, R.style.DialogTheme);
        Dialog dialog = getDialog();
        if (!(dialog == null || (window = dialog.getWindow()) == null)) {
            window.setBackgroundDrawable(new ColorDrawable(0));
            window.setWindowAnimations(R.style.dialog_animation);
            window.setGravity(80);
        }
        DialogfragmentTimePickerV2Binding inflate = DialogfragmentTimePickerV2Binding.inflate(layoutInflater, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "inflate(...)");
        setBinding(inflate);
        View root = getBinding().getRoot();
        Intrinsics.checkNotNullExpressionValue(root, "getRoot(...)");
        return root;
    }

    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog != null && (window = dialog.getWindow()) != null) {
            window.setLayout(-1, -2);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        super.onViewCreated(view, bundle);
        Context context = view.getContext();
        this.is24HourFormat = DateFormat.is24HourFormat(context);
        DialogfragmentTimePickerV2Binding binding2 = getBinding();
        binding2.btnClose.setOnClickListener(new TimePickerV2DialogFragment$$ExternalSyntheticLambda0(this));
        TimePickerV2DialogFragment$$ExternalSyntheticLambda1 timePickerV2DialogFragment$$ExternalSyntheticLambda1 = new TimePickerV2DialogFragment$$ExternalSyntheticLambda1();
        binding2.wheelHour.setFormatter(timePickerV2DialogFragment$$ExternalSyntheticLambda1);
        binding2.wheelMinute.setFormatter(timePickerV2DialogFragment$$ExternalSyntheticLambda1);
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i = arguments.getInt(ARG_TIME_SECONDS);
            int i2 = i / DateTimeConstants.SECONDS_PER_HOUR;
            int i3 = (i / 60) - (i2 * 60);
            this.calendar.set(11, i2);
            int i4 = 12;
            this.calendar.set(12, i3);
            if (this.is24HourFormat) {
                binding2.wheelHour.setNewData(CollectionsKt.toList(new IntRange(0, 23)));
                binding2.wheelHour.setDefaultValueReal(Integer.valueOf(i2));
                CustomWheelView customWheelView = binding2.wheelAmPm;
                Intrinsics.checkNotNullExpressionValue(customWheelView, "wheelAmPm");
                ViewExtensionsKt.hide(customWheelView);
            } else {
                binding2.wheelHour.setNewData(CollectionsKt.toList(new IntRange(1, 12)));
                int i5 = this.calendar.get(10);
                CustomWheelView customWheelView2 = binding2.wheelHour;
                if (i5 != 0) {
                    i4 = i5;
                }
                customWheelView2.setDefaultValueReal(Integer.valueOf(i4));
                AppCompatTextView appCompatTextView = binding2.tvHours;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView, "tvHours");
                ViewExtensionsKt.hide(appCompatTextView);
                AppCompatTextView appCompatTextView2 = binding2.tvMins;
                Intrinsics.checkNotNullExpressionValue(appCompatTextView2, "tvMins");
                ViewExtensionsKt.hide(appCompatTextView2);
                java.text.DateFormat timeInstance = java.text.DateFormat.getTimeInstance(3);
                Intrinsics.checkNotNull(timeInstance, "null cannot be cast to non-null type java.text.SimpleDateFormat");
                DateFormatSymbols dateFormatSymbols = ((SimpleDateFormat) timeInstance).getDateFormatSymbols();
                CustomWheelView customWheelView3 = binding2.wheelAmPm;
                String[] amPmStrings = dateFormatSymbols.getAmPmStrings();
                Intrinsics.checkNotNullExpressionValue(amPmStrings, "getAmPmStrings(...)");
                customWheelView3.setNewData(ArraysKt.toList((T[]) (Object[]) amPmStrings));
                binding2.wheelAmPm.setDefaultPositionReal(this.calendar.get(9));
                int dpToPx = (int) TypedValueCompat.dpToPx(28.0f, context.getResources().getDisplayMetrics());
                binding2.ivScaleMaskLeft.setPadding(0, dpToPx, 0, 0);
                binding2.ivScaleMaskRight.setPadding(0, dpToPx, 0, 0);
            }
            binding2.wheelMinute.setNewData(CollectionsKt.toList(new IntRange(0, 59)));
            binding2.wheelMinute.setDefaultValueReal(Integer.valueOf(i3));
            Typeface create = TypefaceCompat.create(context, ResourcesCompat.getFont(context, R.font.gilroy), 500, false);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            CustomWheelView customWheelView4 = binding2.wheelHour;
            customWheelView4.setTypeface(create);
            customWheelView4.setCyclicEnabled(arguments.getBoolean(ARG_CYCLIC_ENABLED));
            CustomWheelView customWheelView5 = binding2.wheelMinute;
            customWheelView5.setTypeface(create);
            customWheelView5.setCyclicEnabled(arguments.getBoolean(ARG_CYCLIC_ENABLED));
            binding2.wheelAmPm.setTypeface(create);
            binding2.title.setText(arguments.getString(ARG_TITLE));
        }
        binding2.wheelMinute.post(new TimePickerV2DialogFragment$$ExternalSyntheticLambda2(this));
        binding2.btnDone.setOnClickListener(new TimePickerV2DialogFragment$$ExternalSyntheticLambda3(this, binding2));
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$1(TimePickerV2DialogFragment timePickerV2DialogFragment, View view) {
        timePickerV2DialogFragment.dismiss();
    }

    /* access modifiers changed from: private */
    public static final String onViewCreated$lambda$8$lambda$2(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        if (!(obj instanceof Integer)) {
            return String.valueOf(obj);
        }
        String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{obj}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$6(TimePickerV2DialogFragment timePickerV2DialogFragment) {
        timePickerV2DialogFragment.adjustWheelTextSize();
    }

    /* access modifiers changed from: private */
    public static final void onViewCreated$lambda$8$lambda$7(TimePickerV2DialogFragment timePickerV2DialogFragment, DialogfragmentTimePickerV2Binding dialogfragmentTimePickerV2Binding, View view) {
        timePickerV2DialogFragment.dismissAllowingStateLoss();
        Integer num = (Integer) dialogfragmentTimePickerV2Binding.wheelHour.getCurrentItem();
        int intValue = num != null ? num.intValue() : 0;
        Integer num2 = (Integer) dialogfragmentTimePickerV2Binding.wheelMinute.getCurrentItem();
        int intValue2 = num2 != null ? num2.intValue() : 0;
        timePickerV2DialogFragment.calendar.set(12, intValue2);
        if (timePickerV2DialogFragment.is24HourFormat) {
            timePickerV2DialogFragment.calendar.set(11, intValue);
        } else {
            Calendar calendar2 = timePickerV2DialogFragment.calendar;
            if (intValue == 12) {
                intValue = 0;
            }
            calendar2.set(10, intValue);
            timePickerV2DialogFragment.calendar.set(9, dialogfragmentTimePickerV2Binding.wheelAmPm.getCurrentPosition() == 0 ? 0 : 1);
            intValue = timePickerV2DialogFragment.calendar.get(11);
        }
        FragmentKt.setFragmentResult(timePickerV2DialogFragment, REQUEST_KEY, BundleKt.bundleOf(TuplesKt.to(ARG_HOUR_OF_DAY, Integer.valueOf(intValue)), TuplesKt.to(ARG_MINUTE, Integer.valueOf(intValue2)), TuplesKt.to(ARG_TIME_SECONDS, Integer.valueOf((intValue * DateTimeConstants.SECONDS_PER_HOUR) + (intValue2 * 60)))));
    }

    private final void adjustWheelTextSize() {
        Paint paint = new Paint(69);
        int i = getResources().getDisplayMetrics().widthPixels;
        int i2 = this.is24HourFormat ? i / 2 : i / 3;
        float spToPx = TypedValueCompat.spToPx(64.0f, getResources().getDisplayMetrics());
        float spToPx2 = TypedValueCompat.spToPx(2.0f, getResources().getDisplayMetrics());
        paint.setTextSize(spToPx);
        boolean z = false;
        while (RangesKt.coerceAtLeast(paint.measureText("00..."), paint.measureText("88...")) > ((float) i2)) {
            spToPx -= spToPx2;
            paint.setTextSize(spToPx);
            z = true;
        }
        if (z) {
            DialogfragmentTimePickerV2Binding binding2 = getBinding();
            binding2.wheelMinute.setTextSize(spToPx);
            binding2.wheelHour.setTextSize(spToPx);
            binding2.wheelAmPm.setTextSize(spToPx);
            binding2.wheelMinute.setSelectedTextSize(spToPx);
            binding2.wheelHour.setSelectedTextSize(spToPx);
            binding2.wheelAmPm.setSelectedTextSize(spToPx);
            binding2.tvColon.setTextSize(0, spToPx);
        }
    }
}
