package com.giffing.bucket4j.spring.boot.starter.context.metrics;

import java.util.List;

import io.github.bucket4j.BucketListener;

/**
 * Marker Interface
 *
 */
public class MetricBucketListener implements BucketListener {

    private final String name;
	private final List<MetricTagResult> tags;
	private final MetricHandler metricHandler;

    public MetricBucketListener(String name, MetricHandler metricHandler, List<MetricTagResult> tags) {
		this.name = name;
		this.tags = tags;
		this.metricHandler = metricHandler;
	}
    
    @Override
    public void onConsumed(long tokens) {
    	metricHandler.onConsumed(name, tokens, tags);
    }

    @Override
    public void onRejected(long tokens) {
        metricHandler.onRejected(name, tokens, tags);
    }

    @Override
    public void onParked(long nanos) {
    }

    public long getConsumed() {
        return 0;
    }

    public long getRejected() {
        return 0;
    }

    public long getParkedNanos() {
        return 0;
    }

    public long getInterrupted() {
        return 0;
    }

	@Override
	public void onInterrupted(InterruptedException e) {
	}

	@Override
	public void onDelayed(long nanos) {
	}

	public String getName() {
		return name;
	}

}
