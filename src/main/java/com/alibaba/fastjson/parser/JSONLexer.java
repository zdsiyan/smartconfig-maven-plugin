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

package com.alibaba.fastjson.parser;

import java.math.BigDecimal;
import java.util.Collection;

public interface JSONLexer {

    public final static byte EOI            = 0x1A;
    public final static int  NOT_MATCH      = -1;
    public final static int  NOT_MATCH_NAME = -2;
    public final static int  UNKOWN         = 0;
    public final static int  OBJECT         = 1;
    public final static int  ARRAY          = 2;
    public final static int  VALUE          = 3;
    public final static int  END            = 4;

    int token();

    String tokenName();

    void skipWhitespace();

    void nextToken();

    void nextToken(int expect);

    char getCurrent();

    char next();

    String scanSymbol(final SymbolTable symbolTable);

    String scanSymbol(final SymbolTable symbolTable, final char quote);

    void resetStringPosition();

    void scanNumber();

    int pos();

    Number integerValue();

    BigDecimal decimalValue();

    Number decimalValue(boolean decimal);

    String scanSymbolUnQuoted(final SymbolTable symbolTable);

    String stringVal();

    boolean isEnabled(Feature feature);

    void config(Feature feature, boolean state);

    void scanString();

    int intValue();

    void nextTokenWithColon();

    void nextTokenWithColon(int expect);

    boolean isBlankInput();

    int getBufferPosition();

    void close();

    long longValue();

    boolean isRef();

    String numberString();

    byte[] bytesValue();

    float floatValue();

    long scanLong(char expectNextChar);

    int scanInt(char expectNext);

    String scanString(char expectNextChar);

    Enum<?> scanEnum(Class<?> enumClass, final SymbolTable symbolTable, char serperator);

    String scanSymbolWithSeperator(final SymbolTable symbolTable, char serperator);

    Collection<String> scanStringArray(Class<?> type, char seperator);

}
