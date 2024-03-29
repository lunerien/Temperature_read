package edu.projektinzynierski.backend.models;

import edu.projektinzynierski.backend.models.accessControll.PermissionLevel;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserLocationGroup {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;

  @Column(insertable = false, updatable = false, columnDefinition = "serial")
  @GeneratedValue()
  private UUID uuid;

  @ManyToOne(optional = false)
  private User user;

  @ManyToOne(optional = false)
  private LocationGroup locationGroup;

  @Enumerated
  @Column(nullable = false)
  private PermissionLevel permissionLevel;

  @CreationTimestamp private LocalDateTime createdAt;

  @UpdateTimestamp private LocalDateTime updatedAt;
}
