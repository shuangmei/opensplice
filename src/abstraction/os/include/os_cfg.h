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
#ifndef OS_CFG_H
#define OS_CFG_H

typedef struct os_cfg_handle
{
   char *ptr;
   int isStatic;
   size_t size;
} os_cfg_handle;

typedef FILE os_cfg_file; 

os_cfg_file *os_fileOpenURI(const char *uri);
os_cfg_handle *os_fileReadURI(const char *uri);

os_cfg_handle *os_cfgRead(const char *uri);

void os_cfgRelease(os_cfg_handle *cfg);

#endif
