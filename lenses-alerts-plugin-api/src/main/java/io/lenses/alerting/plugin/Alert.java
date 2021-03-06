/*
 * Copyright 2017-2019 Lenses.io Ltd
 */
package io.lenses.alerting.plugin;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Alert {

    public Alert(AlertLevel level,
                 String category,
                 List<String> tags,
                 String instance,
                 String summary,
                 Optional<String> docs,
                 int alertId,
                 Map<String, String> labels) {
        this(level, category, tags, instance, summary, docs, System.currentTimeMillis(), alertId, labels);
    }

    public Alert(AlertLevel level,
                 String category,
                 List<String> tags,
                 String instance,
                 String summary,
                 Optional<String> docs,
                 Long timestamp,
                 int alertId,
                 Map<String, String> labels) {
        this.level = level;
        this.category = category;
        this.tags = tags;
        this.instance = instance;
        this.summary = summary;
        this.timestamp = timestamp;
        this.docs = docs;
        this.alertId = alertId;
        this.labels = labels;
    }


    /**
     * The importance of the alert
     */
    public final AlertLevel level;

    /**
     * Category for the alert
     */
    public final String category;

    /**
     * Allows the user to configure some routing information
     */
    public final List<String> tags;

    /**
     * Contains the lenses instance raising the alert
     */
    public final String instance;

    /**
     * Returns the information for this alert. For example: event x has occurred and you need to do this.
     */
    public final String summary;

    /**
     * The epoch time when this alert was created
     */
    public final Long timestamp;

    /**
     * Provides documentation information related to the alert.
     */
    public final Optional<String> docs;

    /**
     * Returns a unique identifier for the alert type
     */
    public final int alertId;

    /**
     * Keeps a list of key-value
     */
    public final Map<String, String> labels;
}
