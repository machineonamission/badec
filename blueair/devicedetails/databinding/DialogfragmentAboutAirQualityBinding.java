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
   public final TextView aboutHcho;
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
   public final ConstraintLayout contentHcho;
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
   public final ImageView icHcho;
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
   public final TextView labelHcho;
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

   private DialogfragmentAboutAirQualityBinding(FrameLayout var1, TextView var2, TextView var3, TextView var4, TextView var5, TextView var6, TextView var7, TextView var8, TextView var9, TextView var10, TextView var11, TextView var12, AppCompatImageView var13, ConstraintLayout var14, ConstraintLayout var15, ConstraintLayout var16, ConstraintLayout var17, ConstraintLayout var18, TextView var19, TextView var20, TextView var21, TextView var22, ConstraintLayout var23, ConstraintLayout var24, ConstraintLayout var25, ConstraintLayout var26, ConstraintLayout var27, TextView var28, TextView var29, TextView var30, TextView var31, ConstraintLayout var32, ConstraintLayout var33, Group var34, Group var35, Group var36, Group var37, ImageView var38, ImageView var39, ImageView var40, ImageView var41, ImageView var42, ImageView var43, ImageView var44, ImageView var45, ImageView var46, ImageView var47, ImageView var48, TextView var49, TextView var50, TextView var51, TextView var52, TextView var53, TextView var54, TextView var55, TextView var56, TextView var57, TextView var58, TextView var59, TextView var60, TextView var61, TextView var62, TextView var63, TextView var64, ScrollView var65, TextView var66) {
      this.rootView = var1;
      this.aboutExcellent = var2;
      this.aboutGood = var3;
      this.aboutHcho = var4;
      this.aboutHum = var5;
      this.aboutModerate = var6;
      this.aboutPm1 = var7;
      this.aboutPm10 = var8;
      this.aboutPm25 = var9;
      this.aboutPolluted = var10;
      this.aboutTvoc = var11;
      this.aboutVpolluted = var12;
      this.btnClose = var13;
      this.contentContainer = var14;
      this.contentExcellent = var15;
      this.contentGood = var16;
      this.contentHcho = var17;
      this.contentHum = var18;
      this.contentMessageGases = var19;
      this.contentMessageHum = var20;
      this.contentMessageIndoor = var21;
      this.contentMessageParticle = var22;
      this.contentModerate = var23;
      this.contentPm1 = var24;
      this.contentPm10 = var25;
      this.contentPm25 = var26;
      this.contentPolluted = var27;
      this.contentTitleGases = var28;
      this.contentTitleHum = var29;
      this.contentTitleIndoor = var30;
      this.contentTitleParticle = var31;
      this.contentTvoc = var32;
      this.contentVpolluted = var33;
      this.groupGases = var34;
      this.groupHum = var35;
      this.groupIndoorAir = var36;
      this.groupParticleHeader = var37;
      this.icExcellent = var38;
      this.icGood = var39;
      this.icHcho = var40;
      this.icHum = var41;
      this.icModerate = var42;
      this.icPm1 = var43;
      this.icPm10 = var44;
      this.icPm25 = var45;
      this.icPolluted = var46;
      this.icTvoc = var47;
      this.icVpolluted = var48;
      this.labelExcellent = var49;
      this.labelGood = var50;
      this.labelHcho = var51;
      this.labelHum = var52;
      this.labelModerate = var53;
      this.labelPm1 = var54;
      this.labelPm10 = var55;
      this.labelPm25 = var56;
      this.labelPolluted = var57;
      this.labelTvoc = var58;
      this.labelVpolluted = var59;
      this.rangeExcellent = var60;
      this.rangeGood = var61;
      this.rangeModerate = var62;
      this.rangePolluted = var63;
      this.rangeVpolluted = var64;
      this.scrollView = var65;
      this.title = var66;
   }

   public static DialogfragmentAboutAirQualityBinding bind(View var0) {
      int var1 = R.id.about_excellent;
      TextView var46 = (TextView)ViewBindings.findChildViewById(var0, var1);
      if (var46 != null) {
         var1 = R.id.about_good;
         TextView var41 = (TextView)ViewBindings.findChildViewById(var0, var1);
         if (var41 != null) {
            var1 = R.id.about_hcho;
            TextView var43 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var43 != null) {
               var1 = R.id.about_hum;
               TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var6 != null) {
                  var1 = R.id.about_moderate;
                  TextView var51 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var51 != null) {
                     var1 = R.id.about_pm1;
                     TextView var21 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var21 != null) {
                        var1 = R.id.about_pm10;
                        TextView var24 = (TextView)ViewBindings.findChildViewById(var0, var1);
                        if (var24 != null) {
                           var1 = R.id.about_pm25;
                           TextView var20 = (TextView)ViewBindings.findChildViewById(var0, var1);
                           if (var20 != null) {
                              var1 = R.id.about_polluted;
                              TextView var15 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var15 != null) {
                                 var1 = R.id.about_tvoc;
                                 TextView var7 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var7 != null) {
                                    var1 = R.id.about_vpolluted;
                                    TextView var59 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var59 != null) {
                                       var1 = R.id.btn_close;
                                       AppCompatImageView var64 = (AppCompatImageView)ViewBindings.findChildViewById(var0, var1);
                                       if (var64 != null) {
                                          var1 = R.id.content_container;
                                          ConstraintLayout var18 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                          if (var18 != null) {
                                             var1 = R.id.content_excellent;
                                             ConstraintLayout var25 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                             if (var25 != null) {
                                                var1 = R.id.content_good;
                                                ConstraintLayout var66 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                if (var66 != null) {
                                                   var1 = R.id.content_hcho;
                                                   ConstraintLayout var16 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                   if (var16 != null) {
                                                      var1 = R.id.content_hum;
                                                      ConstraintLayout var12 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                      if (var12 != null) {
                                                         var1 = R.id.content_message_gases;
                                                         TextView var63 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                         if (var63 != null) {
                                                            var1 = R.id.content_message_hum;
                                                            TextView var19 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                            if (var19 != null) {
                                                               var1 = R.id.content_message_indoor;
                                                               TextView var8 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                               if (var8 != null) {
                                                                  var1 = R.id.content_message_particle;
                                                                  TextView var23 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                  if (var23 != null) {
                                                                     var1 = R.id.content_moderate;
                                                                     ConstraintLayout var35 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                     if (var35 != null) {
                                                                        var1 = R.id.content_pm1;
                                                                        ConstraintLayout var48 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                        if (var48 != null) {
                                                                           var1 = R.id.content_pm10;
                                                                           ConstraintLayout var39 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                           if (var39 != null) {
                                                                              var1 = R.id.content_pm25;
                                                                              ConstraintLayout var30 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                              if (var30 != null) {
                                                                                 var1 = R.id.content_polluted;
                                                                                 ConstraintLayout var65 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                 if (var65 != null) {
                                                                                    var1 = R.id.content_title_gases;
                                                                                    TextView var47 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                    if (var47 != null) {
                                                                                       var1 = R.id.content_title_hum;
                                                                                       TextView var29 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                       if (var29 != null) {
                                                                                          var1 = R.id.content_title_indoor;
                                                                                          TextView var62 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                          if (var62 != null) {
                                                                                             var1 = R.id.content_title_particle;
                                                                                             TextView var49 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                             if (var49 != null) {
                                                                                                var1 = R.id.content_tvoc;
                                                                                                ConstraintLayout var33 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                if (var33 != null) {
                                                                                                   var1 = R.id.content_vpolluted;
                                                                                                   ConstraintLayout var44 = (ConstraintLayout)ViewBindings.findChildViewById(var0, var1);
                                                                                                   if (var44 != null) {
                                                                                                      var1 = R.id.group_gases;
                                                                                                      Group var54 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                                                                      if (var54 != null) {
                                                                                                         var1 = R.id.group_hum;
                                                                                                         Group var53 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                                                                         if (var53 != null) {
                                                                                                            var1 = R.id.group_indoorAir;
                                                                                                            Group var42 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                                                                            if (var42 != null) {
                                                                                                               var1 = R.id.group_particleHeader;
                                                                                                               Group var58 = (Group)ViewBindings.findChildViewById(var0, var1);
                                                                                                               if (var58 != null) {
                                                                                                                  var1 = R.id.ic_excellent;
                                                                                                                  ImageView var61 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                  if (var61 != null) {
                                                                                                                     var1 = R.id.ic_good;
                                                                                                                     ImageView var9 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                     if (var9 != null) {
                                                                                                                        var1 = R.id.ic_hcho;
                                                                                                                        ImageView var37 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                        if (var37 != null) {
                                                                                                                           var1 = R.id.ic_hum;
                                                                                                                           ImageView var2 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                           if (var2 != null) {
                                                                                                                              var1 = R.id.ic_moderate;
                                                                                                                              ImageView var50 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                              if (var50 != null) {
                                                                                                                                 var1 = R.id.ic_pm1;
                                                                                                                                 ImageView var10 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                 if (var10 != null) {
                                                                                                                                    var1 = R.id.ic_pm10;
                                                                                                                                    ImageView var45 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                    if (var45 != null) {
                                                                                                                                       var1 = R.id.ic_pm25;
                                                                                                                                       ImageView var17 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                       if (var17 != null) {
                                                                                                                                          var1 = R.id.ic_polluted;
                                                                                                                                          ImageView var55 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                          if (var55 != null) {
                                                                                                                                             var1 = R.id.ic_tvoc;
                                                                                                                                             ImageView var4 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                             if (var4 != null) {
                                                                                                                                                var1 = R.id.ic_vpolluted;
                                                                                                                                                ImageView var52 = (ImageView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                if (var52 != null) {
                                                                                                                                                   var1 = R.id.label_excellent;
                                                                                                                                                   TextView var32 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                   if (var32 != null) {
                                                                                                                                                      var1 = R.id.label_good;
                                                                                                                                                      TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                      if (var5 != null) {
                                                                                                                                                         var1 = R.id.label_hcho;
                                                                                                                                                         TextView var31 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                         if (var31 != null) {
                                                                                                                                                            var1 = R.id.label_hum;
                                                                                                                                                            TextView var26 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                            if (var26 != null) {
                                                                                                                                                               var1 = R.id.label_moderate;
                                                                                                                                                               TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                               if (var3 != null) {
                                                                                                                                                                  var1 = R.id.label_pm1;
                                                                                                                                                                  TextView var27 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                  if (var27 != null) {
                                                                                                                                                                     var1 = R.id.label_pm10;
                                                                                                                                                                     TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                     if (var13 != null) {
                                                                                                                                                                        var1 = R.id.label_pm25;
                                                                                                                                                                        TextView var40 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                        if (var40 != null) {
                                                                                                                                                                           var1 = R.id.label_polluted;
                                                                                                                                                                           TextView var60 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                           if (var60 != null) {
                                                                                                                                                                              var1 = R.id.label_tvoc;
                                                                                                                                                                              TextView var14 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                              if (var14 != null) {
                                                                                                                                                                                 var1 = R.id.label_vpolluted;
                                                                                                                                                                                 TextView var22 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                 if (var22 != null) {
                                                                                                                                                                                    var1 = R.id.range_excellent;
                                                                                                                                                                                    TextView var36 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                    if (var36 != null) {
                                                                                                                                                                                       var1 = R.id.range_good;
                                                                                                                                                                                       TextView var28 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                       if (var28 != null) {
                                                                                                                                                                                          var1 = R.id.range_moderate;
                                                                                                                                                                                          TextView var56 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                          if (var56 != null) {
                                                                                                                                                                                             var1 = R.id.range_polluted;
                                                                                                                                                                                             TextView var34 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                             if (var34 != null) {
                                                                                                                                                                                                var1 = R.id.range_vpolluted;
                                                                                                                                                                                                TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                                if (var11 != null) {
                                                                                                                                                                                                   var1 = R.id.scroll_view;
                                                                                                                                                                                                   ScrollView var57 = (ScrollView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                                   if (var57 != null) {
                                                                                                                                                                                                      var1 = R.id.title;
                                                                                                                                                                                                      TextView var38 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                                                                                                                                                                                      if (var38 != null) {
                                                                                                                                                                                                         return new DialogfragmentAboutAirQualityBinding((FrameLayout)var0, var46, var41, var43, var6, var51, var21, var24, var20, var15, var7, var59, var64, var18, var25, var66, var16, var12, var63, var19, var8, var23, var35, var48, var39, var30, var65, var47, var29, var62, var49, var33, var44, var54, var53, var42, var58, var61, var9, var37, var2, var50, var10, var45, var17, var55, var4, var52, var32, var5, var31, var26, var3, var27, var13, var40, var60, var14, var22, var36, var28, var56, var34, var11, var57, var38);
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
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static DialogfragmentAboutAirQualityBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static DialogfragmentAboutAirQualityBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.dialogfragment_about_air_quality, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public FrameLayout getRoot() {
      return this.rootView;
   }
}
