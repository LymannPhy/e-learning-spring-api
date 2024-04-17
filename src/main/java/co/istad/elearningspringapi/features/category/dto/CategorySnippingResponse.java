package co.istad.elearningspringapi.features.category.dto;

public record CategorySnippingResponse (
        Long id,
        String alias,
        String icon,
        Boolean isDeleted,
        String name
){
}
