package com.blueair.outdoor.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.blueair.outdoor.R;

public final class FragmentSearchBinding implements ViewBinding {
   public final Button cancelBtn;
   public final Guideline endGuideline;
   public final TextView headerTextView;
   public final TextView noResultsTextView;
   private final ConstraintLayout rootView;
   public final EditText searchBar;
   public final ImageButton searchClearBtn;
   public final RecyclerView searchResults;
   public final Guideline startGuideline;
   public final Guideline topGuideline;

   private FragmentSearchBinding(ConstraintLayout var1, Button var2, Guideline var3, TextView var4, TextView var5, EditText var6, ImageButton var7, RecyclerView var8, Guideline var9, Guideline var10) {
      this.rootView = var1;
      this.cancelBtn = var2;
      this.endGuideline = var3;
      this.headerTextView = var4;
      this.noResultsTextView = var5;
      this.searchBar = var6;
      this.searchClearBtn = var7;
      this.searchResults = var8;
      this.startGuideline = var9;
      this.topGuideline = var10;
   }

   public static FragmentSearchBinding bind(View var0) {
      int var1 = R.id.cancel_btn;
      Button var4 = (Button)ViewBindings.findChildViewById(var0, var1);
      if (var4 != null) {
         var1 = R.id.end_guideline;
         Guideline var7 = (Guideline)ViewBindings.findChildViewById(var0, var1);
         if (var7 != null) {
            var1 = R.id.headerTextView;
            TextView var5 = (TextView)ViewBindings.findChildViewById(var0, var1);
            if (var5 != null) {
               var1 = R.id.noResultsTextView;
               TextView var9 = (TextView)ViewBindings.findChildViewById(var0, var1);
               if (var9 != null) {
                  var1 = R.id.search_bar;
                  EditText var6 = (EditText)ViewBindings.findChildViewById(var0, var1);
                  if (var6 != null) {
                     var1 = R.id.search_clear_btn;
                     ImageButton var10 = (ImageButton)ViewBindings.findChildViewById(var0, var1);
                     if (var10 != null) {
                        var1 = R.id.search_results;
                        RecyclerView var2 = (RecyclerView)ViewBindings.findChildViewById(var0, var1);
                        if (var2 != null) {
                           var1 = R.id.start_guideline;
                           Guideline var3 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                           if (var3 != null) {
                              var1 = R.id.top_guideline;
                              Guideline var8 = (Guideline)ViewBindings.findChildViewById(var0, var1);
                              if (var8 != null) {
                                 return new FragmentSearchBinding((ConstraintLayout)var0, var4, var7, var5, var9, var6, var10, var2, var3, var8);
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

   public static FragmentSearchBinding inflate(LayoutInflater var0) {
      return inflate(var0, (ViewGroup)null, false);
   }

   public static FragmentSearchBinding inflate(LayoutInflater var0, ViewGroup var1, boolean var2) {
      View var3 = var0.inflate(R.layout.fragment_search, var1, false);
      if (var2) {
         var1.addView(var3);
      }

      return bind(var3);
   }

   public ConstraintLayout getRoot() {
      return this.rootView;
   }
}
