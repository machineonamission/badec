package com.blueair.viewcore.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.viewcore.R;
import com.blueair.viewcore.view.QualityStatusView;

public final class AllQualityStatusViewBinding implements ViewBinding {
    private final ConstraintLayout rootView;
    public final QualityStatusView sensorCoLayout;
    public final QualityStatusView sensorPm10Layout;
    public final QualityStatusView sensorPm25Layout;
    public final QualityStatusView sensorSo2OrElseLayout;
    public final ConstraintLayout sensorView;

    private AllQualityStatusViewBinding(ConstraintLayout constraintLayout, QualityStatusView qualityStatusView, QualityStatusView qualityStatusView2, QualityStatusView qualityStatusView3, QualityStatusView qualityStatusView4, ConstraintLayout constraintLayout2) {
        this.rootView = constraintLayout;
        this.sensorCoLayout = qualityStatusView;
        this.sensorPm10Layout = qualityStatusView2;
        this.sensorPm25Layout = qualityStatusView3;
        this.sensorSo2OrElseLayout = qualityStatusView4;
        this.sensorView = constraintLayout2;
    }

    public ConstraintLayout getRoot() {
        return this.rootView;
    }

    public static AllQualityStatusViewBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static AllQualityStatusViewBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.all_quality_status_view, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static AllQualityStatusViewBinding bind(View view) {
        int i = R.id.sensor_co_layout;
        QualityStatusView qualityStatusView = (QualityStatusView) ViewBindings.findChildViewById(view, i);
        if (qualityStatusView != null) {
            i = R.id.sensor_pm10_layout;
            QualityStatusView qualityStatusView2 = (QualityStatusView) ViewBindings.findChildViewById(view, i);
            if (qualityStatusView2 != null) {
                i = R.id.sensor_pm25_layout;
                QualityStatusView qualityStatusView3 = (QualityStatusView) ViewBindings.findChildViewById(view, i);
                if (qualityStatusView3 != null) {
                    i = R.id.sensor_so2_or_else_layout;
                    QualityStatusView qualityStatusView4 = (QualityStatusView) ViewBindings.findChildViewById(view, i);
                    if (qualityStatusView4 != null) {
                        ConstraintLayout constraintLayout = (ConstraintLayout) view;
                        return new AllQualityStatusViewBinding(constraintLayout, qualityStatusView, qualityStatusView2, qualityStatusView3, qualityStatusView4, constraintLayout);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }
}
