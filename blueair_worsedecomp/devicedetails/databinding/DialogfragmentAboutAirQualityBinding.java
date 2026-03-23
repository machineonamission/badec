package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;

public final class DialogfragmentAboutAirQualityBinding implements ViewBinding {
    public final TextView aboutExcellent;
    public final TextView aboutGood;
    public final TextView aboutHum;
    public final TextView aboutModerate;
    public final TextView aboutPm1;
    public final TextView aboutPm10;
    public final TextView aboutPm25;
    public final TextView aboutPolluted;
    public final TextView aboutTvoc;
    public final TextView aboutVpolluted;
    public final AppCompatImageView btnClose;
    public final ConstraintLayout contentContainer;
    public final ConstraintLayout contentExcellent;
    public final ConstraintLayout contentGood;
    public final ConstraintLayout contentHum;
    public final TextView contentMessageGases;
    public final TextView contentMessageHum;
    public final TextView contentMessageIndoor;
    public final TextView contentMessageParticle;
    public final ConstraintLayout contentModerate;
    public final ConstraintLayout contentPm1;
    public final ConstraintLayout contentPm10;
    public final ConstraintLayout contentPm25;
    public final ConstraintLayout contentPolluted;
    public final TextView contentTitleGases;
    public final TextView contentTitleHum;
    public final TextView contentTitleIndoor;
    public final TextView contentTitleParticle;
    public final ConstraintLayout contentTvoc;
    public final ConstraintLayout contentVpolluted;
    public final Group groupGases;
    public final Group groupHum;
    public final Group groupIndoorAir;
    public final Group groupParticleHeader;
    public final ImageView icExcellent;
    public final ImageView icGood;
    public final ImageView icHum;
    public final ImageView icModerate;
    public final ImageView icPm1;
    public final ImageView icPm10;
    public final ImageView icPm25;
    public final ImageView icPolluted;
    public final ImageView icTvoc;
    public final ImageView icVpolluted;
    public final TextView labelExcellent;
    public final TextView labelGood;
    public final TextView labelHum;
    public final TextView labelModerate;
    public final TextView labelPm1;
    public final TextView labelPm10;
    public final TextView labelPm25;
    public final TextView labelPolluted;
    public final TextView labelTvoc;
    public final TextView labelVpolluted;
    public final TextView rangeExcellent;
    public final TextView rangeGood;
    public final TextView rangeModerate;
    public final TextView rangePolluted;
    public final TextView rangeVpolluted;
    private final FrameLayout rootView;
    public final ScrollView scrollView;
    public final TextView title;

    private DialogfragmentAboutAirQualityBinding(FrameLayout frameLayout, TextView textView, TextView textView2, TextView textView3, TextView textView4, TextView textView5, TextView textView6, TextView textView7, TextView textView8, TextView textView9, TextView textView10, AppCompatImageView appCompatImageView, ConstraintLayout constraintLayout, ConstraintLayout constraintLayout2, ConstraintLayout constraintLayout3, ConstraintLayout constraintLayout4, TextView textView11, TextView textView12, TextView textView13, TextView textView14, ConstraintLayout constraintLayout5, ConstraintLayout constraintLayout6, ConstraintLayout constraintLayout7, ConstraintLayout constraintLayout8, ConstraintLayout constraintLayout9, TextView textView15, TextView textView16, TextView textView17, TextView textView18, ConstraintLayout constraintLayout10, ConstraintLayout constraintLayout11, Group group, Group group2, Group group3, Group group4, ImageView imageView, ImageView imageView2, ImageView imageView3, ImageView imageView4, ImageView imageView5, ImageView imageView6, ImageView imageView7, ImageView imageView8, ImageView imageView9, ImageView imageView10, TextView textView19, TextView textView20, TextView textView21, TextView textView22, TextView textView23, TextView textView24, TextView textView25, TextView textView26, TextView textView27, TextView textView28, TextView textView29, TextView textView30, TextView textView31, TextView textView32, TextView textView33, ScrollView scrollView2, TextView textView34) {
        this.rootView = frameLayout;
        this.aboutExcellent = textView;
        this.aboutGood = textView2;
        this.aboutHum = textView3;
        this.aboutModerate = textView4;
        this.aboutPm1 = textView5;
        this.aboutPm10 = textView6;
        this.aboutPm25 = textView7;
        this.aboutPolluted = textView8;
        this.aboutTvoc = textView9;
        this.aboutVpolluted = textView10;
        this.btnClose = appCompatImageView;
        this.contentContainer = constraintLayout;
        this.contentExcellent = constraintLayout2;
        this.contentGood = constraintLayout3;
        this.contentHum = constraintLayout4;
        this.contentMessageGases = textView11;
        this.contentMessageHum = textView12;
        this.contentMessageIndoor = textView13;
        this.contentMessageParticle = textView14;
        this.contentModerate = constraintLayout5;
        this.contentPm1 = constraintLayout6;
        this.contentPm10 = constraintLayout7;
        this.contentPm25 = constraintLayout8;
        this.contentPolluted = constraintLayout9;
        this.contentTitleGases = textView15;
        this.contentTitleHum = textView16;
        this.contentTitleIndoor = textView17;
        this.contentTitleParticle = textView18;
        this.contentTvoc = constraintLayout10;
        this.contentVpolluted = constraintLayout11;
        this.groupGases = group;
        this.groupHum = group2;
        this.groupIndoorAir = group3;
        this.groupParticleHeader = group4;
        this.icExcellent = imageView;
        this.icGood = imageView2;
        this.icHum = imageView3;
        this.icModerate = imageView4;
        this.icPm1 = imageView5;
        this.icPm10 = imageView6;
        this.icPm25 = imageView7;
        this.icPolluted = imageView8;
        this.icTvoc = imageView9;
        this.icVpolluted = imageView10;
        this.labelExcellent = textView19;
        this.labelGood = textView20;
        this.labelHum = textView21;
        this.labelModerate = textView22;
        this.labelPm1 = textView23;
        this.labelPm10 = textView24;
        this.labelPm25 = textView25;
        this.labelPolluted = textView26;
        this.labelTvoc = textView27;
        this.labelVpolluted = textView28;
        this.rangeExcellent = textView29;
        this.rangeGood = textView30;
        this.rangeModerate = textView31;
        this.rangePolluted = textView32;
        this.rangeVpolluted = textView33;
        this.scrollView = scrollView2;
        this.title = textView34;
    }

    public FrameLayout getRoot() {
        return this.rootView;
    }

    public static DialogfragmentAboutAirQualityBinding inflate(LayoutInflater layoutInflater) {
        return inflate(layoutInflater, (ViewGroup) null, false);
    }

    public static DialogfragmentAboutAirQualityBinding inflate(LayoutInflater layoutInflater, ViewGroup viewGroup, boolean z) {
        View inflate = layoutInflater.inflate(R.layout.dialogfragment_about_air_quality, viewGroup, false);
        if (z) {
            viewGroup.addView(inflate);
        }
        return bind(inflate);
    }

    public static DialogfragmentAboutAirQualityBinding bind(View view) {
        View view2 = view;
        int i = R.id.about_excellent;
        TextView textView = (TextView) ViewBindings.findChildViewById(view2, i);
        if (textView != null) {
            i = R.id.about_good;
            TextView textView2 = (TextView) ViewBindings.findChildViewById(view2, i);
            if (textView2 != null) {
                i = R.id.about_hum;
                TextView textView3 = (TextView) ViewBindings.findChildViewById(view2, i);
                if (textView3 != null) {
                    i = R.id.about_moderate;
                    TextView textView4 = (TextView) ViewBindings.findChildViewById(view2, i);
                    if (textView4 != null) {
                        i = R.id.about_pm1;
                        TextView textView5 = (TextView) ViewBindings.findChildViewById(view2, i);
                        if (textView5 != null) {
                            i = R.id.about_pm10;
                            TextView textView6 = (TextView) ViewBindings.findChildViewById(view2, i);
                            if (textView6 != null) {
                                i = R.id.about_pm25;
                                TextView textView7 = (TextView) ViewBindings.findChildViewById(view2, i);
                                if (textView7 != null) {
                                    i = R.id.about_polluted;
                                    TextView textView8 = (TextView) ViewBindings.findChildViewById(view2, i);
                                    if (textView8 != null) {
                                        i = R.id.about_tvoc;
                                        TextView textView9 = (TextView) ViewBindings.findChildViewById(view2, i);
                                        if (textView9 != null) {
                                            i = R.id.about_vpolluted;
                                            TextView textView10 = (TextView) ViewBindings.findChildViewById(view2, i);
                                            if (textView10 != null) {
                                                i = R.id.btn_close;
                                                AppCompatImageView appCompatImageView = (AppCompatImageView) ViewBindings.findChildViewById(view2, i);
                                                if (appCompatImageView != null) {
                                                    i = R.id.content_container;
                                                    ConstraintLayout constraintLayout = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                    if (constraintLayout != null) {
                                                        i = R.id.content_excellent;
                                                        ConstraintLayout constraintLayout2 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                        if (constraintLayout2 != null) {
                                                            i = R.id.content_good;
                                                            ConstraintLayout constraintLayout3 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                            if (constraintLayout3 != null) {
                                                                i = R.id.content_hum;
                                                                ConstraintLayout constraintLayout4 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                if (constraintLayout4 != null) {
                                                                    i = R.id.content_message_gases;
                                                                    TextView textView11 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                    if (textView11 != null) {
                                                                        i = R.id.content_message_hum;
                                                                        TextView textView12 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                        if (textView12 != null) {
                                                                            i = R.id.content_message_indoor;
                                                                            TextView textView13 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                            if (textView13 != null) {
                                                                                i = R.id.content_message_particle;
                                                                                TextView textView14 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                if (textView14 != null) {
                                                                                    i = R.id.content_moderate;
                                                                                    ConstraintLayout constraintLayout5 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                    if (constraintLayout5 != null) {
                                                                                        i = R.id.content_pm1;
                                                                                        ConstraintLayout constraintLayout6 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                        if (constraintLayout6 != null) {
                                                                                            i = R.id.content_pm10;
                                                                                            ConstraintLayout constraintLayout7 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                            if (constraintLayout7 != null) {
                                                                                                i = R.id.content_pm25;
                                                                                                ConstraintLayout constraintLayout8 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                if (constraintLayout8 != null) {
                                                                                                    i = R.id.content_polluted;
                                                                                                    ConstraintLayout constraintLayout9 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                    if (constraintLayout9 != null) {
                                                                                                        i = R.id.content_title_gases;
                                                                                                        TextView textView15 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                        if (textView15 != null) {
                                                                                                            i = R.id.content_title_hum;
                                                                                                            TextView textView16 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                            if (textView16 != null) {
                                                                                                                i = R.id.content_title_indoor;
                                                                                                                TextView textView17 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                if (textView17 != null) {
                                                                                                                    i = R.id.content_title_particle;
                                                                                                                    TextView textView18 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                    if (textView18 != null) {
                                                                                                                        i = R.id.content_tvoc;
                                                                                                                        ConstraintLayout constraintLayout10 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                        if (constraintLayout10 != null) {
                                                                                                                            i = R.id.content_vpolluted;
                                                                                                                            ConstraintLayout constraintLayout11 = (ConstraintLayout) ViewBindings.findChildViewById(view2, i);
                                                                                                                            if (constraintLayout11 != null) {
                                                                                                                                i = R.id.group_gases;
                                                                                                                                Group group = (Group) ViewBindings.findChildViewById(view2, i);
                                                                                                                                if (group != null) {
                                                                                                                                    i = R.id.group_hum;
                                                                                                                                    Group group2 = (Group) ViewBindings.findChildViewById(view2, i);
                                                                                                                                    if (group2 != null) {
                                                                                                                                        i = R.id.group_indoorAir;
                                                                                                                                        Group group3 = (Group) ViewBindings.findChildViewById(view2, i);
                                                                                                                                        if (group3 != null) {
                                                                                                                                            i = R.id.group_particleHeader;
                                                                                                                                            Group group4 = (Group) ViewBindings.findChildViewById(view2, i);
                                                                                                                                            if (group4 != null) {
                                                                                                                                                i = R.id.ic_excellent;
                                                                                                                                                ImageView imageView = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                if (imageView != null) {
                                                                                                                                                    i = R.id.ic_good;
                                                                                                                                                    ImageView imageView2 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                    if (imageView2 != null) {
                                                                                                                                                        i = R.id.ic_hum;
                                                                                                                                                        ImageView imageView3 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                        if (imageView3 != null) {
                                                                                                                                                            i = R.id.ic_moderate;
                                                                                                                                                            ImageView imageView4 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                            if (imageView4 != null) {
                                                                                                                                                                i = R.id.ic_pm1;
                                                                                                                                                                ImageView imageView5 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                if (imageView5 != null) {
                                                                                                                                                                    i = R.id.ic_pm10;
                                                                                                                                                                    ImageView imageView6 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                    if (imageView6 != null) {
                                                                                                                                                                        i = R.id.ic_pm25;
                                                                                                                                                                        ImageView imageView7 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                        if (imageView7 != null) {
                                                                                                                                                                            i = R.id.ic_polluted;
                                                                                                                                                                            ImageView imageView8 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                            if (imageView8 != null) {
                                                                                                                                                                                i = R.id.ic_tvoc;
                                                                                                                                                                                ImageView imageView9 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                if (imageView9 != null) {
                                                                                                                                                                                    i = R.id.ic_vpolluted;
                                                                                                                                                                                    ImageView imageView10 = (ImageView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                    if (imageView10 != null) {
                                                                                                                                                                                        i = R.id.label_excellent;
                                                                                                                                                                                        TextView textView19 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                        if (textView19 != null) {
                                                                                                                                                                                            i = R.id.label_good;
                                                                                                                                                                                            TextView textView20 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                            if (textView20 != null) {
                                                                                                                                                                                                i = R.id.label_hum;
                                                                                                                                                                                                TextView textView21 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                if (textView21 != null) {
                                                                                                                                                                                                    i = R.id.label_moderate;
                                                                                                                                                                                                    TextView textView22 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                    if (textView22 != null) {
                                                                                                                                                                                                        i = R.id.label_pm1;
                                                                                                                                                                                                        TextView textView23 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                        if (textView23 != null) {
                                                                                                                                                                                                            i = R.id.label_pm10;
                                                                                                                                                                                                            TextView textView24 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                            if (textView24 != null) {
                                                                                                                                                                                                                i = R.id.label_pm25;
                                                                                                                                                                                                                TextView textView25 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                if (textView25 != null) {
                                                                                                                                                                                                                    i = R.id.label_polluted;
                                                                                                                                                                                                                    TextView textView26 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                    if (textView26 != null) {
                                                                                                                                                                                                                        i = R.id.label_tvoc;
                                                                                                                                                                                                                        TextView textView27 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                        if (textView27 != null) {
                                                                                                                                                                                                                            i = R.id.label_vpolluted;
                                                                                                                                                                                                                            TextView textView28 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                            if (textView28 != null) {
                                                                                                                                                                                                                                i = R.id.range_excellent;
                                                                                                                                                                                                                                TextView textView29 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                if (textView29 != null) {
                                                                                                                                                                                                                                    i = R.id.range_good;
                                                                                                                                                                                                                                    TextView textView30 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                    if (textView30 != null) {
                                                                                                                                                                                                                                        i = R.id.range_moderate;
                                                                                                                                                                                                                                        TextView textView31 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                        if (textView31 != null) {
                                                                                                                                                                                                                                            i = R.id.range_polluted;
                                                                                                                                                                                                                                            TextView textView32 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                            if (textView32 != null) {
                                                                                                                                                                                                                                                i = R.id.range_vpolluted;
                                                                                                                                                                                                                                                TextView textView33 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                                if (textView33 != null) {
                                                                                                                                                                                                                                                    i = R.id.scroll_view;
                                                                                                                                                                                                                                                    ScrollView scrollView2 = (ScrollView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                                    if (scrollView2 != null) {
                                                                                                                                                                                                                                                        i = R.id.title;
                                                                                                                                                                                                                                                        TextView textView34 = (TextView) ViewBindings.findChildViewById(view2, i);
                                                                                                                                                                                                                                                        if (textView34 != null) {
                                                                                                                                                                                                                                                            return new DialogfragmentAboutAirQualityBinding((FrameLayout) view2, textView, textView2, textView3, textView4, textView5, textView6, textView7, textView8, textView9, textView10, appCompatImageView, constraintLayout, constraintLayout2, constraintLayout3, constraintLayout4, textView11, textView12, textView13, textView14, constraintLayout5, constraintLayout6, constraintLayout7, constraintLayout8, constraintLayout9, textView15, textView16, textView17, textView18, constraintLayout10, constraintLayout11, group, group2, group3, group4, imageView, imageView2, imageView3, imageView4, imageView5, imageView6, imageView7, imageView8, imageView9, imageView10, textView19, textView20, textView21, textView22, textView23, textView24, textView25, textView26, textView27, textView28, textView29, textView30, textView31, textView32, textView33, scrollView2, textView34);
                                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                                }
                                                                                                                                                                                                                                            }
                                                                                                                                                                                                                                        }
                                                                                                                                                                                                                                    }
                                                                                                                                                                                                                                }
                                                                                                                                                                                                                            }
                                                                                                                                                                                                                        }
                                                                                                                                                                                                                    }
                                                                                                                                                                                                                }
                                                                                                                                                                                                            }
                                                                                                                                                                                                        }
                                                                                                                                                                                                    }
                                                                                                                                                                                                }
                                                                                                                                                                                            }
                                                                                                                                                                                        }
                                                                                                                                                                                    }
                                                                                                                                                                                }
                                                                                                                                                                            }
                                                                                                                                                                        }
                                                                                                                                                                    }
                                                                                                                                                                }
                                                                                                                                                            }
                                                                                                                                                        }
                                                                                                                                                    }
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                        }
                                                                                                                                    }
                                                                                                                                }
                                                                                                                            }
                                                                                                                        }
                                                                                                                    }
                                                                                                                }
                                                                                                            }
                                                                                                        }
                                                                                                    }
                                                                                                }
                                                                                            }
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view2.getResources().getResourceName(i)));
    }
}
