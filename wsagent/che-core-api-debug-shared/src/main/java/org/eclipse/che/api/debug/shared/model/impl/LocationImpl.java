/*
 * Copyright (c) 2012-2018 Red Hat, Inc.
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   Red Hat, Inc. - initial API and implementation
 */
package org.eclipse.che.api.debug.shared.model.impl;

import com.google.common.base.Objects;
import org.eclipse.che.api.debug.shared.model.Location;
import org.eclipse.che.api.debug.shared.model.Method;

/** @author Anatoliy Bazko */
public class LocationImpl implements Location {
  private final String target;
  private final int lineNumber;
  private final boolean externalResource;
  private final String externalResourceId;
  private final String resourceProjectPath;
  private final Method method;
  private final long threadId;

  public LocationImpl(
      String target,
      int lineNumber,
      boolean externalResource,
      String externalResourceId,
      String resourceProjectPath,
      Method method,
      long threadId) {
    this.target = target;
    this.lineNumber = lineNumber;
    this.externalResource = externalResource;
    this.externalResourceId = externalResourceId;
    this.resourceProjectPath = resourceProjectPath;
    this.method = method;
    this.threadId = threadId;
  }

  public LocationImpl(
      String target,
      int lineNumber,
      boolean externalResource,
      String externalResourceId,
      String resourceProjectPath) {
    this(target, lineNumber, externalResource, externalResourceId, resourceProjectPath, null, -1);
  }

  public LocationImpl(String target, int lineNumber, String resourceProjectPath) {
    this(target, lineNumber, false, null, resourceProjectPath, null, -1);
  }

  public LocationImpl(String target, int lineNumber) {
    this(target, lineNumber, false, null, null, null, -1);
  }

  public LocationImpl(String target) {
    this(target, 0, false, null, null, null, -1);
  }

  @Override
  public String getTarget() {
    return target;
  }

  @Override
  public int getLineNumber() {
    return lineNumber;
  }

  @Override
  public boolean isExternalResource() {
    return externalResource;
  }

  @Override
  public String getExternalResourceId() {
    return externalResourceId;
  }

  @Override
  public String getResourceProjectPath() {
    return resourceProjectPath;
  }

  @Override
  public Method getMethod() {
    return method;
  }

  @Override
  public long getThreadId() {
    return threadId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof LocationImpl)) return false;
    LocationImpl location = (LocationImpl) o;
    return lineNumber == location.lineNumber
        && externalResource == location.externalResource
        && threadId == location.threadId
        && Objects.equal(target, location.target)
        && Objects.equal(externalResourceId, location.externalResourceId)
        && Objects.equal(resourceProjectPath, location.resourceProjectPath)
        && Objects.equal(method, location.method);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(
        target,
        lineNumber,
        externalResource,
        externalResourceId,
        resourceProjectPath,
        method,
        threadId);
  }

  @Override
  public String toString() {
    return "LocationImpl{"
        + "target='"
        + target
        + '\''
        + ", lineNumber="
        + lineNumber
        + ", externalResource="
        + externalResource
        + ", externalResourceId='"
        + externalResourceId
        + '\''
        + ", resourceProjectPath='"
        + resourceProjectPath
        + '\''
        + ", method="
        + method
        + ", threadId="
        + threadId
        + '}';
  }
}
