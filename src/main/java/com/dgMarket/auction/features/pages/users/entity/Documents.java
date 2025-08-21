package com.dgMarket.auction.features.pages.users.entity;

import com.dgMarket.auction.features.pages.users.enums.DocumentType;
import com.dgMarket.auction.shared.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
@Entity
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "documents")
public class Documents extends BaseEntity {

    @Column(name = "deleted")
    private Boolean isDeleted;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "document_type")
    private DocumentType documentType;

    @NotNull(message = "For documents to be validate file path required")
    @Column(name = "file_path", nullable = false)
    private String filePath;

    @Column(name = "original_name", nullable = false)
    private String originalName;

    @Lob //tinyblob data stored.
    @Column(name = "security_key", columnDefinition = "TINYBLOB")
    private byte[] securityKey;

    @Column(name = "unique_id", unique = true)
    private String uniqueId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "file_type_id", referencedColumnName = "id")
    private FileType fileType;


}
