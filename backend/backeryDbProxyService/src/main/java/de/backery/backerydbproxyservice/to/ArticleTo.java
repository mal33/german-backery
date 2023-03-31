package de.backery.backerydbproxyservice.to;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArticleTo {

    private String articleId;
    private String name;
    private String description;
}
