package com.whc.myapplication

import android.content.Context
import androidx.work.Worker
import androidx.work.WorkerParameters
import java.util.concurrent.atomic.AtomicInteger

class UploadWorker(context: Context, workerParams: WorkerParameters) : Worker(context, workerParams) {
    val atomicInteger = AtomicInteger(0)
    override fun doWork(): Result {
        println("worker:${atomicInteger.addAndGet(1)}")
        return Result.success()
    }
}