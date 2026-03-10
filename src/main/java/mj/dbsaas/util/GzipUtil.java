package mj.dbsaas.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;

public class GzipUtil {

    public static byte[] decompress(byte[] gz) throws Exception {

        ByteArrayInputStream bais = new ByteArrayInputStream(gz);
        GZIPInputStream gis = new GZIPInputStream(bais);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        byte[] buf = new byte[4096];
        int n;

        while((n = gis.read(buf)) > 0){
            baos.write(buf,0,n);
        }

        return baos.toByteArray();
    }
}