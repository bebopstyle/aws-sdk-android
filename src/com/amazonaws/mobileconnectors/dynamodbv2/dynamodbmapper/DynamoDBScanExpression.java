/*
 * Copyright 2011-2014 Amazon Technologies, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at:
 *
 *    http://aws.amazon.com/apache2.0
 *
 * This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES
 * OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amazonaws.mobileconnectors.dynamodbv2.dynamodbmapper;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ConditionalOperator;

/**
 * Options for filtering results from a scan operation. For example, callers can
 * specify filter conditions so that only objects whose attributes match
 * different conditions are returned (see {@link ComparisonOperator} for more
 * information on the available comparison types).
 * 
 * @see DynamoDBMapper#scan(Class, DynamoDBScanExpression)
 */
public class DynamoDBScanExpression {

    /** Optional filter to limit the results of the scan. */
    private Map<String, Condition> scanFilter;

    /** The exclusive start key for this scan. */
    private Map<String, AttributeValue> exclusiveStartKey;

    /** The limit of items to scan during this scan. */
    private Integer limit;

    /** 
     * The total number of segments into which the scan will be divided.
     * Only required for parallel scan operation.
     */
    private Integer totalSegments;

    /** 
     * The ID (zero-based) of the segment to be scanned.
     * Only required for parallel scan operation.
     */
    private Integer segment;

    /**
     * The logical operator on the filter conditions of this scan.
     */
    private String conditionalOperator;

    /**
     * Returns the scan filter as a map of attribute names to conditions.
     * 
     * @return The scan filter as a map of attribute names to conditions.
     */
    public Map<String, Condition> getScanFilter() {
        return scanFilter;
    }

    /**
     * Sets the scan filter to the map of attribute names to conditions given.
     * 
     * @param scanFilter
     *            The map of attribute names to conditions to use when filtering
     *            scan results.
     */
    public void setScanFilter(Map<String, Condition> scanFilter) {
        this.scanFilter = scanFilter;
    }

    /**
     * Sets the scan filter to the map of attribute names to conditions given
     * and returns a pointer to this object for method-chaining.
     * 
     * @param scanFilter
     *            The map of attribute names to conditions to use when filtering
     *            scan results.
     */
    public DynamoDBScanExpression withScanFilter(Map<String, Condition> scanFilter) {
        setScanFilter(scanFilter);
        return this;
    }

    /**
     * Adds a new filter condition to the current scan filter.
     * 
     * @param attributeName
     *            The name of the attribute on which the specified condition
     *            operates.
     * @param condition
     *            The condition which describes how the specified attribute is
     *            compared and if a row of data is included in the results
     *            returned by the scan operation.
     */
    public void addFilterCondition(String attributeName, Condition condition) {
        if ( scanFilter == null )
            scanFilter = new HashMap<String, Condition>();

        scanFilter.put(attributeName, condition);
    }

    /**
     * Adds a new filter condition to the current scan filter and returns a
     * pointer to this object for method-chaining.
     * 
     * @param attributeName
     *            The name of the attribute on which the specified condition
     *            operates.
     * @param condition
     *            The condition which describes how the specified attribute is
     *            compared and if a row of data is included in the results
     *            returned by the scan operation.
     */
    public DynamoDBScanExpression withFilterConditionEntry(String attributeName, Condition condition) {
        if ( scanFilter == null )
            scanFilter = new HashMap<String, Condition>();

        scanFilter.put(attributeName, condition);
        return this;
    }

    
    /**
     * Returns the exclusive start key for this scan.
     */
    public Map<String, AttributeValue> getExclusiveStartKey() {
        return exclusiveStartKey;
    }

    /**
     * Sets the exclusive start key for this scan.
     */
    public void setExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey) {
        this.exclusiveStartKey = exclusiveStartKey;
    }

    /**
     * Sets the exclusive start key for this scan and returns a pointer to this
     * object for method-chaining.
     */
    public DynamoDBScanExpression withExclusiveStartKey(Map<String, AttributeValue> exclusiveStartKey) {
        this.exclusiveStartKey = exclusiveStartKey;
        return this;
    }

    /**
     * Returns the limit of items to scan during this scan.
     * <p>
     * Use with caution. Please note that this is <b>not</b> the same as the
     * number of items to return from the scan operation -- the operation will
     * cease and return as soon as this many items are scanned, even if no
     * matching results are found. Furthermore, {@link PaginatedScanList} will
     * execute as many scan operations as necessary until it either reaches the
     * end of the result set as indicated by DynamoDB or enough elements are
     * available to fulfill the list operation (e.g. iteration). Therefore,
     * except when scanning without a scan filter, it's usually bad practice to
     * set a low limit, since doing so will often generate the same amount of
     * traffic to DynamoDB but with a greater number of round trips and
     * therefore more overall latency.
     */
    public Integer getLimit() {
        return limit;
    }

    /**
     * Sets the limit of items to scan during this scan. Please note that this
     * is <b>not</b> the same as the number of items to return from the scan
     * operation -- the operation will cease and return as soon as this many
     * items are scanned, even if no matching results are found.
     * 
     * @see DynamoDBScanExpression#getLimit()
     */
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    /**
     * Sets the limit of items to scan and returns a pointer to this object for
     * method-chaining. Please note that this is <b>not</b> the same as the
     * number of items to return from the scan operation -- the operation will
     * cease and return as soon as this many items are scanned, even if no
     * matching results are found.
     * 
     * @see DynamoDBScanExpression#getLimit()
     */
    public DynamoDBScanExpression withLimit(Integer limit) {
        this.limit = limit;
        return this;
    }

    /**
     * Returns the total number of segments into which the scan will be divided.
     */
    public Integer getTotalSegments() {
        return totalSegments;
    }

    /**
     * Sets the total number of segments into which the scan will be divided.
     */
    public void setTotalSegments(Integer totalSegments) {
        this.totalSegments = totalSegments;
    }

    /**
     * Sets the total number of segments into which the scan will be divided and
     * returns a pointer to this object for method-chaining.
     */
    public DynamoDBScanExpression withTotalSegments(Integer totalSegments) {
        setTotalSegments(totalSegments);
        return this;
    }

    /**
     * Returns the ID of the segment to be scanned.
     */
    public Integer getSegment() {
        return segment;
    }

    /**
     * Sets the ID of the segment to be scanned.
     */
    public void setSegment(Integer segment) {
        this.segment = segment;
    }

    /**
     * Sets the ID of the segment to be scanned and returns a pointer to this
     * object for method-chaining.
     */
    public DynamoDBScanExpression withSegment(Integer segment) {
        setSegment(segment);
        return this;
    }

    /**
     * Returns the logical operator on the filter conditions of this scan.
     */
    public String getConditionalOperator() {
        return conditionalOperator;
    }

    /**
     * Sets the logical operator on the filter conditions of this scan.
     */
    public void setConditionalOperator(String conditionalOperator) {
        this.conditionalOperator = conditionalOperator;
    }

    /**
     * Sets the logical operator on the filter conditions of this scan and
     * returns a pointer to this object for method-chaining.
     */
    public DynamoDBScanExpression withConditionalOperator(String conditionalOperator) {
        setConditionalOperator(conditionalOperator);
        return this;
    }

    /**
     * Sets the logical operator on the filter conditions of this scan.
     */
    public void setConditionalOperator(ConditionalOperator conditionalOperator) {
        setConditionalOperator(conditionalOperator.toString());
    }

    /**
     * Sets the logical operator on the filter conditions of this scan and
     * returns a pointer to this object for method-chaining.
     */
    public DynamoDBScanExpression withConditionalOperator(ConditionalOperator conditionalOperator) {
        return withConditionalOperator(conditionalOperator.toString());
    }
}
