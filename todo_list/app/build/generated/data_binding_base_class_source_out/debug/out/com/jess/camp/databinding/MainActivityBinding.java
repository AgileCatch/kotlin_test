// Generated by view binder compiler. Do not edit!
package com.jess.camp.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;
import com.jess.camp.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class MainActivityBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final FloatingActionButton fabAddTodo;

  @NonNull
  public final TabLayout tabLayout;

  @NonNull
  public final Toolbar toolBar;

  @NonNull
  public final ViewPager2 viewPager;

  private MainActivityBinding(@NonNull ConstraintLayout rootView,
      @NonNull FloatingActionButton fabAddTodo, @NonNull TabLayout tabLayout,
      @NonNull Toolbar toolBar, @NonNull ViewPager2 viewPager) {
    this.rootView = rootView;
    this.fabAddTodo = fabAddTodo;
    this.tabLayout = tabLayout;
    this.toolBar = toolBar;
    this.viewPager = viewPager;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static MainActivityBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static MainActivityBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.main_activity, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static MainActivityBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.fab_add_todo;
      FloatingActionButton fabAddTodo = ViewBindings.findChildViewById(rootView, id);
      if (fabAddTodo == null) {
        break missingId;
      }

      id = R.id.tab_layout;
      TabLayout tabLayout = ViewBindings.findChildViewById(rootView, id);
      if (tabLayout == null) {
        break missingId;
      }

      id = R.id.tool_bar;
      Toolbar toolBar = ViewBindings.findChildViewById(rootView, id);
      if (toolBar == null) {
        break missingId;
      }

      id = R.id.view_pager;
      ViewPager2 viewPager = ViewBindings.findChildViewById(rootView, id);
      if (viewPager == null) {
        break missingId;
      }

      return new MainActivityBinding((ConstraintLayout) rootView, fabAddTodo, tabLayout, toolBar,
          viewPager);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
