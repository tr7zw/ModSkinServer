package de.tr7zw.skinserver;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import io.quarkus.vertx.web.Route;
import io.vertx.ext.web.RoutingContext;
import io.vertx.ext.web.handler.FileSystemAccess;
import io.vertx.ext.web.handler.StaticHandler;

@ApplicationScoped
public class SkinServer {

    @Inject
    StatisticsProvider statistics;

    @Route(path = "/*", methods = Route.HttpMethod.GET)
    void getSkin(RoutingContext rc) {
        statistics.requestCounter.add(1);
        StaticHandler.create(FileSystemAccess.RELATIVE, "content/").handle(rc);
    }

}
