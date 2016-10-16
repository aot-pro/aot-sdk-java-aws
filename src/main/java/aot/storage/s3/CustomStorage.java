/*
 * Copyright (C) 2016 Dmitry Kotlyarov.
 * All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package aot.storage.s3;

import aot.storage.Storage;
import com.amazonaws.services.s3.AmazonS3;

import java.util.regex.Pattern;

/**
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public class CustomStorage extends Storage {
    protected final AmazonS3 s3;

    public CustomStorage(String bucket, String prefix, AmazonS3 s3) {
        super(bucket, prefix);

        this.s3 = s3;
    }

    public AmazonS3 getS3() {
        return s3;
    }

    @Override
    public Storage substorage(String prefix) {
        return null;
    }

    @Override
    public Iterable<String> find(String prefix) {
        return null;
    }

    @Override
    public Iterable<String> find(String prefix, String filter) {
        return null;
    }

    @Override
    public Iterable<String> find(String prefix, Pattern filter) {
        return null;
    }

    @Override
    public byte[] get(String key) {
        return new byte[0];
    }

    @Override
    public void put(String key, byte[] data) {

    }

    @Override
    public void delete(String key) {

    }

    @Override
    public String publish(String key) {
        return null;
    }

    @Override
    public void hide(String key) {

    }

    @Override
    public String url(String key) {
        return null;
    }
}
