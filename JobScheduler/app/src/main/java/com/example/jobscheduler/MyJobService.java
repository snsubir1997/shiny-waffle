package com.example.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

public class MyJobService extends JobService {

    public static final String TAG = "JobSc";
    private boolean jobCancelled = false;

    @Override
    public boolean onStartJob(final JobParameters params) {
        Log.d(TAG,"Job Started");
        //myBackgroundMethod(params);
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        Log.d(TAG, "Jobstarted " + i);
                        if (jobCancelled) {
                            return;
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Log.d(TAG, "Job finished");
                    jobFinished(params, false);
                }
            }).start();
    return true;
    }



    private void myBackgroundMethod(JobParameters params) {
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d(TAG,"Job cancelled before completion");
        jobCancelled = true;
        return true;
    }
}
