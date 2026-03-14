package com.blueair.android.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.android.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public final class ActivityUploadLogBinding implements ViewBinding {
   public final AppCompatImageButton btnBack;
   public final MaterialButton btnClear;
   public final MaterialButton btnUpload;
   public final TextInputEditText descriptionValue;
   public final TextView dropdownIssueType;
   public final TextView dropdownLength;
   public final EditText etMaxLogSize;
   public final TextInputLayout inputDescription;
   public final TextView labelIssueType;
   public final TextView labelLength;
   public final TextView labelMaxLogSize;
   public final TextView labelMaxLogSizeUnit;
   private final ConstraintLayout rootView;
   public final TextView tvCurrentLogSize;
   public final TextView tvProgress;
   public final AppCompatTextView tvTitle;

   private ActivityUploadLogBinding(ConstraintLayout var1, AppCompatImageButton var2, MaterialButton var3, MaterialButton var4, TextInputEditText var5, TextView var6, TextView var7, EditText var8, TextInputLayout var9, TextView var10, TextView var11, TextView var12, TextView var13, TextView var14, TextView var15, AppCompatTextView var16) {
      this.rootView = var1;
      this.btnBack = var2;
      this.btnClear = var3;
      this.btnUpload = var4;
      this.descriptionValue = var5;
      this.dropdownIssueType = var6;
      this.dropdownLength = var7;
      this.etMaxLogSize = var8;
      this.inputDescription = var9;
      this.labelIssueType = var10;
      this.labelLength = var11;
      this.labelMaxLogSize = var12;
      this.labelMaxLogSizeUnit = var13;
      this.tvCurrentLogSize = var14;
      this.tvProgress = var15;
      this.tvTitle = var16;
   }

   public static ActivityUploadLogBinding bind(View var0) {
      int var1 = R.id.btn_back;
      AppCompatImageButton var7 = (AppCompatImageButton)ViewBindings.findChildViewById(var0, var1);
      if (var7 != null) {
         var1 = R.id.btn_clear;
         MaterialButton var8 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
         if (var8 != null) {
            var1 = R.id.btn_upload;
            MaterialButton var4 = (MaterialButton)ViewBindings.findChildViewById(var0, var1);
            if (var4 != null) {
               var1 = R.id.description_value;
               TextInputEditText var15 = (TextInputEditText)ViewBindings.findChildViewById(var0, var1);
               if (var15 != null) {
                  var1 = R.id.dropdown_issue_type;
                  TextView var16 = (TextView)ViewBindings.findChildViewById(var0, var1);
                  if (var16 != null) {
                     var1 = R.id.dropdown_length;
                     TextView var10 = (TextView)ViewBindings.findChildViewById(var0, var1);
                     if (var10 != null) {
                        var1 = R.id.et_max_log_size;
                        EditText var14 = (EditText)ViewBindings.findChildViewById(var0, var1);
                        if (var14 != null) {
                           var1 = R.id.input_description;
                           TextInputLayout var12 = (TextInputLayout)ViewBindings.findChildViewById(var0, var1);
                           if (var12 != null) {
                              var1 = R.id.label_issue_type;
                              TextView var6 = (TextView)ViewBindings.findChildViewById(var0, var1);
                              if (var6 != null) {
                                 var1 = R.id.label_length;
                                 TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                 if (var5 != null) {
                                    var1 = R.id.label_max_log_size;
                                    TextView var2 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                    if (var2 != null) {
                                       var1 = R.id.label_max_log_size_unit;
                                       TextView var13 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                       if (var13 != null) {
                                          var1 = R.id.tv_current_log_size;
                                          TextView var3 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                          if (var3 != null) {
                                             var1 = R.id.tv_progress;
                                             TextView var11 = (TextView)ViewBindings.findChildViewById(var0, var1);
                                             if (var11 != null) {
                                                var1 = R.id.tv_title;
                                                AppCompatTextView var9 = (AppCompatTextView)ViewBindings.findChildViewById(var0, var1);
                                                if (var9 != null) {
                                                   return new ActivityUploadLogBinding((ConstraintLayout)var0, var7, var8, var4, var15, var16, var10, var14, var12, var6, var5, var2, var13, var3, var11, var9);
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

   public static ActivityUploadLogBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static ActivityUploadLogBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.activity_upload_log, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
