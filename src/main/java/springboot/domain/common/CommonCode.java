package springboot.domain.common;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class CommonCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private enum code_cd{
        p_fe, p_be
    }

    private enum code_name{
        백엔드, 프론트엔드
    }

    private enum code_group {
        pre, main
    }
}
