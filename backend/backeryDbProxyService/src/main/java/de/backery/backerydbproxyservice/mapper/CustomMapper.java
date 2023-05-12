package de.backery.backerydbproxyservice.mapper;

import de.backery.backerydbproxyservice.dataaccess.entity.*;
import de.backery.backerydbproxyservice.to.ArticleTo;
import de.backery.backerydbproxyservice.to.OrderTo;
import de.backery.backerydbproxyservice.to.UserTo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;


import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CustomMapper {

    @Mapping(source = "articleId", target = "articleId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    ArticleTo articleEntityToArticleTo(ArticleEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "articleId", target = "articleId")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    ArticleEntity articleToToArticleEntity(ArticleTo to);

    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "description", target = "description")
    OrderTo orderEntityToOrderTo(OrderEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "orderId", target = "orderId")
    @Mapping(source = "description", target = "description")
    OrderEntity orderToToOrderEntity(OrderTo to);

    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "username", target = "username")
    UserTo userEntityToUserTo(UserEntity entity);

    @InheritInverseConfiguration
    @Mapping(source = "userId", target = "userId")
    @Mapping(source = "username", target = "username")
    UserEntity userToToUserEntity(UserTo to);

    @InheritInverseConfiguration
    List<ArticleTo> articleEntityListToArticleToList(List<ArticleEntity> articleEntityList);

    @InheritInverseConfiguration
    List<OrderTo> orderEntityListToOrderToList(List<OrderEntity> orderEntityList);

    @InheritInverseConfiguration
    List<UserTo> userEntityListToUserToList(List<UserEntity> userEntityList);
}
