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
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;

/**
 * @author Dmitry Kotlyarov
 * @since 1.0
 */
public class CustomStorage extends Storage {
    protected final AmazonS3 s3;

    public CustomStorage(URL url, String[] ids) {
        this(url.getHost(), url.getPath(), createS3(ids));
    }

    public CustomStorage(String bucket, String prefix, AmazonS3 s3) {
        super(bucket, prefix);

        this.s3 = s3;
    }

    public AmazonS3 getS3() {
        return s3;
    }

    @Override
    public Storage getSubstorage(String prefix) {
        return null;
    }

    @Override
    public Iterable<String> find(String prefix, String filter) {
        return null;
    }

    @Override
    public Iterable<String> list(String prefix, String filter) {
        return null;
    }

    @Override
    public byte[] get(String key, Map<String, String> meta) {
        return new byte[0];
    }

    @Override
    public InputStream getStream(String key, Map<String, String> meta) {
        return null;
    }

    @Override
    public long put(String key, byte[] data, Map<String, String> meta) {
        return 0;
    }

    @Override
    public long upload(String key, InputStream input, long size, Map<String, String> meta) {
        return 0;
    }

    @Override
    public void delete(String key) {

    }

    @Override
    public String getUrl(String key) {
        return null;
    }

    @Override
    public String getHttpsUrl(String key) {
        return null;
    }

    protected static AmazonS3 createS3(String[] ids) {
        AmazonS3 s3;
        if ((ids.length >= 1) && !ids[1].trim().isEmpty()) {
            String[] creds = ids[1].split(":");
            s3 = new AmazonS3Client(new BasicAWSCredentials(creds[0], creds[1]));
        } else {
            s3 = new AmazonS3Client();
        }
        if ((ids.length >= 2) && !ids[2].trim().isEmpty()) {
            s3.setRegion(Region.getRegion(Regions.fromName(ids[2])));
        }
        if ((ids.length >= 3) && !ids[3].trim().isEmpty()) {
            s3.setEndpoint(ids[3]);
        }
        return s3;
    }
}
