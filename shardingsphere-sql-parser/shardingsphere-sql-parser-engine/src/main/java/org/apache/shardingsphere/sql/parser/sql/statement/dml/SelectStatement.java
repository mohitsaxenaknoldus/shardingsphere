/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.sql.parser.sql.statement.dml;

import com.google.common.base.Optional;
import lombok.Getter;
import lombok.Setter;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.item.ProjectionsSegment;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.order.GroupBySegment;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.order.OrderBySegment;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.pagination.limit.LimitSegment;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.predicate.LockSegment;
import org.apache.shardingsphere.sql.parser.sql.segment.dml.predicate.WhereSegment;
import org.apache.shardingsphere.sql.parser.sql.segment.generic.TableSegment;
import org.apache.shardingsphere.sql.parser.sql.statement.generic.TableSegmentsAvailable;
import org.apache.shardingsphere.sql.parser.sql.statement.generic.WhereSegmentAvailable;

import java.util.Collection;
import java.util.LinkedList;

/**
 * Select statement.
 */
@Getter
@Setter
public final class SelectStatement extends DMLStatement implements TableSegmentsAvailable, WhereSegmentAvailable {
    
    private final Collection<TableSegment> tables = new LinkedList<>();
    
    private ProjectionsSegment projections;
    
    private WhereSegment where;
    
    private GroupBySegment groupBy;
    
    private OrderBySegment orderBy;
    
    private LimitSegment limit;
    
    private SelectStatement parentStatement;
    
    private LockSegment lock;
    
    @Override
    public Optional<WhereSegment> getWhere() {
        return Optional.fromNullable(where);
    }
    
    /**
     * Get group by segment.
     * 
     * @return group by segment
     */
    public Optional<GroupBySegment> getGroupBy() {
        return Optional.fromNullable(groupBy);
    }
    
    /**
     * Get order by segment.
     *
     * @return order by segment
     */
    public Optional<OrderBySegment> getOrderBy() {
        return Optional.fromNullable(orderBy);
    }
    
    /**
     * Get order by segment.
     *
     * @return order by segment
     */
    public Optional<LimitSegment> getLimit() {
        return Optional.fromNullable(limit);
    }
    
    /**
     * Get lock segment.
     *
     * @return lock segment
     */
    public Optional<LockSegment> getLock() {
        return Optional.fromNullable(lock);
    }
}
