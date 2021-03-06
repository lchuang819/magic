/*
 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */

package com.magic.util;

import org.apache.log4j.Level;
import org.apache.log4j.net.SyslogAppender;

/**
 * NotifyLevel
 */
public class NotifyLevel extends Level {

    public static final int NOTIFY_INT = FATAL_INT + 10000;
    public static final Level NOTIFY = new NotifyLevel(NOTIFY_INT, "NOTIFY", SyslogAppender.LOG_LOCAL0);
    public static final Level notify = new NotifyLevel(NOTIFY_INT, "notify", SyslogAppender.LOG_LOCAL0);

    public NotifyLevel(int level, String levelStr, int syslogEquivalent) {
        super(level, levelStr, syslogEquivalent);
    }
}
