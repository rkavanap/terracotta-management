/*
 * Copyright Terracotta, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.terracotta.management.entity;

import org.terracotta.management.model.capabilities.Capability;
import org.terracotta.management.model.context.ContextContainer;
import org.terracotta.voltron.proxy.Async;
import org.terracotta.voltron.proxy.ClientId;

import java.util.Collection;
import java.util.concurrent.Future;

/**
 * @author Mathieu Carbou
 */
public interface ManagementAgent {

  /**
   * Exposes this management registry output (context container and capabilities) over this connection.
   * <p>
   * The clientDescriptor will be the ClientDescriptor server-side. Client-side, when calling this method, this field is not required.
   */
  @Async(Async.Ack.NONE)
  Future<Void> expose(ContextContainer contextContainer, Collection<Capability> capabilities, @ClientId Object clientDescriptor);

}
