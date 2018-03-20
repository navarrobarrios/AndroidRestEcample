package com.navarrobarrios.androidrestexample.activities;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.navarrobarrios.androidrestexample.R;
import com.navarrobarrios.androidrestexample.activities.login_activity.LoginActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    //region Variables
    //region Global Variables
    private int fadeCounter;
    //endregion
    //region Views
    @BindView(R.id.activity_splash_name)
    TextView name;
    @BindView(R.id.activity_splash_subname)
    TextView subname;
    //endregion
    //endregion

    //region Activity Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        animateSplash();
    }
    //endregion

    //region Local Methods
    private void animateSplash(){
        final float alphaMin = 0.2f;
        final float alphaMax = 2.0f;
        final int millisecondsDurarion = 1000;

        name.animate()
                .alpha(alphaMax)
                .setDuration(millisecondsDurarion)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        name.animate()
                                .alpha(alphaMin)
                                .setDuration(millisecondsDurarion)
                                .setListener(new Animator.AnimatorListener() {
                                    @Override
                                    public void onAnimationStart(Animator animator) {

                                    }

                                    @Override
                                    public void onAnimationEnd(Animator animator) {
                                        name.animate()
                                                .alpha(alphaMax)
                                                .setDuration(millisecondsDurarion)
                                                .setListener(new Animator.AnimatorListener() {
                                                    @Override
                                                    public void onAnimationStart(Animator animator) {

                                                    }

                                                    @Override
                                                    public void onAnimationEnd(Animator animator) {
                                                        checkIfIsLoged();
//                                                            name.animate()
//                                                                    .alpha(alphaMin)
//                                                                    .setDuration(millisecondsDurarion)
//                                                                    .setListener(new Animator.AnimatorListener() {
//                                                                        @Override
//                                                                        public void onAnimationStart(Animator animator) {
//
//                                                                        }
//
//                                                                        @Override
//                                                                        public void onAnimationEnd(Animator animator) {
//                                                                            name.animate()
//                                                                                    .alpha(alphaMax)
//                                                                                    .setDuration(millisecondsDurarion)
//                                                                                    .setListener(new Animator.AnimatorListener() {
//                                                                                        @Override
//                                                                                        public void onAnimationStart(Animator animator) {
//
//                                                                                        }
//
//                                                                                        @Override
//                                                                                        public void onAnimationEnd(Animator animator) {
//                                                                                            checkIfIsLoged();
//                                                                                        }
//
//                                                                                        @Override
//                                                                                        public void onAnimationCancel(Animator animator) {
//
//                                                                                        }
//
//                                                                                        @Override
//                                                                                        public void onAnimationRepeat(Animator animator) {
//
//                                                                                        }
//                                                                                    });
//                                                                        }
//
//                                                                        @Override
//                                                                        public void onAnimationCancel(Animator animator) {
//
//                                                                        }
//
//                                                                        @Override
//                                                                        public void onAnimationRepeat(Animator animator) {
//
//                                                                        }
//                                                                    });
                                                    }

                                                    @Override
                                                    public void onAnimationCancel(Animator animator) {

                                                    }

                                                    @Override
                                                    public void onAnimationRepeat(Animator animator) {

                                                    }
                                                });
                                    }

                                    @Override
                                    public void onAnimationCancel(Animator animator) {

                                    }

                                    @Override
                                    public void onAnimationRepeat(Animator animator) {

                                    }
                                });
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

        subname.animate()
                .alpha(alphaMax)
                .setDuration(millisecondsDurarion);
    }

    private void checkIfIsLoged(){
        inflateLoginActivivity();
    }

    private void inflateLoginActivivity(){
        Intent loginActivity = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(loginActivity);
        SplashActivity.this.finish();
        overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
    //endregion

}
