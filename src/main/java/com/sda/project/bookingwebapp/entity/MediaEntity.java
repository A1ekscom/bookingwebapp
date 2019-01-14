package com.sda.project.bookingwebapp.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "media")
@EntityListeners(AuditingEntityListener.class)
public class MediaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mediaId;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column
    private String mediaUrl;

    @ManyToOne(targetEntity = PropertyEntity.class)
    @JoinColumn(name = "propertyId", referencedColumnName = "propertyId")
    private PropertyEntity property;
}
