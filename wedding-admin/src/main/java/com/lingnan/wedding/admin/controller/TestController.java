package com.lingnan.wedding.admin.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.concurrent.*;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-11 11:08
 **/


public class TestController {
    private static final Integer BUFSIZE = 1000;

    public static void mergeFiles(String outFile, String[] files, Integer bufSize) {
        if (bufSize == null) {
            bufSize = BUFSIZE;
        }
        FileChannel outChannel = null;
        try {
            outChannel = new FileOutputStream(outFile, true).getChannel();
            for (String f : files) {
                FileChannel fc = new FileInputStream(f).getChannel();
                ByteBuffer bb = ByteBuffer.allocate(bufSize);
                while (fc.read(bb) != -1) {
                    bb.flip();
                    outChannel.write(bb);
                    bb.clear();
                }
                fc.close();
            }
            System.out.println("Merged!! ");
            outChannel.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
