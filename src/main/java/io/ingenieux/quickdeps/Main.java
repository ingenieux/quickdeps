package io.ingenieux.quickdeps;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.apache.commons.lang3.StringUtils.defaultString;
import static org.apache.commons.lang3.StringUtils.isNotBlank;

public class Main {
    public static int main(String[] args) throws Exception {
        // TODO: Use Docopt
        if (0 == args.length) {
            System.err.println("Usage: quickdeps <path to jar files>");

            return 2;
        }

        try {
            final List<File> fileList = Arrays.stream(args).map(File::new).collect(Collectors.toList());

            Set<Artifact> artifactSet = fileList.stream().flatMap(Main::fileToArtifacts).collect(Collectors.toSet());

            artifactSet.stream().map(Main::toXml).forEach(System.out::println);

            return 0;
        } catch (Exception exc) {
            exc.printStackTrace(System.err);

            return 1;
        }
    }

    private static String toXml(Artifact artifact) {
        StringBuilder result = new StringBuilder();

        final Element d = new Element("dependency");
        Document doc = new Document(d);

        d.addContent(new Element("groupId").setText(artifact.getGroupId()));
        d.addContent(new Element("artifactId").setText(artifact.getArtifactId()));
        d.addContent(new Element("version").setText(artifact.getVersion()));

        if (! "jar".equals(defaultString(artifact.getType(), "jar"))) {
            d.addContent(new Element("type").setText(artifact.getType()));
        }

        if (isNotBlank(artifact.getClassifier())) {
            d.addContent(new Element("classifier").setText(artifact.getClassifier()));
        }

        final XMLOutputter xmlOutputter = new XMLOutputter(Format.getCompactFormat().setOmitDeclaration(true).setOmitEncoding(true));

        result.append(xmlOutputter.outputString(doc));

        return result.toString().trim();
    }



    private static Stream<Artifact> fileToArtifacts(File file) {
        Set<Artifact> result = new LinkedHashSet<>();

        try {
            result.addAll(new QuickDeps(file).guess());
        } catch (Exception exc) {
        }

        return result.stream();
    }
}
