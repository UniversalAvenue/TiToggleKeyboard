/**
 * This file was auto-generated by the Titanium Module SDK helper for Android
 * Appcelerator Titanium Mobile
 * Copyright (c) 2009-2013 by Appcelerator, Inc. All Rights Reserved.
 * Licensed under the terms of the Apache Public License
 * Please see the LICENSE included with this distribution for details.
 *
 */
package be.k0suke.titogglekeyboard;

import org.appcelerator.kroll.KrollModule;
import org.appcelerator.kroll.annotations.Kroll;

import org.appcelerator.titanium.TiApplication;
import org.appcelerator.kroll.common.Log;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;
import org.appcelerator.titanium.proxy.TiViewProxy;

@Kroll.module(name="Titogglekeyboard", id="be.k0suke.titogglekeyboard")
public class TitogglekeyboardModule extends KrollModule
{
	// Standard Debugging variables
	private static final String TAG = "TitogglekeyboardModule";

	public TitogglekeyboardModule()
	{
		super();
	}

	@Kroll.onAppCreate
	public static void onAppCreate(TiApplication app)
	{
		Log.d(TAG, "inside onAppCreate");
		// put module init code that needs to run when the application is created
	}

	// Methods
	@Kroll.method
	public void show()
	{
		Context context = TiApplication.getInstance().getApplicationContext();
		InputMethodManager manager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		manager.toggleSoftInput(1, InputMethodManager.SHOW_IMPLICIT);
	}

	@Kroll.method
	public void hide()
	{
		Context context = TiApplication.getInstance().getApplicationContext();
		InputMethodManager manager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		manager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
	}

	@Kroll.method
	public void hideForView(TiViewProxy proxy)
	{
		if (proxy.peekView() != null) {
			Context context = TiApplication.getInstance().getApplicationContext();
			InputMethodManager manager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);

			manager.hideSoftInputFromWindow(proxy.peekView().getNativeView().getWindowToken(), 0);
		}
	}

	@Kroll.method
	public Boolean toggle()
	{
		Context context = TiApplication.getInstance().getApplicationContext();
		InputMethodManager manager = (InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
		if (manager.isActive()) {
			manager.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
			return false;
		} else {
			manager.toggleSoftInput(1, InputMethodManager.SHOW_IMPLICIT);
			return true;
		}
	}
}