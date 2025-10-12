package com.farukgenc.boilerplate.springboot.model.user;

import com.farukgenc.boilerplate.springboot.model.BaseEntity;
import com.farukgenc.boilerplate.springboot.model.stay.Picture;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS_PICTURES")
public class UserPicture extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id_picture")
    private Picture picture;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private User user;

}
