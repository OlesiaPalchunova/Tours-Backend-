package com.bd.tours.dto;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.bd.tours.entity.Comment}
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CommentDto implements Serializable {
    Long id;
    Date dateTimeField;
    String content;
    Long tourId;
    Long touristId;
}