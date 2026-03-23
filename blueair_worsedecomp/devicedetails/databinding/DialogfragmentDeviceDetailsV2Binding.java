package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.SimpleStatusBar;
import com.blueair.viewcore.view.SwitchCompat;
import eightbitlab.com.blurview.BlurView;

public final class DialogfragmentDeviceDetailsV2Binding implements ViewBinding {
    public final AppCompatImageButton btnBack;
    public final SwitchCompat btnStandby;
    public final BlurView bvTitle;
    public final ConstraintLayout contentContainer;
    public final LinearLayout controlsContainer;
    public final ImageView deviceImage;
    public final TextView deviceName;
    public final View deviceNameMaxWidth;
    public final FrameLayout devicesControlsContainer;
    public final FrameLayout graphContainer;
    public final FrameLayout messagesContainer;
    public final ConstraintLayout rootLayout;
    private final ConstraintLayout rootView;
    public final NestedScrollView scrollable;
    public final RecyclerView sensorCardList;
    public final SimpleStatusBar statusBar;
    public final ConstraintLayout titleBar;
    public final View vBottomDivider;

    private DialogfragmentDeviceDetailsV2Binding(ConstraintLayout constraintLayout, AppCompatImageButton appCompatImageButton, SwitchCompat switchCompat, BlurView blurView, ConstraintLayout constraintLayout2, LinearLayout linearLayout, ImageView imageView, TextView textView, View view, FrameLayout frameLayout, FrameLayout frameLayout2, FrameLayout frameLayout3, ConstraintLayout constraintLayout3, NestedScrollView nestedScrollView, RecyclerView recyclerView, SimpleStatusBar simpleStatusBar, ConstraintLayout constraintLayout4, View view2) {
        this.rootView = constraintLayout;
        this.btnBack = appCompatImageButton;
        this.btnStandby = switchCompat;
        this.bvTitle = blurView;
        this.contentContainer = constraintLayout2;
        this.controlsContainer = linearLayout;
        this.deviceImage = imageView;
        this.deviceName = textView;
        this.deviceNameMaxWidth = view;
        this.devicesControlsContainer = frameLayout;
        this.graphContainer = frameLayout2;
        this.messagesContainer = frameLayout3;
        this.rootLayout = constraintLayout3;
        this.scrollable = nestedScrollView;
        this.sensorCardList = recyclerView;
        this.statusBar = simpleStatusBar;
        this.titleBar = constraintLayout4;
        this.vBottomDivider = view2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentDeviceDetailsV2Binding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentDeviceDetailsV2Binding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_device_details_v2, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004f, code lost:
        r1 = com.blueair.devicedetails.R.id.device_name_max_width;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ab, code lost:
        r1 = com.blueair.devicedetails.R.id.v_bottomDivider;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding bind(android.view.View r22) {
        /*
            r0 = r22
            int r1 = com.blueair.devicedetails.R.id.btn_back
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r5 = r2
            androidx.appcompat.widget.AppCompatImageButton r5 = (androidx.appcompat.widget.AppCompatImageButton) r5
            if (r5 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.btn_standby
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r6 = r2
            com.blueair.viewcore.view.SwitchCompat r6 = (com.blueair.viewcore.view.SwitchCompat) r6
            if (r6 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.bv_title
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r7 = r2
            eightbitlab.com.blurview.BlurView r7 = (eightbitlab.com.blurview.BlurView) r7
            if (r7 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.content_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r8 = r2
            androidx.constraintlayout.widget.ConstraintLayout r8 = (androidx.constraintlayout.widget.ConstraintLayout) r8
            if (r8 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.controls_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r9 = r2
            android.widget.LinearLayout r9 = (android.widget.LinearLayout) r9
            if (r9 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.device_image
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r10 = r2
            android.widget.ImageView r10 = (android.widget.ImageView) r10
            if (r10 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.device_name
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r11 = r2
            android.widget.TextView r11 = (android.widget.TextView) r11
            if (r11 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.device_name_max_width
            android.view.View r12 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r12 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.devices_controls_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r13 = r2
            android.widget.FrameLayout r13 = (android.widget.FrameLayout) r13
            if (r13 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.graph_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r14 = r2
            android.widget.FrameLayout r14 = (android.widget.FrameLayout) r14
            if (r14 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.messages_container
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r15 = r2
            android.widget.FrameLayout r15 = (android.widget.FrameLayout) r15
            if (r15 == 0) goto L_0x00bb
            r4 = r0
            androidx.constraintlayout.widget.ConstraintLayout r4 = (androidx.constraintlayout.widget.ConstraintLayout) r4
            int r1 = com.blueair.devicedetails.R.id.scrollable
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r17 = r2
            androidx.core.widget.NestedScrollView r17 = (androidx.core.widget.NestedScrollView) r17
            if (r17 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.sensor_card_list
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r18 = r2
            androidx.recyclerview.widget.RecyclerView r18 = (androidx.recyclerview.widget.RecyclerView) r18
            if (r18 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.statusBar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r19 = r2
            com.blueair.viewcore.view.SimpleStatusBar r19 = (com.blueair.viewcore.view.SimpleStatusBar) r19
            if (r19 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.title_bar
            android.view.View r2 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            r20 = r2
            androidx.constraintlayout.widget.ConstraintLayout r20 = (androidx.constraintlayout.widget.ConstraintLayout) r20
            if (r20 == 0) goto L_0x00bb
            int r1 = com.blueair.devicedetails.R.id.v_bottomDivider
            android.view.View r21 = androidx.viewbinding.ViewBindings.findChildViewById(r0, r1)
            if (r21 == 0) goto L_0x00bb
            com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding r3 = new com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding
            r16 = r4
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            return r3
        L_0x00bb:
            android.content.res.Resources r0 = r0.getResources()
            java.lang.String r0 = r0.getResourceName(r1)
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "Missing required view with ID: "
            java.lang.String r0 = r2.concat(r0)
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding.bind(android.view.View):com.blueair.devicedetails.databinding.DialogfragmentDeviceDetailsV2Binding");
    }
}
