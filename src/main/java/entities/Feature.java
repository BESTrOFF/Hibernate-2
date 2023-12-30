package entities;

import org.apache.commons.lang3.StringUtils;

public enum Feature {
    TRAILERS("Trailers"),
    COMMENTARIES("Commentaries"),
    DELETED_SCENES("Deleted Scenes"),
    BEHIND_THE_SCENES("Behind the Scenes");

    private final String value;

    Feature(String VALUE) {
        this.value = VALUE;
    }

    public String getValue() {
        return value;
    }

    public Feature getValueByValue(String value) {
        if (StringUtils.isEmpty(value)) {
            return null;
        }

        Feature[] features = Feature.values();
        for(Feature feature : features){
            if (feature.getValue().equals(value)){
                return feature;
            }
        }

        return null;
    }
}
