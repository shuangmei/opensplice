/*
 *                         Vortex OpenSplice
 *
 *   This software and documentation are Copyright 2006 to TO_YEAR ADLINK
 *   Technology Limited, its affiliated companies and licensors. All rights
 *   reserved.
 *
 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 *
 */
package org.opensplice.dds.core.event;

import org.omg.dds.core.ServiceEnvironment;
import org.omg.dds.core.event.InconsistentTopicEvent;
import org.omg.dds.core.status.InconsistentTopicStatus;
import org.omg.dds.topic.Topic;
import org.opensplice.dds.core.OsplServiceEnvironment;

public class InconsistentTopicEventImpl<TYPE> extends
        InconsistentTopicEvent<TYPE> {
    private static final long serialVersionUID = 8593632953038364165L;
    private final transient OsplServiceEnvironment environment;
    private final InconsistentTopicStatus status;

    public InconsistentTopicEventImpl(OsplServiceEnvironment environment,
            Topic<TYPE> source, InconsistentTopicStatus status) {
        super(source);
        this.environment = environment;
        this.status = status;
        this.source = source;
    }

    @Override
    public ServiceEnvironment getEnvironment() {
        return this.environment;
    }

    @Override
    public InconsistentTopicStatus getStatus() {
        return this.status;
    }

    @Override
    public InconsistentTopicEvent<TYPE> clone() {
        return new InconsistentTopicEventImpl<TYPE>(this.environment,
                this.getSource(), this.status);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Topic<TYPE> getSource() {
        return (Topic<TYPE>)this.source;
    }

}
