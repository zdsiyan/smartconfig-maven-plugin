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

package com.github.zdsiyan.maven.plugin.smartconfig;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.github.zdsiyan.maven.plugin.smartconfig.model.ConfigFile;

/**
 * 标准文件处理.
 *
 * @author Kevin Zou <kevinz@skfiy.org>
 */
public class BasicProcessor extends Processor {

  public BasicProcessor(String encoding) {
    super(encoding);
  }

  @Override
  public void process(ConfigFile configFile) {
    Configurator configurator = getConfigurator(configFile.getMode());

    try (InputStream in = new FileInputStream(configFile.getFile())) {
      ByteArrayOutputStream out = configurator.execute(in, charset, configFile.getPointHandles());
      writeToFile(configFile.getFile(), out);
    } catch (IOException e) {
      throw new SmartconfigException(configFile.toString(), e);
    }
  }

  private void writeToFile(File file, ByteArrayOutputStream out) throws IOException {
    try (OutputStream fileOut = new FileOutputStream(file)) {
      out.writeTo(fileOut);
      fileOut.flush();
    }
  }

  @Override
  public boolean isSupported(File file) {
    return true;
  }

}
