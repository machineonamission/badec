package com.blueair.viewcore.viewmodel;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(
   d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0006\u0005\u0006\u0007\b\t\nB\t\b\u0004¢\u0006\u0004\b\u0003\u0010\u0004\u0082\u0001\u0006\u000b\f\r\u000e\u000f\u0010¨\u0006\u0011"},
   d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "T", "", "<init>", "()V", "ShowProgress", "ShowSnackbar", "ShowPopup", "ShowConfirmation", "PressBack", "FinishActivity", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$FinishActivity;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$PressBack;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowConfirmation;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowPopup;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowProgress;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowSnackbar;", "viewcore_otherRelease"},
   k = 1,
   mv = {2, 2, 0},
   xi = 48
)
public abstract class BaseViewModelAction {
   private BaseViewModelAction() {
   }

   // $FF: synthetic method
   public BaseViewModelAction(DefaultConstructorMarker var1) {
      this();
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$FinishActivity;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class FinishActivity extends BaseViewModelAction {
      public static final FinishActivity INSTANCE = new FinishActivity();

      private FinishActivity() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$PressBack;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class PressBack extends BaseViewModelAction {
      public static final PressBack INSTANCE = new PressBack();

      private PressBack() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowConfirmation;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "Lcom/blueair/viewcore/viewmodel/ConfirmationMessage;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ShowConfirmation extends BaseViewModelAction {
      public static final ShowConfirmation INSTANCE = new ShowConfirmation();

      private ShowConfirmation() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowPopup;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "Lcom/blueair/viewcore/viewmodel/PopupMessage;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ShowPopup extends BaseViewModelAction {
      public static final ShowPopup INSTANCE = new ShowPopup();

      private ShowPopup() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowProgress;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ShowProgress extends BaseViewModelAction {
      public static final ShowProgress INSTANCE = new ShowProgress();

      private ShowProgress() {
         super((DefaultConstructorMarker)null);
      }
   }

   @Metadata(
      d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0005"},
      d2 = {"Lcom/blueair/viewcore/viewmodel/BaseViewModelAction$ShowSnackbar;", "Lcom/blueair/viewcore/viewmodel/BaseViewModelAction;", "Lcom/blueair/viewcore/viewmodel/SnackbarMessage;", "<init>", "()V", "viewcore_otherRelease"},
      k = 1,
      mv = {2, 2, 0},
      xi = 48
   )
   public static final class ShowSnackbar extends BaseViewModelAction {
      public static final ShowSnackbar INSTANCE = new ShowSnackbar();

      private ShowSnackbar() {
         super((DefaultConstructorMarker)null);
      }
   }
}
