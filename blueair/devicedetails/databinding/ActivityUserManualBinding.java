package com.blueair.devicedetails.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.devicedetails.R;
import com.blueair.viewcore.view.ProgressBlockerView;
import com.github.barteksc.pdfviewer.PDFView;

public final class ActivityUserManualBinding implements ViewBinding {
   public final AppCompatImageButton btnBack;
   public final AppCompatImageButton closeBtn;
   public final PDFView pdfView;
   public final ProgressBlockerView progressView;
   private final ConstraintLayout rootView;
   public final AppCompatTextView title;
   public final AppCompatTextView tvSubtitle;

   private ActivityUserManualBinding(ConstraintLayout var1, AppCompatImageButton var2, AppCompatImageButton var3, PDFView var4, ProgressBlockerView var5, AppCompatTextView var6, AppCompatTextView var7) {
      this.rootView = var1;
      this.btnBack = var2;
      this.closeBtn = var3;
      this.pdfView = var4;
      this.progressView = var5;
      this.title = var6;
      this.tvSubtitle = var7;
   }

   public static ActivityUserManualBinding bind(View var0) {
      int var1 = R.id.btnBack;
      AppCompatImageButton var3 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var3 != null) {
         var1 = R.id.close_btn;
         AppCompatImageButton var2 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
         if (var2 != null) {
            var1 = R.id.pdf_view;
            PDFView var6 = (PDFView)ViewBindings.findChildViewById(var0, var1);
            if (var6 != null) {
               var1 = R.id.progressView;
               ProgressBlockerView var4 = (ProgressBlockerView)ViewBindings.findChildViewById(var0, var1);
               if (var4 != null) {
                  var1 = R.id.title;
                  AppCompatTextView var7 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                  if (var7 != null) {
                     var1 = R.id.tv_subtitle;
                     AppCompatTextView var5 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                     if (var5 != null) {
                        return new ActivityUserManualBinding((ConstraintLayout)var0, var3, var2, var6, var4, var7, var5);
                     }
                  }
               }
            }
         }
      }

      throw new NullPointerException("Missing required view with ID: ".concat(var0.getResources().getResourceName(var1)));
   }

   public static ActivityUserManualBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityUserManualBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_user_manual, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
