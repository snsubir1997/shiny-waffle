package com.example.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobInfo.Builder;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void startJob(View view) {
        ComponentName componentName = new ComponentName(this,MyJobService.class);
        JobInfo jobInfo = new JobInfo.Builder(1234,componentName)
                .setRequiresCharging(true)
                .setRequiredNetworkType(JobInfo.NETWORK_TYPE_UNMETERED)
                .setPersisted(true)
                .setPeriodic(15*60*1000)
                .build();
;
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int resultCode = jobScheduler.schedule(jobInfo);

        if(resultCode == JobScheduler.RESULT_SUCCESS)
        {
            Log.d(TAG,"JobScheduled");
        }
        else
        {
            Log.d(TAG,"JobSchedulngFailed");
        }

    }

    public void stopJob(View view) {
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.cancel(123);
        Log.d(TAG,"JobCancelled");
    }
}