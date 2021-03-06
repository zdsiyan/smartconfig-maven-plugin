/*-
 * ========================LICENSE_START=================================
 * Smartconfig Maven Plugin
 * *
 * Copyright (C) 2016 BruceZhang
 * *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * =========================LICENSE_END==================================
 */

package com.alibaba.fastjson.asm;

/**
 * A visitor to visit a Java field. The methods of this interface must be called in the following order: (
 * <tt>visitAnnotation</tt> | <tt>visitAttribute</tt> )* <tt>visitEnd</tt>.
 * 
 * @author Eric Bruneton
 */
public interface FieldVisitor {

    /**
     * Visits the end of the field. This method, which is the last one to be called, is used to inform the visitor that
     * all the annotations and attributes of the field have been visited.
     */
    void visitEnd();
}
