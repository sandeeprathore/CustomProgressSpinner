package org.sam.applications.sample.customprogressspinner;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

public class CustomProgressSpinner extends Activity {

	private Button showDialog;
	private AnimationDrawable progressAnimation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_custom_progress_spinner);

		showDialog = (Button)findViewById(R.id.showDialog);
		showDialog.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View view) {
				final Dialog dialog = new Dialog(CustomProgressSpinner.this);
				//Set Background of Dialog - Custom 
				dialog.getWindow().setBackgroundDrawableResource(R.drawable.dialog_backround);
				
				//Remove the Title
				//dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
				
				dialog.setTitle(R.string.loading);
				
				//Set the View of the Dialog - Custom
				dialog.setContentView(R.layout.dialog);
				
				//Set the title of the Dialog
				//dialog.setTitle("Title...");
				
				ImageView progressSpinner = (ImageView) dialog.findViewById(R.id.progressSpinner);

				//Set the background of the image - In this case an animation (/res/anim folder)
				progressSpinner.setBackgroundResource(R.anim.progress_animation);
				
				//Get the image background and attach the AnimationDrawable to it.
				progressAnimation = (AnimationDrawable) progressSpinner.getBackground();
				
				//Start the animation after the dialog is displayed.
				dialog.setOnShowListener(new OnShowListener() {
					@Override
					public void onShow(DialogInterface dialog) {
						progressAnimation.start();
					}
				});
				
				dialog.show();
			}
		});

	}

}
