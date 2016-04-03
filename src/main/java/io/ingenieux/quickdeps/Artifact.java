package io.ingenieux.quickdeps;

import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import static org.apache.commons.lang3.StringUtils.defaultString;

public class Artifact implements Comparable<Artifact> {
    String groupId;

    String artifactId;

    String version;

    String classifier;

    String type;

    public Artifact(String groupId, String artifactId, String version, String type, String classifier) {
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
        this.type = defaultString(type);
        this.classifier = defaultString(classifier);
    }

    public String getGroupId() {
        return groupId;
    }

    public String getArtifactId() {
        return artifactId;
    }

    public String getVersion() {
        return version;
    }

    public String getClassifier() {
        return classifier;
    }

    public String getType() {
        return type;
    }


    @Override
    public int compareTo(Artifact o) {
        if (null == o)
            return -1;

        if (this == o)
            return 0;

        return new CompareToBuilder().
                append(this.groupId, o.groupId).
                append(this.artifactId, o.artifactId).
                append(this.version, o.version).
                append(this.classifier, o.classifier).
                append(this.type, o.type).
                toComparison();
    }


    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (obj.getClass() != getClass()) {
            return false;
        }
        Artifact rhs = (Artifact) obj;
        return new EqualsBuilder()
                .append(this.groupId, rhs.groupId)
                .append(this.artifactId, rhs.artifactId)
                .append(this.version, rhs.version)
                .append(this.classifier, rhs.classifier)
                .append(this.type, rhs.type)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder()
                .append(groupId)
                .append(artifactId)
                .append(version)
                .append(classifier)
                .append(type)
                .toHashCode();
    }
}
