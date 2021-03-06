/*
 * Copyright 2017-2019 Lenses.io Ltd
 */
package io.lenses.alerting.plugin.javaapi;

import io.lenses.alerting.plugin.javaapi.util.Try;

import java.util.List;
import java.util.Map;

public interface AlertingPlugin {

    /**
     * Provides the name for the alert integration service. For Slack integration this will read Slack.
     * @return The alert integration name
     */
    String name();

    /**
     * Provides information on what and how this alert integration service works.
     * @return
     */
    String description();

    /**
     * Provides a list of all the configuration keys
     * @return
     */
    List<ConfigEntry> configKeys();

    /**
     * Returns AlertingService for valid configuration (depends on the alerting service class).
     * @param config service configuration
     * @return alerting service or failure
     */
    Try<AlertingService> init(Map<String, String> config);
}