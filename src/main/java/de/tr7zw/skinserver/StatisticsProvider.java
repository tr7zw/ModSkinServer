package de.tr7zw.skinserver;

import java.time.Duration;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.github.rollingmetrics.counter.SmoothlyDecayingRollingCounter;

@Singleton
@Path("/stats")
public class StatisticsProvider {

    public final SmoothlyDecayingRollingCounter requestCounter = new SmoothlyDecayingRollingCounter(
            Duration.ofMinutes(1), 10);
    public final SmoothlyDecayingRollingCounter notFoundCounter = new SmoothlyDecayingRollingCounter(
            Duration.ofMinutes(1), 10);

    @GET
    public Stats getStats() {
        return new Stats();
    }

    class Stats {
        public long requestsLast60Seconds = requestCounter.getSum();
        public long successfulLast60Seconds = requestCounter.getSum() - notFoundCounter.getSum();
        public long notFoundLast60Seconds = notFoundCounter.getSum();
    }

}
