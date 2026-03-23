package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.blueair.android.R;

public abstract class DialogAqiIndexInfoBinding extends ViewDataBinding {
    public final ImageButton closeButton;
    public final ConstraintLayout contentContainer;
    public final ImageView dotCo;
    public final ImageView dotPm10;
    public final ImageView dotPm25;
    public final ImageView dotSo2;
    public final TextView indexLevelExcellentContent;
    public final TextView indexLevelExcellentLabel;
    public final TextView indexLevelGoodContent;
    public final TextView indexLevelGoodLabel;
    public final TextView indexLevelModerateContent;
    public final TextView indexLevelModerateLabel;
    public final TextView indexLevelPollutedContent;
    public final TextView indexLevelPollutedLabel;
    public final TextView indexLevelVpollutedContent;
    public final TextView indexLevelVpollutedLabel;
    public final TextView introductionCo;
    public final TextView introductionIndex;
    public final TextView introductionPm10;
    public final TextView introductionPm25;
    public final TextView introductionSo2;
    public final TextView subTitleGases;
    public final TextView subTitleParticles;

    protected DialogAqiIndexInfoBinding(Object obj, View view, int i, ImageButton imageButton, ConstraintLayout constraintLayout, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, TextView textView11, TextView textView12, TextView textView13, TextView textView14, TextView textView15, TextView textView16, TextView textView17) {
        super(obj, view, i);
        this.closeButton = imageButton;
        this.contentContainer = constraintLayout;
        this.dotCo = imageView;
        this.dotPm10 = imageView2;
        this.dotPm25 = imageView3;
        this.dotSo2 = imageView4;
        this.indexLevelExcellentContent = textView;
        this.indexLevelExcellentLabel = textView2;
        this.indexLevelGoodContent = textView3;
        this.indexLevelGoodLabel = textView4;
        this.indexLevelModerateContent = textView5;
        this.indexLevelModerateLabel = textView6;
        this.indexLevelPollutedContent = textView7;
        this.indexLevelPollutedLabel = textView8;
        this.indexLevelVpollutedContent = textView9;
        this.indexLevelVpollutedLabel = textView10;
        this.introductionCo = textView11;
        this.introductionIndex = textView12;
        this.introductionPm10 = textView13;
        this.introductionPm25 = textView14;
        this.introductionSo2 = textView15;
        this.subTitleGases = textView16;
        this.subTitleParticles = textView17;
    }

    public static DialogAqiIndexInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        return inflate(layoutInflater, viewGroup, z, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAqiIndexInfoBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z, Object obj) {
        return (DialogAqiIndexInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_aqi_index_info, viewGroup, z, obj);
    }

    public static DialogAqiIndexInfoBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAqiIndexInfoBinding inflate(LayoutInflater layoutInflater, Object obj) {
        return (DialogAqiIndexInfoBinding) ViewDataBinding.inflateInternal(layoutInflater, R.layout.dialog_aqi_index_info, (ViewGroup) null, false, obj);
    }

    public static DialogAqiIndexInfoBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogAqiIndexInfoBinding bind(View view, Object obj) {
        return (DialogAqiIndexInfoBinding) bind(obj, view, R.layout.dialog_aqi_index_info);
    }
}
