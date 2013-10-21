/*******************************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *******************************************************************************/
package com.magic.util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;
import java.util.List;
import java.util.Set;

import javolution.util.FastList;
import javolution.util.FastSet;

import org.apache.commons.io.FileUtils;

/**
 * File Utilities
 *
 */
public class FileUtil {

    public static final String module = FileUtil.class.getName();

    public static File getFile(String path) {
        return getFile(null, path);
    }

    public static File getFile(File root, String path) {
        String fileNameSeparator = ("\\".equals(File.separator)? "\\" + File.separator: File.separator);
        return new File(root, path.replaceAll("/+|\\\\+", fileNameSeparator));
    }

    public static void writeString(String fileName, String s) throws IOException {
        writeString(null, fileName, s);
    }

    public static void writeString(String path, String name, String s) throws IOException {
        Writer out = getBufferedWriter(path, name);

        try {
            out.write(s + System.getProperty("line.separator"));
        } catch (IOException e) {
            Debug.logError(e, module);
            throw e;
        } finally {
            if (out != null) {
                try {
                    out.close();
                } catch (IOException e) {
                    Debug.logError(e, module);
                }
            }
        }
    }

    /**
     * Writes a file from a string with a specified encoding.
     *
     * @param path
     * @param name
     * @param encoding
     * @param s
     * @throws IOException
     */
    public static void writeString(String path, String name, String encoding, String s) throws IOException {
        String fileName = getPatchedFileName(path, name);
        if (UtilValidate.isEmpty(fileName)) {
            throw new IOException("Cannot obtain buffered writer for an empty filename!");
        }

        try {
            FileUtils.writeStringToFile(new File(fileName), s, encoding);
        } catch (IOException e) {
            Debug.logError(e, module);
            throw e;
        }
    }

    public static void writeString(String encoding, String s, File outFile) throws IOException {
        try {
            FileUtils.writeStringToFile(outFile, s, encoding);
        } catch (IOException e) {
            Debug.logError(e, module);
            throw e;
        }
    }

    public static Writer getBufferedWriter(String path, String name) throws IOException {
        String fileName = getPatchedFileName(path, name);
        if (UtilValidate.isEmpty(fileName)) {
            throw new IOException("Cannot obtain buffered writer for an empty filename!");
        }

        return new BufferedWriter(new FileWriter(fileName));
    }

    public static OutputStream getBufferedOutputStream(String path, String name) throws IOException {
        String fileName = getPatchedFileName(path, name);
        if (UtilValidate.isEmpty(fileName)) {
            throw new IOException("Cannot obtain buffered writer for an empty filename!");
        }

        return new BufferedOutputStream(new FileOutputStream(fileName));
    }

    public static String getPatchedFileName(String path, String fileName) throws IOException {
        // make sure the export directory exists
        if (UtilValidate.isNotEmpty(path)) {
            path = path.replaceAll("\\\\", "/");
            File parentDir = new File(path);
            if (!parentDir.exists()) {
                if (!parentDir.mkdir()) {
                    throw new IOException("Cannot create directory for path: " + path);
                }
            }

            // build the filename with the path
            if (!path.endsWith("/")) {
                path = path + "/";
            }
            if (fileName.startsWith("/")) {
                fileName = fileName.substring(1);
            }
            fileName = path + fileName;
        }

        return fileName;
    }

    public static StringBuffer readTextFile(File file, boolean newline) throws FileNotFoundException, IOException {
        if (!file.exists()) {
            throw new FileNotFoundException();
        }

        StringBuffer buf = new StringBuffer();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(file));

            String str;
            while ((str = in.readLine()) != null) {
                buf.append(str);
                if (newline) {
                    buf.append(System.getProperty("line.separator"));
                }
            }
        } catch (IOException e) {
            Debug.logError(e, module);
            throw e;
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    Debug.logError(e, module);
                }
            }
        }

        return buf;
    }
    public static StringBuffer readTextFile(String fileName, boolean newline) throws FileNotFoundException, IOException {
        File file = new File(fileName);
        return readTextFile(file, newline);
    }

    public static String readString(String encoding, File inFile) throws IOException {
        String readString = "";
        try {
            readString = FileUtils.readFileToString(inFile, encoding);
        } catch (IOException e) {
            Debug.logError(e, module);
            throw e;
        }
        return readString;
    }

    public static void searchFiles(List<File> fileList, File path, FilenameFilter filter, boolean includeSubfolders) throws IOException {
        // Get filtered files in the current path
        File[] files = path.listFiles(filter);

        // Process each filtered entry
        for (int i = 0; i < files.length; i++) {
            // recurse if the entry is a directory
            if (files[i].isDirectory() && includeSubfolders && !files[i].getName().startsWith(".")) {
                searchFiles(fileList, files[i], filter, true);
            } else {
                // add the filtered file to the list
                fileList.add(files[i]);
            }
        }
    }

}
