/*
 * Copyright © 2014 Cask Data, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package co.cask.tigon.data.transaction.queue;


import co.cask.tigon.data.queue.QueueName;
import co.cask.tigon.data.transaction.EntityAdmin;

import java.util.Map;

/**
 *
 */
public interface QueueAdmin extends EntityAdmin {

  /**
   * Deletes all entries for all queues.
   */
  void dropAll() throws Exception;

  /**
   * Deletes all queues for a flow, for example if the flow is deleted.
   * todo: make this independent of the concept of a flow
   */
  void dropAllForFlow(String app, String flow) throws Exception;

  /**
   * Clears all queues for a flow, for example if the flow is upgraded and old .
   * todo: make this independent of the concept of a flow
   */
  void clearAllForFlow(String app, String flow) throws Exception;

  /**
   * Sets the number of consumer instances for the given consumer group in a queue.
   * @param queueName Name of the queue.
   * @param groupId The consumer group to alter.
   * @param instances Number of instances.
   */
  void configureInstances(QueueName queueName, long groupId, int instances) throws Exception;


  /**
   * Sets the consumer groups information for the given queue.
   * @param queueName Name of the queue.
   * @param groupInfo A map from groupId to number of instances of each group.
   */
  void configureGroups(QueueName queueName, Map<Long, Integer> groupInfo) throws Exception;

  /**
   * Performs upgrade action for all queues.
   */
  void upgrade() throws Exception;
}
