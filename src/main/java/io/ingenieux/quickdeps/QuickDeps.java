package io.ingenieux.quickdeps;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;

import org.apache.commons.codec.digest.DigestUtils;
import org.json.JSONObject;
import org.zeroturnaround.zip.ZipUtil;

import java.io.File;
import java.io.FileInputStream;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Properties;
import java.util.Set;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class QuickDeps {
    private final File file;

    public QuickDeps(File f) {
        this.file = f;
    }

    public Collection<Artifact> guess() throws Exception {
        Set<Artifact> result = new LinkedHashSet<>();

        ZipUtil.iterate(file, (in, zipEntry) -> {
            if (zipEntry.getName().startsWith("META-INF/maven/") && zipEntry.getName().endsWith("pom.properties")) {
                try {
                    Properties p = new Properties();

                    p.load(in);

                    final Artifact artifact = new Artifact(
                            p.getProperty("groupId"),
                            p.getProperty("artifactId"),
                            p.getProperty("version"),
                            defaultString(p.getProperty("type"), "jar"),
                            defaultString(p.getProperty("classifier"), "")
                    );

                    result.add(artifact);
                } catch (Exception exc) {
                    exc.printStackTrace(System.err);
                }
            }
        });

        result.addAll(guessBySignature());

        return result;
    }

    private Set<Artifact> guessBySignature() throws Exception {
        Set<Artifact> result = new LinkedHashSet<>();

        String signature = DigestUtils.sha1Hex(new FileInputStream(file));

        HttpResponse<JsonNode> response = Unirest.get("https://search.maven.org/solrsearch/select").
                queryString("q", String.format("1:\"%s\"", signature)).
                queryString("rows", 1).
                queryString("wt", "json").
                asJson();

        final JSONObject docObject = response.getBody().getObject().optJSONObject("response").optJSONArray("docs").optJSONObject(0);

        if (null != docObject) {
            Artifact a = new Artifact(
                    docObject.optString("g"),
                    docObject.optString("a"),
                    docObject.optString("v"),
                    docObject.optString("p"),
                    docObject.optString("c")
            );

            result.add(a);
        }

        return result;
    }
}
